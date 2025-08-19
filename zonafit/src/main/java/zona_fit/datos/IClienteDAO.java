package zona_fit.datos;

import java.util.List; // importar interface list

import zona_fit.dominio.Cliente;

public interface IClienteDAO {
    // Métodos de la interface 
    List<Cliente> listarClientes();
    // Se recibe como parámetro un objeto y se recupera lo que se necesite
    boolean buscarClientePorId(Cliente cliente);
    boolean agregarCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
    

}
