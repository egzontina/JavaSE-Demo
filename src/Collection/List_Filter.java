package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class List_Filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void filterpwithStream() {
		List<String> items = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));

		// recup�re 1 elment de la liste
		Optional<String> s0 = items.stream().findFirst(); // > A
		Optional<String> s1 = items.stream().filter(s -> s.contains("E")).findFirst();
		System.out.println("s1 get 1 element : " + s1.get()); // > E

		List<String> strings = Arrays.asList("girafe", "chameau", "chat", "poisson", "cachalot");
		strings.stream()
				// filtrage
				.filter(x -> x.contains("cha"))
				// mapping : reformatage des cha�nes de caract�res
				.map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
				// tri par ordre alphab�tique
				.sorted()
				// Outputs:
				// Cachalot
				// Chameau
				// Chat
				.forEach(System.out::println);
	}

}
