package LibraryManSys;
import java.util.Scanner;
public class DeleteAllData implements IOoperations {
    @Override
    public void oper(Database data, User user){
        System.out.println("\nAre you sure you want delete all data?\n"+"1.Continue\n2.Main Menu");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if(i == 1){
            data.deleteAllData();
        }else{
            user.menu(data, user);
        }

    }
}
