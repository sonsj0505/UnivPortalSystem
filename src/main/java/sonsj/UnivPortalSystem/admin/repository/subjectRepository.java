package sonsj.UnivPortalSystem.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sonsj.UnivPortalSystem.admin.domain.subject;

import java.util.Optional;

@Repository
public interface subjectRepository extends JpaRepository<subject, Integer> {

    Optional<subject> findByDepartmentId(int id);
}