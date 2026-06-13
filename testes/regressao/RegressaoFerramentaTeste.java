package regressao;

import modelo.Ferramenta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegressaoFerramentaTest {

    @Test
    void testFerramentaMantemCustoAposAlterarNome() {
        Ferramenta f = new Ferramenta("Parafusadeira", "DeWalt", 450.0, 1, 0);
        f.setNome("Parafusadeira Pro");
        assertEquals(450.0, f.getCustoAquisicao());
    }

    @Test
    void testFerramentaMantemIdAposAlterarCusto() {
        Ferramenta f = new Ferramenta("Serra", "Makita", 400.0, 2, 0);
        f.setCustoAquisicao(500.0);
        assertEquals(2, f.getId());
    }

    @Test
    void testFerramentaSemEmprestimoMantemIdEmpZero() {
        Ferramenta f = new Ferramenta("Nivel", "Vonder", 89.90, 5, 0);
        f.setNome("Nivel Digital");
        assertEquals(0, f.getIdEmp());
    }

    @Test
    void testFerramentaMantemMarcaAposAlterarNome() {
        Ferramenta f = new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0);
        f.setNome("Furadeira Pro");
        assertEquals("Bosch", f.getMarca());
    }
}
