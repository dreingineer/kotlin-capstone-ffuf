package billsPayment
import java.time.LocalDate
import java.time.temporal.ChronoUnit

abstract class bills(
    override var accountNumber: Int,
    override var accountName: String,
    override var amountDue: Double,
    open var dueDate: LocalDate,
): billsPaymentInterface {
    var isPaid = false
        private set

    var billId = ""

    private fun checkAmountDueDate(): Long {
        return ChronoUnit.DAYS.between(dueDate, LocalDate.now())
    }
    fun paymentTransaction(amount: Double): String{
         if(amount >= amountDue){
            if (checkAmountDueDate().toInt() <= 0) {
                isPaid = true
                return "==========PAYMENT DETAILS==========\n"+
                        "Account Number: $accountNumber \n" +
                        "Account Name: $accountName \n" +
                        "Amount Due: $amountDue\n" +
                        "Change Amount: ${amount.minus(amountDue)}\n" +
                        "Due Date: $dueDate" +
                        "Bill Status is paid: $isPaid"

            }else {
                return "Late Payment:" +
                        "Account Number: $accountNumber \n" +
                        "Account Name: $accountName \n" +
                        "Amount Due: $amountDue\n" +
                        "Due Date: $dueDate" +
                        "Bill Status is paid: $isPaid"
            }
        } else return "==================================\nSorry, the transaction is failed!"

    }

    fun paymentTransaction(amount: String): String{
         if(amount.toDouble() >= amountDue){
             if (checkAmountDueDate().toInt() <= 0) {
                 isPaid = true
                 return "==========PAYMENT DETAILS==========\n"+
                         "Account Number: $accountNumber \n" +
                         "Account Name: $accountName \n" +
                         "Amount Due: $amountDue\n" +
                         "Due Date: $dueDate" +
                         "Bill Status is paid: $isPaid"
             }else {
                 return "Late Payment:" +
                         "Account Number: $accountNumber \n" +
                         "Account Name: $accountName \n" +
                         "Amount Due: $amountDue\n" +
                         "Due Date: $dueDate" +
                         "Bill Status is paid: $isPaid"
             }
         } else return "==================================\nSorry, the transaction is failed!"
    }

    fun paymentTransaction(amount: Int): String{
         if(amount.toDouble() >= amountDue){
            if (checkAmountDueDate().toInt() <= 0) {
                isPaid = true
                return "==========PAYMENT DETAILS==========\n"+
                        "Account Number: $accountNumber \n" +
                        "Account Name: $accountName \n" +
                        "Amount Due: $amountDue\n" +
                        "Due Date: $dueDate" +
                        "Bill Status is paid: $isPaid"
            }else {
                return "Late Payment:" +
                        "Account Number: $accountNumber \n" +
                        "Account Name: $accountName \n" +
                        "Amount Due: $amountDue\n" +
                        "Due Date: $dueDate" +
                        "Bill Status is paid: $isPaid"
            }
        } else return "==================================\nSorry, the transaction is failed!"
    }

    fun displayDetails(): String{
        return "===========BILL DETAILS==========\n" +
                "Account Number: $accountNumber \n" +
                "Account Name: $accountName \n" +
                "Amount Due: $amountDue\n" +
                "Due Date: $dueDate"+
                "\nBill Status is paid: $isPaid"
    }

    init{
        this.billId = "${accountName.substring(0,2).uppercase()}-${(10000000 until 99999999).random()}"
    }
}
