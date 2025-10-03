package ru.klgd.javadev.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    private String id;
    private LocalDateTime date = LocalDateTime.now();
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private Boolean isWorker = false;

    public User() {
    }

    public User(String inputLine) {
        String[] params = inputLine.split("\\|");

        this.id = params[0];
        this.date = LocalDateTime.parse(params[1]);
        this.login = params[2];
        this.password = params[3];
        this.confirmPassword = params[4];
        this.lastName = params[5];
        this.firstName = params[6];
        this.middleName = params[7];
        this.age = Integer.parseInt(params[8]);
        this.isWorker = Boolean.parseBoolean(params[9]);
    }

    public User(String id, LocalDateTime date, String login, String password,
                String confirmPassword, String lastName, String firstName,
                String middleName, Integer age, Boolean isWorker) {

        this.id = id;
        this.date = date;

        if (isCorrectLogin(login)) this.login = login;

        if (isCorrectPassword(password)) this.password = password;

        if (isCorrectConfirmPassword(password, confirmPassword))
            this.confirmPassword =
                    confirmPassword;

        if (isCorrectLastName(lastName)) this.lastName = lastName;

        if (isCorrectFirstName(firstName)) this.firstName = firstName;

        if (isCorrectMiddleName(middleName)) this.middleName = middleName;

        if (isCorrectAge(String.valueOf(age))) this.age = age;

        this.isWorker = isWorker;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (isCorrectLogin(login)) this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isCorrectPassword(password)) this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        if (isCorrectConfirmPassword(this.password, confirmPassword))
            this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (isCorrectLastName(lastName)) this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (isCorrectFirstName(firstName)) this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (isCorrectMiddleName(middleName)) this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (isCorrectAge(String.valueOf(age))) this.age = age;
    }

    public Boolean getWorker() {
        return isWorker;
    }

    public void setWorker(Boolean worker) {
        isWorker = worker;
    }

    public void update(User user) {
        this.id = user.getId();
        this.date = LocalDateTime.now();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.confirmPassword = user.getConfirmPassword();
        this.lastName = user.getLastName();
        this.firstName = user.getFirstName();
        this.middleName = user.getMiddleName();
        this.age = user.getAge();
        this.isWorker = user.getWorker();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(date, user.date)
                && Objects.equals(login, user.login) && Objects.equals(password
                , user.password) && Objects.equals(confirmPassword
                , user.confirmPassword) && Objects.equals(lastName
                , user.lastName) && Objects.equals(firstName, user.firstName)
                && Objects.equals(middleName, user.middleName) && Objects.equals
                (age, user.age) && Objects.equals(isWorker, user.isWorker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, login, password, confirmPassword, lastName
                , firstName, middleName, age, isWorker);
    }

    @Override
    public String toString() {
        return (id + "|" + date + "|" + login + "|" + password + "|"
                + confirmPassword + "|" + lastName + "|" + firstName + "|"
                + middleName + "|" + age + "|" + isWorker);
    }

    private Boolean isCorrectLogin(String login) {
        if ((login.length() < 20 && !login.chars().allMatch(Character::isDigit))
                && (login.matches("\\w+"))) {
            return true;
        } else {
            throw new IllegalArgumentException("Недопустимый формат логина!");
        }
    }

    private Boolean isCorrectPassword(String password) {
        if ((password.length() < 20 && !password.chars().allMatch(Character::isLetter))
                && (password.matches("\\w+"))) {
            return true;
        } else {
            throw new IllegalArgumentException("Недопустимый формат пароля!");
        }
    }

    private Boolean isCorrectConfirmPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return true;
        } else {
            throw new IllegalArgumentException("Пароли не совпадают!");
        }
    }

    private Boolean isCorrectLastName(String lastName) {
        if (lastName.chars().allMatch(Character::isLetter)) {
            return true;
        } else {
            throw new IllegalArgumentException("Фамилия пользователя должна " +
                    "содержать только буквы!");
        }
    }

    private Boolean isCorrectFirstName(String firstName) {
        if (firstName.chars().allMatch(Character::isLetter)) {
            return true;
        } else {
            throw new IllegalArgumentException("Имя пользоателя должно " +
                    "сожержать только буквы!");
        }
    }

    private Boolean isCorrectMiddleName(String middleName) {
        if (middleName.chars().allMatch(Character::isLetter) || middleName.isEmpty()) {
            return true;
        } else {
            throw new IllegalArgumentException("Отчество пользователя должно " +
                    "содержать только буквы либо отсутствовать!");
        }
    }

    private Boolean isCorrectAge(String age) {
        if ((age.chars().allMatch(Character::isDigit) && Integer.parseInt(age) > 0)
                || age.isEmpty()) {
            return true;
        } else {
            throw new IllegalArgumentException("Возраст пользователя должен " +
                    "быть числом больше 0 либо отсутствовать!");
        }
    }
}
