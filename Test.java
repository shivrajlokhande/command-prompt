
/*
 * @author Shivraj Lokhande 
 */

/*
Implementation of command prompt functionality using Java
Currently Supports 2 Commands
Enter the directory or filepath
if it's a directory it will list all the files in that directory
if it's a file it will display it's properties such as size,path and last modified date

ex.
cmd:>G:\1.jpg
1472827450000
Size in bytes       69054     
Path                G:\                 
Last Modified       Fri Sep 02 20:14:10 IST 2016 

cmd:>E:\
It's a directory
Wed Apr 22 19:11:56 IST 2020<DIR>angular             
Wed Apr 22 19:11:56 IST 2020<DIR>B.E.Project         
Wed Apr 22 19:11:56 IST 2020<DIR>Deep Learning       
Wed Apr 22 19:11:56 IST 2020<DIR>JavaWorkspace       
Wed Apr 22 19:11:56 IST 2020<DIR>ReactTutorials      
Wed Apr 22 19:11:56 IST 2020<DIR>softwares           
*/

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Test {

	private static Scanner sc = new Scanner(System.in);
	
	public static void printDirectory(File file)
	{
		File[] files = file.listFiles();
		for (File fileName : files)
		{
			Date date = new Date(file.lastModified());
			if(fileName.isDirectory())
				System.out.printf("%-20s%-5s%-20s\n",date.toString(),"<DIR>",fileName.getName());
			else
				System.out.printf("%-20s%-5s%-20s\n",date.toString(),"<FILE>",fileName.getName());
		}
	}
	
	public static void printFile(File file)
	{
		System.out.println(+file.lastModified());
		Date date = new Date(file.lastModified());
		System.out.println(String.format("%-20s%-10d","Size in bytes",file.length()));
		System.out.println(String.format("%-20s%-20s","Path",file.getParentFile()));
		System.out.println(String.format("%-20s%-30s","Last Modified",date.toString()));
	}
	
	public static void main(String[] args)
	{
		System.out.print("cmd:>");
		String path = sc.nextLine();
		
		File file = new File(path);
		if(file.exists())
		{
			if(file.isDirectory())
			{
				System.out.println("It's a directory");
				Test.printDirectory(file);
			}
			else
			{
				Test.printFile(file);
			}
		}
		else
		{
			System.err.println("Invalid Path");
		}
	}

}



