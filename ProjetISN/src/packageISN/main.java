package packageISN;

import java.util.Scanner;

import sun.text.Normalizer;


public class main {

	public static void main(String[] args) {

		//Refactor + boite de dial
		//Liste des mots
		String tab[][] = {{"Voiture","Chat","Visage","Bleu","Famille","Rouge","Vert","Maison","Jaune","Orange","Ordinateur","Souris","Crayon","Lit","Route","Jour","Nuit","Bonjour","Merci","Temps","Porte","Sable","Clavier","Mer","P�re","M�re","Fr�re","Soeur","Dessin"},
						  {"Car","Cat","Face","Blue","Family","Red","Green","House","Yellow","Orange","Computer","Mouse","Pencil","Bed","Road","Day","Night","Hello","Thanks","Time","Door","Sand","Keyboard","Sea","Father","Mother","Brother","Sister","Drawing"},
						  {"Coche","Gato","Cara","Azul","Familia","Rojo","Verde","Casa","Amarillo","Naranja","Ordenador","Rat�n","L�piz","Cama","Camino","D�a","Noche","Hola","Gracias","Tiempo","Puerta","Arena","Teclado","Mar","Padre","Madre","Hermano", "Hermana","Dibujo"}};

		//Scanner
		Scanner sc = new Scanner(System.in);

		//Compteur de bonne r�ponse
		int P = 0;

		//Choix de la langue de d�part
		int langue1 = -1;
		int V�rification = 0;
		String langueD;
		do {
				System.out.println("Langue de d�part ? (Fran�ais, Anglais ou Espagnol)");
				langueD = sc.nextLine();
				if (langueD.equals("Fran�ais") || langueD.equals("Francais") || langueD.equals("fran�ais") || langueD.equals("francais")){ //Tol�rance d'orthographe pour le choix de la langue fran�aise
					langue1 = 0;
					V�rification = 1;
				}
				else if (langueD.equals("Anglais") || langueD.equals("anglais")){ //Tol�rance d'orthographe pour le choix de la langue anglaise
					langue1 = 1;
					V�rification = 1;
				}
				else if (langueD.equals("Espagnol") || langueD.equals("espagnol")){ //Tol�rance d'orthographe pour le choix de la langue espagnole
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
				System.out.println("Langue de traduction ? (Fran�ais, Anglais ou Espagnol)");
				langueF = sc.nextLine();

				//V�rification que la langue de traduction choisie est identique � la langue de d�part
				if (langueF.equals(langueD)){
					System.out.println("La langue saisie ne peut pas �tre utilis�, veuillez recommencer"); //Message d'erreur si la langue de traduction choisie est identique � la langue de d�part
					V�rification = 0;
				}
				else if (langueF.equals("Fran�ais") || langueF.equals("Francais") || langueF.equals("fran�ais") || langueF.equals("francais")){ //Tol�rance d'orthographe pour le choix de la langue fran�aise
					langue2 = 0;
					V�rification = 1;
				}
				else if (langueF.equals("Anglais") || langueF.equals("anglais")){ //Tol�rance d'orthographe pour le choix de la langue anglaise
					langue2 = 1;
					V�rification = 1;
				}
				else if (langueF.equals("Espagnol") || langueF.equals("espagnol")) { //Tol�rance d'orthographe pour le choix de la langue espagnole
					langue2 = 2;
					V�rification = 1;
				}
				else {
					System.out.println("La langue saisie est invalide, veuillez recommencer"); //Message d'erreur si la langue choisie n'est pas le fran�ais, l'anglais ou l'espagnol
					V�rification = 0;
				}
			} while (V�rification == 0);

		//Choix du nombre de tour
		int X = 0;
		do {
			System.out.println("Combien de mots voulez vous traduire ?");
			X = sc.nextInt();
			if (X > 30){
				System.out.println("Vous ne pouvez pas traduire plus de 30 mots.");
				V�rification = 0;
			}
			else {
				V�rification = 1;
			}
		} while(V�rification == 0);

		//Jeu
		String mem = "";
		for (int i = 0; i !=X; i++){

			//Mot al�atoire � traduire
			String mot1;
			int NbR;
			//V�rification que le mot choisi n'a pas d�j� �t� choisi ult�rieurment
			do {
				NbR = (int) (Math.round(Math.random()*28));
				mot1 = tab[langue1][NbR];
			} while (mem.contains(mot1));
			System.out.println("Le mot � traduire en " + langueF.toLowerCase() + " : " + mot1);
			mem = mem.concat(mot1); //M�moire

			//Mot traduis � retrouver
			String mot2 = tab[langue2][NbR];

			//R�ponse
			String Proposition;
			String Normalizer = sansAccents(mot2);
			System.out.println(Normalizer);
			if (i == 0){
				Proposition = sc.nextLine();
			}
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
	
	

}
