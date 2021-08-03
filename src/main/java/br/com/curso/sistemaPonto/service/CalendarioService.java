package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.Calendario;
import br.com.curso.sistemaPonto.repository.CalendarioRepository;

@Service
public class CalendarioService {
	
	@Autowired
	private CalendarioRepository calendarioRepository;
	
	
	
	public Calendario save(Calendario calendario) {
		return this.calendarioRepository.save(calendario);
	}
	
	public List<Calendario> findAll(){
		return this.calendarioRepository.findAll();
	}
	
	public Optional<Calendario> getById(Long id){
		return this.calendarioRepository.findById(id);
	}
	
	public Calendario update(Calendario calendario) {
		return this.calendarioRepository.save(calendario);
	}
	
	public void deletar(Long id) {
		this.calendarioRepository.deleteById(id);
	}

}
