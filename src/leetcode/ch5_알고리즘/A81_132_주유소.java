package leetcode.ch5_알고리즘;

public class A81_132_주유소 {
    public static void main(String[] args) {
        int[] gas = {67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66};
        int[] cost = {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        canCompleteCircuit(gas,cost);
    }
    static public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int tmpGas = 0;
        int totalCost = 0;
        int tmpCost = 0;
        int index = -1;

        for(int i=0; i<gas.length; i++){
            if(i == 74)
                System.out.println();
            totalCost += cost[i];
            tmpGas += gas[i];
            totalGas += gas[i];
            tmpCost +=cost[i];
            if( tmpGas-tmpCost<0) {
                index = -1;
                tmpCost = 0;
                tmpGas = 0;
                continue;
            }
            if(index == -1 && gas[i]-cost[i]>=0) index = i;
        }
        if(totalCost>totalGas) return -1;
        System.out.println( index);
        return -1;
    }
}
