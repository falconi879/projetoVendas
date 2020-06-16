package br.com.jawebsites.vendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jawebsites.vendas.entidades.Usuario;
import br.com.jawebsites.vendas.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;  
	
	public List<Usuario> findAll(){
		return repositorioUsuario.findAll();
		
	}
	public Usuario findById(Long id) { // função encontrar por ID findById
		Optional<Usuario> obj =  repositorioUsuario.findById(id);
		return obj.get();
		
	}
	public Usuario insert(Usuario cliente) {
		return repositorioUsuario.save(cliente);
	}
	public void apaga(Long id) {
		repositorioUsuario.deleteById(id);
	}
	public Usuario alterar(Long id, Usuario obj) {
		Usuario entidade = repositorioUsuario.getOne(id);
		alterarDados(entidade, obj);
		return repositorioUsuario.save(entidade);
	}
	private void alterarDados(Usuario entidade, Usuario obj) {
		entidade.getNome();
		entidade.getEmail();
		entidade.getFone();
		
	}
	
	

}
