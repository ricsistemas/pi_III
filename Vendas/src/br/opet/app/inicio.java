package br.opet.app;

import br.opet.model.Clientes;
import br.opet.model.Enderecos;
import br.opet.model.Grupos;
import br.opet.model.Usuarios;
import br.opet.model.Pedidos;
import br.opet.model.Produtos;

public class inicio {
	public static void main(String[] args) {

		Clientes cli = new Clientes();

		Usuarios l = new Usuarios("rapo@gmail.com", "123456");
		Enderecos ende = new Enderecos();
		ende.setCep("829060-060");
		ende.setBairro("Cajuru");
		ende.setCidade("Curitiba");
		ende.setEstado("parana");
		ende.setNumero(100);
		ende.setLogradouro("SebastiãoMarcos Luiz");
		ende.setCompl("Conj 2 - sala 4");
		ende.setLocal("Trabalho");

		cli.setLogin(l);
		cli.setEndereco(ende);

		cli.setNome_completo("Ricardo");
		cli.setCpf("111212");

		if (cli.inserir()) {
			System.out.println("Cliente Incluido");
			System.out.println("Endereco Incluido");
			System.out.println("Usuario Incluido");

		} else
			System.err.println("Não foi");

		Grupos grup = new Grupos();
		grup.setDescricao("Vestuario");

		if (grup.Insert())
			System.out.println("Grupo Incluido");
		else
			System.err.println("Não foi");

		Produtos prod = new Produtos();
		prod.setGrupo(grup);

		prod.setDescricao("Camisa Masculina");
		prod.setCusto(5.50);
		prod.setPreco(7.70);
		prod.setQtd(10);

		if (prod.insert())
			System.out.println("Produto Incluido");
		else
			System.err.println("Não foi");

		Pedidos ped = new Pedidos();

	}

}
