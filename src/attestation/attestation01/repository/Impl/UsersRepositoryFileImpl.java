package attestation.attestation01.repository.Impl;

import attestation.attestation01.exception.UserNotFoundException;
import attestation.attestation01.model.User;
import attestation.attestation01.repository.UsersRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository {

    private final List<User> USERS = new ArrayList<>();
    private final static String FILENAME = "src/attestation/attestation01/input.txt";

    public UsersRepositoryFileImpl() {
        readFile();
    }

    @Override
    public void create(User user) {
        USERS.add(user);
        writeFile();
    }

    @Override
    public User findById(String id) {
        return USERS
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Пользователь " +
                        "с id: " + id + " не найден!"));
    }

    @Override
    public List<User> findAll() {
        return USERS;
    }

    @Override
    public void update(User user) {

        try {
            User foundedUser = USERS.stream()
                    .filter(e -> e.getId().equals(user.getId()))
                    .findFirst()
                    .orElseThrow(() -> new UserNotFoundException("Пользователь " +
                            "с id: " + user.getId() + " не найден!"));

            foundedUser.update(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            USERS.add(user);
        }

        writeFile();
    }

    @Override
    public void deleteById(String id) {
        USERS.removeIf(user -> user.getId().equals(id));
        writeFile();
    }

    @Override
    public void deleteAll() {
        USERS.clear();
        writeFile();
    }

    private void readFile() {
        List<User> result;

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(FILENAME))) {

            result = bufferedReader.lines()
                    .map(User::new)
                    .toList();

        } catch (IOException e) {
            System.out.println("Не удалось найти файл " + FILENAME);
            result = new ArrayList<>();
        }

        USERS.addAll(result);
    }

    private void writeFile() {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(FILENAME))) {

            for (User u : USERS) {
                bufferedWriter.write(u.toString() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Не удалось найти файл " + FILENAME);
        }
    }
}
