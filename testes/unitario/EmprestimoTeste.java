package unit;

import modelo.Emprestimo;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    // -------------------------------------------------------
    // CONSTRUTORES
    // -------------------------------------------------------

    @Test
    void testConstrutorPadrao() {
        Emprestimo e = new Emprestimo();
        assertNull(e.getDataEmprestimo());
        assertNull(e.getDataDevolucao());
        assertFalse(e.isEntregue());
        assertEquals(0, e.getId());
        assertEquals(0, e.getIdAmg());
    }

    @Test
    void testConstrutorComParametros() {
        Date dataEmp = Date.valueOf("2025-01-01");
        Date dataDev = Date.valueOf("2025-01-15");
        Emprestimo e = new Emprestimo(dataEmp, dataDev, false, 1, 2);
        assertEquals(dataEmp, e.getDataEmprestimo());
        assertEquals(dataDev, e.getDataDevolucao());
        assertFalse(e.isEntregue());
        assertEquals(1, e.getId());
        assertEquals(2, e.getIdAmg());
    }

    // -------------------------------------------------------
    // SETTERS E GETTERS
    // -------------------------------------------------------

    @Test
    void testSetEntregue() {
        Emprestimo e = new Emprestimo();
        e.setEntregue(true);
        assertTrue(e.isEntregue());
    }

    @Test
    void testSetEntregueParaFalse() {
        Emprestimo e = new Emprestimo();
        e.setEntregue(false);
        assertFalse(e.isEntregue());
    }

    @Test
    void testSetDataEmprestimo() {
        Emprestimo e = new Emprestimo();
        Date data = Date.valueOf("2025-03-10");
        e.setDataEmprestimo(data);
        assertEquals(data, e.getDataEmprestimo());
    }

    @Test
    void testSetDataDevolucao() {
        Emprestimo e = new Emprestimo();
        Date data = Date.valueOf("2025-04-10");
        e.setDataDevolucao(data);
        assertEquals(data, e.getDataDevolucao());
    }

    @Test
    void testSetId() {
        Emprestimo e = new Emprestimo();
        e.setId(10);
        assertEquals(10, e.getId());
    }

    @Test
    void testSetIdAmg() {
        Emprestimo e = new Emprestimo();
        e.setIdAmg(7);
        assertEquals(7, e.getIdAmg());
    }

    // -------------------------------------------------------
    // REGRAS DE NEGÓCIO
    // -------------------------------------------------------

    @Test
    void testDataDevolucaoAposEmprestimo() {
        Date dataEmp = Date.valueOf("2025-01-01");
        Date dataDev = Date.valueOf("2025-01-15");
        assertTrue(dataDev.after(dataEmp));
    }

    @Test
    void testDataDevolucaoNaoAntesDaDataEmprestimo() {
        Date dataEmp = Date.valueOf("2025-06-01");
        Date dataDev = Date.valueOf("2025-05-01");
        assertFalse(dataDev.after(dataEmp));
    }

    @Test
    void testEmprestimoNaoEntregueInicialmente() {
        Emprestimo e = new Emprestimo(
            Date.valueOf("2025-01-01"),
            Date.valueOf("2025-01-10"),
            false, 1, 1
        );
        assertFalse(e.isEntregue());
    }

    @Test
    void testMarcarComoEntregue() {
        Emprestimo e = new Emprestimo(
            Date.valueOf("2025-01-01"),
            Date.valueOf("2025-01-10"),
            false, 1, 1
        );
        e.setEntregue(true);
        assertTrue(e.isEntregue());
    }

    @Test
    void testEmprestimoComIdAmigoDiferente() {
        Emprestimo e1 = new Emprestimo(Date.valueOf("2025-01-01"), Date.valueOf("2025-01-10"), false, 1, 1);
        Emprestimo e2 = new Emprestimo(Date.valueOf("2025-02-01"), Date.valueOf("2025-02-10"), false, 2, 2);
        assertNotEquals(e1.getIdAmg(), e2.getIdAmg());
    }

    @Test
    void testDatasIguaisEmprestimoEDevolucao() {
        Date mesmaData = Date.valueOf("2025-06-01");
        Emprestimo e = new Emprestimo(mesmaData, mesmaData, true, 1, 1);
        assertEquals(e.getDataEmprestimo(), e.getDataDevolucao());
    }
}
