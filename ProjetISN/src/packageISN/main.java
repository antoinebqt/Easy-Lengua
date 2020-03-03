package packageISN;

import java.util.Scanner;

import sun.text.Normalizer;

public class Main {

	public static void main(String[] args) {

		//Scanner
		Scanner sc = new Scanner(System.in);

		//Compteur de bonne réponse
		int P = 0;

		//Vérificateur de boucle do
		int Vérification = 0;

		//Choix de la langue de départ
		int langue1 = -1;
		String langueD;
		do {
				System.out.println("Langue de départ ? (Français, Anglais ou Espagnol)"); //Langues possibles
				langueD = sc.nextLine();
				if (langueD.equals("Français") || langueD.equals("Francais") || langueD.equals("français") || langueD.equals("francais")){ //Tolérance d'orthographe
					langue1 = 0;
					Vérification = 1;
				}
				else if (langueD.equals("Anglais") || langueD.equals("anglais")){
					langue1 = 1;
					Vérification = 1;
				}
				else if (langueD.equals("Espagnol") || langueD.equals("espagnol")){
					langue1 = 2;
					Vérification = 1;
				}
				else {
					System.out.println("La langue saisie est invalide, veuillez recommencer"); //Message d'erreur si la langue choisie n'est pas le français, l'anglais ou l'espagnol
					Vérification = 0;
				}
			} while(Vérification == 0);

		//Choix de la langue final
		int langue2 = -1;
		String langueF;
		do {
				System.out.println("Langue de traduction ? (Français, Anglais ou Espagnol)"); //Langues possibles
				langueF = sc.nextLine();

				//Vérification que la langue de traduction choisie est identique à la langue de départ
				if (langueF.equals(langueD)){
					System.out.println("La langue saisie ne peut pas être utilisé, veuillez recommencer"); //Message d'erreur si la langue de traduction choisie est identique à la langue de départ
					Vérification = 0;
				}
				else if (langueF.equals("Français") || langueF.equals("Francais") || langueF.equals("français") || langueF.equals("francais")){ //Tolérance d'orthographe
					langue2 = 0;
					Vérification = 1;
				}
				else if (langueF.equals("Anglais") || langueF.equals("anglais")){ //Tolérance d'orthographe
					langue2 = 1;
					Vérification = 1;
				}
				else if (langueF.equals("Espagnol") || langueF.equals("espagnol")) { //Tolérance d'orthographe
					langue2 = 2;
					Vérification = 1;
				}
				else {
					System.out.println("La langue saisie est invalide, veuillez recommencer"); //Message d'erreur si la langue choisie n'est pas le français, l'anglais ou l'espagnol
					Vérification = 0;
				}
			} while (Vérification == 0);

		//Choix du nombre de tour
		String N;
		int X = 0;
		do {
			do {
				Vérification = 1;
				System.out.println("Combien de mots voulez vous traduire ?");
				N = sc.nextLine();
				try {
					Integer.parseInt(N);
					} catch (NumberFormatException e){
							System.out.println("Vous devez entrez un nombre entier.");
							Vérification = 0;
							}

			} while(Vérification == 0);
			X = Integer.valueOf(N);
			if (X > 28){
				System.out.println("Vous ne pouvez pas traduire plus de 28 mots.");
				Vérification = 0;
			}
		} while(Vérification ==0);

		//Jeu
		String mem = "."; //Initialisation mémoire vide
		String mot1; //Mot à traduire
		String mot2; //Mot à retrouver

		for (int i = 0; i !=X; i++){

			String[]TabResult = Mots(langue1, langue2, mem); //Retour des mots à partir de la fonction Mots
			mot1 = TabResult[0];
			mot2 = TabResult[1];
			mem = mem.concat(mot1); //Mémoire

			System.out.println("Le mot à traduire en " + langueF.toLowerCase() + " : " + mot1);

			//Réponse
			String Proposition;
			String Normalizer = sansAccents(mot2);

			Proposition = sc.nextLine();
			if (Proposition.equals(mot2) || Proposition.equals(Normalizer) || Proposition.equals(mot2.toLowerCase()) || Proposition.equals(Normalizer.toLowerCase())){ //Tolérance de bonne réponse
				System.out.println("Bravo ! Vous gagnez un point !"); //Message en cas de bonne réponse
				P++; // Ajout d'un point
			}
			else {
			System.out.println("Dommage ! La bonne réponse était : " + mot2); //Message en cas de mauvais réponse
			}
		}
		System.out.println("C'est fini ! Votre résultat final : " + P + "/" + X); //Affichage du résultat final
	}

	//Création du mot à traduire sans éventuel(s) accent(s)
	static public String sansAccents(String mot2) {
		return Normalizer.normalize(mot2, Normalizer.DECOMP, 0).replaceAll("[^\\p{ASCII}]", "");
	}

	//Création du mot aléatoire à retrouver
	static public String[] Mots(int langue1, int langue2, String mem){

		//Liste de mots
		String tab[][] = {{"Voiture","Chat","Visage","Bleu","Famille","Rouge","Vert","Maison","Jaune","Orange","Ordinateur","Souris","Crayon","Lit","Route","Jour","Nuit","Bonjour","Merci","Temps","Porte","Sable","Clavier","Mer","Père","Mère","Frère","Soeur","Dessin"},
				  {"Car","Cat","Face","Blue","Family","Red","Green","House","Yellow","Orange","Computer","Mouse","Pencil","Bed","Road","Day","Night","Hello","Thanks","Time","Door","Sand","Keyboard","Sea","Father","Mother","Brother","Sister","Drawing"},
				  {"Coche","Gato","Cara","Azul","Familia","Rojo","Verde","Casa","Amarillo","Naranja","Ordenador","Ratón","Lápiz","Cama","Camino","Día","Noche","Hola","Gracias","Tiempo","Puerta","Arena","Teclado","Mar","Padre","Madre","Hermano", "Hermana","Dibujo"}};

		//Mot aléatoire à traduire
		String mot1;
		int NbR;
		//Vérification que le mot choisi n'a pas déjà été choisi ultérieurment
		do {
			NbR = (int) (Math.round(Math.random()*28));
			mot1 = tab[langue1][NbR];
		} while (mem.contains(mot1));

		//Mot traduis à retrouver
		String mot2 = tab[langue2][NbR];

		//Renvoie des mots
		String[]result = new String[2];
		result[0] = mot1;
		result[1] = mot2;
		return result;
	}
}
