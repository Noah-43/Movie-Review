package nhn.rookie.hama.mreview.repository;

import nhn.rookie.hama.mreview.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // coalesce(expression1, ...n)는 지정한 표현식들 중에 NULL이 아닌 첫 번깨 값을 반환
    @Query("select m, mi, avg(coalesce(r.grade,0)), count(distinct r) from Movie m " +
            "left outer join MovieImage mi on mi.movie = m " +
            "left outer join Review r on r.movie = m group by m")
    Page<Object[]> getListPage(Pageable pageable); // 페이지 처리

    @Query("select m, mi, avg(coalesce(r.grade,0)), count(r) " +
            " from Movie m left outer join MovieImage mi on mi.movie = m " +
            " left outer join Review r on r.movie = m " +
            "where m.mno = :mno group by mi")
    List<Object[]> getMovieWithAll(Long mno); // 특정 영화 조회
}
