package Programmers.practice.hash;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres,plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 각각 노래 이름은 (0...i) 까지의 숫자


        // 각 장르별 총 재생횟수를 알려주는 map
        HashMap<String, Genre> genresPlaysCountMap = new HashMap<>();

        // 전체 배열을 돌며, 장르map을 업데이트 시킨다
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];

            //장르별 카운트 횟수 업데이터
            if(genresPlaysCountMap.containsKey(genre)) {
                Genre genre1 = genresPlaysCountMap.get(genre);
                genre1.addMusic(play,i);
                genresPlaysCountMap.put(genre,  genre1);
            }
            else {
                Genre genre1= new Genre(play,i);
                genresPlaysCountMap.put(genre,genre1);
            }
        }
        List<Genre> list = new ArrayList<>();
        String[] keySet = genresPlaysCountMap.keySet().toArray(new String[0]);
        for(int i=0; i<keySet.length; i++) list.add(genresPlaysCountMap.get(keySet[i]));

        Collections.sort(list, new Comparator<Genre>() {
            @Override
            public int compare(Genre o1, Genre o2) {
                return o2.totalPlay - o1.totalPlay;
            }
        });

        List<Integer> result = new ArrayList<>();

        // 모든 장르에서 최대 2개씩 뽑아낸다
        for(int i=0; i<list.size(); i++){
            int n = 2;
            while(!list.get(i).musicPriorityQueue.isEmpty() && n-->0) {
                result.add(list.get(i).musicPriorityQueue.poll()[1]);
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0 ;i<plays.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static class Genre{
        static int totalPlay;
        static PriorityQueue<int[]> musicPriorityQueue;

        public Genre(int totalPlay, int number) {
            this.totalPlay = totalPlay;
            this.musicPriorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o2[0] == o1[0]) return o1[1] - o2[1];
                    return o2[0] - o1[0];
                }
            });
            musicPriorityQueue.add(new int[]{totalPlay,number});
        }
        public static void addMusic(int play, int number){
            totalPlay += play;
            musicPriorityQueue.add(new int[]{play,number});
        }
    }
}
