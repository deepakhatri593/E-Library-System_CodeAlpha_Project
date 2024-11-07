package LibraryManSys;
import java.util.Scanner;
public class ViewOrders implements IOoperations {
    @Override
    public void oper(Database data, User user){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter book name: ");
        String bookname = s.next();

        int i = data.getBook(bookname);
        if (i > -1 ){
            System.out.println("Book\t\tUser\t\tQty\tPrice");
            for(Order order : data.getAllOrders()){
                if (order.getBook().getName().matches(bookname)) {
                    System.out.println(order.getBook().getName()+"\t\t"+order.getUser().getName()+"\t\t"+order.getQty()+"\t"+order.getPrice());
                }
                System.out.println();
            }
        }else{
            System.out.println("\nBook doesn't Exists\n");
        }
        user.menu(data, user);
    }
}
