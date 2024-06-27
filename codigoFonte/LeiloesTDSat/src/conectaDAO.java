
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

<<<<<<< HEAD
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
>>>>>>> 52925884ed6b45ef2c6f7ac3a9350064d8da813f
public class conectaDAO {

    public Connection connectDB() {
        Connection conn = null;

        try {

<<<<<<< HEAD
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=lorenteamo");
=======
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=");
>>>>>>> 52925884ed6b45ef2c6f7ac3a9350064d8da813f

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }

}
