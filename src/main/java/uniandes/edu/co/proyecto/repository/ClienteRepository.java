package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Integer>{

    //Create
    Cliente save(Cliente cliente);

    //Read
    @Query("{'id' : ?0}")
    Cliente findById(int id);

    @Query("{'nombre' : ?0}")
    Cliente findByNombre(String nombre);

    @Query("{}")
    List<Cliente> findAllClientes();
    
}
