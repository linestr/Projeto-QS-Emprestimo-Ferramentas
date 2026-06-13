package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;

/**
 * Classe que representa um DAO para operações relacionadas a amigos.
 */
public class AmigoDAO {

    /**
     * Lista de amigos.
     */
    public ArrayList<Amigo> ListaAmigos = new ArrayList<>();

    /**
     * Objeto de conexão com o banco de dados.
     */
    private ConexaoDAO connect;

    /**
     * Obtém a lista de amigos.
     *
     * @return A lista de amigos.
     */
    public ArrayList<Amigo> getMinhaLista() {
        ListaAmigos.clear();

        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");
            while (res.next()) {

                int id = res.getInt("id_amigo");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");

                Amigo objeto = new Amigo(id, nome, telefone);

                ListaAmigos.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaAmigos;
    }

    /**
     * Obtém o maior ID de amigo.
     *
     * @return O maior ID de amigo.
     */
    public int maiorId() {
        int maiorId = 0;
        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id_amigo) id FROM tb_amigos");
            res.next();
            maiorId = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorId;
    }

    /**
     * Insere um amigo no banco de dados.
     *
     * @param objeto O objeto amigo a ser inserido.
     * @return Verdadeiro se a inserção foi bem-sucedida, falso caso contrário.
     */
    public boolean inserirAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO tb_amigos(id_amigo,nome,telefone) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Apaga um amigo do banco de dados.
     *
     * @param id O ID do amigo a ser apagado.
     * @return Verdadeiro se a exclusão foi bem-sucedida, falso caso contrário.
     */
    public boolean apagarAmigoBD(int id) {
        try {
            Statement stmt = connect.getConexao().createStatement();

            stmt.executeUpdate("DELETE FROM tb_amigos WHERE id_amigo =" + id);

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    /**
     * Altera um amigo no banco de dados.
     *
     * @param objeto O objeto amigo com as alterações.
     * @return Verdadeiro se a alteração foi bem-sucedida, falso caso contrário.
     */
    public boolean alterarAmigoBD(Amigo objeto) {
        String sql = "UPDATE tb_amigos set nome = ?, telefone = ? WHERE id_amigo = ?";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());
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
     * Carrega um amigo do banco de dados.
     *
     * @param id O ID do amigo a ser carregado.
     * @return O objeto amigo carregado.
     */
    public Amigo carregarAmigoBD(int id) {
        Amigo objeto = new Amigo();
        objeto.setId(id);
        try {
            Statement stmt = connect.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE id_amigo = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getString("telefone"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    /**
     * Obtém o ID de um amigo pelo nome.
     *
     * @param nome O nome do amigo.
     * @return O ID do amigo.
     */
    public static int getIdPeloNome(String nome) {
        int id = -1;

        try {
            String query = "SELECT id_amigo FROM tb_amigos WHERE nome = ?";
            PreparedStatement statement = ConexaoDAO.getConexao().prepareStatement(query);
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_amigo");
            }
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }

        return id;
    }

    /**
     * Verifica se há pendências para um amigo.
     *
     * @param id O ID do amigo.
     * @return Verdadeiro se há pendências, falso caso contrário.
     */
    public boolean verificarPendencia(int id) {

        try {
            Statement stmt = connect.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("select id_amigo, entregue from tb_emprestimos;");
            while (res.next()) {

                int idAmg = res.getInt("id_amigo");
                boolean entregue = res.getBoolean("entregue");

                if (idAmg == id && entregue == false) {
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