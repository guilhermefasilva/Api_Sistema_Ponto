package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.CategoriaUsuario;
import br.com.curso.sistemaPonto.repository.CategoriaUsuarioRepository;

@Service
public class CategoriaUsuarioService {

	private CategoriaUsuarioRepository categoriaUsuarioRepository;

	public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository) {
		this.categoriaUsuarioRepository = categoriaUsuarioRepository;
	}
	
	public CategoriaUsuario save(CategoriaUsuario categoriaUsuario) {
		return this.categoriaUsuarioRepository.save(categoriaUsuario);
	}
	
	public List<CategoriaUsuario> findAll(){
		return this.categoriaUsuarioRepository.findAll();
	}
	public Optional<CategoriaUsuario> getById(long idCategoriaUsuario){
		return this.categoriaUsuarioRepository.findById(idCategoriaUsuario);
	}
	
	public CategoriaUsuario update(CategoriaUsuario categoriaUsuario) {
		return this.categoriaUsuarioRepository.save(categoriaUsuario);
	}
	public void deleteById(long idCategoriaUsuario) {
		this.categoriaUsuarioRepository.deleteById(idCategoriaUsuario);
	}
	
	
}
