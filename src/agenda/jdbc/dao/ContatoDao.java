package agenda.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import agenda.exception.DaoException;
import agenda.jdbc.ConnectionFactory;
import agenda.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() throws ClassNotFoundException, DaoException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) throws DaoException {

		String sql = "INSERT INTO agenda_contatos (nome,email,endereco,dataNascimento) VALUES (?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			throw new DaoException("Erro ao cadastrar contato", e);
		}
	}

	public List<Contato> getLista() throws DaoException {
		
		String sql = "SELECT * FROM agenda_contatos";
		
		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Contato> contatos = new ArrayList<Contato>();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				Date bornDate = rs.getDate("dataNascimento");
				data.setTime(new Date(bornDate.getTime()));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;

		} catch (Exception e) {
			throw new DaoException("Erro ao listar contatos", e);
		}
	}

	public void altera(Contato contato) throws DaoException  {
	
		String sql = "update agenda_contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
	
		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new DaoException("Erro ao alterar contato",e);
		}
	}

	public void exclui(Contato contato) throws DaoException  {
	
		String sql = "DELETE FROM agenda_contatos WHERE id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new DaoException("Erro ao excluir contato",e);
		}
	}
}