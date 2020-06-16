package br.com.jawebsites.vendas.entidades;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.jawebsites.vendas.entidades.pk.ItemPedidoPK;

@Entity
@Table(name = "tb_pedido_produto")
public class ItemPedido {

	@EmbeddedId 
	private ItemPedidoPK id = new ItemPedidoPK(); // atributo identificador (chave primaria)
	
	private Integer qtd;
	private Double preco;
	
	public ItemPedido() {
	}

	public ItemPedido(OrdemPedido pedido, Produtos produto,Integer qtd, Double preco) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.qtd = qtd;
		this.preco = preco;
		
	}
	@JsonIgnore
	public OrdemPedido getPedido() {
		return id.getPedido();
	}
	public void setPedido(OrdemPedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produtos getProduto() {
		return id.getProduto();
	}
	public void setProduto(Produtos produto) {
		id.setProduto(produto);
	}
	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Double getSubTotal() {
		return preco*qtd;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
