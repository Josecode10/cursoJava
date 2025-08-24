package zona_fit.datos;

// Importar las clases necesarias para trabajar con la base de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zona_fit.dominio.Cliente;
import static zona_fit.conexion.Conexion.getConexion;

public class ClienteDAO implements IClienteDAO {
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>(); // Crear una lista para almacenar los clientes
        PreparedStatement ps; // El objeto PreparedStatement se usa para preparar una sentencia sql
        ResultSet rs; // El objeto ResultSet se usa para almacenar el resultado de una consulta sql
        Connection con = getConexion(); // Crear un objeto de tipo Connection para establecer la conexión a la base de datos
        var sql = "SELECT * FROM cliente ORDER BY id"; // Sentencia sql para listar los clientes
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) { // Iterar sobre el resultado de la consulta
                var cliente = new Cliente(); // Crear un objeto cliente
                // Llenar el objeto cliente con los datos del resultado de la consulta
                cliente.setId(rs.getInt("id")); 
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente); // Agregar el objeto cliente a la lista de clientes
            }
        } catch(Exception e) {
            // Si ocurre una excepción, se imprime el mensaje de error
            // Se usa el método getMessage para obtener el mensaje de la excepción
            System.out.println("¡Error al listar clientes!: " + e.getMessage());
        // Finalmente, se cierra la conexión a la base de datos
        } finally {
            // Se usa un bloque try-catch para cerrar la conexión
            // Si ocurre una excepción al cerrar la conexión, se imprime el mensaje de error
            try {
                // Cerrar el objeto de conexion
                con.close();
            } catch(Exception e) {
                System.out.println("¡Error al cerrar la conexión!" + e.getMessage());
            }
        }
        // Retornar la lista de clientes
        // Esta lista contiene los objetos cliente que se recuperaron de la base de datos
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        // Crear los objetos que se van a usar para ejecutar la consulta
        PreparedStatement ps;
        // El objeto ResultSet se usa para almacenar el resultado de una consulta sql
        ResultSet rs;
        // Crear un objeto de tipo Connection para establecer la conexión a la base de datos  
        Connection con = getConexion();
        // Se usa el signo de interrogación (?) para indicar que se va a usar un parámetro
        String sql = "select * from cliente where id = ?";
        // El siguiente código puede arrojar una excepción
        try {
            // Preparar la sentencia sql
            ps = con.prepareStatement(sql);
            // El método setInt se usa para asignar un valor entero al parámetro
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true; // Cliente encontrado
            }
        } catch(Exception e) {
            System.out.println("¡Error al recuperar cliente por id!: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch(Exception e) {
                System.out.println("¡Error al cerrar conexión" + e.getMessage());
            }
        }
        return false; // Cliente no encontrado
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        // Crear los objetos que se van a usar para ejecutar la consulta
        Connection con = getConexion();
        // El objeto PreparedStatement se usa para preparar una sentencia sql
        PreparedStatement ps;
        // Se usan los signos de interrogación (?) para indicar que se van a usar parámetros
        String sql = "INSERT INTO cliente (nombre, apellido, membresia) VALUES (?, ?, ?)";
        try {
            // El método prepareStatement recibe una sentencia sql
            ps = con.prepareStatement(sql);
            // El método setString se usa para asignar un valor de tipo cadena al parámetro
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            // El método setInt se usa para asignar un valor de tipo entero al parámetro    
            ps.setInt(3, cliente.getMembresia());
            // El método execute se usa para ejecutar una sentencia sql que no retorna un resultado
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps; 
        Connection con = getConexion();
        String sql = "UPDATE cliente SET nombre = ?, apellido = ?, membresia = ? WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            // Asignar los valores de los parámetros llamando a los métodos get del objeto cliente
            // El orden de los parámetros debe coincidir con el orden de los signos de interrogación (?)
            // El id se usa en la cláusula WHERE para identificar el registro que se va a modificar
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM cliente WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }
}