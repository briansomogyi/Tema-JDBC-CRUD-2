package ro.emanuel.rubickscube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.DataBaseHelper;
import ro.emanuel.pojo.RubiksCube;

public class RubiksCubeDAO {
	public static RubiksCube getById(int id) throws SQLException {
		Connection connection = DataBaseHelper.getConnection();
		String query = "SELECT * FROM rubiks_cube where id=?";
		PreparedStatement getRubiksCube = connection.prepareStatement(query);
		getRubiksCube.setInt(1, id);

		ResultSet resultSet = getRubiksCube.executeQuery();
		RubiksCube rubiksCube = null;
		if (resultSet.next())
			rubiksCube = new RubiksCube(resultSet.getInt("id"), resultSet.getString("brand"), resultSet.getDouble("weight"), resultSet.getInt("sides"));
		DataBaseHelper.closeConnection();
		if (rubiksCube != null)
			return rubiksCube;
		return null;
	}

	public static ArrayList<RubiksCube> getAll() throws SQLException {
		Connection connection = DataBaseHelper.getConnection();
		String query = "SELECT * FROM rubiks_cube";
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(query);
		ArrayList<RubiksCube> rubiksCubes = new ArrayList<RubiksCube>();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String brand = resultSet.getString("brand");
			double weight = resultSet.getDouble("weight");
			int sides = resultSet.getInt("sides");
			rubiksCubes.add(new RubiksCube(id, brand, weight, sides));
		}
		DataBaseHelper.closeConnection();
		return rubiksCubes;
	}
}
