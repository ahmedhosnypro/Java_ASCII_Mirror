package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        System.out.println("Input the file path:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        System.out.println(filePath);

        try (Scanner fileScanner = new Scanner(new File("D:\\7-Learn\\Java\\HyperSkill\\ASCII Mirror\\ASCII Mirror\\task\\src\\asciimirror\\text.txt"))) {
            while (fileScanner.hasNext()) {
                lines.add(fileScanner.nextLine());
            }

            var length = lines.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get().length();
            lines.forEach(l -> System.out.println(l + " ".repeat(length - l.length())));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}