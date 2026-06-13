package regressao;

import modelo.Amigo;
import modelo.Ferramenta;
import modelo.Emprestimo;
import modelo.Data;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes de Regressão — garantem que alterações futuras não quebrem
 * comportamentos já existentes e validados.
 */
class RegressaoTest {

    // -------------------------------------------------------
    // AMIGO — regressão
    // -------------------------------------------------------

    @Test
    void testAmigoMantemIdAposAlterarNome() {
        Amigo a = new Amigo(1, "Lucas", "47999998888");
        a.setNome("Lucas Alterado");
        assertEquals(1, a.getId());
        assertEquals("Lucas Alterado", a.getNome());
    }

    @Test
    void testAmigoMantemTelefoneAposAlterarNome() {
        Amigo a = new Amigo(1, "Lucas", "47999998888");
        a.setNome("Lucas Novo");
        assertEquals("47999998888", a.getTelefone());
    }

    @Test
    void testAmigoNaoPerdeNomeAposAlterarTelefone() {
        Amigo a = new Amigo(1, "Lucas", "47999998888");
        a.setTelefone("47911112222");
        assertEquals("Lucas", a.getNome());
    }

    @Test
    void testConstrutorPadraoAmigoSempreRetornaValoresPadrao() {
        Amigo a1 = new Amigo();
        Amigo a2 = new Amigo();
        assertEquals(a1.getId(), a2.getId());
        assertEquals(a1.getNome(), a2.getNome());
        assertEquals(a1.getTelefone(), a2.getTelefone());
    }

    @Test
    void testAmigoIdNaoAlteradoAposSetTelefone() {
        Amigo a = new Amigo(5, "Pedro", "47955554444");
        a.setTelefone("47933332222");
        assertEquals(5, a.getId());
    }

    // -------------------------------------------------------
    // FERRAMENTA — regressão
    // -------------------------------------------------------

    @Test
    void testFerramentaMantemCustoAposAlterarNome() {
        Ferramenta f = new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0);
        f.setNome("Furadeira Pro");
        assertEquals(350.0, f.getCustoAquisicao());
    }

    @Test
    void testFerramentaMantemIdAposAlterarMarca() {
        Ferramenta f = new Ferramenta("Serra", "Bosch", 400.0, 3, 0);
        f.setMarca("Makita");
        assertEquals(3, f.getId());
    }

    @Test
    void testFerramentaIdEmpNaoAlteradoAposSetNome() {
        Ferramenta f = new Ferramenta("Martelo", "Stanley", 50.0, 2, 0);
        f.setNome("Martelo Grande");
        assertEquals(0, f.getIdEmp());
    }

    @Test
    void testConstrutorPadraoFerramentaSempreRetornaValoresPadrao() {
        Ferramenta f1 = new Ferramenta();
        Ferramenta f2 = new Ferramenta();
        assertEquals(f1.getNome(), f2.getNome());
        assertEquals(f1.getMarca(), f2.getMarca());
        assertEquals(f1.getCustoAquisicao(), f2.getCustoAquisicao());
    }

    // -------------------------------------------------------
    // EMPRÉSTIMO — regressão
    // -------------------------------------------------------

    @Test
    void testEmprestimoMantemDataEmprestimoAposSetEntregue() {
        Date dataEmp = Date.valueOf("2025-03-01");
        Date dataDev = Date.valueOf("2025-03-15");
        Emprestimo e = new Emprestimo(dataEmp, dataDev, false, 1, 1);
        e.setEntregue(true);
        assertEquals(dataEmp, e.getDataEmprestimo());
    }

    @Test
    void testEmprestimoMantemIdAmgAposSetDevolucao() {
        Emprestimo e = new Emprestimo(
            Date.valueOf("2025-01-01"),
            Date.valueOf("2025-01-10"),
            false, 1, 3
        );
        e.setDataDevolucao(Date.valueOf("2025-01-20"));
        assertEquals(3, e.getIdAmg());
    }

    @Test
    void testEmprestimoMantemStatusAposAlterarDatas() {
        Emprestimo e = new Emprestimo(
            Date.valueOf("2025-05-01"),
            Date.valueOf("2025-05-15"),
            false, 2, 1
        );
        e.setDataEmprestimo(Date.valueOf("2025-05-02"));
        e.setDataDevolucao(Date.valueOf("2025-05-16"));
        assertFalse(e.isEntregue());
    }

    // -------------------------------------------------------
    // DATA — regressão
    // -------------------------------------------------------

    @Test
    void testDataAtualSempreRetornaHoje() {
        Date d1 = Data.dataAtual();
        Date d2 = Data.dataAtual();
        assertEquals(d1, d2);
    }
}
