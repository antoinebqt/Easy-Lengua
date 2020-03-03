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
					System.out.println("La langue saisie est invalide, veuillez recommencer."); //Message d'erreur si la langue choisie n'est pas le fran�ais, l'anglais ou l'espagnol
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
				if (langueF.equals("Fran�ais") || langueF.equals("Francais") || langueF.equals("fran�ais") || langueF.equals("francais")){ //Tol�rance d'orthographe
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
					System.out.println("La langue saisie est invalide, veuillez recommencer."); //Message d'erreur si la langue choisie n'est pas le fran�ais, l'anglais ou l'espagnol
					V�rification = 0;
				}
				if (langue2 == langue1){
					System.out.println("La langue saisie ne peut pas �tre utilis�, veuillez recommencer"); //Message d'erreur si la langue de traduction choisie est identique � la langue de d�part
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
			if (X > 30){
				System.out.println("Vous ne pouvez pas traduire plus de 30 mots.");
				V�rification = 0;
			}
		} while(V�rification ==0);

		//Choix du th�me
		String choixTheme = "";
		int Theme = 1;
		int Y = 0;
		do {
			System.out.println("Voulez vous choisir un th�me ? (HighTech, Sport, Nourriture, Maison, Aucun)");
			choixTheme = sc.nextLine();
			if (choixTheme.equals("HighTech") || choixTheme.equals("hightech") || choixTheme.equals("Hightech") || choixTheme.equals("highTech")){
				Theme = 0;
				Y = 29;
				V�rification = 1;
			}
			else if (choixTheme.equals("Nourriture") || choixTheme.equals("nourriture")){
				Theme = 30;
				Y = 29;
				V�rification = 1;
			}
			else if (choixTheme.equals("Sport") || choixTheme.equals("sport")){
				Theme = 60;
				Y = 29;
				V�rification = 1;
			}
			else if (choixTheme.equals("Maison") || choixTheme.equals("maison")) {
				Theme = 90;
				Y = 29;
				V�rification = 1;
			}
			else if (choixTheme.equals("Aucun") || choixTheme.equals("aucun")){
				Y = 119;
				V�rification = 1;
			}
			else { System.out.println("Le th�me s�l�ctionn� est invalide, veuillez recommencer.");
				   V�rification = 0;
			}
		} while (V�rification == 0);


		//Jeu
		String mem = ""; //Initialisation m�moire vide
		String mot1; //Mot � traduire
		String mot2; //Mot � retrouver

		for (int i = 0; i != X; i++){

			String[]TabResult = Mots(langue1, langue2, mem, Theme, Y); //Retour des mots � partir de la fonction Mots
			mot1 = TabResult[0];
			mot2 = TabResult[1];
			mem = mem.concat(mot1); //Ajout du mot dans la m�moire

			System.out.println("Le mot � traduire en " + langueF.toLowerCase() + " : " + mot1);

			//R�ponse
			String Proposition;
			String Normalizer = sansAccents(mot2); //Mot � retrouver sans accents s'il y en a

			Proposition = sc.nextLine();
			if (Proposition.equals(mot2) || Proposition.equals(Normalizer) || Proposition.equals(mot2.toLowerCase()) || Proposition.equals(Normalizer.toLowerCase())){ //Tol�rance de bonne r�ponse
				System.out.println("Bravo ! Vous gagnez un point !"); //Message en cas de bonne r�ponse
				P++; // Ajout d'un point
			}
			else {
			System.out.println("Dommage ! La bonne r�ponse �tait : " + mot2); //Message en cas de mauvaise r�ponse
			}
		}

		//Affichage du r�sultat final et de la moyenne de bonne r�ponse
		int H = (P*100/X);
		System.out.println("C'est fini ! Votre r�sultat final : " + P + "/" + X + " soit " + H + "% de bonnes r�ponses !");
	}



	//Cr�ation du mot � traduire sans �ventuel(s) accent(s)
	static public String sansAccents(String mot2) {
		return Normalizer.normalize(mot2, Normalizer.DECOMP, 0).replaceAll("[^\\p{ASCII}]", "");
	}



	//Cr�ation des mots
	static public String[] Mots(int langue1, int langue2, String mem, int Theme, int Y){

		//Liste de mots
		String tab[][] = {{"Technologie","Smartphone","Ordinateur","C�ble","Carte graphique","Processeur","Souris","Clavier","R�seau","Adresse IP","Tablette","�cran tactile","Batterie", "Programmation","Bluetooth", "WiFi", "�cran","Serveur","�lectronique","Syst�me d�exploitation","Logiciel","Drone","Ecouteurs","Montre connect�e","Futur","R�alit� virtuelle","Num�rique","Automatisation","Domotique","Cybers�curit�" 	,"Manger","Frite","P�te","Soda","Pizza","Steak","Eau","Boire","Fruit","Pomme","Poire","Banane","Petit pois","Pomme de terre","Tomate","Burger" ,"Poisson","Saumon","Chocolat","Avocat","L�gume","Cr�pe","Fromage","Vin","Sushi","Glace","Tarte","Ananas","Bi�re","Choucroute"	,"Lancer de javelot","Lancer de disque","Saut � la perche","Saut en hauteur","Course","D�cathlon","Heptathlon","Marathon","Triathlon","Cyclisme","Volleyball","Handball","Basketball","Football","Curling","Danse","Gymnastique","Ski de fond","Biathlon","Jeux Olympiques","Natation","Tir � l'arc","Cano�","Judo","Relais","Championnat du monde","Fair play","Boxe","Escrime","Rugby"  	 	 ,"Toit","Jardin","Porte","Paillasson","Table","Chaise","Canap�","Fauteuil","T�l�vision","Meuble","Salon","Chambre","Salle de bain","Cuisine","Garage","Lit","Commode","Bureau","Tiroir","Armoire","R�frig�rateur","Gazini�re","Micro Onde","Four","Lavabo","Douche","Bain","Couteau","Fourchette","Cuill�re"   ,},
				          {"Technology", "Smartphone","Computer","Cable","Graphics Card","Processor","Mouse","Keyboard","Network","IP Address","Tablet","Touch Screen","Battery","Programming","Bluetooth","WiFi","Screen","Server","Electronics","Operating System","Software","Drone","Headphones","Connected Watch","Future","Virtual Reality","Digital","Automating","Automation","cybersecurity"   							,"Eat","Chip","Paste","Soda","Pizza","Steak","Water","Drink","Fruit","Apple","Pear","Banana","Peas","Potato","Tomato","Burger","Fish","Salmon","Chocolate","Avocado","Vegetable","Crepe","Cheese","Wine","Sushi","Ice","Pie","Pineapple","Beer","Sauerkraut" 					,"Javelin Throw", "Discus Throw", "Pole vault", "High Jump", "Race", "Decathlon", "Heptathlon", "Marathon", "Triathlon","Cycling","Volleyball","Handball","Basketball","Football","Curling","Dance","Gymnastics ","Cross Country Skiing","Biathlon","Olympic Games","Swimming","Shooting bow","Canoe","Judo","Relay","World Championship","Fair play","Boxing","Fencing","Rugby"        		 ,"Roof", "Garden", "Door", "Mat", "Table", "Chair", "Sofa", "Armchair", "Television", "Stand", "Lounge", "Room", "Bathroom Bath","Kitchen","Garage","Bed","Chest of drawers","Desk","Drawer","Cabinet","Refrigerator","Gas stove","Microwave","Oven","Sink","Shower","Bath","Knife","Range","Spoon"            ,},
				          {"Tecnolog�a","Tel�fono inteligente","Computadora","Cable","Tarjeta gr�fica","Procesador","Rat�n","Teclado","Red","Direcci�n IP","Tableta","Pantalla t�ctil","Bater�a","Programaci�n","Bluetooth","WiFi","Pantalla","Servidor","Electr�nica","Sistema de operaci�n","Software","Drone","Aud�fonos","Reloj conectado","Futuro","Realidad virtual","Digital","Automatizaci�n","Dom�tica","ciberseguridad"	,"Comer","Frito","Pasta","Soda","Pizza","Bistec","Agua","Bebida","Fruta","Manzana","Pera","Banana","Arjeva","Patata","Tomate","Hamburguesa","Pescado","Salm�n","Chocolate","Abogado","Vegetal","Crepe","Queso","Vino","Sushi","Hielo","Pastel","Pi�a","Cerveza","Chucrut"		,"Lanzamiento de jabalina","Lanzamiento de disco","Salto de poste","Salto de altura", "Carrera","Decatl�n","Heptatl�n","Marat�n","Triatl�n","Ciclismo","Voleibol","Balonmano","Baloncesto","F�tbol","Curling","Danza","Gimnasia","Esqu� de fondo","Biatl�n","Juegos ol�mpicos","Nataci�n","Tiro Arco","Canoa","Judo","Relevo","Campeonato Mundial","Juego limpio","Boxeo","Esgrima","Rugby"      ,"Tejado","Jard�n","Puerta","Rat�n","Tabla","Silla","Sof�","Sill�n","Televisi�n","Stand","Sal�n","Sala","Cuarto de ba�o","Cocina","Garaje","Cama","Cajonera","Escritorio","Caj�n","Gabinete","Refrigerador","Cocina de gas","Microondas","Horno","Fregadero","La ducha","ba�o","Cuchillo","Gama","Cuchara"	   ,}};


		//Mot al�atoire � traduire et v�rification qu'il n'a pas d�j� �t� choisi pr�c�demment
		String mot1;
		int NbR;

		do {
			NbR = (int) (Math.round(Math.random()*Y));
			NbR = NbR + Theme;
			mot1 = tab[langue1][NbR];
		} while (mem.contains(mot1));

		//Mot traduis � retrouver
		String mot2 = tab[langue2][NbR];

		//Renvoie des mots dans le programme principal
		String[]result = new String[2];
		result[0] = mot1;
		result[1] = mot2;
		return result;
	}
}

