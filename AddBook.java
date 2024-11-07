package LibraryManSys;

import java.util.Scanner;

public class AddBook implements IOoperations {
    @Override
    public void oper(Database data, User user){
        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book name: ");
        String name = s.next();
        if(data.getBook(name)> -1){
            System.out.println("There is a book with this name!");
            user.menu(data, user);
            return;
        }
        else{
        book.setName(name);
        System.out.println("Enter Book author: ");
        book.setAuthor(s.next());
        System.out.println("Enter book publisher: ");
        book.setPublisher(s.next());
        System.out.println("Enter book collection address: ");
        book.setAddress(s.next());
        System.out.println("Enter QTY: ");
        book.setQty(s.nextInt());
        System.out.println("Enter price: ");
        book.setPrice(s.nextDouble());
        System.out.println("Enter borrowing copies: ");
        book.setBrwcopies(s.nextInt());

        
        data.AddBook(book);
        System.out.println("Book added successfully\n");

        user.menu(data, user);
        s.close();
        }

        

    }
}
