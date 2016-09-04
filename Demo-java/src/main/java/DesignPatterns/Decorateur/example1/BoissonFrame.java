package DesignPatterns.Decorateur.example1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DesignPatterns.Decorateur.example1.dec.Chocolat;
import DesignPatterns.Decorateur.example1.dec.Lait;
import DesignPatterns.Decorateur.example1.dec.Sucre;

public class BoissonFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton jButtonEspresso = new JButton("Espresso");
	private JButton jButtonDeca = new JButton("Deca");
	private JButton jButtonSumatra = new JButton("Sumatra");
	private JButton jButtonColombia = new JButton("Colombia");
	
	private JButton jButtonIngredientLait = new JButton("Lait");
	private JButton jButtonIngredientChocolat = new JButton("Chocolat");
	private JButton jButtonIngredientSucre = new JButton("Sucre");
	
	JLabel jLabelDescription = new JLabel("Description : ");
	JLabel jLabelPrix = new JLabel("Prix : ");
	
	private Boisson boisson;

	// TODO : use un tableau d'objet avec la liste des listener et des bouton // FACTORISER
	// TODO : use pattern observer pour �couter les exo
	// TODO : factoriser
	// TODO plusieur boisson , use list
	
	public BoissonFrame() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel jpc = new JPanel();
		jpc.setLayout(new GridLayout(2, 1)); // 1 ligne une colonne
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new FlowLayout()); // centrer
		jPanel1.add(jButtonEspresso);
		jPanel1.add(jButtonColombia);
		jPanel1.add(jButtonDeca);
		jPanel1.add(jButtonSumatra);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new FlowLayout());
		jPanel2.add(jButtonIngredientLait);
		jPanel2.add(jButtonIngredientChocolat);
		jPanel2.add(jButtonIngredientSucre);
		
		jpc.add(jPanel1);
		jpc.add(jPanel2);
		
		this.add(jpc, BorderLayout.NORTH);
		
		JPanel jPanelC = new JPanel();
		jPanelC.setLayout(new FlowLayout()); // centre
		jPanelC.add(jLabelDescription);
		jPanelC.add(jLabelPrix);
		this.add(jPanelC, BorderLayout.CENTER);
		
		this.setSize(400, 500);
		this.setVisible(true);
		
		jButtonEspresso.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				boisson = new Espresso();
				jLabelDescription.setText(boisson.getDescription());
				jLabelPrix.setText(""+boisson.cout());
				
			}
		});
		jButtonSumatra.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				boisson = new Sumatra();
				jLabelDescription.setText(boisson.getDescription());
				jLabelPrix.setText(""+boisson.cout());
				
			}
		});
		jButtonDeca.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				boisson = new Deca();
				jLabelDescription.setText(boisson.getDescription());
				jLabelPrix.setText(""+boisson.cout());
				
			}
		});
		jButtonColombia.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				boisson = new Colombia();
				jLabelDescription.setText(boisson.getDescription());
				jLabelPrix.setText(""+boisson.cout());
				
			}
		});
		jButtonIngredientChocolat.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				boisson = new Chocolat(boisson);
				jLabelDescription.setText(boisson.getDescription());
				jLabelPrix.setText(""+boisson.cout());
				
			}
		});
		jButtonIngredientLait.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				boisson = new Lait(boisson);
				jLabelDescription.setText(boisson.getDescription());
				jLabelPrix.setText(""+boisson.cout());
				
			}
		});
		jButtonIngredientSucre.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				boisson = new Sucre(boisson);
				jLabelDescription.setText(boisson.getDescription());
				jLabelPrix.setText(""+boisson.cout());
				
			}
		});
	}
	
	public static void main(String[] args) {
		new BoissonFrame();

	}
	
	
}
