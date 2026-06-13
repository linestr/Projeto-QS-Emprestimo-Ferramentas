package unit;

import modelo.Data;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void testDataAtualNaoNula() {
        Date data = Data.dataAtual();
        assertNotNull(data);
    }

    @Test
    void testDataAtualEHoje() {
        Date data = Data.dataAtual();
        assertEquals(Date.valueOf(LocalDate.now()), data);
    }

    @Test
    void testStringParaDateSQLValida() throws Exception {
        Date data = Data.stringParaDateSQL("2025-06-01");
        assertEquals(Date.valueOf("2025-06-01"), data);
    }

    @Test
    void testStringParaDateSQLOutraDataValida() throws Exception {
        Date data = Data.stringParaDateSQL("2024-12-31");
        assertEquals(Date.valueOf("2024-12-31"), data);
    }

    @Test
    void testStringParaDateSQLFormatoInvalido() {
        assertThrows(Exception.class, () -> {
            Data.stringParaDateSQL("01/06/2025");
        });
    }

    @Test
    void testStringParaDateSQLFormatoInvalidoAmericano() {
        assertThrows(Exception.class, () -> {
            Data.stringParaDateSQL("June 1, 2025");
        });
    }

    @Test
    void testDataAtualNaoEstaNoPassado() {
        Date data = Data.dataAtual();
        Date ontem = Date.valueOf(LocalDate.now().minusDays(1));
        assertTrue(data.after(ontem) || data.equals(Date.valueOf(LocalDate.now())));
    }
}
