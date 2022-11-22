package Corretora;

import java.util.Date;

public class CompraVenda
{
	public Date data;
	public double valor;
	public int quantidade;
	public String nome;
	public CompraVenda(String nome, Date data, double valor, int quantidade)
	{
		this.nome = nome;
		this.data = data;
		this.valor = valor;
		this.quantidade = quantidade;
	}
}
