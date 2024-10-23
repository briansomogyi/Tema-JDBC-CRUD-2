package ro.emanuel.rubickscube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.DataBaseHelper;
import ro.emanuel.pojo.RubiksCube;

public class RubiksCubeDAO {
	public static RubiksCube getById(int id) throws SQLException {
		Connection connection = DataBaseHelper.getConnection();
		String query = "select * from rubiks_cube where id=?";
		PreparedStatement getRubiksCube = connection.prepareStatement(query);
		getRubiksCube.setInt(1, id);

		ResultSet resultSet = getRubiksCube.executeQuery();
		RubiksCube rubiksCube = null;
		if (resultSet.next())
			rubiksCube = new RubiksCube(resultSet.getInt("id"), resultSet.getString("brand"), resultSet.getDouble("weight"), resultSet.getInt("sides"));
		DataBaseHelper.closeConnection();
		return rubiksCube;
	}

	public static List<RubiksCube> getAll() throws SQLException {
		Connection connection = DataBaseHelper.getConnection();
		String query = "select * from rubiks_cube";
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
	
	public static String create (RubiksCube rubiksCube) throws SQLException {
		Connection connection = DataBaseHelper.getConnection();
		
		String query = "insert into rubiks_cube (brand, weight, sides) values (?, ?, ?)";
		PreparedStatement createRubiksCube = connection.prepareStatement(query);
		
		createRubiksCube.setString(1, rubiksCube.getBrand());
		createRubiksCube.setDouble(2, rubiksCube.getWeight());
		createRubiksCube.setInt(3, rubiksCube.getSides());
		int response = createRubiksCube.executeUpdate();
		DataBaseHelper.closeConnection();
		return response + " rows affected.";
	}
	
	public static String delete(int id) throws SQLException {
		Connection connection = DataBaseHelper.getConnection();
		
		String query = "delete from rubiks_cube where id>?";
		PreparedStatement deleteRubiksCube = connection.prepareStatement(query);
		
		deleteRubiksCube.setInt(1, id);
		
		int response = deleteRubiksCube.executeUpdate();
		DataBaseHelper.closeConnection();
		return response + " rows affected.";
	}
	
	public static String update(RubiksCube rubiksCube) throws SQLException {
		Connection connection = DataBaseHelper.getConnection();
		
		String query = "update rubiks_cube set brand=?, weight=?, sides=? where id=?";
		PreparedStatement updateRubiksCube = connection.prepareStatement(query);
		
		updateRubiksCube.setString(1, rubiksCube.getBrand());
		updateRubiksCube.setDouble(2, rubiksCube.getWeight());
		updateRubiksCube.setInt(3, rubiksCube.getSides());
		updateRubiksCube.setInt(4, rubiksCube.getId());
		
		int response = updateRubiksCube.executeUpdate();
		DataBaseHelper.closeConnection();
		return response + " rows affected.";
	}
}
