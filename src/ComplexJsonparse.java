import io.restassured.path.json.JsonPath;
import Files.ComplexReusable;

public class ComplexJsonparse {

	public static void main(String[] args) {
		JsonPath js=new JsonPath(ComplexReusable.coursePrice());
		//Print No of courses returned by API
		int count= js.getInt("courses.size()");
		System.out.println("No of Courses are: "+count);
		//Print Purchase Amount
		int PurAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase amount is:"+PurAmount);
		//Print Title of the first course
		String frstTtle=js.getString("courses[0].title");
		System.out.println("First title name in courses is: "+frstTtle);
		//Print All course titles and their respective Prices
		int sum=0;
		for(int i=0;i<count;i++) {
			String crstitle=js.getString("courses["+i+"].title");
			System.out.println("Course Title: "+crstitle);
			int crsprice=js.getInt("courses["+i+"].price");
			System.out.println("Course price: "+crsprice);
			//Print no of copies sold by RPA Course
			if(crstitle.equalsIgnoreCase("RPA")) {
				int cop=js.getInt("courses["+i+"].copies");
				System.out.println("No of RPA Courses copes sold: "+cop);
			}
		}
		//Verify if Sum of all Course prices matches with Purchase Amount
		
	}
}
