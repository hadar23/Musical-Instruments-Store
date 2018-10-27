
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Guitar extends StringInstruments {

	final private String[] kindGuitars = { "Electric", "Acoustic", "Plastic" };
	private String kindGuitar;

	// -------------------------------------------------
	// Constructors

	public Guitar(Scanner scanner) {
		super(scanner);
		try {// if no information
			setKindGuitar(scanner.next());
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException(
					"\ncorrupted file, some details of " + getClass().getSimpleName() + " are missing");
		}
		/// check the string of the guitars
		isStringOfTheGuitars();
	}

	public Guitar(int amountstring, int price, String namecompany, String kindGuitar) {
		super(amountstring, price, namecompany);
		setKindGuitar(kindGuitar);
		/// check the string of the guitars
		isStringOfTheGuitars();
	}

	/// Default constructor, here, the amount string is 6 always
	public Guitar(int price, String namecompany, String kindGuitar) {
		super(6, price, namecompany);
		setKindGuitar(kindGuitar);
		/// check the string of the guitars
		isStringOfTheGuitars();
	}

	// --------------------------------------------------

	public void isStringOfTheGuitars() {
		/// check the string of the guitars
		if ((this.getAmountString() < 6 || this.getAmountString() > 8)
				&& (this.getKindGuitar().equalsIgnoreCase("Electric")))

			throw new IllegalArgumentException(this.getAmountString()
					+ "\nElectric number of strings is a number between 6 and 8, not " + this.getAmountString());

		// Different from electric means its "Acoustic", "Plastic" -default
		else if (this.getAmountString() != 6 && (!(this.getKindGuitar().equalsIgnoreCase("Electric"))))
			throw new IllegalArgumentException(
					"\n" + this.getKindGuitar() + " Guitars have 6 strings, NOT " + this.getAmountString());

	}

	@Override
	public boolean equals(Object m) {
		if (!(m instanceof Guitar))
			return false;

		if (!((Guitar) m).getKindGuitar().equalsIgnoreCase(this.kindGuitar))
			return false;

		return super.equals(m);
	}

	public void setKindGuitar(String kindGuitar) throws IllegalArgumentException {
//this method set the kind of the guitar
		for (int i = 0; i < kindGuitars.length; i++) {
			if (kindGuitars[i].equalsIgnoreCase(kindGuitar))
				this.kindGuitar = kindGuitar;
		}
		if (this.kindGuitar == null)
			throw new IllegalArgumentException("\nInvalid guitar type " + kindGuitar);
	}

	public String getKindGuitar() {
		return this.kindGuitar;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("  Type: %s", kindGuitar);
	}

}
