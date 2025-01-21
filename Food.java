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
public class Food {

    private String name_food;
    private double calorie_value;

    public Food(String f, double c) {

        name_food = f;
        calorie_value = c; // current value of activity.

        /*
         * initializes the instance fields with the values provided in the parameters
         * ■f - the name of the Food
         * ■c - the calorie value of the Food
         * 
         */
    }

    public String getFoodName() {

        return name_food;

    }

    public double getFoodCalories() {

        return calorie_value;

    }

    public void updateCalories(double c) {

        calorie_value = c;

        // nables the Food to update the calorie value
        // c - the new calorie value of one serving of the Food

    }
}
