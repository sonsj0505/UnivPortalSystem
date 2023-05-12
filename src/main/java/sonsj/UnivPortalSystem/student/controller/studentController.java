package sonsj.UnivPortalSystem.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sonsj.UnivPortalSystem.admin.domain.department;
import sonsj.UnivPortalSystem.admin.domain.subject;
import sonsj.UnivPortalSystem.admin.service.departmentService;
import sonsj.UnivPortalSystem.student.domain.student;
import sonsj.UnivPortalSystem.student.dto.studenetLoginDto;
import sonsj.UnivPortalSystem.student.dto.studentEditDto;
import sonsj.UnivPortalSystem.student.dto.studentJoinDto;
import sonsj.UnivPortalSystem.student.model.StudentStatus;
import sonsj.UnivPortalSystem.student.service.studentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class studentController {

    private final studentService studentService;
    private final departmentService departmentService;

    /* 로그인 */
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

    /* 회원가입 */
    @GetMapping("/student/join")
    public String studentJoin(Model model, studentJoinDto requestDtoData){

        //학과 정보 가져오기
        List<department> departmentList = departmentService.departmentListAllRead();
        model.addAttribute("departmentList", departmentList);

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

    /* 학생 정보 조회 */
    @GetMapping("/student/info/{studentNumber}")
    public String studentInfo(@PathVariable Long studentNumber, Model model) {

        //학생 데이터 조회
        student studentData = studentService.studentInfo(studentNumber);
        studentJoinDto studentDtoData = studentJoinDto.toDto(studentData);

        //학생 상태 enum의 value로 받기
        StudentStatus studentStatusValue = studentDtoData.getStudentStatus();

        model.addAttribute("name", studentDtoData.getName());
        model.addAttribute("email", studentDtoData.getEmail());
        model.addAttribute("studentStatus", studentStatusValue.getValue());
        model.addAttribute("department", studentDtoData.getDepartment().getName());

        return "student/studentInfo";
    }


    /* 학생 정보 수정 */
    @GetMapping("/student/edit/{studentNumber}")
    public String studentEdit(@PathVariable Long studentNumber,
                              @ModelAttribute("requestDtoData") studentJoinDto data, Model model) {

        // 1 모든 학생 상태 리스트로 받고
        Map<String, String> studentStatusList = new HashMap<>();
        studentStatusList.put(StudentStatus.FRESHMAN.getKey(), StudentStatus.FRESHMAN.getValue());
        studentStatusList.put(StudentStatus.UNDERGRADUATE.getKey(), StudentStatus.UNDERGRADUATE.getValue());
        studentStatusList.put(StudentStatus.GRADUATE.getKey(), StudentStatus.GRADUATE.getValue());
        studentStatusList.put(StudentStatus.LEAVEOFABSENCE.getKey(), StudentStatus.LEAVEOFABSENCE.getValue());

        // 2 수정 대상 데이터 받고
        student studentData = studentService.studentInfo(studentNumber);
        studentJoinDto studentDtoData = studentJoinDto.toDto(studentData);

        // 3 데이터 view로 넘기기
        model.addAttribute("studentStatusList", studentStatusList);
        model.addAttribute("name", studentDtoData.getName());
        model.addAttribute("email", studentDtoData.getEmail());
        model.addAttribute("studentStatus", studentDtoData.getStudentStatus().getKey());
        model.addAttribute("departmentName", studentData.getDepartment().getName());

        return "student/studentEdit";
    }

    @PutMapping("/student/edit/{studentNumber}")
    public String studentEditComplete(@PathVariable Long studentNumber,
                              @ModelAttribute("requestDtoData") studentEditDto dtoData) {
        studentService.studentEdit(studentNumber, dtoData.toEntity());
        return "redirect:/student/info/"+studentNumber;
    }

    /* 수강 신청 */
    @GetMapping("/student/{studentNumber}/registCourse")
    public String studentRegistCourse(@PathVariable Long studentNumber, Model model) {

        //학생 데이터 조회
        student studentData = studentService.studentInfo(studentNumber);
        studentJoinDto studentDtoData = studentJoinDto.toDto(studentData);
        model.addAttribute("subjectList", studentDtoData.getDepartment().getSubject());

        return "student/studentRegistCourse";
    }

    @PostMapping("/student/{studentNumber}/registCourse")
    public String studentRegistCourseComplete(@ModelAttribute("requestDtoData") studenetLoginDto dtoData, Model model) {

        student studentData = dtoData.toEntity();

        return "redirect:/student/info/"+studentData.getStudentNumber();
    }
}