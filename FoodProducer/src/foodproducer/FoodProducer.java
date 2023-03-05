package foodproducer;

import foodproducer.IFoodProducer;

import java.util.Scanner;

public class FoodProducer implements IFoodProducer{
	IFoodProducer ms;

//	@Override
	public int buy(int qty, int prices) {
		return qty * prices;
	}
//method
	public void printintro() {
		//declaring variables
		int choice, qty = 0;
		float agb= 800,alb=400;
		float mp=1200,mb=900 ;
		float di=600,dw=400 ;
		float sum = 0;
		float total=0, count=0;
		char ans;
		//output
		do {
		System.out.println("*************************************");
		System.out.println("Welcome to Smart City Food Store");
		System.out.println("*************************************");
		Scanner dc= new Scanner(System.in);
		System.out.println("Which food Category do you want?");
		System.out.println(" 1. Starter");
		System.out.println(" 2. Meal");
		System.out.println(" 3. Dessert");
		choice=dc.nextInt();
		dc.nextLine();
		int number = 0;
		if(choice==1) {
			System.out.println(" Which food item would you like to order?");
			System.out.println(" 1. Cured salmon with prawns  LKR 800");
			System.out.println(" 2. Smoked Salmon LKR 400");
			number=dc.nextInt();
			dc.nextLine();
			
				if(number==1) {
					System.out.println(" Enter quantity:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(agb*qty);
						System.out.println("This Section Current total: LKR"+sum);
						
				} else if(number==2) {
					System.out.println(" Enter quantity:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(alb*qty);
						System.out.println("The Section Current total: LKR"+sum);
				}
		} else if(choice==2) {
			
			System.out.println(" Which food item would you like to order?");
			System.out.println(" 1. Nasigorang  LKR 1200");
			System.out.println(" 2. Burgers LKR 900");
			number=dc.nextInt();
			dc.nextLine();
			
				if(number==1) {
					System.out.println(" Enter quantity:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(mp*qty);
						System.out.println("The Section Current total: LKR"+sum);
				} else if(number==2) {
					System.out.println(" Enter quantity:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(mb*qty);
						System.out.println("The Section Current total: LKR"+sum);
				}
		} else if(choice==3) {
			
			System.out.println(" Which food item would you like to order?");
			System.out.println(" 1. Lava Cake with Ice cream  LKR 600");
			System.out.println(" 2. Brownies LKR 400");
			number=dc.nextInt();
			dc.nextLine();
			
				if(number==1) {
					System.out.println(" Enter quantity:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(di*qty);
						System.out.println("This Section Current total: LKR"+sum);
				} else if(number==2) {
					System.out.println(" Enter quantity:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(dw*qty); 
						System.out.println("This Section Current total: LKR"+sum);}
		
		
		
		
	}
		System.out.println(" Would you like to order more(y/n)?");
		ans=dc.next().charAt(0);
		total=total+sum;
		sum=0;
		count=count+1;
		
		}  while(ans=='y');
		System.out.println("*************************************");
		System.out.println(" Number of Orders:"+ count);
		
		
		System.out.println(" Total bill is: LKR"+ total);
		System.out.println("*************************************");
		
		return;
	}
}
