package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Aluno;
import application.model.Modalidade;
import application.persistence.AlunoDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlunoController implements IAlunoController {

	private AlunoDao alDao;
	private TextField tfAlunoId;
	private TextField tfAlunoNome;
	private TextField tfAlunoEmail;
	private TextField tfAlunoPlano;
	private TextField tfAlunoModalidade;
	private TextArea taAlunoLista;
	private String cmd;

	public AlunoController(AlunoDao alDao, TextField tfAlunoId, TextField tfAlunoNome, TextField tfAlunoEmail,
			TextField tfAlunoPlano, TextField tfAlunoModalidade, TextArea taAlunoLista, String cmd) {
		this.alDao = alDao;
		this.tfAlunoId = tfAlunoId;
		this.tfAlunoNome = tfAlunoNome;
		this.tfAlunoEmail = tfAlunoEmail;
		this.tfAlunoPlano = tfAlunoPlano;
		this.tfAlunoModalidade = tfAlunoModalidade;
		this.taAlunoLista = taAlunoLista;
		this.cmd = cmd;
	}

	@Override
	public void saveAluno() throws SQLException {
		Aluno al = createAluno();
		alDao.insereAluno(al);
		clean();
	}

	@Override
	public void findAluno() throws SQLException {
		Aluno al = createAluno();
		al = alDao.consultaAluno(al);
		tfAlunoId.setText(String.valueOf(al.getId()));
		tfAlunoNome.setText(al.getNome());
		tfAlunoEmail.setText(al.getEmail());
		tfAlunoPlano.setText(al.getPlano());
		tfAlunoModalidade.setText(String.valueOf(al.getModalidade().getId()));
	}

	@Override
	public void findAllAluno() throws SQLException {
		clean();
		List<Aluno> consultaModalidades = alDao.consultaAlunos();
		StringBuffer buffer = new StringBuffer();
		for (Aluno al : consultaModalidades) {
			buffer.append(al + "\n");
		}
		taAlunoLista.setText(buffer.toString());
	}

	@Override
	public void updateAluno() throws SQLException {
		Aluno al = createAluno();
		alDao.atualizaAluno(al);
		clean();
	}

	@Override
	public void deleteAluno() throws SQLException {
		Aluno al = createAluno();
		alDao.excluiAluno(al);
		clean();
	}

	private Aluno createAluno() {
		Aluno al = new Aluno();
		if (cmd.contains("Inserir") || cmd.contains("Atualizar")) {
			al.setId(Integer.parseInt(tfAlunoId.getText()));
			al.setNome(tfAlunoNome.getText());
			al.setEmail(tfAlunoEmail.getText());
			al.setPlano(tfAlunoPlano.getText());

			Modalidade m = new Modalidade();
			m.setId(Integer.parseInt(tfAlunoModalidade.getText()));

			al.setModalidade(m);
		}
		if (cmd.contains("Excluir") || cmd.contains("Buscar")) {
			al.setId(Integer.parseInt(tfAlunoId.getText()));
		}

		return al;
	}

	private void clean() {
		tfAlunoId.setText("");
		tfAlunoNome.setText("");
		tfAlunoEmail.setText("");
		tfAlunoPlano.setText("");
		tfAlunoModalidade.setText("");
		taAlunoLista.setText("");
	}
}