package com.example.Certificado_Residencia.Service;

import com.example.Certificado_Residencia.Model.Habitante;
import com.example.Certificado_Residencia.Repository.HabitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitanteService {
    @Autowired
    private HabitanteRepository habitanteRepository;

    public List<Habitante> listarTodos() {
        return habitanteRepository.findAll();
    }

    public Habitante obtenerPorId(Long id) {
        return habitanteRepository.findById(id).orElse(null);
    }

    public Habitante guardar(Habitante habitante) {
        return habitanteRepository.save(habitante);
    }

    public void eliminar(Long id) {
        habitanteRepository.deleteById(id);
    }
}

