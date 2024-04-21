package br.com.gazin.desafiofullstack.persistence;

import br.com.gazin.desafiofullstack.model.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Integer> {

}