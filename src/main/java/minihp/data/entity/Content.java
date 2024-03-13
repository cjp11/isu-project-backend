package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue
    @Column(name = "content_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String title;

    private String text;

    @CreationTimestamp
    @Column(name = "create_datetime", nullable = false, updatable = false)
    private LocalDateTime createDatetime;

    @UpdateTimestamp
    @Column(name = "update_datetime", nullable = false)
    private LocalDateTime updateDatetime;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "delete_yn")
    private String deleteYn;

    @OneToMany(mappedBy = "content")
    private List<ContentFile> contentFile = new ArrayList<>();

    @OneToMany(mappedBy = "content")
    private List<Reply> replyList = new ArrayList<>();

}
