package com.ismaeldev.integrador.domain.Store;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store")
public class Store implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String responsiblePerson;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String cnpj;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    @ColumnDefault("true")
    private Boolean active;

    private Integer activesVehicles;

    @JsonIgnore
    private StoreRole role;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
    private List<Address> addresses;

    private LocalDateTime dateInsert;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == StoreRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
