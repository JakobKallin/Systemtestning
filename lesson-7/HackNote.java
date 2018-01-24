import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class HackNote {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to HackNote!");
        System.out.println();

        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("1 - Read note");
        System.out.println("2 - Write note");
        System.out.println();
        System.out.print("Please enter option: ");
        int option = Integer.parseInt(console.nextLine());
        System.out.println();

        if (option == 1) {
            System.out.println("You have the following notes:");
            System.out.println();
            File dir = new File("notes");
            String[] files = dir.list();
            for (String f : files) {
                System.out.println("- " + f);
            }
            System.out.println();

            System.out.print("Please enter name of note to read: ");
            String name = console.nextLine();

            System.out.println();
            System.out.println("Contents of note:");
            System.out.println();

            Path noteFile = Paths.get("notes/" + name);
            String note = new String(Files.readAllBytes(noteFile));
            System.out.println(note);
        }
        else {
            System.out.print("Please enter name of note to write: ");
            String name = console.nextLine();
            System.out.print("Please enter contents of note: ");
            String contents = console.nextLine();
            Path noteFile = Paths.get("notes/" + name);
            Files.write(noteFile, contents.getBytes());
            System.out.println();
            System.out.println("Note " + name + " has been created!");
        }

        System.out.println();
        System.out.println("Thank you for using HackNote!");
    }
}
