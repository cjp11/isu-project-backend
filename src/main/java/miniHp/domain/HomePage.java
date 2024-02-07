package miniHp.domain;

import jakarta.persistence.*;

@Entity
@Table(name="homepage")
public class HomePage {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;
    @Column
    private int memberId;
    @Column
    private String name;
    @Column
    private String nickname;
    @Column
    private String profile_image;
    @Column
    private  String introduce;
    @Column
    private String theme;
    @Column
    private char weather;
}
