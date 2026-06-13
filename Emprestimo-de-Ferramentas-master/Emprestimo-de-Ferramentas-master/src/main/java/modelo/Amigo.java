package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

/**
 * Classe Amigo que representa um amigo com id, nome e telefone, e interage com o banco de dados através de AmigoDAO.
 */
public class Amigo {

    private int id;
    private String nome, telefone;
    private AmigoDAO dao;

    /**
     * Construtor padrão da classe Amigo.
     */
    public Amigo() {
        this(0, "", "");
    }

    /**
     * Construtor da classe Amigo com parâmetros.
     *
     * @param id       ID do amigo.
     * @param nome     Nome do amigo.
     * @param telefone Telefone do amigo.
     */
    public Amigo(int id, String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
        dao = new AmigoDAO();
    }

    /**
     * Obtém o ID do amigo.
     *
     * @return ID do amigo.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do amigo.
     *
     * @param id Novo ID do amigo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do amigo.
     *
     * @return Nome do amigo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do amigo.
     *
     * @param nome Novo nome do amigo.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o telefone do amigo.
     *
     * @return Telefone do amigo.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do amigo.
     *
     * @param telefone Novo telefone do amigo.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém a lista de todos os amigos.
     *
     * @return Lista de amigos.
     */
    public ArrayList<Amigo> getListaAmigos() {
        return dao.getMinhaLista();
    }

    /**
     * Insere um novo amigo no banco de dados.
     *
     * @param nome     Nome do amigo.
     * @param telefone Telefone do amigo.
     * @return True se a inserção for bem-sucedida, False caso contrário.
     */
    public boolean inserirAmigo(String nome, String telefone) {
        id = dao.maiorId() + 1;
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.inserirAmigoBD(objeto);
        return true;
    }

    /**
     * Apaga um amigo do banco de dados.
     *
     * @param id ID do amigo a ser apagado.
     * @return True se a exclusão for bem-sucedida, False caso contrário.
     */
    public boolean apagarAmigo(int id) {
        dao.apagarAmigoBD(id);
        return true;
    }

    /**
     * Altera os dados de um amigo no banco de dados.
     *
     * @param id       ID do amigo a ser alterado.
     * @param nome     Novo nome do amigo.
     * @param telefone Novo telefone do amigo.
     * @return True se a alteração for bem-sucedida, False caso contrário.
     */
    public boolean alterarAmigo(int id, String nome, String telefone) {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.alterarAmigoBD(objeto);
        return true;
    }

    /**
     * Carrega um amigo do banco de dados com base no ID.
     *
     * @param id ID do amigo a ser carregado.
     * @return Amigo carregado.
     */
    public Amigo carregarAmigo(int id) {
        return dao.carregarAmigoBD(id);
    }
}