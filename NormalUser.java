package LibraryManSys;
import java.util.Scanner;
public class NormalUser extends User {
    public NormalUser(String name){
        super(name);
        this.operations = new IOoperations[]{
            
            new ViewBooks(),
            new Search(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit()
           

        };
    }

    public NormalUser(String name, String email, String num){
        super(name,email,num);
        this.operations = new IOoperations[]{
            new ViewBooks(),
            new Search(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit()

        };
    }

    @Override
    public void menu(Database data,User user){
        System.out.println("1.View Books");
        System.out.println("2.Search");
        System.out.println("3.Place order");
        System.out.println("4.Borrow book");
        System.out.println("5.Calculate fine");
        System.out.println("6.Return book");
        System.out.println("7.Exit");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        this.operations[n-1].oper(data,user);
    }
    public String toString(){
        return name+"<N/>"+email+"<N/>"+password+"<N/>"+"NormalUser";
    }
}
