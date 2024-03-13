package minihp.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import org.checkerframework.common.aliasing.qual.Unique;

import java.util.Date;

@Entity
@Getter
@Table(name = "member")
public class Member {

    @Id @GeneratedValue
    @Column(name="id", nullable = false)
    private Long id;

    private String email;

    private String password;

    private String name;

    @Column(name = "register_type")
    private String registerType;

    @Column(name = "birth_date")
    private Date birthDate;

    private String gender;

    private String address;

    @Column(name = "delete_yn")
    private String deleteYn;

    @OneToOne(mappedBy = "member")
    private HomePage homePage;

}
