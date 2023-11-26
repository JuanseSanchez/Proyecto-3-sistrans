package uniandes.edu.co.proyecto.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface ConsumoRepository extends MongoRepository<Consumo, LocalDate>{

    //Create
    Consumo save(Consumo consumo);

    //Read
    @Query("{}")
    List<Consumo> findAllConsumos();
    
}
