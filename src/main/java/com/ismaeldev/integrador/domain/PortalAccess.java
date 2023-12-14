package com.ismaeldev.integrador.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ismaeldev.integrador.domain.Store.Store;
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
@Table(name = "PortalAccess")
public class PortalAccess {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long portalAccessId;

    private String storePasswordPortal;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "portalId", nullable = false)
    private Portal portal;

    private LocalDateTime dateInsert;
}
