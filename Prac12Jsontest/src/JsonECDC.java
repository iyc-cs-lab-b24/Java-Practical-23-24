import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters (or you can make fields public)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class JsonECDC {
    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Getting user input for name and age
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        // Creating a Person object
        Person person = new Person(name, age);

        // Creating a Gson object
        Gson gson = new Gson();

        // Encoding JSON from Java object
        String json = gson.toJson(person);
        System.out.println("Encoded JSON: " + json);

        // Writing JSON data to a file
        try (FileWriter fileWriter = new FileWriter("person.json")) {
            fileWriter.write(json);
            System.out.println("JSON data written to person.json file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing JSON data to file: " + e.getMessage());
        }

        // Decoding JSON to Java object
        System.out.println("Decoding JSON to Java object...");
        Person decodedPerson = gson.fromJson(json, Person.class);
        System.out.println("Decoded Person: Name=" + decodedPerson.getName() + ", Age=" + decodedPerson.getAge());

        // Closing the scanner
        scanner.close();
    }
}
