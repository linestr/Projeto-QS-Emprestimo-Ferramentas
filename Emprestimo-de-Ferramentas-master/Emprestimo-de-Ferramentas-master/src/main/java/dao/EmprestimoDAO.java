package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Emprestimo;

/**
 * Classe EmprestimoDAO que fornece métodos para manipulação de dados de empréstimos no banco de dados.
 */
public class EmprestimoDAO {

    /**
     * Lista de todos os empréstimos.
     */
    public static ArrayList<Emprestimo> ListaEmprestimos = new ArrayList<>();

    /**
     * Lista de empréstimos ativos.
     */
    public ArrayList<Emprestimo> ListaEmprestimosAtivos = new ArrayList<>();

    /**
     * Objeto para conexão com o banco de dados.
     */
    private ConexaoDAO connect;

    /**
     * Obtém a lista de todos os empréstimos.
     *
     * @return Lista de todos os empréstimos.
     */
    public ArrayList<Emprestimo> getMinhaLista() {

        ListaEmprestimos.clear();

        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos");
            while (res.next()) {

                int id = res.getInt("id_emprestimo");
                int idAmg = res.getInt("id_amigo");
                Date dataEmprestimo = res.getDate("data_emprestimo");
                Date dataDevolucao = res.getDate("data_devolucao");
                boolean entregue = res.getBoolean("entregue");

                Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);

                ListaEmprestimos.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaEmprestimos;
    }

    /**
     * Obtém o maior ID de empréstimo presente no banco de dados.
     *
     * @return Maior ID de empréstimo.
     */
    public int maiorId() {
        int maiorId = 0;
        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id_emprestimo) id FROM tb_emprestimos");
            res.next();
            maiorId = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorId;
    }

    /**
     * Insere um novo empréstimo no banco de dados.
     *
     * @param objeto Empréstimo a ser inserido.
     * @return True se a inserção for bem-sucedida, False caso contrário.
     */
    public boolean inserirEmprestimoBD(Emprestimo objeto) {
        String sql = "INSERT INTO tb_emprestimos(id_emprestimo,id_amigo,data_emprestimo, data_devolucao, entregue) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setInt(2, objeto.getIdAmg());
            stmt.setDate(3, objeto.getDataEmprestimo());
            stmt.setDate(4, objeto.getDataDevolucao());
            stmt.setBoolean(5, objeto.isEntregue());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Apaga um empréstimo do banco de dados.
     *
     * @param id ID do empréstimo a ser apagado.
     * @return True se a exclusão for bem-sucedida, False caso contrário.
     */
    public boolean apagarEmprestimoBD(int id) {
        try {
            Statement stmt = connect.getConexao().createStatement();

            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE id_emprestimo = " + id);

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    /**
     * Altera os dados de um empréstimo no banco de dados.
     *
     * @param objeto Empréstimo com os novos dados.
     * @return True se a alteração for bem-sucedida, False caso contrário.
     */
    public boolean alterarEmprestimoBD(Emprestimo objeto) {
        String sql = "UPDATE tb_emprestimos set data_devolucao = ?, entregue = ? WHERE id_emprestimo = ?";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            stmt.setDate(1, objeto.getDataDevolucao());
            stmt.setBoolean(2, objeto.isEntregue());
            stmt.setInt(3, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Carrega um empréstimo do banco de dados com base no ID.
     *
     * @param id ID do empréstimo a ser carregado.
     * @return Empréstimo carregado.
     */
    public Emprestimo carregarEmprestimoBD(int id) {
        Emprestimo objeto = new Emprestimo();
        objeto.setId(id);
        try {
            Statement stmt = connect.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE id_emprestimo = " + id);
            res.next();

            objeto.setIdAmg(res.getInt("id_amigo"));
            objeto.setDataEmprestimo(res.getDate("data_emprestimo"));
            objeto.setDataDevolucao(res.getDate("data_devolucao"));
            objeto.setEntregue(res.getBoolean("entregue"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    /**
     * Obtém a lista de empréstimos ativos (não entregues).
     *
     * @return Lista de empréstimos ativos.
     */
    public ArrayList<Emprestimo> getEmprestimosAtivos() {

        ListaEmprestimosAtivos.clear();

        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE entregue is false");
            while (res.next()) {

                int id = res.getInt("id_emprestimo");
                Date data_emp = res.getDate("data_emprestimo");
                Date data_dev = res.getDate("data_devolucao");
                boolean entregue = res.getBoolean("entregue");
                int idEmp = res.getInt("id_amigo");

                Emprestimo objeto = new Emprestimo(data_emp, data_dev, entregue, id, idEmp);

                ListaEmprestimosAtivos.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaEmprestimosAtivos;
    }

    /**
     * Verifica se um amigo tem empréstimos pendentes.
     *
     * @param id ID do amigo a ser verificado.
     * @return True se houver pendências, False caso contrário.
     */
    public boolean verificarPendencia(int id) {

        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("select entregue from tb_emprestimos;");
            while (res.next()) {

                boolean entregue = res.getBoolean("entregue");

                if (entregue == false) {
                    return true;
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return false;
    }
}