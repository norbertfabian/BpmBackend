package cz.xfabian.bpm.repository;

import cz.xfabian.bpm.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Norbert Fábián on 6/6/2017.
 */
public interface LogRepository extends JpaRepository<Log, Integer> {
}
