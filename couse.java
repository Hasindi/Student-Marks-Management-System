import java.util.*;
class couse{
	public static void bestInDatabaseManagementSystem(String[][]idName,int[][]marks,int index){
		Scanner input=new Scanner(System.in);
		
		System.out.println("+------+--------------------------------+-------------+-------------+");
		System.out.println("|ID    |Name                            |DBMS Marks   |PF Marks     |");
		System.out.println("+------+--------------------------------+-------------+-------------+");
		
		//sort dbms marks(ascending)
		int[] sortDbms=new int[marks[1].length];
		for(int i=0; i<sortDbms.length; i++){
			sortDbms[i]=marks[1][i];
		}
		sortArray(sortDbms);
		
		//table body
		int x=sortDbms.length-1;
		do{
			//find max index
			int indexN=-1;
			for(int i=0; i<index; i++){
				if(sortDbms[x]==marks[1][i]){
					indexN=i;
					break;
				}
			}
			//print max index
			System.out.printf("|%-6s|%-32s|%13d|%13d|\n",idName[0][indexN],idName[1][indexN],marks[0][indexN],marks[1][indexN]);
			x--;
			
		}while(sortDbms[x]!=0);
		
		System.out.println("+------+--------------------------------+-------------+-------------+");
		
		System.out.print("Do you want to go back to the main menu(Y/n) : ");
		int opt=input.next().charAt(0);
		if(opt=='Y' || opt=='y'){
			clearConsole();
			return;
		}else if(opt=='N' || opt=='n'){
			clearConsole();	
			System.exit(0);
		}
	}
	public static void bestInProgrammingFundamentals(String[][]idName,int[][]marks,int index){
		Scanner input=new Scanner(System.in);
		
		System.out.println("+------+--------------------------------+------------+------------+");
		System.out.println("|ID    |Name                            |PF Marks    |DBMS Marks  |");
		System.out.println("+------+--------------------------------+------------+------------+");
		
		//sort prf marks(ascending)
		int[] sortPrf=new int[marks[0].length];
		for(int i=0; i<sortPrf.length; i++){
			sortPrf[i]=marks[0][i];
		}
		sortArray(sortPrf);
		
		//table body
		int x=sortPrf.length-1;
		do{
			//find max index
			int indexN=-1;
			for(int i=0; i<index; i++){
				if(sortPrf[x]==marks[0][i]){
					indexN=i;
					break;
				}
			}
			//print max index
			System.out.printf("|%-6s|%-32s|%12d|%12d|\n",idName[0][indexN],idName[1][indexN],marks[0][indexN],marks[1][indexN]);
			x--;
			
		}while(sortPrf[x]!=0);
		
		System.out.println("+------+--------------------------------+------------+------------+");
		
		System.out.print("Do you want to go back to the main menu(Y/n) : ");
		int opt=input.next().charAt(0);
		if(opt=='Y' || opt=='y'){
			clearConsole();
			return;
		}else if(opt=='N' || opt=='n'){
			clearConsole();	
			System.exit(0);
		}
	}
	public static void printStudentRanks(String[][]idName,int[][]marks,int[]total,double[]avg,int[] rank,int index){
		Scanner input=new Scanner(System.in);
		
		//print title
		System.out.println("+------+---------+--------------------------------------+-------------+-------------+");
		System.out.println("|Rank  |ID       |Name                                  |Total Marks  |Avg. Marks   |");
		System.out.println("+------+---------+--------------------------------------+-------------+-------------+");
		
		findRank(total,rank,0,index);
		//table body
		for(int i=0; i<index; i++){
			int indexN=-1;
			for(int j=0; j<100; j++){
				if(rank[i]==total[j]){
					indexN=j;
					break;
				}
			}
			//if not marks added, skip
			if(total[indexN]==0){
				continue;
			}
			System.out.printf("|%-6d|%-9s|%-38s|%13d|%13.2f|\n",(i+1),idName[0][indexN],idName[1][indexN],total[indexN],avg[indexN]);
		}
		System.out.println("+------+---------+--------------------------------------+-------------+-------------+");
		
		System.out.print("Do you want to go back to the main menu(Y/n) : ");
		int opt=input.next().charAt(0);
		if(opt=='Y' || opt=='y'){
			clearConsole();
			//return;
		}else if(opt=='N' || opt=='n'){
			clearConsole();
			System.exit(0);
		}
	}		    
	public static void printStudentDetails(String[][]idName,int[][]marks,int[]total,double[]avg,int[] rank,int index){
		Scanner input=new Scanner(System.in);
		
		boolean repeat;
		do{
			repeat=false;
			
			//checkin and get place
			int place=findPlace(idName);
			
			//print name
			System.out.println("Student Name \t: "+idName[1][place]);
			
			//check marks have aded
			if(marks[0][place]==0 && marks[1][place]==0){
				System.out.println("\nMarks yet to be added.");
			}else{
				System.out.println("+--------------------------------------------+-------------------+");
				System.out.printf("|%-44s|%19d|\n","Programming Fundamental Marks",marks[0][place]);
				System.out.printf("|%-44s|%19d|\n","Database Management System Marks",marks[1][place]);
				System.out.printf("|%-44s|%19d|\n","Total Marks",total[place]);
				System.out.printf("|%-44s|%19.2f|\n","Avg. Marks",avg[place]);
				
				//findRank
				int ranks=findRank(total,rank,place,index);
				
				//print rank
				int lastStRank=0;
				for(int i=0; i<rank.length-1; i++){
					if(rank[i+1]==0 || i==rank.length-1){
						lastStRank=i+1;
						break;
					}
				}
				if(ranks==lastStRank){
					System.out.printf("|%-44s|%12d (Last)|\n","Rank",ranks);
				}else{
					switch(ranks){
						case 1:
						    System.out.printf("|%-44s|%11d (First)|\n","Rank",ranks);
						    break;
						case 2:
						    System.out.printf("|%-44s|%10d (Second)|\n","Rank",ranks);
						    break;
						case 3:
						    System.out.printf("|%-44s|%11d (Third)|\n","Rank",ranks);
						    break;
						default: 
						    System.out.printf("|%-44s|%19d|\n","Rank",ranks);
						}
					}
					System.out.println("+--------------------------------------------+-------------------+");
				}
				System.out.print("Do you want to update marks for another Student(Y/n) : ");
			    int opt=input.next().charAt(0);
			    if(opt=='Y' || opt=='y'){
					clearConsole();
					title7();
					repeat=true;
				}else if(opt=='N' || opt=='n'){
					clearConsole();
				}
			}while(repeat==true);
		}				
	public static void deleteStudent(String[][]idName,int[][]marks,int[]total,double[]avg){
		Scanner input=new Scanner(System.in);
		
		boolean repeat;
		do{
			repeat=false;
			
			//checkin and get place
			int place=findPlace(idName);
			
			//deleting details
			idName[0][place]=null;
			idName[1][place]=null;
			marks[0][place]=0;
			marks[1][place]=0;
			total[place]=0;
			avg[place]=0.0;
			
			System.out.println("Student has been deleted Successfully.");
			System.out.print("Do you want to delete another Student details(Y/n) : ");
			int opt=input.next().charAt(0);
			if(opt=='Y' || opt=='y'){
				clearConsole();
				title6();
				repeat=true;
			}else if(opt=='N' || opt=='n'){
				clearConsole();
			}
		}while(repeat==true);
	}					
	public static void updateMarks(String[][]idName,int[][]marks,int[]total,double[]avg,int index){
		Scanner input=new Scanner(System.in);
		
		boolean repeat;
		do{
		    repeat=false;
		    
		    //checkin and get place
			int place=findPlace(idName);
			
			//print name
			System.out.println("Student Name \t\t: "+idName[1][place]);
			
			//check marks have aded
			if(marks[0][place]==0 && marks[1][place]==0){
				System.out.println("\nThis Student's marks yet to be added.");
			}else{
				//print marks
				System.out.println("\nProgramming Fundamental Marks  \t\t: "+marks[0][place]);
				System.out.println("Database Management System Marks \t: "+marks[1][place]);
				
				//input new marks
				boolean repeatPRF;
		        do{
			        repeatPRF=false;
			
			        System.out.print("\nEnter new Programming Fundamental Marks  \t: ");
				    marks[0][place]=input.nextInt();
		            
		            //check marks
		            if(marks[0][place]<0 || marks[0][place]>100){
				        System.out.println("Invalid marks.Please enter correct marks.\n");
				        repeatPRF=true;
			        }else{
				        marks[0][index]=marks[0][place];
			        }
				}while(repeatPRF==true);
		
		        boolean repeatDBMS;
		        do{
			        repeatDBMS=false;
			
			        System.out.print("Enter new Database Management System Marks \t: ");
				    marks[1][place]=input.nextInt();
		    
		            //check marks
		            if(marks[1][place]<0 || marks[1][place]>100){
			            System.out.println("Invalid marks.Please enter correct marks.\n");
				        repeatDBMS=true;
			        }else{
			         	marks[1][index]=marks[1][place];
			        }
				}while(repeatDBMS==true);
				
				calcTotalAndAvg(marks,total,avg,place);//calc total and avg
				System.out.println("Marks has been updated Successfully.");
			}
			System.out.print("Do you want to update marks for another Student(Y/n) : ");
			int opt=input.next().charAt(0);
			if(opt=='Y' || opt=='y'){
				clearConsole();
				title5();
				repeat=true;
			}else if(opt=='N' || opt=='n'){
				clearConsole();
			}
		}while(repeat==true);
	}
	public static void updateStudentDetails(String[][]idName){
		Scanner input=new Scanner(System.in);
		
		boolean repeat;
		do{
			repeat=false;
			
			//check in and get place
			int place=findPlace(idName);
			
			//print name
			System.out.println("Student Name \t\t: "+idName[1][place]);
			//input new name
			System.out.print("\nEnter the new Student Name \t: ");
			idName[1][place]=input.next();
			
			System.out.println("\nStudent details has been updated Successfully.");
			System.out.print("Do you want to update another Student detail(Y/n) : ");
			int opt=input.next().charAt(0);
			if(opt=='Y' || opt=='y'){
				clearConsole();
				title4();
				repeat=true;
			}else if(opt=='N' || opt=='n'){
				clearConsole();
			}
		}while(repeat==true);
	}
	public static void addMarks(String[][]idName,int[][]marks,int[]total,double[]avg){
		Scanner input=new Scanner(System.in);
		
		boolean repeatMethod;
		do{
			repeatMethod=false;
			boolean repeat;
			do{
				repeat=false;
				
				//check in and get place
				int place=findPlace(idName);
				
				//chek marks have added
				if(marks[0][place]==0 && marks[1][place]==0){
					System.out.println("Student Name \t\t: "+idName[1][place]);
					
					inputMarks(marks,place);//input marks
					calcTotalAndAvg(marks,total,avg,place);//calc total and avg
				}else{
					System.out.println("Student Name \t\t: "+idName[1][place]);
					System.out.println("This Student's marks have been already added.\nIf you want to update the marks,please use [4] Update Marks option.\n");
					System.out.print("Do you want to add marks for another Student(Y/n) : ");
					int opt=input.next().charAt(0);
					if(opt=='Y' || opt=='y'){
						clearConsole();
						title3();
						repeat=true;
					}else if(opt=='N' || opt=='n'){
						clearConsole();
						return;
					}
				}
			}while(repeat==true);
			
			System.out.print("\nMarks have been added. Do you want to add marks for another Student(Y/n) : ");
			int opt=input.next().charAt(0);
			if(opt=='Y' || opt=='y'){
				clearConsole();
				title3();
				repeatMethod=true;
			}else if(opt=='N' || opt=='n'){
				clearConsole();
			}
		}while(repeatMethod==true);
	}
	public static int AddNewStudentWithMarks(String[][]idName,int[][]marks,int[]total,double[]avg,int index){
		Scanner input=new Scanner(System.in);
		
		boolean repeat;
		do{
			repeat=false;
			
			inputId(idName,index);// user input
			inputName(idName,index);// user input
			inputMarks(marks,index);// user input
			calcTotalAndAvg(marks,total,avg,index);//calc total and avg
			
			System.out.print("\nStudent has been added Successfully. Do you want to add a new Student(Y/n) : ");
			int opt=input.next().charAt(0);
			index++;
			
			if(opt=='Y' || opt=='y'){
				clearConsole();
				title2();
				repeat=true;
			}else if(opt=='N' || opt=='n'){
				clearConsole();
			}
		}while(repeat==true);
		return index;
	} 
	public static int AddNewStudent(String[][]idName,int index){
		Scanner input=new Scanner(System.in);
		
		boolean repeat;
		do{
			repeat=false;
			
			inputId(idName,index);// user input
			inputName(idName,index);// user input
			
			System.out.print("\nStudent has been added Successfully. Do you want to add a new Student(Y/n) : ");
			char opt=input.next().charAt(0);
			index++;
			
			if(opt=='Y' || opt=='y'){
				clearConsole();
				title1();
				repeat=true;
			}else if(opt=='N' || opt=='n'){
				clearConsole();
			}
		}while(repeat==true);
		return index;
	}
	public static void expandArrays(String[][]idName,int[][]marks,int[]total,double[]avg,int[] rank){
		
		String[][] temp1=new String[2][idName[0].length+50];//create new array for idName,length+50
		for(int i=0; i<2; i++){                             //copy old arry value to new array
			for(int j=0; j<idName[i].length; j++){
				temp1[i][j]=idName[i][j];
			}
		}
		idName=temp1;
		
		int[][] temp2=new int[2][marks[0].length+50];   //create new array for marks,length+50
		for(int i=0; i<2; i++){                         //copy old arry value to new array
			for(int j=0; j<marks[i].length; j++){
				temp2[i][j]=marks[i][j];
			}
		}
		marks=temp2;
		
		int[] temp3=new int[total.length+50];           //create new array for total,length+50
		for(int j=0; j<total.length; j++){              //copy old arry value to new array
				temp3[j]=total[j];
		}
	    total=temp3;
		
		double[] temp4=new double[avg.length+50];      //create new array for avg,length+50
		for(int j=0; j<avg.length; j++){               //copy old arry value to new array
				temp4[j]=avg[j];
		}
		avg=temp4;
		
		int[] temp5=new int[rank.length+50];           //create new array for rank,length+50
		for(int j=0; j<rank.length; j++){              //copy old arry value to new array
				temp5[j]=rank[j];
		}
		rank=temp5;
	}	
	public static int findRank(int[]total,int[]rank,int place,int index){
		Scanner input=new Scanner(System.in);
		
		//copy array total
		int[]sortTot=new int[total.length];
		for(int i=0; i<total.length; i++){
			sortTot[i]=total[i];
		}
		//sort the coppied array
		sortArray(sortTot);
		
		//reverse sort array for find ranks
		for(int i=0; i<total.length; i++){
			rank[i]=sortTot[sortTot.length-(i+1)];
		}
		//find rank
		int rankSt=0;
		for(int i=0; i<index; i++){
			if(rank[i]==total[place]){
				rankSt=i+1;
			}
		}
		return rankSt;
	}
	public static void sortArray(int[]sort){
		//bubble sort(assending)
		for(int i=0; i<sort.length; i++){
			for(int j=0; j<sort.length-1; j++){
				if(sort[j]>sort[j+1]){
					int temp=sort[j];
					sort[j]=sort[j+1];
					sort[j+1]=temp;
				}
			}
		}
	}
	public static void calcTotalAndAvg(int[][]marks,int[]total,double[]avg,int place){
		total[place]=marks[0][place]+marks[1][place];
		avg[place]=total[place]/2.0;
	}
	public static int findPlace(String[][]idName){
		Scanner input=new Scanner(System.in);
		
		boolean repeatId;
		int place=-1;//index cannot be -1,so asign -1 to place
		do{
			repeatId=false;
			
			System.out.print("Enter Student ID \t: ");
			String tempId=input.next();
			
			//check already exists
			for(int i=0; i<idName[0].length; i++){
				if(tempId.equals(idName[0][i])){
					place=i;//asign i to place
				}
			}
			if(place==-1){
				System.out.print("Invalid Student ID. Do you want to search again (Y/n) : ");
				char opt=input.next().charAt(0);
	            System.out.println();  
				if(opt=='Y' || opt=='y'){
					repeatId=true;
				}else if(opt=='N' || opt=='n'){
					clearConsole();
				}
			}
		}while(repeatId==true);
		return place;
	}	
	public static void inputMarks(int [][]marks,int index){
		Scanner input=new Scanner(System.in);
		
		boolean repeatPRF;
		do{
			repeatPRF=false;
			
			System.out.print("Programming Fundamental Marks\t : ");
		    int prf=input.nextInt();
		    
		    if(prf<0 || prf>100){
			    System.out.println("Invalid marks.Please enter correct marks.\n");
				repeatPRF=true;
			}else{
				marks[0][index]=prf;
			}
		}while(repeatPRF==true);
		
		boolean repeatDBMS;
		do{
			repeatDBMS=false;
			
			System.out.print("Database Management System Marks : ");
		    int dbms=input.nextInt();
		    
		    if(dbms<0 || dbms>100){
				System.out.println("Invalid marks.Please enter correct marks.\n");
				repeatDBMS=true;
			}else{
				marks[1][index]=dbms;
			}
		}while(repeatDBMS==true);
	}		
	public static void inputName(String[][]idName, int index){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter Student Name \t: ");
		idName[1][index]=input.next();
	}
	public static void inputId(String[][]idName, int index){
		Scanner input=new Scanner(System.in);
		
		boolean repeatId;
		String tempId;
		do{
			repeatId=false;
			
			System.out.print("Enter Student ID \t: ");
			tempId=input.next();
			
			//check id already exists
			for(int i=0; i<idName[0].length; i++){
				if(tempId.equals(idName[0][i])){
					System.out.println("The Student ID already exists\n");
					repeatId=true;
				}
			}
		}while(repeatId==true);
		idName[0][index]=tempId;
	}				
	static void title10(){
		  System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t   BEST IN DATABASE MANAGEMENT SYSTEM\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  }
	static void title9(){
		  System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t   BEST IN PROGRAMMING FUNDEMENTALS\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  }
    static void title8(){
		  System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t\t PRINT STUDENTS' RANKS\t\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  } 
    static void title7(){
	      System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t\t PRINT STUDENT DETAILS\t\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  }
	static void title6(){
		  System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t\t   DELETE STUDENT\t\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  }     
	static void title5(){
		  System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t\t\tUPDATE MARKS\t\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  }       
	static void title4(){
		  System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t\t UPDATE STUDENT DETAILS\t\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  }
	static void title3(){
		  System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t\t\tADD MARKS\t\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  }    
	static void title2(){
	      System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t\tADD NEW STUDENT WITH MARKS\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  }    
	static void title1(){
	      System.out.println("------------------------------------------------------------------------------------------");
          System.out.print("|\t\t\t\t     ADD NEW STUDENT\t\t\t\t\t |\n");
          System.out.println("------------------------------------------------------------------------------------------");
          System.out.println();
	  }  
	public final static void clearConsole() {
      try {
        final String os = System.getProperty("os.name");
           if (os.contains("Windows")) {
               new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
           }else {
              System.out.print("\033[H\033[2J");
              System.out.flush();
           }
       }catch (final Exception e) {
          e.printStackTrace();
          // Handle any exceptions.
       }
   }
	public static int menu(){
	   Scanner input = new Scanner(System.in);
	   
	   //create main menu
       System.out.println("------------------------------------------------------------------------------------------");
       System.out.print("|\t\t\t WELCOME TO GDSE MARKS MANAGEMENT SYSTEM  \t\t\t |\n");
       System.out.println("------------------------------------------------------------------------------------------");
       
       System.out.print("[1] Add New Student\t\t\t[2] Add New Student With Marks\n");
       System.out.print("[3] Add Marks\t\t\t\t[4] Update Student Details\n");
       System.out.print("[5] Update Marks\t\t\t[6] Delete Student\n");
       System.out.print("[7] Print Student Details\t\t[8] Print Student Ranks\n");
       System.out.print("[9] Best In Programming Fundamentals\t[10] Best In Programming Database Management System\n\n");
       
       /*System.out.print("[1] Add New Student ");
       System.out.println("\t\t\t[2] Add New Student With Marks ");
       System.out.print("[3] Add Marks ");
       System.out.println("\t\t\t\t[4] Update Student Details ");
       System.out.print("[5] Update Marks ");
       System.out.println("\t\t\t[6] Delete Student ");
       System.out.print("[7] Print Student Details ");
       System.out.println("\t\t[8] Print Student Ranks ");
       System.out.print("[9] Best In Programming Fundamentals ");
       System.out.println("\t[10] Best In Programming Database Management System ");
       System.out.println();*/
       
       //System.out.print("[1] Add New Student\t\t\t[2] Add New Student With Marks\n[3] Add Marks\t\t\t\t[4] Update Student Details\n[5] Update Marks\t\t\t[6] Delete Student\n[7] Print Student Details\t\t[8] Print Student Ranks\n[9] Best In Programming Fundamentals\t[10] Best In Programming Database Management System");
       //System.out.println();
       
       System.out.print("Enter an option to continue > ");
       return input.nextInt();
   }
    public static void main (String[]args){
	   Scanner input=new Scanner(System.in);
	   
	   //create arrays
	   String[][] idName=new String[2][100];
	   int[][] marks=new int[2][100];
	   int[] total=new int[100];
	   double[] avg=new double[100];
	   int[] rank=new int[100];
	   
	   int index=0;
	   int option;
	   do{
		   option=menu();
		   clearConsole();
		   
		   switch(option){
			   case 1: 
			      title1();
			      index=AddNewStudent(idName,index);
			      break;
			   case 2: 
			      title2();
			      index=AddNewStudentWithMarks(idName,marks,total,avg,index);
			      break;
			   case 3: 
			      title3();
			      addMarks(idName,marks,total,avg);
			      break;
			   case 4: 
			      title4();
			      updateStudentDetails(idName);
			      break;
			   case 5: 
			      title5();
			      updateMarks(idName,marks,total,avg,index);
			      break;
			   case 6: 
			      title6();
			      deleteStudent(idName,marks,total,avg);
			      break;
			   case 7: 
			      title7();
			      printStudentDetails(idName,marks,total,avg,rank,index);
			      break;
			   case 8: 
			      title8();
			      printStudentRanks(idName,marks,total,avg,rank,index);
			      break;
			   case 9: 
			      title9();
			      bestInProgrammingFundamentals(idName,marks,index);
			      break;
			   case 10: 
			      title10();
			      bestInDatabaseManagementSystem(idName,marks,index);
			      break;
			  }
		  }while(true);
	  }
  }
