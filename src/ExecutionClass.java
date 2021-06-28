import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ExecutionClass {
    ArrayList<ConsumableClass> booklist = new ArrayList<>();
    ArrayList<ConsumableClass> movielist = new ArrayList<>();
    ArrayList<ConsumableClass> serieslist = new ArrayList<>();
    double totalConsumptionhours=0;
    int totaconsumptiondays=0;
    
    public static void main(String[] args) {
        ExecutionClass e = new ExecutionClass();
        
        for (ConsumableClass c :e.booklist){
            System.out.println(c.getRating());
        }
        while(true)
        {
            System.out.println("************************************************");
            
            System.out.println("Press: 0 (EXIT)");
            System.out.println("Press: 1 (Add a consumable)");
            System.out.println("Press: 2 (Edit a consumable)");
            System.out.println("Press: 3 (Delete a consumable)");         
            System.out.println("Press: 4 (See consumable list)"); 
            System.out.println("Press: 5 (Overview of the consumable)"); 
            
            System.out.println("************************************************");
            System.out.print("Enter Key: ");
            Scanner input=new Scanner(System.in);
            int selection = input.nextInt();

            int flag=0;
            switch(selection)
            {
                case 0:
                    //EXIT
                    flag=1;
                    break;
                    
                case 1:
                    //ADD 
                    e.add();
                    break;

                case 2:
                    //edit
                    e.edit();
                    
                    break;

                case 3:
                    //delete
                    e.delete();
                    break;
                    
                case 4:
                    //viewConsumales
                    e.viewConsumales();
                    break;
                
                case 5:
                    //overallInfo
                    e.overallInfo();
                    break;
            }
            
            if(flag==1)
            {
                break;
            }
            
            System.out.println("");
        }
        
        
    }
    public void delete(){
        System.out.println("Select consumable you want to delete from");
        System.out.println("1. Books.");
        System.out.println("2. Movies.");
        System.out.println("3. Series.");
        Scanner sc= new Scanner(System.in);
        int j= sc.nextInt();
        if (j==1){
            deleteBook();
        }
        if(j==2){
            deleteMovie();
        }
        if(j==3){
            deleteSeries();
        }
    }
   
    public void addBook(){
        System.out.println("Book name");
        Scanner s= new Scanner(System.in);
        String name=s.nextLine();
        System.out.println("Starting date(yyyy/mm/dd)");
        String startingDate= s.nextLine();
        if(startingDate.equals("")){
            startingDate= null;
        }
        System.out.println("Ending date(yyyy/mm/dd)");
        String endingDate = s.nextLine();
        if(endingDate.equals("")){
            endingDate= null;
        }
        System.out.println("Rating");
        Float rating = s.nextFloat();
        System.out.println("Consumption in hours");
        double consumptionTimeInHours = s.nextDouble();
        System.out.println("Consumption in days");
        int consumptionDays = s.nextInt();
        ConsumableClass newBook= new Book(name, rating, startingDate, endingDate, consumptionTimeInHours,consumptionDays);
        booklist.add(newBook);

        //System.out.println(newBook.getConsumptionDays());
    }
    public void addMovie(){
        System.out.println("Movie name");
        Scanner s= new Scanner(System.in);
        String name=s.nextLine();
        System.out.println("Starting date(yyyy/mm/dd)");
        String startingDate= s.nextLine();
        if(startingDate.equals("")){
            startingDate= null;
        }
        System.out.println("Ending date(yyyy/mm/dd)");
        String endingDate = s.nextLine();
        if(endingDate.equals("")){
            endingDate= null;
        }
        System.out.println("Rating");
        Float rating = s.nextFloat();
        System.out.println("Consumption in hours");
        double consumptionTimeInHours = s.nextDouble();
        System.out.println("Consumption in days");
        int consumptionDays = s.nextInt();
        ConsumableClass newMovie= new Movie(name, rating, startingDate, endingDate, consumptionTimeInHours,consumptionDays);
        movielist.add(newMovie);
        //System.out.println(newBook.getConsumptionDays());
    }
    public void addSeries(){
        System.out.println("Series name");
        Scanner s= new Scanner(System.in);
        String name=s.nextLine();
        System.out.println("Starting date(yyyy/mm/dd)");
        String startingDate= s.nextLine();
        if(startingDate.equals("")){
            startingDate= null;
        }
        System.out.println("Ending date(yyyy/mm/dd)");
        String endingDate = s.nextLine();
        if(endingDate.equals("")){
            endingDate= null;
        }
        System.out.println("Rating");
        Float rating = s.nextFloat();
        System.out.println("Consumption in hours");
        double consumptionTimeInHours = s.nextDouble();
        System.out.println("Consumption in days");
        int consumptionDays = s.nextInt();
        ConsumableClass newSeries= new Series(name, rating, startingDate, endingDate, consumptionTimeInHours,consumptionDays);
        serieslist.add(newSeries);
        //System.out.println(newBook.getConsumptionDays());
    }
    public void editBook(){
        System.out.println("Select a book you want to edit");
        int i=1;
        for (ConsumableClass b:booklist){
            System.out.println(i+". book: "+b.getName()+", "+b.getRating()+", "+b.getStartingDate()+", "+b.getEndingDate()+", "+b.getConsumptionHours()+", "+b.getConsumptionDays());
            i++;
        }
        Scanner s= new Scanner(System.in);
        int j = s.nextInt()-1;
        //k=1;
        try{
            ConsumableClass b = booklist.get(j);
            if(b.getEndingDate()!=null){
                return;
            }
            System.out.println("Select which parameter you want to edit");
            System.out.println("1. Edit rating");
            System.out.println("2. ending date");
            System.out.println("3. Add consumption time");
            System.out.println("4. ending date");
            int k = s.nextInt();

            if(k==1){
                System.out.println("Enter rating:");
                Float rating= s.nextFloat();
                booklist.get(j).setRating(rating);
            }
            if(k==2){
                System.out.println("Enter ending date(yyyy/mm/dd):");
                String endingDate = s.nextLine();
                booklist.get(j).setEndingDate(endingDate);
            }
            if(k==3){
                System.out.println("Add consumption time:");
                double consumptionTimeInHours = s.nextDouble();
                booklist.get(j).setConsumptionHours(consumptionTimeInHours);
                //booklist.get(j).
                totalConsumptionhours+=consumptionTimeInHours;
            }
            if(k==4){
                System.out.println("Add consumption days:");
                int consumptionDays = s.nextInt();
                booklist.get(j-1).setConsumptionDays(consumptionDays);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        } 
        
    }
    public void editMovie(){
        System.out.println("Select a movie you want to edit");
        int i=1;
        for (ConsumableClass b:movielist){
            System.out.println(i+". movie: "+b.getName()+", "+b.getRating()+", "+b.getStartingDate()+", "+b.getEndingDate()+", "+b.getConsumptionHours()+", "+b.getConsumptionDays());
            i++;
        }
        Scanner s= new Scanner(System.in);
        int j = s.nextInt()-1;
        //k=1;
        try{
            ConsumableClass b = movielist.get(j);
            if(b.getEndingDate()!=null){
                return;
            }
            System.out.println("Select which parameter you want to edit");
            System.out.println("1. Edit rating");
            System.out.println("2. ending date");
            System.out.println("3. Add consumption time");
            System.out.println("4. ending date");
            int k = s.nextInt();

            if(k==1){
                System.out.println("Enter rating:");
                Float rating= s.nextFloat();
                movielist.get(j).setRating(rating);
            }
            if(k==2){
                System.out.println("Enter ending date(yyyy/mm/dd):");
                String endingDate = s.nextLine();
                movielist.get(j).setEndingDate(endingDate);
            }
            if(k==3){
                System.out.println("Add consumption time:");
                double consumptionTimeInHours = s.nextDouble();
                movielist.get(j).setConsumptionHours(consumptionTimeInHours);
                totalConsumptionhours+=consumptionTimeInHours;
            }
            if(k==4){
                System.out.println("Add consumption days:");
                int consumptionDays = s.nextInt();
                movielist.get(j-1).setConsumptionDays(consumptionDays);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        } 
        
    }
    public void editSeries(){
        System.out.println("Select a Series you want to edit");
        int i=1;
        for (ConsumableClass b:serieslist){
            System.out.println(i+". movie: "+b.getName()+", "+b.getRating()+", "+b.getStartingDate()+", "+b.getEndingDate()+", "+b.getConsumptionHours()+", "+b.getConsumptionDays());
            i++;
        }
        Scanner s= new Scanner(System.in);
        int j = s.nextInt()-1;
        //k=1;
        try{
            ConsumableClass b = serieslist.get(j);
            if(b.getEndingDate()!=null){
                return;
            }
            System.out.println("Select which parameter you want to edit");
            System.out.println("1. Edit rating");
            System.out.println("2. ending date");
            System.out.println("3. Add consumption time");
            System.out.println("4. ending date");
            int k = s.nextInt();

            if(k==1){
                System.out.println("Enter rating:");
                Float rating= s.nextFloat();
                serieslist.get(j).setRating(rating);
            }
            if(k==2){
                System.out.println("Enter ending date(yyyy/mm/dd):");
                String endingDate = s.nextLine();
                serieslist.get(j).setEndingDate(endingDate);
            }
            if(k==3){
                System.out.println("Add consumption time:");
                double consumptionTimeInHours = s.nextDouble();
                serieslist.get(j).setConsumptionHours(consumptionTimeInHours);
                totalConsumptionhours+=consumptionTimeInHours;
            }
            if(k==4){
                System.out.println("Add consumption days:");
                int consumptionDays = s.nextInt();
                serieslist.get(j-1).setConsumptionDays(consumptionDays);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        } 
        
    }
    public void deleteBook(){
        System.out.println("Enter the book you want to delete");
        int i=1;
        for (ConsumableClass b:booklist){
            System.out.println(i+". book: "+b.getName()+", "+b.getRating()+", "+b.getStartingDate()+", "+b.getEndingDate()+", "+b.getConsumptionHours()+", "+b.getConsumptionDays());
            i++;
        }
        Scanner s= new Scanner(System.in);
        int j = s.nextInt()-1;
        try{
            booklist.remove(j);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void deleteMovie(){
        System.out.println("Enter the movie you want to delete");
        int i=1;
        for (ConsumableClass b:movielist){
            System.out.println(i+". movie: "+b.getName()+", "+b.getRating()+", "+b.getStartingDate()+", "+b.getEndingDate()+", "+b.getConsumptionHours()+", "+b.getConsumptionDays());
            i++;
        }
        Scanner s= new Scanner(System.in);
        int j = s.nextInt()-1;
        try{
            movielist.remove(j);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void deleteSeries(){
        System.out.println("Enter the series you want to delete");
        int i=1;
        for (ConsumableClass b:serieslist){
            System.out.println(i+". series: "+b.getName()+", "+b.getRating()+", "+b.getStartingDate()+", "+b.getEndingDate()+", "+b.getConsumptionHours()+", "+b.getConsumptionDays());
            i++;
        }
        Scanner s= new Scanner(System.in);
        int j = s.nextInt()-1;
        try{
            serieslist.remove(j);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public double gettotalBooktime(){
        double totalBooktime=0;
        for(ConsumableClass i :booklist){
            totalBooktime+=i.getConsumptionHours();
        }
        return totalBooktime;
    }
    public double gettotalMovietime(){
        double totalmovietime=0;
        for(ConsumableClass i :movielist){
            totalmovietime+=i.getConsumptionHours();
        }
        return totalmovietime;
    }
    public double gettotalSeriestime(){
        double totalseriestime=0;
        for(ConsumableClass i :movielist){
            totalseriestime+=i.getConsumptionHours();
        }
        return totalseriestime;
    }
    public int gettotalBookday(){
        int totalBookday=0;
        for(ConsumableClass i :booklist){
            totalBookday+=i.getConsumptionDays();
        }
        return totalBookday;
    }
    public int gettotalMovieday(){
        int totalMovieday=0;
        for(ConsumableClass i :movielist){
            totalMovieday+=i.getConsumptionDays();
        }
        return totalMovieday;
    }
    public int gettotalseriesday(){
        int totalSeriesday=0;
        for(ConsumableClass i :serieslist){
            totalSeriesday+=i.getConsumptionDays();
        }
        return totalSeriesday;
    }
    public double getAveragerating(ArrayList<ConsumableClass> ConsumableX){
        double avrating=0;
        int counter=0;
        for (ConsumableClass i:ConsumableX){
            avrating+=i.getRating();
            counter++;
        }
        avrating=avrating/counter;
        return avrating;
    }
    public int consumableCounter(ArrayList<ConsumableClass> ConssumableX){
        int counter=0;
        for(ConsumableClass i:ConssumableX){
            counter++;
        }
        return counter;
    }
    public void add(){
        System.out.println("Select consumable you want to add");
        System.out.println("1. Book");
        System.out.println("2. Movies");
        System.out.println("3. series");
        Scanner sc= new Scanner(System.in);
        int j= sc.nextInt();
        if(j==1){
            addBook();
        }
        if(j==2){
            addMovie();
        }
        if(j==3){
            addSeries();
        }
    }
    public void edit(){
        System.out.println("Select consumable type to edit");
        System.out.println("1. Book");
        System.out.println("2. Movies");
        System.out.println("3. series");
        Scanner sc= new Scanner(System.in);
        int j= sc.nextInt();
        if(j==1){
            editBook();
        }
        if(j==2){
            editMovie();
        }
        if(j==3){
            editSeries();
        }

    }
    public double totalRating(ArrayList<ConsumableClass> ConsumableX){
        double totalRate=0;
        for (ConsumableClass i: ConsumableX ){
            totalRate+=i.getRating();
        }
        return totalRate;

    }
    public void viewConsumales(){
        System.out.println("Select type :");
        System.out.println();
        System.out.format("%32s%32s%32s%32s", "Consumable", "Days of consumption","Hours of consumption","Rating" );
        System.out.println();
        System.out.format("%32s%32d%32f%32f", "Books", gettotalBookday(),gettotalBooktime(),totalRating(booklist) );
        System.out.println();
        System.out.format("%32s%32d%32f%32f", "Movies", gettotalMovieday(),gettotalMovietime(),totalRating(movielist) );
        System.out.println();
        System.out.format("%32s%32d%32f%32f", "Series", gettotalseriesday(),gettotalSeriestime(),totalRating(movielist) );
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int j= sc.nextInt();

        if(j==1){
            System.out.format("%32s%32s%32s%32s", "Books", "Days of consumption","Hours of consumption","Rating" );
            System.out.println();
            for (ConsumableClass i:booklist){
                System.out.format("%32s%32s%32s%32s", i.getName(), i.getConsumptionDays(),i.getConsumptionHours(),i.getRating() );
                System.out.println();
            }
        }
        if(j==2){
            System.out.format("%32s%32s%32s%32s", "Movies", "Days of consumption","Hours of consumption","Rating" );
            System.out.println();
            for (ConsumableClass i:movielist){
                System.out.format("%32s%32s%32s%32s", i.getName(), i.getConsumptionDays(),i.getConsumptionHours(),i.getRating() );
                System.out.println();
            }
        }
        if(j==3){
            System.out.format("%32s%32s%32s%32s", "series", "Days of consumption","Hours of consumption","Rating" );
            System.out.println();
            for (ConsumableClass i:serieslist){
                System.out.format("%32s%32s%32s%32s", i.getName(), i.getConsumptionDays(),i.getConsumptionHours(),i.getRating() );
                System.out.println();
            }
        }
    }
    public void overallInfo(){
        System.out.println("1. total consumption time in hours across all types: "+ (gettotalBooktime()+gettotalMovietime()+gettotalSeriestime()));
        System.out.println("2 .total consumption time in hours in book: "+gettotalBooktime()+" total consumption time in hours in movie"+gettotalMovietime()+" total consumption time in hours in series: "+gettotalSeriestime());
        System.out.println("3. The total days of consumption across all types :"+(gettotalBookday()+gettotalMovieday()+gettotalseriesday()));
        System.out.println("4. Individual days of consumption of books "+gettotalBookday() +" Individual days of consumption of movies "+gettotalMovieday()+" Individual days of consumption of series "+gettotalseriesday());
        System.out.println("5. Average rating across all types "+((getAveragerating(booklist)+getAveragerating(movielist)+getAveragerating(serieslist))/3));
        System.out.println("6. Average rating books "+getAveragerating(booklist)+" Average rating movies"+getAveragerating(movielist)+" Average rating across all types"+getAveragerating(serieslist));
        System.out.println("7. Total number of consumable across all types"+(consumableCounter(booklist)+consumableCounter(movielist)+consumableCounter(serieslist)));
        System.out.println("8. Individual number of books"+consumableCounter(booklist)+" Individual number of movies "+ consumableCounter(movielist)+" Individual number of"+consumableCounter(serieslist));

    }


}
