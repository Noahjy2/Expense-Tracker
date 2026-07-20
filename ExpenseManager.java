import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseManager {
    private ArrayList<Expense> expenses = new ArrayList<>();

    //test data
    public void addInitailData(){
        Expense e1 = new Expense("000001", "Transportation", 250.40, "12/2/2022", "Flight from Malaysia to China");
        expenses.add(e1);
    }


    public Expense getExpense(String id){
        for (Expense expense : expenses){
            if (expense.getId().equals(id)){
                return expense;
            }
        }
        return null;
    }
    

    public void addExpense(Scanner scanner){
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        
        if (getExpense(id) != null){
            System.out.println("ID already exist!");
            return;
        }

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        
        while (!scanner.hasNextDouble()){
            System.out.println("Please Enter Numbers Only!");
            System.out.print("Re-enter amount: ");
            amount = scanner.nextDouble();
        }

        System.out.print("Enter date: ");
        String inputDate = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(inputDate, formatter);
        String newDate = date.format(formatter);

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Expense newExpense = new Expense(id, category, amount, newDate, description);
        expenses.add(newExpense);

        //save File
    }



    public void viewAllExpenses(Scanner scanner){
        //read file to get data
        if (expenses.isEmpty()){
            System.out.println("No Expense Exist");
            return;
        }

        System.out.print("""
        =============================================================================================       
         id        Category           Amount        Date          Description                  
        =============================================================================================
        """);
        for (Expense expense : expenses){

            String id = expense.getId();
            String category = expense.getCategory();
            Double amount = expense.getAmount();
            String date = expense.getDate();
            String description = expense.getDescription();

            System.out.printf("%-10s %-18s $%-12.2f %-13s %-30s\n", id, category, amount, date, description);
        }
    }

    public void searchExpense(Scanner scanner){
        System.out.print("Enter Expense ID: ");
        String id = scanner.nextLine();

        for (Expense expense : expenses){
            if (expense.getId().equals(id)){
                System.out.println("\n" + expense.toString());
            }
        }
    }

    //delete expense
    public void deleteExpense(Scanner scanner){
        System.out.print("Enter Expense ID: ");
        String id = scanner.nextLine();

        for (Expense expense : expenses){
            if (expense.getId().equals(id)){
                expenses.remove(expense);
                System.out.println("Expenses Deleted.");
                return;
            }
        }
        System.out.println("Expense is Not Found!");
    }

    //show Summary
}