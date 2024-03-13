package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Table(name="guestbook")
@Getter
@Entity
public class GuestBook {

    @Id
    @Column(name="guestbook_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;

    @ManyToOne
    @JoinColumn(name = "homepage_id")
    private HomePage homePage;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @Column
    private String text;
    @Column(name = "create_datetime")
    private Date createDatetime;
    @Column(name = "delete_yn")
    private String deleteYn;

}
