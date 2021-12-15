package billsPayment

import java.time.LocalDate

class Water (
     accountNumber: Int,
     accountName: String,
     amountDue: Double,
     dueDate: LocalDate,
     waterprovider: WaterProvider,
) : bills(
    accountNumber,
    accountName,
    amountDue,
    dueDate,
) {

    companion object {
        fun checkAccount(water: Water,accountNumber: Int): String{
            return if (water.accountNumber == accountNumber) "Account is existing."
            else "Account is not exist."
        }
    }
    private fun compute(cm: Int): Double {
        val total = (cm * 12) + 38.85
        val tax = (total * .12)
        return total + tax
    }

    fun checkIsPaid(): String {
        return if (isPaid){
            "Your bill is paid with $billId"
        }else{
            "You are not paid."
        }
    }

    fun computeWaterBill(cm: Int):Double{
        return "%.2f".format(compute(cm)).toDouble()
    }


}