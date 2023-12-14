package com.ismaeldev.integrador.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Portal")
@Entity
public class Portal {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long portalId;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String urlPortal;

    @Column(unique = true, nullable = false)
    private String urlApi;

    @Column(unique = true, nullable = false)
    private String description;

    private String phone;

    private String email;

    private LocalDateTime dateInsert;
}
