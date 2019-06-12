package com.lab2.rest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class User {

    @Id
    private String login;

    private String nome;
    private String senha;

    public User() {

    }

    public User(String login, String nome, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }
}

