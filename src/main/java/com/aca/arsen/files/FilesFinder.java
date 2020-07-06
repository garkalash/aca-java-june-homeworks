package com.aca.arsen.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class FilesFinder {
    public static void main(String[] args) throws IOException {
        Path pathOfFiles = Paths.get("files", "findfolder");
      /*  Stream<Path> paths = Files.walk(pathOfFiles);
        Optional<Path> filteredFile = paths
                .filter(Objects::nonNull)
                .filter(file->file.getFileName().toString().matches("[\\D]+.txt"))
                .map(file -> file.getFileName().toString().toCharArray()).*/

      isValidName("aaa");


    }

    public static boolean isValidName(String name){
        name.chars().forEach(value -> System.out.println(value));
        return false;
    }

}
