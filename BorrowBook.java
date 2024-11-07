package LibraryManSys;

import java.util.Scanner;

public class BorrowBook implements IOoperations{
    @Override
    public void oper(Database data, User user){
         Scanner s = new Scanner(System.in);
        System.out.println("Enter book name: ");
        String bookname = s.next();

        int i = data.getBook(bookname);
        if (i > -1 ){
            Book book = data.getBook(i);
            boolean n = true;
            for(Borrowing b:data.getBrw()){
                if (b.getBook().getName().matches(bookname) && b.getUser().getName().matches(user.getName())) {
                    n=false;
                    System.out.println("You have borrowed this book before! \n");
                }
            }

        if (n) {
            
        
            if (book.getBrwcopies() > 1&& n) {
                Borrowing borrowing = new Borrowing(book, user);
                book.setBrwcopies(book.getBrwcopies()-1);
                data.borrowBook(borrowing,book,i);
                System.out.println("You must return the book 14 days from now\n"+"Expiry date: "+borrowing.getFinish()+"\nEnjoy!\n");

            }
        
            else{
                System.out.println("This book is not available for borrowing\n");
            }
        }
        }else{
            System.out.println("Book doesn't exists!\n");
        }
        user.menu(data, user);
    }
}
