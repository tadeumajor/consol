package com.consol.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
public class Condominio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotEmpty
    private String nome;
    
    @NotEmpty
    private String local;
    
    private int larguraDisp;
    private int alturaDisp;
    private double areaTotal;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_condominio")
    private List<Usuario> moradores;

    public Condominio(String nome, int larguraDisp, int areaDispAlt ) {
        this.nome = nome;
        this.larguraDisp = larguraDisp;
        this.alturaDisp = larguraDisp;
       }

    public Condominio() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getLarguraDisp() {
        return larguraDisp;
    }

    public void setLarguraDisp(int larguraDisp) {
        this.larguraDisp = larguraDisp;
    }

    public int getAlturaDisp() {
        return alturaDisp;
    }

    public void setAlturaDisp(int alturaDisp) {
        this.alturaDisp = alturaDisp;
    }

    public double getAreaTotal() {
          return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {

        this.areaTotal = areaTotal;
    }

    public void calculaArea(){
        this.areaTotal = larguraDisp * alturaDisp;
    }

}
