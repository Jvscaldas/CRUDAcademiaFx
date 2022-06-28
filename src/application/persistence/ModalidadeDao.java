package application.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import application.model.Modalidade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class ModalidadeDao implements IModalidadeDao {

	private SessionFactory sf;

	public ModalidadeDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insereModalidade(Modalidade m) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(m);
		transaction.commit();
	}

	@Override
	public void atualizaModalidade(Modalidade m) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(m);
		transaction.commit();
	}

	@Override
	public void excluiModalidade(Modalidade m) throws SQLException {
		String sql = "DELETE FROM Modalidade WHERE id_modalidade = ?";
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, m.getId());
		query.executeUpdate();
		transaction.commit();
	}

	@Override
	public Modalidade consultaModalidade(Modalidade m) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		m = entityManager.find(Modalidade.class, m.getId());
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Modalidade> consultaModalidades() throws SQLException {
		List<Modalidade> Modalidades = new ArrayList<Modalidade>();
		String sql = "SELECT id_modalidade, nome_modalidade, descricao_modalidade FROM modalidade";
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> listModalidades = query.getResultList();
		for (Object[] linha : listModalidades) {
			Modalidade m = new Modalidade();
			m.setId((int) linha[0]);
			m.setNome(linha[1].toString());
			m.setDescricao(linha[2].toString());

			Modalidades.add(m);
		}
		return Modalidades;
	}

}