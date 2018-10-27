
import java.util.Scanner;

public class Saxophone extends WindInstruments {

	// --------------------------------------------------
	// Constructors

	public Saxophone(int price, String namecompany, String metal) {

		super(price, namecompany, metal);
		isMaterialGood();
	}

	public Saxophone(Scanner scanner) {
		super(scanner);
		isMaterialGood();

	}
	// --------------------------------------------------

	public void isMaterialGood() {// isMaterialGood made from metal only
		if (!(this.getmaterial().equalsIgnoreCase("Metal")))
			throw new IllegalArgumentException("\nSaxophones are made of metal only, NOT " + this.getmaterial());
	}

	@Override
	public boolean equals(Object m) {
		if (!(m instanceof Saxophone))
			return false;

		return super.equals(m);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
