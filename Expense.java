public class Expense {
    private String id;
    private String category;
    private double amount;
    private String date;
    private String description;

    Expense(String id, String category, double amount, String date, String description){
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + "\nCategory: " + this.category + "\nAmount: $" + this.amount +
         "\nDate: " + this.date + "\nDescription: " + this.description;
    }
    
    public String toFileString(){
        return this.getId() + "," + 
                this.getCategory() + "," +
                this.getAmount() + "," + 
                this.getDate() + "," + 
                this.getDescription() + "\n";
    }

    //Getter
    public String getId(){
        return this.id;
    }
    public String getCategory(){
        return this.category;
    }
    public double getAmount(){
        return this.amount;
    }
    public String getDate(){
        return this.date;
    }
    public String getDescription(){
        return this.description;
    }


    //Setter
    public void setId(String id){
        this.id = id;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setDescription(String description){
        this.description = description;
    }

    
}