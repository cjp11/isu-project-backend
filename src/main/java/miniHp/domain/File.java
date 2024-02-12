package miniHp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class File {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private String path;

    @Column
    private String type;

    @Column(name = "org_name")
    private String orgName;
}
