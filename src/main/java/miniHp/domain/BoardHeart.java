package miniHp.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "board_heart")
public class BoardHeart {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;
    @Column
    private int member_id;
    @Column
    private int content_id;

}
