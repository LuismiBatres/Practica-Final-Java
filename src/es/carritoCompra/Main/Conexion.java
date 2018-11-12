package es.carritoCompra.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {

	public static void main(String[] args) {
		Connection conn1 = null;
		try {
			String url1 = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7265151";
			String user = "sql7265151";
			String password = "QvbcD9gyht";
			conn1 = DriverManager.getConnection(url1, user, password);
			if (conn1 != null) {
				System.out.println("Connected to the database sql7265151");
				
				//INSERT
				/*String query = " insert into Categorias values (?, ?)";
				PreparedStatement preparedStmt =conn1.prepareStatement(query);
				preparedStmt.setInt (1, 11);
				preparedStmt.setString (2, "Perfumeria");
				preparedStmt.execute();*/
				
				//SELECT 
				String query1 = "SELECT * FROM Categorias";
				Statement st = conn1.createStatement();
				ResultSet rs = st.executeQuery(query1);
				while (rs.next()){
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					System.out.format("%s, %s \n", id, nombre);
				}
				st.close();
				
			}else {
				System.out.println("Fallo");
			}
		} catch (SQLException ex) {
			System.out.println("Error en la conexion,usuario /password incorrecto");
			ex.printStackTrace();
		}finally {
			try {
				conn1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
