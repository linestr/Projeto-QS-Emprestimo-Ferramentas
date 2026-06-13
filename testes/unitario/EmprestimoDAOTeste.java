package unit;

import dao.EmprestimoDAO;
import modelo.Emprestimo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class EmprestimoDAOTest {

    private EmprestimoDAO dao;

    @BeforeEach
    void setUp() {
        dao = new EmprestimoDAO();
    }

    @Test
    void testListaEmprestimosNaoNula() {
        assertNotNull(EmprestimoDAO.ListaEmprestimos);
    }

    @Test
    void testListaEmprestimosAtivosNaoNula() {
        assertNotNull(dao.ListaEmprestimosAtivos);
    }

    @Test
    void testAdicionarEmprestimoNaLista() {
        EmprestimoDAO.ListaEmprestimos.clear();
        EmprestimoDAO.ListaEmprestimos.add(new Emprestimo(
            Date.valueOf("2025-01-01"),
            Date.valueOf("2025-01-15"),
            false, 1, 1
        ));
        assertEquals(1, EmprestimoDAO.ListaEmprestimos.size());
    }

    @Test
    void testAdicionarMultiplosEmprestimos() {
        EmprestimoDAO.ListaEmprestimos.clear();
        EmprestimoDAO.ListaEmprestimos.add(new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1, 1));
        EmprestimoDAO.ListaEmprestimos.add(new Emprestimo(Date.valueOf("2025-02-01"), Date.valueOf("2025-02-15"), false, 2, 2));
        assertEquals(2, EmprestimoDAO.ListaEmprestimos.size());
    }

    @Test
    void testEmprestimoCorretoNaLista() {
        EmprestimoDAO.ListaEmprestimos.clear();
        EmprestimoDAO.ListaEmprestimos.add(new Emprestimo(
            Date.valueOf("2025-01-01"),
            Date.valueOf("2025-01-15"),
            false, 5, 3
        ));
        assertEquals(5, EmprestimoDAO.ListaEmprestimos.get(0).getId());
    }

    @Test
    void testListaEmprestimosEhArrayList() {
        assertInstanceOf(ArrayList.class, EmprestimoDAO.ListaEmprestimos);
    }

    @Test
    void testListaAtivosEhArrayList() {
        assertInstanceOf(ArrayList.class, dao.ListaEmprestimosAtivos);
    }

    @Test
    void testRemoverEmprestimoDaLista() {
        EmprestimoDAO.ListaEmprestimos.clear();
        Emprestimo e = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-15"), false, 1, 1);
        EmprestimoDAO.ListaEmprestimos.add(e);
        EmprestimoDAO.ListaEmprestimos.remove(e);
        assertTrue(EmprestimoDAO.ListaEmprestimos.isEmpty());
    }

    @Test
    void testListaInicialmenteVazia() {
        EmprestimoDAO.ListaEmprestimos.clear();
        assertTrue(EmprestimoDAO.ListaEmprestimos.isEmpty());
    }
}
