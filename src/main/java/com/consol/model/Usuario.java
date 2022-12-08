package com.consol.model;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nomeMorador;

    @NotEmpty
    private int cpf;

    @NotEmpty
    @Email(message = "Email inválido, gentileza conferir")
    private String email;

    @NotBlank
    @Size(min = 8, message = "Necessário no minimo oito (8) caracteres")
    private String password;

    @NotEmpty
    private String telContato;

    @NotEmpty
    private String numAp;

    private boolean log;

    @ManyToOne
    @JoinColumn(name = "codigo_condominio")
    private Condominio condominio;

    public Usuario() {
    }

    public Usuario( String nomeMorador, int cpf,  String email,String password, String telContato, String numAp, Condominio condominio, Boolean log) {
        this.nomeMorador = nomeMorador;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.telContato = telContato;
        this.numAp = numAp;
        this.log = false;
        this.condominio = condominio;
        
    }

    
}

