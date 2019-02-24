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
		
		System.out.println();
		
		linkeSeite = new boolean[anzahlEingangsvariablen][anzahlZeilen];
		linkeSeite();
		
		ausgabe(anzahlZeilen, anzahlEingangsvariablen);
	}

	public static void linkeSeite() {
		// from 7 to 0 in Array linkeSeite (spalten/coulumns)
		for (int i = anzahlEingangsvariablen -1; i >= 0; i--) {
			int aufl�sung = (int) (anzahlZeilen / (Math.pow(2, (i + 1))));
			
			boolean change = false;
			// die zeilen vom punkt aus, an dem sich 0/1 ge�ndert hat
			int x = 0;
			// from 0 to 255 in Array linkeSeite (zeilen/rows)
			for (int j = 0; j < anzahlZeilen; j++) {
				
				
				
				linkeSeite[i][j] = change;
				
				if (x + 1 == aufl�sung) {
					change = (change) ? false : true;
					x = 0;
				} else {
					x++;
				}
				
			}
		}
	}
	
	public static void debugLinkeSeite(int zeilen, int spalten) {
		for(int i  = 0; i < zeilen; i++) {
			for (int j = 0; j < spalten; j++) {
//				System.out.print(j);
				System.out.print(linkeSeite[j][i] + " ");
			}
			System.out.print(" " + i);
			System.out.println();
		}
	}
	
	public static void ausgabe(int zeilen, int spalten) {
		// alle 255 zeilen (array)
		for (int i = 0; i < zeilen; i++) {
			// alle 7 spalten (array)
			
			System.out.print("[");
			for (int j = 0; j < spalten; j++) {
				
				int output = (linkeSeite[j][i]) ? 1 : 0;
				
				if (j != (spalten - 1)) {
					System.out.print(output + ", ");					
				} else {
					System.out.print(output + "]");
				}
			}
			// Ausgabe der rechten Seite
			System.out.print("   ->   " + Anzeige.generateHexString(i));
			// Zeilenangaben
			System.out.print("    //");
			System.out.printf("%3d",i);
			
			System.out.println();
		}
	}
}
