import java.util.ArrayList;

/**
	
	@author Jacob Lorenzo A. Cano (221303)
	@version December 3, 2022

**/

/*
	I have not discussed the Java language code in my program 
	with anyone other than my instructor or the teaching assistants 
	assigned to this course.

	I have not used Java language code obtained from another student, 
	or any other unauthorized source, either modified or unmodified.

	If any Java language code or documentation used in my program 
	was obtained from another source, such as a textbook or website, 
	that has been clearly noted with a proper citation in the comments 
	of my program.


*/

/*
 
The LifestyleTracker is one of the most code-heavy files in this folder; it is mainly responsible for recording, editing the food list, food eaten list, activities list, and activities performed list.
Also, most, if not all, computations can be found here. Other values along with this is feedbacked to other java files by displaying specific messages or prompts. 

Here are the list of the methods used and a brief description of what they do individually (and collectively):


1. public LifestyleTracker(){} - initialize variables
2. public ArrayList<ArrayList<String>> checkArray_foodlist() - return value of Array of Food List (for updating the other java files)
3. public ArrayList<ArrayList<String>> checkArray_activities(){} - return value of Array of Activities List (for updating the other java files)
4  public ArrayList<ArrayList<String>> checkArray_foodate(){}  - return value of Array of Food Eaten  List (for updating the other java files)
5. public ArrayList<ArrayList<String>> checkArray_activities_done(){} - return value of Array of Activities Performed  List (for updating the other java files)
6. public String edit_data_foodate(String indexx){} - checks if index is present among the Array
7. public void edit_data_foodate_edit(int index, double servings, String name){} 
    > if food name is within food list, it will only update servings.
    > if food name is not within food list, it will ask for calories and servings (it will add food to the list then update it)
8. edit_data_activitiesdone(String ind){} -  checks if index is present among the Array
9. public String edit_data_activitiesdone_edit(int index, double hours, String override, String name){ - > if activity name is within activity list, it will only update servings.
    > if activity name is not within food list, it will ask for calories and servings (it will add food to the list then update it)
10.public void updater_food_ate(String foodname, int index, double new_calories){} - updates the food ate list/array
11. public void updater_activities_done(String activityname, int index, double new_calories){} - updates the activities performed list/array
12.  public void foodate_remover(int _index){} - removes row of food eaten
13.  public void activities_done_remover (int _index_){} - removes specific row of activities performed. 
14.  public static String capitalize(String str) {} -- capitalizes string (makes first character uppercase, while the rest is lowercase) -- some uses this method, some uses .substring() // same functionality technically.
15. public String edit_report_activities_done(){} -- shows table of activities done.
15. public String edit_report_foodate(){} -- shows table of food eaten.

New Methods
16. public String height_recorder(String feets, String inchess){} -- record height of user through mystery mode.
17. public void bmi_calculator(double weight_, double feets, double inchess){} -- calculate BMI of user given weight and height 
18. public String bmr_calculator(double curr_weight,String genders, double feetz, double inchesz, int agez){} - calculates BMR of user given current weight, gender, height, and age.
19. public String weightgoal_checker(String type, double current_weight, double weight_goal){} -- checks if weight goal is either GAIN or LOSE, also checks (if GAIN, target weight must not be lower than current weight), same goes with LOSE.
20. public void activity_level(){} -- analyzes activities performed list and see its corresponding activity level.
21. public String time_converter(String type, double time){} - converts time period goal to unit weeks to fit into the calculations and formula
22.  public void trio_calorie_calculator(){} -- calculates three components
	> Calories needed to sustain weight
	> Calories needed to gain weight
	> Calories needed to lose weight
23. public void bmichecker_max(){} & bmichecker_min(){ checks if person losing weight is gonna lose weight that is considered "underweight". If so, it will display a message;
24.  public String mystery_report(){} - prints mystery report
25. Public String mystery_report_(){} - prints mystery report for the GUI because of difference 

Requisite Methods:
26.public String addFood( String n, double c ){} -- will add food with its corresponding calories per serving in an arraylist. If input already is included in list, it will update the calorie value.
27. public String addActivity( String n, double c ){} - -- will add activity with its corresponding calories burned per hour in an ArrayList. If input already is included in list, it will update the calorie value.
28.public String eat( String foodName, double servings ){}
	> Checks if servings is negative
	> Checks if food exists in list of food
	> If not existing, it will tell user if he or she or they wants to add it to existing food 	list
	> Add to lists of food ate.
29. public String perform( String actName, double hours, String override){}
	> Checks if hours is negative or 0
	> Checks if add/edit activity is going to be beyond 24.00 hrs (because of the instruction "recorded activities for the day" -- but can be override)
	> Add to lists of activities perfromed

30. report() -- prints report







 */
public class LifestyleTracker {


    /*
     
BMR : CALORIES THAT THE PERSON NEEDS IN A DAY (the Harris Benedict Equation which is:)
- - BMR = 66.47 + (13.75 * weight in kg) + (5.003 * height in cm) - (6.755 * age in years)
- BMR = 655.1 + (9.563 * weight in kg) + (1.85 * height in cm) - (4.676 * age in years)

* When a person has little to no exercise (1.2), he or she is said to be in the Sedentary Activity Level
* When a person has light exercise or light sports at least one to three times per week (1.375), he or she is said to be in the Slightly Activity Level
* When a person has a moderate amount of exercises or sports three to five times per week (1.55), he or she is said to be in the Moderately Activity Level
* When a person does hard exercises or sports six to seven times per week (1.725), he or she is said to be in the Very Activity Level
* When a person does rigorous exercises or sports or physical training (1.9), he or she is said to be in the Extra Activity Level

Physical Activity and Controlling Weight. (n.d.). https://www.k-state.edu/paccats/Contents/PA/PDF/Physical%20Activity%20and%20Controlling%20Weight.pdf
https://help.carbmanager.com/docs/update-your-activity-level

Oracle (2020). Class DefaultTableModel. https://docs.oracle.com/javase/7/docs/api/javax/swing/table/DefaultTableModel.html

ICliniq.(2022). Weight Loss by Target Date Calculator. https://www.icliniq.com/tool/weight-loss-by-goal-date-calculator

Gaba, A., et al. (2008). Harris-Benedict equation estimations of energy needs as compared to measured 24-h energy expenditure by indirect calorimetry in people with early to mid-stage Huntington's disease. Nutritional neuroscience. 11. 213-8. 10.1179/147683008X344129.  https://www.researchgate.net/publication/23248180_Harris-Benedict_equation_estimations_of_energy_needs_as_compared_to_measured_24-h_energy_expenditure_by_indirect_calorimetry_in_people_with_early_to_mid-stage_Huntington's_disease/citation/download

Example usage for javax.swing.table DefaultTableModel fireTableDataChanged. (2016). Example usage for javax.swing.table DefaultTableModel fireTableDataChanged. http://www.java2s.com/example/java-api/javax/swing/table/defaulttablemodel/firetabledatachanged-0-1.html

George, J.(2019). How to set a value in a particular JTable cell with Java? https://www.tutorialspoint.com/how-to-set-a-value-in-a-particular-jtable-cell-with-java

2D Array List in Java. (2022). https://iq.opengenus.org/2d-array-list-java/

Atta. (2022). Capitalize the first letter of a string in Java. https://attacomsian.com/blog/capitalize-first-letter-of-string-java

Java - Populate JTable From ArrayList In Java. (2016). https://1bestcsharp.blogspot.com/2016/03/java-populate-jtable-from-arraylist.html

How to use getModelmethod in javax.swing.JTable. (n.d.). https://www.tabnine.com/code/java/methods/javax.swing.JTable/getModel

McKenzie, C. (2022). User input with a Java JOptionPane example. https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-user-input-with-a-Swing-JOptionPane-example
     */

    private ArrayList<ArrayList<String>> food_calorie;
    private ArrayList<ArrayList<String>> activities;

    private ArrayList<ArrayList<String>> food_ate;
    private ArrayList<ArrayList<String>> activities_done;

    private int checker;
    private String message;
    private String report_message;
    private String edit_message;

    private double weight;
    private double weightgoal;

    private int feet;
    private int inches;
    private int age;
    private String gender;
    private String weight_checker_message;
    double total_calories_consumed;
        double total_calories_burned ;
        double net_calories;
        double kg_calorie_converter;


    private String activity_level;
    private Double activity_level_value;
    private String activity_level_description;
    private double bmi;
    private double bmi_computed;
    private String converter;
    private double convert_again;
    private double time_total; // time total for activities

    private String bmr; // 
    private double bmr_computed;
    String bmi_label;
   
    private String weight_goal_type;
    private double calorie_to_sustain;
    private double calorie_to_lose;
    private double calorie_to_gain;
    private double calorie_to_reach_goal;
    private double time_to_reach_goal;
    public String time_type;

    public double intersect_calories;

    Double bmichecker_max;
    Double bmichecker_min;



    // private String[] list_of_commands;



    private Activity transfer;


    public LifestyleTracker(){

       food_calorie = new ArrayList<ArrayList<String>>();
       activities = new ArrayList<ArrayList<String>>();
       food_ate = new ArrayList<ArrayList<String>>();
       activities_done = new ArrayList<ArrayList<String>>();

       // list_of_commands = new String[6];
       activity_level_value = 0.00;
       calorie_to_sustain = 0;
       calorie_to_lose = 0;
       calorie_to_gain = 0;
       calorie_to_reach_goal = 0;
       time_to_reach_goal = 0.00;

       
       report_message = "";
       checker = 1;

       // NOTE: A week denotes 7 days. 
       // A month denotes 30 days. 1 kcal = 0.00012959782 kg
    }

    // =-=-=-=-=-=-=-=-=- NEW METHODS =-=-=-=-=-=-=-=-=- //

    public ArrayList<ArrayList<String>> checkArray_foodlist(){

        return food_calorie;
    }

    public ArrayList<ArrayList<String>> checkArray_activities(){

        return activities;
    }
    

    public ArrayList<ArrayList<String>> checkArray_foodate(){

        return food_ate;
    }

    public ArrayList<ArrayList<String>> checkArray_activities_done(){

        return activities_done;
    }

    public String edit_data_foodate(String indexx){

        if (indexx.equals("back")){
           return "back";
        }
        else{
            int indexs = Integer.parseInt(indexx);
            //  Range<Integer> myRange = Range.between(100, 500);
              int min = 0;
              int max = food_ate.size()-1;
      
        
              if (indexs >= min && indexs <= max){
                  
      
              return "Congrats the index is found.";
      
              }
              else{
              return "Specified index not found.";
              }
        }
       

    }

    public void edit_data_foodate_edit(int index, double servings, String name){

     

        //  Range<Integer> myRange = Range.between(100, 500);
          int min = 0;
          int max = food_ate.size()-1;
//          double total_calories = ((Double.valueOf(food_calorie.get(i).get(1))/100) * (servings*100));

        checkArray_foodlist();


        for(int i = 0; i <  checkArray_foodlist().size(); i++){

            if(checkArray_foodlist().get(i).contains(food_ate.get(index).get(0))){
            food_ate.get(index).set(0, name);
            food_ate.get(index).set(1, String.format("%.2f", servings));
            food_ate.get(index).set(2, String.format("%.2f", (Double.valueOf(food_calorie.get(i).get(1))/100) * (servings*100) ));
            }

        }

        
          System.out.println("Successfully updated!");
  

         
  
      }


      public String edit_data_activitiesdone(String ind){

        if (ind.equals("back")){
           return "back";
        }
        else{
            int indexs = Integer.parseInt(ind);
            //  Range<Integer> myRange = Range.between(100, 500);
              int min = 0;
              int max = activities_done.size()-1;
      
        
              if (indexs >= min && indexs <= max){
                  
      
              return "Congrats the index is found.";
      
              }
              else{
              return "Specified index not found.";
              }
        }

      

    }

    public String edit_data_activitiesdone_edit(int index, double hours, String override, String name){

        String messagez = "";
        double time = 0.00;

        checkArray_activities();


        for(int i = 0; i < activities_done.size(); i++){

            time += Double.parseDouble(activities_done.get(i).get(1));
        }

        if((hours + (time - Double.parseDouble(activities_done.get(index).get(1)))) > 24.00 && override.equalsIgnoreCase("No") ){ // check if new value is within 24 hr limit
            messagez = "Cannot further perform/add/edit this activity. Activities recorded are only for the day, meaning there can only be 24 hrs worth of activity max. Do you want to override it (Y/N)?";
            
            System.out.println(messagez);
            return messagez;
            

        } else{
        

             //  Range<Integer> myRange = Range.between(100, 500);
          int min = 0;
          int max = activities_done.size()-1;
          String hours_ = String.format("%.2f",hours);
//          double calorie = (Double.parseDouble(activities.get(i).get(1))/60) * (hours * 60) ; // gets from list of activities 

        for(int i = 0; i < checkArray_activities().size(); i++){


            if(checkArray_activities().get(i).contains(activities_done.get(index).get(0))){
                activities_done.get(index).set(0, name);
                activities_done.get(index).set(1, String.format("%.2f", hours));
                activities_done.get(index).set(2, String.format("%.2f", Double.parseDouble(activities.get(i).get(1))/60 * (Double.parseDouble(hours_) * 60) ));
            }  // Activity = (given hour * 60) * (calories / 60)


        }

        
          System.out.println("Successfully updated!");
  
  
    }
    return messagez;

    }

    public void updater_food_ate(String foodname, int index, double new_calories){

        int updater =0;
        for(int i = 0; i < food_calorie.size(); i++){

            if(food_calorie.get(i).contains(foodname)){ // "Watermelon"
        
             updater = i;
              
            }


        }

        for(int j = 0; j < food_ate.size(); j++){ 

            if(food_ate.get(j).get(0).contains(foodname)){
                
                double calorie = Double.parseDouble((food_calorie.get(updater).get(1) ) ) * Double.parseDouble(food_ate.get(j).get(1)); 
                food_ate.get(j).set(2,String.format("%.2f",calorie) );

                //                food_ate.get(j).set(2, String.format("%2.f",Double.parseDouble(food_calorie.get(updater).get(1))* Double.parseDouble(food_ate.get(j).get(1))));

            }

        }

    }

    public void updater_activities_done(String activityname, int index, double new_calories){

        int updater = 0;
        for(int i = 0 ; i < activities.size(); i++){

            if(activities.get(i).contains(activityname)){

                updater = i;
            }
        }

        for(int j = 0; j < activities_done.size(); j++){

            if(activities_done.get(j).get(0).contains(activityname)){

                double calorie_burned = (Double.parseDouble((activities.get(updater).get(1)))/ 60) * (Double.parseDouble(activities_done.get(j).get(1)) * 60);

                activities_done.get(j).set(2,String.format("%.2f",calorie_burned) );

                // Activity = (given hour * 60) * (calories / 60)

            }
        }
    }
   
    public void foodate_remover(int _index){

        food_ate.remove(_index);
        System.out.println("Successfully removed!");

    } 

    public void activities_done_remover (int _index_){

        activities_done.remove(_index_);
        System.out.println("Successfully removed!");

    }

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
    
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }


    public String edit_report_activities_done(){
        checkArray_foodate();
        checkArray_activities_done();
        edit_message = "";


        edit_message += String.format("-=-=-=-=-= List of Activities Done =-=-=-=-=-\n");
        edit_message += String.format("|  # |    Activity  |  Time(hr)  |  Cal. B  |\n");
        
        for (int i = 0; i < activities_done.size(); i++){

           edit_message += String.format("| %2d | %12s | %10s | %8s | \n", i, activities_done.get(i).get(0), activities_done.get(i).get(1) , activities_done.get(i).get(2));


        }
        edit_message += String.format("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        /*  System.out.println("-=-=-=-=-= List of Activities Done =-=-=-=-=-");
                        System.out.println("|  # |    Activity  |  Time(hr)  |    Cal. B  |");


                        for (int i = 0; i < list_activities_done.size(); i ++){
                            System.out.printf("| %2d | %12s | %10s | %8s | \n", i, list_activities_done.get(i).get(0), list_activities_done.get(i).get(1) , list_activities_done.get(i).get(2));
    
                        }
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
 */

        return edit_message;



    }

    public String edit_report_foodate(){
        checkArray_foodate();
        checkArray_activities_done();


        edit_message = "";


        edit_message += String.format("-=-=-=-=-= List of Food Ate =-=-=-=-=-\n");

        edit_message += String.format("|  # |  FoodName | Servings | Cal. C |\n");

        for (int i = 0; i < food_ate.size(); i ++){
            edit_message += String.format("| %2d | %9s | %8s | %6s | \n", i, food_ate.get(i).get(0), food_ate.get(i).get(1) , food_ate.get(i).get(2));

        }
        edit_message += String.format("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

       /*  System.out.println("-=-=-=-=-= List of Food Ate =-=-=-=-=-");
        System.out.println("|  # |  FoodName | Servings | Cal. C |");

        for (int i = 0; i < list_food_ate.size(); i ++){
            System.out.printf("| %2d | %9s | %8s | %6s | \n", i, list_food_ate.get(i).get(0), list_food_ate.get(i).get(1) , list_food_ate.get(i).get(2));

        }

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
*/
        return edit_message;

    }

      // =-=-=-=-=-=-=-=-=- NEW METHODS P2 =-=-=-=-=-=-=-=-=- //


  
        public String height_recorder(String feets, String inchess){
            feet = Integer.parseInt(feets);
            inches = Integer.parseInt(inchess);
            
            return "";
        }

        public void bmi_calculator(double weight_, double feets, double inchess){


             bmi_computed = (weight_) / Math.pow(((feets + inchess)), 2) ;

             converter = String.format("%.4f", bmi_computed);
             convert_again = Double.parseDouble(converter);

            if(convert_again < 18.500){
               
                bmi_label = "Underweight";
               
        
            }
            else if(convert_again > 18.500 && convert_again <= 24.999){
                
                bmi_label = "Normal";
               
        
            }
            else if(convert_again > 24.999 && convert_again <= 29.999){
               
                bmi_label = "Overweight";
               
        
            } 
            else if(convert_again > 29.999 && convert_again <= 34.999){
                
                bmi_label = "Obese";
                
        
            } 
            else if(convert_again > 34.999){
               
                bmi_label = "OVERLY OBESE";
                
        
            } 

           
        }

        public String bmr_calculator(double curr_weight,String genders, double feetz, double inchesz, int agez){

          //  private double bmr; // 
          //  private double bmr_computed;
            if(genders.equalsIgnoreCase("M")){
                gender = "Male";
                age = agez;
                bmr_computed = (66.47 + (13.75 * (curr_weight)) + (5.003 * ((feetz + inchesz) * 100)) - (6.755 * agez)) ;
            }
            else{
                gender = "Female";
                age = agez;
                bmr_computed =  655.1 + (9.563 * (curr_weight)) + (1.85 * ((feetz + inchesz) * 100)) - (4.676 * agez);



            }
// - - BMR = 66.47 + (13.75 * weight in kg) + (5.003 * height in cm) - (6.755 * age in years) M
// BMR = 655.1 + (9.563 * weight in kg) + (1.85 * height in cm) - (4.676 * age in years)


            return "";
        }

       
        public String weightgoal_checker(String type, double current_weight, double weight_goal){
            weight_checker_message = "";
            if(type.equals("Gain")){
                if(weight_goal <= current_weight){
                    weight_checker_message = "Your weight goal must be MORE than your current weight";
                    return weight_checker_message;
                }
                else{
                    weight = current_weight;
                    weightgoal = weight_goal;
                    weight_goal_type = type;

                    return "success";
                }
            }
            else if(type.equals("Lose")){
                if(weight_goal >= current_weight){
                    weight_checker_message = "Your weight goal must be LESS than your current weight";
                    
                    return weight_checker_message;
                }
                else{
                    weight = current_weight;
                    weightgoal = weight_goal;
                    weight_goal_type = type;

                    return "success";
                }
            }
            else{
                weight_checker_message = "Invalid input";
            }


            return weight_checker_message;
        }

        public void activity_level(){

             
            checkArray_activities_done();

        activity_level_value = 0.00;

           for(int i = 0; i < activities_done.size(); i++){
            time_total += Double.parseDouble(activities_done.get(i).get(1));
         }
            

            if(time_total < 0.50 ){
                activity_level = "Sedentary Active";
                activity_level_description = "Sedentary Active; you don't engage in highly energy-consuming tasks. ";
                activity_level_value = 1.2;


            }
            else if(time_total > 0.50 && time_total <= 1 ){
                activity_level = "Slightly Active";
                activity_level_description = "Slightly Active; you perform physical exercises for more than 30 mins. but less than 1 hr. per day. ";

                activity_level_value = 1.375;



            }
            else if(time_total > 1 && time_total <= 1.50  ){
                activity_level = "Moderate Active";
                activity_level_description = "Moderately Active; you perform physical tasks for more than an hour but less than 1 hr and 30 mins per day. ";

                activity_level_value = 1.55;


            }
            else if(time_total > 1.50 && time_total <= 2  ){
                activity_level = " Very Active";
                activity_level_description = "Very Active; you perform physically demanding tasks for more than an hour and 30 minutes but less than 2 hours per day. ";
                activity_level_value = 1.725;

            }
            else if(time_total > 2  ){
                activity_level = "Extra V. Active";
                activity_level_description = "Extra Very Active; you perform physically demanding tasks for more than 2 hours a day.  ";

                activity_level_value = 1.900;

            }

        }
        public String time_converter(String type, double time){

            String msg = "";
            // convert in weeks
            if(type.equalsIgnoreCase("Weeks")){
                time_to_reach_goal = time;
                time_type = "Weeks";
                msg = "Success";

            }
            else if(type.equalsIgnoreCase("Days") || type.equalsIgnoreCase("Day")){
                time_to_reach_goal = time / 7;
                time_type = "Weeks";
                msg = "Success";


            }
            else if(type.equalsIgnoreCase("Months") || type.equalsIgnoreCase("Month")){
                time_to_reach_goal = time * 4.345;
                time_type = "Weeks";
                msg = "Success";

            }
            else{
                msg = "Invalid Input";
                return msg;
            }
            return msg;


        }

      

        public void trio_calorie_calculator(){

            
            calorie_to_sustain = bmr_computed * activity_level_value;

            if(weight_goal_type.equalsIgnoreCase("Gain")){
            calorie_to_gain = (weightgoal - weight) * (1100/time_to_reach_goal);
            calorie_to_reach_goal = calorie_to_sustain + calorie_to_gain;
            }
            if(weight_goal_type.equalsIgnoreCase("Lose")){
            calorie_to_lose = (weight - weightgoal) * (1100/time_to_reach_goal);
            calorie_to_reach_goal = calorie_to_sustain - calorie_to_lose;
            }


            //Calories to sustain weight = Basal Metabolic Rate * Activity Level

            /*
             
            If you aim at losing weight,
You can use the below formula to find the required calories for losing your weight

Calories for losing weight = (weight in kg - target weight in kg) * (1100 / goal date in weeks)
Required calories to achieve the target weight = calories to sustain weight - calories for losing weight
             */

             /* 
              
If you aim at gaining weight,
For a weight gain of 2.2 pounds or one kilogram in a week one will need 1100 calories. You can use the below formula to find the required calories for gaining your weight.

Calories for gaining weight = (target weight in kg - weight in kg) * (1100 / goal date in weeks)
Required calories to achieve the target weight = calories to sustain weight + calories for gaining weight

              */

        }
/* 
 * When a person has little to no exercise (1.2), he or she is said to be in the Sedentary Activity Level
* When a person has light exercise or light sports at least one to three times per week (1.375), he or she is said to be in the Slightly Activity Level
* When a person has a moderate amount of exercises or sports three to five times per week (1.55), he or she is said to be in the Moderately Activity Level
* When a person does hard exercises or sports six to seven times per week (1.725), he or she is said to be in the Very Activity Level
* When a person does rigorous exercises or sports or physical training (1.9), he or she is said to be in the Extra Activity Level

Sedentary — You work a desk job with little or no exercise.
Lightly Active — You work a job with light physical demands, or you work a desk job and perform light exercise (at the level of a brisk walk) for 30 minutes per day, 3-5 times per week.
Moderately Active — You work a moderately physically demanding job, such as a construction worker, or you work a desk job and engage in moderate exercise for 1 hour per day, 3-5 times per week.
Very Active — You work a consistently physically demanding job, such as an agricultural worker, or you work a desk job and engage in intense exercise for 1 hour per day or moderate exercise for 2 hours per day, 5-7 times per week.
Extra Active — You work an extremely physically demanding job, such as a professional athlete, competitive cyclist, or fitness professional, or you engage in intense exercise for at least 2 hours per day.

private double feet;
    private double inches;
    private int age;
    private String gender;
    private String weight_checker_message;

    private String activity_level;
    private Double activity_level_value;
    private double bmi;
    private double bmi_computed;
    private String converter;
    private double convert_again;

       private String weight_goal_type;
    private double calorie_to_sustain = 0;
    private double calorie_to_lose = 0;
    private double calorie_to_gain = 0;
    private double calorie_to_reach_goal = 0;
    private double time_to_reach_goal = 0.00;
 */

public void bmichecker_max(){
    
    double x = 24.999 * Math.pow(((feet/ 3.281)+(inches/39.37)),2);
    bmichecker_max =x;
    

  }

  public void bmichecker_min(){
    
    double y = 18.500 * Math.pow((feet/ 3.281)+(inches/39.37),2);
    bmichecker_min = y;

  
  }
        public String mystery_report(){

            //need mag update ng TOTAL CALORIES....
            trio_calorie_calculator();
            bmichecker_max();
            bmichecker_min();
            activity_level();

            for(int i = 0; i < food_ate.size(); i ++){

                total_calories_consumed += Double.parseDouble(food_ate.get(i).get(2));
                report_message += String.format("%4s serving(s) of %2s, %4s kcal \n", food_ate.get(i).get(1), food_ate.get(i).get(0), food_ate.get(i).get(2));
        
            }

            String mystery_message = "\n";

            mystery_message += String.format("-=-=-=-=-=-=-=-> Fitness Report <-=-=-=-=-=-=-\n");

            mystery_message += String.format("| Gender:                 | %6s           |\n", gender);
            mystery_message += String.format("| Age:                    | %5s            |\n", age);
            mystery_message += String.format("| Height:                 | %3s ft. %2s in.   |\n", feet, inches);
            mystery_message += String.format("| Weight:                 | %7.2f kg.      |\n", weight);
            mystery_message += String.format("| Weight Goal Type:       | %4s             |\n", weight_goal_type );
            mystery_message += String.format("| Target Weight:          | %7.2f kg.      |\n", weightgoal);
            mystery_message += String.format("| Time Period:            | %6.2f %5s     |\n", time_to_reach_goal, time_type );
            mystery_message += String.format("| Activity Level:         | %16s |\n", activity_level );
            mystery_message += String.format("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-\n");

            mystery_message += String.format("| Body Mass Index:        | %8.2f         |\n", bmi_computed ); //bmi label
            mystery_message += String.format("| Basal Metabolic Rate:   | %8.2f         |\n", bmr_computed );
            mystery_message += String.format("| Cal. to sustain weight: | %8.2f         |\n", calorie_to_sustain );

            if(calorie_to_reach_goal >= 0){
                mystery_message += String.format("| Cal. to target weight:  | %8.2f         |\n", calorie_to_reach_goal );

            }
            else{
                mystery_message += String.format("| Cal. to target weight:  | %8s         |\n", "*Unsafe" );
                

            }

            if(weight_goal_type.equalsIgnoreCase("gain")){
                mystery_message += String.format("| Cal. to gain weight:    | %8.2f         |\n", calorie_to_gain);

            }
            else{
                
                if(calorie_to_reach_goal < 0){
                    mystery_message += String.format("| Cal. to lose weight:    | %8s         |\n", "*Unsafe");

                }
                else{
                    mystery_message += String.format("| Cal. to lose weight:    | %8.2f         |\n", calorie_to_lose);

                }

            }
            mystery_message += String.format("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-\n");
            report();
            mystery_message += String.format("|*|*|*|*|*|*|*|*|*|*|*|*|*|\n");
            mystery_message += String.format("|  Interpretated Results: | \n");
            mystery_message += String.format("|*|*|*|*|*|*|*|*|*|*|*|*|*|\n");



            mystery_message += String.format(" > Given your BMI, you are classified as %1s  \n", bmi_label);
            if(bmi_label.equalsIgnoreCase("Underweight") && weight_goal_type.equals("Lose")){
                mystery_message += String.format(" > Since you are trying to lose weight but your current BMI is less than normal, we might suggest you to try gaining weight to ranges between %5.2f and %5.2f kg. (normal ranges). Losing more weight might put you at some health risks. \n", bmichecker_min, bmichecker_max);

            }
            mystery_message += String.format(" > Calories needed to sustain your current weight are approx. %6.2f calories per day. \n", calorie_to_sustain);

            if(calorie_to_reach_goal >= 0){

                mystery_message += String.format(" > Calories needed to acheive your target weight are approx. %6.2f calories per day. \n", calorie_to_reach_goal);

            }
            else{
                mystery_message += String.format(" > The entered weight and time goal result in an unsafe level of calorie changes.. Please either increase the time goal, or reduce the change in weight goal. \n");

                //The entered pounds and time goal result in an unsafe level of calorie changes.
            }

            if(weight_goal_type.equalsIgnoreCase("gain")){
                mystery_message += String.format(" > This means you need to consume an extra %6.2f calories per day.\n", calorie_to_gain);

            }
            else{
                if(calorie_to_reach_goal < 0){

                }
                else{
                 mystery_message += String.format(" > The additional %6.2f calories are needed to be burned. This can be achieved by a reduction in daily calorie intake or by slightly increasing your activity level \n", calorie_to_lose);


                }

            }

            intersect_calories = calorie_to_reach_goal - total_calories_consumed;

            mystery_message += String.format(" ------------------- >>  \n");

            mystery_message += String.format(" Looking at your recorded data... \n");
            mystery_message += String.format(" ------------------- >>  \n");

            mystery_message += String.format(" > Assuming most activities recorded are physical activities/exercises, your activity lifestyle is %20s \n", activity_level_description);

            if(weight_goal_type.equalsIgnoreCase("gain")){

                if(total_calories_consumed > calorie_to_reach_goal){
                    mystery_message += String.format(" > Based on your recorded daily food intake, it seems that you have superceeded the daily required calories to reach the target weight. Might we suggest reducing your total daily calories by %4.2f calories  \n", Math.abs(intersect_calories) );
                }
                else{
                    mystery_message += String.format(" > Based on your recorded daily food intake, you would still need to consume %4.2f calories more (daily) to acheive your target weight. Eat more food pls. \n", intersect_calories);

                }

            }

            else{

                if(total_calories_consumed > calorie_to_reach_goal){
                    if(calorie_to_reach_goal < 0){
                        mystery_message += String.format(" > Based on your recorded daily food intake, you would only need to consume %4.2f calories less (daily) to achieve your target weight. However, this is within unsafe levels of changes. It is advisable to extend the time duration or revise your goals. \n", Math.abs(intersect_calories));

                    }
                    else{
                        mystery_message += String.format(" > Based on your recorded daily food intake, you would only need to consume %4.2f calories less (daily) to achieve your target weight \n", Math.abs(intersect_calories));

                    }

                }
                else{
                    mystery_message += String.format(" > Based on your recorded daily food intake, you would only need to consume %4.2f calories more (daily) to achieve your target weight \n", intersect_calories);

                }
            }



// interpretation, 
//Calories needed to sustain your current weight are 2020 calories per day.
// Calories needed to achieve your target weight are 1420 calories per day.
// The additional 600 calories are needed to be burned. This can be achieved by a reduction in daily calorie intake or by slightly increasing your activity level
// based on your recorded food intake, you would still need to consume ____ calories worth of foods more per day
// based on your recorded activity list, 

            return mystery_message;
        }
  


        public String mystery_report_(){


 //need mag update ng TOTAL CALORIES....
 trio_calorie_calculator();
 bmichecker_max();
 bmichecker_min();
 activity_level();

 for(int i = 0; i < food_ate.size(); i ++){

     total_calories_consumed += Double.parseDouble(food_ate.get(i).get(2));
     report_message += String.format("%4s serving(s) of %2s, %4s kcal \n", food_ate.get(i).get(1), food_ate.get(i).get(0), food_ate.get(i).get(2));

 }

 String mystery_message = "\n";

 mystery_message += String.format("-=-=-=-=-=-> Fitness Report <-=-=-==-=-=-\n");

 mystery_message += String.format("| Gender:                       | %6s           \n", gender);
 mystery_message += String.format("| Age:                            | %5s            \n", age);
 mystery_message += String.format("| Height:                        | %3s ft. %2s in.   \n", feet, inches);
 mystery_message += String.format("| Weight:                        | %7.2f kg.      \n", weight);
 mystery_message += String.format("| Weight Goal Type:        | %4s             \n", weight_goal_type );
 mystery_message += String.format("| Target Weight:             | %7.2f kg.      \n", weightgoal);
 mystery_message += String.format("| Time Period:                 | %6.2f %5s     \n", time_to_reach_goal, time_type );
 mystery_message += String.format("| Activity Level:              | %16s \n", activity_level );
 mystery_message += String.format("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

 mystery_message += String.format("| Body Mass Index:         | %8.2f         \n", bmi_computed ); //bmi label
 mystery_message += String.format("| Basal Metabolic Rate:   | %8.2f         \n", bmr_computed );
 mystery_message += String.format("| Cal. to sustain weight: | %8.2f         \n", calorie_to_sustain );

 if(calorie_to_reach_goal >= 0){
     mystery_message += String.format("| Cal. to target weight:   | %8.2f         \n", calorie_to_reach_goal );

 }
 else{
     mystery_message += String.format("| Cal. to target weight:   | %8s         \n", "*Unsafe" );
     

 }

 if(weight_goal_type.equalsIgnoreCase("gain")){
     mystery_message += String.format("| Cal. to gain weight:      | %8.2f         \n", calorie_to_gain);

 }
 else{
     
     if(calorie_to_reach_goal < 0){
         mystery_message += String.format("| Cal. to lose weight:     | %8s         \n", "*Unsafe");

     }
     else{
         mystery_message += String.format("| Cal. to lose weight:     | %8.2f         \n", calorie_to_lose);

     }

 }
 mystery_message += String.format("|Daily Water Intake:        | %8.2f  cups \n ", (((weight * 2.204)*2/3) +  ((time_total * 60)*6/15))/8);
 mystery_message += String.format("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
 report();
 mystery_message += String.format("\n");
 mystery_message += String.format("-=-| Interpretated Results |-=-=-=-=--=-=-=-\n");
 mystery_message += String.format("\n");



 mystery_message += String.format(" > Given your BMI, you are classified as %1s  \n", bmi_label);
 if(bmi_label.equalsIgnoreCase("Underweight") && weight_goal_type.equals("Lose")){
     mystery_message += String.format(" > Since you are trying to lose weight but your current BMI is less than normal, we might suggest you to try gaining weight to ranges between %5.2f and %5.2f kg. (normal ranges). Losing more weight might put you at some health risks. \n", bmichecker_min, bmichecker_max);

 }
 mystery_message += String.format(" > Calories needed to sustain your current weight are approx. %6.2f calories per day. \n", calorie_to_sustain);

 if(calorie_to_reach_goal >= 0){

     mystery_message += String.format(" > Calories needed to acheive your target weight are approx. %6.2f calories per day. \n", calorie_to_reach_goal);

 }
 else{
     mystery_message += String.format(" > The entered weight and time goal result in an unsafe level of calorie changes.. Please either increase the time goal, or reduce the change in weight goal. \n");

     //The entered pounds and time goal result in an unsafe level of calorie changes.
 }

 if(weight_goal_type.equalsIgnoreCase("gain")){
     mystery_message += String.format(" > This means you need to consume an extra %6.2f calories per day.\n", calorie_to_gain);

 }
 else{
     if(calorie_to_reach_goal < 0){

     }
     else{
      mystery_message += String.format(" > The additional %6.2f calories are needed to be burned. This can be achieved by a reduction in daily calorie intake or by slightly increasing your activity level \n", calorie_to_lose);


     }

 }

 intersect_calories = calorie_to_reach_goal - total_calories_consumed;

 mystery_message += String.format("---------------------------------------\n");

 mystery_message += String.format(" Looking at your recorded data... \n");
 mystery_message += String.format("---------------------------------------  \n");

 mystery_message += String.format(" > Assuming most activities recorded are physical activities/exercises, your activity lifestyle is %20s \n", activity_level_description);

 if(weight_goal_type.equalsIgnoreCase("gain")){

     if(total_calories_consumed > calorie_to_reach_goal){
         mystery_message += String.format(" > Based on your recorded daily food intake, it seems that you have superceeded the daily required calories to reach the target weight. Might we suggest reducing your total daily calories by %4.2f calories  \n", Math.abs(intersect_calories) );
     }
     else{
         mystery_message += String.format(" > Based on your recorded daily food intake, you would still need to consume %4.2f calories more (daily) to acheive your target weight. Eat more food pls. \n", intersect_calories);

     }

 }

 else{

     if(total_calories_consumed > calorie_to_reach_goal){
         if(calorie_to_reach_goal < 0){
             mystery_message += String.format(" > Based on your recorded daily food intake, you would only need to consume %4.2f calories less (daily) to achieve your target weight. However, this is within unsafe levels of changes. It is advisable to extend the time duration or revise your goals. \n", Math.abs(intersect_calories));

         }
         else{
             mystery_message += String.format(" > Based on your recorded daily food intake, you would only need to consume %4.2f calories less (daily) to achieve your target weight \n", Math.abs(intersect_calories));

         }

     }
     else{
         mystery_message += String.format(" > Based on your recorded daily food intake, you would only need to consume %4.2f calories more (daily) to achieve your target weight \n", intersect_calories);

     }
    


 }
 double water_intake = 0;
     for(int i = 0; i < checkArray_foodate().size(); i++){
        if(checkArray_foodate().get(i).get(0).equalsIgnoreCase("Water")){
            water_intake += Double.parseDouble(checkArray_foodate().get(i).get(1));
        }
     }
     double wa = ((((weight * 2.204)*2/3) +  ((time_total * 60)*6/15))) / 8;

   
 if(wa > water_intake){
    mystery_message += String.format(" > Based on your recorded water intake, you would need to consume %4.2f cups more (daily) to achieve daily water intake \n", wa - water_intake );

}
else{
    mystery_message += String.format(" > Based on your recorded water intake, you have reached the daily water intake of %.2f cups \n", water_intake);

}


            return mystery_message;
        }
    













      // =-=-=-=-=-=-=-=-=- NEW METHODS =-=-=-=-=-=-=-=-=- //


    public String addFood( String n, double c ){
        
        checker = 1;
        int updates=0;

        if(c < 0){
            return "Food cannot have negative calories.";
        }

        for(int i = 0; i < food_calorie.size();  i++){

            Food update = new Food(n, c);

            checker = 1;

            if(food_calorie.get(i).contains(n)){ 
              //  System.out.println("Food has been found");
                updates = i;
                update.updateCalories(c);

                food_calorie.get(i).set(1, String.format("%.2f", update.getFoodCalories())); // pang update ng cal of existing food

               // System.out.println("The food " + food_calorie.get(i).get(0) + " has " + food_calorie.get(i).get(1) + " calories");
                checker = 0;
                message = "Updated Food " + food_calorie.get(i).get(0) +" with " + food_calorie.get(i).get(1) + " kcal. ";
                checkArray_foodate();
                updater_food_ate(n, updates, c); 
                return message;
            }
            else{
                continue;
            }

            

        
            }
                checkArray_foodate();
                updater_food_ate(n, updates, c); 



            if(checker == 1){

                food_calorie.add(new ArrayList<String>());
                food_calorie.get(food_calorie.size()-1).add(n);

        //        food_ate.get(i).add(String.format("%.2f",total_calories)); // total calories consumed [2]
                food_calorie.get(food_calorie.size()-1).add(String.format("%.2f",c));                
                message = "Added Food " + food_calorie.get(food_calorie.size()-1).get(0) + " with " + food_calorie.get(food_calorie.size()-1).get(1) + " kcal.";
                return message;


            }

            return message;
        


        /*
                    creates a Food object, given a name and a calorie value
            > The new Food object is added to the collection of Food objects.
            > If a Food object with the same name already exists in the collection of Food objects, the calorie
            value of the existing Food object is updated with the provided calorie value.
            > A feedback message is returned for printing to the console or display on a GUI. Refer to the
            sample output.
            > n - the name of the Food
            > c - the calorie value of one serving of the Food
         */



    } 
    public String addActivity( String n, double c ){

        checker = 1;
        // CHECK FOR UPPERCASE LOWER CASE LETTER  
        int updates=0;

        if(c < 0){
            return "Activity cannot have negative calories.";
        }

        Activity update = new Activity(n, c);

        for(int i = 0; i < activities.size();  i++){

            checker = 1;

        if(activities.get(i).contains(n)){ 
            updates = i;
          //  System.out.println("Food has been found");

          update.updateCalories(c); // gets something from Activity
          activities.get(i).set(1, String.format("%.2f", update.getActivityCalories()) ); // pang update ng cal of existing food

           // System.out.println("The food " + food_calorie.get(i).get(0) + " has " + food_calorie.get(i).get(1) + " calories");
            checker = 0;
            message = "Updated Activity " + activities.get(i).get(0) + " with " +  activities.get(i).get(1) + " kcal. ";
            checkArray_activities_done();
            updater_activities_done(n, updates, c); 
            break;
        //         message = "Updated Food " + food_calorie.get(i).get(0) +" with " + food_calorie.get(i).get(1) + " kcal. ";

        }
        else{
            continue;
        }
    }
        checkArray_activities_done();
        updater_activities_done(n, updates, c); 
    
  

        if(checker == 1){


            activities.add(new ArrayList<String>());
            activities.get(activities.size()-1).add(n);
            activities.get(activities.size()-1).add(String.format("%.2f" , c));                
            message = "Added Activity " + activities.get(activities.size()-1).get(0) + " with " + activities.get(activities.size()-1).get(1) + " kcal. ";
            return message;


        /* 
         
                food_calorie.add(new ArrayList<String>());
                food_calorie.get(food_calorie.size()-1).add(n);

        //        food_ate.get(i).add(String.format("%.2f",total_calories)); // total calories consumed [2]
                food_calorie.get(food_calorie.size()-1).add(String.format("%.2f",c));                
                message = "Added Food " + food_calorie.get(food_calorie.size()-1).get(0) + " with " + food_calorie.get(food_calorie.size()-1).get(1) + " kcal.";
                return message;


         */

        }

        return message;
    

        
    }

    public String eat( String foodName, double servings ){
        message = "";
        checker = 1;

        if (servings <= 0){
            message = "Number of servings cannot be negative or zero.";
            return message;
        }

        for(int i = 0; i < food_calorie.size();  i++){

            checker = 1;

            if(food_calorie.get(i).contains(foodName)){ 
             
               
                food_ate.add(new ArrayList<String>());
                food_ate.get(food_ate.size()-1).add(foodName); //food name [0]
                food_ate.get(food_ate.size()-1).add(String.format("%.2f", servings)); // servings [1]

                double total_calories = ((Double.valueOf(food_calorie.get(i).get(1))/100) * (servings*100));
                food_ate.get(food_ate.size()-1).add(String.format("%.2f",total_calories)); // total calories consumed [2]


                checker = 0;

                message = "Ate " + food_ate.get(food_ate.size()-1).get(1) + " serving(s) of " + food_ate.get(food_ate.size()-1).get(0) + ", " +  food_ate.get(food_ate.size()-1).get(2) + " kcal. ";
                break;
            
            }
            else{
                continue;
            }

        
            }

        if(checker == 1){
            message = "The specified food does not exist.";
        }


            return message;



    }

    public String perform( String actName, double hours, String override){

        message = "";
        double time = 0;
        checker = 1;
        if (hours <= 0){
            message = "Number of hours cannot be negative or zero.";
            return message;
        }
      
        for(int i = 0; i < activities_done.size(); i++){

            time += Double.parseDouble(activities_done.get(i).get(1));
        }

        if(hours + time > 24.00 && override.equalsIgnoreCase("No")){
            message = "Cannot further perform (or add) activity. Activities recorded are only for the day, meaning there can only be 24 hrs worth of activity max. Do you want to override it (Y/N)? ";
            return message;
        }

        for(int i = 0; i < activities.size();  i++){

            checker = 1;

            if(activities.get(i).contains(actName)){ 
             

               // transfer = new Activity(actName, hours);

                activities_done.add(new ArrayList<String>());
                activities_done.get(activities_done.size()-1).add(actName);
                activities_done.get(activities_done.size()-1).add(String.format("%.2f", hours));

                double calorie = (Double.parseDouble(activities.get(i).get(1))/60) * (hours * 60) ; // gets from list of activities 
                calorie = Math.round(calorie * 100.0)/100.0;
                checker = 0;
                activities_done.get(activities_done.size()-1).add(String.format("%.2f" , calorie));

                message = ("Performed " + activities_done.get(activities_done.size()-1).get(1) + " hour(s) of " + actName + ", "+  activities_done.get(activities_done.size()-1).get(2) + " kcal. ");
                break;
                
            
            }
            else{
                continue;
        

            }

            /* 
              activities.add(new ArrayList<String>());
            activities.get(activities.size()-1).add(n);
            activities.get(activities.size()-1).add(String.format("%.2f" , c));                
            message = "Added Activity " + activities.get(activities.size()-1).get(0) + " with " + activities.get(activities.size()-1).get(1) + " kcal. ";
            return message;
             */
        
        }

        if(checker == 1){
            message = "The specified activity does not exist.";
        }


            return message;
    }
    
    public String report(){

        report_message = "";
         total_calories_consumed = 0.00;
         total_calories_burned = 0.00;
         net_calories = 0.00;
         kg_calorie_converter = 0.00012959782;

       

        report_message += String.format("----------------\n");
        report_message += String.format("LIFESTYLE REPORT\n");
        report_message += String.format("----------------\n");

        for(int i = 0; i < food_ate.size(); i ++){

            total_calories_consumed += Double.parseDouble(food_ate.get(i).get(2));
            report_message += String.format("%4s serving(s) of %2s, %4s kcal \n", food_ate.get(i).get(1), food_ate.get(i).get(0), food_ate.get(i).get(2));
    
        }

        report_message += String.format("----------------\n");
        report_message += String.format("Total Calories Consumed: %.2f kcal \n", total_calories_consumed);
        report_message += String.format("----------------\n");
        report_message += String.format("Activities Performed:\n");

        // 1.00 hour(s) of Biking, 340.00 kcal

        for(int i = 0; i < activities_done.size(); i ++){

            total_calories_burned += Double.parseDouble(activities_done.get(i).get(2));
            report_message += String.format("%4s hour(s) of %2s, %4s kcal \n", activities_done.get(i).get(1), activities_done.get(i).get(0), activities_done.get(i).get(2));
    
        }

        report_message += String.format("----------------\n");
        report_message += String.format("Total Calories Burned: %.2f kcal\n", total_calories_burned);
        report_message += String.format("----------------\n");

        net_calories = total_calories_consumed - total_calories_burned;
        report_message += String.format("Net Calories for the Day: %.2f kcal \n", net_calories);
        report_message += String.format("If you keep up this lifestyle...\n");

        
        if ( net_calories < 0){
            report_message += String.format("In a week, you will lose %.2f kilograms.\n", Math.abs( kg_calorie_converter * net_calories * 7) );
            report_message += String.format("In a month, you will lose %.2f kilograms.\n", Math.abs( kg_calorie_converter * net_calories * (30*1)) );
            report_message += String.format("In 3 months, you will lose %.2f kilograms.\n", Math.abs( kg_calorie_converter * net_calories * (30*3)) );
            report_message += String.format("In 6 months, you will lose %.2f kilograms.\n", Math.abs( kg_calorie_converter * net_calories * (30*6)) );
            report_message += String.format("----------------\n");


            
        }
        else if(net_calories >= 0){
            report_message += String.format("In a week, you will gain %.2f kilograms.\n", ( kg_calorie_converter * net_calories * 7) );
            report_message += String.format("In a month, you will gain %.2f kilograms.\n", ( kg_calorie_converter * net_calories * (30*1)) );
            report_message += String.format("In 3 months, you will gain %.2f kilograms.\n", ( kg_calorie_converter * net_calories * (30*3)) );
            report_message += String.format("In 6 months, you will gain %.2f kilograms.\n", ( kg_calorie_converter* net_calories * (30*6)) );
            report_message += String.format("----------------\n");

        }
        // Net Calories = Calories consumed - Calories burned
        // if positive, report will show calories gained in kg
        // if negative, report will show calories burned in kg

        // FORMULA: given converter sa file * Net Calorie * Time(Days)
        // NOTE: A week denotes 7 days. A month denotes 30 days. 1 kcal = 0.00012959782 kg
        return report_message;
        
    }

    
}

