package agenda.teste;

import agenda.exception.DaoException;
import agenda.jdbc.dao.ContatoDao;
import agenda.jdbc.modelo.Contato;

public class TesteRemove {

	public static void main(String[] args) throws ClassNotFoundException, DaoException {

		ContatoDao dao = new ContatoDao();
		Contato contato = new Contato();
		contato.setId((long) 1);
		dao.exclui(contato);
	}

}
