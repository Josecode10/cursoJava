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
        // Esta lista se va a llenar con los objetos cliente que se recuperen de la base de datos
        // Se usa la clase ArrayList que implementa la interface List
        List<Cliente> clientes = new ArrayList<>();
        // El objeto PreparedStatement se usa para preparar una sentencia sql
        PreparedStatement ps;
        // El objeto ResultSet se usa para almacenar el resultado de una consulta sql
        ResultSet rs;
        // Crear un objeto de tipo Connection para establecer la conexión a la base de datos
        Connection con = getConexion();
        // Se usa la sentencia "SELECT * FROM cliente ORDER BY id" para recuperar todos los datos de la tabla cliente
        // Se usa el asterisco (*) para recuperar todos los campos de la tabla
        var sql = "SELECT * FROM cliente ORDER BY id";

        // El siguiente código puede arrojar una excepción
        // Se usa un bloque try-catch para manejar la excepción
        try{
            // Preparar la sentencia sql
            // El método prepareStatement recibe una sentencia sql
            ps = con.prepareStatement(sql);
            // Ejecutar la sentencia sql
            // El método executeQuery retorna un objeto de tipo ResultSet
            rs = ps.executeQuery();
            // Mientras haya un registro en el objeto ResultSet
            // El método next se usa para recorrer los registros
            while (rs.next()) {
                // Crear un objeto cliente y asignar los valores de la consulta
                var cliente = new Cliente();
                // Asignar los valores de la consulta a los atributos del objeto cliente
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                // Agregar el objeto cliente a la lista de clientes
                clientes.add(cliente);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCliente'");
    }

    public static void main(String[] args) {
        // Crear un objeto de tipo ClienteDAO para llamar a los métodos de la clase
        IClienteDAO clienteDao = new ClienteDAO();
        // Buscar por "id"
        // var cliente1 = new Cliente(4);
        // System.out.println("Cliente antes de la búsqueda: " + cliente1);
        // var encontrado = clienteDao.buscarClientePorId(cliente1);
        // if (encontrado) {
        //     System.out.println("Cliente encontrado: " + cliente1);
        // } else {
        //     System.out.println("No se ha encontrado registro: " + cliente1);
        // }
        // Agregar cliente
        // var nuevoCLiente = new Cliente("Daniel", "Ortiz", 300); // Crear un objeto cliente
        // // Llamar al método agregarCliente y pasar el objeto cliente como parámetro
        // var agregado = clienteDao.agregarCliente(nuevoCLiente);
        // // Verificar si se agregó el cliente
        // if (agregado) {
        //     System.out.println("Cliente agregado." + nuevoCLiente);
        // } else {
        //     System.out.println("El cliente no se pudo agregar." + nuevoCLiente);
        // }
        // Modificar cliente
        // Se usa el constructor con todos los parámetros para modificar el cliente
        var modificarCliente = new Cliente(5, "Carlos Daniel", "Ortiz", 300);
        var modificado = clienteDao.modificarCliente(modificarCliente);
        if (modificado) {
            System.out.println("Cliente modificado: " + modificarCliente);
        } else {
            System.out.println("El cliente no se modificó: " + modificarCliente);
        }
        // Listar clientes
        System.out.println("*** Listar Clientes ***");
        var clientes = clienteDao.listarClientes(); // Llamar al método listarClientes
        clientes.forEach(System.out::println); // Imprimir la lista de clientes usando expresiones lambda
    }
    
}
