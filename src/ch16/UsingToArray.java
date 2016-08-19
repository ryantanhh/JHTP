package ch16;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class UsingToArray {
	public static void main(String[] args){
		String[] colors = {"black", "blue", "yellow"};
		LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(colors));
		
		System.out.println("Original list:");
		printList(linkedList);
		
		linkedList.addLast("red");
		linkedList.add("pink");
		linkedList.add(3, "green");
		linkedList.addFirst("cyan");

		System.out.println("The list after adding items:");
		printList(linkedList);
	}

	private static void printList(List<String> list){
		ListIterator<String> iterator = list.listIterator();
		while(iterator.hasNext())
			System.out.printf("%s ", iterator.next());
		System.out.println();
	}
}
