package application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@Column(name = "id_aluno")
	@NotNull
	private int id;
	
	@Column(name = "nome_aluno", length = 100)
	@NotNull
	private String nome;
	
	@Column(name = "email_aluno", length = 60)
	@NotNull
	private String email;
	
	@Column(name = "plano_aluno", length = 60)
	@NotNull
	private String plano;
	
	@ManyToOne(targetEntity = Modalidade.class)
	@JoinColumn(name = "id_modalidade")
	@NotNull
	private Modalidade modalidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", plano=" + plano + ", modalidade="
				+ modalidade + "]";
	}

}
