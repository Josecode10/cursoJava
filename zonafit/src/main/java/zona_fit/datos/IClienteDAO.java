package zona_fit.datos;

// Importar las clases necesarias para trabajar con la base de datos
import java.util.List;
import zona_fit.dominio.Cliente;

// Interface que define los métodos que se van a implementar en la clase ClienteDAO
// Esta interface se usa para definir los métodos que se van a usar para acceder a la información
public interface IClienteDAO {
    List<Cliente> listarClientes();
    boolean buscarClientePorId(Cliente cliente);
    boolean agregarCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
    

}
