package demo4;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * classe Instru qui contiendra toutes les fonctions sonores : jouer une note,
 * augmenter ou baisser le volume, changer l'instrument. Cette classe ne
 * correspondra à aucun élément graphique.
 * 
 * @author Malick
 *
 */
public class Instru {

	public IntegerProperty volume = new SimpleIntegerProperty(0);

	private Synthesizer synthetiseur;
	private MidiChannel canal;

	public Instru() {

		// this.volume.set(100);

		try {
			// On récupère le synthétiseur, on l'ouvre et on obtient un canal
			synthetiseur = MidiSystem.getSynthesizer();
			synthetiseur.open();
		} catch (MidiUnavailableException ex) {
			Logger.getLogger(Instru.class.getName()).log(Level.SEVERE, null, ex);
		}
		canal = synthetiseur.getChannels()[0];

		// On initialise l'instrument 0 (le piano) pour le canal
		canal.programChange(0);
	}

	public IntegerProperty getVolume() {
		return volume;
	}

	public IntegerProperty volumeProperty() {
		return volume;
	}

	public void setVolume(IntegerProperty volume) {
		this.volume = volume;
	}

	// Joue la note dont le numéro est en paramètre
	public void note_on(int note) {
		canal.noteOn(note, volume.get());
	}

	// Arrête de jouer la note dont le numéro est en paramètre
	public void note_off(int note) {
		canal.noteOff(note);
	}

	// Set le type d'instrument dont le numéro MIDI est précisé en paramètre
	public void set_instrument(int instru) {
		canal.programChange(instru);
	}
}
