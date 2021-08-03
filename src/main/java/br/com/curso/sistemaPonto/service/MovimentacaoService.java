package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.Movimentacao;
import br.com.curso.sistemaPonto.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	
	public Movimentacao save(Movimentacao movimentacao) {
		return this.movimentacaoRepository.save(movimentacao);
	}
	
	public List<Movimentacao> findAll(){
		return this.movimentacaoRepository.findAll();
	}
	
	public Optional<Movimentacao> getById(Long id){
		return this.movimentacaoRepository.findById(id);
	}
	
	public Movimentacao update(Movimentacao movimentacao) {
		return this.movimentacaoRepository.save(movimentacao);
	}
	
	public void delete(Long id) {
		this.movimentacaoRepository.deleteById(id);
	}
	
	
}
