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


    public void readFile(){

    }
}