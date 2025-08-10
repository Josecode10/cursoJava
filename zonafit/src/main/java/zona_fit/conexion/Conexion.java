package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        var baseDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "admin";

        try {
            // Clase de conexión a la base de datos
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
        var conexion = Conexion.getConexion();
        // Comprobar la conexión a la base de datos
        if (conexion != null) {
            System.out.println("Conexión exitosa: " + conexion);
        } else {
            System.out.println("¡Error al conectarse!");
        }
    }

}
