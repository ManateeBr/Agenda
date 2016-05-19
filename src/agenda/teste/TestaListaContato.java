package agenda.teste;

import java.util.List;

import agenda.exception.DaoException;
import agenda.jdbc.dao.ContatoDao;
import agenda.jdbc.modelo.Contato;

public class TestaListaContato {

	public static void main(String[] args) throws ClassNotFoundException, DaoException {

		ContatoDao dao = new ContatoDao();
		
		List<Contato> contata = dao.getLista();
		
		for (Contato contato : contata) {
			System.out.println("Id: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("E-mail: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime());
			System.out.println("*******************************");
		}

		
	}

}
