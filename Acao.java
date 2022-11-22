package Corretora;

import java.util.Date;

public class Acao extends Investimento {

	public Acao(Carteira carteira, String nome)
	{
		super(carteira, nome);
	}

	@Override
	public double CalculaImposto(double valor, int qtd, Date data)
	{
		double total = valor*qtd;
		double lucro = (valor - (valorTotal/quantidade)) * qtd;

		if (total > 20000.0 && lucro > 0.0)
			return lucro*0.15; // 15% de IR
		
		return 0.0;
	}
}
