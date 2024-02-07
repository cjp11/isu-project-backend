package miniHp.domain;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private Long id;
    @Column
    private String member_id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;
    @Column
    private String register_type;

    @Column
    private Date birth_Date;
    @Column
    private String gender;
    @Column
    private String address;





}
