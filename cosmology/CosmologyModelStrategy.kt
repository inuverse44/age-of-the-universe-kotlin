package AgeOfTheUniverse.cosmology

import kotlin.math.sqrt
import kotlin.math.pow

interface CosmologyModelStrategy {
    val name: String
    
    /**
     * Calculates the dimensionless Hubble parameter E(a) = H(a) / H0.
     */
    fun E(a: Double): Double

    /**
     * Returns the integrand for the age calculation: 1 / (a * E(a)).
     * This corresponds to dt * H0 = da / (a * E(a)).
     */
    fun integrand(a: Double): Double {
        if (a <= 0.0) return 0.0 // Singularity at a=0 handled: lim a->0 is 0 for standard models
        val e = E(a)
        return if (e == 0.0) 0.0 else 1.0 / (a * e)
    }
}
