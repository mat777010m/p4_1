/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      Service s = new Service();

      while (true) {
        System.out.print("podaj imie studenta lub 'wypisz': ");
        String name = scanner.nextLine();
        if (name.equalsIgnoreCase("wypisz")) {
          break;
        }

        System.out.print("podaj wiek: ");
        int age;
        try {
          age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("wiek musi byc liczba calkowita");
          continue;
        }

        s.addStudent(new Student(name, age));
      }

      var students = s.getStudents();
      for (Student current : students) {
        System.out.println(current.ToString());
      }
    } catch (IOException e) {
      System.err.println("wystapil blad z odczytem lub zapisem bazy: " + e.getMessage());
    }
  }
}