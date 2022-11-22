package Corretora;

import java.util.ArrayList;

public class Carteira 
{
	private double saldo;
	private ArrayList<Investimento> investimentos = new ArrayList<>();
	
	public Carteira()
	{
		this.saldo = 0;
	}
	
	public void Depositar(double valor)
	{
		saldo += valor;
	}
	
	public void Sacar(double valor)
	{
		saldo -= valor;
	}
	
	public void Investir(Investimento investimento)
	{
		investimentos.add(investimento);
	}
	
	public double ConsultaInvestimentos()
	{
		double total = 0;
		
		for (Integer n = 0; n < investimentos.size(); n++)
		{
			total += investimentos.get(n).ValorTotal();
		}
		
		return total;
	}
	
	public double ConsultaSaldo()
	{
		return saldo;
	}
	
	Investimento EncontraInvestimento(String nome)
	{
		for (int n = 0; n < investimentos.size(); n++)
		{
			if (investimentos.get(n).nome.compareTo(nome) == 0)
				return investimentos.get(n);
		}
		return null;
	}
}
