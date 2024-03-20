package minihp.data.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Table(name = "content")
@NoArgsConstructor
@DynamicInsert
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(length = 500)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String text;

    @CreationTimestamp
    @Column(name = "create_datetime", nullable = false, updatable = false)
    private LocalDateTime createDatetime;

    @UpdateTimestamp
    @Column(name = "update_datetime", nullable = false)
    private LocalDateTime updateDatetime;

    @Column(name = "view_count", nullable = false)
    @ColumnDefault("0")
    private Long viewCount;

    @Column(name = "delete_yn")
    private String deleteYn;

    @OneToMany(mappedBy = "content")
    private List<ContentFile> contentFile = new ArrayList<>();

    @OneToMany(mappedBy = "content", cascade = {REMOVE})
    private List<Reply> replyList = new ArrayList<>();

    @Builder
    public Content(Long id, Member member, Category category, String title, String text) {
        this.id = id;
        this.member = member;
        this.category = category;
        this.title = title;
        this.text = text;
    }

    @PrePersist
    public void prePersist() {
        this.viewCount = this.viewCount == null ? 0L : this.viewCount;
    }
}
