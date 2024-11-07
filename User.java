package LibraryManSys;

abstract public class User {
    protected String name;
    protected String email;
    protected String password;
    protected IOoperations[] operations;

    public User(){

    }
    public User(String name){
       this.name=name;
    }

    public User(String name, String email, String pass){
        this.name = name;
        this.email = email;
        this.password = pass;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPass(){
        return password;
    }

    abstract public void menu(Database data, User user);

    abstract public String toString();
}
