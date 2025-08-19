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
        // Crear una lista de tipo Cliente
        // Esta lista se va a llenar con los objetos cliente que se recuperen de la base de datos
        // Se usa la clase ArrayList que implementa la interface List
        List<Cliente> clientes = new ArrayList<>();
        // Crear los objetos que se van a usar para ejecutar la consulta
        // El objeto PreparedStatement se usa para preparar una sentencia sql
        PreparedStatement ps;
        // El objeto ResultSet se usa para almacenar el resultado de una consulta sql
        // El objeto ResultSet se usa para recorrer los registros de la consulta
        ResultSet rs;
        // Crear un objeto de tipo Connection para establecer la conexión a la base de datos
        // Se usa el método estático getConexion de la clase Conexion
        Connection con = getConexion();
        // La sentencia sql que se va a ejecutar
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
        PreparedStatement ps;
        ResultSet rs;
        // Tanto para "con" como para "sql" se puede usar "var" en la declaración
        Connection con = getConexion();
        // Donde el "id" sea un id en particular
        // Solo vamos a recuperar un registro
        String sql = "select * from cliente where id = ?";
        // El siguiente código puede arrojar una excepción
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
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
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarCliente'");
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unificarCliente'");
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCliente'");
    }

    public static void main(String[] args) {
        IClienteDAO clienteDao = new ClienteDAO();

        // Listar clientes
        // System.out.println("*** Listar Clientes ***");
        // var clientes = clienteDao.listarClientes();

        // clientes.forEach(System.out::println);

        // Buscar por "id"
        var cliente1 = new Cliente(3);
        System.out.println("Cliente antes de la búsqueda: " + cliente1);
        var encontrado = clienteDao.buscarClientePorId(cliente1);
        if (encontrado) {
            System.out.println("Cliente encontrado: " + cliente1);
        } else {
            System.out.println("No se ha encontrado registro: " + cliente1);
        }

    }
    
}
