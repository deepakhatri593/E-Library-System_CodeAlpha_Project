package LibraryManSys;

import java.util.Scanner;

public class Main {
     static Scanner s;
     static Database data;
    public static void main(String[] args) {
        data = new Database();
        System.out.println("Welcome to Library Management System");
       
        int n;

        // do{
            System.out.println("0.Exit\n1.Login\n2.newUser");

            s = new Scanner(System.in);
            n = s.nextInt();
            switch (n) {
                case 1:
                    login();
                    break;
                    
                case 2:
                    newUser();
                    break;
                
            }
        // }while(n != 0);

       
        

    }
    private static void login(){
        System.out.print("Enter your email: ");
        String email = s.next();
        System.out.print("Enter your password: ");
        String password = s.next();

        int n = data.login(email, password);
        if(n != -1){
            User user = data.getUser(n);
            System.out.println("\n Welcome "+user.getName()+"\n");
            user.menu(data,user);
        }else{
            System.out.println("User doesnot exists");
        }
    }

    private static void newUser(){
        System.out.print("Enter your name: ");
        String name = s.next();
        if (data.userExists(name)) {
            System.out.println("User exists");
            return;
        }
        System.out.print("Enter your email: ");
        String email = s.next();
        System.out.print("Enter password: ");
        String password = s.next(); 

        System.out.println("1.Admin\n2.Normal User");
        int n2 = s.nextInt();
        User user;
        if(n2 == 1){
           user = new Admin(name,email,password);
           
        }else{
            user = new NormalUser(name,email,password);
            
        }
        data.addUser(user);
        System.out.println("Account created successfully");
        user.menu(data,user);
        s.close();
        
        
    }
}
