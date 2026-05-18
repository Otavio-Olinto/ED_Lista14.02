package controller;

import otavioolinto.Lista;
import model.Morador;

@SuppressWarnings("unchecked")
public class AcessoController {
	
	// Criando o vetor global do controle do prédio
	Lista<Morador>[] tabelaHashAndar;
	
	public AcessoController() {
		
		// O vetor de Listas foi criado como global
		// Porém seu tamanho é defido no construtor
		// Pois, caso queira, é possível altera-lo
		// Se passar o tamanho desejado pelo contrutor
		tabelaHashAndar = new Lista[10];
		
		// Como é um vetor de Listas, cada posição do vetor
		// possui uma Lista que está em NULL, ou seja,
		// Não foi iniciada. Então temos que iniciar
		// Cada a lista de cada posição uma a uma
		iniciarListas();
	}
	
	private void iniciarListas() {
		
		int tamanho = tabelaHashAndar.length;
		
		for(int cont=0; cont<tamanho; cont++) {
			
			// Inicializando lista por lista do nosso vetor
			tabelaHashAndar[cont] = new Lista<>(Morador.class);
		}
	}
	
	public void cadastrarMorador(Morador morador) throws Exception{
		
		// Cada morador mora em um andar, o qual determina o indice do nosso vetor
		int posicao = morador.hashCode();
		
		// Como estamos trabalhando com um vetor que tem uma lista em cada posição
		// Temos que chamar o nome e seu índice junto a função da lista que deseja usar
		tabelaHashAndar[posicao].addLast(morador);
	}
	
	public Morador cosultar(Morador ap) throws Exception {
		
		int posicao = ap.hashCode();
		int tamanho = tabelaHashAndar[posicao].size();
		
		if(tamanho==0) {
			
			throw new Exception ("Não há moradores neste apartamento");
		}
		
		for(int cont=0; cont<tamanho; cont++) {
			
			Morador morador = (Morador) tabelaHashAndar[posicao].get(cont);
			
			if(morador.apartamento==ap.apartamento && morador.placaCarro.equals(ap.placaCarro)) {
				
				ap = morador;
				break;
			}
		}
		
		if(ap.nome==null) {
			throw new Exception("Placa não cadastrada");
		}
		
		return ap;
	}
	
	public void excluirMorador(Morador remover) throws Exception {
		
		int posicao = remover.hashCode();
		int tamanho = tabelaHashAndar[posicao].size();
		
		for(int cont=0; cont<tamanho; cont++) {
			
			Morador morador = tabelaHashAndar[posicao].get(cont);
			
			if(remover.nome.equals(morador.nome)) {
				
				// Observe como o vetor de listas substitui o nome da lista para usar as funções
				// Isto é, ao invés de por listaA.remove(num)
				// é posto tabelaHashAndar[posica].removbe(num), pois cada posição ele retorna uma lista
				tabelaHashAndar[posicao].remove(cont);
				System.out.println("Morador: \n"+remover+"Excluído.\n\n");
				break;
			}
		}
	}
	
	public void listarMoradores(int andar)throws Exception {
		
		andar -= 1;
		
		int tamanho = tabelaHashAndar[andar].size();
		
		if(tamanho == 0) {
			
			throw new Exception ("Não há moradores neste andar");
		}
		
		for(int cont=0; cont<tamanho; cont++) {
			
			System.out.println(tabelaHashAndar[andar].get(cont)+"\n");
		}
	}

}
