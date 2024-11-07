package LibraryManSys;
import java.util.Scanner;
public class Exit implements IOoperations{
    @Override
    public void oper(Database data, User user){
        System.out.println("\nAre you sure you want to quit?\n"+"1.Yes\n2.Main Menu");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if(i == 1){
            sc.close();
        }else{
            user.menu(data, user);
        }

    }
}
