package br.com.gazin.desafiofullstack.persistence;

import br.com.gazin.desafiofullstack.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

}