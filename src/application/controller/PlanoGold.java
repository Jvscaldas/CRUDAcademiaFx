package application.controller;

public class PlanoGold implements IMensalidadeStrategy {

	@Override
	public void calcMensalidade() {
		double valorMensalidade = 130.00;
		double desconto = 0.1;

		valorMensalidade = valorMensalidade - (valorMensalidade * desconto);

		System.out.println("Valor mensalidade: " + valorMensalidade);

	}

}
