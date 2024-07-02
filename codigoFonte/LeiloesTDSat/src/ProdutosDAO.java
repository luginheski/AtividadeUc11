
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    //Connection conn;
    //PreparedStatement prep;
    ResultSet resultset;

    private conectaDAO conexao;
    private Connection conn;

    public boolean conectar() {
        this.conexao = new conectaDAO();
        this.conn = this.conexao.connectDB();
        if (this.conn == null) {
            return false;
        } else {
            return true;
        }
    }

    public void desconectar() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.print("erro ao desconectar " + ex.getMessage());
        }
    }

    public int cadastrarProduto(ProdutosDTO produto) {

        int status;
        try {
            PreparedStatement prep = this.conn.prepareStatement("INSERT INTO produtos(nome, valor, status) VALUES(?,?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            status = prep.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar" + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public List<ProdutosDTO> listarProdutos(String termoBusca) {
        List<ProdutosDTO> listagem = new ArrayList<>();
        try {

            String sqlFiltro = "SELECT * FROM produtos ";

            if (!termoBusca.isEmpty()) {
                sqlFiltro = sqlFiltro + " WHERE status LIKE 'Vendido'";

            }

            PreparedStatement st = this.conn.prepareStatement(sqlFiltro);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                listagem.add(produto);
            }

            return listagem;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar2 " + ex);
            System.out.println(ex);
            return null;
        }
    }

    public int venderProduto(ProdutosDTO produto, String id) {
        int status;

        try {
            String sql = "UPDATE produtos SET status = ? WHERE id = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, produto.getStatus());
            st.setString(2, id);
            status = st.executeUpdate();

            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar status " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

}
