package miniHp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CONTENT")
public class Tag {

    @Id
    private Long id;

    @OneToMany
    @Column(name = "content_id")
    private Content content;

    @Column
    private String name;


}
