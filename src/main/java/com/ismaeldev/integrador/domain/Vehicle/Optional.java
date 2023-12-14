package com.ismaeldev.integrador.domain.Vehicle;

import com.ismaeldev.integrador.domain.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Optional")
public class Optional {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long optionalId;

    @Column(unique = true, nullable = false)
    private String optional;

    @Column(unique = true, nullable = false)
    private String abbreviation;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    private LocalDateTime dateInsert;
}
