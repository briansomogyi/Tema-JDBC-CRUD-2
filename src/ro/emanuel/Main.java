package ro.emanuel;

import ro.emanuel.pojo.RubiksCube;
import ro.emanuel.rubickscube.dao.RubiksCubeDAO;

public class Main {

	public static void main(String[] args) {
		try {
			RubiksCube rubiksCube = RubiksCubeDAO.getById(1);
			System.out.println(rubiksCube);
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

}
