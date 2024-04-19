package br.com.gazin.desafiofullstack.persistence;

import br.com.gazin.desafiofullstack.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {

}