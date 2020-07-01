package com.aca.narekhakobyan.homework.employee.functionality;

import java.io.IOException;

public interface Employee {
    void sellItem(String name, Integer count) throws IOException;
    void sellItem(String name) throws IOException;
}
