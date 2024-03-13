package minihp.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name="homepage")
public class HomePage {

    @Id
    @Column(name="homepage_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private Long id;
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @Column
    private String name;
    @Column
    private String nickname;
    @Column(name = "profile_image")
    private String profileImage;
    @Column
    private  String introduce;
    @Column
    private String theme;
    @Column
    private char weather;

    @OneToMany(mappedBy = "homePage")
    private List<Music> musicList;
}
