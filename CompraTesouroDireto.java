package Corretora;

import java.util.Date;

public class CompraTesouroDireto extends Compra
{
	public CompraTesouroDireto(String nome, Date data, double valor, int quantidade)
	{
		super(nome, data, valor, quantidade);
	}
	
	public double CalculaTaxaIR(Date data)
	{
		long dias = (data.getTime() - this.data.getTime()) / 86400000;
		
		if (dias < 180)
			return 0.225;
		
		if (dias < 360)
			return 0.2;
		
		if (dias < 720)
			return 0.175;
		
		return 0.15;
	}
}
