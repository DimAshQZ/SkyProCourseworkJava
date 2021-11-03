package com.company;

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

        getAllEmployeesInfo();

    }

    public static void getAllEmployeesInfo() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
}
