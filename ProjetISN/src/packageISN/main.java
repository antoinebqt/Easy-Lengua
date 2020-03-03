package packageISN;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		//Liste des mots
		String tab[][] = {{"Voiture","Chat","Visage","Bleu","Famille","Rouge","Vert","Maison","Jaune","Orange","Ordinateur","Souris","Crayon","Lit","Route","Jour","Nuit","Bonjour","Merci","Temps","Porte","Sable","Clavier","Mer","Père","Mère","Frère","Soeur","Dessin"},
						  {"Car","Cat","Face","Blue","Family","Red","Green","House","Yellow","Orange","Computer","Mouse","Pencil","Bed","Road","Day","Night","Hello","Thanks","Time","Door","Sand","Keyboard","Sea","Father","Mother","Brother","Sister","Drawing"},
						  {"Coche","Gato","Cara","Azul","Familia","Rojo","Verde","Casa","Amarillo","Naranja","Ordenador","Ratón","Lápiz","Cama","Camino","Día","Noche","Hola","Gracias","Tiempo","Puerta","Arena","Teclado","Mar","Padre","Madre","Hermano", "Hermana","Dibujo"}};

		//Scanner
		Scanner sc = new Scanner(System.in);

		//Compteur de bonne réponse
		int P = 0;

		//Choix de la langue de départ
		int langue1 = -1;
		int Vérification = 0;
		String langueD;
		do {
				System.out.println("Langue de départ ? (Français, Anglais ou Espagnol)");
				langueD = sc.nextLine();
				if (langueD.equals("Français")){
					langue1 = 0;
					Vérification = 1;
				}
				else if (langueD.equals("Anglais")){
					langue1 = 1;
					Vérification = 1;
				}
				else if (langueD.equals("Espagnol")){
					langue1 = 2;
					Vérification = 1;
				}
				else {
					System.out.println("La langue saisie est invalide, veuillez recommencer");
					Vérification = 0;
				}
			} while(Vérification == 0);

		//Choix de la langue final
		int langue2 = -1;
		String langueF;
		do {
				System.out.println("Langue de traduction ? (Français, Anglais ou Espagnol)");
				langueF = sc.nextLine();
				if (langueF.equals(langueD)){
					System.out.println("La langue saisie ne peut pas être utilisé, veuillez recommencer");
					Vérification = 0;
				}
				else if (langueF.equals("Français")){
					langue2 = 0;
					Vérification = 1;
				}
				else if (langueF.equals("Anglais")){
					langue2 = 1;
					Vérification = 1;
				}
				else if (langueF.equals("Espagnol")) {
					langue2 = 2;
					Vérification = 1;
				}
				else {
					System.out.println("La langue saisie est invalide, veuillez recommencer");
					Vérification = 0;
				}
			} while (Vérification == 0);

		//Choix du nombre de tour
		int X = 0;
		do {
			System.out.println("Combien de mots voulez vous traduire ?");
			X = sc.nextInt();
			if (X > 28){
				System.out.println("Vous ne pouvez pas traduire plus de mots que le nombre de mots disponible !");
				Vérification = 0;
			}
			else {
				Vérification = 1;
			}
		} while(Vérification == 0);

		//Jeu
		String mem = "";
		for (int i = 0; i !=X; i++){

			//Mot aléatoire à traduire
			String mot1;
			int NbR;
			do {
				NbR = (int) (Math.round(Math.random()*28));
				mot1 = tab[langue1][NbR];
			} while (mem.contains(mot1));
			System.out.println("Le mot à traduire en " + langueF.toLowerCase() + " : " + mot1 + " (Attention, les majuscules et accents comptent !)");
			mem = mem.concat(mot1);

			//Mot traduis à retrouver
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
			else {
			System.out.println("Dommage ! La bonne réponse était : " + mot2);
			}
		}
		System.out.println("C'est fini ! Votre résultat final : " + P + "/" + X);
	}
}