package ParallelArrays;

import java.util.Arrays;

public class ParallelArraysDemo {

public static void main(String[] args) {
		
		// Parallélisation : gagner en performance en parallélisant n’importe quel traitement
		//		Parallel Arrays Arrays.parallelPrefix : fold right 
		long [] array0 = {1, 2, 3, 4}; // > [1, 3, 6, 10]
		long [] array1 = {1L, 1L, 1L, 1L} ; // > [1, 2, 3, 4]
		Arrays.parallelPrefix(array0, (l1, l2) -> l1 + l2) ; 
//		System.out.println(Arrays.toString(array0)) ; 
				
				 // Parallel Arrays Arrays.sort : tri en place 
			long [] array2 = {1, 6, 3, 9};
			Arrays.parallelSort(array2) ; 
//			System.out.println(Arrays.toString(array2)) ;
				 
			 
//			http://fr.slideshare.net/jpaumard/50-nouvelles-choses-que-lon-peut-faire-avec-java-8
//			75
//				 
//				 CompletableFuture Extension de Future CompletableFuture<String> page = CompletableFuture.supplyAsync( () -> readWebPage(url) ) ;
//				 CompletableFuture Permet de créer des pipelines CompletableFuture.supplyAsync( () -> readWebPage(url) ) .thenApply(content -> getImages(content)) ;
//				 
//				 CompletableFuture Permet de créer des pipelines CompletableFuture<List<Image>> images = CompletableFuture.supplyAsync( () -> readWebPage(url) ) .thenApply(content -> getImages(content)) ; // function
//				 CompletableFuture thenCompose : composition de tâches dans le futur CompletableFuture<List<Image>> cf = CompletableFuture.supplyAsync( () -> readWebPage(url) ) .thenCompose(content -> getImages(content))
//						 CompletableFuture thenCompose : composition de tâches dans le futur CompletableFuture.supplyAsync( () -> readWebPage(url) ) .thenCompose(content -> getImages(content)) .thenApply(image -> writeToDisk(image)) ; // retourne CF<Boolean>
//				 CompletableFuture thenCompose : composition de tâches dans le futur List<CompletableFuture<Boolean>> result = CompletableFuture.supplyAsync( () -> readWebPage(url) ) .thenCompose(content -> getImages(content)) .thenApply(image -> writeToDisk(image)) ; // retourne CF<Boolean>
//				 CompletableFuture allOf : composition de tâches dans le futur (anyOf existe) CompletableFuture.allOf( CompletableFuture.supplyAsync( () -> readWebPage(url) ) .thenCompose(content -> getImages(content)) .thenApply(image -> writeToDisk(image)) ) .join() ;
//				 CompletableFuture thenCombine : combine plusieurs CF Applique la fonction une fois les deux CF exécutés CompletableFuture cf1 = ... ; CompletableFuture cf2 = ... ; cf1.thenCombine(cf2, (b1, b2) -> b1 & b2) ; // retourne la combinaison // des résultats des CF
//				 CompletableFuture thenCombine : combine plusieurs CF Applique la fonction une fois les deux CF exécutés thenAcceptBoth, runAfterBoth CompletableFuture cf1 = ... ; CompletableFuture cf2 = ... ; cf1.thenCombine(cf2, (b1, b2) -> b1 & b2) ; // retourne la combinaison // des résultats des CF
//				 CompletableFuture applyToEither : utilise le premier résultat disponible CompletableFuture cf1 = ... ; CompletableFuture cf2 = ... ; cf1.applyToEither(cf2, (b) -> ...) ; // s’applique au résultat // du premier CF dispo
//				 CompletableFuture applyToEither : utilise le premier résultat disponible acceptEither, runAfterEither CompletableFuture cf1 = ... ; CompletableFuture cf2 = ... ; cf1.applyToEither(cf2, (b) -> ...) ; // s’applique au résultat // du premier CF dispo
//				 
//				 Concurrence
//				 Variables atomiques On avait : AtomicLong atomic = new AtomicLong() ; long l1 = atomic.incrementAndGet() ;
//				 AtomicLong atomic = new AtomicLong() ; long l1 = atomic.incrementAndGet() ; long l2 = atomic.updateAndGet(l -> l*2 + 1) ; long l3 = atomic.accumulateAndGet(12L, (l1, l2) -> l1 % l2) ;
//				 LongAdder On a : LongAdded adder = new LongAdder() ; adder.increment() ; // dans un thread adder.increment() ; // dans un autre thread adder.increment() ; // encore dans un autre thread long sum = adder.sum() ;
//				 LongAccumulator Même chose, mais on généralise : LongAccumulator accu = new LongAccumulator((l1, l2) -> Long.max(l1, l2), 0L) ; accu.accumulate(value1) ; // dans un thread accu.accumulate(value2) ; // dans un autre thread accu.accumulate(value2) ; // encore dans un autre thread long sum = accu.longValue() ;
//				 StampedLock Un lock avec lecture optimiste StampedLock sl= new StampedLock() ; long stamp = sl.writeLock() ; try { ... } finally { sl.unlockWrite(stamp) ; } long stamp = sl.readLock() ; try { ... } finally { sl.unlockRead(stamp) ; }
//				 StampedLock Un lock avec lecture optimiste Exclusivité entre read / write, mais… StampedLock sl= new StampedLock() ; long stamp = sl.writeLock() ; try { ... } finally { sl.unlockWrite(stamp) ; } long stamp = sl.readLock() ; try { ... } finally { sl.unlockRead(stamp) ; }
//				 StampedLock Un lock avec lecture optimiste StampedLock sl= new StampedLock() ; long stamp = sl.tryOptimisticRead() ; // ici on lit une variable qui peut être modifiée par un autre thread if (lock.validate(stamp)) { // la lecture est validée } else { // un autre thread a acquis un write lock }
//				 
//				 ConcurrentConcurrent HashMap
//				 ConcurrentHashMap Réécriture complète de ConcurrentHashMap V7 Complètement thread-safe N’utilise de lock ≠ ConcurrentHashMap V7 Nouvelles méthodes
//				 
//				 Nouvelles méthodes
//				 
//				 ConcurrentHashMap 6000 lignes de code 54 classes membre Pour info : 58 classes dans java.util.concurrent Nouveaux patterns !
//				 96. @JosePaumard#50new8 ConcurrentHashMap Ne plus utiliser size() int count = map.size() ; // ne pas utiliser count = map.mappingCount() ; // nouvelle méthode
//				 
//				 97. @JosePaumard#50new8 ConcurrentHashMap Ne plus utiliser int count = map.size() ; // ne pas utiliser long count = map.mappingCount() ; // nouvelle méthode
//				 98. @JosePaumard#50new8 ConcurrentHashMap Recherche d’éléments search(), searchKey(), searchValue(), searchEntry() ConcurrentHashMap<Integer, String> map = ... ; map.search(10, (key, value) -> value.length() < key) ;
//				 99. @JosePaumard#50new8 ConcurrentHashMap Recherche d’éléments search(), searchKey(), searchValue(), searchEntry() ConcurrentHashMap<Integer, String> map = ... ; map.search(10, (key, value) -> value.length() < key) ;
//				 100. @JosePaumard#50new8 ConcurrentHashMap Recherche d’éléments 10 : taux de parallélisme Si la table compte plus de 10 éléments, alors la recherche se fait en parallèle ! ConcurrentHashMap<Integer, String> map = ... ; map.search(10, (key, value) -> value.length() < key) ;
//				 101. @JosePaumard#50new8 ConcurrentHashMap Recherche d’éléments 10 : taux de parallélisme Si la table compte plus de 10 éléments, alors la recherche se fait en parallèle ! On peut passer 0, ou Integer.MAX_VALUE ConcurrentHashMap<Integer, String> map = ... ; map.search(10, (key, value) -> value.length() < key) ;
//				 102. @JosePaumard#50new8 ConcurrentHashMap ForEach forEach(), forEachKey(), forEachEntries() ConcurrentHashMap<Integer, String> map = ... ; map.forEach(10, (key, value) -> System.out.println(String.join(key, "->", value) ) ;
//				 103. @JosePaumard#50new8 ConcurrentHashMap Réduction reduce(), reduceKey(), reduceEntries() ConcurrentHashMap<Integer, String> map = ... ; map.reduce(10, (key, value) -> value.getName(), // transformation (name1, name2) -> name1.length() > name2.length() ? name1 : name2) // reduction ) ;
//				 104. @JosePaumard#50new8 Pas de ConcurrentHashSet Mais… Set<String> set = ConcurrentHashMap.<String>.newKeySet() ;
//				 105. @JosePaumard#50new8 Pas de ConcurrentHashSet Mais… Crée une concurrent hashmap dont les valeurs sont Boolean.TRUE Sert de set concurrent Set<String> set = ConcurrentHashMap.<String>.newKeySet() ;
//				 
//		
	}

}

