import java.util.*;

public class Main {

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double clear = 0;
        double fail = 0;
        HashMap<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < stages.length; j++) {
                if(i < stages[j]) {
                    clear++;
                }
                else if(i == stages[j]) {
                    fail++;
                }
            }
            map.put(i, fail == 0 && clear == 0 ? 0 : fail/(clear+fail));
            clear = 0;
            fail = 0;
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet, ((n1, n2) -> Double.compare(map.get(n2), map.get(n1))));

        answer = keySet.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        int[] lost = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] reserve = {1, 3, 6};
        System.out.println(solution(5, lost));
    }
}