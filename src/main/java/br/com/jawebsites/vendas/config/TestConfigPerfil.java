package br.com.jawebsites.vendas.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.jawebsites.vendas.entidades.Categoria;
import br.com.jawebsites.vendas.entidades.ItemPedido;
import br.com.jawebsites.vendas.entidades.OrdemPedido;
import br.com.jawebsites.vendas.entidades.Pagamento;
import br.com.jawebsites.vendas.entidades.Produtos;
import br.com.jawebsites.vendas.entidades.Usuario;
import br.com.jawebsites.vendas.entidades.enuns.StatusPedido;
import br.com.jawebsites.vendas.repositorios.RepositorioCategoria;
import br.com.jawebsites.vendas.repositorios.RepositorioItemPedido;
import br.com.jawebsites.vendas.repositorios.RepositorioOrdemPedido;
import br.com.jawebsites.vendas.repositorios.RepositorioProduto;
import br.com.jawebsites.vendas.repositorios.RepositorioUsuario;

@Configuration  // para informar o Spring que é uma classe de configuração
@Profile("test")// o nome do perfil da configuração 
public class TestConfigPerfil implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	@Autowired
	private RepositorioOrdemPedido repositorioPedido;
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	@Autowired
	private RepositorioProduto repositorioProduto;
	@Autowired
	private RepositorioItemPedido repositorioItemPedido;
	
	
	
	//para iniciar automaticamente  quando o programa for executado foi com implementação da interface CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletronico");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Acessórios");
		Categoria cat4 = new Categoria(null, "Domesticos");
		Categoria cat5 = new Categoria(null, "Diversos");
		
		Produtos produto1 = new Produtos(null, "TV 50 Polegadas", "Sansung", 2600.00,"");
		Produtos produto2 = new Produtos(null, "TV 40 Polegadas", "LG", 1600.00,"");
		Produtos produto3 = new Produtos(null, "Notbook", "Sansung", 1300.00,"");
		Produtos produto4 = new Produtos(null, "Mouse", "Lenovo", 35.12,"");
		Produtos produto5 = new Produtos(null, "Teclado", "Multilazer", 32.43,"");
		Produtos produto6 = new Produtos(null, "TV 20 Polegadas", "Sansung", 900.54,"");
		
		repositorioCategoria.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));	
		repositorioProduto.saveAll(Arrays.asList(produto1,produto2,produto3,produto4,produto5,produto6));
		
		produto1.getCategorias().add(cat1);
		produto1.getCategorias().add(cat4);
		produto2.getCategorias().add(cat1);
		produto2.getCategorias().add(cat4);
		produto3.getCategorias().add(cat1);
		produto4.getCategorias().add(cat5);
		produto5.getCategorias().add(cat5);
		produto6.getCategorias().add(cat3);
		
		repositorioProduto.saveAll(Arrays.asList(produto1,produto2,produto3,produto4,produto5,produto6));
		
		
		Usuario usu1 = new Usuario(null, "Andre Relhas Falconi", "falconi879@gmail.com", "999999-999", "12345");
		Usuario usu2 = new Usuario(null, "Monica Relhas Falconi", "monica@gmail.com", "88899-999", "12345");
		Usuario usu3 = new Usuario(null, "Izilda Relhas Falconi", "izilda@gmail.com", "777799-999", "12345");
		
		OrdemPedido pedido1 = new OrdemPedido(null, Instant.now(),StatusPedido.ENVIADO, usu1);
		OrdemPedido pedido2 = new OrdemPedido(null, Instant.parse("2020-05-17T12:00:00Z"),StatusPedido.ENTREGUE, usu2);
		OrdemPedido pedido3 = new OrdemPedido(null, Instant.parse("2020-05-17T12:00:00Z"),StatusPedido.ENVIADO, usu3);
		OrdemPedido pedido4 = new OrdemPedido(null, Instant.parse("2020-05-17T12:00:00Z"),StatusPedido.ESPERANDO_PAGAMENTO, usu2);
		OrdemPedido pedido5 = new OrdemPedido(null, Instant.parse("2020-05-17T12:00:00Z"),StatusPedido.PAGO, usu1);
		
		
		//para salvar no banco de dados
		repositorioUsuario.saveAll(Arrays.asList(usu1,usu2,usu3));
		repositorioPedido.saveAll(Arrays.asList(pedido1,pedido2,pedido3,pedido4,pedido5));
		
		ItemPedido item1 = new ItemPedido(pedido1, produto1, 2, produto1.getPreco());
		ItemPedido item2 = new ItemPedido(pedido1, produto2, 2, produto2.getPreco());
		ItemPedido item3 = new ItemPedido(pedido2, produto3, 1, produto2.getPreco());
		ItemPedido item4 = new ItemPedido(pedido5, produto4, 4, produto4.getPreco());
		ItemPedido item5 = new ItemPedido(pedido5, produto5, 3, produto5.getPreco());
		
		repositorioItemPedido.saveAll(Arrays.asList(item1,item2,item3,item4,item5));
		
		Pagamento pagamento1 = new Pagamento(null, Instant.parse("2020-05-17T14:00:00Z"), pedido5);
		pedido5.setPagamento(pagamento1);// nao usa o repositorio proprio
		repositorioPedido.save(pedido5);
	}
	 
}
