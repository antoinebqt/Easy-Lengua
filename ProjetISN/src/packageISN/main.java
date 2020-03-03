package packageISN;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		//Liste des mots
		String tab[][] = {{"Voiture","Chat","Visage","Bleu","Famille","Rouge","Vert","Maison","Jaune","Orange","Ordinateur","Souris","Crayon","Lit","Route","Jour","Nuit","Bonjour","Merci","Temps","Porte","Sable","Clavier","Mer","P�re","M�re","Fr�re","Soeur"},
				{"Car","Cat","Face","Blue","Family","Red","Green","Home","Yellow","Orange","Computer","Mouse","Pencil","Bed","Road","Day","Night","Hello","Thank you","Time","Door","Sand","Keyboard","Sea","Father","Mother","Brother","Sister"},
			    {"Coche","Gato","Cara","Azul","Familia","Rojo","Verde","Casa","Amarillo","Naranja","Ordenador","Rat�n","L�piz","Cama","Camino","D�a","Noche","Hola","Gracias","Tiempo","Puerta","Arena","Teclado","Mar","Padre","Madre","Hermano", "Hermana"}};

		//Scanner
		Scanner sc = new Scanner(System.in);

		//Compteur de bonne r�ponse
		int P = 0;

		//Choix de la langue de d�part
		int langue1;
		System.out.println("Langue de d�part ? (Fran�ais, Anglais ou Espagnol)"); //A FAIRE : Message d'erreurs
		String langueD = sc.nextLine();
		if (langueD.equals("Fran�ais")){
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
				System.out.println("Langue de traduction ? (Fran�ais, Anglais ou Espagnol)");
				langueF = sc.nextLine();
				if (langueF.equals(langueD)){
					System.out.println("La langue saisie ne peut pas �tre utilis�, veuillez recommencer");
				}
			} while (langueF.equals(langueD));

		if (langueF.equals("Fran�ais")){
			langue2 = 0;
		}
		else if (langueF.equals("Anglais")){
			langue2 = 1;
		}
		else langue2 = 2;

		//Choix du nombre de tour
		System.out.println("Combien de mots voulez vous traduire ?");
		int X =sc.nextInt();

		//D�but du jeu
		for (int i = 0; i !=X; i++){

		//Nombre al�atoire //A FAIRE : m�moire
		int NbR = (int) (Math.round(Math.random()*27));

		//Mot � traduire
		String mot1 = tab[langue1][NbR];
		System.out.println("Le mot � traduire en " + langueF.toLowerCase() + " : " + mot1 + " (Attention, les majuscules et accents comptent !)");

		//Mot traduis
		String mot2 = tab[langue2][NbR];

		//R�ponse
		String Proposition;
		if (i == 0){
			Proposition = sc.nextLine();
		}
		Proposition = sc.nextLine();
		if (Proposition.equals(mot2)){
			System.out.println("Bravo ! Vous gagner un point !");
			P++;
		}
		else System.out.println("Dommage ! La bonne r�ponse �tait : " + mot2 + ".");
		}
		System.out.println("C'est fini ! Votre r�sultat final : " + P + "/" + X + ".");
	}
}