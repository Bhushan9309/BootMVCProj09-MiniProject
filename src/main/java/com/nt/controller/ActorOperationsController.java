package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.service.IActorMgmtService;
import com.nt.vo.ActorVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class ActorOperationsController {
	  @Autowired
	  private IActorMgmtService actorService;
	
          @GetMapping("/")
          public String showHome()
          {
        	  System.out.println("ActorOperationsController.showHome()");
        	  //return LVN
        	  return "welcome";
          }
          @GetMapping("/report")   //GET --(G)
          public String showReport(Map<String, Object> map) {
        	  System.out.println("ActorOperationsController.showReport()");
        	  //use Service
        	  List<ActorVO> listVO=actorService.showAllActorDetails();
        	  //put the data in model attribute
        	  map.put("listVO", listVO);
        	  //return LVN
        	  return "show_result";
          }
          @GetMapping("/add") //for launching add employee form page
          public String addActorFormPage(@ModelAttribute("actor") ActorVO vo)
          {
        	  System.out.println("ActorOperationsController.addActorFormPage()");
        	  //return LVN
        	  return "register_actor_form";
          }
			/*@PostMapping("/add")
			public String saveActor(@ModelAttribute("actor") ActorVO vo,
				                                 Map<String, Object> map )
			{
			  System.out.println("ActorOperationsController.saveActor()");
			  //use service
			  String msg=actorService.saveActor(vo);
			  List<ActorVO> listVO=actorService.showAllActorDetails();
			  //keep results in model attributes
			  map.put("resultMsg", msg);
			  map.put("listVO", listVO);
			  //return LVN
			  return "show_result";
			}*/
			/*@PostMapping("/add") //POST (P)
			 public String saveActor(@ModelAttribute("actor") ActorVO vo,
				                                 RedirectAttributes attrs )
			 {
			  System.out.println("ActorOperationsController.saveActor()");
			  //use service
			  String msg=actorService.saveActor(vo);
			  //keep results in model attributes
			  attrs.addFlashAttribute("resultMsg", msg);
			  //return LVN
			  return "redirect:report";   //Redirect (R)
			 }*/
          @PostMapping("/add") //POST (P)
		   public String saveActor(@ModelAttribute("actor") ActorVO vo,
		 		                                 RedirectAttributes attrs, Map<String, Object> map)
		   {
       try { 	  
		 	  System.out.println("ActorOperationsController.saveActor()");
		 	  //use service
		 	  String msg=actorService.saveActor(vo);
		 	  //keep results in model attributes
		 	  attrs.addFlashAttribute("resultMsg", msg);
		 	  //return LVN
		 	  return "redirect:report";   //Redirect (R)
		   }
       catch(Exception e) {
    	   System.out.println(e.getMessage());
    	   map.put("errorMsg",e.getMessage());
    	   return "show_error";
       }
 }    
			  @GetMapping("/edit") //for launching edit actor form page
			   public String editActorFormPage(@RequestParam("no") Integer no,
			 		                                                @ModelAttribute("actor") ActorVO actorVO)
			   {
			 	  //use service
			 	  ActorVO actorVO1=actorService.showActorById(no);
			 	  BeanUtils.copyProperties(actorVO1, actorVO);
			 	  //return LVN
			 	  return "edit_actor_form";
			   }
          
          @PostMapping("/edit") //for launching edit actor form page
          public String editActorFormPage( @ModelAttribute("actor") ActorVO actorVO,
        		                                                 RedirectAttributes attrs )
          {
        	  //use service
        	  String msg=actorService.editActor(actorVO);
        	  //keep the result in model attribute
        	  attrs.addFlashAttribute("resultMsg",msg);
        	  //redirect the request
        	  return "redirect:report";
          }
          
          @GetMapping("/delete")
          public String deleteActor(@RequestParam("no") int id,
        		                                   RedirectAttributes attrs)
          {
        	  //use service
        	  String msg=actorService.deleteActorById(id);
        	  //keep the results in model attributes
        	  attrs.addFlashAttribute("resultMsg",msg);
        	  //redirect the request
        	  return "redirect:report";
          }
}
