package packageISN;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		//Liste des mots
		String tab[][] = {{"Voiture","Chat","Visage","Bleu","Famille","Rouge","Vert","Maison","Jaune","Orange","Ordinateur","Souris","Crayon","Lit","Route","Jour","Nuit","Bonjour","Merci","Temps","Porte","Sable","Clavier","Mer","Père","Mère","Frère","Soeur"},
				{"Car","Cat","Face","Blue","Family","Red","Green","Home","Yellow","Orange","Computer","Mouse","Pencil","Bed","Road","Day","Night","Hello","Thank you","Time","Door","Sand","Keyboard","Sea","Father","Mother","Brother","Sister"},
			    {"Coche","Gato","Cara","Azul","Familia","Rojo","Verde","Casa","Amarillo","Naranja","Ordenador","Ratón","Lápiz","Cama","Camino","Día","Noche","Hola","Gracias","Tiempo","Puerta","Arena","Teclado","Mar","Padre","Madre","Hermano", "Hermana"}};

		//Scanner
		Scanner sc = new Scanner(System.in);

		//Compteur de bonne réponse
		int P = 0;

		//Choix de la langue de départ
		int langue1;
		System.out.println("Langue de départ ? (Français, Anglais ou Espagnol)"); //A FAIRE : Message d'erreurs
		String langueD = sc.nextLine();
		if (langueD.equals("Français")){
			langue1 = 0;
		}
		else if (langueD.equals("Anglais")){
			langue1 = 1;
		}
		else langue1 = 2;

		//Choix de la langue final
		int langue2;
		String langueF;
		do {
				System.out.println("Langue de traduction ? (Français, Anglais ou Espagnol)");
				langueF = sc.nextLine();
				if (langueF.equals(langueD)){
					System.out.println("La langue saisie ne peut pas être utilisé, veuillez recommencer");
				}
			} while (langueF.equals(langueD));

		if (langueF.equals("Français")){
			langue2 = 0;
		}
		else if (langueF.equals("Anglais")){
			langue2 = 1;
		}
		else langue2 = 2;

		//Choix du nombre de tour
		System.out.println("Combien de mots voulez vous traduire ?");
		int X =sc.nextInt();

		//Début du jeu
		for (int i = 0; i !=X; i++){

		//Nombre aléatoire //A FAIRE : mémoire
		int NbR = (int) (Math.round(Math.random()*27));

		//Mot à traduire
		String mot1 = tab[langue1][NbR];
		System.out.println("Le mot à traduire en " + langueF.toLowerCase() + " : " + mot1 + " (Attention, les majuscules et accents comptent !)");

		//Mot traduis
		String mot2 = tab[langue2][NbR];

		//Réponse
		String Proposition;
		if (i == 0){
			Proposition = sc.nextLine();
		}
		Proposition = sc.nextLine();
		if (Proposition.equals(mot2)){
			System.out.println("Bravo ! Vous gagner un point !");
			P++;
		}
		else System.out.println("Dommage ! La bonne réponse était : " + mot2 + ".");
		}
		System.out.println("C'est fini ! Votre résultat final : " + P + "/" + X + ".");
	}
}