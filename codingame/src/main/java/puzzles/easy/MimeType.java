package puzzles.facile;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * The aim of this puzzle is to match files with their MIME type by reading their extensions.
 * 
 * <pre>
 *  Objectif 
 *  Le type MIME est utilisé dans de nombreux protocoles internet pour associer un type de média (html, image, vidéo, ...) avec le contenu envoyé. Ce type MIME est généralement déduit de l'extension du fichier à transférer.
 *  Vous devez écrire un programme qui permet de détecter le type MIME d'un fichier à partir de son nom.
 *  
 *  Règles
 *  Une table qui associe un type MIME avec une extension de fichier vous est fournie. Une liste de noms de fichier à transférer vous sera aussi fournie et vous devrez déduire pour chacun d'eux, le type MIME à utiliser.
 *  L'extension d'un fichier se définit par la partie du nom qui se trouve après le dernier point qui le compose.
 *  Si l'extension du fichier est présente dans la table d'association (la casse ne compte pas. ex : TXT est équivalent à txt), alors affichez le type MIME correspondant . S'il n'est pas possible de trouver le type MIME associé à un fichier, ou si le fichier n'a pas d'extensions, affichez UNKNOWN.
 *  
 *  Entrées du jeu
 *  Ligne 1: Nombre N d’éléments composant la table d'association. 
 *  Ligne 2 : Nombre Q de noms de fichiers à analyser.
 *  N lignes suivantes : Une extension de fichier par ligne et son type MIME correspondant (séparé par un espace).
 *  Q lignes suivantes : Un nom de fichier par ligne.
 *  
 *  Sortie
 *  Pour chacun des Q noms de fichiers, afficher sur une ligne le type MIME associé. S'il n'y a pas de correspondance, afficher UNKNOWN.
 *  Contraintes
 *  0 < N < 10000
 *  0 < Q < 10000
 *  
 *  Les extensions de fichiers sont composées d'un maximum de 10 caractères ascii alphanumériques.
 *  Les type MIME sont composés d'un maximum de 50 caractères ascii alphanumérique et de ponctuations.
 *  Les noms de fichiers sont composés d'un maximum de 256 caractères ascii alphanumériques et points.
 *  Il n'y a pas d'espaces dans les noms de fichiers, les extensions et les types MIME.
 * </pre>
 * 
 * @author Malick
 */
class MimeType {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.

        // dictionnary associates to each file extension the corresponding MIME type
        HashMap<String, String> MimeTypeMap = new HashMap<String, String>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            MimeTypeMap.put(EXT.toLowerCase(), MT);
        }

        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            // isolates the extension, which is the part after the last '.' character
            int dotPos = FNAME.lastIndexOf('.');
            String ext = (dotPos == -1) ? "" : FNAME.substring(dotPos + 1);
            // For each of the Q filenames, prints the corresponding MIME type, or UNKNOWN
            System.out.println(MimeTypeMap.getOrDefault(ext.toLowerCase(), "UNKNOWN"));
        }

        // To debug
        // System.err.println("Extentions Map : " + MimeTypeMap);

        // close scanner
        in.close();

    }

    /**
     * Other Published Solution - Best Upvoted
     * 
     * @author Malick
     */
    public static void solution() {

        Scanner in = new Scanner(System.in);
        int types_n = in.nextInt();
        int files_n = in.nextInt();

        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < types_n; i++) {
            map.put(in.next().toLowerCase(), in.next());
            in.nextLine();
        }

        for (int i = 0; i < files_n; i++) {
            String FNAME = in.nextLine().toLowerCase(); // One file name per line.
            int dotI = FNAME.lastIndexOf(".");
            String ext = dotI == -1 ? "" : FNAME.substring(dotI + 1);
            System.out.println(map.containsKey(ext) ? map.get(ext) : "UNKNOWN");
        }

    }
}
