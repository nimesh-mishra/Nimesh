package DegTofar;

/**
 * 
 * @author nimesh
 * 
 * 
 */
public class CelciusToFarenheit {

	public static void main(String[] args) {

		for (int i = 0; i <= 100; i++) {
			System.out.println("The Temperature is \t Celcius :" + i + "'c \t"
					+ "Farhenheit: " + (((i * 9) / 5.0) + 32));
		}

	}

}
