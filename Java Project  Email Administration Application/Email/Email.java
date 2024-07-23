package Email;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);


        // call a method asking for the department - return department;
        this.department = setDepartment();

        // call a method for the random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
        // combine elements to generate email;
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    // Ask for the department
    private String setDepartment() {

        System.out.println("New worker:" + firstName + ".Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return " ";
        }

    }

    // Generate a random password;
    private String randomPassword(int length) {

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!#@%$"; // make a string password
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailBox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    // Set the alternate email

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("DISPLAY NAME: ").append(firstName).append(lastName).append(System.lineSeparator());
        sb.append("COMPANY EMAIL: ").append(email).append(System.lineSeparator());
        sb.append("MAILBOX CAPACITY: ").append(mailBoxCapacity).append("mb");
        return  sb.toString().trim();
    }
}





