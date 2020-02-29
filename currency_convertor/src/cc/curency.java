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
	double money(String p)
	{int space=p.indexOf(' ', 0);
	p=p.substring(0, space);
	double k=Double.parseDouble(p);
	return k;	
	}
	void start()
	{
		System.out.println("******************* WELCOME TO CURRENCY CONVERTOR ****************");
		System.out.println("enter the country code of the currency");
		Scanner o=new Scanner(System.in);
		curn1=o.nextLine();
		curn2=o.nextLine();
		temp2=curn1+"-to-"+curn2;
		
	}
	
	void net()
	{
		
		
		
		try {
			String link="https://www.unitconverters.net/currency/usd-to-inr.htm";
			start();
			
			link=link.replace(temp1,temp2);
			System.out.println("source :"+link);
			Document doc =Jsoup.connect(link).get();
			
			
			Elements price = doc.select("table.datatable tr:nth-of-type(4) > td:nth-of-type(1)");
			Elements price1 = doc.select("table.datatable tr:nth-of-type(4) > td:nth-of-type(2)");
			String cur1 = price.text();
			String cur2=price1.text();
			System.out.println(cur1+"="+cur2);
			double cu=money(cur2);
			
			
			
			
			double to_val,amount;
			System.out.println("enter the amount to convert");
			Scanner p=new Scanner(System.in);
			amount=p.nextDouble();
			to_val=amount*cu;
			
			System.out.print(to_val);
			
			
		}
		catch (IOException ex) {
		        System.err.println("Error:" + ex.getMessage());
		    }
		
		
		
	}
	public static void main(String[] args)
	{
		curency s= new curency();
		System.out.println("enter");
		s.net();
		
	}
}
