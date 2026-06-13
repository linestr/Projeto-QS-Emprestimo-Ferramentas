package integracao;

import dao.ConexaoDAO;
import dao.EmprestimoDAO;
import modelo.Emprestimo;
import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class EmprestimoDAOIntegracaoTest {

    private static Connection connection;
    private EmprestimoDAO dao;

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
        stmt.execute("DELETE FROM tb_ferramentas");
        stmt.execute("DELETE FROM tb_emprestimos");
        stmt.execute("DELETE FROM tb_amigos");
        stmt.execute("ALTER TABLE tb_amigos ALTER COLUMN id_amigo RESTART WITH 1");
        stmt.execute("INSERT INTO tb_amigos(nome, telefone) VALUES('Amigo Teste', '47999999999')");
        stmt.close();

        Field field = ConexaoDAO.class.getDeclaredField("connection");
        field.setAccessible(true);
        field.set(null, connection);
    }

    @BeforeEach
    void setUp() throws Exception {
        dao = new EmprestimoDAO();
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM tb_ferramentas");
        stmt.execute("DELETE FROM tb_emprestimos");
        stmt.execute("ALTER TABLE tb_emprestimos ALTER COLUMN id_emprestimo RESTART WITH 1");
        stmt.close();
    }

    @Test
    void testInserirEmprestimo() throws Exception {
        Emprestimo e = new Emprestimo(
            Date.valueOf("2025-01-01"),
            Date.valueOf("2025-01-15"),
            false, 1, 1
        );
        assertTrue(dao.inserirEmprestimoBD(e));
    }

    @Test
    void testGetMinhaListaRetornaEmprestimos() throws Exception {
        Emprestimo e = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1, 1);
        dao.inserirEmprestimoBD(e);
        ArrayList<Emprestimo> lista = dao.getMinhaLista();
        assertFalse(lista.isEmpty());
    }

    @Test
    void testGetMinhaListaIdCorreto() throws Exception {
        Emprestimo e = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1, 1);
        dao.inserirEmprestimoBD(e);
        ArrayList<Emprestimo> lista = dao.getMinhaLista();
        assertEquals(1, lista.get(0).getId());
    }

    @Test
    void testMaiorId() throws Exception {
        Emprestimo e = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1, 1);
        dao.inserirEmprestimoBD(e);
        assertEquals(1, dao.maiorId());
    }

    @Test
    void testApagarEmprestimo() throws Exception {
        Emprestimo e = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1, 1);
        dao.inserirEmprestimoBD(e);
        assertTrue(dao.apagarEmprestimoBD(1));
        assertTrue(dao.getMinhaLista().isEmpty());
    }

    @Test
    void testAlterarEmprestimo() throws Exception {
        Emprestimo e = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1, 1);
        dao.inserirEmprestimoBD(e);
        Emprestimo alterado = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-02-01"), true, 1, 1);
        assertTrue(dao.alterarEmprestimoBD(alterado));
        assertTrue(dao.getMinhaLista().get(0).isEntregue());
    }

    @Test
    void testCarregarEmprestimo() throws Exception {
        Emprestimo e = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1, 1);
        dao.inserirEmprestimoBD(e);
        Emprestimo carregado = dao.carregarEmprestimoBD(1);
        assertEquals(1, carregado.getId());
    }

    @Test
    void testGetEmprestimosAtivos() throws Exception {
        Emprestimo e = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1, 1);
        dao.inserirEmprestimoBD(e);
        ArrayList<Emprestimo> ativos = dao.getEmprestimosAtivos();
        assertFalse(ativos.isEmpty());
    }

    @Test
    void testVerificarPendenciaSemPendencia() throws Exception {
        assertFalse(dao.verificarPendencia(1));
    }

    @AfterAll
    static void tearDown() throws Exception {
        if (connection != null) connection.close();
    }
}
