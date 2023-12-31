package com.monitasker.model.entity;

import com.monitasker.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "TB_users")
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity implements Serializable, UserDetails {

    @Column(length = 50, nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Getter
    @Lob
    @Column(name = "passwordhash", nullable = false, columnDefinition = "BINARY(60)")
    @JdbcTypeCode(SqlTypes.BINARY)
    private byte[] passwordHash;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Task> tasks = new ArrayList<>();

    // PASSWORD STORING

    @Transient
    private String password;

    @PostLoad
    public void onLoad() {
        this.password = new String(passwordHash, StandardCharsets.UTF_8);
    }

    @PrePersist
    @PreUpdate
    public void onSave() {
        if (password != null) {
            this.passwordHash = password.getBytes(StandardCharsets.UTF_8);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.getId() +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // TODO: 24/09/2023  
    }

    @Override
    public boolean isAccountNonExpired() {
        return false; // TODO: 24/09/2023  
    }

    @Override
    public boolean isAccountNonLocked() {
        return false; // TODO: 24/09/2023  
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false; // TODO: 24/09/2023  
    }

    @Override
    public boolean isEnabled() {
        return false; // TODO: 24/09/2023  
    }
}