package br.ifsp.edu.dsw3.aruan.model.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsp.edu.dsw3.aruan.model.daomain.Treinador;
import br.ifsp.edu.dsw3.aruan.model.daomain.Clube;;

public interface ClubeDAO extends JpaRepository <Clube, Long>{
        List<Clube> findByNome(String nome);
        List<Clube> findByTreinador(Treinador treinador);

} 
   
