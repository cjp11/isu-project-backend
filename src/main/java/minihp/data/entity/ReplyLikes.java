package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "reply_likes")
public class ReplyLikes {

    @Id
    @Column(name = "reply_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Reply reply;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
