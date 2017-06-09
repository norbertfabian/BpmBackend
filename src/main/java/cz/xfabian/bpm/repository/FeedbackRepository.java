package cz.xfabian.bpm.repository;

import cz.xfabian.bpm.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Norbert Fábián on 6/9/2017.
 */
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
