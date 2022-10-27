package 기본메소드.카카오;

public class Q4_2 {
    public static void main(String[] args) {

        long[] n = {58,7,5,63,111,95};
        solution(n);
    }

    static public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int count =0;
        for(long number: numbers){
            String str = Long.toBinaryString(number);
            int[] digits;
            if(str.length()%2 == 0){
                digits = new int[str.length()+1];
                digits[0] = 0;
                for(int i=1; i<=str.length(); i++)
                    digits[i] = str.charAt(i-1) - '0';
            }else{
                digits = new int[str.length()];
                for(int i=0; i<str.length(); i++)
                    digits[i] = str.charAt(i) - '0';
            }

            flag =false;

            if(count==3)
                System.out.println();
            TreeNode node = sortByBST(digits);
            inOrder(node);
            if(flag){
                answer[count] = 0;
            }else{
                answer[count] = 1;
            }
            count++;
        }
        return answer;
    }

    static boolean flag;
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
            if(node.val == 0) flag = true;
            if(node.right != null) inOrder(node.right);
        }
    }
}

