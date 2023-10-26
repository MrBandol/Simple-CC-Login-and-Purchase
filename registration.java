package quiz3;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class registration{
	Scanner sc = new Scanner(System.in);
	private Integer firstCreditCardNum;
	private Integer finalCreditCardNum;
	private Integer cvvNum;
	private String cardHolderName;
	private Double creditLimit;
	
	registration(Integer firstCreditCardNum, Integer finalCreditCardNum, Integer cvvNum, String cardHolderName, Double creditLimit){
		this.setFirstCreditCardNum(firstCreditCardNum);
		this.setFinalCreditCardNum(finalCreditCardNum);
		this.setCvvNum(cvvNum);
		this.setCardHolderName(cardHolderName);
		this.setCreditCardLimit(creditLimit);
	
	}
	

	//Entry Dialogue
	public void welcome() {
		System.out.println("Enter any key : ");
		sc.nextLine();
		
		System.out.println("Would you like to Log-in or Register?\n1 to Log-in, 2 to Register ");
		String ans = sc.nextLine();
		loop:
			while(true) {
				if(ans.contains("1")) {
					try {
						fileCreate();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break loop;
				}
				else if(ans.contains("2")) {
					credCardRegister();
					break loop;
				}
				else {
					System.out.println("Try Again (1 to Log-in, 2 to Register) : ");
					ans = sc.nextLine();
				}
			}
	}
	//Registration Dialogue
	public void credCardRegister() {
		
		//First 8 characters of Credit Card
		System.out.println("Please Enter First 8 characters of your Credit Card Number : ");
		this.setFirstCreditCardNum(sc.nextInt());
		loop:
			while(true) {
				String convertFirstCredNum = this.firstCreditCardNum.toString();
					try {
					if(convertFirstCredNum.length() == 8) {
						System.out.println("Your First 8 characters are : " + this.firstCreditCardNum);
						break loop;
					}
					else if (convertFirstCredNum.length() !=8){
						System.out.println("Too few and/or many characters"
								+ "\nPlease try again : ");
						this.setFirstCreditCardNum(sc.nextInt());
					}
				}
				catch(InputMismatchException e) {
					System.out.println("You may have entered a letter");
					this.setFirstCreditCardNum(sc.nextInt());
	
			}
					
		}
		//Final 8 characters of Credit Card
		System.out.println("Please Enter the Final 8 characters of your Credit Card Number : ");
		this.setFinalCreditCardNum(sc.nextInt());
		loop:
			while(true) {
				String convertFinalCredNum = this.finalCreditCardNum.toString();
				try {
					if(convertFinalCredNum.length() == 8) {
						System.out.println("Your Final 8 characters are : " + this.finalCreditCardNum);
						break loop;
					}
					else if (convertFinalCredNum.length() !=8){
						System.out.println("Too few and/or many characters"
											+ "\nPlease try again : ");
						this.setFirstCreditCardNum(sc.nextInt());
					}
				}
				catch(InputMismatchException e) {
					System.out.println("You may have entered a letter\n"
							+ "Please try again : ");
					this.setFinalCreditCardNum(sc.nextInt());
				}
					
		}
		System.out.println("Your Full Credit Card Number : "+ this.firstCreditCardNum+""+this.finalCreditCardNum);
		cvvNum();		
		
	}
	//CVV Number
	public void cvvNum() {
		System.out.println("Please provide a CVV Number : ");
		this.setCvvNum(sc.nextInt());
		loop:
			while(true) {
				String convertCVVNum = this.cvvNum.toString();
				try {
					if(convertCVVNum.length() == 4) {
						System.out.println("Your provided CVV Number is : ");
						break loop;
					}
					else {
						System.out.println("INVALID CVV Number (4 digits)"
										+ "\nPlease provide a CVV Number : ");
						this.setCvvNum(sc.nextInt());
					}
				}
				catch(InputMismatchException e) {
					System.out.println("You may have entered a letter\n"
										+ "Please try again : ");
					this.setCvvNum(sc.nextInt());
				}
		}
		System.out.println("Your CVV Num is : " + this.cvvNum);
		cardHolderName();
	}
	//Card Holder Name
	public void cardHolderName() {
		System.out.println("Please Enter the Card Holder's Name : ");
		this.setCardHolderName(sc.next());
		System.out.println("Thank You "+this.cardHolderName);
		creditLimit();
		
	}
	//Credit Limit
	public void creditLimit() {
		System.out.println("Please provide your Credit Limit (limit 200000)");
		this.setCreditCardLimit(sc.nextDouble());
		loop:
			while(true) {
				if(creditLimit <= 200000) {
					System.out.println("Your Credit Limit is : " + this.creditLimit);
					break loop;
				}
				else
					System.out.println("You have entered a number that is beyond the Limit\n"
										+ "Please try again : ");
					this.setCreditCardLimit(sc.nextDouble());
			}
		
		try {
			fileCreate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Login Dialogue
	public void login() {
		//First 8 characeters
		System.out.println("Please enter the first 8 characters of your Credit Card Number :");
		Integer firstNum = sc.nextInt();
		loop:
			while(true) {
				if(firstNum.equals(this.firstCreditCardNum)) {
					System.out.println("SUCCESS");
					break loop;
				}
				else {
					System.out.println("UNIDENTIFIED NUMBER\nTry again : ");
					firstNum = sc.nextInt();
				}
		}
		//Final 8 characters
		System.out.println("Please enter the final 8 characters of your Credit Card Number : ");
		Integer finalNum = sc.nextInt();
		loop:
			while(true) {
				if(finalNum.equals(this.finalCreditCardNum)) {
					System.out.println("SUCCESS");
					break loop;
				}
				else {
					System.out.println("UNIDENTIFIED NUMBER\nTry again : ");
					firstNum = sc.nextInt();
				}
			}
		//CVV Number
		System.out.println("Please enter CVV Number : ");
		Integer cvvNumber = sc.nextInt();
		loop:
			while(true) {
				if(cvvNumber.equals(this.cvvNum)) {
					System.out.println("SUCCESS");
					break loop;
				}
				else {
					System.out.println("UNIDENTIFIED NUMBER\nTry again : ");
					firstNum = sc.nextInt();
				}
			}
		//Card Holders Name
		System.out.println("Please enter the Card Holder's Name :  ");
		String cardHolder = sc.next();
		loop:
			while(true) {
				if(cardHolder.equals(this.cardHolderName.toLowerCase())) {
					System.out.println("SUCCESS");
					break loop;
				}
				if(cardHolder.equals(this.cardHolderName.toUpperCase())) {
					System.out.println("SUCCESS");
					break loop;
				}
				if(cardHolder.equals(this.cardHolderName)) {
					System.out.println("SUCCESS");
					break loop;
				}
				else {
					System.out.println("UNIDENTIFIED CARD HOLDER NAME\nTry Again : ");
					cardHolder = sc.next();
					
				}
			}
		System.out.println("Login SUCCESS\nWould you like to buy some things on the market? 1 to buy items, 2 to exit program");
		int ansYN = sc.nextInt();
		loop:
			while(true) {
				switch(ansYN) {
				case 1: try {
						buyingPhase();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							break loop;
				case 2: System.out.println("Thank You and Good Bye");
							displayAndExit();
							break loop;
				default: System.out.println("INVALID INPUT 1 to buy, 2 to exit");
						 ansYN = sc.nextInt();
				}
				
			}
	
	}
	//File Creation
	public void fileCreate(){
		System.out.println("We will now be creating a file for your Account Details");
		try {
			File newAccount = new File("CC_"+"BandolsBank_"+this.firstCreditCardNum+this.finalCreditCardNum+"_"+this.cardHolderName+".txt");
			if(!newAccount.exists()) {
				newAccount.createNewFile();
				System.out.println("File Created : "+newAccount.getName());
				System.out.println("File Absolute Path : "+newAccount.getAbsolutePath());
				fileWrite();
			}
			else {
				System.out.println("File already exists");
				System.out.println("File Absolute Path :"+newAccount.getAbsolutePath());
				fileWrite();
			}
		}
		catch(Exception e) {
			System.out.println("There was an error that occured");
		}
		
			
	}
	//File Write
	public void fileWrite() throws IOException {
		System.out.println("Writing into files....");
		try {
			FileWriter writer = new FileWriter("CC_"+"BandolsBank_"+this.firstCreditCardNum+this.finalCreditCardNum+"_"+this.cardHolderName+".txt");
			writer.write("First Credit Card Number : "+this.firstCreditCardNum+" ");
			writer.write("Final Credit Card Number : "+this.finalCreditCardNum+" ");
			writer.write("CVV Number : "+this.cvvNum+" ");	
			writer.write("Card Holder Name : "+this.cardHolderName+" ");
			writer.write("Credit Card Limit : "+this.creditLimit.intValue()+" ");
			writer.close();
		}
		catch (Exception e) {
			System.out.println("An error has occured making the file");
			e.printStackTrace();
		}
		System.out.println("File Successfully created and written");
				
		login();
	}
	//Method to buy items
		public void buyingPhase() throws IOException {
			//For Currency
			final double ps4 = 25000;
			final double ps5 = 95000;
			final double smartTv = 50000;
			final double nintendo = 21000;
			final double samsung = 60000;
			//Files that are going to be used
			//HashMap for Items
			HashMap<String, Integer> items = new HashMap<String, Integer>();
			items.put("PS4", 25000);
			items.put("PS5", 95000);
			items.put("Smart Tv", 50000);
			items.put("Nintendo Switch", 21000);
			items.put("Samsung Note 10 Plus", 60000);
			
			System.out.println("Here are your options\n");
			System.out.println(items);
			System.out.println("Pick your desired item/s using the corresponding number(1=PS4, 2=PS5, 3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG NOTE 10 PLUS"
					+ "\nTYPE 6 TO END PURCHASING ITEMS");
			System.out.println("Your Credit Limit : "+this.creditLimit);
			int desiredItems = sc.nextInt();
			loop:
				while(true) {
					switch(desiredItems) {
					case 1 : if(this.creditLimit >= ps4) {
								System.out.println("SUCCESSFULLY BOUGHT PS4");
								this.setCreditCardLimit(creditLimit-ps4);
								//Try and Catch for writing details
								try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CC_"+"BandolsBank_"+this.firstCreditCardNum+this.finalCreditCardNum+"_"+this.cardHolderName+".txt", true));
									writer.append("\nYOU HAVE BOUGHT THE PS4");
									writer.append(" || New Credit Limit : "+this.creditLimit.intValue());
									writer.close();
								}
								catch(Exception e) {
									System.out.println("Error on writing details");
								}
								System.out.println("(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								System.out.println("Your Credit Limit : "+this.creditLimit);
								desiredItems = sc.nextInt();
								break;
							}
							else if(this.creditLimit < ps4){
								System.out.println("YOU HAVE INSUFFICIENT FUNDS\nPICK ANOTHER ITEM OR EXIT(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								desiredItems = sc.nextInt();
								break;
							}
							break;
			
					case 2 : if(this.creditLimit >= ps5) {
								System.out.println("SUCCESSFULLY BOUGHT PS5");
								//Try and Catch for writing details
								try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CC_"+"BandolsBank_"+this.firstCreditCardNum+this.finalCreditCardNum+"_"+this.cardHolderName+".txt", true));
									writer.append("\nYOU HAVE BOUGHT THE PS5");
									writer.append(" || New Credit Limit : "+this.creditLimit.intValue());
									writer.close();					
								}
								catch(Exception e) {
									System.out.println("Error on writing details");
								}
								System.out.println("(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								System.out.println("Your Credit Limit : "+this.creditLimit);
								desiredItems = sc.nextInt();
								break;
							}
							else if(this.creditLimit < ps5){
								System.out.println("YOU HAVE INSUFFICIENT FUNDS\nPICK ANOTHER ITEM OR EXIT(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								desiredItems = sc.nextInt();
								break;
							}
						
					case 3 :  if(this.creditLimit >= smartTv) {
								System.out.println("SUCCESSFULLY BOUGHT SMART TV");
								this.setCreditCardLimit(creditLimit-smartTv);
								//Try and Catch for writing details
								try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CC_"+"BandolsBank_"+this.firstCreditCardNum+this.finalCreditCardNum+"_"+this.cardHolderName+".txt", true));
									writer.append("\nYOU HAVE BOUGHT THE SMART TV");
									writer.append(" || New Credit Limit : "+this.creditLimit.intValue());
									writer.close();
								}
								catch(Exception e) {
									System.out.println("Error on writing details");
								}
								System.out.println("(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								System.out.println("Your Credit Limit : "+this.creditLimit);
								desiredItems = sc.nextInt();
								break;
							}
							else if(this.creditLimit > smartTv){
								System.out.println("YOU HAVE INSUFFICIENT FUNDS\nPICK ANOTHER ITEM OR EXIT(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								desiredItems = sc.nextInt();
								break;
							}
						
					case 4 :  if(this.creditLimit >= nintendo) {
								System.out.println("SUCCESSFULLY BOUGHT NINTENDO SWITCH");
								this.setCreditCardLimit(creditLimit-nintendo);
								//Try and Catch for writing details
								try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CC_"+"BandolsBank_"+this.firstCreditCardNum+this.finalCreditCardNum+"_"+this.cardHolderName+".txt", true));
									writer.append("\nYOU HAVE BOUGHT THE NINTENDO SWITCH");
									writer.append(" || New Credit Limit : "+this.creditLimit.intValue());
									writer.close();
								}
								catch(Exception e) {
									System.out.println("Error on writing details");
								}
			
								System.out.println("(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								System.out.println("Your Credit Limit : "+this.creditLimit);
								desiredItems = sc.nextInt();
								break;
							}
							else if(this.creditLimit < nintendo) {
								System.out.println("YOU HAVE INSUFFICIENT FUNDS\nPICK ANOTHER ITEM OR EXIT(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								desiredItems = sc.nextInt();
								break;
							}
							break;
						
					case 5 :  if(this.creditLimit >= samsung) {
								System.out.println("SUCCESSFULLY BOUGHT SAMSUNG NOTE 10 PLUS");
								this.setCreditCardLimit(creditLimit-samsung);
								//Try and Catch for writing details
								try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CC_"+"BandolsBank_"+this.firstCreditCardNum+this.finalCreditCardNum+"_"+this.cardHolderName+".txt", true));
									writer.append("\nYOU HAVE BOUGHT THE SAMSUNG NOTE 10 PLUS");
									writer.append(" || New Credit Limit : "+this.creditLimit.intValue());
									writer.close();
								}
								catch(Exception e) {
									System.out.println("Error on writing details");
								}
								
								System.out.println("(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								System.out.println("Your Credit Limit : "+this.creditLimit);
								desiredItems = sc.nextInt();
								break;
							}
							else if(this.creditLimit < samsung){
								System.out.println("YOU HAVE INSUFFICIENT FUNDS\nPICK ANOTHER ITEM OR EXIT(1=PS4, 2=PS5,3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG 6=EXIT)");
								desiredItems = sc.nextInt();
								break;
							}
						
					case 6: System.out.println("Thank you for your purchases");
							displayAndExit();
							break loop;
						
						
					default:System.out.println("\"Pick your desired item/s using the corresponding number(1=PS4, 2=PS5, 3=SMART TV, 4=NINTENDO SWITCH, 5=SAMSUNG NOTE 10 PLUS\n" 
												+"\\nTYPE 6 TO END PURCHASING ITEMS");
							desiredItems = sc.nextInt();
					}
				}
			
		}
	//Display and Exit
	public void displayAndExit() {
		System.out.println("'Card Holder Name': "+this.cardHolderName);
		System.out.println("'Credit Card Number': "+(this.firstCreditCardNum)+this.finalCreditCardNum);
		System.out.println("'CVV Number': "+this.cvvNum);
		System.out.println("'Credit Card Limit': "+ this.creditLimit);
		
	}
	//Encapsulation for registry details
	public Integer getFirstCreditCardNum() {
		return this.firstCreditCardNum;
	}
	
	public Integer finalCreditCardNum() {
		return this.finalCreditCardNum;
	}
	
	public Integer getCvvNum() {
		return this.cvvNum;
	}
	
	public String getCardHolderName() {
		return this.cardHolderName;
	}
	
	public Double getCreditLimit() {
		return this.creditLimit;
	}
	
	public void setFirstCreditCardNum(Integer firstCreditCardNum) {
		this.firstCreditCardNum = firstCreditCardNum;
	}
	
	public void setFinalCreditCardNum(Integer finalCreditCardNum) {
		this.finalCreditCardNum = finalCreditCardNum;
	}
	
	public void setCvvNum(Integer cvvNum) {
		this.cvvNum = cvvNum;
	}
	
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
	public void setCreditCardLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

}
