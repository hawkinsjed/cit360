/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.model.Game;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.util.Scanner;
import savethevillage.SaveTheVillage;


public abstract class View implements ViewInterface
{
    protected String displayMessage;
    
    protected final BufferedReader keyboard = SaveTheVillage.getInFile();
    protected final PrintWriter console = SaveTheVillage.getOutFile();
    
    public View()
    {
        this.displayMessage = "";
    }
    
    public View(String message)
    {
        this.displayMessage = message;
    }
    
    @Override
    public void display()
    {
        boolean done = false;
        do
        {
            String value = this.getInput();
            done = this.doAction(value);
        }while(!done);
    }
    
    @Override
    public String getInput()
    {
        String value = null;
        boolean valid = false;
        
        try{
        while(!valid){
            this.console.println("\n" + this.displayMessage);
            value = this.keyboard.readLine();
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){ //blank value entered
                ErrorView.display(this.getClass().getName(), "\nSorry? What was that?");
                continue;
            }
            break;
        }
        } catch (Exception e){
            ErrorView.display(this.getClass().getName(), "Unable to determine your needs " + e.getMessage());
        }
        return value;
    }
    
    public String getInputNoMenu(){
        
        String value = null;
        boolean valid = false;
        
        try{
        while(!valid){
            value = this.keyboard.readLine();
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){ //blank value entered
                ErrorView.display(this.getClass().getName(), "\nSorry? What was that?");
                continue;
            }
            break;
        }
        } catch (Exception e){
            ErrorView.display(this.getClass().getName(), "Unable to determine your needs " + e.getMessage());
        }
        return value;
    }    
    
    public void display(Game game)
    {
        boolean done = false;
        do
        {
            String value = this.getInput();
            done = this.doAction(value, game);
        } while(!done);
    }
    
    public boolean doAction(String choice, Game game)
    {
        //To be overridden by sub-class functions
        return false;
    }
}
