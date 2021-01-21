package nhn.rookie.hama.mreview.repository;

import nhn.rookie.hama.mreview.entity.Member;
import nhn.rookie.hama.mreview.entity.Movie;
import nhn.rookie.hama.mreview.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // @EntityGraph는 엔티티의 특정한 속성을 같이 로딩하도록 표시하는 어노테이션(특정 기능을 수행할 때만 EAGER 로딩 지정 가)
    // attributePaths - 로딩 설정을 변경하고 싶은 속성의 이름을 배열로 명시
    // type - @EntityGraph를 어떤 방식으로 적용할 것인지 설정
    // FETCH: 명시한 속성은 EAGER로 처리, 나머지 LAZY 처리.
    // LOAD: 명시한 속선은 EAGER로 처리, 나머지는 엔티티 클래스에 명시되거나 기본 방식으로 처리.
    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    @Modifying // update나 delete를 이용하기 위해서 반드시 필요
    @Query("delete from Review mr where mr.member = :member") // 이렇게 @Query를 사용하면 삭제가 한 번에 일어남
    void deleteByMember(Member member);
}
