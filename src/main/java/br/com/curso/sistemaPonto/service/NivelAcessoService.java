package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.NivelAcesso;
import br.com.curso.sistemaPonto.repository.NivelAcessoRepository;

@Service
public class NivelAcessoService {
	
	private NivelAcessoRepository nivelAcessoRepository;

	@Autowired
	public NivelAcessoService(NivelAcessoRepository nivelAcessoRepository) {
		this.nivelAcessoRepository = nivelAcessoRepository;
	}

	public NivelAcesso save(NivelAcesso nivelAcesso) {
		return this.nivelAcessoRepository.save(nivelAcesso);
	}
	
	public List<NivelAcesso> findAll(){
		return this.nivelAcessoRepository.findAll();
	}

	public Optional<NivelAcesso> findById(long idNivelAcesso){
		return this.nivelAcessoRepository.findById(idNivelAcesso);
	}
	
	public NivelAcesso updateNivelAcesso(NivelAcesso nivelAcesso) {
		return this.save(nivelAcesso);
	}
	
	public void deleteNivelAcesso(long idNivelAcesso) {
		this.nivelAcessoRepository.deleteById(idNivelAcesso);
	}
		
}
	
	
	
