package sonsj.UnivPortalSystem.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sonsj.UnivPortalSystem.admin.domain.department;

@Repository
public interface departmentRepository extends JpaRepository<department, Integer> {
}
