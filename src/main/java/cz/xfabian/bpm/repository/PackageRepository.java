package cz.xfabian.bpm.repository;

import cz.xfabian.bpm.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Norbert Fábián on 6/6/2017.
 */
public interface PackageRepository extends JpaRepository<Package, Integer> {

    @Query("SELECT p FROM Package p WHERE p.code = :code")
    public Package findByCode(@Param("code") String code);
}
