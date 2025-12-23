package AgeOfTheUniverse.cosmology

import kotlin.math.sqrt
import kotlin.math.pow

/**
 * Matter-dominated flat model implementation.
 */
class MatterDominatedFlatImpl : CosmologyModelStrategy {
    override val name = "Matter Dominated Flat"

    override fun E(a: Double): Double {
        if (a <= 0.0) return Double.MAX_VALUE
        return sqrt(a.pow(-3))
    }
}
