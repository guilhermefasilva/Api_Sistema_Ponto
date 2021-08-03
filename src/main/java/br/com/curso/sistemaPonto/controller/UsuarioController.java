package br.com.curso.sistemaPonto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.sistemaPonto.models.Usuario;
import br.com.curso.sistemaPonto.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> getUsuarioList(){
		return this.usuarioService.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable long id) throws Exception{
		return ResponseEntity.ok(this.usuarioService.getById(id).orElseThrow(()-> new Exception("Id Não encontrado")));
	}
	
	@PutMapping
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.update(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deleteUsuarioById(long id){

		try {
			this.usuarioService.deletar(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return ResponseEntity.ok().build();
	}
	
}
