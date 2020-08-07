package com.aca.armine.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Path copyFilePath = Paths.get("file");
        Path copiedFilePath;
        List<File> copyFiles = main.findFile(copyFilePath);
        if (copyFiles == null) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        for (File copyFile : copyFiles) {
            copiedFilePath = Paths.get("file\\", copyFile.getName());
            try {
                Files.copy(copyFile.toPath(), copiedFilePath, StandardCopyOption.COPY_ATTRIBUTES);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<File> findFile(Path filepath) {
        Stream<Path> stream = null;
        try {
            stream = Files.find(filepath, 100, ((path, basicFileAttributes) -> {
                File file = path.toFile();
                return file.isFile();
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<File> list = stream
                .filter(Objects::nonNull)
                .map(Path::toFile)
                .filter(file -> file.getName().substring(file.getName().lastIndexOf(".") + 1).equals("txt"))
                .filter(file -> file.getName().replaceFirst("[.][^.]+$", "").matches("\\d+"))
                .filter(file -> getCharsSum(file.getName().replaceFirst("[.][^.]+$", "").toCharArray()) == 54)
                .collect(Collectors.toList());
       Optional<List<File>> optionalFileList= Optional.of(list);
       if(optionalFileList.isPresent()){
           return list;
       } else
           throw new NullPointerException();
    }

    public int getCharsSum(char[] chars) {
        int sum = 0;
        for (char ch : chars) {
            sum += Character.getNumericValue(ch);
        }
        return sum;
    }


}

