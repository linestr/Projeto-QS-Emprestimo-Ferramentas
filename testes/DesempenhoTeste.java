package desempenho;

import modelo.Amigo;
import modelo.Ferramenta;
import modelo.Emprestimo;
import modelo.Data;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DesempenhoTest {

    @Test
    void testCriar100AmigosEmMenosDe1Segundo() {
        long inicio = System.currentTimeMillis();
        ArrayList<Amigo> lista = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            lista.add(new Amigo(i, "Amigo" + i, "4799999" + String.format("%04d", i)));
        }
        long fim = System.currentTimeMillis();
        assertEquals(100, lista.size());
        assertTrue((fim - inicio) < 1000);
    }

    @Test
    void testCriar100FerramentasEmMenosDe1Segundo() {
        long inicio = System.currentTimeMillis();
        ArrayList<Ferramenta> lista = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            lista.add(new Ferramenta("Ferramenta" + i, "Marca" + i, i * 10.0, i, 0));
        }
        long fim = System.currentTimeMillis();
        assertEquals(100, lista.size());
        assertTrue((fim - inicio) < 1000);
    }

    @Test
    void testCriar100EmprestimosEmMenosDe1Segundo() {
        long inicio = System.currentTimeMillis();
        ArrayList<Emprestimo> lista = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            lista.add(new Emprestimo(
                Date.valueOf("2025-01-01"),
                Date.valueOf("2025-01-15"),
                false, i, i
            ));
        }
        long fim = System.currentTimeMillis();
        assertEquals(100, lista.size());
        assertTrue((fim - inicio) < 1000);
    }

    @Test
    void testBuscarAmigoEmListaDe1000EmMenosDe100ms() {
        ArrayList<Amigo> lista = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            lista.add(new Amigo(i, "Amigo" + i, "47999990000"));
        }
        long inicio = System.currentTimeMillis();
        Amigo encontrado = lista.stream()
            .filter(a -> a.getId() == 999)
            .findFirst()
            .orElse(null);
        long fim = System.currentTimeMillis();
        assertNotNull(encontrado);
        assertTrue((fim - inicio) < 100);
    }

    @Test
    void testFiltrarEmprestimosNaoEntreguesEmMenosDe100ms() {
        ArrayList<Emprestimo> lista = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            lista.add(new Emprestimo(
                Date.valueOf("2025-01-01"),
                Date.valueOf("2025-01-15"),
                i % 2 == 0, i, i
            ));
        }
        long inicio = System.currentTimeMillis();
        long naoEntregues = lista.stream().filter(e -> !e.isEntregue()).count();
        long fim = System.currentTimeMillis();
        assertEquals(250, naoEntregues);
        assertTrue((fim - inicio) < 100);
    }

    @Test
    void testCriar1000DatasEmMenosDe1Segundo() {
        long inicio = System.currentTimeMillis();
        ArrayList<Date> datas = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            datas.add(Data.dataAtual());
        }
        long fim = System.currentTimeMillis();
        assertEquals(1000, datas.size());
        assertTrue((fim - inicio) < 1000);
    }

    @Test
    void testCriar1000AmigosEmMenosDe2Segundos() {
        long inicio = System.currentTimeMillis();
        ArrayList<Amigo> lista = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            lista.add(new Amigo(i, "Amigo" + i, "47999990000"));
        }
        long fim = System.currentTimeMillis();
        assertEquals(1000, lista.size());
        assertTrue((fim - inicio) < 2000);
    }

    @Test
    void testCriar1000FerramentasEmMenosDe2Segundos() {
        long inicio = System.currentTimeMillis();
        ArrayList<Ferramenta> lista = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            lista.add(new Ferramenta("Ferramenta" + i, "Marca" + i, i * 10.0, i, 0));
        }
        long fim = System.currentTimeMillis();
        assertEquals(1000, lista.size());
        assertTrue((fim - inicio) < 2000);
    }
}
