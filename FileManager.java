import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager{

    public void saveFile(ArrayList<Expense> expenses){

        String filePath = "expenses.txt";
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Expense expense : expenses){
        
                writer.write(expense.toFileString());
            }

            writer.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot find file location.");
        }
        catch (IOException e){
            System.out.println("Cannot access to file");
        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }
    }


    public void readFile(ArrayList<Expense> expenses){
        
        String filePath = "expenses.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            line = reader.readLine();

            if (line == null){
                System.out.println("The file is empty");
                return;
            }

            do {
                String[] data = line.split(",");
                String id = data[0];
                String category = data[1];
                Double amount = Double.parseDouble(data[2]);
                String date = data[3];
                String description = data[4];
                
                Expense newExpense = new Expense(id, category, amount, date, description);
                expenses.add(newExpense);

            } while ((line = reader.readLine()) != null);

        }
        catch (FileNotFoundException e){
            System.out.println("Cannot find file location.");
        }
        catch (IOException e){
            System.out.println("Cannot access to file");
        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }
        
    }
}