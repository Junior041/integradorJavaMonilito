package com.ismaeldev.integrador.domain.Vehicle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ismaeldev.integrador.domain.Vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Photo")
public class Photo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long photoId;

    @Column(unique = true, nullable = false)
    private String url;

    @JsonIgnore
    @ManyToOne
    private Vehicle vehicle;

    private LocalDateTime dateInsert;
}
