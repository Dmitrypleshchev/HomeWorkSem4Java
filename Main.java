/*Организовать ввод и хранение данных пользователей. ФИО возраст, пол и выход из режима ввода информации
вывод в формате Фамилия И.О. возраст пол
добавить возможность выхода или вывода списка отсортированного по возрасту!)
*реализовать сортировку по возрасту с использованием индексов
*реализовать сортировку по возрасту и полу с использованием индексов*/

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
