import java.util.Date;

public class ConsumableClass{
    private final String name;
    private Float rating;
    private String startingDate, endingDate;
    private double consumptionTimeInHours = 0;
    private int consumptionDays = 0;
    private double totalconsumptionTimeInHours=0;
    private int totalconsumptionDays = 0;
    public ConsumableClass(String name, Float rating, String startingDate, String endingDate, double consumptionTimeInHours, int consumptionDays) {
        this.name = name;
        this.rating = rating;
        this.startingDate = startingDate;
        this.consumptionTimeInHours= consumptionTimeInHours;
        this.endingDate = endingDate;
        this.consumptionDays=consumptionDays;
        this.totalconsumptionTimeInHours+=consumptionTimeInHours;
        this.totalconsumptionDays+=consumptionDays;
    }
    public Float getRating(){
        return this.rating;
    }
    public String getName(){
        return this.name;
    }
    public String getStartingDate(){
        return this.startingDate;
    }
    public String getEndingDate(){
        return this.endingDate;
    }
    public double getConsumptionHours(){
        return this.consumptionTimeInHours;
    }
    public int getConsumptionDays(){
        return this.consumptionDays;
    }
    public void setRating(Float rating){
        this.rating=rating;
    }
    // public void setName(String name){
    //     this.name = name;
    // }
    public void setStartingDate(String startingDate){
        this.startingDate=startingDate;
    }
    public void setEndingDate(String endingDate){
        this.endingDate=endingDate;
    }
    public void setConsumptionHours(double consumptionTimeInHours){
        this.consumptionTimeInHours+=consumptionTimeInHours;
        this.totalconsumptionTimeInHours+=consumptionTimeInHours;
    }
    public void setConsumptionDays(int consumptionDays){
        this.consumptionDays+=consumptionDays;
        this.totalconsumptionDays+=consumptionDays;
    }
    public double getTotalconsumptionTimeInHours(){
        return this.totalconsumptionTimeInHours;
    }
    public int getotalconsumptionDays(){
        return this.totalconsumptionDays;
    }
}