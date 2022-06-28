package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.SQLException;

import org.hibernate.SessionFactory;

import application.persistence.AlunoDao;
import application.persistence.ModalidadeDao;
import application.util.HibernateUtil;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class MainController {
	@FXML
	private TextField tfModalidadeId;
	@FXML
	private TextField tfModalidadeNome;
	@FXML
	private TextField tfModalidadeDescricao;
	@FXML
	private Button btnModalidadeInserir;
	@FXML
	private Button btnModalidadeAtualizar;
	@FXML
	private Button btnModalidadeExcluir;
	@FXML
	private Button btnModalidadeListar;
	@FXML
	private Button btnModalidadeBuscar;
	@FXML
	private TextArea taModalidadeLista;
	@FXML
	private TextField tfAlunoId;
	@FXML
	private TextField tfAlunoNome;
	@FXML
	private TextField tfAlunoEmail;
	@FXML
	private TextField tfAlunoPlano;
	@FXML
	private Button btnAlunoInserir;
	@FXML
	private Button btnAlunoAtualizar;
	@FXML
	private Button btnAlunoExcluir;
	@FXML
	private Button btnAlunoListar;
	@FXML
	private Button btnAlunoBuscar;
	@FXML
	private TextField tfAlunoModalidade;
	@FXML
	private TextArea taAlunoLista;

	// Event Listener on Button[#btnModalidadeInserir].onAction
	@FXML
	public void acaoModalidade(ActionEvent event) {
		String cmd = event.getSource().toString();

		SessionFactory sf = HibernateUtil.getSessionFactory();
		ModalidadeDao mDao = new ModalidadeDao(sf);
		IModalidadeController mCont = new ModalidadeController(mDao, tfModalidadeId, tfModalidadeNome,
				tfModalidadeDescricao, taModalidadeLista, cmd);

		try {
			if (cmd.contains("Inserir")) {
				mCont.saveModalidade();
			}
			if (cmd.contains("Atualizar")) {
				mCont.updateModalidade();
			}
			if (cmd.contains("Excluir")) {
				mCont.deleteModalidade();
			}
			if (cmd.contains("Buscar")) {
				mCont.findModalidade();
			}
			if (cmd.contains("Listar")) {
				mCont.findAllModalidade();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnAlunoInserir].onAction
	@FXML
	public void acaoAluno(ActionEvent event) {
		String cmd = event.getSource().toString();

		SessionFactory sf = HibernateUtil.getSessionFactory();
		AlunoDao alDao = new AlunoDao(sf);
		IAlunoController alCont = new AlunoController(alDao, tfAlunoId, tfAlunoNome, tfAlunoEmail, tfAlunoPlano,
				tfAlunoModalidade, taAlunoLista, cmd);

		try {
			if (cmd.contains("Inserir")) {
				alCont.saveAluno();
			}
			if (cmd.contains("Atualizar")) {
				alCont.updateAluno();
			}
			if (cmd.contains("Excluir")) {
				alCont.deleteAluno();
			}
			if (cmd.contains("Buscar")) {
				alCont.findAluno();
			}
			if (cmd.contains("Listar")) {
				alCont.findAllAluno();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
