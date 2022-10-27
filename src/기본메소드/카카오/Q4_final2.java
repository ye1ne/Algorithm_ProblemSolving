package 기본메소드.카카오;

public class Q4_final2 {
    public static void main(String[] args) {

        long[] n = {3223,3};
        solution(n);
    }

    static public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int count =0;
        for(long number: numbers){

            String str = Long.toBinaryString(number);
//            str = Long.toBinaryString(1_000_000_000_000);
            int[] digits;

            digits = new int[str.length()];
            for(int i=0; i<str.length(); i++)
                digits[i] = str.charAt(i) - '0';


            int totalSize = find(digits.length);
            int[] newArr = new int[totalSize];
            int gap =(totalSize-digits.length);
            for(int i=0; i<totalSize; i++){
                if(totalSize-digits.length>i){
                    newArr[i] =0;
                }else newArr[i] = digits[i-gap];
            }
            notTree =false;

            TreeNode node = sortByBST(newArr);
            inOrder(node);


            if(notTree){
                answer[count] = 0;
            }else answer[count] = 1;

            count++;
        }
        return answer;
    }

    static boolean notTree;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode sortByBSTStart(int[] arr, int num){
        if(arr.length == 0)
            return null;

        if(arr.length ==1 && arr[0] == 0) return null;
        int mid = num;

        int[] left = new int[mid];
        int[] right = new int[arr.length-mid-1];

        for(int i=0; i<mid; i++) left[i] = arr[i];
        for(int i=mid+1; i<arr.length; i++) right[i-(mid+1)] = arr[i];
        TreeNode leftNode = sortByBST(left);
        TreeNode rightNode=  sortByBST(right);
        return new TreeNode(arr[mid],leftNode,rightNode);
    }
    static TreeNode sortByBST(int[] arr){
        if(arr.length == 0)
            return null;

        if(arr.length ==1 && arr[0] == 0) return null;
        int mid = arr.length/2;

        int[] left = new int[mid];
        int[] right = new int[arr.length-mid-1];

        for(int i=0; i<mid; i++) left[i] = arr[i];
        for(int i=mid+1; i<arr.length; i++) right[i-(mid+1)] = arr[i];
        TreeNode leftNode = sortByBST(left);
        TreeNode rightNode=  sortByBST(right);
        return new TreeNode(arr[mid],leftNode,rightNode);
    }

    static void  inOrder(TreeNode node) {
        if(node != null) {
            if(node.left != null) inOrder(node.left);
            if(node.val == 0) notTree = true;
            if(node.right != null) inOrder(node.right);
        }
    }

    static int find(int size){
        int count =0;
        int hight = 0;
        while(count<size*2){
            int tmp = (int)Math.pow(2,count+1)-1;
            if(tmp>size) {
                hight =tmp;
                break;
            }
            count++;
        }
        return hight;
    }
}

