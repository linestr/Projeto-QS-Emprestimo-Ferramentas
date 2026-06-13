package unit;

import modelo.Emprestimo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

class EmprestimoModeloTest {

    private Emprestimo emprestimo;
    private Date dataEmp;
    private Date dataDev;

    @BeforeEach
    void setUp() {
        dataEmp = Date.valueOf("2025-01-01");
        dataDev = Date.valueOf("2025-01-15");
        emprestimo = new Emprestimo(dataEmp, dataDev, false, 1, 2);
    }

    @Test
    void testGetDataEmprestimo() { assertEquals(dataEmp, emprestimo.getDataEmprestimo()); }

    @Test
    void testGetDataDevolucao() { assertEquals(dataDev, emprestimo.getDataDevolucao()); }

    @Test
    void testGetEntregue() { assertFalse(emprestimo.isEntregue()); }

    @Test
    void testGetId() { assertEquals(1, emprestimo.getId()); }

    @Test
    void testGetIdAmg() { assertEquals(2, emprestimo.getIdAmg()); }

    @Test
    void testSetEntregueTrue() { emprestimo.setEntregue(true); assertTrue(emprestimo.isEntregue()); }

    @Test
    void testSetEntrigueFalse() { emprestimo.setEntregue(false); assertFalse(emprestimo.isEntregue()); }

    @Test
    void testSetDataEmprestimo() {
        Date nova = Date.valueOf("2025-03-01");
        emprestimo.setDataEmprestimo(nova);
        assertEquals(nova, emprestimo.getDataEmprestimo());
    }

    @Test
    void testSetDataDevolucao() {
        Date nova = Date.valueOf("2025-03-20");
        emprestimo.setDataDevolucao(nova);
        assertEquals(nova, emprestimo.getDataDevolucao());
    }

    @Test
    void testSetId() { emprestimo.setId(10); assertEquals(10, emprestimo.getId()); }

    @Test
    void testSetIdAmg() { emprestimo.setIdAmg(5); assertEquals(5, emprestimo.getIdAmg()); }

    @Test
    void testConstrutorPadraoDataEmp() { assertNull(new Emprestimo().getDataEmprestimo()); }

    @Test
    void testConstrutorPadraoDataDev() { assertNull(new Emprestimo().getDataDevolucao()); }

    @Test
    void testConstrutorPadraoEntregue() { assertFalse(new Emprestimo().isEntregue()); }

    @Test
    void testConstrutorPadraoId() { assertEquals(0, new Emprestimo().getId()); }

    @Test
    void testConstrutorPadraoIdAmg() { assertEquals(0, new Emprestimo().getIdAmg()); }

    @Test
    void testDataDevolucaoAposEmprestimo() { assertTrue(dataDev.after(dataEmp)); }

    @Test
    void testMudancaStatusMantémId() { emprestimo.setEntregue(true); assertEquals(1, emprestimo.getId()); }

    @Test
    void testMudancaStatusMantémIdAmg() { emprestimo.setEntregue(true); assertEquals(2, emprestimo.getIdAmg()); }
}
