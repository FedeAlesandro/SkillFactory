package org.example.models;

import org.example.enums.EmployeeCategory;
import org.example.interfaces.ISalaryChange;

public class Employee {
    private String name;
    private EmployeeCategory category;
    private Double salary;
    private ISalaryChange salaryChange;

    public Employee(String name, EmployeeCategory category, Double salary) {
        this.name = name;
        this.category = category;
        this.salary = salary;
        salaryChange = this.chooseSalaryChange();
    }

    private Double getSalary() {
        return salary;
    }

    private void setSalary(Double salary) {
        this.salary = salary;
    }

    private EmployeeCategory getCategory() {
        return category;
    }

    private ISalaryChange chooseSalaryChange(){
        if(getCategory().equals(EmployeeCategory.director))
            return new DirectorSalaryChange();
        else
            if (getCategory().equals(EmployeeCategory.administrative))
                return new AdministrativeSalaryChange();
            else
                return new OperatorSalaryChange();
    }

    public void changeSalary(){
        setSalary(salaryChange.applyChange(getSalary()));
    }
}
