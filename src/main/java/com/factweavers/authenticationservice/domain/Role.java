package com.factweavers.authenticationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "dv_user_roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    private String roleName;
    private Long creatorId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dv_role_role_scope", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "role_scope_id"))
    private Set<RoleScopes> roleScopes = new HashSet<>();
}
