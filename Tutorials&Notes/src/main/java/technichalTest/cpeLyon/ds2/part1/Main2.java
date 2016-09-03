package technichalTest.cpeLyon.ds2.part1;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class Main2 {

	/**
	 * Main 
	 */
	public static void main(String args[]) {

		Map<String, String> mapPerso_Image;
		JFrame frame;

		mapPerso_Image = getMapPersonnage_Image();

		frame = new SaloonGUI("A L'ouest de Java Town", mapPerso_Image);
		frame.setVisible(true);

	}
	
	/**
	 * associer à chaque type de personnage, le nom de l’image correspondante
	 */
	public static Map<String, String> getMapPersonnage_Image(){
		
		Map<String, String> mapPersonnage = new HashMap<String, String>();
		mapPersonnage.put("Brigand","ImageBrigand.gif");
		mapPersonnage.put("Barman","ImageBarman.gif");
		mapPersonnage.put("Cowboy","ImageCowboy.gif");
		mapPersonnage.put("Dame","ImageDame.gif");
		mapPersonnage.put("Sherif","ImageSherif.gif");
		
		return mapPersonnage;
		
	}
}
