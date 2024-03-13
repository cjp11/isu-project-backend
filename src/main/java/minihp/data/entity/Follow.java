package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
@Table(name="follow")
public class Follow {

    @Id @Column(name = "following_id")
    private Long id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "following_id")
    private Member following;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private Member follower;

    @Column
    private Date create_datetime;
}
