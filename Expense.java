public class Expense {
    private int id;
    private String category;
    private double amount;
    private String date;
    private String description;


    //Getter
    public int getId(){
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
    public void setId(int id){
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