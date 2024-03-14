package DAO;

import Connection.ConnectionFactory;
//import java.awt.List;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.ListaP;
import com.mysql.cj.jdbc.Blob;

public class ListaPDAO {
    public List<ListaP> read() {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ListaP> resultados = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM teste ");
            rs = stmt.executeQuery();
            while (rs.next()){
                ListaP result = new ListaP();
                result.setRegistro(rs.getInt("id"));
                result.setNome(rs.getString("String"));
                result.setImagem((Blob) rs.getBlob("Imagem"));
                result.setImg(result.getImagem().getBytes(1, (int) result.getImagem().length()));
                
                resultados.add(result);
            }
        }catch (SQLException ex){
            Logger.getLogger(ListaPDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{}
        return resultados;
    }
    
    public void create(ListaP c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO teste (String, Imagem)VALUES(?,?)");
                //stmt.setInt(1,c.getRegistro());
                stmt.setString(1,c.getNome());
                stmt.setBlob(2, c.getFis(), c.getTam());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
        }catch (SQLException ex) {
            //Logger.getLogger(ClienteDAO.class.getNam()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }
        finally{
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void update(ListaP c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE  teste SET String = ?, Imagem = ? WHERE id = ?");
                stmt.setString(1,c.getNome());
                stmt.setBlob(2, c.getFis(), c.getTam());
                stmt.setInt(3, c.getRegistro());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
        }catch (SQLException ex) {
            //Logger.getLogger(ClienteDAO.class.getNam()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }
        finally{
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void delete (ListaP c){ 
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM teste WHERE id = ?");
            stmt.setInt(1,c.getRegistro());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso.");
        }catch (SQLException ex) {
            //Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao exlcuir "+ex);
        }
        finally{
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public ListaP select(ListaP c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM teste WHERE id = ?");
                stmt.setInt(1, c.getRegistro());                
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    ListaP result = new ListaP();

                    result.setNome(rs.getString("String"));
                    result.setImagem((Blob) rs.getBlob("Imagem"));
                    result.setImg(result.getImagem().getBytes(1, (int) result.getImagem().length()));
                    
                    return(result);
            }
                
                JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
        }catch (SQLException ex) {
            //Logger.getLogger(ClienteDAO.class.getNam()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }
        finally{
            //ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }
}
