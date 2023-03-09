package com.application.project.models;

public class User {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public User(){}
    public User(int id, String email, String first_name, String last_name, String avatar){ 
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    //getters
    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getFirst_name(){
        return first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public String getAvatar(){
        return avatar;
    }

    //setters

    public void setId(int id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String to_string(){
        return getId() +". Nombre: " + getFirst_name() +" " + getLast_name() + "\n"
                            + "Correo: " + getEmail() + "\n" 
                            + "Avatar: " + getAvatar() + "\n\n";
    }
}
