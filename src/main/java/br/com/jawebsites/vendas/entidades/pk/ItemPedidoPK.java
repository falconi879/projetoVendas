package br.com.jawebsites.vendas.entidades.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.jawebsites.vendas.entidades.OrdemPedido;
import br.com.jawebsites.vendas.entidades.Produtos;

@Embeddable
public class ItemPedidoPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne  // muitos para um
	@JoinColumn(name = "produto_id") // nome do campo 
	private Produtos produto;
	
	@ManyToOne  // muitos para um
	@JoinColumn(name = "pedido_id") // nome do campo 
	private OrdemPedido pedido;
	
	public Produtos getProduto() {
		return produto;
	}
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	public OrdemPedido getPedido() {
		return pedido;
	}
	public void setPedido(OrdemPedido pedido) {
		this.pedido = pedido;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
}
