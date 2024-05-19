package com.example.Certificado_Residencia.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Habitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;

    @OneToMany(mappedBy = "habitante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificado> certificados;

}

