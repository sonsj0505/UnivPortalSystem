package sonsj.UnivPortalSystem.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sonsj.UnivPortalSystem.admin.dto.departmentInfoDto;
import sonsj.UnivPortalSystem.admin.service.departmentService;

@Controller
@RequiredArgsConstructor
public class departmentController {

    private final departmentService departmentService;

    /* 학과 추가 */
    @GetMapping("/admin/department/add")
    public String departmentAdd(Model model, departmentInfoDto requestDtoData){

        // 입력할 값을 dto로 보냄
        model.addAttribute("requestDtoData", requestDtoData);

        return "admin/departmentAdd";
    }

    @PostMapping("/admin/department/add")
    public String departmentAddComplete(@ModelAttribute("requestDtoData") departmentInfoDto data) {

        // 입력한 값을 db에 저장
        departmentService.departmentAdd(data.toEntity());

        // 학과 조회

        return "redirect:/admin/department/add";
    }
}
