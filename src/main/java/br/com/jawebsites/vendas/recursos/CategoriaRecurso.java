package br.com.jawebsites.vendas.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jawebsites.vendas.entidades.Categoria;
import br.com.jawebsites.vendas.servicos.ServicoCategoria;

@RestController
@RequestMapping(value = "/Categorias")  //nome recuso

public class CategoriaRecurso {

	@Autowired
	public ServicoCategoria servicoCategoria;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> retorno(){
		List<Categoria> listaCategoria = servicoCategoria.findAll();
		
		return ResponseEntity.ok().body(listaCategoria);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria obj = servicoCategoria.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
