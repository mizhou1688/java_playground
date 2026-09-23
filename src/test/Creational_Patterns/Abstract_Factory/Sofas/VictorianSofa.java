package test.Creational_Patterns.Abstract_Factory.Sofas;

public class VictorianSofa implements Sofa {
	int width;
	int heigth;
	int weight;
	String color;
	String meterial;
	int numberOfPeopleCanSitOn;

	final String style = "Victorian";
	
	public VictorianSofa(int width, int heigth, int weight, String color, String meterial, int numberOfPeopleCanSitOn) {
		this.width = width;
		this.heigth = heigth;
		this.weight = weight;
		this.color = color;
		this.meterial = meterial;
		this.numberOfPeopleCanSitOn = numberOfPeopleCanSitOn;
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
	public boolean hasLegs() {
		return hasLegs;
	}

	@Override
	public boolean sitOn() {
		return sitOn;
	}

	@Override
	public int numberOfPeopleCanSitOn() {
		return numberOfPeopleCanSitOn;
	}

	@Override
	public String style() {
		return style;
	}

}
