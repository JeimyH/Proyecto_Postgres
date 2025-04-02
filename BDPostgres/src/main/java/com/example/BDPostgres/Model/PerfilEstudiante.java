package com.example.BDPostgres.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "PerfilEstudiante")
public class PerfilEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_perfil", nullable = false, length = 20)
    private long id_perfil;

    @Column(name = "Direccion", nullable = false, length = 20)
    private String direccion;

    @Column(name = "Fecha Nacimiento", nullable = false, length = 20)
    private String fechaNacimiento;

    @OneToOne(mappedBy = "perfilEstudiante", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private Estudiante estudiante;


}

