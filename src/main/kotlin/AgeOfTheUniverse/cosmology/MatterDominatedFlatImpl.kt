package AgeOfTheUniverse.cosmology

import kotlin.math.sqrt
import kotlin.math.pow

class MatterDominatedFlatImpl : CosmologyModelStrategy {
    override val name = "Matter Dominated Flat (Einstein-de Sitter)"

    override fun E(a: Double): Double {
        if (a <= 0.0) return Double.MAX_VALUE
        // Flat, Matter only: Omega_m = 1
        return sqrt(a.pow(-3))
    }
}
