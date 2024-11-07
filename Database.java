package LibraryManSys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Database {
    
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> booknames= new ArrayList<>();
    private ArrayList<Order> orders= new ArrayList<>();
    private ArrayList<Borrowing> borrowings= new ArrayList<>();

    private File userFile = new File("E:\\LibraryMS\\data\\Users"); 
    private File bookFile = new File("E:\\LibraryMS\\data\\Books");
    private File orderFile = new File("E:\\LibraryMS\\data\\Orders");
    private File borrowingsFile = new File("E:\\LibraryMS\\data\\Borrowings");  
    private File folder = new File("E:\\LibraryMS\\data");
    


    public Database(){
        if(!folder.exists()){
            folder.mkdirs();
        }
        if (!userFile.exists()) {
            try{
            userFile.createNewFile();
            }catch(Exception e){}
        }
        if (!bookFile.exists()) {
            try{
                bookFile.createNewFile();
                }catch(Exception e){}
        }
        if (!orderFile.exists()) {
            try{
                orderFile.createNewFile();
                }catch(Exception e){}
        }
        if (!borrowingsFile.exists()) {
            try{
                borrowingsFile.createNewFile();
                }catch(Exception e){}
        }
        getUsers();
        getBooks();
        getOrders();
        getBorrowings();
    }

    public void addUser(User s){
        users.add(s);
        usernames.add(s.getName());
        saveUsers();
    }

    public void AddBook(Book book){
        books.add(book);
        booknames.add(book.getName());
        saveBooks();
    }

    public int login(String email, String pass){
        int n = -1;
        for(User s: users){
            if(s.getEmail().matches(email) && s.getPass().matches(pass)){
                n = users.indexOf(s);
                break;
            }
        }
        return n;
    }

    public User getUser(int n){
        return users.get(n);
    }

    private void getUsers(){
        String text1 = "";
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(userFile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        }catch(Exception e){
             System.err.println(e.toString());
        }
        if(!text1.matches("") || !text1.isEmpty()){
            String[] a1 = text1.split("<NewUser/>");
            for(String s: a1){
                String[] a2 = s.split("<N/>");
                if (a2[3].matches("Admin")) {
                    User user = new Admin(a2[0],a2[1],a2[2]);
                    users.add(user);
                    usernames.add(user.getName());
                } else {
                    User user = new NormalUser(a2[0],a2[1],a2[2]);
                    users.add(user);
                    usernames.add(user.getName());
                }
            }
        }
    }

    private void saveUsers(){
        String text1 = "";
        for(User user : users){
            text1 = text1 + user.toString()+"<NewUser/>";
        }
        try {
            PrintWriter pw = new PrintWriter(userFile);
            pw.print(text1);
            pw.close();
            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    private void saveBooks(){
        String text1 = "";
        for(Book book : books){
            text1 = text1 + book.toString2()+"<NewBook/>";
        }
        try {
            PrintWriter pw = new PrintWriter(bookFile);
            pw.print(text1);
            pw.close();
            System.err.println("Data Saved");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    private void getBooks(){
        String text1 = "";
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(bookFile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        }catch(Exception e){
             System.err.println(e.toString());
        }
        if(!text1.matches("") || !text1.isEmpty()){
            String[] a1 = text1.split("<NewBook/>");
            for(String s: a1){
               Book book = parceBook(s);
               books.add(book);
               booknames.add(book.getName());
            }
        }
    }
    public Book parceBook(String s){
        String[] a = s.split("<N/>");
        Book book = new Book();
        book.setName(a[0]);
        book.setAuthor(a[1]);
        book.setPublisher(a[2]);
        book.setAddress(a[3]);
        book.setQty(Integer.parseInt(a[4]));
        book.setPrice(Double.parseDouble(a[5]));
        book.setBrwcopies(Integer.parseInt(a[6]));

        return book;

    }

    public ArrayList<Book> getAllBooks(){
        return books;
    }

    public int getBook(String bookname){
        int i = -1;
        for(Book book : books){
            if(book.getName().matches(bookname)){
            i = books.indexOf(book);
            }
        }
        return i;
    }
    public Book getBook(int i){
        return books.get(i);
    }
    public void deleteBook(int i){
        books.remove(i);
        booknames.remove(i);
        saveBooks();
    }
    private void saveOrders(){
        String text1 = "";
        for(Order order : orders){
            text1 = text1 + order.toString2()+"<NewOrder/>";
        }
        try {
            PrintWriter pw = new PrintWriter(orderFile);
            pw.print(text1);
            pw.close();
            System.err.println("Data Saved");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    private void getOrders(){
        String text1 = "";
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(orderFile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        }catch(Exception e){
             System.err.println(e.toString());
        }
        if(!text1.matches("") || !text1.isEmpty()){
            String[] a1 = text1.split("<NewOrder/>");
            for(String s: a1){
                Order order = parseOrder(s);
                orders.add(order);
            }
        }
    }

    private void getBorrowings(){
        String text1 = "";
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(borrowingsFile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        }catch(Exception e){
             System.err.println(e.toString());
        }
        if(!text1.matches("") || !text1.isEmpty()){
            String[] a1 = text1.split("<NewBorrowing/>");
            for(String s: a1){
                Borrowing borrowing = parceBorrow(s);
                borrowings.add(borrowing);
                
            }
        }
    }

    private Borrowing parceBorrow(String s){
        String[] a = s.split("<N/>");
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(a[0],form);
        LocalDate finish = LocalDate.parse(a[1],form);
        Book book = getBook(getBook(a[3]));
        User user = getUserByName(a[4]);
        Borrowing brw = new Borrowing(start, finish, book, user);
        return brw;
    }

    private void saveBorrowings(){
        String text1 = "";
        for(Borrowing borrow : borrowings){
            text1 = text1 + borrow.toString2()+"<NewBorrowing/>";
        }
        try {
            PrintWriter pw = new PrintWriter(borrowingsFile);
            pw.print(text1);
            pw.close();
            System.err.println("Data Saved");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void borrowBook(Borrowing brw, Book book, int bookIndex){
        borrowings.add(brw);
        books.set(bookIndex, book);
        saveBorrowings();
        saveBooks();
    }

    public boolean userExists(String name){
        boolean f = false;
        for(User user : users){
            if(user.getName().toLowerCase().matches(name.toLowerCase())){
                f=true;
            }
        }
        return f;

    }
    private User getUserByName(String name){
        User u = new NormalUser("");
        for(User user : users){
            if(user.getName().matches(name)){
                u = user;
            }
        }
        return u;

    }

    private Order parseOrder(String s){
         String[] a = s.split("<N/>");
         Order order = new Order(books.get(getBook(a[0])),getUserByName(a[1]),Double.parseDouble(a[2]),Integer.parseInt(a[3]));

         return order;

    }


    public void deleteAllData(){
        if (userFile.exists()) {
            try{
            userFile.delete();
            }catch(Exception e){}
        }
        if (bookFile.exists()) {
            try{
                bookFile.delete();
                }catch(Exception e){}
        }
        if (orderFile.exists()) {
            try{
                orderFile.delete();
                }catch(Exception e){}
        }
    }

    public void addOrder(Order order, Book book, int bookIndex){
        orders.add(order);
        books.set(bookIndex, book);
        saveOrders();
        saveBooks();

    }
    public ArrayList<Order> getAllOrders(){
        return orders;
    }
    public ArrayList<Borrowing> getBrw(){
        return borrowings;
    }
    public void returnBook(Borrowing b, Book book, int bookIndex){
        borrowings.remove(b);
        books.set(bookIndex, book);
        saveBorrowings();
        saveBooks();
    }
}
