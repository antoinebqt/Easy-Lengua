package packageISN;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		//Compteur de bonne réponse
		int P = 0;

		//Vérificateur de boucle do
		int Vérification = 0;

		//Choix de la langue de départ
		String[] langue = {"Choisir une langue","Français","Anglais","Espagnol"}; //Langue possible
		int langue1 = -1;
		String langueD;
		do {
				langueD = (String)JOptionPane.showInputDialog(null, "Langue de départ ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE, null, langue, langue[0]); //Message demandant la langue de départ à l'utilisateur
				if (langueD.toUpperCase().equals("FRANCAIS") || langueD.toUpperCase().equals("FRANÇAIS")){ //Tolérance d'orthographe
					langue1 = 0;
					Vérification = 1;
				}
				else if (langueD.toUpperCase().equals("ANGLAIS")){
					langue1 = 1;
					Vérification = 1;
				}
				else if (langueD.toUpperCase().equals("ESPAGNOL")){
					langue1 = 2;
					Vérification = 1;
				}
				else {
					JOptionPane.showMessageDialog(null, "La langue saisie est invalide, veuillez recommencer", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE); //Message d'erreur si la langue choisie n'est pas le français, l'anglais ou l'espagnol
					Vérification = 0;
				}
			} while(Vérification == 0);

		//Choix de la langue final
		int langue2 = -1;
		String langueF;
		do {
			langueF = (String)JOptionPane.showInputDialog(null, "Langue de traduction ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE, null, langue, langue[0]); //Message demandant la langue de traduction à l'utilisateur

				if (langueF.toUpperCase().equals("FRANCAIS") || langueF.toUpperCase().equals("FRANÇAIS")){ //Tolérance d'orthographe
					langue2 = 0;
					Vérification = 1;
				}
				else if (langueF.toUpperCase().equals("ANGLAIS")){
					langue2 = 1;
					Vérification = 1;
				}
				else if (langueF.toUpperCase().equals("ESPAGNOL")){
					langue2 = 2;
					Vérification = 1;
				}
				else {
					JOptionPane.showMessageDialog(null, "La langue saisie est invalide, veuillez recommencer", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE); //Message d'erreur si la langue choisie n'est pas le français, l'anglais ou l'espagnol
					Vérification = 0;
				}
				if (langue2 == langue1){
					JOptionPane.showMessageDialog(null, "La langue saisie ne peut pas être utilisée, veuillez recommencer", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE); //Message d'erreur si la langue de traduction choisie est identique à la langue de départ
					Vérification = 0;
				}
			} while (Vérification == 0);

		//Choix du nombre de tour
		String N;
		int X = 0;
		do {
			do {
				Vérification = 1;
				N = JOptionPane.showInputDialog(null, "Combien de mots voulez traduire ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE);
				try {
					Integer.parseInt(N);
					} catch (NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Vous devez entrez un nombre entier", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE);
							Vérification = 0;
							}

			} while(Vérification == 0);
			X = Integer.valueOf(N);
			if (X > 30){
				JOptionPane.showMessageDialog(null, "Vous ne pouvez pas traduire plus de 30 mots.", "Easy Lengua - Erreur", JOptionPane.WARNING_MESSAGE);
				Vérification = 0;
			}
		} while(Vérification ==0);

		//Choix du thème
		String[] ListeThemes = {"Choisir un thème","HighTech","Sport","Nourriture","Maison","Aucun"}; //Thème possible
		int Theme = 1;
		int Y = 1;
		do {
			String choixTheme = (String)JOptionPane.showInputDialog(null, "Voulez vous choisir un thème ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE, null, ListeThemes, ListeThemes[0]);
			if (choixTheme.toUpperCase().equals("HIGHTECH")){
				Theme = 0;
				Y = 29;
				Vérification = 1;
			}
			else if (choixTheme.toUpperCase().equals("NOURRITURE")){
				Theme = 30;
				Y = 29;
				Vérification = 1;
			}
			else if (choixTheme.toUpperCase().equals("SPORT")){
				Theme = 60;
				Y = 29;
				Vérification = 1;
			}
			else if (choixTheme.toUpperCase().equals("MAISON")){
				Theme = 90;
				Y = 29;
				Vérification = 1;
			}
			else if (choixTheme.toUpperCase().equals("AUCUN")){
				Y = 119;
				Vérification = 1;
			}
			else {
				JOptionPane.showMessageDialog(null, "Le thème sélectionné est invalide, veuillez recommencer", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE);
				   Vérification = 0;
			}
		} while (Vérification == 0);


		//Jeu
		String mem = ""; //Initialisation mémoire vide
		String mot1; //Mot à traduire
		String mot2; //Mot à retrouver

		for (int i = 0; i != X; i++){

			String[] TabResult = Mots(langue1, langue2, mem, Theme, Y); //Retour des mots à partir de la fonction Mots
			mot1 = TabResult[0].toUpperCase();
			mot2 = TabResult[1].toUpperCase();
			mem = mem.concat(mot1); //Ajout du mot dans la mémoire

			System.out.println("Le mot à traduire en " + langueF.toLowerCase() + " : " + mot1);

			//Réponse
			String Proposition;
			String mot2SA = sansAccents(mot2).toUpperCase(); //Mot à retrouver sans accents s'il y en a

			Proposition = JOptionPane.showInputDialog(null, "Le mot à traduire en " + langueF.toLowerCase() + " : " + mot1, "Easy Lengua", JOptionPane.QUESTION_MESSAGE);
			if (Proposition.toUpperCase().equals(mot2) || Proposition.toUpperCase().equals(mot2SA)){ //Tolérance de bonne réponse
				JOptionPane.showMessageDialog(null, "Bravo, vous gagnez un point !", "Easy Lengua", JOptionPane.INFORMATION_MESSAGE); //Message en cas de bonne réponse
				P++; // Ajout d'un point
			}
			else {
				JOptionPane.showMessageDialog(null, "Dommage ! La bonne réponse était : " + mot2, "Easy Lengua", JOptionPane.INFORMATION_MESSAGE); //Message en cas de mauvaise réponse
			}
		}

		//Affichage du résultat final et de la moyenne de bonne réponse
		int H = (P*100/X);
		JOptionPane.showMessageDialog(null, "C'est fini ! Votre résultat final : " + P + "/" + X + " soit " + H + "% de bonnes réponses !", "Easy Lengua", JOptionPane.INFORMATION_MESSAGE);
	}



	//Création du mot à traduire sans éventuel(s) accent(s)
	static public String sansAccents(String mot2) {

		//Liste des accents possible
		String Tab[][] = {{"À","Â","Ä","Á","É","Ê","Ë","È","Ï","Î","Í","Ô","Ó","Ù","Û","Ü","Ú","Ÿ","Ñ","Ç"},
		          		  {"A","A","A","A","E","E","E","E","I","I","I","O","O","U","U","U","U","Y","N","C"}};

		String x = "";
		String y = "";

		for(int n = 0 ;n !=20; n++){
			x = Tab[0][n];
			y = Tab[1][n];

			if (mot2.contains(x)){ //Vérification pour chaque accent si il est contenu dans le mot
				mot2 = mot2.replace(x,y); //Remplacement de la lettre avec accent par sa lettre sans accent
			}
		}
		return mot2;
	}

	//Création des mots
	static public String[] Mots(int langue1, int langue2, String mem, int Theme, int Y){

		//Liste de mots
		String tab[][] = {{"Technologie","Smartphone","Ordinateur","Câble","Carte graphique","Processeur","Souris","Clavier","Réseau","Adresse IP","Tablette","Écran tactile","Batterie", "Programmation","Bluetooth", "WiFi", "Écran","Serveur","Électronique","Système d’exploitation","Logiciel","Drone","Ecouteurs","Montre connectée","Futur","Réalité virtuelle","Numérique","Automatisation","Domotique","Cybersécurité" 	,"Manger","Frite","Pâte","Soda","Pizza","Steak","Eau","Boire","Fruit","Pomme","Poire","Banane","Petit pois","Pomme de terre","Tomate","Burger" ,"Poisson","Saumon","Chocolat","Avocat","Légume","Crêpe","Fromage","Vin","Sushi","Glace","Tarte","Ananas","Bière","Choucroute"	,"Lancer de javelot","Lancer de disque","Saut à la perche","Saut en hauteur","Course","Décathlon","Heptathlon","Marathon","Triathlon","Cyclisme","Volleyball","Handball","Basketball","Football","Curling","Danse","Gymnastique","Ski de fond","Biathlon","Jeux Olympiques","Natation","Tir à l'arc","Canoë","Judo","Relais","Championnat du monde","Fair play","Boxe","Escrime","Rugby"  	 	 ,"Toit","Jardin","Porte","Paillasson","Table","Chaise","Canapé","Fauteuil","Télévision","Meuble","Salon","Chambre","Salle de bain","Cuisine","Garage","Lit","Commode","Bureau","Tiroir","Armoire","Réfrigérateur","Gazinière","Micro Onde","Four","Lavabo","Douche","Bain","Couteau","Fourchette","Cuillère"   ,},
				          {"Technology", "Smartphone","Computer","Cable","Graphics Card","Processor","Mouse","Keyboard","Network","IP Address","Tablet","Touch Screen","Battery","Programming","Bluetooth","WiFi","Screen","Server","Electronics","Operating System","Software","Drone","Headphones","Connected Watch","Future","Virtual Reality","Digital","Automating","Automation","cybersecurity"   							,"Eat","Chip","Paste","Soda","Pizza","Steak","Water","Drink","Fruit","Apple","Pear","Banana","Peas","Potato","Tomato","Burger","Fish","Salmon","Chocolate","Avocado","Vegetable","Crepe","Cheese","Wine","Sushi","Ice","Pie","Pineapple","Beer","Sauerkraut" 					,"Javelin Throw", "Discus Throw", "Pole vault", "High Jump", "Race", "Decathlon", "Heptathlon", "Marathon", "Triathlon","Cycling","Volleyball","Handball","Basketball","Football","Curling","Dance","Gymnastics ","Cross Country Skiing","Biathlon","Olympic Games","Swimming","Shooting bow","Canoe","Judo","Relay","World Championship","Fair play","Boxing","Fencing","Rugby"        		 ,"Roof", "Garden", "Door", "Mat", "Table", "Chair", "Sofa", "Armchair", "Television", "Stand", "Lounge", "Room", "Bathroom Bath","Kitchen","Garage","Bed","Chest of drawers","Desk","Drawer","Cabinet","Refrigerator","Gas stove","Microwave","Oven","Sink","Shower","Bath","Knife","Range","Spoon"            ,},
				          {"Tecnología","Teléfono inteligente","Computadora","Cable","Tarjeta gráfica","Procesador","Ratón","Teclado","Red","Dirección IP","Tableta","Pantalla táctil","Batería","Programación","Bluetooth","WiFi","Pantalla","Servidor","Electrónica","Sistema de operación","Software","Drone","Audífonos","Reloj conectado","Futuro","Realidad virtual","Digital","Automatización","Domótica","ciberseguridad"	,"Comer","Frito","Pasta","Soda","Pizza","Bistec","Agua","Bebida","Fruta","Manzana","Pera","Banana","Arjeva","Patata","Tomate","Hamburguesa","Pescado","Salmón","Chocolate","Abogado","Vegetal","Crepe","Queso","Vino","Sushi","Hielo","Pastel","Piña","Cerveza","Chucrut"		,"Lanzamiento de jabalina","Lanzamiento de disco","Salto de poste","Salto de altura", "Carrera","Decatlón","Heptatlón","Maratón","Triatlón","Ciclismo","Voleibol","Balonmano","Baloncesto","Fútbol","Curling","Danza","Gimnasia","Esquí de fondo","Biatlón","Juegos olímpicos","Natación","Tiro Arco","Canoa","Judo","Relevo","Campeonato Mundial","Juego limpio","Boxeo","Esgrima","Rugby"      ,"Tejado","Jardín","Puerta","Ratón","Tabla","Silla","Sofá","Sillón","Televisión","Stand","Salón","Sala","Cuarto de baño","Cocina","Garaje","Cama","Cajonera","Escritorio","Cajón","Gabinete","Refrigerador","Cocina de gas","Microondas","Horno","Fregadero","La ducha","Baño","Cuchillo","Gama","Cuchara"	   ,}};


		//Mot aléatoire à traduire et vérification qu'il n'a pas déjà été choisi précédemment
		String mot1;
		int NbR;

		do {
			NbR = (int) (Math.round(Math.random()*Y));
			NbR = NbR + Theme;
			mot1 = tab[langue1][NbR];
		} while (mem.contains(mot1.toUpperCase()));

		//Mot traduis à retrouver
		String mot2 = tab[langue2][NbR];

		//Renvoie des mots dans le programme principal
		String[]result = new String[2];
		result[0] = mot1;
		result[1] = mot2;
		return result;
	}
}

