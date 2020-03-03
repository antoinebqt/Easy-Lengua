package packageISN;

import java.util.Scanner;

import sun.text.Normalizer;

public class Main {

	public static void main(String[] args) {

		//Scanner
		Scanner sc = new Scanner(System.in);

		//Compteur de bonne r�ponse
		int P = 0;

		//V�rificateur de boucle do
		int V�rification = 0;

		//Choix de la langue de d�part
		int langue1 = -1;
		String langueD;
		do {
				System.out.println("Langue de d�part ? (Fran�ais, Anglais ou Espagnol)"); //Langues possibles
				langueD = sc.nextLine();
				if (langueD.equals("Fran�ais") || langueD.equals("Francais") || langueD.equals("fran�ais") || langueD.equals("francais")){ //Tol�rance d'orthographe
					langue1 = 0;
					V�rification = 1;
				}
				else if (langueD.equals("Anglais") || langueD.equals("anglais")){
					langue1 = 1;
					V�rification = 1;
				}
				else if (langueD.equals("Espagnol") || langueD.equals("espagnol")){
					langue1 = 2;
					V�rification = 1;
				}
				else {
					System.out.println("La langue saisie est invalide, veuillez recommencer"); //Message d'erreur si la langue choisie n'est pas le fran�ais, l'anglais ou l'espagnol
					V�rification = 0;
				}
			} while(V�rification == 0);

		//Choix de la langue final
		int langue2 = -1;
		String langueF;
		do {
				System.out.println("Langue de traduction ? (Fran�ais, Anglais ou Espagnol)"); //Langues possibles
				langueF = sc.nextLine();

				//V�rification que la langue de traduction choisie est identique � la langue de d�part
				if (langueF.equals(langueD)){
					System.out.println("La langue saisie ne peut pas �tre utilis�, veuillez recommencer"); //Message d'erreur si la langue de traduction choisie est identique � la langue de d�part
					V�rification = 0;
				}
				else if (langueF.equals("Fran�ais") || langueF.equals("Francais") || langueF.equals("fran�ais") || langueF.equals("francais")){ //Tol�rance d'orthographe
					langue2 = 0;
					V�rification = 1;
				}
				else if (langueF.equals("Anglais") || langueF.equals("anglais")){ //Tol�rance d'orthographe
					langue2 = 1;
					V�rification = 1;
				}
				else if (langueF.equals("Espagnol") || langueF.equals("espagnol")) { //Tol�rance d'orthographe
					langue2 = 2;
					V�rification = 1;
				}
				else {
					System.out.println("La langue saisie est invalide, veuillez recommencer"); //Message d'erreur si la langue choisie n'est pas le fran�ais, l'anglais ou l'espagnol
					V�rification = 0;
				}
			} while (V�rification == 0);

		//Choix du nombre de tour
		String N;
		int X = 0;
		do {
			do {
				V�rification = 1;
				System.out.println("Combien de mots voulez vous traduire ?");
				N = sc.nextLine();
				try {
					Integer.parseInt(N);
					} catch (NumberFormatException e){
							System.out.println("Vous devez entrez un nombre entier.");
							V�rification = 0;
							}

			} while(V�rification == 0);
			X = Integer.valueOf(N);
			if (X > 28){
				System.out.println("Vous ne pouvez pas traduire plus de 28 mots.");
				V�rification = 0;
			}
		} while(V�rification ==0);

		//Jeu
		String mem = "."; //Initialisation m�moire vide
		String mot1; //Mot � traduire
		String mot2; //Mot � retrouver

		for (int i = 0; i !=X; i++){

			String[]TabResult = Mots(langue1, langue2, mem); //Retour des mots � partir de la fonction Mots
			mot1 = TabResult[0];
			mot2 = TabResult[1];
			mem = mem.concat(mot1); //M�moire

			System.out.println("Le mot � traduire en " + langueF.toLowerCase() + " : " + mot1);

			//R�ponse
			String Proposition;
			String Normalizer = sansAccents(mot2);

			Proposition = sc.nextLine();
			if (Proposition.equals(mot2) || Proposition.equals(Normalizer) || Proposition.equals(mot2.toLowerCase()) || Proposition.equals(Normalizer.toLowerCase())){ //Tol�rance de bonne r�ponse
				System.out.println("Bravo ! Vous gagnez un point !"); //Message en cas de bonne r�ponse
				P++; // Ajout d'un point
			}
			else {
			System.out.println("Dommage ! La bonne r�ponse �tait : " + mot2); //Message en cas de mauvais r�ponse
			}
		}
		System.out.println("C'est fini ! Votre r�sultat final : " + P + "/" + X); //Affichage du r�sultat final
	}

	//Cr�ation du mot � traduire sans �ventuel(s) accent(s)
	static public String sansAccents(String mot2) {
		return Normalizer.normalize(mot2, Normalizer.DECOMP, 0).replaceAll("[^\\p{ASCII}]", "");
	}

	//Cr�ation du mot al�atoire � retrouver
	static public String[] Mots(int langue1, int langue2, String mem){

		//Liste de mots
		String tab[][] = {{"Voiture","Chat","Visage","Bleu","Famille","Rouge","Vert","Maison","Jaune","Orange","Ordinateur","Souris","Crayon","Lit","Route","Jour","Nuit","Bonjour","Merci","Temps","Porte","Sable","Clavier","Mer","P�re","M�re","Fr�re","Soeur","Dessin"},
				  {"Car","Cat","Face","Blue","Family","Red","Green","House","Yellow","Orange","Computer","Mouse","Pencil","Bed","Road","Day","Night","Hello","Thanks","Time","Door","Sand","Keyboard","Sea","Father","Mother","Brother","Sister","Drawing"},
				  {"Coche","Gato","Cara","Azul","Familia","Rojo","Verde","Casa","Amarillo","Naranja","Ordenador","Rat�n","L�piz","Cama","Camino","D�a","Noche","Hola","Gracias","Tiempo","Puerta","Arena","Teclado","Mar","Padre","Madre","Hermano", "Hermana","Dibujo"}};

		//Mot al�atoire � traduire
		String mot1;
		int NbR;
		//V�rification que le mot choisi n'a pas d�j� �t� choisi ult�rieurment
		do {
			NbR = (int) (Math.round(Math.random()*28));
			mot1 = tab[langue1][NbR];
		} while (mem.contains(mot1));

		//Mot traduis � retrouver
		String mot2 = tab[langue2][NbR];

		//Renvoie des mots
		String[]result = new String[2];
		result[0] = mot1;
		result[1] = mot2;
		return result;
	}
}
