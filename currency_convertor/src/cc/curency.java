package cc;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class curency
{
	public String temp1,temp2,curn1="Indian Rupee",curn2=" United State Dollar";
	curency()
	{
	temp1="usd-to-inr";
	temp2="usd-to-inr";
	}
	void start(String o)
	{int ch;
		System.out.println("********************WELCOME TO CURRENCY EXCHANGE********************** ");
		System.out.println("\n");
		System.out.println("\t choose 1 for usd to inr or vice-versa");
		System.out.println("\t choose 2 for eur to inr or vice-versa");
		System.out.println("\t choose 3 for pound(gbp) to in or vice versar  ");
		Scanner poop=new Scanner(System.in);
		ch=poop.nextInt();
		int chek;
		System.out.println("enter 0 to continue 1 for vice-versa");
		chek=poop.nextInt();
		switch(ch)
		{
			case 1:
				
				if(chek==1) {
					
				
				curn1=" Indian Rupee";
				curn2=" United States Dollar";
				temp2="inr-to-usd";
				
			
				}
				else
				{
					temp2="usd-to-inr";
				}
				break;
			case 2:
				System.out.println("enter 0 to continue 1 for vice-versa");
				if(chek==1) {
					
				
				curn1=" Indian rupee";
				curn2="Euro";
				
				temp2="inr-to-eur";
				}
				else
				{
					curn1="Euro";
					curn2=" Indian Rupee";
					temp2="eur-to-inr";
				}
				break;
			case 3:
				System.out.println("enter 0 to continue 1 for vice-versa");
			if(chek==1) {
				
				
			curn1=" Indian rupee";
			curn2=" British Pound Sterling";
			temp2= "inr-to-gbp";
			}
			else
			{
				curn1=" British Pound Sterling";
				curn2=" Indian Rupee";
				temp2="gbp-to-inr";
				
				
		}
			break;
		
				
		}
	}
	
	public static void main(String[] args)
	{
		curency obj=new curency();
		
		
		try {
			String link="https://www.unitconverters.net/currency/usd-to-inr.htm";
			obj.start(link);
			
			link=link.replace(obj.temp1,obj.temp2);
			System.out.println("source :"+link);
			Document doc =Jsoup.connect(link).get();
			
			Elements price = doc.select("table.datatable tr:nth-of-type(4) > td:nth-of-type(1)");
			Elements price1 = doc.select("table.datatable tr:nth-of-type(4) > td:nth-of-type(2)");
			String cur1 = price.text();
			String cur2=price1.text();
			System.out.println(cur1+"="+cur2);
			String p=cur2.replace(obj.curn2,"");//removing the currency value out from the string
			Double priceas=Double.parseDouble(p);//converting string to double
			
			int op;
			System.out.println("enter the total money to convert into "+obj.curn2);
			Scanner cha=new Scanner(System.in);
			op=cha.nextInt();
			double to_val;
			to_val=op*priceas;
			System.out.println(op+" "+obj.curn1+"="+to_val+""+obj.curn2);			
			
			
		}
		catch (IOException ex) {
		        System.err.println("Error:" + ex.getMessage());
		    }
		
		
		
	}
}