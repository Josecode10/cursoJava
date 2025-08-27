package gm.zona_fit.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import gm.zona_fit.modelo.Cliente;
// JpaRepository<T, ID> T es la clase entidad y ID es el tipo de la clave primaria
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
