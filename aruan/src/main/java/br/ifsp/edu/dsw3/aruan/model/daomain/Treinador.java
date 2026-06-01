

package br.ifsp.edu.dsw3.aruan.model.daomain;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "treinador")
public class Treinador implements Serializable {
    @Id
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_nasc", nullable = false, columnDefinition = "DATE")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataNasc;

    private String credencial;
    private String pais;
    private String estado;
    private String cidade;
    private String log;
    private int cep;

    public Treinador() {
    }

    public Treinador(String cpf, String nome, LocalDate dataNasc, String credencial, String pais, String estado, String cidade, String log, int cep) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.credencial = credencial;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.log = log;
        this.cep = cep;
    }
}
