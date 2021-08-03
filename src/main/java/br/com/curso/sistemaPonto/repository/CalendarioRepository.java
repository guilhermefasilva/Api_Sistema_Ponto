package br.com.curso.sistemaPonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.curso.sistemaPonto.models.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {

}
