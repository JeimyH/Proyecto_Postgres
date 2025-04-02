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
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "Nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "Telefono", nullable = false, length = 20)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    private PerfilEstudiante perfilEstudiante;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Estudiante_Curso",
            joinColumns = @JoinColumn(
                    name = "codigo",
                    referencedColumnName = "codigo"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_curso",
                    referencedColumnName = "id_curso"
            )
    )
    private List<Curso> cursosList;

}
