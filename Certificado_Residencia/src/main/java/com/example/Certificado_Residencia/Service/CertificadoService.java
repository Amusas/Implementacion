package com.example.Certificado_Residencia.Service;

import com.example.Certificado_Residencia.Model.Certificado;
import com.example.Certificado_Residencia.Repository.CertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificadoService {
    @Autowired
    private CertificadoRepository certificadoRepository;

    public List<Certificado> listarTodos() {
        return certificadoRepository.findAll();
    }

    public Certificado obtenerPorId(Long id) {
        return certificadoRepository.findById(id).orElse(null);
    }

    public Certificado guardar(Certificado Certificado) {
        return certificadoRepository.save(Certificado);
    }

    public void eliminar(Long id) {
        certificadoRepository.deleteById(id);
    }
}

