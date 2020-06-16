package br.com.jawebsites.vendas.entidades.enuns;

public enum StatusPedido {
	ESPERANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int code;
	
	//costrutor para tipo enumerado
	private StatusPedido(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public static StatusPedido valorS(int code) {
		for(StatusPedido valor : StatusPedido.values()) {
			if (valor.getCode()== code) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Status Invalido");
	}
	

}
