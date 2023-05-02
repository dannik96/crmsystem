package cz.cvut.fel.groscdan.crmsystem.security.model;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User extends AbstractEntity {

    @Column
    @NonNull
    private String username;

    @Column
    @NonNull
    private String email;

    @Column
    @NonNull
    private String password;

    @OneToOne(mappedBy = "user")
    private Person user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_to_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    @NonNull
    private Set<UserRole> roles = new HashSet<>();

    public User() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addRole(UserRole userRole) {
        if (userRole == null) {
            roles = new HashSet<>();
        }
        roles.add(userRole);
    }
}
