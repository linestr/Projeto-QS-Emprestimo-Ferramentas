package modelo;

import dao.EmprestimoDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Classe Emprestimo que representa um empréstimo com data de empréstimo, data de devolução, status de entrega, ID e ID do amigo.
 */
public class Emprestimo {

    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean entregue;
    private int id, idAmg;
    private EmprestimoDAO dao = new EmprestimoDAO();

    /**
     * Construtor padrão da classe Emprestimo.
     */
    public Emprestimo() {
        this(null, null, false, 0, 0);
    }

    /**
     * Construtor da classe Emprestimo com parâmetros.
     *
     * @param dataEmprestimo Data do empréstimo.
     * @param dataDevolucao  Data da devolução.
     * @param entregue       Status de entrega.
     * @param id             ID do empréstimo.
     * @param idAmg          ID do amigo que fez o empréstimo.
     */
    public Emprestimo(Date dataEmprestimo, Date dataDevolucao, boolean entregue, int id, int idAmg) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.entregue = entregue;
        this.id = id;
        this.idAmg = idAmg;
    }

    /**
     * Obtém a data do empréstimo.
     *
     * @return Data do empréstimo.
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Define a data do empréstimo.
     *
     * @param dataEmprestimo Nova data do empréstimo.
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Obtém a data da devolução.
     *
     * @return Data da devolução.
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Define a data da devolução.
     *
     * @param dataDevolucao Nova data da devolução.
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * Verifica se o empréstimo foi entregue.
     *
     * @return True se o empréstimo foi entregue, false caso contrário.
     */
    public boolean isEntregue() {
        return entregue;
    }

    /**
     * Define o status de entrega do empréstimo.
     *
     * @param entregue Novo status de entrega.
     */
    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    /**
     * Obtém o ID do empréstimo.
     *
     * @return ID do empréstimo.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do empréstimo.
     *
     * @param id Novo ID do empréstimo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o ID do amigo que fez o empréstimo.
     *
     * @return ID do amigo.
     */
    public int getIdAmg() {
        return idAmg;
    }

    /**
     * Define o ID do amigo que fez o empréstimo.
     *
     * @param idAmg Novo ID do amigo.
     */
    public void setIdAmg(int idAmg) {
        this.idAmg = idAmg;
    }

    /**
     * Obtém a lista de todos os empréstimos.
     *
     * @return Lista de empréstimos.
     */
    public ArrayList<Emprestimo> getListaEmprestimos() {
        return dao.getMinhaLista();
    }

    /**
     * Insere um novo empréstimo no banco de dados.
     *
     * @param dataEmprestimo Data do empréstimo.
     * @param dataDevolucao  Data da devolução.
     * @param entregue       Status de entrega.
     * @param idAmg          ID do amigo que fez o empréstimo.
     * @return True se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean inserirEmprestimo(Date dataEmprestimo, Date dataDevolucao, boolean entregue, int idAmg) {
        id = dao.maiorId() + 1;
        Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
        dao.inserirEmprestimoBD(objeto);
        return true;
    }

    /**
     * Apaga um empréstimo do banco de dados.
     *
     * @param id ID do empréstimo a ser apagado.
     * @return True se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean apagarEmprestimo(int id) {
        dao.apagarEmprestimoBD(id);
        return true;
    }

    /**
     * Altera os dados de um empréstimo no banco de dados.
     *
     * @param dataDevolucao Nova data da devolução.
     * @param entregue      Novo status de entrega.
     * @param id            ID do empréstimo a ser alterado.
     * @return True se a alteração for bem-sucedida, false caso contrário.
     */
    public boolean alterarEmprestimo(Date dataDevolucao, boolean entregue, int id) {
        Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
        dao.alterarEmprestimoBD(objeto);
        return true;
    }

    /**
     * Carrega um empréstimo do banco de dados com base no ID.
     *
     * @param id ID do empréstimo a ser carregado.
     * @return Empréstimo carregado.
     */
    public Emprestimo carregarEmprestimo(int id) {
        return dao.carregarEmprestimoBD(id);
    }
}