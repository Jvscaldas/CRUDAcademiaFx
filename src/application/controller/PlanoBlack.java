package application.controller;

public class PlanoBlack implements IMensalidadeStrategy {

	@Override
	public void calcMensalidade() {
		double valorMensalidade = 150.00;
		double desconto = 0.05;
		
		valorMensalidade = valorMensalidade - (valorMensalidade * desconto);

		System.out.println("Valor mensalidade: " + valorMensalidade);
	}


}