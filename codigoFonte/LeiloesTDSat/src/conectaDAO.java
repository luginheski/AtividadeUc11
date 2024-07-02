
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class conectaDAO {
  
    
    public Connection connectDB() {      

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/uc11", // linha de conexao
                    "root", // usuario do mysql
                    "mysql"// senha do mysql
            );
            return conn;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + ex.getMessage());
            return null;
        }
    }


}
