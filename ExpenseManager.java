import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseManager {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private FileManager file = new FileManager();

    //initialize data
    public ExpenseManager(){
        file.readFile(expenses);
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

        double amount;

        while (true){
            System.out.print("Enter amount: ");
            String input = scanner.nextLine();
            
            try {
                amount = Double.parseDouble(input);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Please Enter Valid Number.");
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String newDate;
        while (true) {
            System.out.print("Enter date: ");
            String inputDate = scanner.nextLine();

            try {
                LocalDate date = LocalDate.parse(inputDate, formatter);
                newDate = date.format(formatter);
                break;
            }
            catch (DateTimeParseException e){
                System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            }
        }
        
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Expense newExpense = new Expense(id, category, amount, newDate, description);
        expenses.add(newExpense);

        file.saveFile(expenses);
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
            double amount = expense.getAmount();
            String date = expense.getDate();
            String description = expense.getDescription();

            System.out.printf("%-10s %-18s $%-12.2f %-13s %-30s\n", id, category, amount, date, description);
        }
    }


    public void searchExpense(Scanner scanner){
        System.out.print("Enter Expense ID: ");
        String id = scanner.nextLine();

        if (getExpense(id) != null){
            System.out.println("\n" + getExpense(id).toString());
        } else {
            System.out.println("Expense Not Found!");
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
                file.saveFile(expenses);
                return;
            }
        }
        System.out.println("Expense is Not Found!");

        
    }

    
    public void showSummary(){

        if (expenses.isEmpty()){
            System.out.println("No Expense Exist.");
            return;
        }

        int count = 0;
        double total = 0;
        double highest = 0;
        double lowest = 0;
        double average = 0;
        String highestCategory = "";
        String lowestCategory = "";
        String highestId = "";
        String lowestId = "";

        for (Expense expense : expenses){
            
            double amount = expense.getAmount();
            total += amount; 
            if (amount > highest){
                highest = amount;
                highestCategory = expense.getCategory();
                highestId = expense.getId();
            }
            if (lowest == 0 || amount < lowest){
                lowest = amount;
                lowestCategory = expense.getCategory();
                lowestId = expense.getId();
            }
            count++;
        }

        average = total / count;

        System.out.println("\n============== Expense Summary ==============");
        System.out.println("Number of Expenses: " + count);

        System.out.printf("\nTotal Expenses    : $%.2f\n", total);
        System.out.printf("Average Expense   : $%.2f\n", average);

        System.out.printf("\nHighest Expense   : $%.2f\n", highest);
        System.out.println("Category          : " + highestCategory);
        System.out.println("ID                : " + highestId);

        System.out.printf("\nLowest Expense    : $%.2f\n", lowest);
        System.out.println("Category          : " + lowestCategory);
        System.out.println("ID                : " + lowestId);
        System.out.println("=============================================");
    }
}