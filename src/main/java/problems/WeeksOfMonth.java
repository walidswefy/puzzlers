package problems;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author walid.sewaify
 * @since 22-Nov-20
 */
public class WeeksOfMonth {
    public static void main(String[] args) {
        printWeeks(2010, Month.JANUARY);
    }

    private static void printWeeks(int year, Month month) {
        LocalDate monthStart = LocalDate.of(year, month, 1);
        LocalDate weekStart = monthStart
                .with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        while (weekStart.isBefore(monthStart.plus(1, ChronoUnit.MONTHS))) {
            System.out.println("Week start: " + weekStart.toString());
            weekStart = weekStart.plus(6, ChronoUnit.DAYS);
            System.out.println("Week end: " + weekStart.toString());
            weekStart = weekStart.plus(1, ChronoUnit.DAYS);
        }
    }
}
