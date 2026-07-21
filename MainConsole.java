import java.util.Scanner;

public class MainConsole{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
            

        while (true){
            ExpenseManager manager = new ExpenseManager();    
            System.out.println("\n========== Expense Tracker ==========");
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
                case "1" -> manager.addExpense(scanner);
                case "2" -> manager.viewAllExpenses(scanner);
                case "3" -> manager.searchExpense(scanner);
                case "4" -> manager.deleteExpense(scanner);
                case "5" -> manager.showSummary();
                case "6" -> System.out.println("Bye");
                default -> System.out.println("Invalid choice");
            }

            if (choice.equals("6")){
                break;
            }

        }

    }
}