package Programmers.KAKAO2019RECRUITMENT;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 매칭점수 {
    public static void main(String[] args) {

        String[] p = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        String word ="blind";
        solution(word,p);
    }

    //기본점수 : 검색어 등장횟수
    //외부링크 수 : 다른 페이지로 연결된 링크의 갯수
    //링크 점수 : 다른 웹페이지의 기본점수/외부링크수
    //기본점수(0), 외부링크수(1), 외부에서 링크된수(2),
    static public int solution(String word, String[] pages) {

        Map<String,int[]> map = new HashMap<>();
        Map<String,Integer> indexMap = new HashMap<>();

        for(int i=0; i<pages.length; i++){
            String str = pages[i];
            //웹사이트 먼저 알고
            int start = str.indexOf("content=\"") +1;
            int end = str.indexOf("\"",start) +1;
            String domain = str.substring(start, end);

            if(!map.containsKey(domain))map.put(domain,new int[]{0,0,0});
            indexMap.put(domain,i);

            //바디부분만 떼오기
            start = str.indexOf("<body>")+6;
            end = str.indexOf("</body")+1;

            String body = str.substring(start,end);

            //링크가 있을때까지 반복함
            start = body.indexOf("<a href=")+1;
            String realBody = "";
            int tmp = 0;
            while(start >0){
                end = body.indexOf("\"",start+8)+1;
                realBody +=  body.substring(tmp,start);
                tmp = end;
                String outLink = body.substring(start+8,end);
                start = body.indexOf("<a href=",end)+1;
            }

//            //본문 내용 검색
//            start = realBody.indexOf( word);
//            while(start>0){
//                if()
//            }
            System.out.println();

        }


        int answer = 0;


        return answer;
    }



    static String startTag = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"";
}
