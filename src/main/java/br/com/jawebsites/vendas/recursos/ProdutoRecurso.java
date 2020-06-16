package br.com.jawebsites.vendas.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jawebsites.vendas.entidades.Produtos;
import br.com.jawebsites.vendas.servicos.ServicoProduto;

@RestController
@RequestMapping(value = "/Produtos")  //nome recuso
public class ProdutoRecurso {
	
	@Autowired
	public ServicoProduto servicoProduto;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> retorno(){
		List<Produtos> listaProduto = servicoProduto.findAll();
		
		return ResponseEntity.ok().body(listaProduto);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produtos> findById(@PathVariable Long id){
		Produtos obj = servicoProduto.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
