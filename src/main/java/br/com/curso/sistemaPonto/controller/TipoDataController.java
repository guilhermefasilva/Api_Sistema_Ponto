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

import br.com.curso.sistemaPonto.models.TipoData;
import br.com.curso.sistemaPonto.service.TipoDataService;

@RestController
@RequestMapping("/data")
public class TipoDataController {

	@Autowired
	private TipoDataService tipoDataService;
	
	@PostMapping
	public TipoData createData(@RequestBody TipoData tipoData) {
		return this.tipoDataService.save(tipoData);
	}
	
	@GetMapping
	public List<TipoData> getDataList(){
		return tipoDataService.findAll();
	}
	@GetMapping("/{idData}")
	public ResponseEntity<TipoData> getDataById(@PathVariable long idData) throws Exception{
		return ResponseEntity.ok(this.tipoDataService.getById(idData).orElseThrow(()-> new Exception("Id Não encontrado")));
	}
	
	@PutMapping
	public TipoData updateData(@RequestBody TipoData tipoData) {
		return this.tipoDataService.updateTipoData(tipoData);
	}
	
	@DeleteMapping("/{idData}")
	public ResponseEntity<TipoData> deleteDataById(long idData){

		try {
			this.tipoDataService.deleteTipoData(idData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return ResponseEntity.ok().build();
	}
}