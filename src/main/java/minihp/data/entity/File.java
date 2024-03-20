package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String path;

    @Column
    private String type;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;

    @Column(name = "update_datetime")
    private LocalDateTime updateDatetime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "delete_yn")
    private String deleteYn;
}
