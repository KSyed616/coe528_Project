package store;

//Everything in User extends off of LogIn

abstract class User{
    public abstract void owner_change(LogIn l);
    public abstract void customer_change(LogIn l);
}
