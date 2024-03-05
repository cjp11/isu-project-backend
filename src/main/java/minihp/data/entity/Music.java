package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Table(name="music")
public class Music {

    @Id
    @Column(name="music_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;
    @ManyToOne
    @JoinColumn(name = "homepage_id")
    private HomePage homePage;
    @Column
    private String name;
    @Column
    private String link;
    @CreatedDate
    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;
    @Column(name = "delete_yn")
    private char deleteYn;

}
