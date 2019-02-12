package G;

import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem {
    public static List<int[]> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return null;
        }
        int n = buildings.length;
        int[] lastBuilding = buildings[n-1];
        int rightMostIndex = 0;
        for(int[] building: buildings){
            if(building[1] > rightMostIndex){
                rightMostIndex = building[1];
            }
        }
        int[] intArray = new int[rightMostIndex + 2];

        for(int[] building: buildings){
            for(int i = building[0]; i<= building[1]; i++){
                if(building[2] > intArray[i]){
                    intArray[i] = building[2];
                }
            }
        }

        List<int[]> list = new ArrayList<>();
        if(intArray[0] > 0){
            int[] first = {0,intArray[0]};
            list.add(first);
        }

        for(int i = 1; i < intArray.length - 1; i++){
            if(intArray[i] != intArray[i-1] || intArray[i+1] != intArray[i]){
                int[] current = new int[2];
                if(intArray[i] > intArray[i-1]){
                    current[0] = i;
                    current[1] = intArray[i];
                    list.add(current);
                }
                if(intArray[i+1] < intArray[i]){
                    current[0] = i;
                    current[1] = intArray[i + 1];
                    list.add(current);
                }

            }
        }
        return list;
    }
}
