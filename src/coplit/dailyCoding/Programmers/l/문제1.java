package coplit.dailyCoding.Programmers.l;

import java.util.ArrayList;

public class 문제1 {

    ArrayList<Marble> answer = new ArrayList<>();

//    public int[] solution(int[] marbles) {
//        1.순열 메소드 만들어서 계산하면서 풀기
//        makePerm
//    }

    public void makePerm(ArrayList<Integer> list) {
        if (list.size()%2 == 0) {
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < list.size(); i++) {
                rightSum += list.get(i);
            }


            for (int i = 0; i < list.size(); i++) {
                leftSum += list.get(i);
                rightSum -= list.get(i);
                if(leftSum == rightSum) {
                    answer.add(new Marble(list,i,list.size()-1-i,leftSum));
                }
            }
        }

        else {
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < list.size(); i++) {
                rightSum += list.get(i);
            }


            for (int i = 0; i < list.size(); i++) {
                leftSum += list.get(i);
                rightSum -= list.get(i);
                if(leftSum == rightSum) {
                    answer.add(new Marble(list,i,list.size()-1-i,leftSum));
                }
            }
        }
    }

    public class Marble {
        ArrayList<Integer> list;
        int leftCnt;
        int rightCnt;
        int sum;

        public Marble(ArrayList<Integer> list, int leftCnt, int rightCnt, int sum) {
            this.list = list;
            this.leftCnt = leftCnt;
            this.rightCnt = rightCnt;
            this.sum = sum;
        }
    }
}
