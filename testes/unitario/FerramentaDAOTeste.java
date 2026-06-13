package unit;

import dao.FerramentaDAO;
import modelo.Ferramenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class FerramentaDAOTest {

    private FerramentaDAO dao;

    @BeforeEach
    void setUp() {
        dao = new FerramentaDAO();
    }

    @Test
    void testListaFerramentasNaoNula() {
        assertNotNull(dao.ListaFerramentas);
    }

    @Test
    void testListaFerramentasDisponiveisNaoNula() {
        assertNotNull(dao.ListaFerramentasDisponiveis);
    }

    @Test
    void testAdicionarFerramentaNaLista() {
        dao.ListaFerramentas.clear();
        dao.ListaFerramentas.add(new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0));
        assertEquals(1, dao.ListaFerramentas.size());
    }

    @Test
    void testAdicionarMultiplasFerramentas() {
        dao.ListaFerramentas.clear();
        dao.ListaFerramentas.add(new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0));
        dao.ListaFerramentas.add(new Ferramenta("Martelo", "Stanley", 50.0, 2, 0));
        dao.ListaFerramentas.add(new Ferramenta("Serra", "Makita", 400.0, 3, 0));
        assertEquals(3, dao.ListaFerramentas.size());
    }

    @Test
    void testFerramentaCorretaNaLista() {
        dao.ListaFerramentas.clear();
        dao.ListaFerramentas.add(new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0));
        assertEquals("Furadeira", dao.ListaFerramentas.get(0).getNome());
    }

    @Test
    void testListaFerramentasEhArrayList() {
        assertInstanceOf(ArrayList.class, dao.ListaFerramentas);
    }

    @Test
    void testListaDisponiveisEhArrayList() {
        assertInstanceOf(ArrayList.class, dao.ListaFerramentasDisponiveis);
    }

    @Test
    void testRemoverFerramentaDaLista() {
        dao.ListaFerramentas.clear();
        Ferramenta f = new Ferramenta("Furadeira", "Bosch", 350.0, 1, 0);
        dao.ListaFerramentas.add(f);
        dao.ListaFerramentas.remove(f);
        assertTrue(dao.ListaFerramentas.isEmpty());
    }

    @Test
    void testListaInicialmenteVazia() {
        dao.ListaFerramentas.clear();
        assertTrue(dao.ListaFerramentas.isEmpty());
    }
}
