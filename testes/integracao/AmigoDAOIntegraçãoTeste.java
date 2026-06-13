package integracao;

import dao.AmigoDAO;
import dao.ConexaoDAO;
import modelo.Amigo;
import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class AmigoDAOIntegracaoTest {

    private static Connection connection;
    private AmigoDAO dao;

    @BeforeAll
    static void setUpBanco() throws Exception {
        connection = DriverManager.getConnection(
            "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", ""
        );
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS tb_amigos (" +
            "id_amigo INT NOT NULL AUTO_INCREMENT, " +
            "nome VARCHAR(45) NOT NULL, " +
            "telefone VARCHAR(45) NOT NULL, " +
            "PRIMARY KEY (id_amigo))");
        stmt.execute("CREATE TABLE IF NOT EXISTS tb_emprestimos (" +
            "id_emprestimo INT NOT NULL AUTO_INCREMENT, " +
            "data_emprestimo DATE NOT NULL, " +
            "data_devolucao DATE NOT NULL, " +
            "entregue BOOLEAN NOT NULL, " +
            "id_amigo INT NOT NULL, " +
            "PRIMARY KEY (id_emprestimo))");
        stmt.execute("CREATE TABLE IF NOT EXISTS tb_ferramentas (" +
            "id_ferramenta INT NOT NULL AUTO_INCREMENT, " +
            "nome VARCHAR(45) NOT NULL, " +
            "marca VARCHAR(45) NOT NULL, " +
            "custo_aquisicao DOUBLE NOT NULL, " +
            "id_emprestimo INT, " +
            "PRIMARY KEY (id_ferramenta))");
        stmt.close();

        // Injeta a conexão H2 no ConexaoDAO via reflection
        Field field = ConexaoDAO.class.getDeclaredField("connection");
        field.setAccessible(true);
        field.set(null, connection);
    }

    @BeforeEach
    void setUp() throws Exception {
        dao = new AmigoDAO();
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM tb_amigos");
        stmt.execute("ALTER TABLE tb_amigos ALTER COLUMN id_amigo RESTART WITH 1");
        stmt.close();
    }

    @Test
    void testInserirAmigo() throws Exception {
        Amigo amigo = new Amigo(1, "Carlos", "47991234567");
        assertTrue(dao.inserirAmigoBD(amigo));
    }

    @Test
    void testGetMinhaListaRetornaAmigos() throws Exception {
        Amigo amigo = new Amigo(1, "Ana", "47988887777");
        dao.inserirAmigoBD(amigo);
        ArrayList<Amigo> lista = dao.getMinhaLista();
        assertFalse(lista.isEmpty());
    }

    @Test
    void testGetMinhaListaNomeCorreto() throws Exception {
        Amigo amigo = new Amigo(1, "Maria", "47977776666");
        dao.inserirAmigoBD(amigo);
        ArrayList<Amigo> lista = dao.getMinhaLista();
        assertEquals("Maria", lista.get(0).getNome());
    }

    @Test
    void testMaiorIdRetornaUm() throws Exception {
        Amigo amigo = new Amigo(1, "João", "47966665555");
        dao.inserirAmigoBD(amigo);
        assertEquals(1, dao.maiorId());
    }

    @Test
    void testApagarAmigo() throws Exception {
        Amigo amigo = new Amigo(1, "Pedro", "47955554444");
        dao.inserirAmigoBD(amigo);
        assertTrue(dao.apagarAmigoBD(1));
        assertTrue(dao.getMinhaLista().isEmpty());
    }

    @Test
    void testAlterarAmigo() throws Exception {
        Amigo amigo = new Amigo(1, "Lucas", "47944443333");
        dao.inserirAmigoBD(amigo);
        Amigo alterado = new Amigo(1, "Lucas Silva", "47944443333");
        assertTrue(dao.alterarAmigoBD(alterado));
        assertEquals("Lucas Silva", dao.getMinhaLista().get(0).getNome());
    }

    @Test
    void testCarregarAmigo() throws Exception {
        Amigo amigo = new Amigo(1, "Felipe", "47933332222");
        dao.inserirAmigoBD(amigo);
        Amigo carregado = dao.carregarAmigoBD(1);
        assertEquals("Felipe", carregado.getNome());
    }

    @Test
    void testVerificarPendenciaSemPendencia() throws Exception {
        Amigo amigo = new Amigo(1, "Teste", "47922221111");
        dao.inserirAmigoBD(amigo);
        assertFalse(dao.verificarPendencia(1));
    }

    @AfterAll
    static void tearDown() throws Exception {
        if (connection != null) connection.close();
    }
}
