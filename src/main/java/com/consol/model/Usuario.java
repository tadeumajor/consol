package com.consol.model;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nomeMorador;

    @NotEmpty
    private String rg;

    @NotEmpty
    @Email(message = "Email inválido, gentileza conferir")
    private String email;

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

    public Usuario(Long id, String nomeMorador, String rg,  String email, String telContato, String numAp, Condominio condominio, Boolean log) {
        this.id = id;
        this.nomeMorador = nomeMorador;
        this.rg = rg;
        this.email = email;
        this.telContato = telContato;
        this.numAp = numAp;
        this.condominio = condominio;
        this.log=false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    public String getNumAp() {
        return numAp;
    }

    public void setNumAp(String numAp) {
        this.numAp = numAp;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }


    
}

