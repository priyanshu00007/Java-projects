// // // public class Function
// // // {
// // //     public static void main(String[] args) {
// // //         System.out.println(add(30,40));
// // //     }

// // //     public int add(int a,int b)
// // //     {
// // //         return a + b;
// // //     }
// // // }

// // public class Function
// // {
// //     public static void main(String[] args) {
// //         System.out.println(add(30,40));
// //     }

// //     public static int add(int a,int b)
// //     {
// //         return a + b;
// //     }
// // }

// // oops
// /*
//  * | Concept       | Use                                                     |
// | ------------- | ------------------------------------------------------- |
// | Encapsulation | Protect data using classes + private fields             |
// | Inheritance   | Reuse code by extending classes                         |
// | Polymorphism  | One method, many forms                                  |
// | Abstraction   | Hiding internal logic using interfaces/abstract classes |

//  */
// // class Dog {
// //     String name;
// //     int age;

// //     void bark()
// //     {
// //         System.out.println("bark");          
// //     }
// // }

// // public class Function
// // {
// //    public static void main(String args[])
// //     {
// //         Dog d1 = new Dog();
// //         d1.name = "Sharan";
// //         d1.age = 10;
// //         System.out.println("name  : " + d1.name);     
// //         System.out.println("age : " + d1.age);
// //         d1.bark();      
// //     }
// // }


// // try catch
// // public class Function{
// // public static void main(String[] args) {   
// //     try
// //     {
// //         int a = 10/10;
// //         System.out.println("this a" + a);
// //     }
// //     catch(Exception e)
// //     {
// //         System.out.println(e);
// //     }
    
// // }
// // }



// // file handling 
// // import java.io.*;
// // import java.util.*;
// // public class Filehandler
// // {
// //     public static void main(String aargs[])
// //     {
// //         String filename = "input.txt";
// //         File file = new File(filename);

// //         try{
// //             if(!file.exists())
// //             {
// //                 file.createNewFile();
// //                 System.out.println("file created successfully");    
// //             }
// //             else{
// //                 System.out.println("file already exists");
// //             }
// //             FileWriter fw = new FileWriter(file,true);
// //             BufferedWriter bw =  new BufferedWriter(fw);
// //             bw.write("New lin e added to the file");
// //             bw.newLine();
// //             bw.close();
// //             System.out.println("Data written to file successfully");


// //             Scanner sc = new Scanner(file);
// //             while(sc.hasNextLine())
// //             {
// //                 System.out.println(sc.nextLine());
// //             }
// //             sc.close();
// //         }
// //         catch(Exception e)
// //         {
// //             System.out.println("Error occurred: " + e.getMessage());
// //         }
// //     }
// // }



// // import java.io.*;
// // import java.util.*;

// // // 🎭 Abstraction: Define what to do, not how
// // abstract class FileManager {
// //     abstract void writeToFile(String data);
// //     abstract void readFromFile();
// // }

// // // 🧾 FileHandler: Implements abstract methods for writing/reading
// // class MyFileHandler extends FileManager {
// //     private final String fileName = "input.txt";
// //     private File file;

// //     public MyFileHandler() {
// //         file = new File(fileName);
// //         try {
// //             if (!file.exists()) {
// //                 file.createNewFile();
// //                 System.out.println("✅ File created: " + fileName);
// //             } else {
// //                 System.out.println("📁 File already exists. Appending data...");
// //             }
// //         } catch (IOException e) {
// //             System.out.println("❌ Error creating file: " + e.getMessage());
// //         }
// //     }

// //     // 🪶 Polymorphism: same method signature, different implementation
// //     @Override
// //     void writeToFile(String data) {
// //         try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
// //             bw.write(data);
// //             bw.newLine();
// //             System.out.println("📝 Data written to file.");
// //         } catch (IOException e) {
// //             System.out.println("❌ Error writing: " + e.getMessage());
// //         }
// //     }

// //     @Override
// //     void readFromFile() {
// //         System.out.println("\n📄 File Content:");
// //         try (Scanner scanner = new Scanner(file)) {
// //             while (scanner.hasNextLine()) {
// //                 System.out.println("📌 " + scanner.nextLine());
// //             }
// //         } catch (FileNotFoundException e) {
// //             System.out.println("❌ File not found.");
// //         }
// //     }
// // }

// // // 👨‍💼 Encapsulation: Protect internal data
// // class Person {
// //     private String name;
// //     private int age;

// //     public Person(String name, int age) { // constructor
// //         this.name = name;
// //         this.age = age;
// //     }

// //     public String getInfo() {
// //         return "👤 Name: " + name + ", Age: " + age;
// //     }
// // }

// // // 👨‍🎓 Inheritance: Student is a type of Person
// // class Student extends Person {
// //     private String course;

// //     public Student(String name, int age, String course) {
// //         super(name, age);
// //         this.course = course;
// //     }

// //     // 🔁 Polymorphism: override method
// //     @Override
// //     public String getInfo() {
// //         return super.getInfo() + ", 📘 Course: " + course;
// //     }
// // }

// // // 🚀 Main class
// // public class FullOOPExample {
// //     public static void main(String[] args) {
// //         Scanner input = new Scanner(System.in);

// //         // 🎓 Create a student (Encapsulation + Inheritance)
// //         System.out.print("Enter name: ");
// //         String name = input.nextLine();

// //         System.out.print("Enter age: ");
// //         int age = input.nextInt();
// //         input.nextLine(); // consume newline

// //         System.out.print("Enter course: ");
// //         String course = input.nextLine();

// //         Student student = new Student(name, age, course);

// //         // 🗃️ Use file handler (Abstraction + Polymorphism)
// //         FileManager fileManager = new MyFileHandler();

// //         // Append student info
// //         fileManager.writeToFile(student.getInfo());

// //         // Read and display content
// //         fileManager.readFromFile();
// //     }
// // }



// // only oocp

// import java.util.Scanner;

// // 🔒 Encapsulation: private fields + public accessors
// class Person {
//     private String name;
//     private int age;

//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     // Getter methods
//     public String getName() { return name; }
//     public int getAge() { return age; }

//     // Polymorphism: base method
//     public String getDetails() {
//         return "👤 Name: " + name + ", Age: " + age;
//     }
// }

// // 🧬 Inheritance: Student inherits from Person
// class Student extends Person {
//     private String course;

//     public Student(String name, int age, String course) {
//         super(name, age); // call Person's constructor
//         this.course = course;
//     }

//     // Polymorphism: method overriding
//     @Override
//     public String getDetails() {
//         return super.getDetails() + ", 📘 Course: " + course;
//     }
// }

// // 🧩 Abstraction: defining what (not how)
// abstract class Greeter {
//     abstract void greet(Person p);
// }

// // 👋 Concrete implementation of Greeter
// class WelcomeGreeter extends Greeter {
//     @Override
//     void greet(Person p) {
//         System.out.println("👋 Welcome, " + p.getName() + "! You are " + p.getAge() + " years old.");
//     }
// }

// // 🚀 Main class to run everything
// public class OOPExample {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // Input
//         System.out.print("Enter name: ");
//         String name = sc.nextLine();

//         System.out.print("Enter age: ");
//         int age = sc.nextInt();
//         sc.nextLine(); // consume newline

//         System.out.print("Enter course: ");
//         String course = sc.nextLine();

//         // Create Student object (Encapsulation + Inheritance)
//         Person student = new Student(name, age, course); // Polymorphism in action

//         // Display details
//         System.out.println(student.getDetails()); // Calls overridden method

//         // Greet using abstraction
//         Greeter greeter = new WelcomeGreeter(); // Abstract class reference
//         greeter.greet(student); // Polymorphism with abstract method
//     }
// }



// all indi
// 1. Encapsulation
// Definition: Wrapping data (variables) and methods into a single unit (class) and restricting direct access to them using private access.

// class EncapsulatedStudent {
//     private String name;
//     private int age;

//     // Constructor
//     public EncapsulatedStudent(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     // Public getters (controlled access)
//     public String getName() { return name; }
//     public int getAge() { return age; }

//     // Public setters (controlled modification)
//     public void setAge(int age) {
//         if (age > 0) this.age = age;
//     }
// }

// public class EncapsulationDemo {
//     public static void main(String[] args) {
//         EncapsulatedStudent student = new EncapsulatedStudent("John", 20);

//         // Access through getters
//         System.out.println("Name: " + student.getName());
//         System.out.println("Age: " + student.getAge());

//         // Modify age via setter
//         student.setAge(25);
//         System.out.println("Updated Age: " + student.getAge());
//     }
// }
// ✅ 2. Inheritance
// Definition: When a class (child) inherits fields and methods from another class (parent).

// java
// Copy
// Edit
// // Parent class
// class Animal {
//     public void eat() {
//         System.out.println("🍽️ Animal is eating...");
//     }
// }

// // Child class
// class Dog extends Animal {
//     public void bark() {
//         System.out.println("🐶 Dog is barking...");
//     }
// }

// public class InheritanceDemo {
//     public static void main(String[] args) {
//         Dog d = new Dog();
//         d.eat();  // Inherited method
//         d.bark(); // Child class method
//     }
// }
// ✅ 3. Polymorphism
// Definition: Ability to take many forms.
// Types:

// Compile-time (Method Overloading)

// Runtime (Method Overriding)

// (a) Method Overloading (Compile-time Polymorphism)
// java
// Copy
// Edit
// class Calculator {
//     public int add(int a, int b) {
//         return a + b;
//     }

//     public double add(double a, double b) {
//         return a + b;
//     }
// }

// public class OverloadingDemo {
//     public static void main(String[] args) {
//         Calculator c = new Calculator();
//         System.out.println(c.add(5, 10));        // Calls int version
//         System.out.println(c.add(2.5, 3.3));     // Calls double version
//     }
// }
// (b) Method Overriding (Runtime Polymorphism)
// java
// Copy
// Edit
// class Vehicle {
//     public void start() {
//         System.out.println("🚗 Vehicle is starting...");
//     }
// }

// class Car extends Vehicle {
//     @Override
//     public void start() {
//         System.out.println("🚙 Car is starting with a key...");
//     }
// }

// public class OverridingDemo {
//     public static void main(String[] args) {
//         Vehicle v = new Car(); // Polymorphic reference
//         v.start();             // Calls Car's overridden method
//     }
// }
// ✅ 4. Abstraction
// Definition: Hiding complex logic and showing only essential features.
// Achieved by:

// abstract class

// interface

// (a) Using Abstract Class
// java
// Copy
// Edit
// abstract class Shape {
//     abstract void draw(); // Abstract method
// }

// class Circle extends Shape {
//     public void draw() {
//         System.out.println("⚪ Drawing a Circle");
//     }
// }

// public class AbstractionDemo {
//     public static void main(String[] args) {
//         Shape s = new Circle(); // Abstract reference
//         s.draw();
//     }
// }
// (b) Using Interface
// java
// Copy
// Edit
// interface Printable {
//     void print(); // implicitly public and abstract
// }

// class Document implements Printable {
//     public void print() {
//         System.out.println("🖨️ Printing Document...");
//     }
// }

// public class InterfaceDemo {
//     public static void main(String[] args) {
//         Printable p = new Document();
//         p.print();
//     }
// }