
public class OOPS {
    public static void main(String[] args) {
        Pen p1 = new Pen(); // CREATED A PEN OBJECT NAMED p1
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(4);
        System.out.println(p1.getTip());
        p1.setColor("Red");
        System.out.println(p1.getColor());

        BankAccount myAcc = new BankAccount();
        myAcc.username = "purnima"; // we cannot access password here since it is private
        myAcc.setPassword("lmn"); // only we can change the password

        // CONSTRUCTORS:
        Student s1 = new Student();
        s1.name = "purnima";
        s1.roll = 82;
        s1.password = "abc";
        // s1.marks[0] = 100;
        // s1.marks[1] = 80;
        // s1.marks[2] = 70;

        // Student s2 = new Student(s1);
        // s2.password = "xyz";

        Horse h = new Horse();
        Chicken ch = new Chicken();
        h.walk();
        ch.walk();
        Mustang myHorse = new Mustang();

        Queen q = new Queen();
        q.move();

    }
}

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }
}

class Pen {
    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String newColor) {
        this.color = newColor;
    }

    void setTip(int tip) {
        this.tip = tip;
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    class Address {
        String city;
    }

    // shallow copy constructor -->in this if any changes in made in the copy one's
    // then it would affect its original..
    /*
     * Student(Student s1){
     * marks=new int[3];
     * this.name=s1.name;
     * this.roll=s1.roll;
     * this.marks= s1.marks;
     * }
     */

    // deep copy constructor
    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        // for (int i = 0; i < marks.length; i++) {
        // this.marks[i] = s1.marks[i];
        // }
    }

    Student() {
        System.out.println("Constructor is called");
    }
}

abstract class Animal { // we cannot create object of Animal since it is abstract type
    String color;

    Animal() {
        System.out.println("Animal constructor called");
        color = "brown";
    }

    void eat() {
        System.out.println("Animal eats");
    }

    abstract void walk();
}

class Horse extends Animal {
    Horse() {
        System.out.println("horse constructor called");
    }

    void changeColor() {
        color = "black";
    }

    void walk() {
        System.out.println("horse walk on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called");
    }
}

class Chicken extends Animal {
    void changeColor() {
        color = "peach";
    }

    void walk() {
        System.out.println("chicken walk on 2 legs");
    }
}

interface Chessplayer {
    void move();
}

class Queen implements Chessplayer {
    public void move() {
        System.out.println("up,down,right,left,diagonal (in all four directions)");
    }
}

class King implements Chessplayer {
    public void move() {
        System.out.println("up,down,right,left,diagonal by 1 step");
    }
}

class Rook implements Chessplayer {
    public void move() {
        System.out.println("up,down,right,left");
    }
}