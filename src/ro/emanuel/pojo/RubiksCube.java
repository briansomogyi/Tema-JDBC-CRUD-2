package ro.emanuel.pojo;

public class RubiksCube {
	private int id;
	private String brand;
	private double weight;
	private int sides;
	private RubiksCube(String brand, double weight, int sides) {
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
	}
	public RubiksCube(int id, String brand, double weight, int sides) {
		this(brand, weight, sides);
		this.setId(id);
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	@Override
	public String toString() {
		return "RubiksCube [brand=" + brand + ", weight=" + weight + ", sides=" + sides + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
