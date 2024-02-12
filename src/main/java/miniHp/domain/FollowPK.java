package miniHp.domain;



import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.io.Serializable;
public class FollowPK implements Serializable {

    @Id
    @Column(name="following_id", nullable = false)
    private int following_id;

    @Id
    @Column(name="follower_id", nullable = false)
    private int follower_id;


}
