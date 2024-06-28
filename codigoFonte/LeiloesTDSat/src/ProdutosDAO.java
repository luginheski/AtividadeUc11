
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    //Connection conn;
    //PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    private conectaDAO conexao;
    private Connection conn;
    
    public boolean conectar(){
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
        try{
            PreparedStatement  prep = this.conn.prepareStatement("INSERT INTO produtos(nome, valor, status) VALUES(?,?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            status = prep.executeUpdate();
            return status;
        }catch(SQLException ex){
            System.out.println("Erro ao conectar" + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        
        

        return listagem;
    }

}
