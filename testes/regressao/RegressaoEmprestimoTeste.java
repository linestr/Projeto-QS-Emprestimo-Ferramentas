package regressao;

import modelo.Emprestimo;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

class RegressaoEmprestimoTest {

    @Test
    void testStatusEntregaAlteraCorretamente() {
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
    void testEmprestimoMantemIdAmigoAposAlterarStatus() {
        Emprestimo e = new Emprestimo(
            Date.valueOf("2025-01-01"),
            Date.valueOf("2025-01-20"),
            false, 1, 3
        );
        e.setEntregue(true);
        assertEquals(3, e.getIdAmg());
    }

    @Test
    void testEmprestimoMantemDataEmprestimoAposAlterarDevolucao() {
        Date dataEmp = Date.valueOf("2025-01-01");
        Emprestimo e = new Emprestimo(dataEmp, Date.valueOf("2025-01-20"), false, 1, 1);
        e.setDataDevolucao(Date.valueOf("2025-02-01"));
        assertEquals(dataEmp, e.getDataEmprestimo());
    }

    @Test
    void testConstrutorPadraoSempreRetornaFalseParaEntregue() {
        Emprestimo e1 = new Emprestimo();
        Emprestimo e2 = new Emprestimo();
        assertEquals(e1.isEntregue(), e2.isEntregue());
        assertFalse(e1.isEntregue());
    }
}
