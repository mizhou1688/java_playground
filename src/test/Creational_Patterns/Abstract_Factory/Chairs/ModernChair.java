package test.Creational_Patterns.Abstract_Factory.Chairs;

public class ModernChair implements Chair{
		int width;
		int heigth;
		int weight;
		String color;
		String meterial;
		int numberOfPeopleCanSitOn;
		
		final String style = "Modern";
		
		public ModernChair(int width, int heigth, int weight, String color, String meterial, int numberOfPeopleCanSitOn) {
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
		public int numberOfPeopleCanSitOn() {
			return numberOfPeopleCanSitOn;
		}

		@Override
		public String style() {
			return style;
		}

}

