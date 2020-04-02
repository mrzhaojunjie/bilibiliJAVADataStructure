package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts= new HashMap<String,HashSet<String>>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("北京");
        hashSet.add("上海");
        hashSet.add("天津");
        hashSet.add("广州");
        hashSet.add("深圳");
        hashSet.add("成都");
        hashSet.add("杭州");
        hashSet.add("大连");

        ArrayList<String> selects = new ArrayList<>();  //定义一个ArrayList用来存放所选择的城市
        HashSet<String> tempSet = new HashSet<>();
        String maxKey = null;   //临时变量指向所选择的k
        while (hashSet.size() != 0) {
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();  //先清空临时的HashSet
                HashSet<String> areas = broadcasts.get(key);  //将k值对应的集合加入areas
                tempSet.addAll(areas);

                tempSet.retainAll(hashSet);  //取交集取出tempSet和hashSet的交集
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if(maxKey != null){
                selects.add(maxKey);
                hashSet.removeAll(broadcasts.get(maxKey));
            }
        }

    }
}
