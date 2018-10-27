
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Flute extends WindInstruments {

	final private String[] kindflutes = { "Bass", "Recorder", "Transverse" };
	private String kindflute;

	// -------------------------------------------------
	// Constructors

	public Flute(int price, String namecompany, String kindmetal, String kindflute) {
		super(price, namecompany, kindmetal);
		setKindflute(kindflute);
	}

	public Flute(Scanner scanner) {

		super(scanner);
		try {// if no information
			setKindflute(scanner.next());
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException(
					"\ncorrupted file, some details of " + getClass().getSimpleName() + " are missing");
		}

	}

	// -------------------------------------------------
	@Override
	public boolean equals(Object m) {// equals
		if (!(m instanceof Flute))
			return false;
		if (!((Flute) m).getKindflute().equalsIgnoreCase(this.getKindflute()))
			return false;
		return super.equals(m);
	}

	public String getKindflute() {
		return kindflute;
	}

	public void setKindflute(String kindflute) {// check if Kind flute

		for (int i = 0; i < kindflutes.length; i++)
			if (kindflutes[i].equalsIgnoreCase(kindflute))
				this.kindflute = kindflute;
		if (this.kindflute == null)
			throw new IllegalArgumentException("\ninvalid type kindflutes " + kindflute);

	}

	@Override
	public String toString() {
		return super.toString() + String.format("  Type: %s", kindflute);
	}

}
