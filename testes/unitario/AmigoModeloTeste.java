package unit;

import modelo.Amigo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AmigoModeloTest {

    private Amigo amigo;

    @BeforeEach
    void setUp() {
        amigo = new Amigo(1, "Carlos", "47991234567");
    }

    @Test
    void testGetId() { assertEquals(1, amigo.getId()); }

    @Test
    void testGetNome() { assertEquals("Carlos", amigo.getNome()); }

    @Test
    void testGetTelefone() { assertEquals("47991234567", amigo.getTelefone()); }

    @Test
    void testSetIdAtualiza() { amigo.setId(99); assertEquals(99, amigo.getId()); }

    @Test
    void testSetNomeAtualiza() { amigo.setNome("Ana"); assertEquals("Ana", amigo.getNome()); }

    @Test
    void testSetTelefoneAtualiza() { amigo.setTelefone("47900000000"); assertEquals("47900000000", amigo.getTelefone()); }

    @Test
    void testNomeNaoNulo() { assertNotNull(amigo.getNome()); }

    @Test
    void testTelefoneNaoNulo() { assertNotNull(amigo.getTelefone()); }

    @Test
    void testIdPositivo() { assertTrue(amigo.getId() > 0); }

    @Test
    void testNomeMinimo() { assertTrue(amigo.getNome().length() >= 2); }

    @Test
    void testTelefone11Digitos() { assertEquals(11, amigo.getTelefone().length()); }

    @Test
    void testTelefoneSomenteNumeros() { assertTrue(amigo.getTelefone().matches("\\d{11}")); }

    @Test
    void testConstrutorPadraoId() { assertEquals(0, new Amigo().getId()); }

    @Test
    void testConstrutorPadraoNome() { assertEquals("", new Amigo().getNome()); }

    @Test
    void testConstrutorPadraoTelefone() { assertEquals("", new Amigo().getTelefone()); }

    @Test
    void testAlterarNomeMantémId() { amigo.setNome("Novo"); assertEquals(1, amigo.getId()); }

    @Test
    void testAlterarTelefoneMantémNome() { amigo.setTelefone("47911111111"); assertEquals("Carlos", amigo.getNome()); }
}
