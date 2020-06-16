package br.com.jawebsites.vendas.recursos;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jawebsites.vendas.entidades.Usuario;
import br.com.jawebsites.vendas.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/Usuarios")  //nome recuso
public class UsuarioRecurso {
	
	@Autowired
	private ServicoUsuario servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> retorno(){
		
		List<Usuario> listaUsuario = servico.findAll();
		
		return ResponseEntity.ok().body(listaUsuario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario cliente){
		cliente = servico.insert(cliente);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apaga(@PathVariable Long id){
		servico.apaga(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> alterar(@PathVariable Long id, Usuario obj){
		obj = servico.alterar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
