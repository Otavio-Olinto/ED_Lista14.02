package view;

import controller.AcessoController;
import model.Morador;

public class Principal {

	public static void main(String[] args) {
		// Criando os moradores
		Morador morador1 = new Morador("Sandra", 201,"Onix", "1234-ABC", "Azul");
		Morador morador2 = new Morador("Pedro", 1003,"Onix", "9467-XHC", "Preto");
		Morador morador3 = new Morador("Alves", 1001,"Onix", "9273-KSN", "Amarelo");
		Morador morador4 = new Morador("Cabral", 503,"Onix", "3901-LDN", "Vermelho");
		Morador morador5 = new Morador("AnoNovo", 501,"Onix", "3528-LAE", "Branco");
		Morador morador6 = new Morador("Cinthia", 501,"Sharpedo", "8173-DRK", "Crespúsculo");
		
		// Importando a Tabela Hash Andar
		AcessoController acesso = new AcessoController();
		
		try {
			
			acesso.cadastrarMorador(morador5);
			acesso.cadastrarMorador(morador4);
			acesso.cadastrarMorador(morador3);
			acesso.cadastrarMorador(morador2);
			acesso.cadastrarMorador(morador1);
			acesso.cadastrarMorador(morador6);
			
			acesso.listarMoradores(5);
			
			acesso.excluirMorador(morador5);
			
			acesso.listarMoradores(5);
			
		}catch(Exception exc) {
			
			System.err.println(exc.getMessage());
		}
	}

}
