package LibraryManSys;
import java.util.ArrayList;
public class ViewBooks implements IOoperations{
    
    @Override
    public void oper(Database data, User user){
        ArrayList<Book> books = data.getAllBooks();
        System.out.println("\n Name\tAuthor\t\tPublisher\tCLA\tQty\tprice\tBrw cps");

        for(Book b : books){
            System.out.println(b.getName()+"\t"+b.getAuthor()+"\t\t"+b.getPublisher()+"\t\t"+b.getAddress()+"\t"+b.getQty()+"\t"+b.getPrice()+"\t"+b.getBrwcopies());
        }

        System.out.println();
        user.menu(data, user);
    }
}
