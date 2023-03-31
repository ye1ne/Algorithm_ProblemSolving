package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            if (isContact(br.readLine())) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean isContact(String str) {

        int privType = 0;
        boolean isMulti = false;
        for (int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == '1'){
                TypeAResult typeAResult = countTypeALength(str.substring(i));
                if(typeAResult.isFail) return false;

                if(typeAResult.hasMultiOne) isMulti = true;
                i += typeAResult.count;
            }
            //0으로 시작
            else {
                //기본으로 다음꺼가 없으면 실패임
                if (i + 1 >= str.length()) {
                    return false;
                }

                //만약 다음이 1이면 성공, 넘어감
                if(str.charAt(i+1) == '1'){
                    privType = 2;
                    isMulti = false;
                    i++;
                    continue;
                }

                //다음이 불행히도 0이면
                if(str.charAt(i+1) == '0'){
                    if(!isMulti)
                        return false;
                    isMulti = false;
                    TypeAResult typeAResult = countTypeALength(str.substring(i-1));
                    if(typeAResult.isFail) return false;

                    if(typeAResult.hasMultiOne) isMulti = true;
                    i += (typeAResult.count-1);

                }
            }

        }

        return true;
    }

    private static TypeAResult countTypeALength(String str) {
        int start = 0;

        //최소한의 필요한 0 카운트 (2개)
        if(start+1 >= str.length()){
            return new TypeAResult(false,0,true);
        }
        start++;
        if(str.charAt(start) != '0'){
            return new TypeAResult(false,0,true);
        }
        if(start+1 >= str.length()){
            return new TypeAResult(false,0,true);
        }
        start++;
        if(str.charAt(start) != '0'){
            return new TypeAResult(false,0,true);
        }
        //남아 있는 0 소진
        while (start+1 < str.length() && str.charAt(start+1) == '0') {
            start++;
        }
        //1이 반드시 나와야 하는데 없어서 실패
        if(start+1 >= str.length()){
            return new TypeAResult(false,0,true);
        }

        int count = 0;
        while (start+1 < str.length() && str.charAt(start+1) == '1') {
            start++;
            count++;
        }

        if(count >=2 ){
            return new TypeAResult(true,start,false);
        }
        return new TypeAResult(false,start,false);
    }

    static class TypeAResult{
        boolean hasMultiOne;
        int count;

        boolean isFail;

        public TypeAResult(boolean hasMultiOne, int count, boolean isFail) {
            this.hasMultiOne = hasMultiOne;
            this.count = count;
            this.isFail = isFail;
        }

    }


}
