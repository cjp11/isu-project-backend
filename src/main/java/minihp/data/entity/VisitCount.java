package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Table(name="visitcount")
public class VisitCount {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;

    @ManyToOne
    @JoinColumn(name = "homepage_id")
    private HomePage homePage;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;

}
