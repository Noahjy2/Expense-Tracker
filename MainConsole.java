import java.util.Scanner;

public class MainConsole{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("========== Expense Tracker ==========");
            System.out.print("""
            1. Add Expense
            2. View All Expense
            3. Search Expense
            4. Delete Expense
            5. Show Summary
            6. Exit
            """);
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice){
                case "1" -> System.out.println("Add expense");
                case "2" -> System.out.println("View all expense");
                case "3" -> System.out.println("Search expense");
                case "4" -> System.out.println("Delete summary");
                case "5" -> System.out.println("Show summary");
                case "6" -> System.out.println("Bye");
                default -> System.out.println("Invalid choice");
            }

            if (choice.equals("6")){
                break;
            }

        }

    }
}