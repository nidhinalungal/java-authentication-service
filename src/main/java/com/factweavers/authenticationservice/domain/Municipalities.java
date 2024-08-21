package com.factweavers.authenticationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "dv_muncipality")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Municipalities {
    @Id
    private Long id;
    @NotNull
    private String name;

    @OneToMany(mappedBy = "muncipality", cascade = CascadeType.ALL)
    private List<User> users;

    public Municipalities(Long id, String name){
        this.id=id;
        this.name=name;
    }
}
