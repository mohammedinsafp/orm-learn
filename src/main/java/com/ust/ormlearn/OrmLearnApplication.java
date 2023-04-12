package com.ust.ormlearn;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.ust.ormlearn.Service.CountryService;
import com.ust.ormlearn.model.Country;
@SpringBootApplication
public class OrmLearnApplication {
	private static CountryService countryService;
	public static void main(String[] args) throws InvocationTargetException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class); 
		 Scanner sc=new Scanner(System.in);
		 while(true) {
			 System.out.println("\n"+"\n"+"\n"+"Enter the option "+"\n"+ "1.View the all datas "+"\n"+"2.View by code"
			 		+ "\n"+"3.Add country"+"\n"+"4.update country"+"\n"+"5.Delete country");
			 int number=sc.nextInt();
		 switch(number) {
		 case 1:testGetAllCountries();
		 		break;
		 case 2:getCountryByCodeTest();
	 			break;
		 case 3:testAddCountry();
	 		break;
		 case 4:testUpdateCountry();
	 		break;
		 case 5:testDeleteCountry();
	 		break;
	 	default:System.out.println("Enter numbe between 0-5");
	 		break;
		 }
		 }	
	}
	public static void testGetAllCountries() {
		List<Country> countries = countryService.getAllCountry();
		System.out.println("Inside application class after calling service"+countries);
		for(Country con:countries) {
			System.out.println(con);
		}
	}
	private static void getCountryByCodeTest(){ 
		Scanner sc=new Scanner(System.in);
		Country country = countryService.findCountryByCode(sc.nextLine());
		System.out.println(country);
	}
	public static void testAddCountry() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter code and country");
		String x=sc.nextLine();
		String y=sc.nextLine();
		Country country = new Country(x,y);
		countryService.addCountry(country);
		System.out.println(country);
	}
	public static void testUpdateCountry() throws InvocationTargetException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter code and country");
		String x=sc.nextLine();
		String y=sc.nextLine();
		Country country=new Country(x,y);
		countryService.updateCountry(x,y);
		System.out.println(country);
	}
	public static void testDeleteCountry() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter code");
		String x=sc.nextLine();
		String y="";
		Country country=new Country(x,y);
		countryService.deleteCountry(x,y);
		System.out.println("Deleted the contry with code "+x);	
	}

}

