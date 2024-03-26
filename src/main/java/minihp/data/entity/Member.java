package minihp.data.entity;


import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id", nullable = false)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String nickname;

    @Column(name = "register_type")
    private String registerType;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String gender;

    private String address;

    @Column(name = "profile_image")
    private String profileImage;

    @Column
    private String introduce;

    @Column(name = "delete_yn")
    private String deleteYn;

    @OneToOne(mappedBy = "member")
    private HomePage homePage;

    @Builder
    public Member(Long id, String email, String password, String name, String nickname, String registerType, LocalDate birthDate, String gender, String address, HomePage homePage, String profileImage, String introduce) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.registerType = registerType;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.homePage = homePage;
        this.introduce = introduce;
        this.profileImage = profileImage;
    }

}
