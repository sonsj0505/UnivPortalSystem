package sonsj.UnivPortalSystem.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sonsj.UnivPortalSystem.student.domain.student;

import java.util.Optional;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {
    Optional<student> findByStudentNumber(Long studentNumber);
}