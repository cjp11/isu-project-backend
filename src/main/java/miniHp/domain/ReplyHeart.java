package miniHp.domain;

import jakarta.persistence.*;

@Entity
@Table(name="reply_heart")
public class ReplyHeart {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;
    @Column
    private int reply_id;
    @Column
    private int member_id;
}
