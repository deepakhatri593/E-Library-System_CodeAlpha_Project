package LibraryManSys;

import java.util.Scanner;

public class Search implements IOoperations{
    @Override
    public void oper(Database data, User user){
          Scanner s = new Scanner(System.in);
        System.out.println("Enter book name: ");
        String bookname = s.next();

        int i = data.getBook(bookname);
        if (i > -1 ){
           System.out.println("\n"+data.getBook(i).toString()+"\n");
        }else{
            System.out.println("\nBook doesn't Exists\n");
        }
      
        user.menu(data, user);
    }
}
