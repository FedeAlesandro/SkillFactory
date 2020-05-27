package org.example.models;

import org.example.interfaces.ISalaryChange;

public class OperatorSalaryChange implements ISalaryChange {
    @Override
    public Double applyChange(Double amount) {
        return amount * 1.40;
    }
}
