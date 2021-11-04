package com.company;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;


public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void getAllEmployeesInfo() {
        Arrays.stream(employees).forEach(System.out::println);
    }

    public double calcSalarySum() {
        return Arrays.stream(employees).mapToDouble(Employee::getSalary).sum();
    }

    public Employee minSalaryEmployee() {
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

    public Employee maxSalaryEmployee() {
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

    public double averageSalary() {
        return calcSalarySum() / employees.length;
    }

    public void allEmployeesName() {
        Arrays.stream(employees).map(employee -> employee.getId() + ") " + employee.getName()).forEach(System.out::println);
    }

    public void indexationOfWages(double percent) {
        for (Employee employee : employees) employee.setSalary(percent / 100 * employee.getSalary());
    }

    public Employee minSalaryEmployeeOfDepartment(int department) {
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

    public Employee maxSalaryEmployeeOfDepartment(int department) {
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

    public double calcSalarySumOfDepartment(int department) {
        return Arrays.stream(employees).filter(employee -> employee.getDepartment() == department).mapToDouble(Employee::getSalary).sum();
    }

    public double averageSalaryOfDepartment(int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                count += 1;
            }
        }
        return calcSalarySumOfDepartment(department) / count;
    }

    public void indexationOfWagesOfDepartment(int department, double percent) {
        Arrays.stream(employees).filter(value -> value.getDepartment() == department).forEach(employee -> employee.setSalary(percent / 100 * employee.getSalary()));
    }

    public void getAllEmployeesInfoOfDepartment(int department) {
        System.out.println("\nВсе сотрудники " + department + " отдела.");
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println("ФИО: " + employee.getName() +
                        ", ЗП: " + employee.getSalary() +
                        ", id: " + employee.getId());
            }
        }
    }

    public void allEmployeesWithLessSalary(double salary) {
        System.out.println("\nВсе сотрудники c ЗП меньше " + salary);
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println("ФИО: " + employee.getName() +
                        ", ЗП: " + employee.getSalary() +
                        ", id: " + employee.getId());
            }
        }
    }

    public void allEmployeesWithSalaryMore(double salary) {
        System.out.println("\nВсе сотрудники c ЗП больше " + salary);
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println("ФИО: " + employee.getName() +
                        ", ЗП: " + employee.getSalary() +
                        ", id: " + employee.getId());
            }
        }
    }

    public void addEmployee(String name, int department, int salary) {
        Employee newEmployee = new Employee(name, department, salary);
        boolean empty = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                empty = true;
                break;
            }
        }
        if (!empty) {
            employees[size++] = newEmployee;
        }
    }

    public void deleteEmployee(String name) {
        IntStream.range(0, employees.length).filter(i -> Objects.equals(employees[i].getName(), name)).forEach(i -> employees[i] = null);
    }

    /* Ошибка NullPointerException пока не понял как работатет
    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }*/

    public void changeEmployee(String name, double salary) {
        for (Employee employee : employees) {
            if (Objects.equals(employee.getName(), name)) {
                employee.setSalary(salary);
            }
        }
    }

    public void changeEmployee(String name, int department) {
        for (Employee employee : employees) {
            if (Objects.equals(employee.getName(), name)) {
                employee.setDepartment(department);
            }
        }
    }

    public void employeesByDepartment() {
        System.out.println("\n ФИО всех сотрудников по отделам");
        int departments = 1;
        for (Employee value : employees) {
            if (value.getDepartment() > departments) {
                departments = value.getDepartment();
            }
        }
        for (int i = 1; i <= departments; i++) {
            System.out.println(i + " отдел");
            for (Employee employee : employees) {
                if (employee.getDepartment() == i) {
                    System.out.println(employee.getName());
                }
            }
        }
    }
}
