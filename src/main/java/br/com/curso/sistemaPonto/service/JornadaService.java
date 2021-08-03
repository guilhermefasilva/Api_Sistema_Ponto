package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.JornadaTrabalho;
import br.com.curso.sistemaPonto.repository.JornadaRepository;

@Service
public class JornadaService {

	private JornadaRepository jornadaRepository;

	@Autowired
	public JornadaService(JornadaRepository jornadaRepository) {
		this.jornadaRepository = jornadaRepository;
	}
	
	public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
		return jornadaRepository.save(jornadaTrabalho);
	}
	
	public List<JornadaTrabalho> findAll(){
		return jornadaRepository.findAll();
		}

	public Optional<JornadaTrabalho> getById(long idJornada) {
		return jornadaRepository.findById(idJornada);
	}
	public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho) {
		return jornadaRepository.save(jornadaTrabalho);
	}
	
	public void deleteJornada(long idJornada) {
		jornadaRepository.deleteById(idJornada);
	}
}
