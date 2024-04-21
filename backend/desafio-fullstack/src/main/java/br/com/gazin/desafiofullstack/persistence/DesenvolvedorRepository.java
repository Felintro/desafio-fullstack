package br.com.gazin.desafiofullstack.persistence;

import br.com.gazin.desafiofullstack.model.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Integer> {

    @Query("SELECT d FROM Desenvolvedor d LEFT JOIN FETCH d.nivel WHERE d.id = ?1")
    Desenvolvedor findByIdFetchNivel(Integer id);

}