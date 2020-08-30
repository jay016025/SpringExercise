package idv.jay.EmpModel.EmpController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import idv.jay.EmpModel.EmpService.EmpService;

@Controller("empController")
public class EmpController {
	
	@Autowired(required = true)
	private EmpService empService;
	
//	@Autowired
//	public void setEmpService(EmpService service) {
//		this.empService = service;
//	}
	
	public EmpController() {
		super();
		System.out.println("EmpController");
	}
	
	public void addEmp() {
		empService.addEmp();
	}
}
