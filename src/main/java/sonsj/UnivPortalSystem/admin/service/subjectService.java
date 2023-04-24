package sonsj.UnivPortalSystem.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sonsj.UnivPortalSystem.admin.domain.subject;
import sonsj.UnivPortalSystem.admin.repository.subjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class subjectService {
    private final subjectRepository subjectRepository;

    public void subjectAdd(subject subjectData) {

        subjectRepository.save(subjectData);
    }

    public List<subject> subjectListAllRead(Integer id) {

        //학과별 과목 전체 조회
        List<subject> allSubjectData = subjectRepository.findByDepartmentId(id);

        return allSubjectData;
    }
}
