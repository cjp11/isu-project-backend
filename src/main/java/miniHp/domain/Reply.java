package miniHp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reply {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "content_id")
    private Content content;

    @OneToMany
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "reply_content")
    private String replyContent;

    @CreationTimestamp
    @Column(name = "create_datetime", nullable = false, updatable = false)
    private LocalDate createdTime;

    @UpdateTimestamp
    @Column(name = "update_datetime", nullable = false)
    private LocalDate updatedTime;



}
