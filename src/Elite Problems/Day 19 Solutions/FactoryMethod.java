
/*
A Factory Method Design Pattern or Factory Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.

The Factory Method Pattern is also known as Virtual Constructor.

Advantage of Factory Design Pattern
Factory Method Pattern allows the sub-classes to choose the type of objects to create.
It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code. That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class.


*/


//Calculate Electricity bill a real world Example.

// Step1 

//We are going to create a Plan abstract class. 

import java.io.*; 

abstract class Plan

{
 protected double rate;
 abstract void getRate();
 public void calculateBill(int units)
 {
  System.out.println(units * rate);
 }
} //end of Plan class.




// Step 2 
//We are going to create a Concrete classes that extends Plan abstract class. 

class DomesticPlan extends Plan {
 //@override
 public void getRate() {
  rate = 3.50;
 }
} //end of DomesticPlan class.



class CommercialPlan extends Plan {
 //@override 
 public void getRate() {
  rate = 7.50;
 }
} //end of CommercialPlan class.



class InstitutionalPlan extends Plan {
 //@override
 public void getRate() {
  rate = 5.50;
 }
} //end of InstitutionalPlan class.





// Step 3 
//Create a GetPlanFactory to generate object of concrete classes based on given information.


class GetPlanFactory {
 //use getPlan method to get object of type Plan 
 public Plan getPlan(String planType) {

  if (planType == null) {
   return null;
  }

  if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
   return new DomesticPlan();
  } else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
   return new CommercialPlan();
  } else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
   return new InstitutionalPlan();
  }
  return null;
 }
} //end of GetPlanFactory class.




// Step 4
//Use the GetPlanFactory to get the object of concrete classes by passing an information such as type(DOMESTICPLAN/COMMERCIALPLAN/INSTITUTIONALPLAN).


class FactoryMethod {

 public static void main(String args[]) throws IOException {

  GetPlanFactory planFactory = new GetPlanFactory();
  //get an object of DomesticPaln and call its getPlan()method.
  //But we want to calculate the bill for one plan at time not all.for this we IO concept.

  System.out.print("1) DOMESTICPLAN\n");
  System.out.print("2) COMMERCIALPLAN\n");
  System.out.print("3) INSTITUTIONALPLAN\n");
  System.out.print("Enter the name of plan for which the bill will be generated: ");
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  String planName = br.readLine();

  System.out.print("Enter the number of units for bill will be calculated: ");

  int units = Integer.parseInt(br.readLine());


  Plan p = planFactory.getPlan(planName);

  //call getRate() method and calculateBill()method of DomesticPaln.

  System.out.print("Bill amount for " + planName + " of  " + units + " units is: ");
  p.getRate();
  p.calculateBill(units);


 }
} //end of GenerateBill class.
