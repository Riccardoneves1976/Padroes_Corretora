package Corretora;

import java.text.ParseException;
import java.util.Scanner;

public class Corretora 
{
	Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws Exception
	{
		Corretora corretora = new Corretora();
		Carteira carteira = new Carteira();
		
		int n = 0;
		do
		{
			n = corretora.MostrarMenu();
			switch(n)
			{
			case 1:
				corretora.Depositar(carteira);
				break;
			case 2:
				corretora.Sacar(carteira);
				break;
			case 3:
				corretora.ComprarAcao(carteira);
				break;
			case 4:
				corretora.ComprarFundoImobiliario(carteira);
				break;
			case 5:
				corretora.ComprarTesouroDireto(carteira);
				break;
			case 6:
				corretora.Vender(carteira);
				break;
			case 7:
				System.out.printf("Saldo da carteira: R$ %1.2f\n", carteira.ConsultaSaldo());
				break;
			case 8:
				System.out.printf("Saldo de investimentos: R$ %1.2f\n", carteira.ConsultaInvestimentos());
				break;
			}
		}while (n != 0);

	}
	
	public void Depositar(Carteira carteira)
	{
		System.out.println("Digite o valor que deseja depositar ");
		
		carteira.Depositar(s.nextDouble());
	}
	
	public void Sacar(Carteira carteira)
	{
		System.out.println("Digite o valor que deseja sacar ");
		
		carteira.Sacar(s.nextDouble());
	}
	
	public void ComprarAcao(Carteira carteira) throws ParseException
	{
		Compra c = Compra.LerCompra(s);
		
		Investimento investimento = carteira.EncontraInvestimento(c.nome);
		if (investimento == null)
			investimento = new Acao(carteira, c.nome);
		
		investimento.Comprar(c.valor, c.quantidade, c.data);
	}
	
	public void ComprarFundoImobiliario(Carteira carteira) throws ParseException
	{
		Compra c = Compra.LerCompra(s);
		
		Investimento investimento = carteira.EncontraInvestimento(c.nome);
		if (investimento == null)
			investimento = new FundoImobiliario(carteira, c.nome);
		
		investimento.Comprar(c.valor, c.quantidade, c.data);
	}
	
	public void ComprarTesouroDireto(Carteira carteira) throws ParseException
	{
		Compra c = Compra.LerCompra(s);
		
		Investimento investimento = carteira.EncontraInvestimento(c.nome);
		if (investimento == null)
			investimento = new TesouroDireto(carteira, c.nome);
		
		investimento.Comprar(c.valor, c.quantidade, c.data);
	}
	
	public void Vender(Carteira carteira) throws Exception
	{
		Venda v = Venda.LerVenda(s);
		Investimento investimento = carteira.EncontraInvestimento(v.nome);
		if (investimento == null)
			throw new Exception();
		
		investimento.Vender(v.valor, v.quantidade, v.data);
	}
	
	public int MostrarMenu()
	{
		System.out.println("_________________MENU_______________");
		System.out.println("0 - Sair ");
		System.out.println("1 - Depositar ");
		System.out.println("2 - Sacar ");
		System.out.println("3 - Comprar Acao ");
		System.out.println("4 - Comprar Fundo Imobiliario ");
		System.out.println("5 - Comprar Tesouro Direto ");
		System.out.println("6 - Vender Investimento ");
		System.out.println("7 - Consultar Saldo");
		System.out.println("8 - Consultar Investimentos");
		
	    return s.nextInt();
	}
}
