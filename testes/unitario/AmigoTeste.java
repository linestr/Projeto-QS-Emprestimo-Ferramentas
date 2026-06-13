package unit;

import modelo.Amigo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AmigoTest {

    @Test
    void testConstrutorPadrao() {
        Amigo amigo = new Amigo();
        assertEquals(0, amigo.getId());
        assertEquals("", amigo.getNome());
        assertEquals("", amigo.getTelefone());
    }

    @Test
    void testConstrutorComParametros() {
        Amigo amigo = new Amigo(1, "Maria", "47991234567");
        assertEquals(1, amigo.getId());
        assertEquals("Maria", amigo.getNome());
        assertEquals("47991234567", amigo.getTelefone());
    }

    @Test
    void testSetId() {
        Amigo amigo = new Amigo();
        amigo.setId(5);
        assertEquals(5, amigo.getId());
    }

    @Test
    void testSetNome() {
        Amigo amigo = new Amigo();
        amigo.setNome("João");
        assertEquals("João", amigo.getNome());
    }

    @Test
    void testSetTelefone() {
        Amigo amigo = new Amigo();
        amigo.setTelefone("47999999999");
        assertEquals("47999999999", amigo.getTelefone());
    }

    @Test
    void testNomeNaoNulo() {
        Amigo amigo = new Amigo(1, "Ana", "47988887777");
        assertNotNull(amigo.getNome());
    }

    @Test
    void testTelefoneNaoNulo() {
        Amigo amigo = new Amigo(1, "Ana", "47988887777");
        assertNotNull(amigo.getTelefone());
    }
}
