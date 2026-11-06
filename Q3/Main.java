import java.io.*;
public class Main {
    // Manual close() version
    static void manualVersion() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new StringReader(
                            "Store 1\n1000\n2000\n3000"));
            String line;
            System.out.println("Manual Close Version:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(
                    "Error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println(
                        "Error while closing resource");
            }
        }
    }
    // Try-with-resources version
    static void tryWithResourcesVersion() {
        try (BufferedReader reader =
                new BufferedReader(
                        new StringReader(
                                "Store 1\n1000\n2000\n3000"))) {
            String line;
            System.out.println(
                    "\nTry-With-Resources Version:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        manualVersion();
        tryWithResourcesVersion();
        System.out.println(
                "\nReport generated successfully.");
    }
}
