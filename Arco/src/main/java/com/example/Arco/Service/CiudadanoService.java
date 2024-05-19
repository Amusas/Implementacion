package com.example.Arco.Service;

import com.example.Arco.Model.Ciudadano;
import com.example.Arco.Repository.CiudadanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadanoService {
    @Autowired
    private CiudadanoRepository ciudadanoRepository;

    public List<Ciudadano> listarTodos() {
        return ciudadanoRepository.findAll();
    }

    public Ciudadano obtenerPorId(String id) {
        return ciudadanoRepository.findById(id).orElse(null);
    }

    public Ciudadano guardar(Ciudadano ciudadano) {
        return ciudadanoRepository.save(ciudadano);
    }

    public void eliminar(String id) {
        ciudadanoRepository.deleteById(id);
    }
}

