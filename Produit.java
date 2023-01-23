import java.util.Scanner;

class Produit {
	public String code;
	public String categorie;
	public String nom;
	public int prix;
	public int quantite;
	public int n;
	int cpt;
	int cpt1;
	int cpt2;
	int cpt3;
	int pos;

	Scanner sc = new Scanner(System.in);
	Scanner scanner = new Scanner(System.in);

	Produit prod[];

	void enregistrement() {
		System.out.println("veuillez entrez le nombre de produit que vous avez en stock");
		n = sc.nextInt();
		while (n < 1) {
			System.out.println("erreur vous návez rien n stock ,veuilez reentrez ");
			n = sc.nextInt();
		}

		prod = new Produit[n];

		for (int i = 0; i < n; i++) {
			prod[i] = new Produit();

			System.out.println("veuillez entrez la categorie du produit " + (i + 1) + "\n");
			prod[i].categorie = scanner.nextLine();
			System.out.println("\n");

			System.out.println("veuillez le nom de votre produit " + (i + 1));
			prod[i].nom = scanner.nextLine();
			System.out.println("======================== ");

			System.out.println("veuillez entrez le prix unitaire de ce produit " + (i + 1));
			prod[i].prix = sc.nextInt();
			System.out.println("======================== ");
			System.out.println("veuillez entez la quantite exacte de ce produit " + (i + 1));
			prod[i].quantite = sc.nextInt();
			System.out.println("======================== ");
			prod[i].code = prod[i].categorie.substring(0, 1) + prod[i].nom.substring(0, 1) + "-" + (i + 1);
		}
	}

	public String toString() {
		return "code  		   : " + code + "\n" +
				"categorie     : " + categorie + "\n" +
				"nom           : " + nom + "\n" +
				"prix Unitaire : " + prix + " Gdes" + "\n" +
				"quantite      : " + quantite + " unite" + "\n";
	}

	void afficher() {
		for (Produit p : prod) {
			if (!p.equals(null)) {
				System.out.println(p.toString());
			} else {
				continue;
			}
		}
	}

	void rechercheCategorie() {
		cpt = 0;
		System.out.println("Entrer la categorie : ");
		String cat = sc.next();
		for (int i = 0; i < prod.length; i++) {

			if (cat.equals(this.prod[i].categorie)) {
				cpt = cpt + 1;
				System.out.println(prod[i].toString());
				System.out.println("partie if");

			}

		}
		if (cpt == 0) {
			System.out.println("categorie inexistant");

		}
	}

	/**
	 * 
	 */
	void produitPostNext() {
		cpt1 = 0;
		System.out.println("Entrer la nom du produit que vous ne voulez pas afficher : ");
		String nomSearch = sc.next();
		for (int i = 0; i < prod.length; i++) {
			if (nomSearch.equals(prod[i].nom)) {
				pos = i;
				cpt1++;
				if (pos == 0) {
					System.out.println("ce produit n'est preceder d'aucun autre produit!!!");
				}
				if (pos == prod.length - 1) {
					System.out.println("ce produit n'est succdeder d'aucun autre produit!!!");
				}
				if (prod.length == 1) {
					System.out.println("Il n'a qu'un produit dans le tableau!!!");
				}
				System.out.println(prod[i].toString());
			} else if (cpt1 == 0 && i == prod.length - 1) {
				System.out.println("nom du produit innexistant!!!");
			}

		}
	}

	/**
	 * 
	 */
	void augmenterPrixProdInf() {
		cpt2 = 0;
		for (int i = 0; i < prod.length; i++) {

			if (prod[i].prix < 60) {
				cpt2++;
				if (cpt2 == 1) {
					System.out.println("produit dont le prix unitaire est < 60");
				}
				prod[i].prix = (prod[i].prix + ((prod[i].prix * 50) / 100));
				System.out.println(prod[i].toString());
			}
		}
		if (cpt2 == 0) {
			System.out.println("Il n'y a pas de produit dont le prix unitaire est < 60");
		}

	}

	void diminuerPrixProd() {
		cpt3 = 0;
		for (int i = 0; i < prod.length; i++) {
			if (prod[i].prix < 60) {
				cpt2++;
				if (cpt2 == 1) {
					System.out.println("produit dont le prix unitaire est < 60");
				}
				prod[i].prix = (prod[i].prix + ((prod[i].prix * 50) / 100));
				System.out.println(prod[i].toString());
				// System.out.println("partie if");
			}
		}
		if (cpt3 == 0) {
			System.out.println("Il n'y a pas de produit dont le prix unitaire est < 60");
		}
	}

	/**
	 * 
	 */
	void supprimerProdParCode() {
		System.out.print("Entrer la code du produit que vous voulez supprimer : ");
		String codeSearch = sc.nextLine();
		for (int i = 0; i < prod.length; i++) {
			if (!codeSearch.equals(prod[i].code)) {
				this.prod[i] = null;
			}
		}
	}

	public static void main(String a[]) {
		Produit pd = new Produit();

		pd.enregistrement();

		int exit = 0;
		do {
			System.out.println(
					"1. Afficher tous les produits du tablea (2Points).\n\t\t 2. Afficher tous les produits se trouvant dans une catégorie\n\t\t3. Afficher tous les produits qui viennent avant et après un produit\n\t\t4. Augmenter de 50% le prix unitaire de tous les produits dont leur prix unitaire est inférieur à 60 Gourdes\n\t\t5. Diminuer de 50 gourdes le prix unitaire de tous les produits d’une catégorie dont leur quantité est comprise entre 500 à 1000 (2Points)\n\t\t6. Supprimer un produit dans le tableau par son code\n\t\t\t------0. pour quitter le programme ");

			int choice;
			Scanner scan = new Scanner(System.in);
			System.out.println("<==><==>Veuillir choisir une option<==><==>");
			choice = scan.nextInt();
			switch (choice) {
				case 0:
					System.exit(0);
					break;

				case 1:
					pd.afficher();

					break;

				case 2:
					pd.rechercheCategorie();
					break;

				case 3:
					pd.produitPostNext();

					break;

				case 4:
					pd.augmenterPrixProdInf();

					break;

				case 5:
					pd.supprimerProdParCode();
					break;

				default:
					System.out.println("invalid option\n");
					System.out.print("<==><==>Veuillir choisir une option<==><==>    ");

					choice = scan.nextInt();
					break;
			}
		} while (exit == 0);

	}
}