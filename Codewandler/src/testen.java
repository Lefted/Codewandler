import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testen {
	public static boolean change = false;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("Status: " + change);
			System.out.println("Press a key...");
			reader.readLine();
			change();
		}
	}
	
	public static void change() {
		change = (change) ? false : true;
	}
}
