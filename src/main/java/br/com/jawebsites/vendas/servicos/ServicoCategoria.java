package br.com.jawebsites.vendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jawebsites.vendas.entidades.Categoria;
import br.com.jawebsites.vendas.repositorios.RepositorioCategoria;

@Service
public class ServicoCategoria {
	@Autowired
	public RepositorioCategoria repositorioCategoria;
	
	public List<Categoria> findAll() {
		return repositorioCategoria.findAll();
	}
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorioCategoria.findById(id);
		return obj.get();		
	}
}
