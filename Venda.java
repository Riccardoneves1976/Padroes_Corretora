package Corretora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Venda extends CompraVenda
{
	public Venda(String nome, Date data, double valor, int quantidade)
	{
		super(nome, data, valor, quantidade);
	}
	
	public static Venda LerVenda(Scanner s) throws ParseException
	{
		System.out.println("Digite o nome do investimento: ");
		s.nextLine();
		String nome = s.nextLine();
		System.out.println("Digite a data do investimento: ");
		String data = s.nextLine();
		System.out.println("Digite o valor do investimento: ");
		double valor = s.nextDouble();
		System.out.println("Digite quantidade vendida: ");
		int qtd = s.nextInt();

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		return new Venda(nome, df.parse(data), valor, qtd);
	}
}
