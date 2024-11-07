package LibraryManSys;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Borrowing {
      
    LocalDate start;
    LocalDate finish;
    int daysleft;
    Book book;
    User user;

    DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Borrowing(Book book, User user){
        start = LocalDate.now();
        finish = start.plusDays(14);
        Period period = Period.between(start,finish);
        daysleft = period.getDays();
        this.book = book;
        this.user = user;
    }

    public Borrowing(LocalDate start, LocalDate finish, Book book, User user){
        this.start = start;
        this.finish = finish;
        Period period = Period.between(finish,LocalDate.now());
        daysleft = period.getDays();
        this.book = book;
        this.user = user;
    }

    public String getStart() {
        return form.format(start);
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public String getFinish() {
        return form.format(finish);
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }

    public int getDaysleft() {
        return Period.between(finish,LocalDate.now()).getDays();
    }

    public void setDaysleft(int daysleft) {
        this.daysleft = daysleft;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString(){
        return "Borrowing time: "+start+"\nExpiry date: "+finish+"\nDays left: "+daysleft;
    }
    public String toString2(){
        return getStart()+"<N/>"+getFinish()+"<N/>"+getDaysleft()+"<N/>"+book.getName()+"<N/>"+user.getName()+"<N/>";
    }

}

