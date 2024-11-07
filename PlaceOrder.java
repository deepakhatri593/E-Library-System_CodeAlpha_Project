package LibraryManSys;

import java.util.Scanner;
public class PlaceOrder implements IOoperations{
    @Override
    public void oper(Database data, User user){
        Order order = new Order();
        System.out.println("\nEnter book name: ");
        Scanner sc = new Scanner(System.in);
        String bookname = sc.next();
        int i = data.getBook(bookname);
        if(i <= -1){
            System.out.println("Book doesnot exist!\n");
        }else{
            Book book = data.getBook(i);
            order.setBook(data.getBook(i));
            order.setUser(user);
            System.out.println("Enter Quantity:");
            int qty = sc.nextInt();
            order.setQty(qty);
            order.setPrice(data.getBook(i).getPrice()*qty);
            int bookIndex = data.getBook(book.getName());
            book.setQty(book.getQty()-qty);
            data.addOrder(order,book,bookIndex);
            System.out.println("Order placed Successfully\n");
        }
        user.menu(data, user);

    }
}
