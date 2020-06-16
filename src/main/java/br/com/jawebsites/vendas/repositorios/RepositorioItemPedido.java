package br.com.jawebsites.vendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jawebsites.vendas.entidades.ItemPedido;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido, Long> {

}


