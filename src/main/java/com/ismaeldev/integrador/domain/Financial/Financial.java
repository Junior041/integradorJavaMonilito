package com.ismaeldev.integrador.domain.Financial;

import com.ismaeldev.integrador.domain.Store.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Financial" )
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long financialId;

    @Column(nullable = false, length = 50)
    private String paymentMethod;

    @Column(nullable = false)
    private Boolean isMonthly;

    @Column(nullable = false, columnDefinition = "FLOAT")
    @ColumnDefault("50.00")
    private Double price;

    @Column(nullable = false)
    private FinancialCoin coinType;

    @Column(nullable = false)
    private Byte datePayment;

    @Column(columnDefinition = "INTEGER")
    @ColumnDefault("0")
    private Integer vehiclesLimit;

    @Column(columnDefinition = "INTEGER")
    @ColumnDefault("0")
    private Integer additionalLimit;

    @Column(columnDefinition = "FLOAT")
    @ColumnDefault("5.00")
    private Float additionalPrice;

    @ManyToOne
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    @Column(nullable = false)
    private LocalDateTime dateInsert;
}