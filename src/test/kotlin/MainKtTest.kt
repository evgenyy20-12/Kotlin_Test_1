import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun main_Mastercard() {
        val cardType = "Mastercard"
        var result = commission(cardType)

        assertEquals(92000, result)
    }

    @Test
    fun main_Maestro() {
        val cardType = "Maestro"
        var result = commission(cardType)

        assertEquals(92000, result)
    }

    @Test
    fun main_vkPay() {
        val cardType = "VkPay"
        var result = commission(cardType)

        assertEquals(0, result)
    }

    @Test
    fun main_visa() {
        val cardType = "Visa"
        var result = commission(cardType)

        assertEquals(112500, result)
    }

    @Test
    fun main_mir() {
        val cardType = "Мир"
        var result = commission(cardType)

        assertEquals(112500, result)
    }

    @Test
    fun main_WrongCard() {
        val cardType = "Ort"
        var result = commission(cardType)

        assertEquals(0, result)
    }

    @Test
    fun vkPay_addMaxSumm() {
        val transferAmount = 15000
        val amountOfPreviousTransfers = 0

        var result = vkPay(transferAmount, amountOfPreviousTransfers)
        assertEquals(1, result)
    }

    @Test
    fun vkPay_NotAddMaxSumm() {
        val transferAmount = 15000000
        val amountOfPreviousTransfers = 0

        var result = vkPay(transferAmount, amountOfPreviousTransfers)
        assertEquals(0, result)
    }

    @Test
    fun mastercardMaestro_shouldAddCommision() {
        val transferAmount = 150000

        var result = mastercardMaestro(transferAmount)
        assertEquals(92000, result)
    }

    @Test
    fun mastercardMaestro_shoulNotdAddCommission() {
        val transferAmount = 355

        var result = mastercardMaestro(transferAmount)
        assertEquals(1, result)
    }

    @Test
    fun visaMir_shouldAddMinCommission() {
        val transferAmount = 1000

        var result = visaMir(transferAmount)
        assertEquals(3500, result)
    }

    @Test
    fun visaMir_shouldAddCommission() {
        val transferAmount = 100000
        val commission = 0.75
        val commissionForTranslation = (transferAmount * commission).toInt()
        var result = visaMir(transferAmount)
        assertEquals(commissionForTranslation, result)
    }
    @Test
    fun commission_mir(){
        val cardType = "Мир"

        var result = commission(cardType)
        assertEquals(112500, result)

    }
}

