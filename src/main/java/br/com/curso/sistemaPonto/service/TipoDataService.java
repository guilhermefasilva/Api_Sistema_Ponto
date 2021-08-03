package br.com.curso.sistemaPonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.sistemaPonto.models.TipoData;
import br.com.curso.sistemaPonto.repository.TipoDataRespository;

@Service
public class TipoDataService {
	
	private TipoDataRespository tipoDataRespository;

	@Autowired
	public TipoDataService(TipoDataRespository tipoDataRespository) {
		this.tipoDataRespository = tipoDataRespository;
	}
	
	
	public TipoData save(TipoData tipodata) {
		return this.tipoDataRespository.save(tipodata);
	}
	
	public List<TipoData> findAll(){
		return this.tipoDataRespository.findAll();
	}
	
	public Optional<TipoData> getById(long idTipoData){
		return this.tipoDataRespository.findById(idTipoData);
	}
	
	public TipoData updateTipoData(TipoData tipoData) {
		return this.tipoDataRespository.save(tipoData);
	}

	public void deleteTipoData(long idTipoData) {
		this.tipoDataRespository.deleteById(idTipoData);
	}
	

}
