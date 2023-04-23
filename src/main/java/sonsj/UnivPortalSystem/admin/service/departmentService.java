package sonsj.UnivPortalSystem.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sonsj.UnivPortalSystem.admin.domain.department;
import sonsj.UnivPortalSystem.admin.repository.departmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class departmentService {
    private final departmentRepository departmentRepository;

    public void departmentAdd(department departmentData) {

        //학과 추가
        departmentRepository.save(departmentData);
    }

    public List<department> departmentListAllRead() {

        //학과 전체 조회
        List<department> allDepartmentData = departmentRepository.findAll();

        return allDepartmentData;
    }

    public department departmentInfo(int id) {
        department departmentInfoData = departmentRepository.findById(id).get();

        return departmentInfoData;
    }
}