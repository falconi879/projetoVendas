package br.com.jawebsites.vendas.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jawebsites.vendas.entidades.OrdemPedido;
import br.com.jawebsites.vendas.servicos.ServicoOrdemPedido;

@RestController
@RequestMapping(value = "/Pedidos")  //nome recuso
public class OrdemPedidoRecurso {

	@Autowired
	public ServicoOrdemPedido servicoPedido;
	
	@GetMapping
	public ResponseEntity<List<OrdemPedido>> retorno(){
		List<OrdemPedido> listaPedido = servicoPedido.findAll();
		
		return ResponseEntity.ok().body(listaPedido);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdemPedido> findById(@PathVariable Long id){
		OrdemPedido obj = servicoPedido.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
