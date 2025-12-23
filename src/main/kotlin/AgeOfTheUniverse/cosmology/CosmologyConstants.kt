package AgeOfTheUniverse.cosmology

/**
 * Constants for Cosmological calculations based on Planck 2018 results.
 */
object CosmologyConstants {

    // density parameter
    const val OMEGA_MATTER_NOW = 0.315
    const val OMEGA_RADIATION_NOW = 0.00009
    const val OMEGA_VACUUM_NOW = 0.685

    // Hubble parameter
    const val REFERENCE_HUBBLE = 100.0
    const val REDUCED_HUBBLE_NOW = 0.674
    const val HUBBLE_NOW = REFERENCE_HUBBLE * REDUCED_HUBBLE_NOW

    /**
     * Conversion factor: 1/H0 in Gyr.
     * Calculated as (Mpc in km) / (seconds in Gyr) / H0.
     * Approximately 977.8 / H0.
     */
    const val HUBBLE_TIME_GYR = 9.78 / REDUCED_HUBBLE_NOW
}
