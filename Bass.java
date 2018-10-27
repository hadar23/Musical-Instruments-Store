
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bass extends StringInstruments {

	private boolean isfretless;

	// -------------------------------------------------
	// Constructors

	public Bass(Scanner scanner) {
		super(scanner);
		try {// check if string amount is OK for bass guitar
			setIsfretless(scanner.nextBoolean());

		} catch (InputMismatchException e) {
			throw new IllegalArgumentException("\nWhether a bass is fretless or not is boolean, "
					+ " any other string than \"True\" or \"False\" is not acceptable");
		} catch (NoSuchElementException ex) {// if no information
			throw new NoSuchElementException(
					"\ncorrupted file, some details of " + getClass().getSimpleName() + " are missing");
		}
		isStringAmountOK();
	}

	public Bass(int amount, int price, String namecompany, boolean b) {
		super(amount, price, namecompany);
		setIsfretless(b);
		// check if string amount is OK for bass guitar
		isStringAmountOK();
	}

	// -------------------------------------------------
	@Override
	public boolean equals(Object m) {// equals
		if (!(m instanceof Bass))
			return false;

		if (!((Bass) m).isIsfretless() == this.isIsfretless())
			return false;

		return super.equals(m);
	}

	public void isStringAmountOK() {// check if string amount is OK
		if (this.getAmountString() < 4 || this.getAmountString() > 6)
			throw new IllegalArgumentException("\nbass guitar have 4-6 strings not " + this.getAmountString());
	}

	public boolean isIsfretless() {
		return isfretless;
	}

	public void setIsfretless(boolean isfretless) {

		this.isfretless = isfretless;

	}

	@Override
	public String toString() {
		return super.toString() + String.format("  Fretless: %s", (isfretless ? "Yes" : "No"));
	}

}
