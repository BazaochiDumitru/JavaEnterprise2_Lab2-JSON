package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadJSON {
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        // Crearea unui obiect de analiză JSON pentru a analiza fișierul citit
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("students.json"))
        {
            // Citirea JSON file
            // Parsarea JSON din fișier
            Object obj = jsonParser.parse(reader);

            // Conversia obiectului la JSONArray
            JSONArray studentList = (JSONArray) obj;
            System.out.println(studentList); // Afișarea listei de studenți

            // Iterarea prin lista de studenți și parsarea fiecărui obiect student
            studentList.forEach(st -> parseStudentObject((JSONObject) st));

            // Tratarea excepției
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseStudentObject(JSONObject student)
    {
        // Obținerea obiectul elevului în listă
        JSONObject studentObject = (JSONObject) student.get("student");

        // Obținerea id studentului
        String id = (String) studentObject.get("id");
        System.out.println("\nStudent id: "  + id);

        // Obținerea numele studentului
        String firstname = (String) studentObject.get("firstname");
        System.out.println("First Name: "  + firstname);

        // Obținerea prenumele studentului
        String lastname = (String) studentObject.get("lastname");
        System.out.println("Last Name: "  + lastname);

        // Obținerea obiectul studentului
        String subject = (String) studentObject.get("subject");
        System.out.println("Subject: "  + subject);

        // Obținerea notei studentului
        String marks = (String) studentObject.get("marks");
        System.out.println("Marks: "  + marks);
    }
}
