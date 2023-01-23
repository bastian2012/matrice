import java.util.Scanner;

import javax.swing.text.Position;

class Tableau {

	public int n;
	public int[] tab;
	boolean bool=true;
	Scanner sc = new Scanner(System.in);

	void saisir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez la dimension du tableau");
		n = sc.nextInt();

		while (n < 3 || n > 7) {
			System.out.println("Erreur, la dimension du tableau doit etre compris entre 3 et 7");
			n = sc.nextInt();
		}

		tab = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("entrer l'element " + (i + 1) + " :");
			tab[i] = sc.nextInt();
		}
	}

	void afficher() {
		System.out.println("les elements du tableau sont : ");
		for (int i = 0; i < tab.length; i++) {
			System.out.print(" |" + tab[i] + "| ");
		}
		System.out.println("\n\n");
	}

	void decroissant() {
		System.out.println("l'ordre décroissant des 3 derniers elements du tableau est : ");
		int temp;
		for (int i = n - 3; i < n; i++) {
			int posmax = i;
			for (int j = i + 1; j < n; j++) {
				if (tab[j] > tab[posmax]) {
					posmax = j;
				}
			}
			temp = tab[posmax];
			tab[posmax] = tab[i];
			tab[i] = temp;
			System.out.print(" |" + tab[i] + "| ");
		}
		System.out.println("\n\n");

	}

	void occurence() 
	{   
		/*System.out.print("entrer le nombre : ");
		int nonbre=sc.nextInt();
		for (int i = 0; i < tab.length; i++) {
			if (tab[i]==nonbre && i>3){
				  position=i+1;
				break;
			}
			else{
				continue;
			}
		}
		*/

		System.out.println("Entrez le nombre que vous voulez rechercher dans le tableau");
		int r = sc.nextInt();


		for (int i = 0; i < n; i++) {

			if (tab[i] == r && i>3) 
			{
		//	int posr = i + 1;

				//System.out.println("la position de ce nombre est : " + posr);
						/*if (posr > 3) {
							System.out.println("les 3 nombres qui viennent avant ce nombre sont : ");*/
							for (i = i - 3; i < i; i++) {

								System.out.print(" |" + tab[i] + "| ");
							}
							break;
						}
			else{
				 bool=false;
			}			
			} 
if(!bool){
	System.out.println("element innexistant!!! ou le nombre n'est pas preceder de trois nombre");
}

			
	}
		
		
	

	void comparaison() {
		int max, min;
		max = tab[0];
		min = tab[0];
		for (int i = 1; i < n; i++) {
			if (tab[i] > max) {
				max = tab[i];
			} else if (tab[i] < min) {
				min = tab[i];
			} else {
				min = min;
				max = max;
			}
		}
		System.out.println("le plus grand nombre du tableau est : " + max);
		System.out.println("le plus petit nombre du tableau est : " + min);

	}

	/*
	 * void Menu()
	 * {
	 * System.out.println(
	 * "<=======================================================MENU========================================================>"
	 * );
	 * System.out.
	 * println("<===================FAITES UN CHOIX==========================>");
	 * System.out.println("1==>Afficher les elements du Tableau");
	 * System.out.
	 * println("2==>Afficher en ordre decroissant les 3 derniers elements du Tableau"
	 * );
	 * System.out.
	 * println("3==>Afficher les 3 premiers nombres qui viennent avant un nombre quelconque choisit par lútilisateur lorsque la position de lélement saisi est superieure a 3"
	 * );
	 * System.out.
	 * println("4==>Afficher le plus grand et le plus petit nombre du Tableau");
	 * System.out.println ("  ");
	 * System.out.println (" faites votre choix ci-dssous ");
	 * choix=cx.nextInt();
	 * 
	 * 
	 * }
	 */
	public static void main(String a[]) {
		Tableau tb = new Tableau();
		Scanner cx = new Scanner(System.in);
		int choix;
		int exit = 0;
		tb.saisir();

		do {

			System.out.println(
					"<=======================================================MENU========================================================>");
			System.out.println("<===================FAITES UN CHOIX==========================>");
			System.out.println("1==>Afficher les elements du Tableau");
			System.out.println("2==>Afficher en ordre decroissant les 3 derniers elements du Tableau");
			System.out.println(
					"3==>Afficher les 3 premiers nombres qui viennent avant un nombre quelconque choisit par lútilisateur lorsque la position de lélement saisi est superieure a 3");
			System.out.println("4==>Afficher le plus grand et le plus petit nombre du Tableau");
			System.out.println("0==>Pour sortir du programme");
			System.out.println("  ");
			System.out.println(" faites votre choix ci-dssous ");
			choix = cx.nextInt();

			switch (choix) {
				case 1:
					tb.afficher();
					break;
				case 2:
					tb.decroissant();
					break;
				case 3:
					tb.occurence();
					break;
				case 4:
					tb.comparaison();
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("choix incorrect");
					choix = cx.nextInt();
					break;

			}
		} while (exit == 0);
	}

}
