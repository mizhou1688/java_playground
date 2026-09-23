package test.Creational_Patterns.Abstract_Factory.CoffeeTables;

public class ModernCoffeeTable implements CoffeeTable {

	int width;
	int heigth;
	int weight;
	String color;
	String meterial;
	final String style = "Modern";
	
	public ModernCoffeeTable(int width, int heigth, int weight, String color, String meterial) {
		this.width = width;
		this.heigth = heigth;
		this.weight = weight;
		this.color = color;
		this.meterial = meterial;
	}

	@Override
	public int width() {
		return width;
	}

	@Override
	public int heigth() {
		return heigth;
	}

	@Override
	public int weight() {
		return weight;
	}

	@Override
	public String color() {
		return color;
	}

	@Override
	public String meterial() {
		return meterial;
	}

	@Override
	public String style() {
		return style;
	}

}
