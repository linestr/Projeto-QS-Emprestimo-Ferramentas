package integracao;

import modelo.Ferramenta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FerramentaIntegracaoTest {

    @Test
    void testCriarFerramentaEVerificarDados() {
        Ferramenta f = new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0);
        assertAll(
            () -> assertEquals("Furadeira", f.getNome()),
            () -> assertEquals("Bosch", f.getMarca()),
            () -> assertEquals(350.0, f.getCustoAquisicao()),
            () -> assertEquals(1, f.getId()),
            () -> assertEquals(0, f.getIdEmp())
        );
    }

    @Test
    void testCustoZeroInvalido() {
        Ferramenta f = new Ferramenta("Martelo", "Vonder", 0.0, 1, 0);
        assertFalse(f.getCustoAquisicao() > 0);
    }

    @Test
    void testCustoNegativoInvalido() {
        Ferramenta f = new Ferramenta("Martelo", "Vonder", -10.0, 1, 0);
        assertTrue(f.getCustoAquisicao() < 0);
    }

    @Test
    void testNomeMinimoCaracteres() {
        Ferramenta f = new Ferramenta("Ma", "Vonder", 50.0, 1, 0);
        assertTrue(f.getNome().length() >= 2);
    }

    @Test
    void testMarcaMinimoCaracteres() {
        Ferramenta f = new Ferramenta("Martelo", "Vo", 50.0, 1, 0);
        assertTrue(f.getMarca().length() >= 2);
    }

    @Test
    void testFerramentaAssociadaAEmprestimo() {
        Ferramenta f = new Ferramenta("Serra", "Makita", 400.0, 2, 3);
        assertTrue(f.getIdEmp() > 0);
    }

    @Test
    void testAlterarCustoFerramenta() {
        Ferramenta f = new Ferramenta("Parafusadeira", "DeWalt", 450.0, 1, 0);
        f.setCustoAquisicao(500.0);
        assertEquals(500.0, f.getCustoAquisicao());
    }
}
