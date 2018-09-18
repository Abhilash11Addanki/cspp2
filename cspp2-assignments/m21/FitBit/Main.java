import java.util.Scanner;
import java.util.ArrayList;
class Food {
    private String foodname;
    private String quantity;
    private String date;
    private String time;
    Food(String f, String q, String d, String t) {
        foodname = f;
        quantity = q;
        date = d;
        time = t;
    }
    String getfoodname() {
        return foodname;
    }
    void setfoodname(String f) {
        foodname = f;
    }
    String getquantity() {
        return quantity;
    }
    void setquantity(String q) {
        quantity = q;
    }
    String getdate() {
        return date;
    }
    void setdate(String d) {
        date = d;
    }
    String gettime() {
        return time;
    }
    void settime(String t) {
        time = t;
    }
}
class Water {
    private String quantity;
    private String date;
    private String time;
    Water(String q, String d, String t) {
        quantity = q;
        date = d;
        time = t;
    }
    String getquantity() {
        return quantity;
    }
    void setquantity(String q) {
        quantity = q;
    }
    String getdate() {
        return date;
    }
    void setdate(String d) {
        date = d;
    }
    String gettime() {
        return time;
    }
    void settime(String t) {
        time = t;
    }
}
class PhysicalActivity {
    private String activityname;
    private String date;
    private String starttime;
    private String endtime;
    private String notes;
    PhysicalActivity(String a, String n, String d, String s, String e) {
        activityname = a;
        notes = n;
        date = d;
        starttime = s;
        endtime = e;
    }
    String getactivityname() {
        return activityname;
    }
    void setactivityname(String name) {
        activityname = name;
    }
    String getnotes() {
        return notes;
    }
    void setnotes(String n) {
        notes = n;
    }
    String getdate() {
        return date;
    }
    void setdate(String d) {
        date = d;
    }
    String getstarttime() {
        return starttime;
    }
    void setstarttime(String s) {
        starttime = s;
    }
    String getendtime() {
        return endtime;
    }
    void setendtime(String e) {
        endtime = e;
    }
}
class Weight {
    private String weight;
    private String fat;
    private String date;
    private String time;
    Weight(String d, String t, String w, String f) {
        date = d;
        time = t;
        weight = w;
        fat = f;
    }
    String getweight() {
        return weight;
    }
    void setweight(String w) {
        weight = w;
    }
    String getfat() {
        return fat;
    }
    void setfat(String f) {
        fat = f;
    }
    String getdate() {
        return date;
    }
    void setdate(String d) {
        date = d;
    }
    String gettime() {
        return time;
    }
    void settime(String t) {
        time = t;
    }
}
class Sleep {
    private String date;
    private String starttime;
    private String endtime;
    Sleep(String d, String s, String e) {
        date = d;
        starttime = s;
        endtime = e;
    }
    String getdate() {
        return date;
    }
    void setdate(String d) {
        date = d;
    }
    String getstarttime() {
        return starttime;
    }
    void setstarttime(String s) {
        starttime = s;
    }
    String getendtime() {
        return endtime;
    }
    void setendtime(String e) {
        endtime = e;
    }
}
class Log {
    private ArrayList<Food> foodlog;
    private ArrayList<Water> waterlog;
    private ArrayList<PhysicalActivity> activitylog;
    private ArrayList<Weight> weightlog;
    private ArrayList<Sleep> sleeplog;
    Log() {
        foodlog = new ArrayList<Food>();
        waterlog = new ArrayList<Water>();
        activitylog = new ArrayList<PhysicalActivity>();
        weightlog = new ArrayList<Weight>();
        sleeplog = new ArrayList<Sleep>();
    }
    void addtofoodlog(final Food food) {
        foodlog.add(food);
    }
    void addtowaterlog(final Water water) {
        waterlog.add(water);
    }
    void addtoactivitylog(final PhysicalActivity activity) {
        activitylog.add(activity);
    }
    void addtoweightlog(final Weight weight) {
        weightlog.add(weight);
    }
    void addtosleeplog(final Sleep sleep) {
        sleeplog.add(sleep);
    }
    void showfoodlog(String date) {
        for (Food food : foodlog) {
            if (food.getdate().equals(date)) {
                System.out.println("Date:" + food.getdate());
                System.out.println("Time:" + food.gettime());
                System.out.println("Name:" + food.getfoodname());
                System.out.println("Quantity:" + food.getquantity());
            }
        }
    }
    void showfoodlog() {
        for (Food food : foodlog) {
            System.out.println("Date:" + food.getdate());
            System.out.println("Time:" + food.gettime());
            System.out.println("Name:" + food.getfoodname());
            System.out.println("Quantity:" + food.getquantity());
        }
    }
    void showwaterlog(String date) {
        for (Water water : waterlog) {
            if (water.getdate().equals(date)) {
                System.out.println("Date:" + water.getdate());
                System.out.println("Quantity:" + water.getquantity() + "ml");
                break;
            }
        }
    }
    void showwaterlog() {
        for (Water water : waterlog) {
            System.out.println("Date:" + water.getdate());
            System.out.println("Quantity:" + water.getquantity() + "ml");
        }
    }
    void showactivitylog(String date) {
        if (activitylog.size() == 0) {
            System.out.println("None");
        } else {
            for (PhysicalActivity activity : activitylog) {
                if (activity.getdate().equals(date)) {
                    System.out.println("Name:" + activity.getactivityname());
                    System.out.println("Notes:" + activity.getnotes());
                    System.out.println("Date:" + activity.getdate());
                    System.out.println("Starttime:" + activity.getstarttime());
                    System.out.println("Endtime:" + activity.getendtime());
                    break;
                }
            }
        }
    }
    void showactivitylog() {
        if (activitylog.size() == 0) {
            System.out.println("None");
        } else {
            for (PhysicalActivity activity : activitylog) {
                System.out.println("Name:" + activity.getactivityname());
                System.out.println("Notes:" + activity.getnotes());
                System.out.println("Date:" + activity.getdate());
                System.out.println("Starttime:" + activity.getstarttime());
                System.out.println("Endtime:" + activity.getendtime());
            }
        }
    }
    void showweightlog(String date) {
        for (Weight weight : weightlog) {
            if (weight.getdate().equals(date)) {
                System.out.println("Date:" + weight.getdate());
                System.out.println("Time:" + weight.gettime());
                System.out.println("Weight:" + weight.getweight());
                System.out.println("Fat:" + weight.getfat());
                break;
            }
        }
    }
    void showweightlog() {
        for (Weight weight : weightlog) {
            System.out.println("Date:" + weight.getdate());
            System.out.println("Time:" + weight.gettime());
            System.out.println("Weight:" + weight.getweight());
            System.out.println("Fat:" + weight.getfat());
        }
    }
    void showsleeplog(String date) {
        for (Sleep sleep : sleeplog) {
            if (sleep.getdate().equals(date)) {
                System.out.println("Date:" + sleep.getdate());
                System.out.println("Starttime:" + sleep.getstarttime());
                System.out.println("Endtime:" + sleep.getendtime());
                break;
            }
        }
    }
    void showsleeplog() {
        for (Sleep sleep : sleeplog) {
            System.out.println("Date:" + sleep.getdate());
            System.out.println("Starttime:" + sleep.getstarttime());
            System.out.println("Endtime:" + sleep.getendtime());
        }
    }
}
final class Main {
    private Main() {

    }
    public static void helper(Log l, String[] str, boolean flag) {
        if (flag) {
            System.out.println("Food");
            l.showfoodlog(str[0]);
            System.out.println();
            System.out.println("Water");
            l.showwaterlog(str[0]);
            System.out.println();
            System.out.println("PhysicalActivity");
            l.showactivitylog(str[0]);
            System.out.println();
            System.out.println("Weight");
            l.showweightlog(str[0]);
            System.out.println();
            System.out.println("Sleep");
            l.showsleeplog(str[0]);
            System.out.println();
        }
        System.out.println("Food");
        l.showfoodlog(str[0]);
        System.out.println("Water");
        l.showwaterlog(str[0]);
        System.out.println("PhysicalActivity");
        l.showactivitylog(str[0]);
        System.out.println("Weight");
        l.showweightlog(str[0]);
        System.out.println("Sleep");
        l.showsleeplog(str[0]);
    }
    public static void main(final String[] args) {
        Log l = new Log();
        Scanner scan = new Scanner(System.in);
        String str[] = new String[0];
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            if (tokens.length == 2) {
                str = tokens[1].split(",");
            }
            switch (tokens[0]) {
            case "Food":
                l.addtofoodlog(new Food(str[0], str[1], str[2], str[3]));
                break;
            case "Water":
                l.addtowaterlog(new Water(str[0], str[1], str[2]));
                break;
            case "PhysicalActivity":
                l.addtoactivitylog(new PhysicalActivity(str[0], str[1], str[2], str[3], str[4]));
                break;
            case "Weight":
                l.addtoweightlog(new Weight(str[0], str[1], str[2], str[3]));
                break;
            case "Sleep":
                l.addtosleeplog(new Sleep(str[0], str[1], str[2]));
                break;
            case "Foodlog":
                System.out.println("Food");
                l.showfoodlog();
                System.out.println();
                break;
            case "Waterlog":
                System.out.println("Water");
                l.showwaterlog();
                System.out.println();
                break;
            case "PhysicalActivitylog":
                System.out.println("PhysicalActivity");
                l.showactivitylog();
                System.out.println();
                break;
            case "Weightlog":
                System.out.println("Weight");
                l.showweightlog();
                System.out.println();
                break;
            case "Sleeplog":
                System.out.println("Sleep");
                l.showsleeplog();
                System.out.println();
                break;
            case "Summary":
                if (str.length == 1) {
                    helper(l, str, true);
                } else {
                    helper(l, str, false);
                }
                break;
            default:
                break;
            }
        }
    }
}

