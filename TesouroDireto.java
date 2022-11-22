package Corretora;

import java.util.ArrayList;
import java.util.Date;

public class TesouroDireto extends Investimento 
{
	private ArrayList<CompraTesouroDireto> compras = new ArrayList<>();
	
	public TesouroDireto(Carteira carteira, String nome) 
	{
		super(carteira, nome);
	}

	@Override
	public double CalculaImposto(double valor, int qtd, Date data) throws Exception
	{
		double imposto = 0;
		while (qtd > 0)
		{
			double menorImposto = -1;
			int menorImpostoIndex = -1;
			for (int n = 0; n < compras.size(); n++)
			{
				double lucroMarginal = valor - compras.get(n).valor;
				double impostoMarginal = lucroMarginal*compras.get(n).CalculaTaxaIR(data);

				if (menorImposto == -1 || impostoMarginal < menorImposto)
				{
					menorImposto = impostoMarginal;
					menorImpostoIndex = n;
				}
			}
			
			if (menorImpostoIndex == -1) 
				throw new Exception();
			
			imposto = menorImposto * min(qtd, compras.get(menorImpostoIndex).quantidade);
			if (qtd > compras.get(menorImpostoIndex).quantidade)
			{
				qtd -= compras.get(menorImpostoIndex).quantidade;
				compras.remove(menorImpostoIndex);
			}
			else
			{
				compras.get(menorImpostoIndex).quantidade -= qtd;
				qtd = 0;
			}

			menorImposto = -1;
			menorImpostoIndex = -1;
		}
		
		return imposto;
	}
	
	private int min(int a, int b)
	{
		if (a > b)
			return b;
		return a;
	}
	
	@Override
	public void AtualizarInvestimento(double valor, int qtd, Date data)
	{
		super.AtualizarInvestimento(valor, qtd, data);
		
		if (valor > 0)
			compras.add(new CompraTesouroDireto(nome, data, valor, qtd));
	}
}
