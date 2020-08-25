package com.aca.luiza.booking_task.lib.json;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for writing in files
 */
public class Write extends File {
    private FileWriter _file;

    public Write(String file) {
        super(file);
    }

    public void writeToFile(String data) throws IOException {
        _file.write(data);
        _file.flush();
        _file.close();
    }

    public void open() throws IOException {
        _file = new FileWriter(_fileName);
    }
}
