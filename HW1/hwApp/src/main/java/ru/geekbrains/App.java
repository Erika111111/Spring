package ru.geekbrains;

public class App 
{
    public static void main( String[] args )
    {
        Person person = new Person("Andrey", "Mityukov", 33);
        Person person1 = new Person("Alena", "Portnova", 32);

        String json = person.toJson();
        System.out.println("JSON: " + json);

    }
}
