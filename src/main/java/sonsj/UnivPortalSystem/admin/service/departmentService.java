package sonsj.UnivPortalSystem.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sonsj.UnivPortalSystem.admin.domain.department;
import sonsj.UnivPortalSystem.admin.repository.departmentRepository;

@Service
@RequiredArgsConstructor
public class departmentService {
    private final departmentRepository departmentRepository;

    public void departmentAdd(department departmentData) {
        departmentRepository.save(departmentData);
    }
}