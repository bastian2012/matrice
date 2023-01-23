import java.util.Scanner;

class Matrice {
	public int n;
	public int[][] matrice;
	public int[][] matrice1;
	public int[] tb1;
	public int[] tb2;
	int temp;
	/**
	 *
	 */
	int o;
	int p;
	int w;
	int c;
	int z = 0;
	int y = 0;
	double inverse;
	double triple;
	Scanner sc = new Scanner(System.in);

	void saisir() {

		System.out.println("Entrer la dimension du tableau");
		n = sc.nextInt();
		while (n < 2 || n > 5) {
			System.out.println("Erreur la dimension doit etre compris entre 2 a 5");
			n = sc.nextInt();
		}

		matrice = new int[n][n];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				System.out.println("entrer l'element " + (z + 1));

				matrice[i][j] = sc.nextInt();
				z++;
			}
		}
	}
	void afficher() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrice[i][j] + "\t");

			}
			System.out.print("\n");

		}
		System.out.print("\n============================");
	}
	void DiagonalSecondaire() {
		int somme = 0;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {

				if (i + j == n - 1) {
					int s = matrice[i][j];
					somme = somme + s;

				}
			}
		}
		double c = somme;
		inverse = (1 / c);
		triple = (3 * inverse);

		System.out.println("le triple de l'ínverse de la somme de la diagonale secondaire est egale : " + triple);

	}

	void permutationDiagPrSec() {
		o = 0;
		p = n - 1;
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				if (i == j) {

					temp = matrice[i][j];
					matrice[i][j] = matrice[o][p];
					matrice[o][p] = temp;

				}
			}
			o++;
			p--;
		}

		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				System.out.print(matrice[i][j] + "\t");
			}
			System.out.print("\n");

		}
	}

	void nombreDivisiblePar2Et4() {
		w = 0;
		tb1 = new int[n * n];
		System.out.println(" nombre divisible par 2 et par 4");
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {

				if (((matrice[i][j]) * (matrice[i][j])) % 4 == 0) {
					tb1[w] = matrice[i][j];
					System.out.print("|" + tb1[w] + "| ");
					w++;

				}
			}
		}
		System.out.println("\n" + (w + 1) + " nombre sont divisible par 2 et pat 4");
	}

	void sommeMatrice() {
		matrice1 = new int[n][n];
		System.out.println("pour effectuer la somme veuiller saisir une matrice de meme dimension que la precedente ");
		for (int i = 0; i < matrice1.length; i++) {
			for (int j = 0; j < matrice1.length; j++) {
				System.out.println("entrer l'element " + (y + 1));

				matrice1[i][j] = sc.nextInt();
				matrice1[i][j] += matrice[i][j];
				y++;
			}
		}

		for (int i = 0; i < matrice1.length; i++) {
			for (int j = 0; j < matrice1.length; j++) {
				System.out.print(matrice1[i][j] + "\t");
			}
			System.out.println("\n");
		}

	}

	public static void main(String a[]) {
		Matrice mat = new Matrice();
		System.out.println(
				"\t\t\tCe programme utilise une matrice carrée de (n compris entre 2 à 5) nombres entiers\n\n\t\t\t\nsaisis le tableau pour pouvoir voir les operation qui peuvent etre effectuer  \n\n ");
		mat.saisir();
		System.out.println("=========================");
		int exit = 1;
		do {

			System.out.println(
					"\t\t1. Afficher tous les éléments du tableau.\n\t\t2. Afficher le triple de l’inverse de la somme des éléments se trouvant sur la diagonale secondaire\n\t\t3. . Permuter les éléments de la diagonale principale à deux de la diagonale secondaire de la matrice.\n\t\t4. Copier dans un tableau à 1 dimension tous les nombres saisis dont leur carré est un nombre pair divisible par 2 et par 4, puis afficher le tableau.\n\t\t5. . Calculer la somme de la première matrice à une autre matrice carrée de même taille dont les nombres seront saisis au clavier par l’utilisateur.\n\t\t0. pour quitter le programme. ");

			System.out.println("veuiller choisir une option : ");
			int choix;
			Scanner scan = new Scanner(System.in);
			choix = scan.nextInt();
			while ((choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5 && choix != 0)) {
				System.out.println("option invalide reessayer : ");
				choix = scan.nextInt();
			}
			switch (choix) {
				case 1:
					mat.afficher();
					System.out.println("=========================");
					break;
				case 2:
					mat.DiagonalSecondaire();
					System.out.println("=========================");
					break;
				case 3:
					mat.permutationDiagPrSec();
					System.out.println("=========================");
					break;
				case 4:
					mat.nombreDivisiblePar2Et4();
					System.out.println("=========================");
					break;
				case 5:
					mat.sommeMatrice();
					System.out.println("=========================");
					break;
				case 0:
					System.out.println("Bye bye");
					System.exit(0);
					break;
				default:
					break;
			}
		} while (exit == 1);
	}

}
