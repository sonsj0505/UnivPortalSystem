package sonsj.UnivPortalSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sonsj.UnivPortalSystem.domain.student;
import sonsj.UnivPortalSystem.dto.studenetLoginDto;
import sonsj.UnivPortalSystem.dto.studentJoinDto;
import sonsj.UnivPortalSystem.service.studentService;

@Controller
@RequiredArgsConstructor
public class studentController {

    private final studentService studentService;

    @GetMapping("/student/login")
    public String studentLogin(Model model, studenetLoginDto dtoData) {

        //studenetLoginInfoDto에 입력 값을 받음
        model.addAttribute("requestDtoData", dtoData);

        return "student/studentLogin";
    }

    @PostMapping("/student/login")
    public String studentLoginComplete(@ModelAttribute("requestDtoData") studenetLoginDto dtoData, Model model) {

        student studentData = dtoData.toEntity();

        studentService.studentLogin(studentData);

        return "redirect:/student/info/"+studentData.getStudentNumber();
    }

    @GetMapping("/student/info/{studentNumber}")
    public String studentInfo(@PathVariable Long studentNumber, Model model) {

        student studentData = studentService.studentInfo(studentNumber);

        model.addAttribute("name", studentData.getName());
        model.addAttribute("email", studentData.getEmail());

        return "student/studentInfo";
    }

    @GetMapping("/student/join")
    public String studentJoin(Model model, studentJoinDto requestDtoData){

        // 입력할 값을 dto로 보냄
        model.addAttribute("requestDtoData", requestDtoData);
        return "student/studentJoin";
    }

    @PostMapping("/student/join")
    public String studentJoinComplete(@ModelAttribute("requestDtoData") studentJoinDto data) {

        // 입력한 값을 db에 저장
        studentService.studentJoinComplete(data.toEntity());

        return "redirect:/student/login";
    }

}