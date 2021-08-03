package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.Localidade;
import br.com.curso.sistemaPonto.repository.LocalidadadeRepository;

@Service
public class LocalidadeService {
	
	@Autowired
	private LocalidadadeRepository localidadadeRepository;
	
	
	public Localidade save(Localidade localidade) {
		return this.localidadadeRepository.save(localidade);
	}
	
	public List<Localidade> findAll(){
		return this.localidadadeRepository.findAll();
	}
	
	public Optional<Localidade> getById(Long id){
		return this.localidadadeRepository.findById(id);
	}
	
	public Localidade update(Localidade localidade) {
		return this.localidadadeRepository.save(localidade);
	}

	public void deletar(Long id) {
		this.localidadadeRepository.deleteById(id);
	}
}
