package AgeOfTheUniverse.integration

import kotlin.math.abs

class SimpsonImpl : TrapezoidalImpl() {
    override fun run(start: Double, end: Double, eps: Double, f: (Double) -> Double): Double {
        var oldS = 0.0
        var newS = 0.0
        var oldSt = 0.0 // Old Trapezoidal Sum
        var newSt = 0.0 // New Trapezoidal Sum

        val maxSteps = 20

        for (i in 1..maxSteps) {
            newSt = nextTrapezoid(start, end, i, oldSt, f)

            // See Numerical recipes in C for the followng equation
            newS = (4.0 * newSt - oldSt) / 3.0

            if (i > 5) {
                if (abs(newS - oldS) < eps * abs(oldS) || (newS == 0.0 && oldS == 0.0)) {
                    return newS
                }
            }
            oldS = newS
            oldSt = newSt
        }
        return newS
    }
}