package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Reserva;

public class ReservaDAO {

	private Connection connection;
	
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void guardar(Reserva reserva) {
		String sql = "INSERT INTO reservas (FechaEntrada, FechaSalida, Valor, Forma_pago)"
				+ "VALUE(?,?,?,?)";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setDate(1, reserva.getFechaEntrada());
			pstm.setDate(2, reserva.getFechaSalida());
			pstm.setString(3, reserva.getValor());
			pstm.setString(4, reserva.getForma_pago());
			
			pstm.executeUpdate();
			
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next())
					reserva.setId(rst.getInt(1));
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		} catch (Exception e) {
			
		}
	}
}
