package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * demo Class of a read of xml file with DOM
 * 
 * @author Malick
 * @see https://openclassrooms.com/courses/structurez-vos-donnees-avec-xml
 *
 *      TODO : update code in java 8
 */
public class ReadXMLFile {

	/**
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {

		ReadWithDOM();

	}

	/**
	 * Read xml file with dom
	 * 
	 */
	private static void ReadWithDOM() {
		/*
		 * Etape 1 : récupération d'une instance de la classe
		 * "DocumentBuilderFactory"
		 */
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			/*
			 * Etape 2 : création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Etape 3 : création d'un Document DOM
			 */

			// Get file from resources folder
			String fileName = "xml/Repertoire.xml";
			File file = new File(ReadXMLFile.class.getResource('/' + fileName).getFile());
			if (!file.exists()) {
				System.out.println("le fichier " + fileName + " n'existe pas");
				System.exit(1);
			}

			final Document document = builder.parse(file);

			// Affiche du prologue
			System.out.println("*************PROLOGUE************");
			System.out.println("version : " + document.getXmlVersion());
			System.out.println("encodage : " + document.getXmlEncoding());
			System.out.println("standalone : " + document.getXmlStandalone());

			/*
			 * Etape 4 : récupération de l'Element racine, the root node
			 */
			final Element root = document.getDocumentElement();

			System.out.println("\n*************RACINE************");
			System.out.println(root.getNodeName());

			/*
			 * Recupère l'ojet Xpath
			 */
			XPathFactory xpf = XPathFactory.newInstance();
			XPath path = xpf.newXPath();

			
			
			/*
			 * XPATH Expression 0 : sélectionner tous les nœuds "personne" 
			 */
			String expression0 = "/repertoire/personne"; // ou "//personne"
			
			
			/*
			 * XPATH Expression 1 : Recupère tous les nœuds <nom> du fichier
			 */
			String expression1 = "//nom";
			// On cast le résultat en Nodelist
			NodeList list = (NodeList) path.evaluate(expression1, root, XPathConstants.NODESET);
			int nodesLength = list.getLength();
			// Parcours de la boucle
			System.out.println("\n*************NOEUD NOM************");
			for (int i = 0; i < nodesLength; i++) {
				Node node = list.item(i);
				System.out.println(node.getNodeName() + " : " + node.getTextContent());
			}
			
			/*
			 * XPATH Expression 2 : sélectionner tous les nœuds descendants du deuxième nœud 
			 */
			String expression2 = "/repertoire/personne[position()=2]/descendant::*";
			
			
			/*
			 * XPATH Expression 3 : sélectionner le nœud "personne" correspondant à un individu ayant au moins 2 numéros de téléphone :
			 */
			String expression3 = "/repertoire/personne[count(telephones/telephone) > 1]";
			
			/*
			 * XPATH Expression 4 : sélectionner tous les nœuds descendants du deuxième nœud 
			 */
			String expression4 = "//nom";
			
			/*
			 * XPATH Expression 5 : sélectionner le deuxième nœud "personne" dont le pays de domiciliation est la France :
			 */
			String expression5 = "/repertoire/personne[adresse/pays=\"FRANCE\"][position()=2]";

			/*
			 * XPATH Expression 6 : sélectionner le deuxième nœud "personne" dont le pays de domiciliation est la France :
			 */
			String expressio6 = "/repertoire/personne[@sexe=\"masculin\"][adresse/pays=\"USA\"]";

			
			
			/*
			 * Etape 5 : récupération des personnes
			 */
			final NodeList racineNoeuds = root.getChildNodes();
			final int nbRacineNoeuds = racineNoeuds.getLength();

			for (int i = 0; i < nbRacineNoeuds; i++) {
				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element personne = (Element) racineNoeuds.item(i);

					System.out.println("\n*************PERSONNE************");
					System.out.println("sexe : " + personne.getAttribute("sexe"));

					/*
					 * Etape 6 : récupération du nom et du prénom
					 */
					final Element nom = (Element) personne.getElementsByTagName("nom").item(0);
					final Element prenom = (Element) personne.getElementsByTagName("prenom").item(0);

					System.out.println("nom : " + nom.getTextContent());
					System.out.println("prénom : " + prenom.getTextContent());

					/*
					 * Etape 7 : récupération des numéros de téléphone
					 */
					final NodeList telephones = personne.getElementsByTagName("telephone");
					final int nbTelephonesElements = telephones.getLength();

					for (int j = 0; j < nbTelephonesElements; j++) {
						final Element telephone = (Element) telephones.item(j);

						System.out.println(telephone.getAttribute("type") + " : " + telephone.getTextContent());
					}
				}
			}
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

	}



}
