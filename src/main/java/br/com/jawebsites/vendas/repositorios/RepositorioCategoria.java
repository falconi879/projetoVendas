package br.com.jawebsites.vendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jawebsites.vendas.entidades.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
