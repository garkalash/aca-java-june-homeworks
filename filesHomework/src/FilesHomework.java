
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class FilesHomework {
    public static void main(String[] args) {
        Path path = Paths.get("New folder", "New folder");
        try (Stream<Path> allFiles = Files.walk(path)) {

            Optional<Path> file = allFiles
                    .filter(Objects::nonNull)
                    .filter(file1 -> file1.getFileName().toString().matches("[\\d]+.txt"))
                    .filter(file1 -> isEqualTo54(file1.getFileName().toString()))
                    .findFirst();

            FileInputStream fileReader = new FileInputStream(file.toString().substring(9, file.toString().length() - 1));

            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = fileReader.read()) != -1) {
                content.append((char) ch);
            }

            String[] fileContent = content.toString().split("\n");
            String fileName = fileContent[0].split(":")[1].trim();
            String fileText = fileContent[1].split(":")[1].trim();
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(fileText);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEqualTo54(String filename) {
        int sum = 0;
        int name = Integer.parseInt(filename.substring(0, filename.length() - 4));
        while (name != 0 && sum < 54) {
            sum += name % 10;
            name /= 10;
        }

        return sum == 54;
    }
}
