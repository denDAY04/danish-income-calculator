package daic

import java.time.Month

class IncomeMonth {
  final Month month
  int workdays = 0

  IncomeMonth(Month month) {
    this.month = month
  }

  IncomeMonth(int month) {
    this.month = Month.of(month)
  }

  Double calculateIncome(Double hourlyWage, Double hoursPerDay) {
    hourlyWage * hoursPerDay * ((Double) workdays)
  }
}
