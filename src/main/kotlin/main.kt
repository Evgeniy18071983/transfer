import kotlin.math.roundToInt

var commissionVkPay = 0
var commission = 0.075
fun transfer(amountMonth: Int, whatPaySystem: Int, amount: Double) {

    val commissionMasterAndMaestro = if ((amountMonth in 301..74999)) 0.0 else (amount * 0.006 + 20)

    val commissionVisaAndMir =if ((commission*amount) < 35) 35.0 else (commission*amount)

    val price = when (whatPaySystem) {
        1 -> amount - commissionMasterAndMaestro
        2 -> amount - commissionMasterAndMaestro
        3 -> amount - commissionVisaAndMir
        4 -> amount - commissionVisaAndMir
        5 -> amount - amount * commissionVkPay
        else -> println("Ошибка")
    }
val finalPrice = price as Double
    val amountTransaction = (finalPrice * 100.0).roundToInt() / 100.0
    println("Вы перевели: $amountTransaction рублей")
}
fun main() {
    println("К какой платежной системы относится Ваша карта? ")
    val string = """1. Mastercard
            |2. Maestro
            |3. Visa
            |4. Мир
            |5. VK Pay
             """.trimMargin()
    println (string)
    val whatPaySystem = readLine()!!.toInt()
    println("Укажите обущю сумму переводов за месяц:")
    val amountMonth = readLine()!!.toInt()

    println("Укажите обущю сумму переводов за день:")
    val amountDay = readLine()!!.toDouble()

    if (amountDay >= 150_000.00 || amountMonth >= 600_000.0) {
        println("Лимиты переводов превышены, операция отменена")
    } else {
        println("Какую сумму будете переводить?")
        val amount = readLine()!!.toDouble()
        transfer(amountMonth, whatPaySystem, amount)
    }
}

