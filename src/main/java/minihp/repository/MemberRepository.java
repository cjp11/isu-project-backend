package minihp.repository;

import jakarta.transaction.Transactional;
import minihp.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member,Integer> {
    Member findByEmail(String email);

}
