package nhn.rookie.hama.mreview.repository;

import nhn.rookie.hama.mreview.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
