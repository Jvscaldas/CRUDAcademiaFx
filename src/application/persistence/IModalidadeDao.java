package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Modalidade;

public interface IModalidadeDao {

	public void insereModalidade(Modalidade m) throws SQLException;

	public void atualizaModalidade(Modalidade m) throws SQLException;

	public void excluiModalidade(Modalidade m) throws SQLException;

	public Modalidade consultaModalidade(Modalidade m) throws SQLException;

	public List<Modalidade> consultaModalidades() throws SQLException;

}
