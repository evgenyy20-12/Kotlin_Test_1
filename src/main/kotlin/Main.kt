fun main() {
    val cardType = "Mastercard"
    commission(cardType)
}

fun commission(cardType: String):Int {
    val transferAmount = 150000
    val amountOfPreviousTransfers = 0
    return when (cardType) {
        "Vk Pay" -> vkPay(transferAmount, amountOfPreviousTransfers)
        "Mastercard", "Maestro" -> mastercardMaestro(transferAmount)
        "Visa", "Мир" -> visaMir(transferAmount)
        else -> 0
    }
}

fun vkPay(transferAmount: Int, amountOfPreviousTransfers: Int):Int {
    if (transferAmount / 100 <= 15000 && amountOfPreviousTransfers / 100 <= 40000) {
        return 1
    } else {
        return 0
    }
}

fun mastercardMaestro(transferAmount: Int):Int {
    val commission = 0.6
    val commissionForTranslation = transferAmount * commission + 2000
    return when (transferAmount) {
        in 300..75000 -> 1
        else -> commissionForTranslation.toInt()
    }
}

fun visaMir(transferAmount: Int):Int {
    val commission = 0.75
    val minimumCommission = 3500
    val commissionForTranslation = transferAmount * commission
    var cardTransferCommission = 0
    if (commissionForTranslation < minimumCommission) {
        cardTransferCommission = minimumCommission;
    } else {
        cardTransferCommission = commissionForTranslation.toInt()
    }
    return cardTransferCommission
}