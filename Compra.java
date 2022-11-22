package Corretora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Compra extends CompraVenda
{
	public Compra(String nome, Date data, double valor, int quantidade)
	{
		super(nome, data, valor, quantidade);
	}
	
	public static Compra LerCompra(Scanner s) throws ParseException
	{
		System.out.printf("Digite o nome do investimento: ");
		s.nextLine();
		String nome = s.nextLine();
		System.out.printf("Digite a data do investimento: ");
		String data = s.nextLine();
		System.out.printf("Digite o valor do investimento: ");
		double valor = s.nextDouble();
		System.out.printf("Digite quantidade comprada: ");
		int qtd = s.nextInt();

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		return new Compra(nome, df.parse(data), valor, qtd);
	}
}
