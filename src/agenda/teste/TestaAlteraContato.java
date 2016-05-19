package agenda.teste;

import java.util.Calendar;

import agenda.exception.DaoException;
import agenda.jdbc.dao.ContatoDao;
import agenda.jdbc.modelo.Contato;

public class TestaAlteraContato {

	public static void main(String[] args) throws ClassNotFoundException, DaoException {

		ContatoDao dao = new ContatoDao();
		Contato contato = new Contato();
		
		contato.setNome("Novo");
		contato.setEmail("novo email");
		contato.setEndereco("novo endereço");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId((long) 1);
		dao.altera(contato);
	}

}
