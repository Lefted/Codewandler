import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codewandler {

	public static int anzahlEingangsvariablen;
	public static int anzahlZeilen;

	public static boolean[][] linkeSeite;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Bitte anzahl der Eingangsvariablen eingeben: ");
		anzahlEingangsvariablen = Integer.parseInt(reader.readLine());
		anzahlZeilen = (int) Math.pow(2, anzahlEingangsvariablen);
		System.out.println(anzahlZeilen);

		linkeSeite = new boolean[anzahlEingangsvariablen][anzahlZeilen];
		linkeSeite();
		
		ausgabeLinkeSeite(256, 8);
	}

	public static void linkeSeite() {
		for (int i = anzahlEingangsvariablen -1; i >= 0; i--) {
			int auflösung = (int) (anzahlZeilen / (Math.pow(2, i)));
			System.out.println(anzahlZeilen / auflösung);
			for (int j = 0; j < anzahlZeilen; j++) {
				boolean change = false;
				for (int x = 0; x < (anzahlZeilen / auflösung); x++) {
					for (int k = 0; k < auflösung; k++) {
						linkeSeite[i][j] = change;
					}
					change = (true) ? false : true;
				}
				
			}
		}
	}
	
	public static void ausgabeLinkeSeite(int zeilen, int spalten) {
		for(int i  = 0; i < zeilen; i++) {
			for (int j = 0; j < spalten; j++) {
//				System.out.print(j);
				System.out.print(linkeSeite[j][i] + " ");
			}
			System.out.print(" " + i);
			System.out.println();
		}
	}
}
