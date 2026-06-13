package unit;

import modelo.Ferramenta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FerramentaTest {

    @Test
    void testConstrutorPadrao() {
        Ferramenta f = new Ferramenta();
        assertEquals("", f.getNome());
        assertEquals("", f.getMarca());
        assertEquals(0.0, f.getCustoAquisicao());
        assertEquals(0, f.getId());
        assertEquals(0, f.getIdEmp());
    }

    @Test
    void testConstrutorComParametros() {
        Ferramenta f = new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0);
        assertEquals("Furadeira", f.getNome());
        assertEquals("Bosch", f.getMarca());
        assertEquals(350.0, f.getCustoAquisicao());
        assertEquals(1, f.getId());
        assertEquals(0, f.getIdEmp());
    }

    @Test
    void testSetNome() {
        Ferramenta f = new Ferramenta();
        f.setNome("Martelo");
        assertEquals("Martelo", f.getNome());
    }

    @Test
    void testSetMarca() {
        Ferramenta f = new Ferramenta();
        f.setMarca("Stanley");
        assertEquals("Stanley", f.getMarca());
    }

    @Test
    void testSetCustoAquisicao() {
        Ferramenta f = new Ferramenta();
        f.setCustoAquisicao(199.99);
        assertEquals(199.99, f.getCustoAquisicao());
    }

    @Test
    void testSetId() {
        Ferramenta f = new Ferramenta();
        f.setId(10);
        assertEquals(10, f.getId());
    }

    @Test
    void testSetIdEmp() {
        Ferramenta f = new Ferramenta();
        f.setIdEmp(3);
        assertEquals(3, f.getIdEmp());
    }

    @Test
    void testCustoNaoNegativo() {
        Ferramenta f = new Ferramenta("Serra", "Makita", 500.0, 2, 0);
        assertTrue(f.getCustoAquisicao() > 0);
    }
}
