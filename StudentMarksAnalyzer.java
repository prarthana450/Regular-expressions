import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StudentMarksAnalyzer {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("marks.txt"))) {
            // Convert to int array for calculations
            int[] marks = lines
                .filter(s -> !s.trim().isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();

            // Calculate Total
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }

            // Calculate Average
            double average = marks.length > 0 ? (double) total / marks.length : 0;

            // Find Highest Mark
            int highest = marks.length > 0 ? marks[0] : 0;
            for (int mark : marks) {
                if (mark > highest) {
                    highest = mark;
                }
            }

            // Display Results
            System.out.println("=== Student Marks Analysis ===");
            System.out.println("Total Marks: " + total);
            System.out.println("Average Mark: " + String.format("%.2f", average));
            System.out.println("Highest Mark: " + highest);
            System.out.println("Total Students: " + marks.length);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: One of the marks is not a valid number.");
        }
    }
}
