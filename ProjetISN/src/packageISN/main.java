package packageISN;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {

		int Rejouer = 10; //Pour recommencer une session � la fin
		ImageIcon img = new ImageIcon(Object.class.getResource("/Image/logo.png"));

		//CODE PRINCIPAL
		do {
			//Compteur de bonne r�ponse
			int P = 0;

			//V�rificateur de boucle do
			int V�rification = 0;

			//Choix de la langue de d�part
			String[] langue = {"Choisir une langue","Fran�ais","Anglais","Espagnol"}; //Langue possible
			int langue1 = -1;
			String langueD;
			do {
					langueD = (String)JOptionPane.showInputDialog(null, "Langue de d�part ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE, img, langue, langue[0]); //Question
					if (langueD.equals("Fran�ais")){
						langue1 = 0;
						V�rification = 1;
					}
					else if (langueD.equals("Anglais")){
						langue1 = 1;
						V�rification = 1;
					}
					else if (langueD.equals("Espagnol")){
						langue1 = 2;
						V�rification = 1;
					}
					else {
						JOptionPane.showMessageDialog(null, "Vous devez s�lectionner une langue.", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE); //Message d'erreur
						V�rification = 0;
					}
				} while(V�rification == 0);

			//Choix de la langue final
			int langue2 = -1;
			String langueF = "";

			if (langue1 == 0){ //Si la premi�re langue est le fran�ais
				String[]langueA = {"Choisir une langue","Anglais","Espagnol"}; //Langues possible
				do {
					langueF = (String)JOptionPane.showInputDialog(null, "Langue de traduction ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE, img, langueA, langueA[0]); //Question

						if (langueF.equals("Anglais")){
							langue2 = 1;
							V�rification = 1;
						}
						else if (langueF.equals("Espagnol")){
							langue2 = 2;
							V�rification = 1;
						}
						else {
							JOptionPane.showMessageDialog(null, "Vous devez s�lectionner une langue.", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE); //Message d'erreur
							V�rification = 0;
						}

					} while (V�rification == 0);
			}

			if (langue1 == 1){ //Si la premi�re langue est l'anglais
				String[]langueB = {"Choisir une langue","Fran�ais","Espagnol"}; //Langues possible
				do {
					langueF = (String)JOptionPane.showInputDialog(null, "Langue de traduction ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE, img, langueB, langueB[0]); //Question

						if (langueF.equals("Fran�ais")){
							langue2 = 0;
							V�rification = 1;
						}
						else if (langueF.equals("Espagnol")){
							langue2 = 2;
							V�rification = 1;
						}
						else {
							JOptionPane.showMessageDialog(null, "Vous devez s�lectionner une langue.", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE); //Message d'erreur
							V�rification = 0;
						}

					} while (V�rification == 0);
			}

			if (langue1 == 2){ //Si la premi�re langue est l'espagnol
				String[]langueC = {"Choisir une langue","Fran�ais","Anglais"}; //Langues possible
				do {
					langueF = (String)JOptionPane.showInputDialog(null, "Langue de traduction ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE, img, langueC, langueC[0]); //Question

						if (langueF.equals("Fran�ais")){
							langue2 = 0;
							V�rification = 1;
						}
						else if (langueF.equals("Anglais")){
							langue2 = 1;
							V�rification = 1;
						}
						else {
							JOptionPane.showMessageDialog(null, "Vous devez s�lectionner une langue.", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE); //Message d'erreur
							V�rification = 0;
						}

					} while (V�rification == 0);
			}

			//Choix du th�me
			String[] ListeThemes = {"Choisir un th�me","HighTech","Sport","Nourriture","Maison","Aucun"}; //Th�me possible
			int Theme = 0; //D�calage dans la base de donn�es
			int Y = 1; //Nombre de mots dans le th�me
			do {
				String choixTheme = (String)JOptionPane.showInputDialog(null, "Voulez vous choisir un th�me ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE, img, ListeThemes, ListeThemes[0]); //Question
				if (choixTheme.equals("HighTech")){
					Theme = 0;
					Y = 29;
					V�rification = 1;
				}
				else if (choixTheme.equals("Nourriture")){
					Theme = 30;
					Y = 29;
					V�rification = 1;
				}
				else if (choixTheme.equals("Sport")){
					Theme = 60;
					Y = 29;
					V�rification = 1;
				}
				else if (choixTheme.equals("Maison")){
					Theme = 90;
					Y = 29;
					V�rification = 1;
				}
				else if (choixTheme.equals("Aucun")){
					Y = 119;
					V�rification = 1;
				}
				else {
					JOptionPane.showMessageDialog(null, "Le th�me s�lectionn� est invalide, veuillez recommencer.", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE); //Si l'utilisateur ne choisit pas de th�me
					   V�rification = 0;
				}
			} while (V�rification == 0);

			//Choix du nombre de tour
			String N;
			int X = 0;
			do {
				do {
					V�rification = 1;
					N = JOptionPane.showInputDialog(null, "Combien de mots voulez traduire ?", "Easy Lengua", JOptionPane.QUESTION_MESSAGE);

					//V�rification qu'il s'agit bien d'un entier
					try {
						Integer.parseInt(N);
						} catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Vous devez entrez un nombre entier.", "Easy Lengua - Erreur", JOptionPane.ERROR_MESSAGE);
							V�rification = 0;
							}
				} while(V�rification == 0);

				X = Integer.valueOf(N); //X prend la valeur de N si c'est bien un entier

				if (X > Y+1){ //Si le nombre rentr� est sup�rieur au nombre de mot dans le th�me choisi
					JOptionPane.showMessageDialog(null, "Vous ne pouvez pas traduire plus de " + (Y+1) + " mots pour ce th�me. Veuillez recommencer.", "Easy Lengua - Erreur", JOptionPane.WARNING_MESSAGE);
					V�rification = 0;
				}
			} while(V�rification ==0);

			//Application
			String mem = ""; //Initialisation m�moire vide
			String mot1; //Mot � traduire
			String mot2; //Mot � retrouver

			for (int i = 0; i != X; i++){

				String[] TabResult = Mots(langue1, langue2, mem, Theme, Y); //Retour des mots � partir de la fonction Mots
				mot1 = TabResult[0].toUpperCase();
				mot2 = TabResult[1].toUpperCase();
				mem = mem.concat(mot1); //Ajout du mot dans la m�moire

				//R�ponse
				String Proposition;
				String mot2SA = sansAccents(mot2).toUpperCase(); //Mot � retrouver sans accents s'il y en a

				Proposition = JOptionPane.showInputDialog(null , "Le mot � traduire en " + langueF.toLowerCase() + " : " + mot1, "Easy Lengua", JOptionPane.QUESTION_MESSAGE);
				if (Proposition.toUpperCase().equals(mot2) || Proposition.toUpperCase().equals(mot2SA)){ //Tol�rance de bonne r�ponse
					JOptionPane.showMessageDialog(null, "Bravo, vous gagnez un point !", "Easy Lengua", JOptionPane.INFORMATION_MESSAGE, img); //Message en cas de bonne r�ponse
					P++; // Ajout d'un point
				}
				else {
					JOptionPane.showMessageDialog(null, "Dommage ! La bonne r�ponse �tait : " + mot2, "Easy Lengua", JOptionPane.INFORMATION_MESSAGE, img); //Message en cas de mauvaise r�ponse
				}
			}

			//Affichage du r�sultat final et de la moyenne de bonne r�ponse
			int H = (P*100/X);
			JOptionPane.showMessageDialog(null, "C'est fini ! Votre r�sultat final : " + P + "/" + X + " soit " + H + "% de bonnes r�ponses !", "Easy Lengua", JOptionPane.INFORMATION_MESSAGE, img);

			Rejouer = JOptionPane.showConfirmDialog(null, "Voulez-vous recommencer ?", "Easy Lengua", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, img); //Message demandant si l'utilisateur veut recommencer

			if (Rejouer == 0){JOptionPane.showMessageDialog(null, "Tr�s bien continuons.", "Easy Lengua", JOptionPane.INFORMATION_MESSAGE, img);} //Si sa r�ponse est oui
			if (Rejouer == 1){JOptionPane.showMessageDialog(null, "Tr�s bien � bient�t !", "Easy Lengua", JOptionPane.INFORMATION_MESSAGE, img);} //Si sa r�ponse est non

		}while (Rejouer == 0);
	}

	//Cr�ation du mot � traduire sans �ventuel(s) accent(s)
	static public String sansAccents(String mot2) {

		//Liste des accents possible
		String Tab[][] = {{"�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","'","-"},
		          		  {"A","A","A","A","E","E","E","E","I","I","I","O","O","U","U","U","U","Y","N","C"," "," "}};

		String x = "";
		String w = "";

		for(int n = 0 ;n !=22; n++){
			x = Tab[0][n];
			w = Tab[1][n];

			if (mot2.contains(x)){ //V�rification pour chaque accent si il est contenu dans le mot
				mot2 = mot2.replace(x,w); //Remplacement de la lettre avec accent par sa lettre sans accent
			}
		}
		return mot2;
	}

	//Cr�ation des mots
	static public String[] Mots(int langue1, int langue2, String mem, int Theme, int Y){

		//Liste de mots
		String tab[][] = {{"Technologie","Smartphone","Ordinateur","C�ble","Carte graphique","Processeur","Souris","Clavier","R�seau","Adresse IP","Tablette","�cran tactile","Batterie", "Programmation","Bluetooth", "WiFi", "�cran","Serveur","�lectronique","Syst�me d�exploitation","Logiciel","Drone","Ecouteurs","Montre connect�e","Futur","R�alit� virtuelle","Num�rique","Automatisation","Domotique","Cybers�curit�" 	,"Manger","Frite","P�te","Soda","Pizza","Steak","Eau","Boire","Fruit","Pomme","Poire","Banane","Petit pois","Pomme de terre","Tomate","Burger" ,"Poisson","Saumon","Chocolat","Avocat","L�gume","Cr�pe","Fromage","Vin","Sushi","Glace","Tarte","Ananas","Bi�re","Choucroute"	,"Lancer de javelot","Lancer de disque","Saut � la perche","Saut en hauteur","Course","D�cathlon","Heptathlon","Marathon","Triathlon","Cyclisme","Volleyball","Handball","Basketball","Football","Curling","Danse","Gymnastique","Ski de fond","Biathlon","Jeux Olympiques","Natation","Tir � l'arc","Cano�","Judo","Relais","Championnat du monde","Fair play","Boxe","Escrime","Rugby"  	 	 ,"Toit","Jardin","Porte","Paillasson","Table","Chaise","Canap�","Fauteuil","T�l�vision","Meuble","Salon","Chambre","Salle de bain","Cuisine","Garage","Lit","Commode","Bureau","Tiroir","Armoire","R�frig�rateur","Gazini�re","Micro Onde","Four","Lavabo","Douche","Bain","Couteau","Fourchette","Cuill�re"   ,},
				          {"Technology", "Smartphone","Computer","Cable","Graphics Card","Processor","Mouse","Keyboard","Network","IP Address","Tablet","Touch Screen","Battery","Programming","Bluetooth","WiFi","Screen","Server","Electronics","Operating System","Software","Drone","Headphones","Connected Watch","Future","Virtual Reality","Digital","Automating","Automation","cybersecurity"   							,"Eat","Chip","Paste","Soda","Pizza","Steak","Water","Drink","Fruit","Apple","Pear","Banana","Peas","Potato","Tomato","Burger","Fish","Salmon","Chocolate","Avocado","Vegetable","Crepe","Cheese","Wine","Sushi","Ice","Pie","Pineapple","Beer","Sauerkraut" 					,"Javelin Throw", "Discus Throw", "Pole vault", "High Jump", "Race", "Decathlon", "Heptathlon", "Marathon", "Triathlon","Cycling","Volleyball","Handball","Basketball","Football","Curling","Dance","Gymnastics ","Cross Country Skiing","Biathlon","Olympic Games","Swimming","Shooting bow","Canoe","Judo","Relay","World Championship","Fair play","Boxing","Fencing","Rugby"        		 ,"Roof", "Garden", "Door", "Mat", "Table", "Chair", "Sofa", "Armchair", "Television", "Stand", "Lounge", "Room", "Bathroom Bath","Kitchen","Garage","Bed","Chest of drawers","Desk","Drawer","Cabinet","Refrigerator","Gas stove","Microwave","Oven","Sink","Shower","Bath","Knife","Range","Spoon"            ,},
				          {"Tecnolog�a","Tel�fono inteligente","Computadora","Cable","Tarjeta gr�fica","Procesador","Rat�n","Teclado","Red","Direcci�n IP","Tableta","Pantalla t�ctil","Bater�a","Programaci�n","Bluetooth","WiFi","Pantalla","Servidor","Electr�nica","Sistema de operaci�n","Software","Drone","Aud�fonos","Reloj conectado","Futuro","Realidad virtual","Digital","Automatizaci�n","Dom�tica","ciberseguridad"	,"Comer","Frito","Pasta","Soda","Pizza","Bistec","Agua","Bebida","Fruta","Manzana","Pera","Banana","Arjeva","Patata","Tomate","Hamburguesa","Pescado","Salm�n","Chocolate","Abogado","Vegetal","Crepe","Queso","Vino","Sushi","Hielo","Pastel","Pi�a","Cerveza","Chucrut"		,"Lanzamiento de jabalina","Lanzamiento de disco","Salto de poste","Salto de altura", "Carrera","Decatl�n","Heptatl�n","Marat�n","Triatl�n","Ciclismo","Voleibol","Balonmano","Baloncesto","F�tbol","Curling","Danza","Gimnasia","Esqu� de fondo","Biatl�n","Juegos ol�mpicos","Nataci�n","Tiro Arco","Canoa","Judo","Relevo","Campeonato Mundial","Juego limpio","Boxeo","Esgrima","Rugby"      ,"Tejado","Jard�n","Puerta","Rat�n","Tabla","Silla","Sof�","Sill�n","Televisi�n","Stand","Sal�n","Sala","Cuarto de ba�o","Cocina","Garaje","Cama","Cajonera","Escritorio","Caj�n","Gabinete","Refrigerador","Cocina de gas","Microondas","Horno","Fregadero","La ducha","Ba�o","Cuchillo","Gama","Cuchara"	   ,}};


		//Mot al�atoire � traduire et v�rification qu'il n'a pas d�j� �t� choisi pr�c�demment
		String mot1;
		int NbR;

		do {
			NbR = (int) (Math.round(Math.random()*Y));
			NbR = NbR + Theme;
			mot1 = tab[langue1][NbR];
		} while (mem.contains(mot1.toUpperCase()));

		//Mot traduis � retrouver
		String mot2 = tab[langue2][NbR];

		//Renvoie des mots dans le programme principal
		String[]result = new String[2];
		result[0] = mot1;
		result[1] = mot2;
		return result;
	}
}

