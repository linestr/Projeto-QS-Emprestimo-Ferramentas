package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;

/**
 * Classe FerramentaDAO que fornece métodos para manipulação de dados de ferramentas no banco de dados.
 */
public class FerramentaDAO {

    /**
     * Lista de todas as ferramentas.
     */
    public ArrayList<Ferramenta> ListaFerramentas = new ArrayList<>();

    /**
     * Lista de ferramentas disponíveis.
     */
    public ArrayList<Ferramenta> ListaFerramentasDisponiveis = new ArrayList<>();

    /**
     * Objeto para conexão com o banco de dados.
     */
    private ConexaoDAO connect;

    /**
     * Obtém a lista de todas as ferramentas.
     *
     * @return Lista de todas as ferramentas.
     */
    public ArrayList<Ferramenta> getMinhaLista() {

        ListaFerramentas.clear();

        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas");
            while (res.next()) {

                int id = res.getInt("id_ferramenta");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double custoAquisicao = Double.parseDouble(res.getString("custo_aquisicao"));
                int idEmp = res.getInt("id_emprestimo");

                Ferramenta objeto = new Ferramenta(nome, marca, custoAquisicao, id, idEmp);

                ListaFerramentas.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaFerramentas;
    }

    /**
     * Obtém o maior ID de ferramenta presente no banco de dados.
     *
     * @return Maior ID de ferramenta.
     */
    public int maiorId() {
        int maiorId = 0;
        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id_ferramenta) id FROM tb_ferramentas");
            res.next();
            maiorId = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorId;
    }

    /**
     * Insere uma nova ferramenta no banco de dados.
     *
     * @param objeto Ferramenta a ser inserida.
     * @return True se a inserção for bem-sucedida, False caso contrário.
     */
    public boolean inserirFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramentas(id_ferramenta,nome,marca,custo_aquisicao) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCustoAquisicao());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Apaga uma ferramenta do banco de dados.
     *
     * @param id ID da ferramenta a ser apagada.
     * @return True se a exclusão for bem-sucedida, False caso contrário.
     */
    public boolean apagarFerramentaBD(int id) {
        try {
            Statement stmt = connect.getConexao().createStatement();

            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE id_ferramenta =" + id);

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    /**
     * Altera os dados de uma ferramenta no banco de dados.
     *
     * @param objeto Ferramenta com os novos dados.
     * @return True se a alteração for bem-sucedida, False caso contrário.
     */
    public boolean alterarFerramentaBD(Ferramenta objeto) {
        String sql = "UPDATE tb_ferramentas set nome = ?, marca = ?, custo_aquisicao = ? WHERE id_ferramenta = ?";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getCustoAquisicao());
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Carrega uma ferramenta do banco de dados com base no ID.
     *
     * @param id ID da ferramenta a ser carregada.
     * @return Ferramenta carregada.
     */
    public Ferramenta carregarFerramenta(int id) {
        Ferramenta objeto = new Ferramenta();
        objeto.setId(id);
        try {
            Statement stmt = connect.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE id_ferramenta = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setMarca(res.getString("marca"));
            objeto.setCustoAquisicao(res.getDouble("custo_aquisicao"));
            objeto.setIdEmp(res.getInt("id_emprestimo"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    /**
     * Obtém a lista de ferramentas disponíveis (não emprestadas).
     *
     * @return Lista de ferramentas disponíveis.
     */
    public ArrayList<Ferramenta> getFerramentasDisponiveis() {

        ListaFerramentasDisponiveis.clear();

        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE id_emprestimo is null");
            while (res.next()) {

                int id = res.getInt("id_ferramenta");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double custoAquisicao = Double.parseDouble(res.getString("custo_aquisicao"));
                int idEmp = res.getInt("id_emprestimo");

                Ferramenta objeto = new Ferramenta(nome, marca, custoAquisicao, id, idEmp);

                ListaFerramentasDisponiveis.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaFerramentasDisponiveis;
    }

    /**
     * Verifica se uma ferramenta está pendente de empréstimo.
     *
     * @param id ID da ferramenta a ser verificada.
     * @return True se houver pendências, False caso contrário.
     */
    public boolean verificarPendencia(int id) {

        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("select id_emprestimo from tb_ferramentas;");
            while (res.next()) {

                int idEmp = res.getInt("id_emprestimo");

                if (idEmp > 0) {
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