package br.ifsp.edu.dsw3.aruan.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.ifsp.edu.dsw3.aruan.model.dao.TreinadorDAO;
import br.ifsp.edu.dsw3.aruan.model.daomain.Treinador;;

@RestController
@RequestMapping("/treinador")
public class TreinadorController {

    @Autowired
    private TreinadorDAO dao;

    @PostMapping("/cadastrar")
    public Treinador cadastrar(@RequestParam("cpf") String cpf, 
                               @RequestParam("nome") String nome, 
                               @RequestParam("dataNasc") LocalDate dataNasc, 
                               @RequestParam("credencial") String credencial, 
                               @RequestParam("pais") String pais, 
                               @RequestParam("estado") String estado, 
                               @RequestParam("cidade") String cidade, 
                               @RequestParam("log") String log, 
                               @RequestParam("cep") int cep) {
        Treinador treinador = new Treinador(cpf, nome, dataNasc, credencial, pais, estado, cidade, log, cep);
        return dao.save(treinador);
    }

    @GetMapping("/listar")
    public List<Treinador> listar() {
        return dao.findAll();
    }

    @GetMapping("/pesquisar/{cpf}")
    public Treinador pesquisarPorCpf(@PathVariable("cpf") String cpf) {
        Optional<Treinador> treinador = dao.findById(cpf);
        return treinador.orElse(null);
    }

    

    @DeleteMapping("/deletar/{cpf}")
    public Boolean remover(@PathVariable("cpf") String cpf) {
        Optional<Treinador> optionalTreinador = dao.findById(cpf);
        if (optionalTreinador.isPresent()) {
            dao.delete(optionalTreinador.get());
            return true;
        }
        return false;
    }
}
