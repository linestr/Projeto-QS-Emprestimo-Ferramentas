package visao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MensagemTeste {

    @Test
    void testMensagemExcecao() {
        Mensagem m = new Mensagem("Erro de teste");
        assertEquals("Erro de teste", m.getMessage());
    }

    @Test
    void testMensagemEhExcecao() {
        Mensagem m = new Mensagem("Erro");
        assertInstanceOf(Exception.class, m);
    }

    @Test
    void testMensagemVazia() {
        Mensagem m = new Mensagem("");
        assertEquals("", m.getMessage());
    }

    @Test
    void testMensagemComEspacos() {
        Mensagem m = new Mensagem("   ");
        assertEquals("   ", m.getMessage());
    }

    @Test
    void testMensagemComCaracteresEspeciais() {
        Mensagem m = new Mensagem("Erro: campo inválido!");
        assertEquals("Erro: campo inválido!", m.getMessage());
    }

    @Test
    void testMensagemNaoNula() {
        Mensagem m = new Mensagem("Qualquer erro");
        assertNotNull(m.getMessage());
    }
}
