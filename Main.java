//
// CH2: Main.java
//
//  Created on: 2023. 09. ?.
//      Author: your name
//
//  1) 입출력 함수 호출 연습
//  2) while, switch 문장, operator
//  3) User Interface 용 함수들 구현
//

import java.util.*;

//===============================================================================
// main()
//===============================================================================
public class Main 
{
    public static void main(String[] args) {
        //--------------------------------
        // AutoCheck(chk, trace)
        // chk: 1(자동 오류 체크), 0(키보드에서 직접 입력하여 프로그램 실행)
        // trace: true(오류발생한 곳 출력), false(단순히 O, X만 표시)
        //--------------------------------
        //int chk = 1; if (chk != 0) new AutoCheck(chk, true).run(); else

        // TODO: System.in을 인자로 하는 Scanner 객체를 생성한 후
        //       해당 객체를 아래 run() 함수의 인자로 넘겨 주어라. (null 대신에 넘겨 줄 것)
        //       위 기능을 반드시 하나의 문장으로 완성해야 한다. 변수 선언하지 말고 바로 넘겨 줌
        //       즉, run( Scanner 객체를 생성 ); 형태가 되어야 한다.
    	Scanner scanner = new Scanner(System.in);
        run(scanner);
    }

    public static void run(Scanner scan) {
        // UI 클래스의 setScanner() 함수를 호출함; setScanner()가 static 함수라 이렇게 호출 가능함
        UI.setScanner(scan); // UI 클래스 내의 static 함수 호출
        MainMenu.run(); // MainMenu 클래스 내의 static 함수 호출방법: 클래스이름.함수이름();
        // TODO: scan이 더 이상 필요없으므로 닫아라.
        scan.close();
    }
}

//===============================================================================
// Main Menu
//===============================================================================
class MainMenu
{
    public static void run() {
        String menuStr =
                "******** Main Menu ********\n" +
                "* 0.exit 1.JavaBasic(ch2) *\n" +
                "***************************\n";
        System.out.print("\n" + menuStr);
			 int MENU_COUNT = UI.value;
			
       int menuItem = UI.selectMenu(menuStr, MENU_COUNT);
       
       
       switch(UI.value) {
       case 0:
    	   System.out.println("\nGood bye!!");
    	   break;
       case 1:
    	   Ch2.run();
    	  // System.out.print("\n" + menuStr);  
    	   break;
       default:
    	   System.out.println( menuStr);
    	   UI.selectMenu(menuStr, MENU_COUNT);
       }
       
      /*while(true) {
    	   if(UI.value==0) {
    		   //System.out.print("menuitem: " + UI.value);
    		   System.out.println("\nGood bye!!");
    		   break;
    	   }   
	   
    	   else  {
    		  //System.out.println("\n" + menuStr);
    		  UI.selectMenu(menuStr, MENU_COUNT);
    	   }
       }*/
       
        
    }
} // class MainMenu

//===============================================================================
// User Interface
//===============================================================================
class UI
{
    public static boolean echo_input = false; // 자동오류체크 시 true로 설정됨
    public static Scanner scan;
    public static int value;
    public static void setScanner(Scanner s) { scan = s; }
    

    // 입력을 받기 위해 static Scanner scan 멤버를 활용하라. 즉, scan.함수() 형식으로 호출
    // 정수 값을 입력 받아 리턴함 (음수, 0, 양수)
    public static int getInt(String msg) { 

        // TODO: msg를 화면에 출력한 후 정수 값을 입력 받아 지역 변수 value에 저장함 (변수 선언할 것)
    	//       입력 시 이 클래스의 scan 멤버 변수를 활용하라. 
        //       (이 변수는 setScanner(Scanner s)에 의해 이미 초기화 되었음)
    	
    	System.out.print(msg);
    	value = scan.nextInt();
    	
    	
         if (echo_input) System.out.println(value); // 자동오류체크 시 입력 값을 출력함
        // 위 문장은 자동오류체크 시에 사용되는 문장임; 일반적으로 키보드로부터 입력받을 경우 
        // 화면에 자동 echo되지만, 자동오류체크 시에는 입력파일에서 입력받은 값이 자동 echo 되지  
        // 않으므로 명시적으로 출력 버퍼에 출력(echo) 해 주어야 한다.

        // (지시가 있을 때 구현할 것) 입력 버퍼에 남아 있는 '\n'를 제거하지 않으면 다음번 getNextLine()에서 
        // '\n'만 빈 줄이 입력될 수 있으므로 입력 버퍼에 남아 있는 '\n'를 사전에 제거함

        return 0; // TODO: 입력 받은 정수 value를 리턴할 것 
    }

    // 0 또는 양의 정수 값을 입력 받아 리턴함
    public static int getPosInt(String msg) { 
        // TODO: 위 getInt(String msg)를 호출해 정수값을 입력 받은 후 입력된 값이 음수일 경우
        //       에러("Input a positive INTEGER. Try again!!") 출력하고 다시 입력 받는다.
        //       원하는 값이 입력될 때까지 위 과정을 계속 반복하여야 한다.
    
    	while(true){
    			UI.getInt(msg);
    		if(value<0) {
    			System.out.println("Input a positive INTEGER. Try again!!");
    			System.out.println("");
    			
    		}
    		else{
    			//System.out.println("menu item: "+UI.value);
    			break;
    		}
    	}
    	
        return 0; // TODO: 입력된 0 또는 양수 리턴
    }
    
    // [0, (size-1)] 사이의 인덱스 값을 리턴함
    // 존재하지 않는 메뉴항목을 선택한 경우 에러 출력
    public static int getIndex(String msg, int size) { 
        // TODO: 위 getPosInt(String msg)를 호출해 0 또는 양수를 입력 받은 후 적절하지 않은 인덱스(index)일 경우 
        //       에러("index: OUT of selection range(0 ~ size-1) Try again!!")를 
        //       출력하고 다시 입력 받는다.
    	
    	
    	while(true) {
    		UI.getPosInt(msg);
    		if(value>1 || value<0) {
    			System.out.println(value + ":" + " OUT of selection range(0 ~ 1) Try again!!");
    			System.out.println("");
    		}
    		else if(value==0||value==1) {
    			//System.out.println("menuitem: "+UI.value);
    			//System.out.println("");
    			break;
    		}
    		
    	}
        return 0; // TODO: 입력 받은 값 리턴
    }

    // 사용자에게 메뉴("\n"+menuStr+"menu item? ")를 보여주고 
    // 위 getIndex(String msg, int size)를 호출해서
    // 사용자가 선택한 메뉴항목의 인덱스(0 ~ (menuCount-1))를 리턴함
    // menuCount: 메뉴항목의 개수임
    public static int selectMenu(String menuStr, int menuCount) 
    {
    	//System.out.println(menuStr);
    	
         int menuItem = UI.getIndex("menu item? ", menuCount);
       
         return menuItem;}
    	//return 0; }

    // 중요: 위 각 함수 구현 시
    // selectMenu() -> getIndex() -> getPosInt() -> getInt() 를 호출해서 구현하여야 한다.

    // 위 getInt()를 참고하여 msg를 화면에 출력한 후 문자열 단어 하나를 입력 받아 리턴함
    public static String getNext(String msg) { 
        // TODO: msg를 화면에 출력한 후 하나의 토큰(단어)을 입력 받아 변수 token에 저장함
        // if (echo_input) System.out.println(token); // 자동오류체크 시 입력 값을 출력함
        return "";  // TODO: 입력 받은 한 단어를 리턴할 것
    }

    // msg를 화면에 출력한 후 하나의 행 전체를 입력 받아 리턴함
    public static String getNextLine(String msg) { 
        // TODO: msg를 화면에 출력한 후 한 행 전체를 입력 받아 변수 line에 저장함
        // if (echo_input) System.out.println(line); // 자동체크 시 출력됨
        return "";  // TODO: 입력 받은 한 행 전체를 리턴할 것
    }
}

//===============================================================================
// class Ch2
//===============================================================================
class Ch2 
{
    public static void run() {
        String menuStr =
             "************* Ch2 Menu ***********\n" +
             "* 0.exit 1.output 2.readToken    *\n" +
             "* 3.readLine 4.operator 5.switch *\n" +
             "**********************************\n";

        //2-1-0에서 삭제 System.out.print(menuStr);
        
       
        while(true) {
        	 int MENU_COUNT = UI.value;
        	System.out.print("\n"+menuStr);
        	 int menuItem = UI.selectMenu(menuStr, MENU_COUNT);
        	switch(UI.value) {
        	case 0:
        		MainMenu.run();  		
        		return;
        	case 1:
        		output();
        		break;
        	case 2:
        	case 3:
        	case 4:
        	case 5:break;
        	default:
        		if(UI.value<0) {
        			System.out.println("Input a positive INTEGER. Try again!!");
        			System.out.println("");
        		}
        		else if(UI.value>5) {
        			System.out.println(UI.value + ":" + " OUT of selection range(0 ~ 5) Try again!!");
        			System.out.println("");
        		}
        		
        	}
        }
        
        
        
    }

    public static void output()     { System.out.println("output"); }
    public static void readToken()  {  }
    public static void readLine()   {  }
    public static void operator()   {  }
    public static void switchCase() {  }}