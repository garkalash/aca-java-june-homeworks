package employee.functionality;

import java.io.IOException;

public interface Employee {
    void sellItem(String name, Integer count) throws IOException;
    void sellItem(String name) throws IOException;
}
