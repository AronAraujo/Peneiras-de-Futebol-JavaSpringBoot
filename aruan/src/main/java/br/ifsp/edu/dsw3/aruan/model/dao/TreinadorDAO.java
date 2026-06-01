package br.ifsp.edu.dsw3.aruan.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import br.ifsp.edu.dsw3.aruan.model.daomain.Treinador;;

public interface TreinadorDAO extends JpaRepository <Treinador, String>{
    Treinador findByCpf(String cpf);
} 
