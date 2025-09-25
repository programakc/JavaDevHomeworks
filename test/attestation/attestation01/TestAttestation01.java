package attestation.attestation01;

import attestation.attestation01.model.User;
import attestation.attestation01.repository.Impl.UsersRepositoryFileImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TestAttestation01 {

    UsersRepositoryFileImpl urfi = new UsersRepositoryFileImpl();

    @Test
    void testCreatePositive() {
        User user = new User("00000000-4fbc-4504-9233-576e156e8a03" +
                "|2024-03-11T23:10:11.556|original_41|jd6yen|jd6yen|Семёнов|Виктор|Андреевич|32|true");
        urfi.create(user);

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(user);
            Assertions.assertEquals("00000000-4fbc-4504-9233-576e156e8a03", user.getId());
            Assertions.assertEquals(LocalDateTime.parse("2024-03-11T23:10:11.556"), user.getDate());
            Assertions.assertEquals("original_41", user.getLogin());
            Assertions.assertEquals("jd6yen", user.getPassword());
            Assertions.assertEquals("jd6yen", user.getConfirmPassword());
            Assertions.assertEquals("Семёнов", user.getLastName());
            Assertions.assertEquals("Виктор", user.getFirstName());
            Assertions.assertEquals("Андреевич", user.getMiddleName());
            Assertions.assertEquals(Integer.parseInt("32"), user.getAge());
            Assertions.assertEquals(Boolean.parseBoolean("true"), user.getWorker());
        });
    }

    @Test
    void testCreateNegative() { // different password
        User user = new User("00000000-4fbc-4504-9233-576e156e8a03" +
                "|2024-03-11T23:10:11.556|original_41|jd6yen|jd6y|Семёнов|Виктор|Андреевич|32|true");
        urfi.create(user);

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(user);
            Assertions.assertEquals("00000000-4fbc-4504-9233-576e156e8a03", user.getId());
            Assertions.assertEquals(LocalDateTime.parse("2024-03-11T23:10:11.556"), user.getDate());
            Assertions.assertEquals("original_41", user.getLogin());
            Assertions.assertEquals("jd6yen", user.getPassword());
            Assertions.assertEquals("jd6yen", user.getConfirmPassword()); //
            Assertions.assertEquals("Семёнов", user.getLastName());
            Assertions.assertEquals("Виктор", user.getFirstName());
            Assertions.assertEquals("Андреевич", user.getMiddleName());
            Assertions.assertEquals(Integer.parseInt("32"), user.getAge());
            Assertions.assertEquals(Boolean.parseBoolean("true"), user.getWorker());
        });
    }

    @Test
    void testFindByIdPositive() {
        User user = new User("00000000-4fbc-4504-9233-576e156e8a03" +
                "|2024-03-11T23:10:11.556|original_41|jd6yen|jd6yen|Семёнов|Виктор|Андреевич|32|true");
        urfi.findById(user.getId());

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(user.getId());
            Assertions.assertEquals("00000000-4fbc-4504-9233-576e156e8a03", user.getId());
        });
    }

    @Test
    void testFindByIdNegative() { // different password
        User user = new User("00000000-4fbc-4504-9233-576e156e8a03" +
                "|2024-03-11T23:10:11.556|original_41|jd6yen|jd6yen|Семёнов|Виктор|Андреевич|32|true");
        urfi.findById(user.getId());

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(user.getId());
            Assertions.assertEquals("00110000-4fbc-4504-9233-576e156e8a03", user.getId());
        });
    }
}
