package com.example.Arco.Repository;

import com.example.Arco.Model.Ciudadano;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CiudadanoRepository extends MongoRepository<Ciudadano, String> {
    List<Ciudadano> findByNombre(String nombre);
}


