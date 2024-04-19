package br.com.gazin.desafiofullstack.persistence;

import br.com.gazin.desafiofullstack.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Integer> {

}