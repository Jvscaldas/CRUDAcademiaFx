package application.controller;

import application.model.Beneficio;

public class BeneficioBasico implements IBeneficio {

	@Override
	public String setBeneficio(Beneficio b) {

		if (b.getPlano() == b.getPlano().Basico) {
			b.setNome("Sem beneficio");
		}
		return b.getNome();
	}

	@Override
	public void nextBeneficio(Beneficio b) {
		b.setNome(setBeneficio(b));

		BeneficioGold bg = new BeneficioGold();
		bg.nextBeneficio(b);

	}

}
