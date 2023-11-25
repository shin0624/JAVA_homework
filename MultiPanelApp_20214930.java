package prac09_02;
import javax.swing.*;
import java.awt.*;

//아래 패널 클래스에서 호출할 모든 함수는 슈퍼클래스인 jpanel의 메서드이므로, 객체이름 쓰지 말고 바로 호출
class NorthPanel extends JPanel{//JPanel을 상속받은 NorthPanel 클래스
	
	public NorthPanel() {//백그라운드 색을 LIGHT_GRAY로 설정한다. 생성자를 따로 만들어야 함을 유의
	setBackground(Color.LIGHT_GRAY);
	setOpaque(true);//버튼의 배경색이 보이도록
	setLayout(new FlowLayout(FlowLayout.CENTER));//배치관리자 플로우레이아웃 생성. 중앙정렬 사용. 상하좌우 간격은 디폴트(5)
	//"열기“, "닫기“, "나가기“ 버튼을 생성하여 이 패널에 추가
	add(new JButton("열기"));
	add(new JButton("닫기"));
	add(new JButton("나가기"));
}
}
class SouthPanel extends JPanel{//JPanel을 상속받은 SouthPanel 클래스
	public SouthPanel() {
		setBackground(Color.YELLOW);//백그라운드 색을 노란색으로 설정한다
		setOpaque(true);//버튼의 배경색이 보이도록
		setLayout(new FlowLayout(FlowLayout.LEFT));//배치관리자 플로우레이아웃 생성. 왼쪽정렬 사용. 상하좌우 간격은 디폴트(5)
		add(new JButton("Word Input"));//"Word Input“ 버튼을 생성하여 이 패널에 추가
		add(new JTextField(15));//텍스트 입력 창인 JTextField(15)를 생성하여 이 패널에 추가
		
		
	}
}
class CenterPanel extends JPanel{//JPanel을 상속받은 CenterPanel 클래스
	public CenterPanel() {
		setBackground(Color.WHITE);//백그라운드 색을 흰색으로 설정한다
		setLayout(null);//배치관리자 제거
		for(int i=0;i<10;i++) {
			JLabel j = new JLabel("*");//*문자열을 갖는 레이블객체생성
			//정수형 x, y 변수 선언 및 초기화 (난수 발생하여 각각 초기화)
			// x는 10~260, y는 10~210
			int x = (int)(Math.random()*260+10);
			int y = (int)(Math.random()*210+10);
			j.setLocation(x, y);//label j를 x, y 위치에 배치
			j.setSize(20,20);//label j의 크기를 20, 20으로 설정
			j.setForeground(Color.red);//label j의 전경색을 빨간색으로 설정
			j.setOpaque(true);
			add(j);//label을 이 패널(CenterPanel)에 추가		
		}				
	}
}


class MultiPanelFrame extends JFrame{//JFrame을 상속받은 MultiPanelFrame 클래스 
	public MultiPanelFrame() {
		super("여러 개의 패널을 가진 프레임");//슈퍼클래스 생성자 호출
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 윈도우를 닫으면 프로그램 종료하도록 설정
		
		Container c = getContentPane();//컨텐트 팬을 알아내서 변수 c에 저장(선언 및 초기화) 
		
		c.add(new NorthPanel(), BorderLayout.NORTH );//NorthPanel을 생성한 후, 컨텐트 팬 c에 추가
		c.add(new SouthPanel(), BorderLayout.SOUTH);//SouthPanel을 생성한 후 컨텐트 팬에 추가하되, 남쪽에 배치
		c.add(new CenterPanel(), BorderLayout.CENTER);//CenterPanel 을 생성한 후 컨텐트 팬에 추가하되, 중앙에 배치
		
		setSize(320,320);//프레임의 크기를 320,320으로 설정
		setVisible(true);//화면에 보이기
	}
	
}


public class MultiPanelApp_20214930 {

	public static void main(String[] args) {
		
		new MultiPanelFrame();//MultiPanelFrame 클래스의 객체를 생성
	}

}
