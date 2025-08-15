package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    // Crear un método que retorna un objeto de tipo "Connection"
    public static Connection getConexion() {
        Connection conexion = null;
        var baseDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "admin";

        try {
            // Cargar el nombre de la clase para crear la conexión a MySql
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Objeto que permite establecer una conexión a la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch(Exception e) {
            System.out.println("¡Error al conectar a la base de datos!" + e.getMessage());
        } finally {
            System.out.println();
        }
        return conexion;  
    }

    public static void main(String[] args) {
        // No necesitamos crear un objeto ya que el método es estático
        // Accedemos a los métodos directamente con el nombre de la clase
        var conexion = Conexion.getConexion();
        // Comprobar la conexión a la base de datos
        if (conexion != null) {
            System.out.println("Conexión exitosa: " + conexion);
        } else {
            System.out.println("¡Error al conectarse!");
        }
    }

}
