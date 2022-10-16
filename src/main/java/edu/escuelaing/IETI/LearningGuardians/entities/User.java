package edu.escuelaing.IETI.LearningGuardians.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import edu.escuelaing.IETI.LearningGuardians.dtos.UserDto;
import edu.escuelaing.IETI.LearningGuardians.entities.enumerations.RoleEnum;
@Document
public class User{
    @Id
    String id;
    

    String name, createdAt;
    private String passwordHash;
    private List<RoleEnum> roles;

    @Indexed( unique = true )
    String email;


    public User(String id, String name, String email, String createdAt){
        this.id =id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public User(UserDto userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.createdAt = userDTO.getCreatedAt();
        //System.out.println("Estamos en costructor de User ");
        //System.out.println("Contraseña " + userDTO.getPassword());
        passwordHash = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt());
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public List<RoleEnum> getRoles() {
        return roles;
    }
    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }
}