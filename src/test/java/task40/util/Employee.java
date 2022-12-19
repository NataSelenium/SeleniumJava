package task40.util;

import java.util.Objects;

public class Employee {
    private  String name;
    private String position;
    private String office;
    private int  age;
    private int  salary;

    public Employee(String empName, String empPosition, String empOffice, int empAge, int empSalary)
    {
        name = empName;
        position = empPosition;
        office = empOffice;
        age = empAge;
        salary = empSalary;
    }

    public Employee(String empName, String empPosition, String empOffice)
    {
        name = empName;
        position = empPosition;
        office = empOffice;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getOffice() {
        return office;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(position, employee.position) &&
                Objects.equals(office, employee.office);
    }
}
