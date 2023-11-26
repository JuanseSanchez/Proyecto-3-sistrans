package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, String>{

    //Create
    TipoHabitacion save(TipoHabitacion tipoHabitacion);

    //Read
    @Query(value = "{'nombre' : ?0}")
    TipoHabitacion findByNombre(String nombre);

    @Query("{}")
    List<TipoHabitacion> findAllTipoHabitaciones();

    //Delete
    @Query(value = "{'nombre' : ?0}", delete = true)
    TipoHabitacion deleteByNombre(String nombre);

    //Update
    @Query(value = "{'nombre' : ?0}")
    TipoHabitacion updateByNombre(String nombre, TipoHabitacion tipoHabitacion);


    
}
