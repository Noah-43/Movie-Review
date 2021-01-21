package nhn.rookie.hama.mreview.repository;

import nhn.rookie.hama.mreview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
