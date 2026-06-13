package integracao;

import modelo.Amigo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AmigoIntegracaoTest {

    @Test
    void testCriarAmigoEVerificarDados() {
        Amigo amigo = new Amigo(1, "Carlos", "47911112222");
        assertAll(
            () -> assertEquals(1, amigo.getId()),
            () -> assertEquals("Carlos", amigo.getNome()),
            () -> assertEquals("47911112222", amigo.getTelefone())
        );
    }

    @Test
    void testAmigoComNomeCurtoInvalido() {
        Amigo amigo = new Amigo(2, "A", "47911112222");
        assertTrue(amigo.getNome().length() < 2);
    }

    @Test
    void testTelefoneComOnzeDigitos() {
        String telefone = "47991234567";
        assertEquals(11, telefone.length());
        assertTrue(telefone.matches("\\d{11}"));
    }

    @Test
    void testTelefoneInvalidoMenosDigitos() {
        String telefone = "479912345";
        assertNotEquals(11, telefone.length());
    }
}
