package com.example.BDPostgres.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_curso", nullable = false, length = 20)
    private long id_curso;

    @Column(name = "Nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "Descripcion", nullable = false, length = 20)
    private String descripcion;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Estudiante> estudiantes;

    @ManyToMany(mappedBy = "cursosList", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantesList;


}
