package br.com.jawebsites.vendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jawebsites.vendas.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
