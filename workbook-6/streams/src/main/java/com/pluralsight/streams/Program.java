package com.pluralsight.streams;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Person> people =createPeopleList();


        // Search By Name
        System.out.println("Who would you like to search?");
        String name = scan.nextLine();

        for (Person person : people) {
            if(person.getFirstName().equalsIgnoreCase(name) || person.getLastName().equalsIgnoreCase(name)) {
                System.out.println(person);
            }
        }

        // Average age of list
        System.out.println("The average age is " + averageAge(people));

        // Find Oldest
        System.out.println("This oldest person is " +  oldestPerson(people));

        // Find Youngest
        System.out.println("This youngest person is " +  youngestPerson(people));

    }
    private static ArrayList<Person> createPeopleList(){
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("John", "Doe", 28));
        people.add(new Person("Jane", "Smith", 34));
        people.add(new Person("Alice", "Johnson", 22));
        people.add(new Person("Bob", "Brown", 45));
        people.add(new Person("Charlie", "Davis", 38));
        people.add(new Person("Eva", "Miller", 30));
        people.add(new Person("David", "Wilson", 50));
        people.add(new Person("Emma", "Moore", 27));
        people.add(new Person("Frank", "Taylor", 33));
        people.add(new Person("Grace", "Anderson", 29));

        return people;
    }
    private static double averageAge(ArrayList<Person> people){
        double totalAge = 0;
        for (Person person : people){
            totalAge += person.getAge();
        }
        return totalAge / people.size();
    }
    private static Person oldestPerson(ArrayList<Person> people){
        Person oldestPerson = people.get(0);

        for (Person person : people){
            if (person.getAge() > oldestPerson.getAge()){
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }
    private static Person youngestPerson(ArrayList<Person> people){
        Person youngestPerson = people.get(0);

        for (Person person : people){
            if (person.getAge() < youngestPerson.getAge()){
                youngestPerson = person;
            }
        }

        return youngestPerson;
    }
}
