
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Afekainstruments {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(System.in);
		boolean isfilegood = false;
		ArrayList instrumentsStore = new ArrayList();
		while (!isfilegood) {
			try {
				System.out.println("enter the instruments path ");
				File file = new File(in.nextLine());
				in = new Scanner(file);
				isfilegood = true;

				addAllInstruments(instrumentsStore, addGuitarsToArray(in));
				addAllInstruments(instrumentsStore, addBassesToArray(in));
				addAllInstruments(instrumentsStore, addFlutesToArray(in));
				addAllInstruments(instrumentsStore, addSaxophonesToArray(in));

				System.out.println("\nInstruments loaded from file successfully!\n");

				if (instrumentsStore.size() != 0) {
					printinstruments(instrumentsStore);
					System.out.println("\nNum Of Differnt Elemnts: " + getNumOfDifferntElemnts(instrumentsStore));
					System.out.println(
							"\nMost Expensieve Instrument: \n" + getMostExpensieveInstrument(instrumentsStore));
				} else
					System.out.println("There are no instruments in the store currently");

			} catch (FileNotFoundException e) {
				System.out.println("\nFile Error! Please try again:\n");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			} catch (InputMismatchException e) {
				System.err.println(e.getMessage());
				System.exit(2);
			} catch (NoSuchElementException e) {
				System.err.println(e.getMessage());
				System.exit(3);
			}

		}
	}

//------------------------------------------------------------------------------------
	public static ArrayList addGuitarsToArray(Scanner in) {// add Guitar To Array
		int xtype = ifNumInstrumntsGood("Guitar", in);
		ArrayList list = new ArrayList();
		for (int i = 0; i < xtype; i++) {
			list.add(new Guitar(in));
		}
		return list;
	}

	public static ArrayList addBassesToArray(Scanner in) {// add Basses To Array
		int xtype = ifNumInstrumntsGood("Bassess", in);
		ArrayList list = new ArrayList();
		for (int i = 0; i < xtype; i++) {
			list.add(new Bass(in));
		}
		return list;
	}

	public static ArrayList addFlutesToArray(Scanner in) {// add Flutes To Array
		int xtype = ifNumInstrumntsGood("Flutes", in);
		ArrayList list = new ArrayList();
		for (int i = 0; i < xtype; i++) {
			list.add(new Flute(in));
		}
		return list;
	}

	public static ArrayList addSaxophonesToArray(Scanner in) {// add Saxophones To Array
		int xtype = ifNumInstrumntsGood("Saxsophones", in);
		ArrayList list = new ArrayList();
		for (int i = 0; i < xtype; i++) {
			list.add(new Saxophone(in));
		}
		return list;
	}

	public static int ifNumInstrumntsGood(String s, Scanner sc) {// if number of instruments is Good

		try {
			int num = sc.nextInt();
			if (num < 0)
				throw new IllegalArgumentException("Number of " + s + " must be a positive number!");
			else
				return num;
		} catch (InputMismatchException ex) {
			throw new InputMismatchException("Num of " + s + " must be a number!");
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException("Corrupted file, number of " + s + " is missing");
		}

	}

//---------------------------------------------------------------------------------------------------------
	public static ArrayList addAllInstruments(ArrayList array1, ArrayList array2) {// add All Instruments

		for (int i = 0; i < array2.size(); i++) {
			array1.add(array2.get(i));
		}
		return array1;
	}

	public static void printinstruments(ArrayList array1) {// print instruments
		for (int i = 0; i < array1.size(); i++) {
			System.out.println(array1.get(i).toString());

		}
	}

	public static MusicalInstrument getMostExpensieveInstrument(ArrayList array1) {// get Most Expensive Instrument
		double price = 0;
		int index = 0;
		for (int i = 0; i < array1.size(); i++) {
			if (((MusicalInstrument) array1.get(i)).getPrice() > price) {
				price = ((MusicalInstrument) array1.get(i)).getPrice();
				index = i;
			}
		}
		return (MusicalInstrument) array1.get(index);
	}

	public static int getNumOfDifferntElemnts(ArrayList array1) {// get number Of different elements
		int counter = 0;

		for (int i = 0; i < array1.size(); i++) {
			boolean b = true;
			for (int j = i + 1; j < array1.size(); j++) {
				if ((array1.get(i).equals(array1.get(j)))) {
					b = false;
					break;
				}
			}
			if (b) {
				counter++;
			}
		}
		return counter;
	}
}
