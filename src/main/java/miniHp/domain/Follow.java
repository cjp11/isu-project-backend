package miniHp.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="follow")
@IdClass(Follow.class)
public class Follow {

    @Id
    @Column(name="following_id", nullable = false)
    private int following_id;

    @Id
    @Column(name="follower_id", nullable = false)
    private int follower_id;
    @Column
    private Date create_datetime;
}
