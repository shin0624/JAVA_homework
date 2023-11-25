package prac09_04;
import javax.swing.*;
import java.awt.*;

class TenColorButtonFrame extends JFrame{//JFrame을 상속받은 TenColorButtonFrame 클래스
	public TenColorButtonFrame() {//생성자
		super("Ten Color Buttons Frame");//슈퍼클래스인 jframe생성자 호출
		//setTitle("Ten Color Buttons Frame");//메서드 호출로 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 윈도우를 닫으면 프로그램 종료하도록 설정
		Container c = getContentPane();//컨텐트 팬을 알아내서 변수 c에 저장
		c.setLayout(new GridLayout(1,10));//그리드 레이아웃 객체 생성, 1행 10열
		
		JButton btn[] = new JButton[10];//원소 10개 할당한 jbutton배열 레퍼런스변수 선언
		
		Color color[] = { Color.RED, Color.ORANGE, Color.YELLOW, 
				Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY, 
				Color.PINK, Color.LIGHT_GRAY };//버튼의 배경색으로 사용할 10가지 색으로 초기화
		for(int i=0;i<btn.length;i++)
		{		
			btn[i] = new JButton(Integer.toString(i)); //버튼 생성하여 btn[i]에 저장
			//버튼 생성시 버튼에 사용할 문자열은 정수 i를 문자열로 변환하여 넘겨 줌
			btn[i].setOpaque(true);//버튼의 배경색이 보이게 함
			btn[i].setBackground(color[i]);//백그라운드 색깔을 color[i]로 설정함
			c.add(btn[i]);//btn[i]를 컨텐트 팬 c에 추가함
			
		}
		setSize(500,200);//프레임의 크기를 500,200으로 설정
		setVisible(true);//화면에 보이기
	}
}


public class TenColorApp_20214930 {
	

	public static void main(String[] args) {
			new TenColorButtonFrame();

	}

}
