package br.com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.company.models.Colaborador;

@Repository
public interface ColaboradorDao extends JpaRepository<Colaborador, Integer> {

}
