package ch16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithms2 {

	public static void main(String[] args){
		String[] colors = {"red", "white", "yellow", "blue"};
		List<String> list1 = Arrays.asList(colors);
		ArrayList <String> list2 = new ArrayList<>();

		list2.add("black");
		list2.add("red");
		list2.add("green");

		System.out.print("Before addAll, list2 contains: ");
		showList(list2);

		System.out.print("After addAll, list2 contains: ");
		list2.addAll(list1);
		showList(list2);

		int frequency = Collections.frequency(list2, "red");
		System.out.printf("Frequency of red in list2: %s\n", frequency);

		boolean disjoint = Collections.disjoint(list1, list2);

		System.out.printf("list1 and list2 %s elements in comment", 
				disjoint ? "do not have":"have");



	}

//	private static void showList(List<String> list) {
//		for (String s : list)
//			System.out.printf("%s ", s);
//		System.out.println();
//	}

	private static <T> void showList(List<T> list){
		for (T e : list)
			System.out.printf("%s ", e);
		System.out.println();
	}
}
