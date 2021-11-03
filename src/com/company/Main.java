package com.company;

import java.util.Arrays;

public class Main {

    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Джефф Безос", 1, 177000);
        employees[1] = new Employee("Илон Маск", 2, 151000);
        employees[2] = new Employee("Бернар Арно", 3, 150000);
        employees[3] = new Employee("Билл Гейтс", 4, 124000);
        employees[4] = new Employee("Марк Цукерберг", 5, 97000);
        employees[5] = new Employee("Уоррен Баффет", 1, 96000);
        employees[6] = new Employee("Ларри Эллисон", 2, 93000);
        employees[7] = new Employee("Ларри Пейдж", 3, 91500);
        employees[8] = new Employee("Сергей Брин", 4, 89000);
        employees[9] = new Employee("Мукеш Амбани", 5, 84500);

        getAllEmployeesInfo();// 8a
        System.out.println("Сумма затрат на ЗП в месяц: " + calcSalarySum());// 8b
        System.out.println("Сотрудник с минимальной ЗП: " + minSalaryEmployee());// 8c
        System.out.println("Сотрудник с максимальной  ЗП: " + maxSalaryEmployee());// 8d
        System.out.println("Среднее значение зарплат: " + averageSalary());// 8e
        allEmployeesName();// 8f
    }

    public static void getAllEmployeesInfo() {
        Arrays.stream(employees).forEach(System.out::println);
    }

    public static int calcSalarySum() {
        return Arrays.stream(employees).mapToInt(Employee::getSalary).sum();
    }

    public static Employee minSalaryEmployee() {
        int minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee maxSalaryEmployee() {
        int maxSalary = 0;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static double averageSalary() {
        return calcSalarySum() / employees.length;
    }

    public static void allEmployeesName() {
        Arrays.stream(employees).map(employee -> employee.getId() + ") " + employee.getName()).forEach(System.out::println);
    }
}
