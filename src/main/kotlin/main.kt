import kotlin.math.roundToInt

var commissionVkPay = 0
fun transfer() {
    println("К какой платежной системы относится Ваша карта? ")
    val string = """1. Mastercard
            |2. Maestro
            |3. Visa
            |4. Мир
            |5. VK Pay
             """.trimMargin()
    println (string)
    val whatPaySystem = readLine()!!.toInt()

    println("Какую сумму будете переводить?")
    val amount = readLine()!!.toDouble()

    println("Укажите обущю сумму переводов за месяц:")
    val amountMonth = readLine()!!.toInt()

    println("Укажите обущю сумму переводов за день:")
    val amountDay = readLine()!!.toDouble()

    val commission1 = if ((amountMonth in 301..74999)) 0 else (amount * 0.006 + 20)

    val commission2 =0.005 //if ((commission*amount) < 35) 35 else (commission*amount)


    val price = when (whatPaySystem) {
        1 -> amount - (amount * commission1)
        2 -> amount - (amount * commission1)
        3 -> amount - (amount * commission2)
        4 -> amount - (amount * commission2)
        5 -> amount - amount * commissionVkPay
        else -> println("Ошибка")
    }
val finalPrice = price as Double
    val amountTransaction = (finalPrice * 100.0).roundToInt() / 100.0
    println("Вы перевели: $amountTransaction рублей")
}

private operator fun Double.minus(any: Any): Any {
    TODO("Not yet implemented")
}

private operator fun Double.times(commission2: Number): Any {
    TODO("Not yet implemented")
}

fun main() {
    transfer()
}