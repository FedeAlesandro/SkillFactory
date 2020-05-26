package org.example.models;

import org.example.interfaces.ISalaryChange;

public class AdministrativeSalaryChange implements ISalaryChange {
    @Override
    public Double applyChange(Double amount) {
        return amount * 1.15;
    }
}
