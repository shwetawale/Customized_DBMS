import java.lang.*;
import java.util.*;

//create table student(RID int, Name varchar(255), Salary int);
//Database table /Schema
class Student
{
	public int RID;
	public String Name;
	public int Salary;
	
	//private static int Generator=0;
	private static int Generator;
	static
	{
		Generator=0;
	}
		
	public Student(String str, int value)
	{
		this.RID=++Generator;
		this.Name=str;
		this.Salary=value;
	}
	public void DisplayData()
	{
		System.out.println(this.RID+"\t"+this.Name+"\t"+this.Salary);
	}
}

class DBMS
{
	LinkedList<Student> lobj;
	
	public DBMS()
	{
		lobj=new LinkedList<>();
	}
	
	public void  StartDBMS()
	{
		Scanner sobj=new Scanner(System.in);
		System.out.println("Marvellous customised DBMS started");
		String Query="";
		
		while(true)
		{
			System.out.print("Marvellous  DBMS console >");
			Query=sobj.nextLine();
			
			String token[]=Query.split(" ");
			int QuerySize=token.length;
			
			if(QuerySize==1)
			{
				if("Help".equals(token[0]))
				{
					System.out.println("This application is used to demonstrates the customised DBMS");
					System.out.println("Exit: Terminate the DBMS");
					System.out.println("Display all data : select * from student");
					System.out.println("Insert data :Insert  into student Name Salary"); 	
				}	
				else if("Exit".equals(token[0]))
				{
					System.out.println("Thank you for using Marvellous DBMS");
					break;
				}
			}
			else if(QuerySize==2)
			{
				
			}
			
			else if(QuerySize==4)
			{
				if("select".equals(token[0]))
				{
					if("*".equals(token[1]))
					{
						DisplayAll();
					}
				}
			}
			
			else if(QuerySize==5)
			{
				if("Insert".equals(token[0]))
				{
					InsertData(token[3],Integer.parseInt(token[4]));
				}
			}
		}
	}
	
	public void  InsertData(String str,int value)
	{
		Student sobj=new Student(str,value);
		lobj.add(sobj);
	}
	public void DisplayAll()
	{
		for(Student sref:lobj)
		{
			sref.DisplayData();	
		}
	}
	public void DisplaySpecific(int rid)
	{
		for(Student sref:lobj)
		{
			if(sref.RID==rid)
			{
				sref.DisplayData();	
				break;
			}
		}
	}
	
		public void DisplaySpecific(String str)
	{
		for(Student sref:lobj)
		{
			if(str.equals(sref.Name))
			{
				sref.DisplayData();	
				break;
			}
		}
	}
	
	public void DeleteSpecific(int rid)
	{
		int index=0;
		for(Student sref:lobj)
		{
			if(sref.RID==rid)
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}
	
	public void DeleteSpecific(String str)
	{
		int index=0;
		for(Student sref:lobj)
		{
			if(str.equals(sref.Name))
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}
	
	public void AggregateMin()
	{
		int iMin=(lobj.getFirst()).Salary;
		Student temp=lobj.getFirst();
		for(Student sref:lobj)
		{
			if(sref.Salary<iMin)
			{
				iMin=sref.Salary;
				temp=sref;
			}
		}
		System.out.println("Minimum Salary:  "+iMin);
		temp.DisplayData();
	}

	public void AggregateMax()
	{
		int iMax=0;
		Student temp=null;
		for(Student sref:lobj)
		{
			if(sref.Salary>iMax)
			{
				iMax=sref.Salary;
				temp=sref;
			}
		}
		System.out.println("Maximum Salary:  "+iMax);
		temp.DisplayData();
	}
	
	public void AggregateSum()
	{
		int iSum=0;
		Student temp=null;
		for(Student sref:lobj)
		{
			iSum=iSum+sref.Salary;
		}
		System.out.println("Summation of Salaries is:  "+iSum);
	}

	public void AggregateAvg()
	{
		int iSum=0;
		Student temp=null;
		for(Student sref:lobj)
		{
			iSum=iSum+sref.Salary;
		}
		System.out.println("Average Salary is:  "+iSum/lobj.size());
	}
	
	public void AggregateCount()
	{
		System.out.println("Count is:  "+lobj.size());
	}
	
}

class program3
{
	public static void main(String a[])
	{
		DBMS dobj=new DBMS();
		dobj.StartDBMS();
	/*	dobj.InsertData("piyush",1000);
		dobj.InsertData("Sakshi",2000);
		dobj.InsertData("shweta",50000);
		dobj.InsertData("aditi",1000);
		dobj.InsertData("rug",9000);
		//dobj.DisplayAll();
		//dobj.DisplaySpecific(2);
		//dobj.DisplaySpecific("shweta");
		//dobj.DeleteSpecific(2);
		//dobj.DeleteSpecific("aditi");
		dobj.AggregateMin();
		dobj.AggregateMax();
		//dobj.DisplayAll();
		dobj.AggregateSum();
		dobj.AggregateAvg();
		dobj.AggregateCount();    */
	}
}



