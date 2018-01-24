import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HackThis {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Välkommen till eSjukhuset!");
        System.out.println();

        System.out.print("Personnummer: ");
        String username = console.nextLine();
        System.out.print("Lösenord: ");
        String password = console.nextLine();
        System.out.println();

        try {
            Path passwordFile = Paths.get("users/" + username + "/password.txt");
            String correctPassword = new String(Files.readAllBytes(passwordFile));
            if (!password.equals(correctPassword)) {
                throw new SecurityException();
            }
        }
        catch(Exception e) {
            System.out.println("Fel: ogiltigt personnummer eller lösenord");
            System.exit(1);
        }

        File dir = new File("users/" + username);
        String[] files = dir.list();
        List<String> journalFiles = new ArrayList<String>();
        for (String f : files) {
            if (!f.equals("password.txt")) {
                journalFiles.add(f);
            }
        }

        System.out.println("Du har följande journalinlägg:");
        System.out.println();
        for (String withExtension : journalFiles) {
            String withoutExtension = withExtension.substring(0, withExtension.lastIndexOf('.'));
            System.out.println("- " + withoutExtension);
        }
        System.out.println();
        System.out.print("Vilket journalinlägg vill du se? ");
        String selected = console.nextLine();
        System.out.println();

        try {
            Path journalFile = Paths.get("users/" + username + "/" + selected + ".txt");
            String entry = new String(Files.readAllBytes(journalFile));
            System.out.println("Journalinlägg #" + selected + ":");
            System.out.println();
            System.out.println("\"" + entry + "\"");
        }
        catch(Exception e) {
            System.out.println("Fel: ogiltigt journalinlägg");
            System.exit(1);
        }

        System.out.println();
        System.out.println("Tack för att du använder eSjukhuset!");
    }
}
