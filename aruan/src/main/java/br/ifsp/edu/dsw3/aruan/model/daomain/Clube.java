package br.ifsp.edu.dsw3.aruan.model.daomain;
import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="clube")
public class Clube implements Serializable {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;
    private String presidente;
    private String pais;
    private String estado;
    private String cidade;
    private String log;

    @Column(nullable = false, columnDefinition = "DATE")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fundacao;

    private String treinador;

    private int cep;

    public Clube() {
    }
    public Clube(String nome, LocalDate fundacao, String presidente, String pais, String estado, String cidade, String log, String treinador, int cep) {
        this.nome = nome;
        this.fundacao = fundacao;
        this.presidente = presidente;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.log = log;
        this.treinador = treinador;
        this.cep = cep;
    }
    

}
