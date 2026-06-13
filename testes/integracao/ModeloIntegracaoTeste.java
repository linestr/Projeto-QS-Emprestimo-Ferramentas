package integracao;

import dao.ConexaoDAO;
import modelo.Amigo;
import modelo.Ferramenta;
import modelo.Emprestimo;
import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ModeloIntegracaoTest {

    private static Connection connection;

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
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM tb_ferramentas");
        stmt.execute("DELETE FROM tb_emprestimos");
        stmt.execute("DELETE FROM tb_amigos");
        stmt.execute("ALTER TABLE tb_amigos ALTER COLUMN id_amigo RESTART WITH 1");
        stmt.execute("ALTER TABLE tb_emprestimos ALTER COLUMN id_emprestimo RESTART WITH 1");
        stmt.execute("ALTER TABLE tb_ferramentas ALTER COLUMN id_ferramenta RESTART WITH 1");
        stmt.close();
    }

    @Test
    void testAmigoInserirEObterLista() {
        Amigo a = new Amigo();
        a.inserirAmigo("Carlos", "47991234567");
        ArrayList<Amigo> lista = a.getListaAmigos();
        assertFalse(lista.isEmpty());
        assertEquals("Carlos", lista.get(0).getNome());
    }

    @Test
    void testAmigoAlterar() {
        Amigo a = new Amigo();
        a.inserirAmigo("Lucas", "47988887777");
        ArrayList<Amigo> lista = a.getListaAmigos();
        int id = lista.get(0).getId();
        a.alterarAmigo(id, "Lucas Silva", "47988887777");
        ArrayList<Amigo> listaAtualizada = a.getListaAmigos();
        assertEquals("Lucas Silva", listaAtualizada.get(0).getNome());
    }

    @Test
    void testAmigoApagar() {
        Amigo a = new Amigo();
        a.inserirAmigo("Maria", "47977776666");
        ArrayList<Amigo> lista = a.getListaAmigos();
        int id = lista.get(0).getId();
        a.apagarAmigo(id);
        assertTrue(a.getListaAmigos().isEmpty());
    }

    @Test
    void testAmigoCarregar() {
        Amigo a = new Amigo();
        a.inserirAmigo("Pedro", "47966665555");
        ArrayList<Amigo> lista = a.getListaAmigos();
        int id = lista.get(0).getId();
        Amigo carregado = a.carregarAmigo(id);
        assertEquals("Pedro", carregado.getNome());
    }

    @Test
    void testFerramentaInserirEObterLista() {
        Ferramenta f = new Ferramenta();
        f.inserirFerramenta("Furadeira", "Bosch", 350.0);
        ArrayList<Ferramenta> lista = f.getListaFerramentas();
        assertFalse(lista.isEmpty());
        assertEquals("Furadeira", lista.get(0).getNome());
    }

    @Test
    void testFerramentaAlterar() {
        Ferramenta f = new Ferramenta();
        f.inserirFerramenta("Serra", "Makita", 400.0);
        ArrayList<Ferramenta> lista = f.getListaFerramentas();
        int id = lista.get(0).getId();
        f.alterarFerramenta(id, "Serra Pro", "Makita", 450.0);
        assertEquals("Serra Pro", f.getListaFerramentas().get(0).getNome());
    }

    @Test
    void testFerramentaApagar() {
        Ferramenta f = new Ferramenta();
        f.inserirFerramenta("Martelo", "Stanley", 50.0);
        ArrayList<Ferramenta> lista = f.getListaFerramentas();
        int id = lista.get(0).getId();
        f.apagarFerramenta(id);
        assertTrue(f.getListaFerramentas().isEmpty());
    }

    @Test
    void testFerramentaCarregar() {
        Ferramenta f = new Ferramenta();
        f.inserirFerramenta("Nivel", "Vonder", 90.0);
        ArrayList<Ferramenta> lista = f.getListaFerramentas();
        int id = lista.get(0).getId();
        Ferramenta carregada = f.carregarFerramenta(id);
        assertEquals("Nivel", carregada.getNome());
    }

    @Test
    void testEmprestimoInserirEObterLista() {
        Amigo a = new Amigo();
        a.inserirAmigo("Amigo Teste", "47999999999");
        Emprestimo e = new Emprestimo();
        e.inserirEmprestimo(
            Date.valueOf("2025-01-01"),
            Date.valueOf("2025-01-15"),
            false, 1
        );
        ArrayList<Emprestimo> lista = e.getListaEmprestimos();
        assertFalse(lista.isEmpty());
    }

    @Test
    void testEmprestimoAlterar() {
        Amigo a = new Amigo();
        a.inserirAmigo("Amigo Teste", "47999999999");
        Emprestimo e = new Emprestimo();
        e.inserirEmprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1);
        ArrayList<Emprestimo> lista = e.getListaEmprestimos();
        int id = lista.get(0).getId();
        e.alterarEmprestimo(Date.valueOf("2025-02-01"), true, id);
        assertTrue(e.getListaEmprestimos().get(0).isEntregue());
    }

    @Test
    void testEmprestimoApagar() {
        Amigo a = new Amigo();
        a.inserirAmigo("Amigo Teste", "47999999999");
        Emprestimo e = new Emprestimo();
        e.inserirEmprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1);
        ArrayList<Emprestimo> lista = e.getListaEmprestimos();
        int id = lista.get(0).getId();
        e.apagarEmprestimo(id);
        assertTrue(e.getListaEmprestimos().isEmpty());
    }

    @AfterAll
    static void tearDown() throws Exception {
        if (connection != null) connection.close();
    }
}
