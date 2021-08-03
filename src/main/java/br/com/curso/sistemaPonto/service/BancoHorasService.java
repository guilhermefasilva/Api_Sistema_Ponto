package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.BancoHoras;
import br.com.curso.sistemaPonto.repository.BancoHorasRepository;

@Service
public class BancoHorasService {
	
	@Autowired
	private BancoHorasRepository bancoHorasRepository;

	
	public BancoHoras save(BancoHoras bancoHoras) {
		return this.bancoHorasRepository.save(bancoHoras);
	}
	
	public List<BancoHoras> findAll(){
		return this.bancoHorasRepository.findAll();
	}
	
	public Optional<BancoHoras> getById(Long id){
		return this.bancoHorasRepository.findById(id);
	}
	
	public BancoHoras update(BancoHoras bancoHoras) {
		return this.bancoHorasRepository.save(bancoHoras);
	}
	
	public void deletar(Long id) {
		this.bancoHorasRepository.deleteById(id);
	}
}
