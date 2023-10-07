package org.example;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSON {
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        // Studentul 1
        // Crearea unui obiect nou JSON numit studentDetails
        JSONObject studentDetails = new JSONObject();
        studentDetails.put("id", "101");
        studentDetails.put("firstname", "Olga");
        studentDetails.put("lastname", "Criclivaia");
        studentDetails.put("subject", "Math");
        studentDetails.put("marks", "9");

        // Crearea unui obiect nou JSON numit studentObject
        JSONObject studentObject = new JSONObject();
        studentObject.put("student", studentDetails);

        // Studentul 2
        JSONObject studentDetails2 = new JSONObject();
        studentDetails2.put("id", "102");
        studentDetails2.put("firstname", "Valentina");
        studentDetails2.put("lastname", "Advahova");
        studentDetails2.put("subject", "Chemistry");
        studentDetails2.put("marks", "8");

        JSONObject studentObject2 = new JSONObject();
        studentObject2.put("student", studentDetails2);

        // Studentul 3
        JSONObject studentDetails3 = new JSONObject();
        studentDetails3.put("id", "103");
        studentDetails3.put("firstname", "Alina");
        studentDetails3.put("lastname", "Gutul");
        studentDetails3.put("subject", "English");
        studentDetails3.put("marks", "10");

        JSONObject studentObject3 = new JSONObject();
        studentObject3.put("student", studentDetails3);

        // Studentul 4
        JSONObject studentDetails4 = new JSONObject();
        studentDetails4.put("id", "104");
        studentDetails4.put("firstname", "Nadejda");
        studentDetails4.put("lastname", "Ianciuc");
        studentDetails4.put("subject", "Physics");
        studentDetails4.put("marks", "7");

        JSONObject studentObject4 = new JSONObject();
        studentObject4.put("student", studentDetails4);

        // Adaugarea studentilor in lista
        JSONArray studentList = new JSONArray();
        studentList.add(studentObject);
        studentList.add(studentObject2);
        studentList.add(studentObject3);
        studentList.add(studentObject4);

        //  Inscriere in Json file
        // Crearea unui obiect Filewriter pentru deschiderea fisierului students.json
        try (FileWriter file = new FileWriter("students.json")) {
            // Metoda write din FileWriter pentru a scrie instanta JSONArray sau JSONObject într-un fișier
            file.write(studentList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}