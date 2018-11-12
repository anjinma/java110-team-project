package indiesker.java110.ms.web;

import java.io.File;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import indiesker.java110.ms.domain.Member;
import indiesker.java110.ms.service.MemberService;

@RequestMapping("/signup/member")
@Controller //managerListContoller 라고 Spring이 자동으로 이름 지어줌
public class MemberController{

   MemberService memberService;
   ServletContext sc;


   public MemberController(MemberService memberService, ServletContext sc) {
     this.memberService = memberService;
     this.sc = sc;
   }

   @RequestMapping("form")
   public void form() {
   }

   @PostMapping("add")
   public String add(String type,
           Member m,
           MultipartFile file1) throws Exception  {
       if (file1.getSize() > 0) {
           String filename = UUID.randomUUID().toString();
           file1.transferTo(new File(sc.getRealPath("/upload/" + filename)));
           m.setPhoto(filename);
       }
       System.out.println(type);
       memberService.add(m);
       if(type.equals("fan")) {
         return "redirect:form";         
       }else if(type.equals("busker")) {
         return "redirect:form";  
       }else if(type.equals("support")) {
         return "redirect:form";  
       }else {
         return "redirect:form";  
       }
   }

   @ResponseBody
   @RequestMapping("checkId")
   public int checkId(String id, Model model) throws Exception {
     return memberService.checkId(id);
   }

   @ResponseBody
   @RequestMapping("checkEmail")
   public int checkEmail(String email, Model model) throws Exception {
     return memberService.checkEmail(email);
   }

   @ResponseBody
   @RequestMapping("checkNick")
   public int checkNickname(String nickname, Model model) throws Exception {
     return memberService.checkNickname(nickname);
   }

}