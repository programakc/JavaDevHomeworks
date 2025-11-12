package ru.klgd.javadev.attestation03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "cinema")
@SQLDelete(sql = "UPDATE cinema.users SET is_deleted = true WHERE id = ?")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    private String fio;

    private Integer age;

    @Column(nullable = false)
    private String email;

    private LocalDate regdate;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    public User(String nickname, String password, String fio, Integer age,
                String email, LocalDate regdate) {

        this.nickname = nickname;
        this.password = password;
        this.fio = fio;
        this.age = age;
        this.email = email;
        this.regdate = regdate;
    }
}
