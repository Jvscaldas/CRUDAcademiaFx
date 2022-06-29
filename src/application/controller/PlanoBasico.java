package application.controller;

public class PlanoBasico implements IMensalidadeStrategy {

	@Override
	public void calcMensalidade() {
		double valorMensalidade = 100.00;
		double desconto = 1.00;
		
		valorMensalidade = valorMensalidade * desconto;

		System.out.println("Valor mensalidade: " + valorMensalidade);
		
	}


}
