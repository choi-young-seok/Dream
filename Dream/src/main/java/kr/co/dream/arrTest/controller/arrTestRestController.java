package kr.co.dream.arrTest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class arrTestRestController {

	@RequestMapping(value = "/arrTestRegister", method = RequestMethod.POST)
	@ResponseBody
	public String arrTest(@RequestBody arrTestList arrTestList){
		List<arrTestVO> arrTests = arrTestList.getArrTestList();
		System.out.println(arrTests.size());
		for(int i=0;i < arrTests.size();i++){
			System.out.println(arrTests.get(i).toString());
		}
		return "success";
	}
	
//	public String arrTest(@RequestBody arrTestVO a){
//		System.out.println(a.toString());
//		return "success";
//	}
	
}
