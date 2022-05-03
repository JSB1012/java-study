package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			File file = new File("phone.txt");
			
			if(!file.exists()) {
				System.out.println("file not found");
				return;
			}
	
			System.out.println("==========파일정보===========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
	
			System.out.println("==========전화번호===========");
			
			//1. 기반 스트림(FileInputStream)
			FileInputStream fis = new FileInputStream(file);
			
			//2. 보조 스트림1(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			//3. 보조 스트림2(ch1|ch2|ch3|\n -> "ch1ch2ch3")
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					if(index == 0) { // 이름
						System.out.print(token + ":");
					} else if(index == 1) { //전화번호1
						System.out.print(token + "-");
					} else if(index == 2) { //전화번호2
						System.out.print(token + "-");
					} else { //전화번호3
						System.out.print(token);
					}
					
					index++;
				}
				
				System.out.println("");
			}
		} catch(IOException ex) {
			System.out.println("error:" + ex);
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
}