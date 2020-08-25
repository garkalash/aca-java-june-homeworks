package com.aca.luiza.booking_task.lib.json;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Special class for reading Files,should use JSONParser
 */
public class Read extends File {
    private FileReader _file;

    public Read(String file) {
        super(file);
    }

    public Object readFromFile() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(_file);
    }

    public void open() throws IOException {
        _file = new FileReader(_fileName);
    }
}
