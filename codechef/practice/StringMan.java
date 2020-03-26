package practice;


import java.lang.reflect.Array;
import java.util.*;

public class StringMan {
    static class Node {
        int num;
        int depth;

        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "N{" +
                    "num=" + num +
                    ", depth=" + depth +
                    '}';
        }
    }


    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet<>();

        q.add(id);
        visited.add(id);

        while (!q.isEmpty() && level > 0) {
//            System.out.println(" for : " + cur.num + " ---> " + " d : " + depth);
//            System.out.println("q: " + q );
            int s = q.size();
            for(int k=0; k<s; k++) {
                int cur = q.poll();
                int[] f = friends[cur];

//                System.out.println("\tarray : " + Arrays.toString(f));
                for (int i = 0; i < f.length; i++) {
                    if (!visited.contains(f[i])) {
//                    System.out.println("\tFriend: " + f[i]);
                        q.add(f[i]);
                        visited.add(f[i]);
                    }
                }
            }

            level--;
        }

//        System.out.println("queue : ");
//        System.out.println(q);

        Map<String, Integer> fmap = new HashMap<>();
        while (!q.isEmpty()) {
            int tmp = q.poll();
            List<String> watchList = watchedVideos.get(tmp);
            for (String v : watchList) fmap.put(v, fmap.getOrDefault(v, 0) + 1);
        }

        List<Map.Entry<String, Integer>> flist = new LinkedList<>(fmap.entrySet());
        Collections.sort(flist, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() != o2.getValue()) return o1.getValue() - o2.getValue();
                else return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, Integer> e: flist) {
            res.add(e.getKey());
        }

        return res;
    }

    public static void main(String[] args) {

        List<List<String>> watchedvideos = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C"),
                Arrays.asList("B", "C"),
                Arrays.asList("D")
                );
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};


        List<String> res = watchedVideosByFriends(watchedvideos, friends, 0, 2);
        for (String r : res) {
            System.out.print(r +  "; " );
        }

    }
}
