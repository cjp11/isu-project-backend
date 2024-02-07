package miniHp.domain;

import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 auto_increment
    private int id;
    @Column
    private int home_id;
    @Column
    private String name;

}
