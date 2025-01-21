/**
	
	@author Jacob Lorenzo A. Cano (221303)
	@version December 3, 2022

**/

/*

> The TrackerApp Java program calls on methods from the TrackerGUI.java, while at same time initializes and declaring the size of the JFrame of the GUI which 1100 x 780. 


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
public class TrackerApp{
    
    public static void main(String[] args){
        TrackerGUI gd = new TrackerGUI(1100, 780);

        gd.setUpGUI();
        gd.EnterButton();
        gd.FoodButton();
        gd.ActivityButton();
        gd.ReportButton();
        gd.ClearButton();
        gd.EatButton();
        gd.View_Activities_Performed_Button();
        gd.PerformButton();
        gd.EditFoodButton();
        gd.EditActivityButton();
        gd.MysteryButton();
        gd.MysteryReportButton();
        gd.ViewActivitiesButton();
        gd.View_Food_Eaten_Button();
        gd.View_Food_List();
        // new NewJFrame().setVisible(true);


     

    }
}
