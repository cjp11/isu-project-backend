package miniHp.domain;

import jakarta.persistence.*;

import java.util.Date;

@Table(name="guestbook")
@Entity
public class GuestBook {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;
    @Column
    private int homepage_id;
    @Column
    private int member_id;
    @Column
    private String text;
    @Column
    private Date create_datetime;
    @Column
    private char delete_yn;

}
