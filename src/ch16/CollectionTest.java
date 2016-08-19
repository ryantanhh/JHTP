package ch16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
	public static void main(String[] args){
		String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
		String[] colorsToRemove = {"RED", "WHITE", "BLUE"};

		List<String> colorsList= new ArrayList<>(); 
		List<String> colorsToRemoveList= new ArrayList<>(); 

		for (String s: colors)
			colorsList.add(s);

		System.out.println("Original colors:");
		printList(colorsList);
		
		for (String s: colorsToRemove)
			colorsToRemoveList.add(s);

		System.out.println("Colors to remove:");
		printList(colorsToRemoveList);

		removeList(colorsList, colorsToRemoveList);

		System.out.println("Colors left:");
		printList(colorsList);

	}

//	private static void printList(List<String> list){
//		for (String s: list)
//			System.out.printf("%s ", s);
//		System.out.println();
//
//	}
//
//	private static void removeList(Collection<String> items,
//			Collection<String> itemsToRemove){
//		Iterator<String> iterator = items.iterator();
//
//		while(iterator.hasNext()){
//			if (itemsToRemove.contains(iterator.next()))
//				iterator.remove();
//		}
//
//	}


	// Rewrite printList with generic method
	private static <T> void printList(List<T> list){
		for (T e : list) 
			System.out.printf("%s ", e);
		System.out.println();
	}

	// Rewrite removeList with generic method
	private static <T> void removeList(Collection<T> items,
			Collection<T> itemsToRemove){
		Iterator<T> iterator = items.iterator();

		while(iterator.hasNext()){
			if (itemsToRemove.contains(iterator.next()))
				iterator.remove();
		}
	}
}
