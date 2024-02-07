package miniHp.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="visitcount")
public class VisitCount {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;
    @Column
    private int homepage_id;
    @Column
    private int member_id;
    @Column
    private Date create_datetime;

}
