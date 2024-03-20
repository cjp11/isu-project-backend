package minihp.repository;


import minihp.data.entity.Category;
import minihp.data.entity.Content;
import minihp.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    @Query("SELECT c,m.nickname,ct.name " +
            "from Content c " +
            "join c.member m " +
            "join c.category ct " +
            "where " +
            "m.id = :memberId and ct.id = :categoryId")
    List<Content> findByMemberIdAndCategoryId(Long memberId, Long categoryId);
}
