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

import br.com.curso.sistemaPonto.models.CategoriaUsuario;
import br.com.curso.sistemaPonto.service.CategoriaUsuarioService;

@RestController
@RequestMapping("/categoriaUsuario")
public class CategoriaUsuarioController {
	
	@Autowired
	private CategoriaUsuarioService categoriaUsuarioService;
	
	
	@PostMapping
	public CategoriaUsuario createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
		return this.categoriaUsuarioService.save(categoriaUsuario);
	}
	@GetMapping
	public List<CategoriaUsuario> getCategoriaUsuarios(){
		return this.categoriaUsuarioService.findAll();
	}
	
	@GetMapping("/{idCategoriaUsuario}")
	public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioById(@PathVariable long idCategoriaUsuario) throws Exception{
		return ResponseEntity.ok(this.categoriaUsuarioService.getById(idCategoriaUsuario)
				.orElseThrow(()-> new Exception("Id não encontrado")));
	}
	
	@PutMapping
	public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
		return this.categoriaUsuarioService.update(categoriaUsuario);
	}
	@DeleteMapping("/{idCategoriaUsuario}")
	public ResponseEntity<CategoriaUsuario> deleteCategoriaUsuario(@PathVariable long idCategoriaUsuario){
		
		try {
			this.categoriaUsuarioService.deleteById(idCategoriaUsuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}
	
	
}
