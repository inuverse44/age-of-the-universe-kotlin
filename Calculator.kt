package AgeOfTheUniverse

import AgeOfTheUniverse.integration.IntegrateStrategy
import AgeOfTheUniverse.cosmology.CosmologyModelStrategy
import AgeOfTheUniverse.cosmology.CosmologyConstants

class Calculator(
    private var strategy: IntegrateStrategy,
    var model: CosmologyModelStrategy
) {
    fun run(start: Double, end: Double, eps: Double = 1e-6): Double {
        return strategy.run(start, end, eps) { a -> model.integrand(a) }
    }

    fun calculateAge(hubbleTimeGyr: Double = CosmologyConstants.HUBBLE_TIME_GYR): Double {
        val integral = run(0.0, 1.0)
        return hubbleTimeGyr * integral
    }
    
    fun setStrategy(newStrategy: IntegrateStrategy) {
        this.strategy = newStrategy
    }
}