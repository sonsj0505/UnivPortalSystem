package sonsj.UnivPortalSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sonsj.UnivPortalSystem.domain.student;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {
}