package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.Usuario;
import br.com.curso.sistemaPonto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}
	
	public Optional<Usuario> getById(Long id){
		return this.usuarioRepository.findById(id);
	}
	
	public Usuario update(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	public void deletar(Long id) {
		this.usuarioRepository.deleteById(id);
	}

}
