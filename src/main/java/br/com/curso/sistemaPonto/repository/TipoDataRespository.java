package br.com.curso.sistemaPonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.curso.sistemaPonto.models.TipoData;

@Repository
public interface TipoDataRespository extends JpaRepository<TipoData, Long>  {

}
