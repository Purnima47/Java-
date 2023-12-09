public class Inheritance {
    public static void main(String[] args) {
        // Fish shark = new Fish();
        // shark.eat();
        // Dog doggy = new Dog();
        // doggy.legs = 4;
        // System.out.println(doggy.legs);
        Deer d = new Deer();
        d.eat(); // method overriding
        Animal a = new Animal();
        Student s1 = new Student();
        System.out.println(s1.school);

    }
}

// base class
class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }
}

class Mamals extends Animal {
    int legs;

    void walk() {
        System.out.println("walks");
    }
}

class Deer extends Animal {
    void eat() {
        System.out.println("Eats grass");
    }
}
// class Dog extends Mamals{
// String breed;
// }

// Derived class
/*
 * class Fish extends Animal{
 * int fins;
 * void swim(){
 * System.out.println("Swims in water");
 * }
 * }
 */

// this is not part of inheritance but oops (static keyword)

class Student {
    int roll;
    String name;
    static String school = "SDPBEC";
}