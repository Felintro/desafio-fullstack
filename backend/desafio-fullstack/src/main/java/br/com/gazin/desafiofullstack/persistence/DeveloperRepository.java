package br.com.gazin.desafiofullstack.persistence;

import br.com.gazin.desafiofullstack.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

}