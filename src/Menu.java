import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    public static void run() throws IOException {
        Scanner scan = new Scanner(System.in);
        //"src/this.txt";
        System.out.println("choose 1 to crete new file with the name of the current files names");
        System.out.println("choose 2 to check existing file ");
        System.out.println("press 3 to create a new file");
        System.out.println("press any other letter/number to exit");
        String firstQuest = scan.next();
        switch (firstQuest) {
            case "1":
                try {
                    System.out.println("choose file location");
                    String newLocation = scan.next();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(newLocation));
                    writer.write(Arrays.toString(fileNames()));
                    writer.close();
                } catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "2":
                System.out.println("file name");
                String searchFile = scan.next();
                if(loop(searchFile)) {
                    System.out.println("file found");
                    break;
                }
                System.out.println("file not found");
                break;
            case "3":
                System.out.println("file name");
                String newLocation = scan.next();
                BufferedWriter writer = new BufferedWriter(new FileWriter(newLocation));
                writer.close();
                break;
            default:
        }
    }

    public static String[] fileNames() {
        File file = new File("src");
        return file.list();
    }

    public static boolean loop(String searchFile) {
        for (int i = 0; i < fileNames().length; i++) {
            if (fileNames()[i].contains(searchFile)) {
                return true;
            }
        }
        return false;
    }
}
