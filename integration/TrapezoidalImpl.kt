package AgeOfTheUniverse.integration

import kotlin.math.abs

open class TrapezoidalImpl : IntegrateStrategy {
    override fun run(start: Double, end: Double, eps: Double, f: (Double) -> Double): Double {
        var oldS = 0.0
        var newS = 0.0
        val maxSteps = 20

        for (i in 1..maxSteps) {
            newS = nextTrapezoid(start, end, i, oldS, f)
            // Check convergence after a few iterations (e.g., 5) to avoid spurious early convergence
            if (i > 5) {
                if (abs(newS - oldS) < eps * abs(oldS) || (newS == 0.0 && oldS == 0.0)) {
                    return newS
                }
            }
            oldS = newS
        }
        return newS
    }

    /**
     * Refines the trapezoidal sum.
     * @param n The stage of refinement (1, 2, 3, ...).
     * @param oldS The previous sum (at stage n-1).
     */
    protected fun nextTrapezoid(a: Double, b: Double, n: Int, oldS: Double, f: (Double) -> Double): Double {
        if (n == 1) {
            return 0.5 * (b - a) * (f(a) + f(b))
        } else {
            // Number of points to add: 2^(n-2)
            var points = 1
            repeat(n - 2) { points = points shl 1 }

            val tnm = points.toDouble()
            val del = (b - a) / tnm
            var x = a + 0.5 * del
            var sum = 0.0

            for (j in 0 until points) {
                sum += f(x)
                x += del
            }
            return 0.5 * (oldS + (b - a) * sum / tnm)
        }
    }
}