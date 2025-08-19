package zona_fit.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zona_fit.dominio.Cliente;
import static zona_fit.conexion.Conexion.getConexion;

// Patron de diseño DAO ( Data Access Object)
// Patro utilizado para acceder a la información de una entidad (db table)
// Cliente DAO                          clientes        Base de datos (tabla clientes) -- ORM (object relational maping)
// listar clientes READ (select)        - id            - id
// insertar clientes CREATE (insert)    - nombre        - nombre
// actualizar clientes UPDATE (update)  - apellido      - apellido
// eliminar clientes DELETE (delete)    - membresia     - membresia

public class ClienteDAO implements IClienteDAO {
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        // Preparar la sentencia de tipo sql que vamos a ejecutar hacia la base de datos
        PreparedStatement ps;
        // Importar la interface resultset
        // Este objeto contiene el resultado de la consulta
        ResultSet rs;
        Connection con = getConexion();
        var sql = "select * from cliente order by id";

        try{
            // Con la variable preparedStatement 
            // vamos a recibir un objeto ps 
            // que vamos a obtener del objeto tipo conexión
            ps = con.prepareStatement(sql);
            // Ejecutar la sentencia tipo sql
            rs = ps.executeQuery();
            // Iterar cada uno de los resultados
            // Si no hay registros que iterar el método "next" retorna falso
            // Se posiciona en el primer registro a iterar 
            while (rs.next()) { 
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }

        } catch(Exception e) {
            System.out.println("¡Error al listar clientes!: " + e.getMessage());
        } finally {
            try {
                // Cerrar el objeto de conexion
                con.close();
            } catch(Exception e) {
                System.out.println("¡Error al cerrar la conexión!" + e.getMessage());
            }
        }
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
