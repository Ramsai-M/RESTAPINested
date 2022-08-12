import org.testng.Assert;
import org.testng.annotations.Test;

import Files.ComplexReusable;
import io.restassured.path.json.JsonPath;
public class SumValidation {

	@Test
	public void sumOfCourses() {
		JsonPath js=new JsonPath(ComplexReusable.coursePrice());
		int count= js.getInt("courses.size()");
		int sum=0;
		for(int i=0;i<count;i++) {
			int crsprice=js.getInt("courses["+i+"].price");
			int cop=js.getInt("courses["+i+"].copies");
			int amount=crsprice*cop;
			System.out.println(amount);
			sum=sum+amount;
		}
		System.out.println(sum);
		int PurAmount=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, PurAmount);
	}
	
}
