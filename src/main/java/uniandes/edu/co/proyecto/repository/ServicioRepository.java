package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends MongoRepository<Servicio, String>{

    //Create
    Servicio save(Servicio servicio);

    @Query(value = "{'nombre' : ?0}")
    Servicio findByNombre(String nombre);

    @Query(value = "{}")
    List<Servicio> findAllServicios();

    //Delete
    @Query(value = "{'id' : ?0}", delete = true)
    Servicio deleteById(int id);

    @Query(value = "{'nombre' : ?0}", delete = true)
    Servicio deleteByNombre(String nombre);

    //Update
    @Query(value = "{'id' : ?0}")
    Servicio updateById(int id, Servicio servicio);
    
}
