package application.model;

public class Beneficio {

	private String nome;
	private Plano plano;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	@Override
	public String toString() {
		return "Beneficio [nome=" + nome + ", plano=" + plano + "]";
	}

}
