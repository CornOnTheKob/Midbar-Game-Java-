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

The TrackerGUI.java uses various java swing classes to implement the needed functionalities that a TrackerConsole can do.

 In this JFrame, the GUI is segregated into at least 3 JPanels
> Panel 1
	- User will input his/her name to enable all the Jbuttons 
	- User can now utilize the JButton as well as use JOptionPanes to record the Food and its calories, Food eaten and its servings as well as total calories consumed. Same goes to Activities. 
	- User can also print the Report and Mystery Report as well as Activate Mystery Mode through one of the given buttons.

> Panel 2
	- Using JTables, user can view the ff:
		> List of Food 
		> List of Food Eaten
		> List of Activities
		> List of Activities Performed
		* Programmer used various classes such as Default Table Model, JTables as well as 				other things from the java catalogue.
	- The user can also switch on viewing what they want to see using J Buttons and two of the buttons can allow the user to edit the List of FOOD ATE and ACTIVITIES PERFORMED
		> The User can edit the name and servings (for FOOD)
		> The User can edit the name and hours performed (for Activities)
		> If the User inputted a new name not found within the list of Foods Recorded / Activities Performed, it will ask the user for the amount of calories that activity consumes/burns (per serving or per hour). 
		> Otherwise, it will only ask for the servings/hours performed if the name has been found. 

		

> Panel 3
	- Using JTextArea, the program will print out either of the three:
	 	- 1) A prompt welcoming the user to the lifestyle tracker
		- 2) Report() - print a "receipt" consists of
			> List of food consumed 
			> Total calories consumed
			> List of Activities performed
			> Total calories burned
			> Net calories for the day
			> And forecast on how many kg can you lose/gain [after a week, a months, 3 months, and 6 months]

		- 3) Mystery Mode - the mystery mode is an add-on that takes new input from the user such as gender, age, height, weight, weight goal type, target weight, time period, and activity level. From those it will calculate the ff:
	> BMI - will also tell if under what category you are within
	> BMR - Basal Metabolic Rate tells you the number of calories your body needs to accomplish its most basic (basal) life-sustaining functions for the day. -- using the HARRIS-BENEDICT EQUATION. 
	> Calories to sustain weight -- calories needed for the day to sustain your weight
	> Calories to target weight -- calories needed to achieve your target weight per day
	> Calories to gain/lose weight - how much calories you need to consume less or more per day
	   
	> Integrating the new inputs with the old inputs, THE Activity Level will check the list of activities performed and make research-based assumptions depending on how long you do the activities for (*This is assumed that the activities performed are "strenuous" activities or physically-demanding exercises).
	> Also, it will tell you based on your recorded daily food intake, how many calories you would need (or not need) to consume or burn. [DEPENDING ON THE INPUTS]

	- A Clear Report button can be seen in the lower part of the JPANEL which can be used to clear the text area



 */

/*
 REFERENCES


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
    
Java: Custom Buttons in showInputDialog. https://stackoverflow.com/questions/13334198/java-custom-buttons-in-showinputdialog
*/
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.awt.event.ActionEvent; // need this otherwise error...?

import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.FlowLayout; //Flowlayout manager
import java.awt.Container; // For the content pane, container data type

import java.awt.BorderLayout;
import java.awt.GridLayout;



public class TrackerGUI {

   


    private LifestyleTracker input;
    private JFrame frame; 
    private JButton enter_button;

    

    private JPanel panel;
    private JButton food_button;
    private JButton activity_button;
    private JButton eat_button;
    private JButton perform_button;
    private JButton mystery_button;
    private JButton report2_button;
    private JButton report_button;
    private int checker; 

    private JPanel panel2;
    // private JTextArea food_list;
    //private JTextArea activities_list;
    //private JButton view_activities;
    private JButton view_food_ate_button;
    private JButton view_activities_performed_button;
    private JButton edit_food_ate_button;
    private JButton edit_activities_performed_button;
    private JButton delete_food_ate_button;
    private JButton delete_activities_performed_button;
    private JTable activities_table;
    private JTable food_table;
    private JScrollPane scroller_activity;
    private JScrollPane scroller_food_eat;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private JButton display_foodlist_button;
    private JButton display_activities_button;


    public static double feet;
    public static double inches;

    private JPanel panel3;
    private JLabel display_name;
    public static String mystery_unlocker = "locked";


    private JPanel panel4;
    private JLabel Report_name;
    private JTextArea Report;
    private JButton clear_report;
    private JScrollPane scroller;
    private String report_message;


    private int width;
    private int height;
   
    private JTextArea report_receipt;
    private JTextField user_name_input;
    private JLabel user_name_label;
    // private Border border = BorderFactory.createLineBorder(Color.BLACK);

    private String override;
    

    public TrackerGUI(int w, int h){ // instantiate it...

        checker =1;
        frame = new JFrame();
        frame.setResizable(false);

   //     FlowLayout flow = new FlowLayout();
    //    GridLayout grid = new GridLayout(1,7);
//        GridLayout grid = new GridLayout(1,7);
        report_message = "";
        panel = new JPanel(); // panel1 = buttons
        panel2 = new JPanel(); // panel2 = results of food ate
        panel3 = new JPanel(); // panel3 = welcome user
        panel4 = new JPanel(); // panel4 = report and mysteryreport
        width = w;
        height = h;
        enter_button = new JButton("Enter");
        food_button = new JButton("Food"); // label
        input = new LifestyleTracker();
        activity_button = new JButton("Activity");
        eat_button = new JButton("Eat");
        perform_button = new JButton("Perform"); // label
        mystery_button = new JButton("Mystery");
        report2_button = new JButton("Mystery Report");
        report_button = new JButton("Report"); // label
        report_receipt = new JTextArea("aaa");
        user_name_input = new JTextField();
        user_name_label = new JLabel();
        display_name = new JLabel();
       // food_list = new JTextArea("--- List of food ---");
       
     

        Report_name = new JLabel();

         String editfoodate = " Edit\nFood Ate";

         edit_food_ate_button = new JButton("<html>" + editfoodate.replaceAll("\\n", "<br>") + "</html>");
          edit_activities_performed_button = new JButton("Edit Act Performed");
     delete_food_ate_button = new JButton("Delete Food Eaten");
    delete_activities_performed_button = new JButton("Delete Act Performed");
    String view_FA = " View Food\n  Eaten";


    view_food_ate_button = new JButton("<html>" + view_FA.replaceAll("\\n", "<br>") + "</html>");
    String view_AP = " View Acts\n  Performed";

    display_foodlist_button = new JButton("VFL");
    display_activities_button = new JButton("VAL");

    view_activities_performed_button = new JButton("<html>" + view_AP.replaceAll("\\n", "<br>") + "</html>");
    Report = new JTextArea("");


         model = new DefaultTableModel(); // activities performed
         model.addColumn("#");
        model.addColumn("Activity Name");
        model.addColumn("Time(hrs)");
        model.addColumn("Calories Burned");
        //model.addRow(new Object[]{"Column 1","aaaa", "Column 3"});
    
        model2 = new DefaultTableModel(); // food ate
        model2.addColumn("#");
        model2.addColumn("Food Name");
        model2.addColumn("Servings");
        model2.addColumn("Calories Consumed");
        
       // model2.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
    
  activities_table = new JTable(model);
  activities_table.getColumnModel().getColumn(0).setPreferredWidth(1);
  activities_table.getColumnModel().getColumn(1).setPreferredWidth(80);
  activities_table.getColumnModel().getColumn(2).setPreferredWidth(30);

  food_table = new JTable(model2); // new
  food_table.getColumnModel().getColumn(0).setPreferredWidth(1);
  food_table.getColumnModel().getColumn(1).setPreferredWidth(100);
  food_table.getColumnModel().getColumn(2).setPreferredWidth(30);


  food_table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
  food_table.setEnabled(false);
  activities_table.setEnabled(false);




    clear_report = new JButton("Clear Report");

    scroller = new JScrollPane(Report,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroller_activity = new JScrollPane(activities_table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroller_food_eat =  new JScrollPane(food_table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    //activities_table.setValueAt("hiiii", 0, 0);
    //activities_table.getColumnModel().getColumn(0).setHeaderValue("New Name");
  //
  food_button.setEnabled(false);
  eat_button.setEnabled(false);
  activity_button.setEnabled(false);
  perform_button.setEnabled(false);
  mystery_button.setEnabled(false);
  report2_button.setEnabled(false);
  report_button.setEnabled(false);
  Report.setEditable(false);
  edit_food_ate_button.setEnabled(false);
  edit_activities_performed_button.setEnabled(false);
  clear_report.setEnabled(false);


 display_foodlist_button.setEnabled(false);
display_activities_button.setEnabled(false);
view_food_ate_button.setEnabled(false);
view_activities_performed_button.setEnabled(false);

 //
 
    }

    public void setUpGUI(){
        display_name.setText("");

        panel.setPreferredSize(new Dimension(300,800));
        panel2.setPreferredSize(new Dimension(300,800));
        panel3.setPreferredSize(new Dimension(780,15));
        panel4.setPreferredSize(new Dimension(380,800));
     
        report_receipt.setPreferredSize(new Dimension(100,100));
     panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
     panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
     panel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
     panel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        enter_button.setPreferredSize(new Dimension(80,50));
        food_button.setPreferredSize(new Dimension(140,140));
        activity_button.setPreferredSize(new Dimension(140,140));
        eat_button.setPreferredSize(new Dimension(140,140));
        perform_button.setPreferredSize(new Dimension(140,140));
        mystery_button.setPreferredSize(new Dimension(140,140));
        mystery_button.setPreferredSize(new Dimension(140,140));
        report2_button.setPreferredSize(new Dimension(140,140));
        report_button.setPreferredSize(new Dimension(280,140));
        edit_food_ate_button.setPreferredSize(new Dimension(150, 50));
        edit_activities_performed_button.setPreferredSize(new Dimension(150, 50));
        delete_food_ate_button.setPreferredSize(new Dimension(150, 30));
        delete_activities_performed_button.setPreferredSize(new Dimension(150, 30));
        view_activities_performed_button.setPreferredSize(new Dimension(100, 50));
        view_food_ate_button.setPreferredSize(new Dimension(100, 50));
        clear_report.setPreferredSize(new Dimension(360, 40));

        Report_name.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Report_name.setText("Report"); // NOI18N

        user_name_label.setPreferredSize(new Dimension(280,50));
        user_name_input.setPreferredSize(new Dimension(200,50));
        user_name_label.setText("Enter your name here below:");
        user_name_label.setFont(new java.awt.Font("Dialog", 1, 14));
        
       // food_list.setPreferredSize(new Dimension(400,300)); // JTEXT AREAS
        scroller_food_eat.setPreferredSize(new Dimension(400,300)); // updated
        scroller_activity.setPreferredSize(new Dimension(400,300)); //updated
        scroller.setPreferredSize(new Dimension(360,640)); //updated

        display_foodlist_button.setPreferredSize((new Dimension(50,50)));
        display_activities_button.setPreferredSize(((new Dimension(50,50))));

        Border etched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
       // food_list.setBorder(BorderFactory.createTitledBorder(
       //     etched, "Food List"));
        food_table.setBorder(BorderFactory.createTitledBorder(
            etched));

            Report.setBorder(BorderFactory.createTitledBorder(
                etched, "Results"));
                Report.setLineWrap(true);
                Report.setWrapStyleWord(true);
                Report.setEditable(false);
                Report.setFocusable(false); 

        // 
        frame.setSize(width,height);
        frame.setTitle("My Fitness Tracker (#221303) - TrackerApp GUI");
        panel.add(user_name_label);

        panel.add(user_name_input);
        panel.add(enter_button);
        panel.add(food_button, BorderLayout.WEST);
        panel.add(activity_button, BorderLayout.WEST);
        panel.add(eat_button);
        panel.add(perform_button);
        panel.add(mystery_button);
        panel.add(report2_button);
        panel.add(report_button);
     
        panel2.add(display_foodlist_button);
        panel2.add(view_food_ate_button);
        panel2.add(view_activities_performed_button);
        panel2.add(display_activities_button);

       // panel2.add(food_list);
       panel2.add(scroller_food_eat);
        panel2.add(edit_food_ate_button);
        panel2.add(edit_activities_performed_button);
        panel2.add(scroller_activity);




        panel3.add(display_name);


        panel4.add(Report_name);
        panel4.add(scroller); // originally Report
        panel4.add(clear_report);
      
        
        

       // panel2.add(report_button, BorderLayout.EAST);
        frame.add(panel, BorderLayout.WEST); // adding jpanel to jfram
        frame.add(panel3, BorderLayout.NORTH);
        frame.add(panel2); // adding jpanel to jframe
        frame.add(panel4, BorderLayout.EAST); // adding jpanel to jframe


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true); // to see the window haha

        //     jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

      //  AAA.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
       //  AAA.setText("CUSTOMER NAME: ");


    }


    public void EnterButton(){
        ActionListener EnterButton = new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent ae){
          
                if(ae.getSource()==enter_button && checker != 0){


                     String username_message =  user_name_input.getText();

                    if(username_message.isEmpty() || username_message.isBlank()){
                        JOptionPane.showMessageDialog(null,"Please input name!");

                    // user_name_input.setPreferredSize(new Dimension(200,50));

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Welcome " + username_message.substring(0,1).toUpperCase() + username_message.substring(1).toLowerCase() + "!");

                        report_message += "Welcome to " +input.capitalize(username_message)+ "'s Lifestyle Tracker!";
                        Report.setText(report_message);
    
                        checker = 0;

                        food_button.setEnabled(true);
  eat_button.setEnabled(true);
  activity_button.setEnabled(true);
  perform_button.setEnabled(true);
  mystery_button.setEnabled(true);
  report2_button.setEnabled(true);
  report_button.setEnabled(true);
  Report.setEditable(true);
  edit_food_ate_button.setEnabled(true);
  edit_activities_performed_button.setEnabled(true);
  clear_report.setEnabled(true);
  display_foodlist_button.setEnabled(true);
  display_activities_button.setEnabled(true);
  view_food_ate_button.setEnabled(true);
  view_activities_performed_button.setEnabled(true);
                    }

                   


                }



            

            }
        };

        enter_button.addActionListener(EnterButton);
    }
public void FoodButton(){
    ActionListener FoodButton = new ActionListener() {
        

        @Override // we need to override a method called actionPerformed; to define an already provided method
        public void actionPerformed(ActionEvent ae){// we can use actionevent object inside
            Object o = ae.getSource();

            input.checkArray_foodlist();


        String first_word = JOptionPane.showInputDialog("Enter Food name", "");
        String first_word_converter = first_word.substring(0,1).toUpperCase() + first_word.substring(1).toLowerCase();

        double second_word = Double.parseDouble(JOptionPane.showInputDialog("Enter Calorie value", ""));
        String message = "";
        message = input.addFood(first_word_converter, second_word);

        if(message.equalsIgnoreCase("Food cannot have negative calories.")){
            JOptionPane.showMessageDialog(null, message);

        }
        else{
            JOptionPane.showMessageDialog(null, message);
        }
       

        input.checkArray_foodlist();
            
        ArrayList<ArrayList<String>> view_food_list = input.checkArray_foodlist();
       
        model2.setNumRows(0);
        model2.setColumnCount(0);

        model2.addColumn("#");
        model2.addColumn("Food Name");
        model2.addColumn("Calories Consumed (/hr) ");
   

        for(int i = 0; i < view_food_list.size(); i++){

           model2.addRow(new Object[]{i, view_food_list.get(i).get(0),view_food_list.get(i).get(1) });


        }

          food_table.getColumnModel().getColumn(0).setPreferredWidth(10);
          food_table.getColumnModel().getColumn(1).setPreferredWidth(90);
          food_table.getColumnModel().getColumn(2).setPreferredWidth(90);


      //  TableColumn a = activities_table.getColumnModel().getColumn();
      //      activities_table.removeColumn(a);
      food_table.getTableHeader().repaint();
      food_table.getTableHeader().revalidate();


   DefaultTableModel tblModel = (DefaultTableModel)food_table.getModel();
   

   food_table.getTableHeader().repaint();
   food_table.getTableHeader().revalidate();
   DefaultTableModel model = (DefaultTableModel) food_table.getModel();

   model2.fireTableDataChanged();



     
/* 
 
   if(first_word_converter.equalsIgnoreCase("Food")){
                 second_word_name = in.next().toLowerCase(); 
                  second_word_name_converter = second_word_name.substring(0,1).toUpperCase() + second_word_name.substring(1).toLowerCase();
                 third_word_CSH = in.nextDouble();

                  message = input.addFood(second_word_name_converter, third_word_CSH);

                System.out.println(message);
            }


 */



        }
        

};
food_button.addActionListener(FoodButton);

    // One buttonlistener can be connected to multiple button sources

 

}


public void EatButton(){
    ActionListener EatButton = new ActionListener() {

        @Override // we need to override a method called actionPerformed; to define an already provided method
        public void actionPerformed(ActionEvent ae){// we can use actionevent object inside
            Object o = ae.getSource();

            input.checkArray_foodate();
            input.checkArray_foodlist();

        String first_word = JOptionPane.showInputDialog("Enter food you want to eat", "");
        String first_word_converter = first_word.substring(0,1).toUpperCase() + first_word.substring(1).toLowerCase();
        double second_word = Double.parseDouble(JOptionPane.showInputDialog("Enter servings", ""));

        String message = input.eat(first_word_converter, second_word);
        
     
        if(message.equalsIgnoreCase("The specified food does not exist.")){ // "yet"

        int choice = JOptionPane.showConfirmDialog(null, "Specified food does not exist. Do you want to add it to the menu?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);


        if(choice == 0) { // yes
           
            double third_word = Double.parseDouble(JOptionPane.showInputDialog("Enter calorie servings", "")); 
            String message4 = input.addFood(first_word_converter, third_word);
            String message2 = input.eat(first_word_converter, second_word);

            JOptionPane.showMessageDialog(null, message4);
            JOptionPane.showMessageDialog(null, message2);

           

      // model2.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});

                //     model.setValueAt("naurrr", 0, 1);
       //     activities_table.getColumnModel().getColumn(1).setHeaderValue("Titt");
       //     activities_table.getTableHeader().repaint();

        //    TableColumn a = activities_table.getColumnModel().getColumn(4);
       //     activities_table.removeColumn(a);


          } else {
            System.out.println("No Option");

         
          } 


        }
        else if(message.equalsIgnoreCase("Number of servings cannot be negative or zero.")){
            JOptionPane.showMessageDialog(null, message);

        }
        else{
            JOptionPane.showMessageDialog(null, message);

        }

        input.checkArray_foodate();
        input.checkArray_foodlist();
                    
                    ArrayList<ArrayList<String>> view_food_eaten = input.checkArray_foodate();
                   
                    model2.setNumRows(0);
                    model2.setColumnCount(0);
        
        
                    model2.addColumn("#");
                model2.addColumn("Food Name");
                model2.addColumn("Servings");
                model2.addColumn("Calories Consumed");
        
                   
                    for(int i = 0; i< view_food_eaten.size(); i++){
        
                        model2.addRow(new Object[]{i, view_food_eaten.get(i).get(0),view_food_eaten.get(i).get(1), view_food_eaten.get(i).get(2) });
        
        
                    }
        
                    food_table.getColumnModel().getColumn(0).setPreferredWidth(1);
                    food_table.getColumnModel().getColumn(1).setPreferredWidth(80);
                    food_table.getColumnModel().getColumn(2).setPreferredWidth(30);
        
                  //  TableColumn a = activities_table.getColumnModel().getColumn();
                  //      activities_table.removeColumn(a);
                  food_table.getTableHeader().repaint();
                  food_table.getTableHeader().revalidate();
        
        
               DefaultTableModel tblModel = (DefaultTableModel)food_table.getModel();
               
        
               food_table.getTableHeader().repaint();
               food_table.getTableHeader().revalidate();
               DefaultTableModel model = (DefaultTableModel) food_table.getModel();
        
               model2.fireTableDataChanged();
        
        
         /* 
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

         */   

        }
};
eat_button.addActionListener(EatButton);
}



public void View_Food_Eaten_Button(){

    ActionListener View_Food_Eaten_Button = new ActionListener(){

@Override
public void actionPerformed(ActionEvent ae){

    input.checkArray_foodate();
input.checkArray_foodlist();
            
            ArrayList<ArrayList<String>> view_food_eaten = input.checkArray_foodate();
           
            model2.setNumRows(0);
            model2.setColumnCount(0);


            model2.addColumn("#");
        model2.addColumn("Food Name");
        model2.addColumn("Servings");
        model2.addColumn("Calories Consumed");

           
            for(int i = 0; i< view_food_eaten.size(); i++){

                model2.addRow(new Object[]{i, view_food_eaten.get(i).get(0),view_food_eaten.get(i).get(1), view_food_eaten.get(i).get(2) });


            }

            food_table.getColumnModel().getColumn(0).setPreferredWidth(1);
            food_table.getColumnModel().getColumn(1).setPreferredWidth(80);
            food_table.getColumnModel().getColumn(2).setPreferredWidth(30);

          //  TableColumn a = activities_table.getColumnModel().getColumn();
          //      activities_table.removeColumn(a);
          food_table.getTableHeader().repaint();
          food_table.getTableHeader().revalidate();


       DefaultTableModel tblModel = (DefaultTableModel)food_table.getModel();
       

       food_table.getTableHeader().repaint();
       food_table.getTableHeader().revalidate();
       DefaultTableModel model = (DefaultTableModel) food_table.getModel();

       model2.fireTableDataChanged();




}

    };
    view_food_ate_button.addActionListener(View_Food_Eaten_Button);
}

public void View_Food_List(){

    ActionListener View_Food_List = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae){


            input.checkArray_foodlist();
            
            ArrayList<ArrayList<String>> view_food_list = input.checkArray_foodlist();
           
            model2.setNumRows(0);
            model2.setColumnCount(0);

            model2.addColumn("#");
            model2.addColumn("Food Name");
            model2.addColumn("Calories Consumed (/hr) ");
       

            for(int i = 0; i < view_food_list.size(); i++){

               model2.addRow(new Object[]{i, view_food_list.get(i).get(0),view_food_list.get(i).get(1) });


            }

              food_table.getColumnModel().getColumn(0).setPreferredWidth(10);
              food_table.getColumnModel().getColumn(1).setPreferredWidth(90);
              food_table.getColumnModel().getColumn(2).setPreferredWidth(90);


          //  TableColumn a = activities_table.getColumnModel().getColumn();
          //      activities_table.removeColumn(a);
          food_table.getTableHeader().repaint();
          food_table.getTableHeader().revalidate();


       DefaultTableModel tblModel = (DefaultTableModel)food_table.getModel();
       

       food_table.getTableHeader().repaint();
       food_table.getTableHeader().revalidate();
       DefaultTableModel model = (DefaultTableModel) food_table.getModel();

       model2.fireTableDataChanged();


        }

    };
    display_foodlist_button.addActionListener(View_Food_List);
}

public void View_Activities_Performed_Button(){

    ActionListener View_Activities_Performed_Button = new ActionListener() {

        @Override // we need to override a method called actionPerformed; to define an already provided method
        public void actionPerformed(ActionEvent ae){
                        
input.checkArray_activities_done();
input.checkArray_activities();
            
            ArrayList<ArrayList<String>> view_activities_performed = input.checkArray_activities_done();
           
            model.setNumRows(0);
            model.setColumnCount(0);


            model.addColumn("#");
            model.addColumn("Activity Name");
            model.addColumn("Time(hrs)");
            model.addColumn("Calories Burned");

           
            for(int i = 0; i< view_activities_performed.size(); i++){

               model.addRow(new Object[]{i, view_activities_performed.get(i).get(0),view_activities_performed.get(i).get(1), view_activities_performed.get(i).get(2) });


            }

            activities_table.getColumnModel().getColumn(0).setPreferredWidth(1);
            activities_table.getColumnModel().getColumn(1).setPreferredWidth(80);
            activities_table.getColumnModel().getColumn(2).setPreferredWidth(30);

          //  TableColumn a = activities_table.getColumnModel().getColumn();
          //      activities_table.removeColumn(a);
            activities_table.getTableHeader().repaint();
            activities_table.getTableHeader().revalidate();


       DefaultTableModel tblModel = (DefaultTableModel)activities_table.getModel();
       

       activities_table.getTableHeader().repaint();
       activities_table.getTableHeader().revalidate();
       DefaultTableModel model = (DefaultTableModel) activities_table.getModel();

       model.fireTableDataChanged();




/* 
   //     model.setValueAt("naurrr", 0, 1);
       //     activities_table.getColumnModel().getColumn(1).setHeaderValue("Titt");
       //     activities_table.getTableHeader().repaint();

        //    TableColumn a = activities_table.getColumnModel().getColumn(4);
       //     activities_table.removeColumn(a);

//TableColumn tcol = table.getColumnModel().getColumn(col_index);
// table.removeColumn(tcol); 

  String tblname = tblModel.getValueAt(activities_table.getSelectedRow(), 0).toString();
        String tblSubject = tblModel.getValueAt(activities_table.getSelectedRow(), 1).toString();
        String tblcode = tblModel.getValueAt(activities_table.getSelectedRow(),2).toString();

           activities_table.getColumnModel().getColumn(1).setHeaderValue("TITE");

             activities_table.setValueAt(view_activities_performed.get(0).get(0), 0, 0);


 */
      
           
            // we can use actionevent object inside
        }

    };

    view_activities_performed_button.addActionListener(View_Activities_Performed_Button);


}


public void ViewActivitiesButton(){

    ActionListener ViewActivitiesButton = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae){

            input.checkArray_activities();
            
            ArrayList<ArrayList<String>> view_activities = input.checkArray_activities();
           
            model.setNumRows(0);
            model.setColumnCount(0);

            model.addColumn("#");
            model.addColumn("Activity Name");
            model.addColumn("Calories Burned (/hr) ");
       


            for(int i = 0; i< view_activities.size(); i++){

               model.addRow(new Object[]{i, view_activities.get(i).get(0),view_activities.get(i).get(1) });


            }

              activities_table.getColumnModel().getColumn(0).setPreferredWidth(10);
            activities_table.getColumnModel().getColumn(1).setPreferredWidth(90);
            activities_table.getColumnModel().getColumn(2).setPreferredWidth(90);


          //  TableColumn a = activities_table.getColumnModel().getColumn();
          //      activities_table.removeColumn(a);
            activities_table.getTableHeader().repaint();
            activities_table.getTableHeader().revalidate();


       DefaultTableModel tblModel = (DefaultTableModel)activities_table.getModel();
       

       activities_table.getTableHeader().repaint();
       activities_table.getTableHeader().revalidate();
       DefaultTableModel model = (DefaultTableModel) activities_table.getModel();

       model.fireTableDataChanged();


        }

    };
    display_activities_button.addActionListener(ViewActivitiesButton);

}
public void ActivityButton(){
    ActionListener ActivityButton = new ActionListener() {

        

        @Override // we need to override a method called actionPerformed; to define an already provided method
        public void actionPerformed(ActionEvent ae){// we can use actionevent object inside
            
            
          
            String first_word = JOptionPane.showInputDialog("Enter Activity name", "");
            String first_word_converter = first_word.substring(0,1).toUpperCase() + first_word.substring(1).toLowerCase();
    
            double second_word = Double.parseDouble(JOptionPane.showInputDialog("Enter Calorie value", ""));
    
            String message = input.addActivity(first_word_converter, second_word);
    
            if(message.equalsIgnoreCase("Activity cannot have negative calories.")){
                JOptionPane.showMessageDialog(null, message);

            }
            else{
                JOptionPane.showMessageDialog(null, message);

            }

           
            input.checkArray_activities();
            
            ArrayList<ArrayList<String>> view_activities = input.checkArray_activities();
           
            model.setNumRows(0);
            model.setColumnCount(0);

            model.addColumn("#");
            model.addColumn("Activity Name");
            model.addColumn("Calories Burned (/hr) ");
       


            for(int i = 0; i< view_activities.size(); i++){

               model.addRow(new Object[]{i, view_activities.get(i).get(0),view_activities.get(i).get(1) });


            }

              activities_table.getColumnModel().getColumn(0).setPreferredWidth(10);
            activities_table.getColumnModel().getColumn(1).setPreferredWidth(90);
            activities_table.getColumnModel().getColumn(2).setPreferredWidth(90);


          //  TableColumn a = activities_table.getColumnModel().getColumn();
          //      activities_table.removeColumn(a);
            activities_table.getTableHeader().repaint();
            activities_table.getTableHeader().revalidate();


       DefaultTableModel tblModel = (DefaultTableModel)activities_table.getModel();
       

       activities_table.getTableHeader().repaint();
       activities_table.getTableHeader().revalidate();
       DefaultTableModel model = (DefaultTableModel) activities_table.getModel();

       model.fireTableDataChanged();




        }
};
activity_button.addActionListener(ActivityButton);

}

public void PerformButton(){

    ActionListener PerformButton = new ActionListener(){
        @Override 
        public void actionPerformed(ActionEvent ae){
        

            

            override = "no";

/* 
 ArrayList<ArrayList<String>> view_activities = input.checkArray_activities_done();

  model.setNumRows(0);
             model.setColumnCount(0);

             model.addColumn("#");
             model.addColumn("Activity Name");
             model.addColumn("Time (hour/s)");
             activities_table.getColumnModel().getColumn(0).setHeaderValue("#");
             activities_table.getColumnModel().getColumn(1).setHeaderValue("Activity Name");
             activities_table.getColumnModel().getColumn(2).setHeaderValue("Calories burned (/hr)");

             for(int i = 0; i< input.checkArray_activities_done().size(); i++){

                model.addRow(new Object[]{i, view_activities.get(i).get(0),view_activities.get(i).get(1) });


             }

*/
            
input.checkArray_activities_done();
input.checkArray_activities();



            String first_word = JOptionPane.showInputDialog("Enter Activity name", "");
            String first_word_converter = first_word.substring(0,1).toUpperCase() + first_word.substring(1).toLowerCase();
    
            double second_word = Double.parseDouble(JOptionPane.showInputDialog("Enter Hours Performed", ""));

            String message = input.perform(first_word_converter, second_word, override);



            if(message.equalsIgnoreCase("The specified activity does not exist.")){

                int choice = JOptionPane.showConfirmDialog(null, "Specified activity does not exist. Do you want to add it to the menu?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);


                if(choice == 0) { // yes
                   
                    double third_word = Double.parseDouble(JOptionPane.showInputDialog("Enter calories burned per hour", "")); 
                    message = input.addActivity(first_word_converter, third_word);
                    String message2 = input.perform(first_word_converter, second_word, override);
                    
                    if(message2.equalsIgnoreCase("Activity cannot have negative calories.")){
                        JOptionPane.showMessageDialog(null, message);

                    }
                    else{
                        JOptionPane.showMessageDialog(null, message);
                        JOptionPane.showMessageDialog(null, message2);
                    }
                  

            }

        }
        else if(message.equalsIgnoreCase("Cannot further perform (or add) activity. Activities recorded are only for the day, meaning there can only be 24 hrs worth of activity max. Do you want to override it (Y/N)? ")){

            int choice = JOptionPane.showConfirmDialog(null, "You have already period 24 hours worth of activity. Do you want to override it? ", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
         
            if(choice == 0) { // yes
                override = "yes";
                
                String message3 = input.perform(first_word_converter, second_word, override);
                 JOptionPane.showMessageDialog(null, "System has been overriden");
     
                if(message3.equalsIgnoreCase("The specified activity does not exist.")){

                    int choice2 = JOptionPane.showConfirmDialog(null, "Specified activity does not exist. Do you want to add it to the menu?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if(choice2 == 0) { // yes
                   
                        double third_word = Double.parseDouble(JOptionPane.showInputDialog("Enter calories burned per hour", "")); 
                        message = input.addActivity(first_word_converter, third_word);
                        String message2 = input.perform(first_word_converter, second_word, override);
            
                        if(message2.equalsIgnoreCase("Activity cannot have negative calories.")){
                            JOptionPane.showMessageDialog(null, message);
    
                        }
                        else{
                            JOptionPane.showMessageDialog(null, message);
                            JOptionPane.showMessageDialog(null, message2);
                        }
                }
                }
                override = "no";

            }
            else{
                JOptionPane.showMessageDialog(null, "System has not been overriden");

            }

            

           

            
       

        }
        else if(message.equalsIgnoreCase("Number of hours cannot be negative or zero.")){
            JOptionPane.showMessageDialog(null, message);

        }

       
        ArrayList<ArrayList<String>> view_activities_performed = input.checkArray_activities_done();
       
        model.setNumRows(0);
        model.setColumnCount(0);


        model.addColumn("#");
        model.addColumn("Activity Name");
        model.addColumn("Time(hrs)");
        model.addColumn("Calories Burned");

       
        for(int i = 0; i< view_activities_performed.size(); i++){

           model.addRow(new Object[]{i, view_activities_performed.get(i).get(0),view_activities_performed.get(i).get(1), view_activities_performed.get(i).get(2) });


        }

        activities_table.getColumnModel().getColumn(0).setPreferredWidth(1);
        activities_table.getColumnModel().getColumn(1).setPreferredWidth(80);
        activities_table.getColumnModel().getColumn(2).setPreferredWidth(30);

      //  TableColumn a = activities_table.getColumnModel().getColumn();
      //      activities_table.removeColumn(a);
        activities_table.getTableHeader().repaint();
        activities_table.getTableHeader().revalidate();


   DefaultTableModel tblModel = (DefaultTableModel)activities_table.getModel();
   

   activities_table.getTableHeader().repaint();
   activities_table.getTableHeader().revalidate();
   DefaultTableModel model = (DefaultTableModel) activities_table.getModel();

   model.fireTableDataChanged();





        }
        
/* 
 
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
 */

        
    };

    perform_button.addActionListener(PerformButton);

}

public void EditFoodButton(){

   // edit_food_ate_button
   ActionListener EditFoodButton = new ActionListener() {

    @Override // we need to override a method called actionPerformed; to define an already provided method
    public void actionPerformed(ActionEvent ae){// 
       
        Object[] options1 = {"Update", "Delete"};

       int a = JOptionPane.showOptionDialog(null,
        "Choose between the two options below",
        "Edit the List of Food Eaten",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        null,
        options1,
        null);

        ArrayList<ArrayList<String>> viewfoodate = input.checkArray_foodate();

        if(a == 0){

            if(viewfoodate.isEmpty()){
                JOptionPane.showMessageDialog(null,"Food Eaten is still empty.");

            }else{


            
            JOptionPane.showMessageDialog(null, "You have chosen Update");
            String first_worda = JOptionPane.showInputDialog("Select record # to edit", "");
            String response = input.edit_data_foodate(first_worda);

           
             if(response.equalsIgnoreCase("Congrats the index is found.")){

                String foodname = JOptionPane.showInputDialog("Type new name of food", "");
                String foodname_converter = foodname.substring(0,1).toUpperCase() + foodname.substring(1).toLowerCase();
                int ch = 1;
                for(int i = 0; i < input.checkArray_foodlist().size(); i++){

                    if(input.checkArray_foodlist().get(i).get(0).contains(foodname_converter)){
                     //   JOptionPane.showMessageDialog(null, "Food item is here");
                        ch = 0;
                    }
                    

                }
                if(ch != 0){
                  //  JOptionPane.showMessageDialog(null, "Food item is not here. ");
                    String calories = JOptionPane.showInputDialog("Type new amount of calories", "");

                    if(input.addFood(foodname_converter, Double.parseDouble(calories)).equalsIgnoreCase("Food cannot have negative calories.")){
                        JOptionPane.showMessageDialog(null,input.addFood(foodname_converter, Double.parseDouble(calories)));
                     

                    }
                    else{

                        String second_word = JOptionPane.showInputDialog("Type new amount of servings", "");
                        if(Double.parseDouble(second_word) <= 0){
                            JOptionPane.showMessageDialog(null,"Servings cannot be negative or zero.");
        
                        }else{
                            input.addFood(foodname_converter, Double.parseDouble(calories));
                            input.checkArray_foodlist();
                            input.checkArray_foodate();
                            input.edit_data_foodate_edit(Integer.parseInt(first_worda), Double.parseDouble(second_word), foodname_converter);
                            
                        }
                       
                    }
                    
                }
                else{

                    String second_word = JOptionPane.showInputDialog("Type new amount of servings", "");
                    if(Double.parseDouble(second_word) <= 0){
                        JOptionPane.showMessageDialog(null,"Servings cannot be negative or zero.");
    
                    }else{

                        input.checkArray_foodlist();
                        input.checkArray_foodate();
                        input.edit_data_foodate_edit(Integer.parseInt(first_worda), Double.parseDouble(second_word), foodname_converter);
                        
                    }
                }

             
                    
             

            }
            else{
                JOptionPane.showMessageDialog(null, "Index not found.");

            }


       
        }

        }
        else if(a==1){

            if(viewfoodate.isEmpty()){
                JOptionPane.showMessageDialog(null,"Food Eaten is still empty.");

            }else{
            JOptionPane.showMessageDialog(null, "You have chosen Delete");
            String first_word = JOptionPane.showInputDialog("Select record # to edit", "");
            String response = input.edit_data_foodate(first_word);

            if(response.equalsIgnoreCase("Congrats the index is found.")){
                input.foodate_remover(Integer.parseInt(first_word)); 
                JOptionPane.showMessageDialog(null, "Successfully removed.");

                
            }
            else{
                JOptionPane.showMessageDialog(null, "Index not found.");

            }


        }}

        model2.setNumRows(0);
    
        for(int j = 0; j < viewfoodate.size(); j++){
            model2.addRow(new Object[]{j, viewfoodate.get(j).get(0),viewfoodate.get(j).get(1), viewfoodate.get(j).get(2) });

        }

    }
};
edit_food_ate_button.addActionListener(EditFoodButton);

}

public void EditActivityButton(){
    ActionListener EditActivityButton = new ActionListener() {
        @Override // we need to override a method called actionPerformed; to define an already provided method
        public void actionPerformed(ActionEvent ae){// we can use actionevent object inside


/*

            String first_word = JOptionPane.showInputDialog("Enter Activity name", "");
            String first_word_converter = first_word.substring(0,1).toUpperCase() + first_word.substring(1).toLowerCase();
    
            double second_word = Double.parseDouble(JOptionPane.showInputDialog("Enter Hours Performed", ""));

            String message = input.perform(first_word_converter, second_word, override);


            if(message.equalsIgnoreCase("The specified activity does not exist.")){

                int choice = JOptionPane.showConfirmDialog(null, "Specified activity does not exist. Do you want to add it to the menu?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(choice == 0) { // yes
                   
                    double third_word = Double.parseDouble(JOptionPane.showInputDialog("Enter calories burned per hour", "")); 
                    message = input.addActivity(first_word_converter, third_word);
                    String message2 = input.perform(first_word_converter, second_word, override);
        
                    JOptionPane.showMessageDialog(null, message);
                    JOptionPane.showMessageDialog(null, message2);
            }

        }
        else if(message.equalsIgnoreCase("Cannot further perform (or add) activity. Activities recorded are only for the day, meaning there can only be 24 hrs worth of activity max. Do you want to override it (Y/N)? ")){

            int choice = JOptionPane.showConfirmDialog(null, "You have already period 24 hours worth of activity. Do you want to override it? ", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(choice == 0) { // yes
                override = "yes";
                
                String message3 = input.perform(first_word_converter, second_word, override);
                 JOptionPane.showMessageDialog(null, "System has been overriden");
     
                if(message3.equalsIgnoreCase("The specified activity does not exist.")){

                    int choice2 = JOptionPane.showConfirmDialog(null, "Specified activity does not exist. Do you want to add it to the menu?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if(choice2 == 0) { // yes
                   
                        double third_word = Double.parseDouble(JOptionPane.showInputDialog("Enter calories burned per hour", "")); 
                        message = input.addActivity(first_word_converter, third_word);
                        String message2 = input.perform(first_word_converter, second_word, override);
            
                        JOptionPane.showMessageDialog(null, message);
                        JOptionPane.showMessageDialog(null, message2);
    
                }
                }


            }
            else{
                JOptionPane.showMessageDialog(null, "System has not been overriden");

            } 

 */
            override = "no";
            Object[] options1 = {"Update", "Delete"};

            int a = JOptionPane.showOptionDialog(null,
             "Choose between the two options below",
             "Edit the List of Activities Performed",
             JOptionPane.YES_NO_CANCEL_OPTION,
             JOptionPane.PLAIN_MESSAGE,
             null,
             options1,
             null);
     
             ArrayList<ArrayList<String>> viewactivityperformed = input.checkArray_activities_done();
     
             if(a == 0){
     
                 if(viewactivityperformed.isEmpty()){
                     JOptionPane.showMessageDialog(null,"Activities Performed is still empty.");
     
                 }else{
     
    
                 
                 JOptionPane.showMessageDialog(null, "You have chosen Update");
                
                 String first_worda = JOptionPane.showInputDialog("Select record # to edit", "");
                 String response = input.edit_data_activitiesdone(first_worda);
                 String empty = "";
                
                  if(response.equalsIgnoreCase("Congrats the index is found.")){





                    override = "no";

                String activityname = JOptionPane.showInputDialog("Type new name of Activity", "");
                String activityname_converter = activityname.substring(0,1).toUpperCase() + activityname.substring(1).toLowerCase();

                int ch = 1;
                for(int i = 0; i < input.checkArray_activities().size(); i++){

                    if(input.checkArray_activities().get(i).get(0).contains(activityname_converter)){
                        ch = 0;
                    }
                }

                if(ch != 0){

                    String calories = JOptionPane.showInputDialog("Type new amount of calories", "");
                    if( input.addActivity(activityname_converter, Double.parseDouble(calories)).equalsIgnoreCase("Activity cannot have negative calories.")){
                        JOptionPane.showMessageDialog(null,"Activity cannot have negative calories.");

                    }
                    
                }


                String second_word = JOptionPane.showInputDialog("Type new amount of time (hours)", "");
                input.checkArray_activities();
                input.checkArray_activities_done();
                String message1 = input.edit_data_activitiesdone_edit(Integer.parseInt(first_worda), Double.parseDouble(second_word), override, activityname_converter);


            
                    if(message1.equalsIgnoreCase("Cannot further perform/add/edit this activity. Activities recorded are only for the day, meaning there can only be 24 hrs worth of activity max. Do you want to override it (Y/N)?")){

                        int choice = JOptionPane.showConfirmDialog(null, "You have already period 24 hours worth of activity. Do you want to override it? ", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
         
                        if(choice == 0) { // yes
                            override = "yes";
                            
                            empty = second_word;
                            input.edit_data_activitiesdone_edit(Integer.parseInt(first_worda), Double.parseDouble(second_word), override, activityname_converter);

                             JOptionPane.showMessageDialog(null, "System has been overriden");
                             override = "no";
                        }

                    }

                  
                 }
               
                 else{

                     JOptionPane.showMessageDialog(null, "Index not found.");
     
                 }
     
     
            
             }
     
             }
             else if(a==1){
     
                 if(viewactivityperformed.isEmpty()){
                     JOptionPane.showMessageDialog(null,"Activities Performed is still empty.");
                     
                 }else{
                 JOptionPane.showMessageDialog(null, "You have chosen Delete");
                 String first_word = JOptionPane.showInputDialog("Select record # to delete", "");
                 String response = input.edit_data_activitiesdone(first_word);
     
                 if(response.equalsIgnoreCase("Congrats the index is found.")){
                     input.activities_done_remover(Integer.parseInt(first_word)); 
                     JOptionPane.showMessageDialog(null, "Successfully removed.");
                    
                     
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "Index not found.");
     
                 }
     
     
             }
            
            
            
            }
     
            model.setNumRows(0);
    
            for(int j = 0; j < viewactivityperformed.size(); j++){
                model.addRow(new Object[]{j, viewactivityperformed.get(j).get(0),viewactivityperformed.get(j).get(1), viewactivityperformed.get(j).get(2) });
    
            }




        }
    };

edit_activities_performed_button.addActionListener(EditActivityButton);

}

public void MysteryButton(){
    ActionListener MysteryButton = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){



            Object[] options1 = {"Male", "Female"};

       int gender = JOptionPane.showOptionDialog(null,
        "Choose your gender",
        "Gender",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        null,
        options1,
        null);
String gender_choice = "";
        if(gender ==0){
         gender_choice = "M";
            
        }
        else if(gender==1){
            gender_choice = "F";

        }

        String Age = JOptionPane.showInputDialog("Enter Age (in years)", "");

        String Height = JOptionPane.showInputDialog("Enter Height (e.g. 5'5)", "");

        String[] height_list = Height.split("'");
        feet = Double.parseDouble(height_list[0])/ 3.281;
        inches = Double.parseDouble(height_list[1]) / 39.37;

        input.height_recorder(height_list[0], height_list[1]);

        String Weight = JOptionPane.showInputDialog("Enter Weight in kg. (e.g. 50.75) ", "");

        input.bmi_calculator(Double.parseDouble(Weight), feet, inches);

        
        input.bmr_calculator(Double.parseDouble(Weight), gender_choice, feet, inches, Integer.parseInt(Age));


        Object[] options2 = {"Gain", "Lose"};

        int weight_goal_type = JOptionPane.showOptionDialog(null,
         "Choose your goal type",
         "Weight Goal Type",
         JOptionPane.YES_NO_CANCEL_OPTION,
         JOptionPane.PLAIN_MESSAGE,
         null,
         options2,
         null);

         String weight_goaltype = "";
         if(weight_goal_type ==0){
            weight_goaltype = "Gain";
               
           }
           else if(weight_goal_type==1){
            weight_goaltype = "Lose";
   
           }

boolean checkerweight = true;
while(checkerweight = true){


         String TargetWeight = JOptionPane.showInputDialog("Enter Target Weight in kg (e.g. 69.50)", "");
        

         if(!input.weightgoal_checker(weight_goaltype, Double.parseDouble(Weight),Double.parseDouble(TargetWeight) ).equalsIgnoreCase("success")){
            System.out.println(input.weightgoal_checker(weight_goaltype, Double.parseDouble(Weight),Double.parseDouble(TargetWeight) ));
            
            JOptionPane.showMessageDialog(null, input.weightgoal_checker(weight_goaltype, Double.parseDouble(Weight),Double.parseDouble(TargetWeight)));
            continue;
            //
        }
        else{


            input.weightgoal_checker(weight_goaltype, Double.parseDouble(Weight),Double.parseDouble(TargetWeight)); 
            String Time_period = JOptionPane.showInputDialog("Enter Target Time to Achieve Goal \n (e.g. 5 weeks/days/months)", "" );
            String[] Time_period_list = Time_period.split(" ");
    
            System.out.printf("First: %8s Second: %4s ", Time_period_list[0],Time_period_list[1]);
    
            input.time_converter(Time_period_list[1], Double.parseDouble(Time_period_list[0]));
            input.trio_calorie_calculator();
            input.activity_level();

            mystery_unlocker = "unlocked";
            checkerweight = false;
            JOptionPane.showMessageDialog(null, "Success: All inputs have been recorded!");

            break;
        }

    }



       



//                 String[] height_split = height.split("'");



        }
    };
    mystery_button.addActionListener(MysteryButton);

}
public void MysteryReportButton(){
    ActionListener MysteryReportButton = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){

            report_message = "";

            if(mystery_unlocker.equalsIgnoreCase("locked")){
                JOptionPane.showMessageDialog(null, "Can't access this without entering mystery mode.\n Hint: Press Mystery Button");


            }
            else{

                if(ae.getSource()==report2_button){
                    report_message = "";
                    Report.setText("");
                    Report.selectAll();
                    Report.replaceSelection("");
    
            }
    
                Report.selectAll();
                Report.replaceSelection("");
                report_message += input.mystery_report_();
               Report.setText(report_message);
               // message = input.mystery_report();
            }

            report_message = "";
           
 
    

        }
    };
    report2_button.addActionListener(MysteryReportButton);
}

public void ReportButton(){
    ActionListener ReportButton = new ActionListener() {

        @Override // we need to override a method called actionPerformed; to define an already provided method
        public void actionPerformed(ActionEvent ae){// we can use actionevent object inside

       //     model.setValueAt("naurrr", 0, 1);
       //     activities_table.getColumnModel().getColumn(1).setHeaderValue("Titt");
       //     activities_table.getTableHeader().repaint();

        //    TableColumn a = activities_table.getColumnModel().getColumn(4);
       //     activities_table.removeColumn(a);

//TableColumn tcol = table.getColumnModel().getColumn(col_index);
// table.removeColumn(tcol); 
  
report_message = "";
           if(ae.getSource()==report_button){
                Report.setText("");
                Report.selectAll();
                Report.replaceSelection("");


        }

            Report.selectAll();
            Report.replaceSelection("");
            report_message += "Welcome to " +input.capitalize(user_name_input.getText())+ "'s Lifestyle Tracker! \n";
            report_message +=  input.report();
           Report.setText(report_message);
           // message = input.mystery_report();

    }

};
report_button.addActionListener(ReportButton);


}

public void ClearButton(){
 ActionListener ClearButton = new ActionListener() {

        @Override // we need to override a method called actionPerformed; to define an already provided method
        public void actionPerformed(ActionEvent ae){// we can use actionevent object inside

            if(ae.getSource()==clear_report){
                Report.setText("");
                Report.selectAll();
                Report.replaceSelection("");


        }

          

    }

};
clear_report.addActionListener(ClearButton);

}
}