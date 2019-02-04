package MS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class RecommenderSystem {
    private static Map<String, Map<String, Double>> map = new HashMap<>();
    private static Map<String, Map<String, Double>> normalizedMap = new HashMap<>();
    private static Set<String> itemSet = new HashSet<>();

    public static void constructMap() {
        Map<String, Double> map1 = new HashMap<>();
        map1.put("Imagine Dragons", 3.0);
        map1.put("Daft Punk", 5.0);
        map1.put("Lorde", 4.0);
        map1.put("Fall Out Boy", 1.0);
        map.put("David", map1);

        Map<String, Double> map2 = new HashMap<>();
        map2.put("Imagine Dragons", 3.0);
        map2.put("Daft Punk", 4.0);
        map2.put("Lorde", 4.0);
        map2.put("Fall Out Boy", 1.0);
        map.put("Matt", map2);

        Map<String, Double> map3 = new HashMap<>();
        map3.put("Kacey Musgraves", 4.0);
        map3.put("Imagine Dragons", 3.0);
        map3.put("Lorde", 3.0);
        map3.put("Fall Out Boy", 1.0);
        map.put("Ben", map3);

        Map<String, Double> map4 = new HashMap<>();
        map4.put("Kacey Musgraves", 4.0);
        map4.put("Imagine Dragons", 4.0);
        map4.put("Daft Punk", 4.0);
        map4.put("Lorde", 3.0);
        map4.put("Fall Out Boy", 1.0);
        map.put("Chris", map4);

        Map<String, Double> map5 = new HashMap<>();
        map5.put("Kacey Musgraves", 5.0);
        map5.put("Imagine Dragons", 4.0);
        map5.put("Daft Punk", 5.0);
        map5.put("Fall Out Boy", 3.0);
        map.put("Tori", map5);
    }

    public static void constructItemSet() {
        itemSet.add("Imagine Dragons");
        itemSet.add("Daft Punk");
        itemSet.add("Lorde");
        itemSet.add("Fall Out Boy");
        itemSet.add("Kacey Musgraves");
    }

    public static double getConsineSimilarity(String item1, String item2) {
        double fenzi = 0;
        double fenmuFirst = 0;
        double fenmuSecond = 0;
        double fenmu = 0;
        for (String user : map.keySet()) {
            double averageRateThisUser = getAverageRate(user);
            Map<String, Double> map1 = map.get(user);
            if (map1.keySet().contains(item1) && map1.keySet().contains(item2)) {
                double score1 = map1.get(item1);
                double score2 = map1.get(item2);
                fenzi += (score1 - averageRateThisUser) * (score2 - averageRateThisUser);
                fenmuFirst += Math.pow((score1 - averageRateThisUser), 2);
                fenmuSecond += Math.pow((score2 - averageRateThisUser), 2);
            }
        }
        fenmu = Math.sqrt(fenmuFirst) * Math.sqrt(fenmuSecond);
        double cosineSimilarity = fenzi / fenmu;
        return cosineSimilarity;
    }

    public static double getAverageRate(String user1) {
        double count = 0;
        double sum = 0;
        Map<String, Double> map1 = map.get(user1);
        for (String item : map1.keySet()) {
            count++;
            sum += map1.get(item);
        }
        double average = sum / count;
        return average;
    }

    public static void constructNormalizedMap() {
        for (String user : map.keySet()) {
            Map<String, Double> userMap = map.get(user);
            Map<String, Double> normalizeUserMap = new HashMap<>();
            double maxR = Collections.max(userMap.values());
            double minR = Collections.min(userMap.values());
            for (String item : userMap.keySet()) {
                double normalizedRate = (2 * (userMap.get(item) - minR) - (maxR - minR)) / (maxR - minR);
                normalizeUserMap.put(item, normalizedRate);
            }
            normalizedMap.put(user, normalizeUserMap);
        }
    }

    public static double normalizedPredictRate(String item, String user) {
        double fenzi = 0.0;
        double fenmu = 0.0;
        Map<String, Double> normalizedUserMap = normalizedMap.get(user);
        for (String item1 : normalizedUserMap.keySet()) {
            double cosineSimilarity = getConsineSimilarity(item, item1);
            fenzi += cosineSimilarity * normalizedUserMap.get(item1);
            fenmu += Math.abs(cosineSimilarity);
        }
        double normalizedPredictRate = fenzi / fenmu;
        return normalizedPredictRate;
    }


    public static double denormalizPredictRate(String user1, double normalizedRate) {
        Map<String, Double> userMap = map.get(user1);
        double maxR = Collections.max(userMap.values());
        double minR = Collections.min(userMap.values());
        double result = 0.5 * (normalizedRate + 1) * (maxR - minR) + minR;
        return result;

    }

    public static Map<String, Double> getRecommenderMap(String user1) {
        Map<String, Double> userMap = map.get(user1);
        double userAverage = getAverageRate(user1);
        Set<String> userSet = userMap.keySet();
        Map<String, Double> recommendMap = new HashMap<>();
        for (String item : userMap.keySet()) {
            if (userMap.get(item) > userAverage) {
                Map<String, Double> itemRecommendMap = new HashMap<>();
                String itemToRecommend = "";
                double itemCosineSimilarity = 0;
                for (String item2 : itemSet) {
                    if (!userSet.contains(item2)) {
                        double cosineSimilarity = getConsineSimilarity(item, item2);
                        if (cosineSimilarity > itemCosineSimilarity) {
                            itemCosineSimilarity = cosineSimilarity;
                            itemToRecommend = item2;
                        }
                    }
                }
                if (itemCosineSimilarity != 0) {
                    double normalRate = normalizedPredictRate(itemToRecommend, user1);
                    double predictRate = denormalizPredictRate(user1, normalRate);
                    recommendMap.put(itemToRecommend, predictRate);
                }
            }
        }
        return recommendMap;
    }

    public static void readTxt() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/test.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("read file finished.");
        }
    }

    public static void main(String[] args) {
        constructMap();
        constructItemSet();
        constructNormalizedMap();
        String item1 = "Daft Punk";
        String item2 = "Lorde";
        String user1 = "David";
        String item3 = "Kacey Musgraves";
        double consineSimilarity = getConsineSimilarity(item1, item2);
        double normalizedPredictRate = normalizedPredictRate(item3, user1);
        double predictRate = denormalizPredictRate(user1, normalizedPredictRate);
        System.out.println("recommend map is " + getRecommenderMap(user1));

        readTxt();
    }
}
