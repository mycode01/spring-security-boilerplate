package com.example.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@ToString(exclude = {"upw"})
@EqualsAndHashCode(of={"uid", "upw", "username"})
@Alias("member")
public class Member {
    private Long id;
    private String uid;
    @JsonIgnore
    private String upw;
    private String username;
    private String isEnabled;

    //and more
    private List<String> roles = new ArrayList<>();

    public void setRoles(String roles){
        this.roles = Arrays.asList(roles.split(";"));
    }
    public String getRoles(){
        if(roles == null || roles.isEmpty()){
            return "";
        } else {
            return String.join(";", roles);
        }
    }

    public void addRole(String role){
        if(roles == null){
            roles = new ArrayList<>();
        }
        roles.add(role);
    }


}
