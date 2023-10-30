package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;


public class Conexion {

    // Datos de conexión a la base de datos
    String url = "jdbc:mysql://localhost:3306/calculadora_db"; // Reemplaza 'tu_basedatos' con el nombre de tu base de datos
    String usuario = "root"; // Reemplaza 'tu_usuario' con tu nombre de usuario de MySQL
    String contraseña = ""; // Reemplaza 'tu_contraseña' con tu contraseña de MySQL
    Connection cx;

    public Conexion() {
    }

    public Connection conectar() {
        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            cx = DriverManager.getConnection(url, usuario, contraseña);

            // Si la conexión se establece con éxito, imprime un mensaje
            System.out.println("Conexión a la base de datos MySQL exitosa.");

            // Cierra la conexión cuando hayas terminado de usarla
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return cx;
    }
    public void desconectar(){
        try{
            cx.close();
        }catch(SQLException ex){
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
