package com.cibertec.examenfinal.jaremgallegos.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class HistorialOdontologico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private LocalDate fecha;
    

    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name = "diagnostico_id")
    private Diagnostico diagnostico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "radiografia_id")
    private Radiografia radiografia;
}
