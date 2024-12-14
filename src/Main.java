import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static NotePad notePad = new NotePad();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean running = true;
        while (running) {
            System.out.print("\n1. Add new note");
            System.out.print("\n2. Remove note");
            System.out.print("\n3. show all note");
            System.out.print("\n4. export note");
            System.out.print("\n5. exit ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String temp = addNoteMenu();
                    if (temp.equals("5"))
                        break;
                    if (temp.equals("note-added") || temp.equals("note already exixts"))
                        System.out.println("temp");
                    break;
                case 2:
                    String temp1 = removeNoteMenu();
                    if (temp1.equals("5"))
                        break;
                    if (temp1.equals("note-removed") || temp1.equals("note doesnot exixts"))
                        System.out.println("temp1");
                    break;
                case 3:
                    notePad.listNotes();
                    break;
                case 4:
                    String exportResult = exportNoteMenu();
                    if (!exportResult.equals("5"));
                    System.out.println(exportResult);
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static String addNoteMenu() {
        System.out.print("Enter note title: ");
        String title = scanner.nextLine();
        if (title.equals("5"))
            return "5";
        System.out.print("Enter the text:");
        String content = scanner.nextLine();
        return notePad.addNote(title, content);
    }

    private static String removeNoteMenu() {
        System.out.print("Enter the note title to remove: ");
        String title = scanner.nextLine();
        if (title.equals("5"))
            return "5";
        return notePad.removeNote(title);
    }

    private static String exportNoteMenu() throws IOException {
        System.out.println(" Enter the note title to export: ");
        String title = scanner.nextLine();
        if (title.equals("5"))
            return "5";
        notePad.exportNote(title);
        return notePad.exportNote(title);
    }
}