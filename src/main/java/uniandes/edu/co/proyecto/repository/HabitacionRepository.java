package uniandes.edu.co.proyecto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends MongoRepository<Habitacion, Integer> {

    //Create
    Habitacion save(Habitacion habitacion);

    //Read
    @Query("{'numero' : ?0}")
    Habitacion findById(int numero);

    @Query("{}")
    Habitacion findAllHabitaciones();

    //Delete
    @Query(value = "{'numero' : ?0}")
    void deleteById(int numero);

    //Update
    @Query(value = "{numero : ?0}")
    Habitacion updateHabitacion(int numero, Habitacion habitacion);

    
}
