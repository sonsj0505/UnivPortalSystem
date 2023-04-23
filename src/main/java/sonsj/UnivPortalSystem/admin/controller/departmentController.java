package sonsj.UnivPortalSystem.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sonsj.UnivPortalSystem.admin.domain.department;
import sonsj.UnivPortalSystem.admin.domain.subject;
import sonsj.UnivPortalSystem.admin.dto.departmentInfoDto;
import sonsj.UnivPortalSystem.admin.dto.subjectInfoDto;
import sonsj.UnivPortalSystem.admin.model.SubjectType;
import sonsj.UnivPortalSystem.admin.service.departmentService;
import sonsj.UnivPortalSystem.admin.service.subjectService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class departmentController {

    private final departmentService departmentService;
    private final subjectService subjectService;

    /* 학과 리스트 조회 */
    @GetMapping("/admin/department/list")
    public String departmentList(Model model, departmentInfoDto requestDtoData){

        // 입력할 값을 dto로 보냄
        model.addAttribute("requestDtoData", requestDtoData);

        List<department> viewAllDepartmentData = departmentService.departmentListAllRead();

        model.addAttribute("departmentData", viewAllDepartmentData);

        return "/admin/departmentList";
    }

    /* 학과 추가 */
    @PostMapping("/admin/department/list")
    public String departmentAdd(@ModelAttribute("requestDtoData") departmentInfoDto data) {

        // 입력한 값을 db에 저장
        departmentService.departmentAdd(data.toEntity());

        return "redirect:/admin/department/list";
    }

    /* 학과 정보 조회 */
    @GetMapping("/admin/department/info/{id}")
    public String departmentInfo(Model model, @PathVariable("id") Integer id) {

        //학과 정보
        department departmentData = departmentService.departmentInfo(id);
        departmentInfoDto res = departmentInfoDto.toDto(departmentData);
        model.addAttribute("departmentInfoData", res);

        //과목 정보
        List<subject> viewAllSubjectData = subjectService.subjectListAllRead(id);
        model.addAttribute("subjectData", viewAllSubjectData);

        return "/admin/departmentInfo";
    }

    /* 학과별 과목 추가 */
    @GetMapping("/admin/department/{departmentId}/subject/add")
    public String subjectAdd(Model model, @PathVariable("departmentId") Integer departmentId) {

        //학과 id
        model.addAttribute("departmentId", departmentId);

        //이수구분 status
        Map<String, String> subjectTypeList = new HashMap<>();
        subjectTypeList.put(SubjectType.MAJOR_REQUIRED.getKey(), SubjectType.MAJOR_REQUIRED.getValue());
        subjectTypeList.put(SubjectType.MAJOR_OPTION.getKey(), SubjectType.MAJOR_OPTION.getValue());
        subjectTypeList.put(SubjectType.ELECTIVE_REQUIRED.getKey(), SubjectType.ELECTIVE_OPTION.getValue());
        subjectTypeList.put(SubjectType.ELECTIVE_OPTION.getKey(), SubjectType.ELECTIVE_OPTION.getValue());
        model.addAttribute("subjectTypeList", subjectTypeList);

        return "/admin/subjectAdd";
    }

    /* 학과별 과목 추가 */
    @PostMapping("/admin/department/{departmentId}/subject/add")
    public String subjectAddComplete(@PathVariable("departmentId") Integer departmentId, @ModelAttribute("requestDtoData") subjectInfoDto data) {

        subjectService.subjectAdd(data.toEntity());

        return "redirect:/admin/department/info/"+departmentId;
    }
}