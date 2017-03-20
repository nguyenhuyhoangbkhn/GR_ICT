package hust.edu.vn.rateict.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hust.edu.vn.rateict.model.Location;

public class LocationDaoImpl implements LocationDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Location> getAllLocation() {
		String sql = "SELECT * FROM LOCATION";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Location> locationList = new ArrayList<Location>();
			while (true) {
				if (rs.next()) {
					Location alocation = new Location(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
							rs.getInt("id_parent"), rs.getInt("flag_delete"));
					locationList.add(alocation);
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return locationList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
