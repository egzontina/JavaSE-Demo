package chap14_Swing_Boites_de_dialogues;
import javax.swing.*;

public class Confirm1 {
	public static void main(String args[]) {
		while (true) {
			int rep = JOptionPane.showConfirmDialog(null, "voulez-vous continuer");
			System.out.println("reponse : " + rep);
		}
	}
}
