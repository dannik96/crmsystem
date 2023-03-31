package cz.cvut.fel.groscdan.crmsystem.security.model;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@RequiredArgsConstructor
@Getter
@Setter
public class UserRole extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @Column
    @NonNull
    private ERole name;

    public UserRole() {

    }

}
