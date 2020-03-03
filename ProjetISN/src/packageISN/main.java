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
					System.out.println("La langue saisie est invalide, veuillez recommencer."); //Message d'erreur si la langue choisie n'est pas le français, l'anglais ou l'espagnol
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
				if (langueF.equals("Français") || langueF.equals("Francais") || langueF.equals("français") || langueF.equals("francais")){ //Tolérance d'orthographe
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
					System.out.println("La langue saisie est invalide, veuillez recommencer."); //Message d'erreur si la langue choisie n'est pas le français, l'anglais ou l'espagnol
					Vérification = 0;
				}
				if (langue2 == langue1){
					System.out.println("La langue saisie ne peut pas être utilisé, veuillez recommencer"); //Message d'erreur si la langue de traduction choisie est identique à la langue de départ
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
			if (X > 30){
				System.out.println("Vous ne pouvez pas traduire plus de 30 mots.");
				Vérification = 0;
			}
		} while(Vérification ==0);

		//Choix du thème
		String choixTheme = "";
		int Theme = 1;
		int Y = 0;
		do {
			System.out.println("Voulez vous choisir un thème ? (HighTech, Sport, Nourriture, Maison, Aucun)");
			choixTheme = sc.nextLine();
			if (choixTheme.equals("HighTech") || choixTheme.equals("hightech") || choixTheme.equals("Hightech") || choixTheme.equals("highTech")){
				Theme = 0;
				Y = 29;
				Vérification = 1;
			}
			else if (choixTheme.equals("Nourriture") || choixTheme.equals("nourriture")){
				Theme = 30;
				Y = 29;
				Vérification = 1;
			}
			else if (choixTheme.equals("Sport") || choixTheme.equals("sport")){
				Theme = 60;
				Y = 29;
				Vérification = 1;
			}
			else if (choixTheme.equals("Maison") || choixTheme.equals("maison")) {
				Theme = 90;
				Y = 29;
				Vérification = 1;
			}
			else if (choixTheme.equals("Aucun") || choixTheme.equals("aucun")){
				Y = 119;
				Vérification = 1;
			}
			else { System.out.println("Le théme séléctionné est invalide, veuillez recommencer.");
				   Vérification = 0;
			}
		} while (Vérification == 0);


		//Jeu
		String mem = ""; //Initialisation mémoire vide
		String mot1; //Mot à traduire
		String mot2; //Mot à retrouver

		for (int i = 0; i != X; i++){

			String[]TabResult = Mots(langue1, langue2, mem, Theme, Y); //Retour des mots à partir de la fonction Mots
			mot1 = TabResult[0];
			mot2 = TabResult[1];
			mem = mem.concat(mot1); //Ajout du mot dans la mémoire

			System.out.println("Le mot à traduire en " + langueF.toLowerCase() + " : " + mot1);

			//Réponse
			String Proposition;
			String Normalizer = sansAccents(mot2); //Mot à retrouver sans accents s'il y en a

			Proposition = sc.nextLine();
			if (Proposition.equals(mot2) || Proposition.equals(Normalizer) || Proposition.equals(mot2.toLowerCase()) || Proposition.equals(Normalizer.toLowerCase())){ //Tolérance de bonne réponse
				System.out.println("Bravo ! Vous gagnez un point !"); //Message en cas de bonne réponse
				P++; // Ajout d'un point
			}
			else {
			System.out.println("Dommage ! La bonne réponse était : " + mot2); //Message en cas de mauvaise réponse
			}
		}

		//Affichage du résultat final et de la moyenne de bonne réponse
		int H = (P*100/X);
		System.out.println("C'est fini ! Votre résultat final : " + P + "/" + X + " soit " + H + "% de bonnes réponses !");
	}



	//Création du mot à traduire sans éventuel(s) accent(s)
	static public String sansAccents(String mot2) {
		return Normalizer.normalize(mot2, Normalizer.DECOMP, 0).replaceAll("[^\\p{ASCII}]", "");
	}



	//Création des mots
	static public String[] Mots(int langue1, int langue2, String mem, int Theme, int Y){

		//Liste de mots
		String tab[][] = {{"Technologie","Smartphone","Ordinateur","Câble","Carte graphique","Processeur","Souris","Clavier","Réseau","Adresse IP","Tablette","Écran tactile","Batterie", "Programmation","Bluetooth", "WiFi", "Écran","Serveur","Électronique","Système d’exploitation","Logiciel","Drone","Ecouteurs","Montre connectée","Futur","Réalité virtuelle","Numérique","Automatisation","Domotique","Cybersécurité" 	,"Manger","Frite","Pâte","Soda","Pizza","Steak","Eau","Boire","Fruit","Pomme","Poire","Banane","Petit pois","Pomme de terre","Tomate","Burger" ,"Poisson","Saumon","Chocolat","Avocat","Légume","Crêpe","Fromage","Vin","Sushi","Glace","Tarte","Ananas","Bière","Choucroute"	,"Lancer de javelot","Lancer de disque","Saut à la perche","Saut en hauteur","Course","Décathlon","Heptathlon","Marathon","Triathlon","Cyclisme","Volleyball","Handball","Basketball","Football","Curling","Danse","Gymnastique","Ski de fond","Biathlon","Jeux Olympiques","Natation","Tir à l'arc","Canoë","Judo","Relais","Championnat du monde","Fair play","Boxe","Escrime","Rugby"  	 	 ,"Toit","Jardin","Porte","Paillasson","Table","Chaise","Canapé","Fauteuil","Télévision","Meuble","Salon","Chambre","Salle de bain","Cuisine","Garage","Lit","Commode","Bureau","Tiroir","Armoire","Réfrigérateur","Gazinière","Micro Onde","Four","Lavabo","Douche","Bain","Couteau","Fourchette","Cuillère"   ,},
				          {"Technology", "Smartphone","Computer","Cable","Graphics Card","Processor","Mouse","Keyboard","Network","IP Address","Tablet","Touch Screen","Battery","Programming","Bluetooth","WiFi","Screen","Server","Electronics","Operating System","Software","Drone","Headphones","Connected Watch","Future","Virtual Reality","Digital","Automating","Automation","cybersecurity"   							,"Eat","Chip","Paste","Soda","Pizza","Steak","Water","Drink","Fruit","Apple","Pear","Banana","Peas","Potato","Tomato","Burger","Fish","Salmon","Chocolate","Avocado","Vegetable","Crepe","Cheese","Wine","Sushi","Ice","Pie","Pineapple","Beer","Sauerkraut" 					,"Javelin Throw", "Discus Throw", "Pole vault", "High Jump", "Race", "Decathlon", "Heptathlon", "Marathon", "Triathlon","Cycling","Volleyball","Handball","Basketball","Football","Curling","Dance","Gymnastics ","Cross Country Skiing","Biathlon","Olympic Games","Swimming","Shooting bow","Canoe","Judo","Relay","World Championship","Fair play","Boxing","Fencing","Rugby"        		 ,"Roof", "Garden", "Door", "Mat", "Table", "Chair", "Sofa", "Armchair", "Television", "Stand", "Lounge", "Room", "Bathroom Bath","Kitchen","Garage","Bed","Chest of drawers","Desk","Drawer","Cabinet","Refrigerator","Gas stove","Microwave","Oven","Sink","Shower","Bath","Knife","Range","Spoon"            ,},
				          {"Tecnología","Teléfono inteligente","Computadora","Cable","Tarjeta gráfica","Procesador","Ratón","Teclado","Red","Dirección IP","Tableta","Pantalla táctil","Batería","Programación","Bluetooth","WiFi","Pantalla","Servidor","Electrónica","Sistema de operación","Software","Drone","Audífonos","Reloj conectado","Futuro","Realidad virtual","Digital","Automatización","Domótica","ciberseguridad"	,"Comer","Frito","Pasta","Soda","Pizza","Bistec","Agua","Bebida","Fruta","Manzana","Pera","Banana","Arjeva","Patata","Tomate","Hamburguesa","Pescado","Salmón","Chocolate","Abogado","Vegetal","Crepe","Queso","Vino","Sushi","Hielo","Pastel","Piña","Cerveza","Chucrut"		,"Lanzamiento de jabalina","Lanzamiento de disco","Salto de poste","Salto de altura", "Carrera","Decatlón","Heptatlón","Maratón","Triatlón","Ciclismo","Voleibol","Balonmano","Baloncesto","Fútbol","Curling","Danza","Gimnasia","Esquí de fondo","Biatlón","Juegos olímpicos","Natación","Tiro Arco","Canoa","Judo","Relevo","Campeonato Mundial","Juego limpio","Boxeo","Esgrima","Rugby"      ,"Tejado","Jardín","Puerta","Ratón","Tabla","Silla","Sofá","Sillón","Televisión","Stand","Salón","Sala","Cuarto de baño","Cocina","Garaje","Cama","Cajonera","Escritorio","Cajón","Gabinete","Refrigerador","Cocina de gas","Microondas","Horno","Fregadero","La ducha","baño","Cuchillo","Gama","Cuchara"	   ,}};


		//Mot aléatoire à traduire et vérification qu'il n'a pas déjà été choisi précédemment
		String mot1;
		int NbR;

		do {
			NbR = (int) (Math.round(Math.random()*Y));
			NbR = NbR + Theme;
			mot1 = tab[langue1][NbR];
		} while (mem.contains(mot1));

		//Mot traduis à retrouver
		String mot2 = tab[langue2][NbR];

		//Renvoie des mots dans le programme principal
		String[]result = new String[2];
		result[0] = mot1;
		result[1] = mot2;
		return result;
	}
}

