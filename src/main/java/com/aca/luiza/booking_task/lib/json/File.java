package com.aca.luiza.booking_task.lib.json;
/**
 * Abstract class File both for Write and Read classes, provides fileName field.
 */
public abstract class File {

    protected final String _fileName;

    protected File(String fileName) {
        _fileName = fileName;
    }
}
