package billsPayment

import java.time.LocalDate

fun main() {
    var flag = false
    val waterPayment = Water(123, "Christine", 2195.0, LocalDate.now(), WaterProvider.MAYNILAD )
    val waterPayment2 = Water(1233, "Christine", 2195.0, LocalDate.now(), WaterProvider.MAYNILAD )
    val waterPayment3 = Water(1111, "Doraemon", 1555.55, LocalDate.now(), WaterProvider.MANILAWATER )
    val waterPayment4 = Water(1112, "Nobita", 3422.11, LocalDate.now(), WaterProvider.MANILAWATER )
    val waterPayment5 = Water(1113, "Shizuka", 999.5, LocalDate.now(), WaterProvider.MANILAWATER )
    val electricityPayment = Electricity(123, "Christine", 2195.0, LocalDate.now(), ElectricityProvider.MERALCO )
    val electricityPayment2 = Electricity(123, "Christine", 2195.0, LocalDate.now(), ElectricityProvider.MERALCO )
    val electricityPayment3 = Electricity(2111, "Zuneyo", 1211.5, LocalDate.now(), ElectricityProvider.CAGELCO1 )
    val electricityPayment4 = Electricity(2112, "Damulag", 1855.9, LocalDate.now(), ElectricityProvider.MERALCO )
    val electricityPayment5 = Electricity(2113, "Mickeymouse", 2995.0, LocalDate.now(), ElectricityProvider.CAGELCO1 )
    val listOfWaterBill = listOf<Water>(waterPayment,waterPayment2,waterPayment3,waterPayment4,waterPayment5)
    val listOfElectricityBill= listOf<Electricity>(electricityPayment,electricityPayment2,electricityPayment3,electricityPayment4,electricityPayment5)

    while (!flag) {
        println("==================================")
        println("Bills Payment")
        println("1. Water")
        println("2. Electricity")
        println("3. Exit")
        print("Please enter a number: ")
        val input = readLine()
        if (input == "3") flag = true
        else if(input == "1" || input == "2"){
            println("==================================")
            println("Choose:")
            println("1. Bills Payment")
            println("2. Calculate my bill")
            println("3. Display my details")
            println("4. Check if you are paid")
            println("5. Check account if existing")
            println("6. Exit")
            print("Please enter a number: ")
            when (readLine()) {
                "1" -> {
                    print("Please enter your account number: ")
                    val accountNumber = readLine()!!.toInt()
                    print("Please enter your account name: ")
                    val accountName = readLine().toString()
                    print("Please enter your account due: ")
                    val amount = readLine()!!
                    if (input =="1"){
                        val account = listOfWaterBill.find { it.accountNumber == accountNumber && it.accountName == accountName}
                        if (account == null){
                            println("==================================\nSorry, you do not have any accounts.")
                        }else{
                            println(account?.paymentTransaction(amount))
                        }
                    }else {
                        val account = listOfElectricityBill.find { it.accountNumber == accountNumber && it.accountName == accountName}
                        if (account == null){
                            println("==================================\nSorry, you do not have any accounts.")
                        }else{
                            println(account?.paymentTransaction(amount))
                        }
                    }

                }
                "2" -> {
                    print("Please enter your consumed unit: ")
                    val  consumedUnit = readLine()!!.toInt()
                    if (input == "1") println("The amount is: ${waterPayment.computeWaterBill(consumedUnit)}")
                    else println("The amount is: ${electricityPayment.computeElectricityBill(consumedUnit)}")
                    println("==================================")
                }
                "3" ->{
                    print("Please enter your account number: ")
                    val accountNumber = readLine()!!.toInt()
                    print("Please enter your account name: ")
                    val accountName = readLine().toString()
                    if(input == "1"){
                        val s = listOfWaterBill.find { it.accountNumber == accountNumber && it.accountName == accountName}
                        if (s == null)  println("==================================\nSorry, you do not have any accounts.")
                        else println(s.displayDetails())
                    } else {
                        val s = listOfElectricityBill.find { it.accountNumber == accountNumber && it.accountName == accountName}
                        if (s == null)  println("==================================\nSorry, you do not have any accounts.")
                        else println(s.displayDetails())
                    }
                }
                "4" -> {
                    print("Please enter your account number: ")
                    val accountNumber = readLine()!!.toInt()
                    if (input == "1"){
                        val s = listOfWaterBill.find { it.accountNumber == accountNumber}
                        if (s == null){
                            println("==================================\nSorry, you do not have any accounts.")
                        }else{
                            println(s.checkIsPaid())
                        }
                    }else{
                        val s = listOfElectricityBill.find { it.accountNumber == accountNumber}
                        if (s == null){
                            println("==================================\nSorry, you do not have any accounts.")
                        }else{
                            println(s.checkIsPaid())
                        }

                    }

                }
                "5" ->{
                    print("Please enter your account number: ")
                    val accountNumber = readLine()!!.toInt()
                    if (input == "1") {
                        listOfWaterBill.forEach {
                            println(Water.checkAccount(it, accountNumber))
                        }
                    }
                    else listOfElectricityBill.forEach {
                        println(Electricity.checkAccount(it, accountNumber))
                    }

                }
                "6" -> flag = true
                else -> println("Sorry, your input is invalid.")
            }
        }
        else println("Sorry, Invalid Input!")
    }
}

