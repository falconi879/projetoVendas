package br.com.jawebsites.vendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jawebsites.vendas.entidades.OrdemPedido;
import br.com.jawebsites.vendas.repositorios.RepositorioOrdemPedido;

@Service
public class ServicoOrdemPedido {
	
	@Autowired
	public RepositorioOrdemPedido repositorioOrdemPedido;
	
	public List<OrdemPedido> findAll() {
		return repositorioOrdemPedido.findAll();
	}
	public OrdemPedido findById(Long id) {
		Optional<OrdemPedido> obj = repositorioOrdemPedido.findById(id);
		return obj.get();		
	}
}
