import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClienteDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    public ClienteDAO(){
}
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancojavafacul", "root","");
            return true;
        }catch (ClassNotFoundException | SQLException e){
            return false;
        }
    }
    
    public int adicionar(Cliente cliente){
        int status = 1;
        try{
            pstm = conn.prepareStatement("INSERT INTO cliente(mat, nome, email)VALUES(?,?,?)");
            pstm.setString(1, cliente.getMat());
            pstm.setString(2, cliente.getNome());
            pstm.setString(3, cliente.getEmail());
            status = pstm.executeUpdate();
            return status;
        }catch(SQLException e) {
            //JOptionPane.showConfirmDialog(null, "Erro ao salvar dados "+ e.toString());
            //System.out.println("Erro ao salvar dados "+ e.getMessage().toLowerCase());
            return e.getErrorCode();
        }
    }

    public void desconectar(){
        try{
            conn.close();
        }catch (SQLException e){

        }
    }

    public Cliente Consultar (String matricula){
            try {
                Cliente cliente = new Cliente();
                pstm = conn.prepareStatement("SELECT * FROM cliente WHERE mat = ?");
                pstm.setString(1, matricula);
                rs = pstm.executeQuery();
                if(rs.next()){
                    cliente.setMat(rs.getString("mat"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    return cliente;
                } else {
                    return null;
                }   } catch (HeadlessException | SQLException e) {
                return null;
            }
        }
    }