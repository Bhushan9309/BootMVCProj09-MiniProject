package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.service.IActorMgmtService;
import com.nt.vo.ActorVO;

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
          @PostMapping("/add") //POST (P)
          public String saveActor(@ModelAttribute("actor") ActorVO vo,
        		                                 Map<String, Object> map )
          {
        	  System.out.println("ActorOperationsController.saveActor()");
        	  //use service
        	  String msg=actorService.saveActor(vo);
        	  //keep results in model attributes
        	  map.put("resultMsg", msg);
        	  //return LVN
        	  return "redirect:report";   //Redirect (R)
          }
          
}
