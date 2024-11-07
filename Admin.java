package LibraryManSys;

import java.util.Scanner;
public class Admin extends User{

    
    public Admin(String name){
        super(name);
        this.operations = new IOoperations[]{
            
            new ViewBooks(),
            new AddBook(),
            new DeleteBook(),
            new Search(),
            new DeleteAllData(),
            new ViewOrders(),
            new Exit()

        };
    }

    public Admin(String name, String email, String num){
        super(name,email,num);
        this.operations = new IOoperations[]{
            
            new ViewBooks(),
            new AddBook(),
            new DeleteBook(),
            new Search(),
            new DeleteAllData(),
            new ViewOrders(),
            new Exit()
        };
    }

    @Override
    public void menu(Database data, User user){
        System.out.println("1.View Books");
        System.out.println("2.Add Books");
        System.out.println("3.Delete Books");
        System.out.println("4.Search");
        System.out.println("5.Delete all data");
        System.out.println("6.View orders");
        System.out.println("7.Exit");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        this.operations[n-1].oper(data,user);
    }

    public String toString(){
        return name+"<N/>"+email+"<N/>"+password+"<N/>"+"Admin";
    }
}
