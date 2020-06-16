package br.com.jawebsites.vendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jawebsites.vendas.entidades.Produtos;

public interface RepositorioProduto extends JpaRepository<Produtos, Long> {

}
