package homeworks.homework12;

import java.util.Objects;

public class Person implements ExceptionMessages{

    private String lastName;
    private String firstName;
    private String middleName;
    private String date;
    private Integer phoneNumber;
    private char gender;
    private Integer age;

    public Person() {
    }

    public Person(String str) {

        String[] enteredString = str.split(" ");

        if (enteredString.length != 7) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_ARGS);
        }

        if (enteredString[0].chars().allMatch(Character::isLetter)) {
            this.lastName = enteredString[0];
        } else {
            throw new IllegalArgumentException(INCORRECT_NAME);
        }

        if (enteredString[1].chars().allMatch(Character::isLetter)) {
            this.firstName = enteredString[1];
        } else {
            throw new IllegalArgumentException(INCORRECT_NAME);
        }

        if (enteredString[2].chars().allMatch(Character::isLetter)) {
            this.middleName = enteredString[2];
        } else {
            throw new IllegalArgumentException(INCORRECT_NAME);
        }

        if (enteredString[3].matches("^((0?[1-9]|[12][0-9]|3[01])\\." +
                "(0?[1-9]|1[012])\\.(19|20)\\d\\d)$")) {

            this.date = enteredString[3];
        } else {
            throw new IllegalArgumentException(INCORRECT_DATE);
        }

        if ((enteredString[4].chars().allMatch(Character::isDigit)
                && Integer.parseInt(enteredString[4]) > 0)) {

            this.phoneNumber = Integer.parseInt(enteredString[4]);
        } else {
            throw new IllegalArgumentException(INCORRECT_PHONE_NUMBER);
        }

        if (enteredString[5].length() == 1 && (enteredString[5].equals("f")
                || enteredString[5].equals("m"))) {

            this.gender = enteredString[5].charAt(0);
        } else {
            throw new IllegalArgumentException(INCORRECT_GENDER);
        }

        if (enteredString[6].chars().allMatch(Character::isDigit)
                && Integer.parseInt(enteredString[6]) > 0
                && Integer.parseInt(enteredString[6]) < 125) {

            this.age = Integer.parseInt(enteredString[6]);
        } else {
            throw new IllegalArgumentException(INCORRECT_AGE);
        }
    }

    public Person(String lastName, String firstName, String middleName, String date
            , Integer phoneNumber, char gender, Integer age) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return gender == person.gender && Objects.equals(firstName
                , person.firstName) && Objects.equals(lastName, person.lastName)
                && Objects.equals(middleName, person.middleName)
                && Objects.equals(date, person.date) && Objects.equals(phoneNumber
                , person.phoneNumber) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, date, phoneNumber, gender, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", date='" + date + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}