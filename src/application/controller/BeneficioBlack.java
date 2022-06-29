package application.controller;

import application.model.Beneficio;

public class BeneficioBlack implements IBeneficio {

	@Override
	public String setBeneficio(Beneficio b) {

		if (b.getPlano() == b.getPlano().Black) {
			b.setNome("Armários e massagem");
		}
		return b.getNome();
	}

	@Override
	public void nextBeneficio(Beneficio b) {
		b.setNome(setBeneficio(b));

	}
}
