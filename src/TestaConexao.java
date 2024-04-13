
import java.sql.*;
public class TestaConexao {
private static final String USUARIO = "root";
private static final String SENHA = "";
private static final String URL = "jdbc:mysql://localhost:3306/bancojavafacul";
public static Connection conectar()throws SQLException, ClassNotFoundException {
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
Connection conexao = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
return conexao;
}
public static void main(String[] args) throws ClassNotFoundException{
try {
Connection conexao = TestaConexao.conectar();
System.out.println("Conexão ao Banco realizada com sucesso");
} catch (SQLException ex) {
ex.printStackTrace();
System.out.println("Conexão ao Banco falhou");
}
}
}