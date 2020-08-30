package idv.jay.EmpModel.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.jay.EmpModel.EmpDao.EmpDao;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDao empDao;
	
	public EmpServiceImpl() {
		super();
		System.out.println("EmpServiceImpl");
	}

	@Override
	public void addEmp() {
		// TODO Auto-generated method stub
		empDao.addEmp();
	}
}
