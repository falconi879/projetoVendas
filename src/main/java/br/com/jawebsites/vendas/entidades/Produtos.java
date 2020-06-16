package br.com.jawebsites.vendas.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_produto")
public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String descricao;
	private Double preco;
	private String urlImagem;
	
	
	
	@ManyToMany  // muitos para muitos
	@JoinTable (name = "tb_produto_categoria" ,	joinColumns = @JoinColumn(name = "produto_id"),inverseJoinColumns = @JoinColumn (name =  "categoria_id")) 
	private Set<Categoria> categorias = new HashSet<>();
	
	@OneToMany(mappedBy = "id.produto") // relacionamento 1 para muitos com id da classe Itempedido  
	private Set<ItemPedido> itens = new HashSet<>();
	public Produtos() {
	}

	public Produtos(Long id, String name, String descricao, Double preco, String urlImagem) {
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.preco = preco;
		this.urlImagem = urlImagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}
	@JsonIgnore
	public Set<OrdemPedido> getOrdemPedido(){
		Set<OrdemPedido> set = new HashSet<>(); //instacia os pedidos 
		for(ItemPedido x: itens) { // percorre para achar itens
			set.add(x.getPedido()); //adiciona nos pedidos  
		}
		return set; //retorna a lista  
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
