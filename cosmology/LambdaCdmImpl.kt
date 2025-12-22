package AgeOfTheUniverse.cosmology

import kotlin.math.sqrt
import kotlin.math.pow

class LambdaCdmImpl(
    private val Om: Double = CosmologyConstants.OMEGA_MATTER_NOW,
    private val Or: Double = CosmologyConstants.OMEGA_RADIATION_NOW,
    private val Ol: Double = CosmologyConstants.OMEGA_VACUUM_NOW
) : CosmologyModelStrategy {
    
    private val Ok = 1.0 - Om - Or - Ol
    override val name = "LambdaCDM (Om=$Om, Or=$Or, Ol=$Ol)"

    override fun E(a: Double): Double {
        if (a <= 0.0) return Double.MAX_VALUE // Effectively infinite H at big bang
        val term1 = Om * a.pow(-3)
        val term2 = Or * a.pow(-4)
        val term3 = Ol
        val term4 = Ok * a.pow(-2)
        return sqrt(term1 + term2 + term3 + term4)
    }
}
