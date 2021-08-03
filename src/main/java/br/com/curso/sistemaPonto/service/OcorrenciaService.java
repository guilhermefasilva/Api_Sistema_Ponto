package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.Ocorrencia;
import br.com.curso.sistemaPonto.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {
 
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
		this.ocorrenciaRepository = ocorrenciaRepository;
	}


	public Ocorrencia save(Ocorrencia ocorrencia) {
		return this.ocorrenciaRepository.save(ocorrencia);
	}
	
	public List<Ocorrencia>findAll(){
		return this.ocorrenciaRepository.findAll();
	}
	
	public Optional<Ocorrencia>getById(long idOcorrencia){
		return ocorrenciaRepository.findById(idOcorrencia);
		
	}
	
	public Ocorrencia updateOcorrencia(Ocorrencia ocorrencia) {
		return this.ocorrenciaRepository.save(ocorrencia);
	}
	
	public void deletarOcorrencia(long idOcorrencia) {
		this.ocorrenciaRepository.deleteById(idOcorrencia);
	}
	
	
}
