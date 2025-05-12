package 자바_알고리즘_인터뷰.배열

import java.util.Deque
import java.util.LinkedList
import java.util.PriorityQueue

class KClosestPointsToOrigin {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val queue: PriorityQueue<Point> = PriorityQueue(compareBy { a -> a.distance })
        for (point in points) {
            val distance = Math.pow(point[0].toDouble(), 2.0) + Math.pow(point[1].toDouble(), 2.0)
            queue.add(
                Point(
                    point = point,
                    distance = distance.toLong()
                )
            )
        }

        val result = Array(k) { IntArray(2) }
        for (i in 0 until k) {
            result[i] = queue.poll().point
        }
        return result
    }
}

data class Point(
    var point: IntArray,
    var distance: Long,
)