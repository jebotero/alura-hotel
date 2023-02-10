package modelo;

import java.awt.GraphicsConfiguration;
import java.sql.Date;

public class Reserva {
		
		private Integer id;
		private Date FechaEntrada;
		private Date FechaSalida;
		private String Valor;
		private String Forma_pago;
		
		
		
		public Reserva(Date fechaEntrada, Date fechaSalida, String valor, String forma_pago) {
			super();
			FechaEntrada = fechaEntrada;
			FechaSalida = fechaSalida;
			Valor = valor;
			Forma_pago = forma_pago;
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Date getFechaEntrada() {
			return FechaEntrada;
		}
		public Date getFechaSalida() {
			return FechaSalida;
		}
		public String getValor() {
			return Valor;
		}
		public String getForma_pago() {
			return Forma_pago;
		}

		public GraphicsConfiguration getId_Reserva() {
			return null;
		}
		
}
