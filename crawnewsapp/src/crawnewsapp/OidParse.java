package crawnewsapp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 1번 Jsout(Maven)
// 2번 Jsoup로 URL 요청
// 3번 Oid의 번호는 어디까지 있는지
// oid마다의 신문사명을 매칭

public class OidParse {
	Map<String, Integer> oidMap = new HashMap<>();


	public static void main(String[] args) {
		String oid = "001";
		String aid = "0000000001";
		String host = "https://news.naver.com/main/read.nhn?&sid=001";
		String title;
		Elements el;
		String url;
		String selector = "div.article_info h3";
		Document doc = null; 
		
		try {
            doc = Jsoup.connect(url).get(); // -- 1. get방식의 URL에 연결해서 가져온 값을 doc에 담는다.
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        Elements titles = doc.select(selector); // -- 2. doc에서 selector의 내용을 가져와 Elemntes 클래스에 담는다.
        
        
        
        for(Element element: titles) { // -- 3. Elemntes 길이만큼 반복한다.
            System.out.println(element.text()); // -- 4. 원하는 요소가 출력된다.
        }
   
	}
}


