
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MusicalInstrument {

	private double price;
	private String namecompany;

	// -------------------------------------------------
	// Constructors

	public MusicalInstrument(double price, String namecompany) {

		setPrice(price);
		setNamecompany(namecompany);
	}

	public MusicalInstrument(Scanner scanner) {

		try {
			setPrice(scanner.nextDouble());
			setNamecompany(scanner.next());

		} catch (InputMismatchException ex) {
			throw new InputMismatchException("\nPrice must be a number");
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException(
					"\ncorrupted file, some details of " + getClass().getSimpleName() + " are missing");

		}
	}

	// -------------------------------------------------

	@Override
	public boolean equals(Object m) {
		if (m instanceof MusicalInstrument) {
			if (((MusicalInstrument) m).getPrice() == this.getPrice()
					&& ((MusicalInstrument) m).getNamecompany().equalsIgnoreCase(this.getNamecompany()))
				return true;
		}
		return false;
	}

	public double getPrice() {
		return price;
	}

	// check if price is valid input
	public void setPrice(double price) {
		if (price > 0)
			this.price = price;
		else
			throw new IllegalArgumentException("\nPrice must be a positive number! NOT " + price);

	}

	public String getNamecompany() {
		return namecompany;
	}

	public void setNamecompany(String namecompany) {
		this.namecompany = namecompany;

	}

	@Override
	public String toString() {
		return String.format("%-8s %-9s | Price: %7.2f", namecompany, getClass().getSimpleName(), price);
	}

}
