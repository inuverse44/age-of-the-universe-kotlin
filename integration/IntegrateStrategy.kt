package AgeOfTheUniverse.integration

interface IntegrateStrategy {
    fun run(start: Double, end: Double, eps: Double = 1e-6, f: (Double) -> Double): Double
}