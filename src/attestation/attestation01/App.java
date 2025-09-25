package attestation.attestation01;

import attestation.attestation01.model.User;
import attestation.attestation01.repository.Impl.UsersRepositoryFileImpl;
import attestation.attestation01.repository.UsersRepository;

public class App {

    public static void main(String[] args) {

        UsersRepository usersRepository = new UsersRepositoryFileImpl();

        System.out.println("\nСчитывание всех пользователей из " +
                "файла:\n" + usersRepository.findAll());

        User user = new User("00000000-4fbc-4504-9233-576e156e8a03" +
                "|2024-03-11T23:10:11.556|original_41|jd6yen|jd6yen|Семёнов|Виктор|Андреевич|32|true");

        usersRepository.create(user);
        System.out.println("\nСоздание нового пользователя:\n" + usersRepository.findAll());

        System.out.println("\nНахождение пользователя по ID: 0d72cb3a-d9ba-4716-8ed2-d6e1d700ac9d");
        System.out.println(usersRepository.findById("0d72cb3a-d9ba-4716-8ed2-d6e1d700ac9d"));

        User user2 = new User("47ab98ba-4fbc-4504-9233-576e156e8a03|2024-05" +
                "-15T19:10:11.556|gr_35|7623hf|7623hf|Петров|Виктор|Сергеевич|29|true");

        usersRepository.update(user2);
        System.out.println("\nОбновление данных пользователя:");
        System.out.println(usersRepository.findAll());

        usersRepository.deleteById("47ab98ba-4fbc-4504-9233-576e156e8a03");
        System.out.println("\nУдаление пользователя по ID:\n" + usersRepository.findAll());

        usersRepository.deleteAll();
        System.out.println("\nУдаление всех пользователей:\n" + usersRepository.findAll());
    }
}
