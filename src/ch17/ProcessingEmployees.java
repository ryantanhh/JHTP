package ch17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {
	public static void main(String[] args) {
		Employee [] employees = {
			new Employee("Jason", "Red", 5000, "IT"),
			new Employee("Ashley", "Green", 7600, "IT"),
			new Employee("Matthew", "Indigo", 3587.5, "Sales"),
			new Employee("James", "Indigo", 4700.77,  "Marketing"),
			new Employee("Luke", "Indigo", 6200, "IT"),
			new Employee("Jason", "Blue", 3200, "Sales"),
			new Employee("Wendy", "Brown", 4236.4, "Marketing")
		};
		List<Employee> list = Arrays.asList(employees);
		System.out.println("Complete Employee list:");
		list.stream().forEach(System.out::println);

		Predicate<Employee> salaryFourToSixthousand =
			e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

		System.out.printf("Employees earning $4000-$6000 per month sorted by salary:%n");
		list.stream()
			.filter(salaryFourToSixthousand)
			.sorted(Comparator.comparing(Employee::getSalary))
			.forEach(System.out::println);

		System.out.printf("First employee who earns 4000-$6000 per month :%n%s%n",
				list.stream()
				.filter(salaryFourToSixthousand)
				.findFirst()
				.get());

		Function<Employee, String> byFirstName = Employee::getFirstName;
		Function<Employee, String> byLastName = Employee::getLastName;

		Comparator<Employee> lastThenFirst = Comparator
			.comparing(byLastName)
			.thenComparing(byFirstName);

		System.out.printf("Employees in ascending order by last name then first name: %n");
		list.stream()
			.sorted(lastThenFirst)
			.forEach(System.out::println);

		System.out.printf("Employees in descending order by last name then first name: %n");
		list.stream()
			.sorted(lastThenFirst.reversed())
			.forEach(System.out::println);
		
		System.out.printf("Unique employee last names: %n");
		list.stream()
			.map(Employee::getLastName)
			.distinct()
			.sorted()
			.forEach(System.out::println);

		System.out.printf("%nEmployee names in order by last name then first name: %n");

		list.stream()
			.sorted(lastThenFirst)
			.map(Employee::getName)
			.forEach(System.out::println);

		System.out.printf("%nEmployees by department:%n");
		Map<String, List<Employee>> groupedByDepartment = 
			list.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment));
		groupedByDepartment.forEach(
				(department, employeesInDepartment) -> {
					System.out.println(department);
					employeesInDepartment.forEach(
							employee -> System.out.printf("  %s%n", employee)
							);
				});

		System.out.printf("%nCount of Employees by department%n");
		Map<String, Long> employeeCountByDepartment = 
			list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, 
						Collectors.counting())); 
		
		employeeCountByDepartment.forEach(
				(department, count) -> System.out.printf("%s has %d %s%n", 
					department, 
					count,
					count > 1 ? "employees" : "employee")
				);
		System.out.printf(
				"%nSum of Employees' salaries (via sum method): %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.sum()
				);

		System.out.printf(
				"%nSum of Employees' salaries (via reduce method): %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.reduce(0, (x, y) -> x + y)
				);

		System.out.printf(
				"%nSum of Employees' salaries (via reduce method): %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.average()
					.getAsDouble()
				);
	}
}
