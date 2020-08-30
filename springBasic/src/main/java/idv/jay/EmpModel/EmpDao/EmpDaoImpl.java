package idv.jay.EmpModel.EmpDao;

import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao{

	public EmpDaoImpl() {
		super();
		System.out.println("EmpDaoImpl");
	}

	@Override
	public void addEmp() {
		// TODO Auto-generated method stub
		System.out.println("EmpDaoImpl: add success");
	}
	
}
