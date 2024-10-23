package ro.emanuel;

import java.util.List;

import ro.emanuel.pojo.RubiksCube;
import ro.emanuel.rubickscube.dao.RubiksCubeDAO;

public class Main {

	public static void main(String[] args) {
		try {
			// READ
			List<RubiksCube> rubiksCubes = RubiksCubeDAO.getAll();
			System.out.println(rubiksCubes);
			RubiksCube rubiksCube = RubiksCubeDAO.getById(1);
			System.out.println(rubiksCube);
			
			// CREATE
			int id = 0;
			String brand = "MoYu";
			double weight = 3.3;
			int sides = 6;
			rubiksCube = new RubiksCube(id, brand, weight, sides);
			String command = RubiksCubeDAO.create(rubiksCube);
			System.out.println(command);
			
			// READ
			rubiksCubes = RubiksCubeDAO.getAll();
			System.out.println(rubiksCubes);
			
			// UPDATE
			id = 1;
			rubiksCube = new RubiksCube(id, brand, weight, sides);
			command = RubiksCubeDAO.update(rubiksCube);
			System.out.println(command);
			
			// DELETE
			command = RubiksCubeDAO.delete(id);
			System.out.println(command);
						
			// READ
			rubiksCubes = RubiksCubeDAO.getAll();
			System.out.println(rubiksCubes);
									
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

}
