package br.com.jawebsites.vendas.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.jawebsites.vendas.entidades.enuns.StatusPedido;

@Entity
@Table(name = "tb_ordemPedido")
public class OrdemPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	private Integer status;
	
	@ManyToOne                               // relacionamento muitos para 1
	@JoinColumn(name = "usuario_id")         //identificador da chave estrangeira
	private Usuario usuario;
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)// para ficar p mesmo id
	private Pagamento pagamento;
	
	@OneToMany(mappedBy = "id.pedido") // relacionamento 1 para muitos com id da classe Itempedido  
	private Set<ItemPedido> itens = new HashSet<>();
	
	public OrdemPedido() {
		
	}

	public OrdemPedido(Long id, Instant momento,StatusPedido status, Usuario usuario) {
		this.id = id;
		this.momento = momento;
		setStatus(status);
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	public StatusPedido getStatus() {
		return StatusPedido.valorS(status);
	}

	public void setStatus(StatusPedido status) {
		if(status != null) {
			this.status = status.getCode();
		}	
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Set<ItemPedido> getItens(){
		return itens;
	}
	public Double getTotal() {
		Double soma = 0.00;
		for(ItemPedido x : itens) {
			soma = soma + x.getSubTotal();
		}
		return soma;
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
		OrdemPedido other = (OrdemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
		}
	}
