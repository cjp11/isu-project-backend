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
@Table(name = "CONTENT")
public class Content {

    @Id
    @GeneratedValue
    @Column(name = "id")
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
    private LocalDate createdTime;

    @UpdateTimestamp
    @Column(name = "update_datetime", nullable = false)
    private LocalDate updatedTime;

    @Column(name = "view_count")
    private int viewCount;

    @Column(name = "delete_yn")
    private Character deleteYn;


}
