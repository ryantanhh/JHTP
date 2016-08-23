package ch16;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithms1 {
	public static void main(String[] args){
		Character[] letters = {'P', 'C', 'M'};
		Character[] lettersCopy = new Character[3];
		List<Character> list = Arrays.asList(letters);
		List<Character> listCopy = Arrays.asList(lettersCopy);

		System.out.println("list contains:");
		output(list);

		Collections.reverse(list);
		System.out.println("Reversed list:");
		output(list);

		Collections.sort(list);
		System.out.println("Sorted list:");
		output(list);


		System.out.println("Copied list:");
		Collections.copy(listCopy, list);
		output(listCopy);

		System.out.printf("Max value in the list: %s\n", Collections.max(list));
		System.out.printf("Min value in the list: %s\n", Collections.min(list));

		System.out.println("List filled with 'R':");

		Collections.fill(list, 'R');
		output(list);

		System.out.printf("Max value in the list: %s\n", Collections.max(list));
		System.out.printf("Min value in the list: %s\n", Collections.min(list));
	}

//	private static void output(List<Character> list) {
//		for (Character e : list)
//			System.out.printf("%s ", e);
//		System.out.println();
//	}

//	Rewrite the output method in a generic form
	private static <T> void output(List<T> list){
		for (T e: list)
			System.out.printf("%s ", e);
		System.out.println();
	}


//	private static void output(Collection<?> list){
//		for (Object e: list)
//			System.out.printf("%s ", e);
//		System.out.println();
//	}

}
