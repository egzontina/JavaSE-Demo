package ITwTest.ds2.part1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SaloonGUI extends JFrame {

	Map<String, String> mapPerso_Image;
	List<JButton> boutons;
	List<Personnages> personnages;

	private JPanel pan;
	private JLabel label;
	JOptionPane jop;

	public SaloonGUI(String string, Map<String, String> mapPerso_Image) {
		super(string);

		pan = new JPanel();
		label = new JLabel("Le JLabel");
		jop = new JOptionPane();

		this.setTitle("Animation");
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.mapPerso_Image = mapPerso_Image;
		personnages = new LinkedList<Personnages>();
		boutons = this.createListBoutons();
		this.addBoutonsToFrame();
		this.listenBoutons();

		pan.add(label);

		this.setContentPane(pan);
	}

	/**
	 * Ecoute des buttons
	 */
	private void listenBoutons() {
		for (JButton bouton : boutons) {
			// action au clic sur le button
			bouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					String nomPersonnage = boiteSaisie();
					Personnages p = newInstance(bouton, nomPersonnage);
				}
			});
		}

	}

	/**
	 * ajoute chaque bouton � la fen�tre
	 */
	private void addBoutonsToFrame() {
		for (JButton b : boutons) {
			pan.add(b);
		}
	}

	/**
	 * fabrique une liste de JButton. � partir de la map
	 */
	private List<JButton> createListBoutons() {
		List<JButton> listButtonPersonnage = new ArrayList<>();
		// � Actions sur la Map �
		Set<Map.Entry<String, String>> set = this.mapPerso_Image.entrySet();
		for (Entry<String, String> e : set) {
			// JButton bouton = new JButton(new ImageIcon(e.getValue()));
			// bouton.setName(e.getKey());
			JButton bouton = new JButton(e.getKey());

			listButtonPersonnage.add(bouton);
		}
		return listButtonPersonnage;
	}

	/**
	 * Boite de saisie
	 */
	protected String boiteSaisie() {
		String nomPersonnage = JOptionPane.showInputDialog(null, "Saisir le nom du personnage ",
				"Cr�ation d'un personnage!", JOptionPane.QUESTION_MESSAGE);
		return nomPersonnage;
	}

	/**
	 * New Instance
	 */
	protected Personnage newInstance(JButton bouton, String nomPersonnage) {
		String name = bouton.getName();
		Personnage p = new Cowboy(nomPersonnage);
		personnages.add(p);
		return p;
	}

}
