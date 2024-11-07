package LibraryManSys;

import java.util.Scanner;

public class ReturnBook implements IOoperations{
    @Override
    public void oper(Database data, User user){
        System.out.println("Enter book name: ");
        Scanner sc = new Scanner(System.in);
        String bookname = sc.next();
        if (!data.getBrw().isEmpty()) {
            for(Borrowing b : data.getBrw()){
                if(b.getBook().getName().matches(bookname) && b.getUser().getName().matches(user.getName())){
                    Book book = b.getBook();
                    int i = data.getAllBooks().indexOf(book);
                    if(b.getDaysleft()<0){
                        System.out.println("You are late!"+"you have to pay "+ Math.abs(b.getDaysleft()*50)+"as fine\n");
                    }
                    book.setBrwcopies(book.getBrwcopies()+1);
                    data.returnBook(b,book,i);
                    System.out.println("Book returned\nThank you!\n");
                    break;
                }else{
                    System.out.println("You didn't borrow this book!\n");
                }
        }
    }else{
        System.out.println("You didn't borrow this book!\n");
    }
    user.menu(data, user);
}}
