package edu.escuelaing.IETI.LearningGuardians.dtos;

import java.io.Serializable;

public class UserDto implements Serializable{
    String id,name,email,createdAt;

    public UserDto() {
    }

    private static final long serialVersionUID = 1L;

    public UserDto(String name, String email, String createdAt) {
        this.id = "";
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }
    public UserDto(String id, String name, String email, String createdAt){
        this.id =id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
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


}
