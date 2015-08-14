package writingTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmployeeDetails {
	EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	EmployeeDetails employee = new EmployeeDetails();

	@Test
	public void testCalculateAppriasal() {
		employee.setName("Rajeev");
		employee.setAge(35);
		employee.setMonthlySalary(8000); 
		double appraisal = empBusinessLogic.calculateAppraisal(employee);
		Assert.assertEquals(5000, appraisal, 0.0, "5000");
	}

	@Test
	public void testCalculateYearlySalary() {
		employee.setName("Rajeev");
		employee.setAge(35);
		employee.setMonthlySalary(8000);
		double salary = empBusinessLogic.calculateYearlySalary(employee);
		Assert.assertEquals(96000, salary, 0.0, "8000");
	}
}