package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservasController {
	private ReservaDAO reservaDAO;
	
	public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.reservaDAO = new ReservaDAO(connection);
	}
	
	public void guardar(Reserva reserva) {
		this.reservaDAO.guardar(reserva);
	}

	public void Eliminar(Integer valueOf) {
		
	}

	public List<Reserva> buscar() {
		return null;
	}

	public List<Reserva> buscarId(String text) {
		return null;
	}

	public void actualizar(Date FechaEntrada, Date FechaSalida, String Valor, String Forma_pago, Integer id) {
	}
}
