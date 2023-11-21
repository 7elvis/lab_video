package com.example.Base_Conciertos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "artista")
public class Concierto {
    @Id
    @Column(name = "idArtista", nullable = false)
    private int id;
    @Column(name = "Nombre_Grupo")
    private String nombre_grupo;
    @Column(name = "Fecha_creacion", length = 45)
    private String fecha_creacion;
    @Column(name = "tipo_Musica")
    private String tipo_musica,length = 45;
}
