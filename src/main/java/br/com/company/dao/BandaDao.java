package br.com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.company.models.Banda;

@Repository
public interface BandaDao extends JpaRepository<Banda, Integer> {

}
