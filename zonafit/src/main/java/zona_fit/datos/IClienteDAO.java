package zona_fit.datos;

import java.util.List;

import zona_fit.dominio.Cliente;

public interface IClienteDAO {
    List<Cliente> listarClientes();
    boolean buscarClientePorId(Cliente cliente);
    boolean agregarCliente(Cliente cliente);
    boolean unificarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
    

}
