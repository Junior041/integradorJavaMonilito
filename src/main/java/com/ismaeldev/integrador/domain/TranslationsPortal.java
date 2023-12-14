package com.ismaeldev.integrador.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "translations_portal")
@Entity
public class TranslationsPortal {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long translationsPortalId;

    @Column(nullable = false)
    private String termPortal;

    @Column(nullable = false)
    private String termIntegrator;

    @ManyToOne
    @JoinColumn(name = "portalId", nullable = false)
    private Portal portal;

    private LocalDateTime dateInsert;
}
