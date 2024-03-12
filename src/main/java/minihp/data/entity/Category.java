package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name="category")
public class Category {

    @Id
    @Column(name="category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private Long id;

    @Column
    private String name;

    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;

    @Column(name = "delete_yn")
    private String deleteYn;

    @ManyToOne
    @JoinColumn(name = "homepage_id")
    private HomePage homePageId;

}
