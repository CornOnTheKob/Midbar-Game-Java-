import java.util.ArrayList;
import java.util.*;

/**
	
	@author Jacob Lorenzo A. Cano (221303)
	@version December 3, 2022

**/

/*
 
    The TrackerConsole java program creates a sort of Lifestyle Tracker application in which the system can and should be able to record several food items with its caloires per serving as well
    as several kinds of activities and calories burned from performing each activity for an hour. The system will then proceed to track the user's diet 
    and list down all of the foods ate and activities performed, the net calories, and based on that, the amount of weight that the user is expected to gain or lose 
    in specific time frames


  
 */

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
public class TrackerConsole {


   
    private static String name;
    public static String mystery_unlocker;
    public static String gender_choice = "";
    public static boolean one;
    public static boolean two;
    public static boolean three;
    public static boolean four;
    public static boolean five;
    public static boolean six;
    public static double feet;
    public static double inches;
    public static String override;

// CHECK FOR LOWER CASE AND UPPERCASE 
    public static void main(String[]args){

        Scanner in = new Scanner(System.in);
        LifestyleTracker input = new LifestyleTracker();

        String second_word_name; 
        double third_word_CSH;
        String message;
        String decision;
        String modifier_word;
        String modifier_word_converter;
        boolean checker3 = true;
        boolean checkerulit = true;
        mystery_unlocker = "locked";
        int age = 0;
        override = "no";
        one = true;
        two = true;
        three = true;
        four = true;
        five = true;
        six = true;

        String list;


        boolean checker = true;

        name = String.format("Welcome to %1s's Lifestyle Tracker! \n" , args[0]);
        System.out.print(name);
        while(checker = true){
            String first_word_command = in.next(); 
            String second_word_name_converter;
            String first_word_converter = first_word_command.substring(0, 1).toUpperCase() + first_word_command.substring(1).toLowerCase();
                 name = String.format("Welcome to %1s's Lifestyle Tracker! \n" , args[0]);

            // System.out.println("Word is:" + first_word_command.substring(0,1).toUpperCase() + first_word_command.substring(1).toLowerCase());

            if(first_word_converter.equalsIgnoreCase("Food")){
                 second_word_name = in.next().toLowerCase(); 
                  second_word_name_converter = second_word_name.substring(0,1).toUpperCase() + second_word_name.substring(1).toLowerCase();
                 third_word_CSH = in.nextDouble();

                  message = input.addFood(second_word_name_converter, third_word_CSH);

                System.out.println(message);
            }
            else if(first_word_converter.equalsIgnoreCase("Command")){

                String[] list_of_com = {"Food <name> <calorie>", "Activity <name> <calorie>", "Eat <name> <servings>", "Perform <name> <time>", "Edit <foodrec/activityrec>", "Mystery <???>", "Report2" ,"Report (terminate program)"};
                
                System.out.println("List of Commands: ");
                for(int i = 0; i<list_of_com.length; i++){
                    System.out.println("--> " + list_of_com[i]);
                    
                }

            }
            else if(first_word_converter.equalsIgnoreCase("Activity")){

                 second_word_name = in.next(); 
                 second_word_name_converter = second_word_name.substring(0,1).toUpperCase() + second_word_name.substring(1).toLowerCase();

                third_word_CSH = in.nextDouble();

                 message = input.addActivity(second_word_name_converter, third_word_CSH);
                System.out.println(message);

            }

            else if(first_word_converter.equalsIgnoreCase("Eat")){

                second_word_name = in.next(); 
                 second_word_name_converter = second_word_name.substring(0,1).toUpperCase() + second_word_name.substring(1).toLowerCase();

                third_word_CSH = in.nextDouble();

                message = input.eat(second_word_name_converter, third_word_CSH);

                System.out.println(message);
                if(message.equals("The specified food does not exist.")){ // "yet"
                    while(checkerulit = true){
                    System.out.print("--> Do you wanna add this to the menu (Y/N)? ");
                    decision = in.next(); 

                    switch(input.capitalize(decision)){
                        case "Y": 
                            System.out.println("--> You have chosen Yes.");
                            System.out.print("--> Insert Calorie value per serving: ");
                            double fourh_word_CSH = in.nextDouble();
                        
                            message = input.addFood(second_word_name_converter, fourh_word_CSH);
                            String message2 = input.eat(second_word_name_converter, third_word_CSH);

                            System.out.println(message);
                            System.out.println(message2);

                            checkerulit = false;
                            break;
                        case "N": 
                            System.out.println("-->You have chosen No.");
                            
                            break;
                        default :
                        System.out.println("--> Command not found. Try again.");
                        continue;
                    }
                    checkerulit = false;
                    break;
                }
                }
               

              }
            
            else if(first_word_converter.equals("Perform")){

                 override = "no";
                 second_word_name = in.next(); 
                 second_word_name_converter = second_word_name.substring(0,1).toUpperCase() + second_word_name.substring(1).toLowerCase();

                third_word_CSH = in.nextDouble();
                
                
                message = input.perform(second_word_name_converter, third_word_CSH, override);
                System.out.println(message);

                // message = "The specified activity does not exist.";
                if(message.equals("The specified activity does not exist.")){
                    while(checkerulit = true){
                        System.out.print("--> Do you wanna add this to list of Activities (Y/N)? ");
                        decision = in.next(); 

                    switch(input.capitalize(decision)){
                        case "Y":
                            System.out.println("--> You have chosen Yes.");
                            System.out.print("--> Insert Calorie burned per hour of this Activity: ");
                            double fourh_word_CSH = in.nextDouble();
                        
                            message = input.addActivity(second_word_name_converter, fourh_word_CSH);
                            String message2 = input.perform(second_word_name_converter, third_word_CSH, override);

                            System.out.println(message);
                            System.out.println(message2);
                            checkerulit = false;
                            break;
                        case "N":
                            System.out.println("-->You have chosen No.");
                            break;
                        default : 
                            System.out.println("--> Command not found. Try again.");
                            continue;

                    }
                    checkerulit = false;
                    break;
                    }
                }
                else if(message.equals("Cannot further perform (or add) activity. Activities recorded are only for the day, meaning there can only be 24 hrs worth of activity max. Do you want to override it (Y/N)? ")){
                   boolean desisyonz = true;
                    while(desisyonz == true){
                    String desisyon = in.next();

                    if(desisyon.equalsIgnoreCase("Y")){
                        override = "yes";
                        System.out.println("System has been overridden.");
                        String message2 = input.perform(second_word_name_converter, third_word_CSH, override);
                        desisyonz = false;

                        if(message2.equals("The specified activity does not exist.")){
                            while(checkerulit = true){
                                System.out.print("--> Do you wanna add this to list of Activities (Y/N)? ");
                                decision = in.next(); 
        
                            switch(input.capitalize(decision)){
                                case "Y":
                                    System.out.println("--> You have chosen Yes.");
                                    System.out.print("--> Insert Calorie burned per hour of this Activity: ");
                                    double fourh_word_CSH = in.nextDouble();
                                
                                    message = input.addActivity(second_word_name_converter, fourh_word_CSH);
                                    String message3 = input.perform(second_word_name_converter, third_word_CSH, override);
        
                                    System.out.println(message);
                                    System.out.println(message3);
                                    checkerulit = false;
                                    break;
                                case "N":
                                    System.out.println("-->You have chosen No.");
                                    break;
                                default : 
                                    System.out.println("--> Command not found. Try again.");
                                    continue;
        
                            }
                            override = "no";
                            checkerulit = false;
                            break;
                            }}
                        
                        break;
                    }
                    else if(desisyon.equalsIgnoreCase("N")){
                        override = "no";
                        System.out.println("System will not be overridden.");
                        String message2 = input.perform(second_word_name_converter, third_word_CSH, override);
                        desisyonz = false;
                        break;

                    }
                    else{

                        System.out.println("Invalid input. Try again.");
                        System.out.print("--> Do you want to override it (Y/N)? ");
                        continue;

                    }


                }

            }

            }
            
            else if(first_word_converter.equalsIgnoreCase("Report")){

                checker = false;


                message = input.report();
                System.out.println(message);

                break;

            }
            else if(first_word_converter.equals("Edit")){
                second_word_name = in.next(); 
                 second_word_name_converter = second_word_name.substring(0,1).toUpperCase() + second_word_name.substring(1).toLowerCase();

                if(second_word_name_converter.equals("Foodrec")){
                    
                    if(input.checkArray_foodate().isEmpty()){
                        System.out.println("List of Food Ate is still empty. Start eating now!");
                        continue; 
                        
                    }
            
                    else{



                    boolean checker2 = true;
                    ArrayList<ArrayList<String>> list_food_ate = input.checkArray_foodate();
                    while (checker2 = true){

                        if(input.checkArray_foodate().isEmpty()){
                          
                            break;
                        }
                        else{
                        
                        list = input.edit_report_foodate();
                        System.out.println(list);

                        System.out.print("--> delete or edit? ");
                        modifier_word = in.next();
                        modifier_word_converter = modifier_word.substring(0,1).toUpperCase() + modifier_word.substring(1).toLowerCase();


                        if (modifier_word_converter.equals("Delete")){
                        while(checker3 = true){

                            System.out.print("--> Select record # to delete: ");
                            String third_word_name = in.next(); 
                            String response = input.edit_data_foodate(third_word_name);

                            if(response.equals("Congrats the index is found.")){

                               
                                input.foodate_remover(Integer.parseInt(third_word_name)); 
                                break;
                                
                            }
                            else if(response.equals("Back")){
                                System.out.println("--> Editing cancelled.");
                                break;
                            }
                            else{
                                System.out.println("--> Index not found. Try again");
                                continue;
                            } // IF INDEX NOT FOUND, IT SHOULD ONLY LOOP BACK TO THE SAME PROMPT 
                             // # CHOOSE INDEX  AND NOT GO BACK TO EDIT / DELETE
                        }

                        }
                        else if(modifier_word_converter.equalsIgnoreCase("Edit")){
                            while(checker3 = true){


                        System.out.print("--> Select record # to edit: ");
                        String third_word_name = in.next(); 
                        String response = input.edit_data_foodate(third_word_name);

                        if(response.equals("Congrats the index is found.")){

                            System.out.print("--> Type new name of food: ");
                            String foodname = in.next();
                            String foodname_converter = foodname.substring(0,1).toUpperCase() + foodname.substring(1).toLowerCase();
                            int ch = 1;

                            for(int i =0; i < input.checkArray_foodlist().size(); i++){

                                if(input.checkArray_foodlist().get(i).get(0).contains(foodname_converter)){
                                    ch = 0;
                                }
                            }
                            if(ch !=0){
                                     System.out.print("--> Type new calories: ");
                                     String calories = in.next();

                                     input.addFood(foodname_converter, Double.parseDouble(calories));

                            }


                            System.out.print("--> Type new amount of servings: ");
                            double fourth_word = in.nextDouble(); 
                            input.checkArray_foodate();
                            input.checkArray_foodlist();
                           
                            input.edit_data_foodate_edit(Integer.parseInt(third_word_name), fourth_word, foodname_converter);
                            break;
                            
                        }
                        else if(response.equals("back")){
                            System.out.println("--> Editing cancelled.");
                            break;
                        }
                        else{
                            System.out.println("--> Index not found. Try again");
                            continue;
                            
                        }
                    }
                        }
                        else if(modifier_word_converter.equals("Back")){
                            System.out.println("--> Editing cancelled.");
                            checker2 = false;
                            checker3 = false;
                            break;
                        }
                        else{
                            System.out.println("--> Command not found. Try again.");
                            continue;
                        }

                    }
                        continue;
                    }
                }
                
              
                /* 
                 Add the function to allow the user to periodically view all of the recorded food eaten or activities performed (so
far), with corresponding record numbers (index),  then select a record number and update the data of that record.
                 */

                }else if(second_word_name_converter.equalsIgnoreCase("Activityrec")){
                    if(input.checkArray_activities_done().isEmpty()){
                        System.out.println("List of Activities Done is still empty. Start exercising now!");
                        continue; 
                    }
                    else{
                    boolean checker32 = true;
                 //   ArrayList<ArrayList<String>> list_activities_done = input.checkArray_activities_done();

                    while(checker32 == true){
                        
                        if(input.checkArray_activities_done().isEmpty()){
                          
                            break;
                        }
                        else{
                  
                        list = input.edit_report_activities_done();
                        System.out.println(list);

                        System.out.print("--> delete or edit? ");
                        modifier_word = in.next();
                        modifier_word_converter = modifier_word.substring(0,1).toUpperCase() + modifier_word.substring(1).toLowerCase();


                        if(modifier_word_converter.equals("Delete")){

                            while(checker3 = true){

                            System.out.print("--> Select record # to delete: ");
                            String third_word_name = in.next(); 
                            String response = input.edit_data_activitiesdone(third_word_name);
    
                            if(response.equals("Congrats the index is found.")){
                                input.activities_done_remover(Integer.parseInt(third_word_name));
                                break;
                                
                            }
                            else if(response.equals("back")){
                                System.out.println("--> Editing cancelled.");
                                break;
                            }
                            else{
                                System.out.println("--> Index not found. Try again");
                                continue;
                                
                            }
                        }
                        }else if(modifier_word_converter.equals("Edit")){

                            while(checker3 = true){

                            System.out.print("--> Select record # to edit: ");
                            String third_word_name = in.next(); 
                            String response = input.edit_data_activitiesdone(third_word_name);
    
                            if(response.equals("Congrats the index is found.")){
                                override = "no";


                                System.out.print("--> Type new name of Activity: ");
                                String activ_name = in.next();
                                String activ_name_converter = activ_name.substring(0,1).toUpperCase() + activ_name.substring(1).toLowerCase();

                                int ch =1;

                                for(int i =0; i<input.checkArray_activities().size(); i++){

                                    if(input.checkArray_activities().get(i).get(0).contains(activ_name_converter)){
                                        ch = 0;
                                    }

                                }
                                if(ch != 0){
                                    System.out.print("--> Type calories amount: ");
                                    String calories = in.next();
                                    input.addActivity(activ_name_converter, Double.parseDouble(calories));
                                }

                                System.out.print("--> Type new value for hours: ");
                                double fourth_word = in.nextDouble(); 
                                String ma = input.edit_data_activitiesdone_edit(Integer.parseInt(third_word_name), fourth_word, override, activ_name_converter);
                                boolean overrider_checker = true;
                                if(ma.equals("Cannot further perform/add/edit this activity. Activities recorded are only for the day, meaning there can only be 24 hrs worth of activity max. Do you want to override it (Y/N)?")){
                                    while(overrider_checker == true){

                                    String des = in.next();
                                    if(des.equalsIgnoreCase("y")){
                                        override = "yes";
                                        System.out.println("System has been overridden.");
                                        input.edit_data_activitiesdone_edit(Integer.parseInt(third_word_name), fourth_word, override, activ_name_converter);
                                        override = "no";
                                        break;
                                    }
                                    else if(des.equalsIgnoreCase("n")){
                                        override = "no";
                                        System.out.println("System will not be overridden.");
                                      

                                        input.edit_data_activitiesdone_edit(Integer.parseInt(third_word_name), fourth_word, override, activ_name_converter);
                                        break;

                                    }
                                    else{
                                        System.out.println("--> Invalid Input. Try again.");
                                        System.out.println("Do you want to override it (Y/N)? ");
                                        continue;

                                    }
                                }
                                }

                                break;

                                
                                
                            }
                            else if(response.equals("Back")){
                                System.out.println("--> Editing cancelled.");
                             
                                break;
                            }
                            else{
                                System.out.println("--> Index not found. Try again");
                                continue;
                                
                            }
                        }


                        }else if(modifier_word_converter.equals("Back")){
                            
                            System.out.println("--> Editing cancelled.");
                            checker32 = false;
                            checker3 = false;
                            break;
                        }else{
                            System.out.println("--> Command not found. Try again.");
                            continue;
                        }


                    }


                    }
                }



                }
              
                
                
                else{
                System.out.println("--> Command Not Found. Try again. ");
                continue;
                }
            }


            else if(first_word_converter.equalsIgnoreCase("Mystery")){
                mystery_unlocker = "unlocked";
                System.out.println("-=-=-> Welcome to Mystery Mode <-=-=-=");
               
               
              

                while(one == true){
                    System.out.print("--> Enter Gender (M/F): ");
                    String gender = in.next();
                switch(input.capitalize(gender)){
                    case "M":
                         gender_choice = "M";
                         System.out.print(String.format("Gender Male has been recorded.\n"));
                         one = false;
                         break;
                    case "F":
                         gender_choice = "F";
                         System.out.print(String.format("Gender Female has been recorded.\n"));
                         one = false;
                        break;
                    default :
                        System.out.println("Unknown Input. Try again.");
                        continue;

                }
                one = false;
                break;
            }

            while(two = true){
                System.out.print("--> Enter Age (in years): ");
                age = in.nextInt();

                if(age < 0){
                    System.out.println("Invalid Input. Age cannot be negative.");
                    continue;
                }
                else{
                    System.out.println(String.format("%2s year(s) of age has been recorded.", age));
                    two = false;
                    break;

                }
            }
             
                in.nextLine(); // to reset
             while(three = true){

            
                System.out.print("--> Enter Height (in ft'in): ");
                String height = in.nextLine();
                String[] height_split = height.split("'");

                if(Integer.parseInt(height_split[1]) >= 12){
                 System.out.println("--> Invalid input. Please try again");
                 continue;
                }
                else{
                     feet = Double.parseDouble(height_split[0])/ 3.281;
                     inches = Double.parseDouble(height_split[1]) / 39.37;
                    input.height_recorder(height_split[0], height_split[1]);
    
                     System.out.println("Height of " + height_split[0] + " feet and " + height_split[1] + " inches has been recorded." );
                    break;
                  
                }
            }
               
                System.out.print("--> Enter weight (in kg): ");
                double weight = in.nextDouble();
                System.out.println(String.format("Weight of %.2f kg has been recorded", weight));
                boolean weight_checker = true;

                input.bmi_calculator(weight, feet, inches);
                input.bmr_calculator(weight, gender_choice, feet, inches, age);
                while(weight_checker = true){
                    
                    System.out.print("--> Enter weight goal in kg, followed by target weight (e.g. Gain 50): ");
                // gain to 50 kg,
                String target_weight_type = input.capitalize(in.next());
                double target_weight = in.nextDouble();
                
               
                if(!input.weightgoal_checker(target_weight_type, weight,target_weight ).equals("success")){
                    System.out.println(input.weightgoal_checker(target_weight_type, weight,target_weight ));
                    continue;
                    
                }
                else{
                    input.weightgoal_checker(target_weight_type, weight,target_weight );
                    System.out.println(String.format("Target weight (%4s) from %.2f to %.2f kg. has been recorded.", target_weight_type, weight, target_weight));
                    break;

                }


                }
                

               

                // Daily activity level: based sa # of activities... 
                while(six = true){

                    System.out.print("--> Enter time period to achieve target goal (whole days/weeks/month) (e.g. 2 weeks) ");
                    int time_period_value = in.nextInt();
                    String time_period_type = in.next();
               
                if(input.time_converter(time_period_type, time_period_value).equalsIgnoreCase("Invalid Input")){
                    System.out.println("Invalid input. Try again.");
                    continue;
                }
                else{
                    System.out.println(String.format("Time period of %1s %6s has been recorded.",time_period_value, time_period_type.substring(0,1).toUpperCase() + time_period_type.substring(1).toLowerCase() ));
                    System.out.println("You may resume recording your food intake and activities performed.");
                    input.time_converter(time_period_type, time_period_value);
                    input.trio_calorie_calculator();
                    input.activity_level();
                    six = false;
                    break;
    
                }
            }
                
            }
            
            else if(first_word_converter.equalsIgnoreCase("Report2")){
                if(mystery_unlocker.equalsIgnoreCase("locked")){
                    System.out.println("Sorry, you can't access this yet. Open the Mystery mode first! (Hint: type mystery in the command prompt).");
                }
                else{
                    message = input.mystery_report();
                    System.out.println(message);
                }
              
            }



            else{
                System.out.println("--> Command Not Found. Try again. ");
                continue;
            }
            continue;

        }
      

/* 
 
Food - calls addFood() on the LifestyleTracker object, given the values that follow
●Activity - calls addActivity() on the LifestyleTracker object, given the values that follow
●Eat - calls eat() on the LifestyleTracker object, given the values that follow
●Perform - calls perform() on the LifestyleTracker object, given the values that follow
●Report - calls report() on the LifestyleTracker object


Food <name> <calories>
Record that the food named <name> contains <calories> calories per serving.
●Activity <name> <calories>
Record that performing the activity named <name> burns <calories> calories per hour.
●Eat <name> <servings>
Record that the user ate <servings> servings of the food named <name>.
●Perform <name> <hours>
Record that the user performed the activity named <name> for <hours> hours.
●Report
Print the report (refer to the sample output).
 */


    }


}
/*
    //main
    private static ArrayList<ArrayList<String>> food_ate;
    private static double converter_servings_hours;
    private static double converter_calories;
    private static String converter;

    public TrackerConsole(){
       
         converter_servings_hours = 0.00;
         double converter_calories = 0.00;
         String converter = "";

    }


    public static void main(String[]args){
    
    
        food_ate = new ArrayList<ArrayList<String>>();

    System.out.printf("Welcome to %1s's Lifestyle Tracker! \n" , args[0]);

    food_ate.add(new ArrayList<String>());
    food_ate.get(0).add("Cupcake"); //food name [0]

    converter_calories = (  23.821 );
    converter = String.format("%.2f", converter_calories);

    food_ate.get(0).add(String.valueOf(2.34)); // servings [1]

    food_ate.get(0).add(String.valueOf(converter_calories)); // total calories consumed [2]


    food_ate.add(new ArrayList<String>());

    
    food_ate.get(1).add("Cake"); //food name [0]
    food_ate.get(1).add(String.valueOf(5.66)); // servings [1]
    converter_calories = (  2.49366 );
    converter = String.format("%.2f", converter_calories);
    food_ate.get(1).add(String.valueOf(converter)); // total calories consumed [2]


    System.out.println(food_ate);

    String message = "";
    String fullmessage = "";

    message += String.format("----------------\n");
    message += String.format("LIFESTYLE REPORT\n");
    message += String.format("----------------\n");
    double total_calories_consumed = 0;

    for(int i = 0; i < food_ate.size(); i ++){

        total_calories_consumed += Double.parseDouble(food_ate.get(i).get(2));

        message += String.format("%4s serving(s) of %2s, %4s kcal \n", food_ate.get(i).get(1), food_ate.get(i).get(0), food_ate.get(i).get(2));

    }

    message += String.format("----------------\n");
    message += String.format("Total calories burned is: %.2f",  total_calories_consumed);



    System.out.println(message);
     
    }
   */




    /* 
        ArrayList<ArrayList<String>> food_calorie = new ArrayList<ArrayList<String>>();

        food_calorie.add(new ArrayList<String>());

        food_calorie.get(0).add("Strawberry");
        food_calorie.get(0).add("34");

        food_calorie.add(new ArrayList<String>());

        food_calorie.get(1).add("Mango");
        food_calorie.get(1).add("60");


        food_calorie.get(0).set(0, "Banana");
        food_calorie.get(0).set(1, "45" );

        String name = "Mango";

        if(food_calorie.get(1).contains(name)){
            System.out.println("Meron");
        }


      //  food_calorie.indexOf("Banana");

      //  System.out.print(food_calorie.indexOf("Mango"));

            // System.out.println(food_calorie);

            //  System.out.println("The food " + food_calorie.get(0).get(0) + " has " + food_calorie.get(0).get(1) + " calories");

                // The food Banana has 60 calories







*/





/*
        ArrayList<ArrayList<String>> name = new ArrayList<>();

        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>(3);

        for(int i = 0; i < listOfLists.size(); i++)  {
            listOfLists.add(new ArrayList<String>());
        }

        ArrayList<String>[][] list = new ArrayList[10][10];
            list[0][0] = new ArrayList<>();
            list[0][0].add("test");
            // [test]

            list[0][1] = new ArrayList<>();
            list[0][1].add("jaocb");
            list[0][1].add("lorenzo");
            //   [jaocb, lorenzo]

            list[0][2] = new ArrayList<>();
            list[0][2].add("lorenzo");
            
            System.out.println(list[0][0]);
            System.out.println(list[0][1]);



        name.add(new ArrayList<>());

        name.get(0).add("Jacob");

        System.out.println(name.get(0));

        //[Jacob]

 */
        /*

        name.add("Jacob") ; // [0]
        name.add("Lorenzo") ; // [1]
        name.add("Atanacio") ; // [2]

        double[][] array = new double[3][];

        array[0] = new double[3];
        array[1] = new double[4];
        array[2] = new double[5];
        array[0][2] = 2.0;
     
        for(int i = 0; i < array.length; i++){

            System.out.println("Row index " + i);
            for(int j = 0; j < array[i].length; j++){
                System.out.println("Column value " + j + " is: " + array[i][j]);


            }

        }


        for(int i = 0; i < 3; i++){
            System.out.println(array.length);
        }

    

     */


