package br.com.jawebsites.vendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jawebsites.vendas.entidades.Produtos;
import br.com.jawebsites.vendas.repositorios.RepositorioProduto;

@Service
public class ServicoProduto {
	
	@Autowired
	public RepositorioProduto repositorioProduto;
	
	public List<Produtos> findAll() {
		return repositorioProduto.findAll();
	}
	public Produtos findById(Long id) {
		Optional<Produtos> obj = repositorioProduto.findById(id);
		return obj.get();		
	}
}
