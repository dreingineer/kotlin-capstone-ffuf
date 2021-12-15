package billsPayment

import java.time.LocalDate

open class Electricity(
     accountNumber: Int,
     accountName: String,
     amountDue: Double,
     dueDate: LocalDate,
     electricityprovider: ElectricityProvider ,
) : bills(
    accountNumber,
    accountName,
    amountDue,
    dueDate){
    var isAmountDue: Boolean = false
    companion object {
        fun checkAccount(electricity: Electricity,accountNumber: Int): String{
            return if (electricity.accountNumber == accountNumber) "Account is existing."
            else "Account is not exist."
        }
    }
    fun checkIsPaid(): String {
        return if (isPaid){
            "Your bill is paid with $billId"
        }else{
            "You are not paid." +
                    "Your amount due: $amountDue"
        }
    }

    fun computeElectricityBill(units: Int):Int{
        if (units <= 100) {
            return units * 10
        }
        else if (units <= 200) {
            return (100 * 10)+ (units - 100) * 15
        }
        else if (units <= 300) {
            return (100 * 10)+ (100 * 15)+ (units - 200)* 20
        }
        else if (units > 300) {
            return (100 * 10)+ (100 * 15)+ (100 * 20)+ (units - 300)* 25
        }
        return 0
    }

}