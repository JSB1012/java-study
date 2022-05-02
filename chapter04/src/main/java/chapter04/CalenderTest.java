package chapter04;

import java.util.Calendar;

public class CalenderTest {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 11); //12(Month +1)
		cal.set(Calendar.DATE, 25);
		
		printDate(cal);
		
		cal.set(2022, 4, 2); // 2022/5/2
		cal.add(Calendar.DATE, 100);
		printDate(cal);

	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일","월","화","수","목","금","토",}; //a에 10이 대입된게 여기가 마지막이다
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0~11; +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);

		System.out.println(year + "년 " + (month + 1 < 10 ? "0" : "") + (month + 1) + "월 " + ((date < 10) ? "0" : "")
				+ date + "일 " + DAYS[day-1] +"요일 "+ hours + "시 " + minutes + "분 " + seconds);

	}

}
