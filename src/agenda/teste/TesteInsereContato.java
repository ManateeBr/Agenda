package agenda.teste;

import java.util.Calendar;

import agenda.exception.DaoException;
import agenda.jdbc.dao.ContatoDao;
import agenda.jdbc.modelo.Contato;

public class TesteInsereContato {

	public static void main(String[] args) throws ClassNotFoundException, DaoException {

		Contato c = new Contato();
		c.setNome("Sheila");
		c.setEmail("contato@");
		c.setEndereco("Av");
		c.setDataNascimento(Calendar.getInstance());

	
		ContatoDao dao = new ContatoDao();
		dao.adiciona(c);
		
		System.out.println("Contato gravado");
		
	}

}
