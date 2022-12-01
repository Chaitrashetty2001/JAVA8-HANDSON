package employeeService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import employeedto.Employee;

public class EmployeeGetFile {

	public static List<Employee> readEmployee(String fileName) throws IOException {
		String fileName1 = "C:\\employee.csv";
		List<Employee> emp = Files.lines(Paths.get(fileName1)).skip(1)

				.map(line -> {
					String[] fields = line.split(",");
					return new Employee(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]),
							LocalDateTime.parse(fields[3]), Boolean.parseBoolean(fields[4]));
				})

				.collect(Collectors.toList());

		emp.forEach(System.out::println);
		return emp;

	}

	public static void sort(List<Employee> emp) {
		emp.stream().sorted(Comparator.comparing(Employee::getJoinDate).reversed()).limit(5)
				.forEach(System.out::println);
	}

	public static void getEmployee(List<Employee> emp, LocalDateTime date) {
		emp.stream().filter(i -> i.getJoinDate().equals(date)).forEach(System.out::println);
	}

	public static void workingDaysForNextWeek(LocalDateTime localDateTime) {
		LocalDateTime dateTime = LocalDateTime.now();
		LocalDateTime nextMonday = dateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		IntStream.range(0, 6).mapToObj(nextMonday::plusDays).collect(Collectors.toList()).forEach(System.out::println);

	}

	public static void basedOnIsManager(List<Employee> emp) {
		System.out.println(emp.stream().collect(Collectors.groupingBy(Employee::isManager)));

	}
	public static void  technicalLead(List<Employee> emp) {
		emp.stream().filter(i->Period.between(i.getJoinDate().toLocalDate(),LocalDate.now()).getYears()>=7).forEach(System.out::println);
		
	}

	public static void main(String[] args) throws IOException {
		String fileName = "C:\\employee.csv";
		System.out.println("EMPLOYEE DATA LIST");
		List<Employee> emp = readEmployee(fileName);
		System.out.println("------------------------------------------------TOP FIVE EMPLOYEE LIST BASED ON JOINING DATE--------------------------------------------------------------");
		sort(emp);
		System.out.println();
		System.out.println(	"------------------------------------------------EMPLOYEESBASED ON  JoiningDate AS INPUT------------------------------------------------------------------");
		System.out.println();
		getEmployee(emp, LocalDateTime.parse("2013-03-19T18:18:12.135"));
		System.out.println("--------------------------------------------------WORKING DAYS FOR NEXT WEEK------------------------------------------------------------------------------");
		System.out.println();
		workingDaysForNextWeek(LocalDateTime.parse("2019-10-28T19:18:12.135"));
		System.out.println("---------------------------------------------------DATA CATEGORISED AS REGULAR OR MANAGER BASED ON isManager FIELD----------------------------------------");
		basedOnIsManager(emp);
		System.out.println();
		System.out.println("----------------------------------------------------TechnicalLead for Employees having experience >7 yrs------------------------------------------------------------------------------------------------------");
		
		technicalLead(emp);
	
		

	}
}
