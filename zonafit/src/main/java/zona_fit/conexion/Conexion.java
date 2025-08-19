package zona_fit.conexion;

// Importar las clases necesarias para trabajar con la base de datos
import java.sql.Connection;
import java.sql.DriverManager;

// Clase que permite establecer una conexión a la base de datos
// Esta clase contiene un método estático que retorna un objeto de tipo Connection
public class Conexion {
    // Método estático que retorna un objeto de tipo Connection
    // Este método se usa para establecer la conexión a la base de datos
    public static Connection getConexion() {
        // Declarar un objeto de tipo Connection
        // Este objeto se usa para establecer la conexión a la base de datos
        Connection conexion = null;
        // Definir los parámetros de conexión a la base de datos
        // Estos parámetros se usan para establecer la conexión a la base de datos MySQL
        var baseDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "admin";

        try {
            // Registrar el driver de MySQL
            // El método forName se usa para registrar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión a la base de datos
            // El método getConnection recibe la URL de la base de datos, el usuario y la contraseña
            // Si la conexión es exitosa, se asigna el objeto Connection a la variable conexion
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
