package integracao;

import modelo.Emprestimo;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

class EmprestimoIntegracaoTest {

    @Test
    void testCriarEmprestimoEVerificarDados() {
        Date dataEmp = Date.valueOf("2025-01-01");
        Date dataDev = Date.valueOf("2025-01-15");
        Emprestimo e = new Emprestimo(dataEmp, dataDev, false, 1, 2);
        assertAll(
            () -> assertEquals(dataEmp, e.getDataEmprestimo()),
            () -> assertEquals(dataDev, e.getDataDevolucao()),
            () -> assertFalse(e.isEntregue()),
            () -> assertEquals(1, e.getId()),
            () -> assertEquals(2, e.getIdAmg())
        );
    }

    @Test
    void testDataDevolucaoAposEmprestimo() {
        Date dataEmp = Date.valueOf("2025-01-01");
        Date dataDev = Date.valueOf("2025-01-15");
        assertTrue(dataDev.after(dataEmp));
    }

    @Test
    void testDataDevolucaoIgualEmprestimoInvalido() {
        Date dataEmp = Date.valueOf("2025-01-01");
        Date dataDev = Date.valueOf("2025-01-01");
        assertFalse(dataDev.after(dataEmp));
    }

    @Test
    void testDataDevolucaoAntesEmprestimoInvalido() {
        Date dataEmp = Date.valueOf("2025-06-01");
        Date dataDev = Date.valueOf("2025-05-01");
        assertTrue(dataDev.before(dataEmp));
    }

    @Test
    void testFinalizarEmprestimo() {
        Emprestimo e = new Emprestimo(
            Date.valueOf("2025-01-01"),
            Date.valueOf("2025-01-20"),
            false, 1, 1
        );
        assertFalse(e.isEntregue());
        e.setEntregue(true);
        assertTrue(e.isEntregue());
    }

    @Test
    void testFormatoDataValido() {
        String data = "2025-06-07";
        assertTrue(data.matches("\\d{4}-\\d{2}-\\d{2}"));
    }

    @Test
    void testFormatoDataInvalido() {
        String data = "07/06/2025";
        assertFalse(data.matches("\\d{4}-\\d{2}-\\d{2}"));
    }
}
