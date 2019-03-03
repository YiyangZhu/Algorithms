package DP;

public class ProfitableSchemes {
    public int profitableSchemes(int numPeople, int targetProfit, int[] group, int[] profit) {
        int numTask = group.length;
        int[][][] dp = new int[numTask+1][targetProfit+1][numPeople+1];
        dp[0][0][0] = 1;

        for(int currentTaskNumber = 1; currentTaskNumber <= numTask; currentTaskNumber++){
            for(int currentProfit = 0; currentProfit <= targetProfit; currentProfit++){
                for(int currentRequiredPeople = 0; currentRequiredPeople <= numPeople; currentRequiredPeople++){
                    int profitWithoutCurrentTask = dp[currentTaskNumber-1][currentProfit][currentRequiredPeople];
                    int profitWithCurrentTask = 0;

                    int priorProfit = Math.max(0, currentProfit - profit[currentTaskNumber-1]);
                    if(currentRequiredPeople >= group[currentTaskNumber-1]){
                        profitWithCurrentTask = dp[currentTaskNumber-1][priorProfit][currentRequiredPeople-group[currentTaskNumber-1]];
                    }

                    dp[currentTaskNumber][currentProfit][currentRequiredPeople] = (profitWithoutCurrentTask + profitWithCurrentTask) % (1000_000_007);
                }
            }
        }

        int result = 0;
        for(int a = 0; a <= numPeople; a++){
            result += dp[numTask][targetProfit][a];
            result %= 1000_000_007;

        }
        return result;
    }
}