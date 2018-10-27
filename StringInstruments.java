
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringInstruments extends MusicalInstrument {
	private int amountstring;

	// -------------------------------------------------
	// Constructors

	public StringInstruments(Scanner scanner) {
		super(scanner);
		try {// if no information
			setAmountString(scanner.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("\ninvalid input for string amount");
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException(
					"\ncorrupted file, some details of " + getClass().getSimpleName() + " are missing");
		}
	}

	public StringInstruments(int amount, int price, String namecompany) {
		super(price, namecompany);
		setAmountString(amount);
	}

	// -------------------------------------------------
	@Override
	public boolean equals(Object m) {
		if (!(m instanceof StringInstruments))
			return false;

		if (!(((StringInstruments) m).getAmountString() == this.getAmountString()))
			return false;
		return super.equals(m);
	}

	public int getAmountString() {
		return amountstring;
	}

	public void setAmountString(int amount) {
		this.amountstring = amount;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", Number of string: %2d|", amountstring);
	}

}
