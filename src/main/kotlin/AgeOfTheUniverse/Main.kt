package AgeOfTheUniverse

import AgeOfTheUniverse.cosmology.CosmologyConstants.HUBBLE_NOW
import AgeOfTheUniverse.cosmology.CosmologyConstants.HUBBLE_TIME_GYR
import AgeOfTheUniverse.cosmology.LambdaCdmImpl
import AgeOfTheUniverse.cosmology.MatterDominatedFlatImpl
import AgeOfTheUniverse.integration.SimpsonImpl
import AgeOfTheUniverse.integration.TrapezoidalImpl

fun main() {
    println("--- Age of the Universe Calculation ---\n")

    // 1. Standard LambdaCDM Model
    val lambdaCdm = LambdaCdmImpl()
    // Initialize Calculator with Simpson's Rule and LambdaCDM model
    val calculator = Calculator(SimpsonImpl(), lambdaCdm)
    
    println("Model: ${lambdaCdm.name}")
    println("H0: $HUBBLE_NOW km/s/Mpc")
    
    var age = calculator.calculateAge()
    println("Age: $age Gyr")
    println()

    // 2. Switch to Matter Dominated Flat Model (Einstein-de Sitter)
    // Theoretical prediction: Age = 2/3 * (1/H0)
    val edsModel = MatterDominatedFlatImpl()
    calculator.model = edsModel
    
    println("Model: ${edsModel.name}")
    age = calculator.calculateAge()
    println("Age: $age Gyr")
    
    val hubbleTime = HUBBLE_TIME_GYR
    val theoreticalEdsAge = (2.0 / 3.0) * hubbleTime
    println("Theoretical Age (2/3 * 1/H0): $theoreticalEdsAge Gyr")
    println("Difference: ${kotlin.math.abs(age - theoreticalEdsAge)} Gyr")
    println()

    // 3. Compare Integration Strategies on LambdaCDM
    println("--- Strategy Comparison (LambdaCDM) ---")
    calculator.model = lambdaCdm
    
    // Simpson
    calculator.setStrategy(SimpsonImpl())
    val ageSimpson = calculator.calculateAge()
    println("Simpson Rule: $ageSimpson Gyr")

    // Trapezoidal
    calculator.setStrategy(TrapezoidalImpl())
    val ageTrap = calculator.calculateAge()
    println("Trapezoidal Rule: $ageTrap Gyr")
}