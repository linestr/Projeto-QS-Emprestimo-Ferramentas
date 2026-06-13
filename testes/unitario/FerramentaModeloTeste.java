package unit;

import modelo.Ferramenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FerramentaModeloTest {

    private Ferramenta ferramenta;

    @BeforeEach
    void setUp() {
        ferramenta = new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0);
    }

    @Test
    void testGetNome() { assertEquals("Furadeira", ferramenta.getNome()); }

    @Test
    void testGetMarca() { assertEquals("Bosch", ferramenta.getMarca()); }

    @Test
    void testGetCusto() { assertEquals(350.0, ferramenta.getCustoAquisicao()); }

    @Test
    void testGetId() { assertEquals(1, ferramenta.getId()); }

    @Test
    void testGetIdEmp() { assertEquals(0, ferramenta.getIdEmp()); }

    @Test
    void testSetNome() { ferramenta.setNome("Serra"); assertEquals("Serra", ferramenta.getNome()); }

    @Test
    void testSetMarca() { ferramenta.setMarca("Makita"); assertEquals("Makita", ferramenta.getMarca()); }

    @Test
    void testSetCusto() { ferramenta.setCustoAquisicao(500.0); assertEquals(500.0, ferramenta.getCustoAquisicao()); }

    @Test
    void testSetId() { ferramenta.setId(5); assertEquals(5, ferramenta.getId()); }

    @Test
    void testSetIdEmp() { ferramenta.setIdEmp(2); assertEquals(2, ferramenta.getIdEmp()); }

    @Test
    void testCustoPositivo() { assertTrue(ferramenta.getCustoAquisicao() > 0); }

    @Test
    void testNomeNaoNulo() { assertNotNull(ferramenta.getNome()); }

    @Test
    void testMarcaNaoNula() { assertNotNull(ferramenta.getMarca()); }

    @Test
    void testConstrutorPadraoNome() { assertEquals("", new Ferramenta().getNome()); }

    @Test
    void testConstrutorPadraoMarca() { assertEquals("", new Ferramenta().getMarca()); }

    @Test
    void testConstrutorPadraoCusto() { assertEquals(0.0, new Ferramenta().getCustoAquisicao()); }

    @Test
    void testConstrutorPadraoId() { assertEquals(0, new Ferramenta().getId()); }

    @Test
    void testConstrutorPadraoIdEmp() { assertEquals(0, new Ferramenta().getIdEmp()); }

    @Test
    void testAlterarNomeMantémMarca() { ferramenta.setNome("Lixadeira"); assertEquals("Bosch", ferramenta.getMarca()); }

    @Test
    void testAlterarCustoMantémId() { ferramenta.setCustoAquisicao(999.0); assertEquals(1, ferramenta.getId()); }
}
