package packageISN;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		//Scanner
		Scanner sc = new Scanner(System.in);

		//Liste des mots
		String tab[][] = {{"Voiture","Chat","Visage"},
				{"Car","Cat","Face"}};

		//Choix de la langue de départ
		int langue1;
		int langue2;
		System.out.println("Langue de départ ? (Français ou Anglais)");
		String langue = sc.nextLine();
		if (langue.equals("Français")){
			langue1 = 0;
			langue2 = 1;
		}
		else {
			langue1 = 1;
			langue2 = 0;
		}
		//Nombre aléatoire
		int NbR = (int) (Math.round(Math.random()*2));;

		//Mot à traduire
		String mot1 = tab[langue1][NbR];
		System.out.println("Le mot à traduire : " + mot1 + " (Attention, les majuscules et accents comptent !)");

		//Mot traduis
		String mot2 = tab[langue2][NbR];

		//Réponse
		String Proposition;
		Proposition = sc.nextLine();
		if (Proposition.equals(mot2)){
			System.out.println("Bravo !");
		}
		else System.out.println("Dommage !");
	}
}