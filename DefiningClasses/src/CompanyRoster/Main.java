package CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departmentHashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Employee employee = null;
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else {
                employee = new Employee(name, salary, position, department);
            }

            if (!departmentHashMap.containsKey(department)) {
                departmentHashMap.put(department, new Department(department));
            }
            departmentHashMap.get(department).getEmployees().add(employee);

        }

        Department maxDepartmentAverage = departmentHashMap
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverage()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxDepartmentAverage.getName());

        maxDepartmentAverage.getEmployees()
                .stream()
                .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(e -> System.out.println(e.toString()));
    }
}
