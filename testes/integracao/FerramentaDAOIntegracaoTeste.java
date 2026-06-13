package integracao;

import dao.ConexaoDAO;
import dao.FerramentaDAO;
import modelo.Ferramenta;
import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class FerramentaDAOIntegracaoTest {

    private static Connection connection;
    private FerramentaDAO dao;

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

        Field field = ConexaoDAO.class.getDeclaredField("connection");
        field.setAccessible(true);
        field.set(null, connection);
    }

    @BeforeEach
    void setUp() throws Exception {
        dao = new FerramentaDAO();
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM tb_ferramentas");
        stmt.execute("ALTER TABLE tb_ferramentas ALTER COLUMN id_ferramenta RESTART WITH 1");
        stmt.close();
    }

    @Test
    void testInserirFerramenta() throws Exception {
        Ferramenta f = new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0);
        assertTrue(dao.inserirFerramentaBD(f));
    }

    @Test
    void testGetMinhaListaRetornaFerramentas() throws Exception {
        Ferramenta f = new Ferramenta("Martelo", "Stanley", 50.0, 1, 0);
        dao.inserirFerramentaBD(f);
        ArrayList<Ferramenta> lista = dao.getMinhaLista();
        assertFalse(lista.isEmpty());
    }

    @Test
    void testGetMinhaListaNomeCorreto() throws Exception {
        Ferramenta f = new Ferramenta("Serra", "Makita", 400.0, 1, 0);
        dao.inserirFerramentaBD(f);
        ArrayList<Ferramenta> lista = dao.getMinhaLista();
        assertEquals("Serra", lista.get(0).getNome());
    }

    @Test
    void testMaiorId() throws Exception {
        Ferramenta f = new Ferramenta("Lixadeira", "DeWalt", 300.0, 1, 0);
        dao.inserirFerramentaBD(f);
        assertEquals(1, dao.maiorId());
    }

    @Test
    void testApagarFerramenta() throws Exception {
        Ferramenta f = new Ferramenta("Chave", "Tramontina", 30.0, 1, 0);
        dao.inserirFerramentaBD(f);
        assertTrue(dao.apagarFerramentaBD(1));
        assertTrue(dao.getMinhaLista().isEmpty());
    }

    @Test
    void testAlterarFerramenta() throws Exception {
        Ferramenta f = new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0);
        dao.inserirFerramentaBD(f);
        Ferramenta alterada = new Ferramenta("Furadeira Pro", "Bosch", 400.0, 1, 0);
        assertTrue(dao.alterarFerramentaBD(alterada));
        assertEquals("Furadeira Pro", dao.getMinhaLista().get(0).getNome());
    }

    @Test
    void testCarregarFerramenta() throws Exception {
        Ferramenta f = new Ferramenta("Nivel", "Vonder", 90.0, 1, 0);
        dao.inserirFerramentaBD(f);
        Ferramenta carregada = dao.carregarFerramenta(1);
        assertEquals("Nivel", carregada.getNome());
    }

    @Test
    void testFerramentasDisponiveis() throws Exception {
        Ferramenta f = new Ferramenta("Parafusadeira", "DeWalt", 450.0, 1, 0);
        dao.inserirFerramentaBD(f);
        ArrayList<Ferramenta> disponiveis = dao.getFerramentasDisponiveis();
        assertFalse(disponiveis.isEmpty());
    }

    @AfterAll
    static void tearDown() throws Exception {
        if (connection != null) connection.close();
    }
}
