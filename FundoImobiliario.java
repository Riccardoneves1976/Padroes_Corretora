package Corretora;

import java.util.Date;

public class FundoImobiliario extends Investimento 
{
	public FundoImobiliario(Carteira carteira, String nome) 
	{
		super(carteira, nome);
	}

	@Override
	public double CalculaImposto(double valor, int qtd, Date data)
	{
		double lucro = (valor - (valorTotal/quantidade)) * qtd;
		System.out.printf("lucro: %1.2f\n", lucro);

		if (lucro > 0.0)
			return lucro*0.20; // 20% de IR
		
		return 0.0;
	}
}
