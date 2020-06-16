package br.com.jawebsites.vendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jawebsites.vendas.entidades.OrdemPedido;

public interface RepositorioOrdemPedido extends JpaRepository<OrdemPedido, Long>{

}
