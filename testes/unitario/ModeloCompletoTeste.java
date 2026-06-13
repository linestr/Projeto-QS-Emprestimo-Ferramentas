package unit;

import modelo.Amigo;
import modelo.Emprestimo;
import modelo.Ferramenta;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

class ModeloCompletoTest {

    @Test
    void testAmigoGetSetCompleto() {
        Amigo a = new Amigo();
        a.setId(10);
        a.setNome("Teste");
        a.setTelefone("47999998888");
        assertEquals(10, a.getId());
        assertEquals("Teste", a.getNome());
        assertEquals("47999998888", a.getTelefone());
    }

    @Test
    void testAmigoConstrutorCompleto() {
        Amigo a = new Amigo(5, "João", "47911112222");
        assertAll(
            () -> assertEquals(5, a.getId()),
            () -> assertEquals("João", a.getNome()),
            () -> assertEquals("47911112222", a.getTelefone())
        );
    }

    @Test
    void testFerramentaGetSetCompleto() {
        Ferramenta f = new Ferramenta();
        f.setId(3);
        f.setNome("Martelo");
        f.setMarca("Stanley");
        f.setCustoAquisicao(75.0);
        f.setIdEmp(2);
        assertAll(
            () -> assertEquals(3, f.getId()),
            () -> assertEquals("Martelo", f.getNome()),
            () -> assertEquals("Stanley", f.getMarca()),
            () -> assertEquals(75.0, f.getCustoAquisicao()),
            () -> assertEquals(2, f.getIdEmp())
        );
    }

    @Test
    void testFerramentaConstrutorCompleto() {
        Ferramenta f = new Ferramenta("Serra", "Makita", 400.0, 2, 1);
        assertAll(
            () -> assertEquals("Serra", f.getNome()),
            () -> assertEquals("Makita", f.getMarca()),
            () -> assertEquals(400.0, f.getCustoAquisicao()),
            () -> assertEquals(2, f.getId()),
            () -> assertEquals(1, f.getIdEmp())
        );
    }

    @Test
    void testEmprestimoGetSetCompleto() {
        Emprestimo e = new Emprestimo();
        Date dataEmp = Date.valueOf("2025-03-01");
        Date dataDev = Date.valueOf("2025-03-20");
        e.setId(7);
        e.setIdAmg(3);
        e.setDataEmprestimo(dataEmp);
        e.setDataDevolucao(dataDev);
        e.setEntregue(true);
        assertAll(
            () -> assertEquals(7, e.getId()),
            () -> assertEquals(3, e.getIdAmg()),
            () -> assertEquals(dataEmp, e.getDataEmprestimo()),
            () -> assertEquals(dataDev, e.getDataDevolucao()),
            () -> assertTrue(e.isEntregue())
        );
    }

    @Test
    void testEmprestimoConstrutorCompleto() {
        Date dataEmp = Date.valueOf("2025-04-01");
        Date dataDev = Date.valueOf("2025-04-15");
        Emprestimo e = new Emprestimo(dataEmp, dataDev, false, 3, 4);
        assertAll(
            () -> assertEquals(dataEmp, e.getDataEmprestimo()),
            () -> assertEquals(dataDev, e.getDataDevolucao()),
            () -> assertFalse(e.isEntregue()),
            () -> assertEquals(3, e.getId()),
            () -> assertEquals(4, e.getIdAmg())
        );
    }

    @Test
    void testAmigoNomeVazio() {
        Amigo a = new Amigo(1, "", "47999999999");
        assertEquals("", a.getNome());
    }

    @Test
    void testFerramentaCustoZero() {
        Ferramenta f = new Ferramenta("Teste", "Marca", 0.0, 1, 0);
        assertEquals(0.0, f.getCustoAquisicao());
    }

    @Test
    void testEmprestimoEntregueAlternado() {
        Emprestimo e = new Emprestimo();
        e.setEntregue(true);
        assertTrue(e.isEntregue());
        e.setEntregue(false);
        assertFalse(e.isEntregue());
    }

    @Test
    void testAmigoAlterarTodosOsCampos() {
        Amigo a = new Amigo(1, "Original", "47900000000");
        a.setId(99);
        a.setNome("Alterado");
        a.setTelefone("47911111111");
        assertEquals(99, a.getId());
        assertEquals("Alterado", a.getNome());
        assertEquals("47911111111", a.getTelefone());
    }
}
