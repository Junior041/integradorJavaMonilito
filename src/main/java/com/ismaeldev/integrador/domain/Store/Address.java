package com.ismaeldev.integrador.domain.Store;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ismaeldev.integrador.domain.Store.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String street;
    @Column(nullable = false)
    private String zipCode;
    private String state;
    private String neighborhood;
    private String city;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    private LocalDateTime dateInsert;
}
