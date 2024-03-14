package Connection;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.logging.Level; 
import java.util.logging.Logger;

public class ConnectionFactory { 
    private static final String DRIVER = "com.mysql.jdbc.Driver";// driver de cnx do MySQL 
    private static final String URL = "jdbc:mysql://localhost:3306/teste1"; //substituir pelo nome do banco de dados
    private static final String USER = "root"; private static final String PASS = "";


    public static Connection getConnection(){
        try { 
            Class.forName(DRIVER);
                return DriverManager.getConnection(URL, USER, PASS); 
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        } 
    }

    public static void closeConnection(connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection((Connection) con, stmt);
        try{
            if(rs != null) {
                rs.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Para alterar o corpo dos métodos gerados, escolha Ferramentas | Modelos.
    }
}
