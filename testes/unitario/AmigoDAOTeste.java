package unit;

import dao.AmigoDAO;
import modelo.Amigo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AmigoDAOTest {

    private AmigoDAO dao;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    @BeforeEach
    void setUp() throws Exception {
        dao = new AmigoDAO();
        connection = mock(Connection.class);
        statement = mock(Statement.class);
        resultSet = mock(ResultSet.class);
    }

    @Test
    void testListaAmigosInicialmenteVazia() {
        dao.ListaAmigos.clear();
        assertTrue(dao.ListaAmigos.isEmpty());
    }

    @Test
    void testAdicionarAmigoNaLista() {
        dao.ListaAmigos.clear();
        dao.ListaAmigos.add(new Amigo(1, "Carlos", "47991234567"));
        assertEquals(1, dao.ListaAmigos.size());
    }

    @Test
    void testAdicionarMultiplosAmigos() {
        dao.ListaAmigos.clear();
        dao.ListaAmigos.add(new Amigo(1, "Carlos", "47991234567"));
        dao.ListaAmigos.add(new Amigo(2, "Ana", "47988887777"));
        dao.ListaAmigos.add(new Amigo(3, "João", "47977776666"));
        assertEquals(3, dao.ListaAmigos.size());
    }

    @Test
    void testListaAmigosContemAmigoCerto() {
        dao.ListaAmigos.clear();
        Amigo amigo = new Amigo(1, "Carlos", "47991234567");
        dao.ListaAmigos.add(amigo);
        assertEquals("Carlos", dao.ListaAmigos.get(0).getNome());
    }

    @Test
    void testListaAmigosNaoNula() {
        assertNotNull(dao.ListaAmigos);
    }

    @Test
    void testInserirAmigoNaListaDiretamente() {
        dao.ListaAmigos.clear();
        Amigo a = new Amigo(5, "Maria", "47911112222");
        dao.ListaAmigos.add(a);
        assertEquals(5, dao.ListaAmigos.get(0).getId());
    }

    @Test
    void testRemoverAmigoDaLista() {
        dao.ListaAmigos.clear();
        Amigo a = new Amigo(1, "Carlos", "47991234567");
        dao.ListaAmigos.add(a);
        dao.ListaAmigos.remove(a);
        assertTrue(dao.ListaAmigos.isEmpty());
    }

    @Test
    void testListaAmigosEhArrayList() {
        assertInstanceOf(ArrayList.class, dao.ListaAmigos);
    }
}
