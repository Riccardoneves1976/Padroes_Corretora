package Corretora;

import java.util.Date;

public abstract class Investimento 
{
	protected Carteira carteira;
	protected double valorTotal;
	protected double quantidade;
	protected String nome;
	
	public Investimento(Carteira carteira, String nome)
	{
		this.carteira = carteira;
		this.nome = nome;
		this.valorTotal = 0.0;
		this.quantidade = 0.0;
		carteira.Investir(this);
	}
	
	public String Nome()
	{
		return nome;
	}
	
	public double ValorTotal()
	{
		return valorTotal;
	}
	
	public void Comprar(double valor, int qtd, Date data)
	{
		AtualizarCarteira(-valor*qtd);
		AtualizarInvestimento(valor, qtd, data);
	}
	
	public void Vender(double valor, int qtd, Date data) throws Exception
	{
		double imposto = CalculaImposto(valor, qtd, data);
		System.out.printf("Imposto pago R$ %1.2f\n", imposto);
		AtualizarInvestimento(-valor, qtd, data);
		AtualizarCarteira(valor*qtd - imposto);
	}
	
	public void ReceberDividendos(double valor)
	{
		AtualizarCarteira(valor*quantidade);
	}
	
	public void AtualizarInvestimento(double valor, int qtd, Date data)
	{
		if (valor > 0)
		{
			quantidade += qtd;
			valorTotal += valor*qtd;
		}
		else
		{
			valorTotal -= (valorTotal/quantidade)*qtd;
			quantidade -= qtd;
		}
	}
	
	public void AtualizarCarteira(double valorTotal)
	{
		if (valorTotal > 0.0)
			carteira.Depositar(valorTotal);
		else
			carteira.Sacar(-valorTotal);
	}
	public abstract double CalculaImposto(double valor, int qtd, Date data) throws Exception;
}
