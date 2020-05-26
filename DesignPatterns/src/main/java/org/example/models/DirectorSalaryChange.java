package org.example.models;

import org.example.interfaces.ISalaryChange;

public class DirectorSalaryChange implements ISalaryChange {
    @Override
    public Double applyChange(Double amount) {
        return amount * 0.80;
    }
}
