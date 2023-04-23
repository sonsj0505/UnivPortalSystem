package sonsj.UnivPortalSystem.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sonsj.UnivPortalSystem.admin.domain.department;
import sonsj.UnivPortalSystem.admin.dto.departmentInfoDto;
import sonsj.UnivPortalSystem.admin.service.departmentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class departmentController {

    private final departmentService departmentService;

    /* 학과 리스트 조회 */
    @GetMapping("/admin/department/list")
    public String departmentList(Model model, departmentInfoDto requestDtoData){

        // 입력할 값을 dto로 보냄
        model.addAttribute("requestDtoData", requestDtoData);

        List<department> viewAllDepartmentData = departmentService.departmentList();

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
    public String departmentInfo(@PathVariable("id") Integer id) {

        return "/admin/departmentInfo";
    }
}