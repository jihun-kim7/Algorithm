class Solution {
    public long solution(int r1, int r2) {
        long R1 = 1L * r1 * r1;
        long R2 = 1L * r2 * r2;
        long total = 0;

        for (long x = 0; x <= r2; x++) {
            long x2 = x * x;

            // 바깥 원에서 가능한 y의 최댓값 (floor)
            long yMax = (long) Math.floor(Math.sqrt(R2 - x2));

            // 안쪽 원에서 제외해야 할 y의 최솟값 (ceil), 음수면 0으로
            long inner = R1 - x2;
            long yMin = 0;
            if (inner > 0) {
                yMin = (long) Math.ceil(Math.sqrt(inner));
            }

            long countY = 0;
            if (yMax >= yMin) {
                if (yMin == 0) {
                    // y = -yMax ... 0 ... yMax
                    countY = yMax * 2 + 1;
                } else {
                    // y = ±yMin ... ±yMax
                    countY = (yMax - yMin + 1) * 2;
                }
            }

            if (x == 0) {
                // x=0은 좌우 대칭이 없어 그대로
                total += countY;
            } else {
                // x>0은 좌우 대칭으로 두 배
                total += countY * 2;
            }
        }
        return total;
    }
}
