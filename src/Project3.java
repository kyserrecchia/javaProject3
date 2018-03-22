//KYLE SERRECCHIA
//CS111 LAB PROJECT 3
//MAR 23, 2018

import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Project3 {
    
    final static int MIN_NUMBER = 1;
    final static int MAX_NUMBER = 8;
    static int image_number = 1;

    public static int forward ( int current_number ) {
        if(MIN_NUMBER <= current_number && current_number <= MAX_NUMBER){
            if(current_number == MAX_NUMBER){
                return MIN_NUMBER;
            }
            else{
                return current_number + 1;
            }
        }
        else{
            System.out.println("ERROR: current_number out of range!");
            return currrent_number;
        }
    }
    
    public static void forward (  ) {
        // overloaded method, use global variable as input and output
        if(image_number == MAX_NUMBER){
            image_number = MIN_NUMBER;
        }
        else{
            image_number = image_number + 1;
        }
    }

    public static int backward ( int current_number ) {
        if(MIN_NUMBER <= current_number && current_number <= MAX_NUMBER){
            if(current_number == MIN_NUMBER){
                return current_number;
            }
            else{
                return current_number - 1;
            }
        }
        else{
            System.out.println("ERROR: current_number out of range!");
            return current_number;
        }
    }

    public static void backward (  ) {
        if(image_number != MIN_NUMBER){
            image_number = image_number - 1;
        }
    }

        
    public static JLabel load_picture(String imagefile){

        JLabel templabel = null;

        String startURL = "";
        if (!imagefile.startsWith("http"))
           startURL = "http://www.canyons.edu/Departments/CMPSCI/Documents/ferguson/cs111/images/";

        URL myURL=null;
        try
        {
          myURL = new URL(startURL + imagefile);
          BufferedImage myPicture = ImageIO.read(myURL);
          templabel = new JLabel(new ImageIcon(myPicture));
        }
        catch(Exception e) {
          System.out.println("Error caught " + e.toString());
        }

        return templabel;
    }
    
    public static void showWindow ( String filename ) {   
    // create, size and show a GUI window frame, you may need to click on taskbar to see window
	//display the filename in the title of the window frame, otherwise the window will be blank (for now)
        JFrame frame1 = new JFrame();
        JLabel thelabel = new JLabel();
        thelabel = load_picture(filename);
        frame1.add(thelabel);
        frame1.setTitle("MENU");
        FlowLayout layout = new FlowLayout();
        frame1.setLayout(layout);
        frame1.setSize(1000, 500);
        frame1.setLocation(0, 0);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
    
    
    public static String createFileName ( int current_number ) {
        String file = "picture" + current_number + ".gif";
        if(MIN_NUMBER <= current_number && current_number <= MAX_NUMBER){
            showWindow(file);
            return file;
        }
        else{
            return "ERROR: current_number out of range!";
        }
    }

    public static String createRandomName (  ) {
            Random rand = new Random();
            int num = rand.nextInt(8) + 1;
            String file = "picture" + num + ".gif";
            showWindow(file);
            return file;
    }
    
    public static String getAnyImage ( ) {
       String url;
       System.out.println("Enter the url for the desired image");
       Scanner input = new Scanner(System.in);
       url = input.next();
       showWindow(url);
       
       return url;
    }
    
    public static void makeMenu(){
            System.out.println("|*=========================================*|");
            System.out.println("|                    MENU                   |");
            System.out.println("|  =======================================  |");
            System.out.println("|                                           |");
            System.out.println("|  ENTER GIVEN NUMBER FOR DESIRED FUNCTION  |");
            System.out.println("|  =======================================  |");
            System.out.println("|                                           |");
            System.out.println("|      NUMBER                FUNCTION       |");
            System.out.println("|      ======                ========       |");
            System.out.println("|       0,4                   FORWARD       |");
            System.out.println("|       1,5                   BACKWARD      |");
            System.out.println("|        2                CREATE FILE NAME  |");
            System.out.println("|        3              CREATE RANDOM NAME  |");
            System.out.println("|        6                  SHOW WINDOW     |");
            System.out.println("|        7                    ANY PIC       |");
            System.out.println("|        8                   EXIT MENU      |");
            System.out.println("|  =======================================  |");
            System.out.println("|                                           |");         
    }


    public static void showMenu (  ) {
        boolean isRunning = true;
        // write a loop
        // Display a menu, with options 1 .. N for each method above, and an exit option
            // get user input and call the correct method using a SWITCH
            // print out the NEW image number everytime the value changes
        while(isRunning){
            makeMenu();
            
            String file;
            
            Scanner input = new Scanner(System.in);
            int menu_input = input.nextInt();
            
                switch (menu_input){
                    case 0: image_number = forward(image_number);
                            System.out.println(image_number);
                            break;
                    case 1: image_number = backward(image_number);
                            System.out.println(image_number);
                            break;
                    case 2: file = createFileName(image_number);
                            System.out.println(file);
                            break;
                    case 3: file = createRandomName();
                            System.out.println(file);
                            break;
                    case 4: forward();
                            System.out.println(image_number);
                            break;
                    case 5: backward();
                            System.out.println(image_number);
                            break;
                    case 6: showWindow(file);
                            break;
                    case 7: getAnyImage();
                            break;
                    case 8: isRunning = false;
                            break;
                    default: System.out.println("Not a valid menup option!");
                            break;
                }
            
        }
    }

    public static void main (String [] args) {
      //  call showMenu
      showMenu();
    }
    
}
