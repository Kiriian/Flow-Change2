/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import flow.change.Controller;
/**
 *
 * @author Jeanette
 */
public class Person
{
    private int score;
    private String username;
    Controller ctrl = new Controller();

    public Person(String username, int score)
    {
        this.score = score;
        this.username = username;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int Score)
    {
        this.score = Score;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return username +"," +score;
    }
      
//    public int newScore()
//    {
//        score = score - 
//    }
}
