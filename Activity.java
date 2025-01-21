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

import java.util.ArrayList;

public class Activity {

    private String name_activity;
    private double calorie_value;
    private double total_calories_burned;

    public Activity(String n, double c) {

        name_activity = n;
        calorie_value = c; // current value of activity.

    }

    public String getActivityName() {

        return name_activity;

    }

    public void updateCalories(double c) {

        // calories that should be burned by 1 hour

        String converter = String.format("%.2f", c);
        calorie_value = Double.parseDouble(converter);

        //

        // food_calorie.get(0).set(0, "bananas");

    }

    public double getActivityCalories() {

        return calorie_value;

    }

}
