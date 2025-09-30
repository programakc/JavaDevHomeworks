package homeworks.homework12;

public interface ExceptionMessages {

    static final String INCORRECT_NUMBER_ARGS = "Неверное " +
            "количество аргументов!";

    static final String INCORRECT_PHONE_NUMBER = "Недопустимый формат номера " +
            "телефона!";

    static final String INCORRECT_GENDER = "Пол должен быть \"f\" или \"m\"!";

    static final String INCORRECT_DATE = "Дата рождения задаётся в формате " +
            "dd.mm.yyyy";

    static final String INCORRECT_NAME = "Имя, фамилия и отчество не могут " +
            "содержать цифры или специальные символы!";

    static final String INCORRECT_AGE = "Возраст не соответствует " +
            "действительности, проверьте!";
}