/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filehandler;

import Model.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import Interface.PriceStrategy;
/**
 *
 * @author Jeanette
 */
public class FileHandler
{
    public static ArrayList<Person> loadPerson (String filename)
    {
    Scanner file_scanner = null;
    ArrayList<Person> userArray = new ArrayList<>();

        try {
            file_scanner = new Scanner(new File(filename));  //Connection to the file using the Scanner object
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file to load from! Returning null.");
            ex.printStackTrace();
            return null;  //If something goes wrong the method returns null
        }

        while (file_scanner.hasNextLine()) {  //File found. Reading one line. 
            String linje = file_scanner.nextLine();
            Scanner sc = new Scanner(linje).useDelimiter(",");
            String username = sc.next();
            int score = sc.nextInt();
            Person p = new Person(username, score);
            System.out.println(p);
            userArray.add(p);  //Reading in a single line and saving in the ArrayList
        }

        file_scanner.close();  //Closing the file
        return userArray;    //returning the arraylist
    }
    
    
    
    public static boolean save(ArrayList<Person> userArray, String filename) 
    {
        if (userArray == null)
        {
            return false;
        }  //Checking parameter for null.
        FileWriter output;  //Creating reference for filewriter.

        try 
        {
            FileWriter writer = new FileWriter(filename,true);
            //output = new FileWriter(new File(Ordpar));  //Opening connection to file.
            for (Person highScorelines : userArray)
            {   //running through the ArrayList.                    
                writer.append(highScorelines.toString()+ ("\r\n"));
                //Each String object is written as a line in file.
            }
            writer.close();  //Closing the file
        } 
        catch (Exception ex) 
        {  //If something goes wrong everything is send to system out.
            System.out.println("Could not save to file!");
            System.out.println(ex.toString());
            ex.printStackTrace();
            return false;  //If something goes wrong false is returned!
        }
        return true;
}
}
