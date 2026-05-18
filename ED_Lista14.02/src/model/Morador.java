package model;

import java.util.Objects;

public class Morador {
	
	public String nome;
	public int apartamento;
	public String modeloCarro;
	public String placaCarro;
	public String corCarro;
	
	public Morador(String nome, int apt, String modelo, String placa, String cor) {
		
		this.nome = nome;
		this.apartamento = apt;
		this.modeloCarro = modelo;
		this.placaCarro = placa;
		this.corCarro = cor;
	}
	
	public String toString() {
		return "Morador: "+this.nome+" do apartamento de n°: "+this.apartamento+"\nCarro: "+this.modeloCarro+
				" cor: "+this.corCarro+" com a placa: "+this.placaCarro+"\n";
	}

	@Override
	public int hashCode() {
		int andar = (this.apartamento/100)-1;
		return andar;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Morador other = (Morador) obj;
		return apartamento == other.apartamento && Objects.equals(corCarro, other.corCarro)
				&& Objects.equals(modeloCarro, other.modeloCarro) && Objects.equals(nome, other.nome)
				&& Objects.equals(placaCarro, other.placaCarro);
	}
	
	
}
