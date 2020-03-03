package packageISN;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		//Scanner
		Scanner sc = new Scanner(System.in);

		//Liste des mots
		String tab[][] = {{"Voiture","Chat","Visage"},
				{"Car","Cat","Face"}};

		//Nombre aléatoire
		int NbR = (int) (Math.round(Math.random()*2));;

		//Mot à traduire
		String mot1 = tab[0][NbR];
		System.out.println("Le mot à traduire en anglais : " + mot1);

		//Mot traduis
		String mot2 = tab[1][NbR];

		//Réponse
		String Proposition;
		Proposition = sc.nextLine();
		if (Proposition.equals(mot2)){
			System.out.println("Bravo !");
		}
		else System.out.println("Dommage !");
	}
}