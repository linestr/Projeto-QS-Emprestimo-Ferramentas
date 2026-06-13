package modelo;

import dao.FerramentaDAO;
import java.util.ArrayList;

/**
 * Classe Ferramenta que representa uma ferramenta com nome, marca, custo de aquisição, ID e ID de empréstimo.
 */
public class Ferramenta {

    private String nome, marca;
    private double custoAquisicao;
    private int id, idEmp;
    private FerramentaDAO dao;

    /**
     * Construtor padrão da classe Ferramenta.
     */
    public Ferramenta() {
        this("", "", 0, 0, 0);
    }

    /**
     * Construtor da classe Ferramenta com parâmetros.
     *
     * @param nome           Nome da ferramenta.
     * @param marca          Marca da ferramenta.
     * @param custoAquisicao Custo de aquisição da ferramenta.
     * @param id             ID da ferramenta.
     * @param idEmp          ID do empréstimo associado à ferramenta.
     */
    public Ferramenta(String nome, String marca, double custoAquisicao, int id, int idEmp) {
        this.nome = nome;
        this.marca = marca;
        this.custoAquisicao = custoAquisicao;
        this.id = id;
        this.idEmp = idEmp;
        dao = new FerramentaDAO();
    }

    /**
     * Obtém o nome da ferramenta.
     *
     * @return Nome da ferramenta.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da ferramenta.
     *
     * @param nome Novo nome da ferramenta.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a marca da ferramenta.
     *
     * @return Marca da ferramenta.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca da ferramenta.
     *
     * @param marca Nova marca da ferramenta.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtém o custo de aquisição da ferramenta.
     *
     * @return Custo de aquisição da ferramenta.
     */
    public double getCustoAquisicao() {
        return custoAquisicao;
    }

    /**
     * Define o custo de aquisição da ferramenta.
     *
     * @param custoAquisicao Novo custo de aquisição da ferramenta.
     */
    public void setCustoAquisicao(double custoAquisicao) {
        this.custoAquisicao = custoAquisicao;
    }

    /**
     * Obtém o ID da ferramenta.
     *
     * @return ID da ferramenta.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da ferramenta.
     *
     * @param id Novo ID da ferramenta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o ID do empréstimo associado à ferramenta.
     *
     * @return ID do empréstimo.
     */
    public int getIdEmp() {
        return idEmp;
    }

    /**
     * Define o ID do empréstimo associado à ferramenta.
     *
     * @param idEmp Novo ID do empréstimo.
     */
    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    /**
     * Obtém a lista de todas as ferramentas.
     *
     * @return Lista de ferramentas.
     */
    public ArrayList<Ferramenta> getListaFerramentas() {
        return dao.getMinhaLista();
    }

    /**
     * Insere uma nova ferramenta no banco de dados.
     *
     * @param nome           Nome da ferramenta.
     * @param marca          Marca da ferramenta.
     * @param custoAquisicao Custo de aquisição da ferramenta.
     * @return True se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean inserirFerramenta(String nome, String marca, double custoAquisicao) {
        id = dao.maiorId() + 1;
        Ferramenta objeto = new Ferramenta(nome, marca, custoAquisicao, id, idEmp);
        dao.inserirFerramentaBD(objeto);
        return true;
    }

    /**
     * Apaga uma ferramenta do banco de dados.
     *
     * @param id ID da ferramenta a ser apagada.
     * @return True se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean apagarFerramenta(int id) {
        dao.apagarFerramentaBD(id);
        return true;
    }

    /**
     * Altera os dados de uma ferramenta no banco de dados.
     *
     * @param id             ID da ferramenta a ser alterada.
     * @param nome           Novo nome da ferramenta.
     * @param marca          Nova marca da ferramenta.
     * @param custoAquisicao Novo custo de aquisição da ferramenta.
     * @return True se a alteração for bem-sucedida, false caso contrário.
     */
    public boolean alterarFerramenta(int id, String nome, String marca, double custoAquisicao) {
        Ferramenta objeto = new Ferramenta(nome, marca, custoAquisicao, id, idEmp);
        dao.alterarFerramentaBD(objeto);
        return true;
    }

    /**
     * Carrega uma ferramenta do banco de dados com base no ID.
     *
     * @param id ID da ferramenta a ser carregada.
     * @return Ferramenta carregada.
     */
    public Ferramenta carregarFerramenta(int id) {
        return dao.carregarFerramenta(id);
    }
}