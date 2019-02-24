public class Codewandler {

	public static int anzahlEingangsvariablen;
	public static int anzahlZeilen;

	public static boolean[][] linkeSeite;

	public static void initRowsAndCoulmns(int coulmns) {
		anzahlEingangsvariablen = coulmns;
		anzahlZeilen = (int) Math.pow(2, coulmns);
	}
	
	public static void linkeSeite() {
		linkeSeite = new boolean[anzahlEingangsvariablen][anzahlZeilen];
		// from 7 to 0 in Array linkeSeite (spalten/coulumns)
		for (int i = anzahlEingangsvariablen - 1; i >= 0; i--) {
			int auflösung = (int) (anzahlZeilen / (Math.pow(2, (i + 1))));

			boolean change = false;
			// die zeilen vom punkt aus, an dem sich 0/1 geändert hat
			int x = 0;
			// from 0 to 255 in Array linkeSeite (zeilen/rows)
			for (int j = 0; j < anzahlZeilen; j++) {

				linkeSeite[i][j] = change;

				if (x + 1 == auflösung) {
					change = (change) ? false : true;
					x = 0;
				} else {
					x++;
				}

			}
		}
	}

	public static void debugLinkeSeite(int zeilen, int spalten) {
		for (int i = 0; i < zeilen; i++) {
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
			System.out.printf("%3d", i);

			System.out.println();
		}
	}

	public static StringBuffer getStringBuffer(int spalten, int zeilen, boolean compile0And1) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < zeilen; i++) {

			buffer.append("[");
			for (int j = 0; j < spalten; j++) {
				int output = (linkeSeite[j][i]) ? 1 : 0;

				if (j != (spalten - 1)) {
					buffer.append(output + ", ");
				} else {
					buffer.append(output + "]");
				}
			}
			
			buffer.append("   ->   ");
			
			if (!compile0And1) {
				
				buffer.append(Anzeige.generateHexString(i));
				buffer.append("    //" + i);
			}
			buffer.append("\n");

		}
		return buffer;
	}
}
