
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WindInstruments extends MusicalInstrument {
	final private String[] materials = { "Wood", "Metal", "Plastic" };
	private String material;

	// -------------------------------------------------
	// Constructors

	public WindInstruments(int price, String namecompany, String kindmetal) {
		super(price, namecompany);
		setmaterial(kindmetal);
	}

	public WindInstruments(Scanner scanner) {
		super(scanner);
		try {
			setmaterial(scanner.next());
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException(
					"\ncorrupted file, some details of " + getClass().getSimpleName() + " are missing");
		}

	}

	// -------------------------------------------------
	@Override
	public boolean equals(Object m) {
		if (!(m instanceof WindInstruments))
			return false;

		if (!((WindInstruments) m).getmaterial().equalsIgnoreCase(this.getmaterial()))
			return false;

		return super.equals(m);
	}

	public String getmaterial() {
		return material;
	}

	public void setmaterial(String material) {// set material by checking first

		for (int i = 0; i < materials.length; i++)
			if (materials[i].equalsIgnoreCase(material))
				this.material = material;
		if (this.material == null)
			throw new IllegalArgumentException("\ninvalid type material for wind instruments " + material);

	}

	@Override
	public String toString() {
		return super.toString() + String.format(", Made of: %11s|", material);

	}
}
