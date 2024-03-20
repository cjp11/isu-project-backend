package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "content_likes")
public class ContentLikes {

    @Id
    @Column(name="content_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private Long id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "content_id")
    private Content content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
