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

        getAllEmployeesInfo();// Базовая сложность 8a
        System.out.println("Сумма затрат на ЗП в месяц: " + calcSalarySum());// Базовая сложность 8b
        System.out.println("Сотрудник с минимальной ЗП: " + minSalaryEmployee());// Базовая сложность 8c
        System.out.println("Сотрудник с максимальной  ЗП: " + maxSalaryEmployee());// Базовая сложность 8d
        System.out.println("Среднее значение зарплат: " + averageSalary());// Базовая сложность 8e
        allEmployeesName();// Базовая сложность 8f

        indexationOfWages(150);// Повышенная сложность 1
        getAllEmployeesInfo();
        System.out.println("Сотрудник с минимальной ЗП из 2 отдела: " + minSalaryEmployeeOfDepartment(2));// Повышенная сложность 2a
        System.out.println("Сотрудник с максимальной ЗП из 5 отдела: " + maxSalaryEmployeeOfDepartment(5));// Повышенная сложность 2b
        System.out.println("Сумма затрат на ЗП в месяц в 3 отделе: " + calcSalarySumOfDepartment(3));// Повышенная сложность 2c
        System.out.println("Среднее значение зарплат в 4 отделе: " + averageSalaryOfDepartment(4));// Повышенная сложность 2d
        indexationOfWagesOfDepartment(1, 130);// Повышенная сложность 2e
        getAllEmployeesInfoOfDepartment(1);// Повышенная сложность 2f
        allEmployeesWithLessSalary(139000);// Повышенная сложность 3a
        allEmployeesWithSalaryMore(140000);// Повышенная сложность 3b


    }

    public static void getAllEmployeesInfo() {
        Arrays.stream(employees).forEach(System.out::println);
    }

    public static double calcSalarySum() {
        return Arrays.stream(employees).mapToDouble(Employee::getSalary).sum();
    }

    public static Employee minSalaryEmployee() {
        double minSalary = Integer.MAX_VALUE;
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
        double maxSalary = 0;
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

    public static void indexationOfWages(double percent) {
        for (Employee employee : employees) employee.setSalary(percent / 100 * employee.getSalary());
    }

    public static Employee minSalaryEmployeeOfDepartment(int department) {
        double minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee maxSalaryEmployeeOfDepartment(int department) {
        double maxSalary = 0;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static double calcSalarySumOfDepartment(int department) {
        return Arrays.stream(employees).filter(employee -> employee.getDepartment() == department).mapToDouble(Employee::getSalary).sum();
    }

    public static double averageSalaryOfDepartment(int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                count += 1;
            }
        }
        return calcSalarySumOfDepartment(department) / count;
    }

    public static void indexationOfWagesOfDepartment(int department, double percent) {
        Arrays.stream(employees).filter(value -> value.getDepartment() == department).forEach(employee -> employee.setSalary(percent / 100 * employee.getSalary()));
    }

    public static void getAllEmployeesInfoOfDepartment(int department) {
        System.out.println("\nВсе сотрудники " + department + " отдела.");
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println("ФИО: " + employee.getName() +
                        ", ЗП: " + employee.getSalary() +
                        ", id: " + employee.getId());
            }
        }
    }

    public static void allEmployeesWithLessSalary(double salary) {
        System.out.println("\nВсе сотрудники c ЗП меньше " + salary);
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println("ФИО: " + employee.getName() +
                        ", ЗП: " + employee.getSalary() +
                        ", id: " + employee.getId());
            }
        }
    }

    public static void allEmployeesWithSalaryMore(double salary) {
        System.out.println("\nВсе сотрудники c ЗП больше " + salary);
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println("ФИО: " + employee.getName() +
                        ", ЗП: " + employee.getSalary() +
                        ", id: " + employee.getId());
            }
        }
    }
}
