package daic


import java.time.LocalDate
import java.time.Month
import java.util.stream.IntStream

class IncomeCalculator {
  private static final float amBidragRatio = 0.08
  private static final double atpBidrag = 94.65

  private final Integer year
  private final Double hourlyWage
  private final Double hoursPerDay
  private final Map<Month, IncomeMonth> months

  IncomeCalculator(Integer year, Double wage, Double hoursPerDay) {
    this.year = year
    this.hourlyWage = wage
    this.hoursPerDay = hoursPerDay

    months = initializeMonths()
    setIncomePerMonth()
  }

  double monthlyIncome(Month month) {
    months.get(months).calculateIncome(hourlyWage, hoursPerDay)
  }

  double annualSum() {
    months.values().stream().mapToDouble(m -> hourlyWage * hoursPerDay * m.workdays).sum()
  }

  double annualSumAfterATP() {
    annualSum() - (12 * atpBidrag)
  }

  double annualSumAfterAM() {
    annualSumAfterATP() * (1.0 - amBidragRatio)
  }

  private static Map<Month, IncomeMonth> initializeMonths() {
    def months = new HashMap<Month, IncomeMonth>()
    IntStream.range(1, 13).forEach{months.put(Month.of(it), new IncomeMonth(it)) }
    return months
  }

  private void setIncomePerMonth() {
    def first = LocalDate.of(year, 1, 1)
    first
        .datesUntil(first.plusYears(1))
        .filter(d -> d.getDayOfWeek().isWeekday())
        .forEach(d -> months.get(d.getMonth()).workdays++)
  }

}