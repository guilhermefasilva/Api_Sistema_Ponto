package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.Empresa;
import br.com.curso.sistemaPonto.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	private EmpresaRepository empresaRepository;

	@Autowired
	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}
	
	public Empresa save(Empresa empresa) {
		return this.empresaRepository.save(empresa);
	}
	
	public List<Empresa> findAll(){
		return this.empresaRepository.findAll();
	}
	
	public Optional<Empresa> findById(long idEmpresa){
		return this.empresaRepository.findById(idEmpresa);
	}
	
	public Empresa update(Empresa empresa) {
		return this.empresaRepository.save(empresa);
	}
	
	public void delete(long idEmpresa) {
		this.empresaRepository.deleteById(idEmpresa);
	}
	
	

}
