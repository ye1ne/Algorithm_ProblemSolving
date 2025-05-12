package 자바_알고리즘_인터뷰.배열

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
//        val maxLength = nums.size
//
//        for (i in 0 until maxLength) {
//            for (j in i+1 until  maxLength) {
//                val sum = nums[i] + nums[j]
//                if (sum == target) {
//                    return intArrayOf(i, j)
//                }
//            }
//        }

        val numMap = nums.mapIndexed { idx, value -> (value to idx) }.toMap()

        for (i in nums.indices) {
            val num = nums[i]
            val remainNum = target - num

            if (numMap.containsKey(remainNum) && (numMap[remainNum] != i)) {
                return intArrayOf(i, numMap[remainNum]!!)
            }
        }

        return intArrayOf()
    }
}