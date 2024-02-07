package miniHp.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="music")
public class Music {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;
    @Column
    private int homepage_id;
    @Column
    private String name;
    @Column
    private String link;
    @Column
    private Date create_datetime;
    @Column
    private char delete_yn;

}
