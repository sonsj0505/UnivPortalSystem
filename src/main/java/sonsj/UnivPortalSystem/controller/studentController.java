package sonsj.UnivPortalSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sonsj.UnivPortalSystem.dto.studentRequiredInfoDto;
import sonsj.UnivPortalSystem.service.studentService;

@Controller
@RequiredArgsConstructor
public class studentController {

    private final studentService studentService;

    @GetMapping("studentJoin")
    public String studentJoin(Model model, studentRequiredInfoDto requestDtoData){

        // 입력할 값을 dto로 보냄
        model.addAttribute("requestDtoData", requestDtoData);
        return "student/studentJoin";
    }

    @PostMapping("studentJoin")
    public String studentJoinComplete(@ModelAttribute("requestDtoData") studentRequiredInfoDto data, Model model) {

        //입력한 값 view로 넘김
        model.addAttribute("studentNumber", data.getStudentNumber());
        model.addAttribute("name", data.getName());
        model.addAttribute("email", data.getEmail());

        // 입력한 값을 db에 저장
        studentService.studentJoinComplete(data.toEntity());

        return "student/studentJoin";
    }

}