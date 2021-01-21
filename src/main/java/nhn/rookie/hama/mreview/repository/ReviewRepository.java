package nhn.rookie.hama.mreview.repository;

import nhn.rookie.hama.mreview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
