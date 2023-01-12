/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author DAM2Alu10
 */
public class AccesoBBDD {
    private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String database = "baloncesto";
	private static String hostname = "localhost";
	private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database
			+ "?serverTimezone=Europe/Madrid";
	private static String username = "root";
	private static String password = "root";
	static ResultSet reg;
	private Connection conecta;

	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}

	public void desconectar() throws SQLException {
		if (conecta != null) {
			conecta.close();
		}
	}

	public ResultSet consulta(String localidad) throws SQLException {
		PreparedStatement consulta;
		String cadenaSQL = "SELECT * FROM socio ";
		if (localidad.isEmpty()) {
			consulta = conecta.prepareStatement(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} else {
			cadenaSQL = "SELECT * FROM socio  where localidad = ?";
			consulta = conecta.prepareStatement(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			consulta.setString(1, localidad);
		}

		ResultSet reg = consulta.executeQuery();
		return reg;
	}

	public ResultSet limpia() throws SQLException {
		PreparedStatement consulta;
		String cadenaSQL = "select * from socio where socioID=0";
		consulta = conecta.prepareStatement(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet reg = consulta.executeQuery();
		return reg;
	}

	public int nuevo(Socio socio) {
		try {
			String sql = "insert into socio values (((select max(socioID)from socio s)+1),?,?,?,?)";
			                 PreparedStatementdStatement inserta = conecta.prepareStatement(sql);
			inserta.setString(1, socio.getNombre());
			inserta.setInt(2, socio.getEstatura());
			inserta.setInt(3, socio.getEdad());
			inserta.setString(4, socio.getLocalidad());
			inserta.executeUpdate();
			return 1;
		} catch (SQLException e) {
			return e.getErrorCode();
		}
	}
}
