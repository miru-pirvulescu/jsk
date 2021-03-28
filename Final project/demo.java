import java.util.ArrayList;

private class BasicJava(){
    
    
    // if statement
    if(condition == True){
        //execute some code
    }

    //else statement
    if (x == 0){
        //execute some code
    }
    else{
        //execute some other code
    }

    //else if statement
    if (x == 0){
        //execute some code
    }
    else if (x == 1){
        //execute some other code
    }

    // switch statement
    switch (value){
        case (value == x):
            //here goes some code
        
        case (value == y):
            //here goes some code

        case (value == z):
            //here goes some code
    }

    // do while
    do{
        //execute some code
    }while (condition == true);

    // while
    while (condition == true){
        //execute some code
    }

    // for
    for(int i = 0; i <= n; i++){
        //execute some code
    }

    // for-each
    for(String s: CollectionOfStrings){
        System.out.println(s);
    }

    // continue statement
    for(int i = 0; i <= n; i++){
        //execute some code
        if (i == m){
            continue; //to the next iteration
        }
    }

    // break statement
    for(int i = 0; i <= n; i++){
        //execute some code
        if (i >= m){
            break; //out of the loop
        }
    }

    // declaring an integer
    int integer_number = 10;

    // declaring a float
    float float_number = 3.14;

    // declaring a long
    long long_number = 1234567890;

    // declaring a double
    double double_number = 3.14159265358979;

    // declaring a short
    short short_number = 120;

    // declaring a byte
    byte byte_number = 126;

    // declaring a char
    char character = 'x';

    // declaring a boolean
    boolean isJavaFun = true;

    // declaring an array, empty or predefined
    int[] no_numbers_yet;
    int[] some_numbers = {1, 2, 3, 4, 5};

    // declaring an ArrayList
    ArrayList<String> some_strings = new ArrayList<>();
    // add an element
    some_strings.add("Hello World!");
    // remove an element
    some_strings.remove(0);

    // declaring a HashMap
    HashMap<String, String> animals = new HashMap<>();
    // add an element
    countries.put("cat", "feline");
    // remove an element
    countries.remove("cat");

    // declaring a String
    String hello = "Hello World!";

    // code block example
    {
        int x = 10;
        x = x + 2;
        System.out.pringln(x);
    }

    // // arithmetic operation
    // int x = 2;
    // int y = 3;
    // int z = x + y;

    // // assignment operator
    // int x = 1234;

    // comparison operator

    // a variable with an assigned value
    int x = 10;

    
    int y = 20;
    if(x > y){
        System.out.println("x is greater than y");
    }

    // logical operator
    boolean t = true;
    boolean f = false;

    if (t && f == true){
        System.out.println("true && false cannot actually be true");
    }

}

//class example
public class HelloWorld{

    private int x = 10;

    public void print_x(){
        System.out.println(this.x);
    }
}

// constructor example
public class HelloWorld{

    private int x;

    public HelloWorld(){
        this.x = 10;
    }

    public void print_x(){
        System.out.println(this.x);
    }

    public void print_something_else(String something_else){
        System.out.println(something_else);
    }

    public int get_x(){
        return this.x;
    }

    // declaring an object
    HelloWorld object = new HelloWorld();


    // a public method
    public void non_secret_message(){
        System.out.println("This is a message for everyone to see!");
    }

    // a private method
    private void secret_message(){
        System.out.println("This is a very secret message!");
    }

    // a protected method
    protected void almost_secret_message(){
        System.out.println("This message is only meant for my children!");
    }
}