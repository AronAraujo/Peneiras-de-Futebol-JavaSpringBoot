package br.ifsp.edu.dsw3.aruan.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ifsp.edu.dsw3.aruan.model.dao.ClubeDAO;
import br.ifsp.edu.dsw3.aruan.model.dao.TreinadorDAO;
import br.ifsp.edu.dsw3.aruan.model.daomain.Clube;
import br.ifsp.edu.dsw3.aruan.model.daomain.Treinador;

@RestController
@RequestMapping("/clube")
public class ClubeController {

    @Autowired
    private ClubeDAO daoC;

    @Autowired
    private TreinadorDAO daoT;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarClube(@RequestParam("nome") String nome,
                                            @RequestParam("fundacao") LocalDate fundacao,
                                            @RequestParam("presidente") String presidente,
                                            @RequestParam("pais") String pais,
                                            @RequestParam("estado") String estado,
                                            @RequestParam("cidade") String cidade,
                                            @RequestParam("log") String log,
                                            @RequestParam("cep") int cep,
                                            @RequestParam("treinadorCpf") String treinadorCpf) {

        // Verificar se o treinador existe
        Treinador treinador = daoT.findByCpf(treinadorCpf);
        if (treinador == null) {
            // Retorna 404 se o treinador não for encontrado
            return ResponseEntity.notFound().build();
        }

        // Se o treinador existir, prossegue com o cadastro do clube
        Clube clube = new Clube(nome, fundacao, presidente, pais, estado, cidade, log, treinadorCpf, cep);
        Clube savedClube = daoC.save(clube);
        return ResponseEntity.ok(savedClube);
    }
    @GetMapping("/listar")
    public List<Clube> listar() {
        return daoC.findAll();
    }

    @GetMapping("/listar/nome/{nome}")
    public List<Clube> listarPorNome(@PathVariable("nome") String nome) {
        return daoC.findByNome(nome);
    }

    @DeleteMapping("/deletar/{id}")
    public Boolean remover(@PathVariable("id") Long id) {
        Optional<Clube> optionalClube = daoC.findById(id);
        if (optionalClube.isPresent()) {
            daoC.delete(optionalClube.get());
            return true;
        }
        return false;
    }
}
