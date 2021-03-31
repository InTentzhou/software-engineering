package SofreareEngineering;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Scanner;


public class SoftwareEngineering {
	
	static int[][] apr_wei = new int[20][3001];
	
	//只读：
	public static String txtString(File file) {      //读数据的方法
		String resultString = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s=null;
			while ((s = br.readLine()) != null) {   //使用readline方法一次读一行
				resultString = resultString + '\n' + s;	
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultString;	
	}
	
	
	
	//处理数据
	public static void Read_file(String string) {      //数据转换
		//用于存放重量和价值；当下标为双数时为profit，单数时为weight
		
		int line=0;
		int begin=0;
		int end=0;
		int i=0;
		
		try {
			BufferedReader br1 = new BufferedReader(new StringReader(string));
			String s2=null;
			while ((s2 = br1.readLine()) != null) {   //使用readline方法一次读一行
				//String转换到int数组
				if(s2.charAt(0)>='0'&&s2.charAt(0)<='9')
				{
					System.out.println("*********");
					int[] cont = new int[3001];
					for (int j = 0; j < s2.length(); j++) {
						if(s2.charAt(j)==','||s2.charAt(j)=='.')//寻找逗号的位置
						{
							cont[i++]=j;
						}
					}
				for (int j = 0; j < cont.length; j++) {
					end=cont[j];
					apr_wei[line][j]=Integer.parseInt(s2.substring(begin,end));
					if (cont[j+1]==0) {
						break;
					} else {
						begin=cont[j]+1;
					}
				}
				
				for (int j = 0; j < cont.length; j++) {
					System.out.print(cont[j]);
				}
				line++;
			   }
				
			}
			br1.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("读入idkp1-10数据输入1  读入sdkp1-10数据输入2  读入udkp1-10数据输入3   读入wdkp1-10数据输入4");
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		switch (n) {
		case 1:
			File file1 = new File("C:\\Users\\LiHanQIn\\Desktop\\软件工程\\实验二 任务3data_set/idkp1-10.txt");//读入idkp-10.txt
			
			Read_file(txtString(file1));
			
			for (int i = 0; i < apr_wei[1].length; i++)
			{
				System.out.print(apr_wei[1][i]);
			}
			 
			break;
		case 2:
			File file2 = new File("C:\\Users\\LiHanQIn\\Desktop\\软件工程\\实验二 任务3data_set/sdkp1-10.txt");//读入sdkp-10.txt
			System.out.println(txtString(file2));
			break;
		case 3:
			File file3 = new File("C:\\Users\\LiHanQIn\\Desktop\\软件工程\\实验二 任务3data_set/udkp1-10.txt");//读入udkp-10.txt
			System.out.println(txtString(file3));
			break;
		case 4:
			File file4 = new File("C:\\Users\\LiHanQIn\\Desktop\\软件工程\\实验二 任务3data_set/wdkp1-10.txt");//读入wdkp-10.txt
			System.out.println(txtString(file4));
		default:
			break;
		}
		
		
	}
}
