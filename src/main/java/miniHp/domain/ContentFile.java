package miniHp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContentFile {

    @OneToMany
    @JoinColumn(name = "content_id")
    private Content content;

    @OneToMany
    @JoinColumn(name = "file_id")
    private File file;

    @Column
    private Character thumbnail;
}
