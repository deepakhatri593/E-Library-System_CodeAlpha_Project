package LibraryManSys;

import java.util.Scanner;

public class CalculateFine implements IOoperations{
    @Override
    public void oper(Database data, User user){
        System.out.println("Enter book name: ");
        Scanner sc = new Scanner(System.in);
        String bookname = sc.next();
        boolean g = true;

        for(Borrowing b : data.getBrw()){
            if(b.getBook().getName().matches(bookname) && b.getUser().getName().matches(user.getName())){
                if (b.getDaysleft()<0) {
                    System.out.println("You are late!"+"you have to pay "+ Math.abs(b.getDaysleft()*50)+"as fine\n");
                } else {
                    System.out.println("You don't have to pay fine\n");
                }
                g = false;
                break;
            }
        }
        if (g) {
            System.out.println("You didn't borrow this book!");
        }
        user.menu(data, user);
    }
}
