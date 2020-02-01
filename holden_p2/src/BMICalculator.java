/*
 * The main function calls readUnitType()
 * We read in whether the user is using metric or imperial
 * Based on that answer, we prompt the user for their corresponding weight and height measurement types
 * When the user inputs height, we call a function to set that height in a variable, same with the weight
 * 
 * The main function calls calculateBmi()
 * We use functions to get the weight and height variables previously stored and make the BMI calculation based on unit type
 * We call a function to find the corresponding BMI category
 * We store both of these (BMI and category) in variables to fetch later
 * 
 * The main function calls displayBmi()
 * We get the bmi and bmi category to output
 * We output the bmi and make sure to only display to 1 decimal point
 * We output the category
 * 
 * We close the Scanner to prevent memory leak.
 */

import java.util.Scanner;

public class BMICalculator {
	private String unitType;
	
	private float weight;
	private float height;
	
	private String bmiCategory;
	private float bmi;
	
	Scanner input = new Scanner(System.in);
	
	public void readUserData() {
		System.out.print("Please enter which unit system you would like. 'm' for metric and 'i' for imperial: ");
		String unitType = readUnitType();
		readMeasurementData(unitType);
	}
	
	private String readUnitType() {
		String unitType;
		
		while(true){
			if(input.hasNext("i") || input.hasNext("m")) {
				unitType = input.next();
				break;
			} else {
				System.out.print("Please enter 'i' or 'm' to desiginate unit type: ");
				input.next();
			}
		}
		
		this.unitType = unitType;
		return unitType;
	}
	
	private void readMeasurementData(String unitType) {		
		if(unitType.equals("m")) {
			readMetricData();
		} else if(unitType.equals("i")) {
			readImperialData();
		}
	}
	
	private void readMetricData() {		
		System.out.print("Please enter your height in meters: ");
		
		while(!input.hasNextFloat()) {
			System.out.print("Please enter a valid height: ");
			input.next();
		}
		
		float metricHeight = input.nextFloat();
		if(metricHeight < 0) {
			System.out.print("Invalid");
			System.exit(0);
		}
		setHeight(metricHeight);
		
		System.out.print("Please enter your weight in kilograms: ");
		
		while(!input.hasNextFloat()) {
			System.out.print("Please enter a valid weight: ");
			input.next();
		}
		
		float metricWeight = input.nextFloat();
		if(metricWeight < 0) {
			System.out.print("Invalid");
			System.exit(0);
		}
		setWeight(metricWeight);
	}
	
	private void readImperialData() {
		System.out.print("Please enter your height in inches: ");
		
		while(!input.hasNextFloat()) {
			System.out.print("Please enter a valid height: ");
			input.next();
		}
		
		float imperialHeight = input.nextFloat();
		if(imperialHeight < 0) {
			System.out.print("Invalid");
			System.exit(0);
		}
		setHeight(imperialHeight);
		
		System.out.print("Please enter your weight in pounds: ");
		
		while(!input.hasNextFloat()) {
			System.out.print("Please enter a valid weight: ");
			input.next();
		}
		
		float imperialWeight = input.nextFloat();
		if(imperialWeight < 0) {
			System.out.print("Invalid");
			System.exit(0);
		}
		setWeight(imperialWeight);
	}
	
	public void calculateBmi() {
		float bmi = 0;
		float weight = getWeight();
		float height = getHeight();
		String unitType = this.unitType;
		
		if(unitType.equals("m")) {
			bmi = weight / (height * height);
		} else if(unitType.equals("i")) {
			bmi = (703 * weight) / (height * height);
		}	
		
		this.bmi = bmi;
		calculateBmiCategory(bmi);
	}
	
	private void calculateBmiCategory(float bmi) {
		String bmiCategory = "";
		
		if(bmi < 18.5) {
			bmiCategory = "Underweight";
		}
		else if(bmi >= 18.5 && bmi < 25) {
			bmiCategory = "Normal Weight";
		}
		else if(bmi >= 25 && bmi < 30) {
			bmiCategory = "Overweight";
		}
		else if(bmi >= 30) {
			bmiCategory = "Obese";
		}
		
		this.bmiCategory = bmiCategory;
	}
	
	public void displayBmi() {
		float bmi = getBmi();
		String bmiCategory = getBmiCategory();
		
		System.out.println("===========================");
		System.out.printf("Your BMI is: %.1f \n", bmi);
		System.out.println("Based on your BMI you are: " + bmiCategory);
		
		this.input.close();
	}
	
	public float getWeight() {
		return this.weight;
	}
	
	private void setWeight(float weight) {
		this.weight = weight;
	}
	
	public float getHeight() {
		return this.height;
	}
	
	private void setHeight(float height) {
		this.height = height;
	}
	
	public float getBmi() {
		return this.bmi;
	}
	
	public String getBmiCategory() {
		return this.bmiCategory;
	}
}
