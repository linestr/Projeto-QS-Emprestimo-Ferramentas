package regressao;

import modelo.Amigo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegressaoAmigoTest {

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
    void testConstrutorPadraoSempreRetornaValoresPadrao() {
        Amigo a1 = new Amigo();
        Amigo a2 = new Amigo();
        assertEquals(a1.getId(), a2.getId());
        assertEquals(a1.getNome(), a2.getNome());
        assertEquals(a1.getTelefone(), a2.getTelefone());
    }
}
