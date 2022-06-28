package application.controller;

import java.sql.SQLException;

public interface IModalidadeController {

	public void saveModalidade() throws SQLException;

	public void updateModalidade() throws SQLException;

	public void deleteModalidade() throws SQLException;

	public void findModalidade() throws SQLException;

	public void findAllModalidade() throws SQLException;

}