package prob05;

public class MyBase extends Base {
	
	/*
	 * 주의 사항 : 
	 * 1. 주어진 main메소드를 이용하여 테스트 합니다.
	 * 2. 주어진 Class Base는 절대로 수정하면 안됩니다.
	 * 3. 컴파일이 안되거나 Exception 이 발생하는 경우는 무조건 오답으로 처리됩니다.
	 */

	public void service(String state){
		if( state.equals( "낮" ) ) {
			day();
		} else if(state.equals( "밤" )) {
			night();
		}
		else {
			after();
		}
	}
	

	public void day(){
		System.out.println("낮에는 열심히 일하자!");
	}
	
	public void night(){
		System.out.println("night");
	}
	
	public void after() {
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}

}
