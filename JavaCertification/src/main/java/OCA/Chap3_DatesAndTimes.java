package OCA;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * DATES and TIMES samples
 * 
 * @see chap 3 , page 138
 */
public class Chap3_DatesAndTimes {

    final static String newLine = System.lineSeparator();

    public static void main(String args[]) {

        // creating();

        // manipulating();

        // workingWithPeriod();

         formatting();

//         parsing();

    }

    /**
     * Creating Dates and Times
     */
    public static void creating() {

        // current date an time
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        // Date
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20); // recommended way
        LocalDate date2 = LocalDate.of(2015, 1, 20);
        // LocalDate d = new LocalDate(); // DOES NOT COMPILE
        // LocalDate.of(2015, Month.JANUARY, 32); // throws DateTimeException

        // time
        LocalTime time1 = LocalTime.of(6, 15); // hour and minute
        LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
        LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

        // date and time
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1); // recommended way
    }

    /**
     * Manipulating Dates and Times
     */
    public static void manipulating() {

        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
        // plus()
        System.out.println(date); // 2014-01-20
        date = date.plusDays(2);
        System.out.println(date); // 2014-01-22
        date = date.plusWeeks(1);
        System.out.println(date); // 2014-01-29
        date = date.plusMonths(1);
        System.out.println(date); // 2014-02-28
        date = date.plusYears(5);
        System.out.println(date); // 2019-02-28

        // minus()
        // methods to go backward in time
        System.out.println(newLine);
        date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime); // 2020-01-20T05:15
        dateTime = dateTime.minusDays(1);
        System.out.println(dateTime); // 2020-01-19T05:15
        dateTime = dateTime.minusHours(10);
        System.out.println(dateTime); // 2020-01-18T19:15
        dateTime = dateTime.minusSeconds(30);
        System.out.println(dateTime); // 2020-01-18T19:14:30

        // chain method
        System.out.println(newLine);
        LocalDate date2 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time2 = LocalTime.of(5, 15);
        LocalDateTime dateTime2 = LocalDateTime.of(date2, time2).minusDays(1).minusHours(10).minusSeconds(30);
        System.out.println(dateTime2);

        // Converting to a long equivalents in relation to 1970 (UNIX started using for date standards)
        System.out.println(newLine);
        System.out.println(date + ", toEpochDay : " + date.toEpochDay()); // number of days since January 1, 1970
        System.out.println(dateTime + ", toEpochSecond : " + dateTime.toEpochSecond(ZoneOffset.UTC)); // the number of
                                                                                                      // seconds since
                                                                                                      // January 1,
                                                                                                      // 1970.

    }

    /**
     * Working with Periods
     */
    public static void workingWithPeriod() {

        // five way to create periode
        Period annually = Period.ofYears(1); // every 1 year
        Period quarterly = Period.ofMonths(3); // every 3 months
        Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
        Period everyOtherDay = Period.ofDays(2); // every 2 days
        Period everyYearAndAWeek = Period.of(1, 0, 7); // every (1 year, O month, and 7 days)

        // what objects it can be used wit
        Period period = Period.ofMonths(1);
        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(date.plus(period)); // 2015-02-20
        System.out.println(dateTime.plus(period)); // 2015-02-20T06:15
        // System.out.println(time.plus(period)); // UnsupportedTemporalTypeException

        // e.g of use
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);

        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            // swith every month
            System.out.println("new month period: " + upTo);
            upTo = upTo.plus(period); // adds the period
        }

        System.out.println("start =" + start);
        System.out.println("end =" + end);
        System.out.println("upTo = " + upTo);
    }

    /**
     * Parsing Dates and Times
     */
    public static void parsing() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date = LocalDate.parse("01 02 2015", formatter);
        LocalTime time = LocalTime.parse("11:22");
        System.out.println(date); // 2015-01-02
        System.out.println(time); // 11:22
    }

    /**
     * Formatting Dates and Times
     */
    public static void formatting() {

        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        // first way : method to get data, would be more work than necessary.
        System.out.println(date.getDayOfWeek()); // MONDAY
        System.out.println(date.getDayOfMonth()); // 20
        System.out.println(date.getMonth()); // JANUARY
        System.out.println(date.getYear()); // 2020
        System.out.println(date.getDayOfYear()); // 20

        System.out.println(newLine);

        // better way : use DateTimeFormatter
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        System.out.println(newLine);

        // predefined formats that are more useful to output the date and time in your program
        // localized formatter in the predefined short format
        DateTimeFormatter shortDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        // System.out.println(shortDateTime.format(time)); // UnsupportedTemporalTypeException, a time cannot be
        // formatted as a date.
        System.out.println(shortDateFormatter.format(dateTime)); // 1/20/20
        System.out.println(shortDateFormatter.format(date)); // 1/20/20

        DateTimeFormatter shortDateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumDateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(shortDateTimeFormatter.format(dateTime)); // 1/20/20 11:12 AM
        System.out.println(mediumDateTimeFormatter.format(dateTime)); // Jan 20, 2020 11:12:34 AM
        // or
        DateTimeFormatter fullDateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(dateTime.format(fullDateTimeFormatter));
        System.out.println(date.format(fullDateTimeFormatter));

        DateTimeFormatter shortTimeFormtter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        DateTimeFormatter mediumTimeFormtter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        System.out.println(time.format(shortTimeFormtter)); // 11:12
        System.out.println(time.format(mediumTimeFormtter)); // 11:12:34
        System.out.println(dateTime.format(shortTimeFormtter)); // 11:12
        
        // customized Patter formatter
        DateTimeFormatter customizedFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(customizedFormatter)); // January 20, 2020, 11:12

    }
}
