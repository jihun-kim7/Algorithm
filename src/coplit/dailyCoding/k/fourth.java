package coplit.dailyCoding.k;



public class fourth {

    public static void main(String[] args) {
        System.out.println(solution(
//                new int[]{1,50}, new int[]{51,100}, 100, 100
                new int[]{1,10}, new int[]{3,14}, 2, 5
//                new int[]{1,6}, new int[]{2,5}, 1, 6
        ));
    }


    public static int solution(int[] a, int[] b, int duration, int distance) {

        if(a[0] > b[0]) {
            int temp0 = a[0];
            int temp1 = a[1];
            a[0] = b[0];
            a[1] = b[1];
            b[0] = temp0;
            b[1] = temp1;
        }

        int aMaxDistance = (a[1]-a[0]-duration)/2;
        int bMaxDistance = (b[1]-b[0]-duration)/2;
        int aMaxTime = a[0] + aMaxDistance;
        if ((a[1]-a[0]-duration)%2 == 0) {
            aMaxTime++;
        }
        int bMaxTime = b[0] + bMaxDistance;
        if ((b[1]-b[0]-duration)%2 == 0) {
            bMaxTime++;
        }
        int aLocation = 0;
        int bLocation = distance;
        int nowTime = a[0];
        int maxTime = Math.min(aMaxTime, bMaxTime);

        while (nowTime <= maxTime) {
            if (aLocation < aMaxDistance) {
                aLocation++;
            }
            if (nowTime >= b[0] && bLocation > bLocation-bMaxDistance) {
                bLocation--;
            }
            nowTime++;

            System.out.println(nowTime + " " + aLocation + " " + bLocation);

            if (bLocation <= aLocation) {
                return nowTime;
            }
        }

        return -1;
    }
}
