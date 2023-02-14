package org.sample.dto;

public class UserDto {
    private int id;
    private String name;
    private String lastname;
    private String password;

    public UserDto() {
    }

    public UserDto(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public UserDto(int id, String name, String lastname, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
