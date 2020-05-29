/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;
import java.util.Scanner;

/**
 *
 * @author Iffath Zeba Sayeeda
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "sizcompany.com";
      
    // Constructor receives first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName; 
        
        // Call a method asking for the department - return the department
        this.department = setDepartment();
        
        // Call a method to generate random password
        this.password = passwordGenerator(defaultPasswordLength);
        System.out.println("Password : " + this.password);
        
        // Generate email by combining elements
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    
    // Ask for department
    private String setDepartment(){
        System.out.print("New Worker : " +firstName + "\nDepartment Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter your department code : ");
        Scanner input = new Scanner(System.in);
        int depNumber = input.nextInt();
        switch(depNumber){
            case 1: 
                return "sales";
            case 2:
                return "dev";
            case 3: 
                return "acct";
            default:
                return "";
        }
                    
    }
    
    // Generate random password
    private String passwordGenerator(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
        char[] password = new char[length];
        for(int i =0; i<length; i++){
            int random = (int)(Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }
    
    //Change password
    public void setPassword(String newPassword){
        this.password = newPassword;        
    }
    
    //Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
        
    }
    
    //Set alternate email
    public void setAlternateEmailAddress(String alternateEmail){
        this.alternateEmail = alternateEmail;        
    }
    
    //Get mailbox capacity
    public int getMailboxCapacity(){
        return this.mailboxCapacity;
    }
    
    //Get alternate email
    public String getAlternateEmail(){
        return this.alternateEmail;
    }
    
    //Get password
    public String getPassword(){
        return this.password;
    }
    
    //Displays info
    public String showInfo(){
        return "DISPLAY NAME: " +firstName + " " + lastName +
                "\nCOPMANY EMAIL : " + email + 
                "\nMAILBOX CAPACITY : " + mailboxCapacity + " MB"; 
    }
}
