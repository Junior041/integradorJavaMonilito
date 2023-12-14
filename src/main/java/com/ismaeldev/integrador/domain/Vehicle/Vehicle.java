package com.ismaeldev.integrador.domain.Vehicle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ismaeldev.integrador.domain.Brand;
import com.ismaeldev.integrador.domain.Category;
import com.ismaeldev.integrador.domain.Store.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Vehicle")
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    @Column(nullable = false, length = 25)
    private String model;
    private String version;
    private String fuel;
    private String motor;
    private Integer year;
    private Float price;
    private Float offerPrice;
    private String CodeFipe;
    @Column(length = 255)
    private String description;
    @Column(length = 25)
    private String color;
    private Integer hp;
    private Integer doors;
    private LocalDateTime dateInsert;

    @Column(nullable = true)
    @ColumnDefault(value = "false")
    private boolean active;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brandId", nullable = false)
    private Brand brand;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
    private List<Photo> photos;

    @ManyToMany
    @JoinTable(
            name = "optionalsVehicles",
            joinColumns = @JoinColumn(name = "vehicleId"),
            inverseJoinColumns = @JoinColumn(name = "optionalId")
    )
    private List<Optional> optionals;

}
