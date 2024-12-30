package A4greedy;

import java.util.*;

public class A403구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> d1 = new ArrayDeque<>();
        for (int person : people) {
            d1.add(person);
        }
        while(true) {
            if (!d1.isEmpty()) {
                if (d1.peekFirst() + d1.peekLast() > limit) {
                    d1.pollLast();
                    answer++;
                } else if (d1.peekFirst() + d1.peekLast() <= limit) {
                    d1.pollLast();
                    d1.pollFirst();
                    answer++;
                } else if (d1.size() == 1) {
                    d1.poll();
                    answer++;
                }
            }else{
                break;
            }
        }
        System.out.println(answer);
//        틀린답안(시간초과)
//        List<List<Integer>> boat = new ArrayList<>();
//        List<Integer> another = new ArrayList<>();
//        for (int i = 0; i < people.length; i++) {
//            another.add(people[i]);
//        }
//        while (true) {
//            List<Integer> temp = new ArrayList<>();
//            if (another.get(0) + another.get(another.size() - 1) > limit) {
//                temp.add(another.get(another.size() - 1));
//                boat.add(temp);
//                another.remove(another.size() - 1);
//            }else if (another.size()==1) {
//                boat.add(new ArrayList<>(another.get(0)));
//                another.remove(0);
//            } else if (another.get(0) + another.get(another.size() - 1) <= limit) {
//                temp.add(another.get(0));
//                temp.add(another.get(another.size() - 1));
//                boat.add(temp);
//                another.remove(another.get(0));
//                another.remove(another.get(another.size() - 1));
//            }
//            if(another.isEmpty()){
//                break;
//            }
//        }
//        answer = boat.size();
    }
}