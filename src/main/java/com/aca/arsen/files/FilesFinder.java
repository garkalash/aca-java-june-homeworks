package com.aca.arsen.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FilesFinder {
    public static void main(String[] args) {
        Path pathOfFiles = Paths.get("find_file_homework");
        try {
            Stream<Path> paths = Files.walk(pathOfFiles);
            Optional<Path> foundFile = paths
                    .filter(file -> file.getFileName().toString().matches("[\\d]+.txt"))
                    .filter(file -> isValidName(file.getFileName().toString()))
                    .findFirst();
            BufferedReader reader = new BufferedReader(new FileReader(foundFile.toString().substring(9, foundFile.toString().length()-1)));
            StringBuilder fileContent = new StringBuilder();
            String line = "";
            while((line= reader.readLine()) !=null)
                fileContent.append(line).append("\n");
            String newfileName = fileContent.toString().substring(10,26);
            String newfileContent = fileContent.toString().substring(36);
            BufferedWriter writer = new BufferedWriter(new FileWriter(newfileName));
            writer.write(newfileContent);
            writer.flush();
            writer.close();
            } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean isValidName(String name){
         return name.split("\\.")[0].chars()
                .map(Character::getNumericValue)
                .sum() == 54;
    }

}
