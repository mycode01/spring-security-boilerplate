package com.example.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = {"upw"})
@EqualsAndHashCode(of={"uid", "upw", "username"})
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uid;
    @JsonIgnore
    @Column(nullable = false)
    private String upw;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String isEnabled;

    //and more
    @Convert(converter = StringListConverter.class)
    private List<String> roles = new ArrayList<>();

    public void addRole(String role){
        if(roles == null){
            roles = new ArrayList<>();
        }
        roles.add(role);
    }


}
