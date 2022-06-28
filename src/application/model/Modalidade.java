package application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "modalidade")
public class Modalidade {

	@Id
	@Column(name = "id_modalidade")
	@NotNull
	private int id;

	@Column(name = "nome_modalidade", length = 100)
	@NotNull
	private String nome;

	@Column(name = "descricao_modalidade", length = 300)
	@NotNull
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Modalidade [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

}
