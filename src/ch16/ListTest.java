package ch16;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
	public static void main(String[] args){
		String[] colors1 = {"black", "yellow", "green", "blue", "violet", "sivler"};
		String[] colors2 = {"gold", "white", "brown", "blue", "gray", "silver"};

		List<String> list1 = new LinkedList<>();
		List<String> list2 = new LinkedList<>();

		for (String s: colors1)
			list1.add(s);

		for (String s: colors2)
			list2.add(s);

		System.out.println("Colors in list 1:");
		printList(list1);

		System.out.println("Colors in list 2:");
		printList(list2);

		list1.addAll(list2);
		list2 = null;

		System.out.println("Combinded colors in list 1 & 2:");
		printList(list1); 

		listToUppercase(list1);

		System.out.println("list1 to uppercase:");
		printList(list1); 

		listRemoveItems(list1, 4,7);

		System.out.println("Delete list1 from index 4 to 7");
		printList(list1); 

		System.out.println("Reversed list1:");
		printListReversed(list1);

	}

	private static void printList(List<String> list){
		for (String s: list)
			System.out.printf("%s ", s);
		System.out.println();
	}

	private static void listToUppercase(List<String> list){
		ListIterator<String> iterator = list.listIterator();
		while (iterator.hasNext()){
			String s = iterator.next().toUpperCase();
			iterator.set(s);
		}
	}

	private static void listRemoveItems(List<String> list, int start, int end){
		list.subList(start, end).clear();
	}

	private static void printListReversed(List<String> list){
		ListIterator<String> iterator = list.listIterator(list.size());
		while(iterator.hasPrevious())
			System.out.printf("%s ", iterator.previous());
	}
}
