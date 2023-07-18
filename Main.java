/*Организовать ввод и хранение данных пользователей. ФИО возраст, пол и выход из режима ввода информации
вывод в формате Фамилия И.О. возраст пол
добавить возможность выхода или вывода списка отсортированного по возрасту!)
*реализовать сортировку по возрасту с использованием индексов
*реализовать сортировку по возрасту и полу с использованием индексов*/


/*class User{
  private String fullName;
  private int age;
  private String gender;
  public User (String fullName, int age, String gender) {
    this.age = age;
    this.gender = gender;
    this.fullName = fullName;
  }
public String getFullName() {
  return fullName;
}
public int getAge() {
  return age;
}

public String getGender() {
  return gender;
}

public void displayUser() {
  System.out.println (fullName + " " + age + " " + gender);
}
}*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main{
  private static List users = new ArrayList();
  private static int currentIndex = 0;

  class User{
  private String fullName;
  private int age;
  private String gender;
  public User (String fullName, int age, String gender) {
    this.age = age;
    this.gender = gender;
    this.fullName = fullName;
  }
public String getFullName() {
  return fullName;
}
public int getAge() {
  return age;
}

public String getGender() {
  return gender;
}

public void displayUser() {
  System.out.println (fullName + " " + age + " " + gender);
}
}
  public static void  main (String[] args) {
    Scanner scanner = new Scanner (System.in);

    while (true) {
      System.out.println("Введите команду: ");
      String command = scanner.nextLine().toLowerCase();

      if (command.equals("add")){
        addUser(scanner);
      }
      else if (command.equals("list")) {
        listUsers();
      }
      else if (command.equals("sort by age")) {
        sortByAge();
        listUsers();
      }
      else if (command.equals("sort by age and gender")) {
        sortByAgeAndGender();
        listUsers();
      }
      else if (command.equals("exit")) {
        break;
      }
      else{
        System.out.println("Команда неверная. Попробуйте снова)");
      }
    }
   }


}