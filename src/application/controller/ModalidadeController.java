package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Modalidade;
import application.persistence.ModalidadeDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ModalidadeController implements IModalidadeController {

	private ModalidadeDao mDao;
	private TextField tfModalidadeId;
	private TextField tfModalidadeNome;
	private TextField tfModalidadeDescricao;
	private TextArea taModalidadeLista;
	private String cmd;

	public ModalidadeController(ModalidadeDao mDao, TextField tfModalidadeId, TextField tfModalidadeNome,
			TextField tfModalidadeDescricao, TextArea taModalidadeLista, String cmd) {
		this.mDao = mDao;
		this.tfModalidadeId = tfModalidadeId;
		this.tfModalidadeNome = tfModalidadeNome;
		this.tfModalidadeDescricao = tfModalidadeDescricao;
		this.taModalidadeLista = taModalidadeLista;
		this.cmd = cmd;
	}

	public void saveModalidade() throws SQLException {
		Modalidade m = createModalidade(cmd);
		mDao.insereModalidade(m);
		clean();
	}

	@Override
	public void updateModalidade() throws SQLException {
		Modalidade m = createModalidade(cmd);
		mDao.atualizaModalidade(m);
		clean();
	}

	@Override
	public void deleteModalidade() throws SQLException {
		Modalidade m = createModalidade(cmd);
		mDao.excluiModalidade(m);
		clean();
	}

	@Override
	public void findModalidade() throws SQLException {
		Modalidade m = createModalidade(cmd);
		m = mDao.consultaModalidade(m);
		tfModalidadeId.setText(String.valueOf(m.getId()));
		tfModalidadeNome.setText(m.getNome());
		tfModalidadeDescricao.setText(m.getDescricao());
	}

	@Override
	public void findAllModalidade() throws SQLException {
		clean();
		List<Modalidade> consultaModalidades = mDao.consultaModalidades();
		StringBuffer buffer = new StringBuffer();
		for (Modalidade m : consultaModalidades) {
			buffer.append(m + "\n");
		}
		taModalidadeLista.setText(buffer.toString());
	}

	private Modalidade createModalidade(String cmd) {
		Modalidade m = new Modalidade();
		if (cmd.contains("Inserir") || cmd.contains("Atualizar")) {
			m.setId(Integer.parseInt(tfModalidadeId.getText()));
			m.setNome(tfModalidadeNome.getText());
			m.setDescricao(tfModalidadeDescricao.getText());
		}
		if (cmd.contains("Excluir") || cmd.contains("Buscar")) {
			m.setId(Integer.parseInt(tfModalidadeId.getText()));
		}
		return m;
	}

	private void clean() {
		tfModalidadeId.setText("");
		tfModalidadeNome.setText("");
		tfModalidadeDescricao.setText("");
		taModalidadeLista.setText("");
	}
}
