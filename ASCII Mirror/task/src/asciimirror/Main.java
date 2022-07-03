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

            for (var line : lines) {
                StringBuilder sb = new StringBuilder();
                sb.append(line);
                sb.append(" ".repeat(maxLength - line.length()));
                StringBuilder res = new StringBuilder();
                res.append(sb);
                res.append(" | ");
                sb.reverse();
                for (int i = 0; i < sb.length(); i++) {
                    switch (sb.charAt(i)) {
                        case '\\':
                            res.append("/");
                            break;
                        case '/':
                            res.append("\\");
                            break;
                        case '}':
                            res.append("{");
                            break;
                        case '{':
                            res.append("}");
                            break;
                        case ']':
                            res.append("[");
                            break;
                        case '[':
                            res.append("]");
                            break;
                        case ')':
                            res.append("(");
                            break;
                        case '(':
                            res.append(")");
                            break;
                        case '<':
                            res.append(">");
                            break;
                        case '>':
                            res.append("<");
                            break;
                        default:
                            res.append(sb.charAt(i));
                            break;
                    }
                }
                System.out.println(res);
            }
        }
    }
}