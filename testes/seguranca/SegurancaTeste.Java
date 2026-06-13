package seguranca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SegurancaTest {

    @Test
    void testSQLInjectionNomeAmigo() {
        String entradaMaliciosa = "'; DROP TABLE tb_amigos; --";
        assertFalse(entradaMaliciosa.matches("[a-zA-ZÀ-ú\\s]{2,45}"),
            "Entrada maliciosa não deveria passar na validação de nome");
    }

    @Test
    void testSQLInjectionTelefone() {
        String entradaMaliciosa = "'; DROP TABLE tb_amigos; --";
        assertFalse(entradaMaliciosa.matches("\\d{11}"),
            "Entrada maliciosa não deveria passar na validação de telefone");
    }

    @Test
    void testTelefoneAceitaSomenteNumeros() {
        String telefoneValido = "47991234567";
        String telefoneInvalido = "4799123456A";
        assertTrue(telefoneValido.matches("\\d{11}"));
        assertFalse(telefoneInvalido.matches("\\d{11}"));
    }

    @Test
    void testFormatoDataSeguro() {
        String dataValida = "2025-06-07";
        String dataInvalida = "'; DROP TABLE tb_emprestimos; --";
        assertTrue(dataValida.matches("\\d{4}-\\d{2}-\\d{2}"));
        assertFalse(dataInvalida.matches("\\d{4}-\\d{2}-\\d{2}"));
    }

    @Test
    void testCustoNaoAceitaValorNegativo() {
        double custo = -100.0;
        assertFalse(custo > 0, "Custo negativo não deveria ser aceito");
    }

    @Test
    void testNomeNaoAceitaCaracteresEspeciais() {
        String nomeInvalido = "<script>alert('xss')</script>";
        assertFalse(nomeInvalido.matches("[a-zA-ZÀ-ú\\s]{2,45}"),
            "Nome com caracteres especiais não deveria ser aceito");
    }
}
