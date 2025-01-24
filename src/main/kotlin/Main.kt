package ru.netology


fun main() {
    val card1 = "MASTERCARD"
    val card2 = "VISA"
    val card3 = "MIR"
    val transfer1 = 80_000
    val transfer2 = 60_000
    val transfer3 = 110_000

    println("Перевод с карты $card1 сумма $transfer1 ${transferMoney(card1, 0, transfer1)} руб.")
    println("Перевод с карты $card2 сумма $transfer2 ${transferMoney(card2, 0, transfer2)} руб.")
    println("Перевод с карты $card2 сумма $transfer3 ${transferMoney(card3, 410_000, transfer3)} руб.")

}

fun transferMoney(cardType: String = "MIR", transferMonth: Int = 0, summTransfer: Int): Pair<String, Int> {
    val limitDay = 150_000
    val limitMonth = 600_000


    if (summTransfer > limitDay || transferMonth + summTransfer > limitMonth) {
        return Pair("Превышен лимит", 0)
    }

    var comission = when (cardType) {

        "VISA" -> maxOf((summTransfer * 0.0075).toInt(), 35)

        "MASTERCARD" -> {
            val freeLimit = 75_000
            val taxableAmount = maxOf(0, transferMonth + summTransfer - freeLimit)
            if (taxableAmount > 0) (taxableAmount * 0.006).toInt() + 20 else 0
        }

        else -> 0

    }
    return Pair("комиссия составит", comission)
}
