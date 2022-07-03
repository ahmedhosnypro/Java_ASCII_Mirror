package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        System.out.println("Input the file path:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNext()) {
                lines.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        var optLine = lines.stream().max(Comparator.comparingInt(String::length));
        if (optLine.isPresent()) {
            int maxLength = optLine.get().length();
            var modifiedLines = new ArrayList<String>();
            lines.replaceAll(line -> line + " ".repeat(maxLength - line.length()));
            lines.forEach(line -> System.out.println(line + " | " + line));
        }
    }
}