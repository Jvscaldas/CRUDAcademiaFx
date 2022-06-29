package application.controller;

import application.model.Beneficio;

public class BeneficioGold implements IBeneficio {

	@Override
	public String setBeneficio(Beneficio b) {

		if (b.getPlano() == b.getPlano().Gold) {
			b.setNome("Armários");
		}
		return b.getNome();
	}

	@Override
	public void nextBeneficio(Beneficio b) {
		b.setNome(setBeneficio(b));

		BeneficioBlack bbl = new BeneficioBlack();
		bbl.nextBeneficio(b);

	}

}
