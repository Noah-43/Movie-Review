package nhn.rookie.hama.mreview.repository;

import nhn.rookie.hama.mreview.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {
}
