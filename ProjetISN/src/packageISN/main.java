package packageISN;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		//Scanner
		Scanner sc = new Scanner(System.in);

		//Liste des mots
		String tab[][] = {{"Voiture","Chat","Visage"},
				{"Car","Cat","Face"}};

		//Choix de la langue de d�part
		int langue1;
		int langue2;
		System.out.println("Langue de d�part ? (Fran�ais ou Anglais)");
		String langue = sc.nextLine();
		if (langue.equals("Fran�ais")){
			langue1 = 0;
			langue2 = 1;
		}
		else {
			langue1 = 1;
			langue2 = 0;
		}
		//Nombre al�atoire
		int NbR = (int) (Math.round(Math.random()*2));;

		//Mot � traduire
		String mot1 = tab[langue1][NbR];
		System.out.println("Le mot � traduire : " + mot1 + " (Attention, les majuscules et accents comptent !)");

		//Mot traduis
		String mot2 = tab[langue2][NbR];

		//R�ponse
		String Proposition;
		Proposition = sc.nextLine();
		if (Proposition.equals(mot2)){
			System.out.println("Bravo !");
		}
		else System.out.println("Dommage !");
	}
}