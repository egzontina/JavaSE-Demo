package DateTime;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class DateAndTime {

	/**
	 * for JDK 7 and earlier : 
	 * A better solution is to use a tried and tested date and time library like Joda-Time
	 * 		Calendar : Months are counted from 0, not 1
	 * 
	 */
	
	public static final String newLine = System.getProperty("line.separator");
	
	public static void main(String[] args) {
			
//		periodAndDurationTest();
//		formaterDateTimeTest
//		test();
//		zoneIdTest();
		
		Date_ConvertSqltoUtil();
	}
	
	public static void test() {
		
		/* Date : instant */
		Instant instant = Instant.now();
		
		System.out.println("Instant.now() : "+ instant);
		System.out.println("\n");

		/* locale Date - date empirique */
		LocalDate nowLocalDate = LocalDate.now();
		LocalDate shakespearedDoB =  LocalDate.of(1564, Month.APRIL, 23);	
		LocalDate currentDateplus1days = nowLocalDate.plusDays(1) ;
		
		System.out.println("LocalDate.now()  : "+ nowLocalDate);
		System.out.println("LocalDate.now().plusDays(1)  : " + currentDateplus1days);
		System.out.println("LocalDate.of(1564, Month.APRIL, 23)  : "+ shakespearedDoB);
		System.out.println(newLine);
		
		/* local time - heure emprique */
		LocalTime timeHM = LocalTime.of(10, 20);
		LocalTime timeHMSN = LocalTime.of(10, 0, 0, 0);
		LocalTime timePlusHour = timeHM.plusHours(2);
		
		System.out.println("LocalTime.of(10, 20) : "+ timeHM);
		System.out.println("LocalTime.of(10, 0, 0, 0) : "+ timeHMSN);
		System.out.println("LocalTime.of(10, 20).plusHours(2) : "+ timePlusHour);
		System.out.println(newLine);
	}
	
	
	
	/** ======================================================== DATE TIME FORMATER ==================================================================== */
	
	public static void formaterDateTimeTest() {
	
		// DateTimeFormatter : lagacy <--> New API
		Date date = Date.from(Instant.now()); // legacy -> new API
		Instant instant = date.toInstant(); // API -> legacy
		Timestamp time = Timestamp.from(Instant.now()); // legacy -> new API
		Instant instant2 = time.toInstant(); // API -> legacy
			
		// TODO
		// Date date2 = Date.from(LocalDate.now());
		// LocalDate localDate2 = date2.toLocaleDate():
		System.out.println("Date : " + date);
		System.out.println("instant date : " + instant);
		System.out.println("timestamp : " + time);
		System.out.println("instant2 : " + instant2);
	}
	
	
	/** ======================================================== ZONE ID - ============================================================================= */	
	/**
	 * coder une heure localisé
	 */
	public static void zoneIdTest() {
		
		/* Zoned Time */
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();		
		System.out.println("ZoneId.getAvailableZoneIds() : "+ allZoneIds.toString());
		System.out.println("ZoneId.systemDefault() : "+ ZoneId.systemDefault());
		System.out.println(newLine);
		
		LocalDate localDate =  LocalDate.of(1564, Month.APRIL, 23);
		LocalTime localtime = LocalTime.of(10, 0, 0, 0);
		
		ZoneId parisTimeZone = ZoneId.of("Europe/Paris");
		ZoneId usTimeZone = ZoneId.of("US/Central");
		
		ZonedDateTime zoneDateTime = ZonedDateTime.of(localDate, localtime, parisTimeZone);
		ZonedDateTime nextZoneTime = zoneDateTime.plus(Period.ofMonths(1));
		ZonedDateTime zoneTimeUS = zoneDateTime.withZoneSameInstant(usTimeZone);
				
		System.out.println("ZonedDateTime.of() : " + zoneDateTime);
		System.out.println("ZonedDateTime.of().plus(Period.ofMonths(1)) : " + nextZoneTime);
		System.out.println("ZonedDateTime.of().withZoneSameInstant() : " + zoneTimeUS);
		System.out.println(newLine);		
		// date time formater
		System.out.println("nextZoneTimeUS ISO : " + DateTimeFormatter.ISO_DATE_TIME.format(zoneTimeUS));
		System.out.println("nextZoneTimeUS RFC : " + DateTimeFormatter.RFC_1123_DATE_TIME.format(zoneTimeUS));
		System.out.println(newLine);

	}
	
	/** ======================================================== PERIOD - DURATION & DIFERRENCE ======================================================== */
	/**
	 * Duration is time-based (nanos) and Period is date-based (year/month/day).
	 */
	public static void periodAndDurationTest() {
		
		Instant start = Instant.now();
		Instant end = Instant.EPOCH; // Constant for the 1970-01-01T00:00:00Z epoch instant
		
		LocalDateTime fromDateTime = LocalDateTime.of(1990, 07, 16, 7, 45, 55); // ( year,  month, dayOfMonth, hour, minute, second)
		LocalDateTime toDateTime = LocalDateTime.now();
        
		Period period = Period.between(fromDateTime.toLocalDate(), toDateTime.toLocalDate());
		Duration duration0 = Duration.between(fromDateTime, toDateTime);
		long days = ChronoUnit.DAYS.between(fromDateTime, toDateTime); // preferred
		// long days = fromDateTime.until(toDateTime, ChronoUnit.DAYS); // same result
		
		System.out.println("LocalDateTime period : "+ period);
		System.out.println("LocalDateTime period : "+ period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days ");
		System.out.println("LocalDateTime duration : Duration millis : "+ duration0.toMillis());
		System.out.println("LocalDateTime Duration.between().millis() : "+ duration0.toMillis());
		System.out.println("LocalDateTime Duration.between().getNano() : "+ duration0.getNano());
		System.out.println("LocalDateTime Start.until() : "+ days);
		System.out.println(newLine);
		
		// The Duration between two temporal objects of the same type can be calculated as follows:
		
		/* Duration */
		Duration duration = Duration.between(start, end);
		
		// TODO to check
		 duration.plus(2L, ChronoUnit.SECONDS);
		 duration.plus(10L, ChronoUnit.MINUTES);
				
		System.out.println("Instant Duration elapsed : "+ duration);
		System.out.println("Instant Duration millis : "+ duration.toMillis());
		System.out.println(newLine);
		
		LocalDate oldDate = LocalDate.of(1984, Month.JUNE, 4);
	    LocalDate currentDate = LocalDate.now();
	    Period betweenDates = Period.between(oldDate, currentDate);
	    
	    // Period.between(oldDate, currentDate).getDays() === différence uniquement entre les jours des dates 
	    // ChronoUnit.DAYS.between(oldDate, currentDate) === différence total entre les deux date EN JOURS, 
	    System.out.println(
	    		"LocalDate - Period.between().diffInDays.getDays : " + betweenDates.getDays() + "\n" +
	    		"LocalDate - Period.between().diffInMonths.getMonths  : " + betweenDates.getMonths() + "\n" + 
	    		"LocalDate - Period.between().diffInYears.getYears  : " + betweenDates.getYears() + "\n" +
	    		"LocalDate - ChronoUnit.DAYS.between()  : " + ChronoUnit.DAYS.between(oldDate, currentDate) + "\n" +
	    		"LocalDate - ChronoUnit.MONTHS.between()  : " + ChronoUnit.MONTHS.between(oldDate, currentDate) + "\n" +
	    		"LocalDate - ChronoUnit.YEARS.between()  : " + ChronoUnit.YEARS.between(oldDate, currentDate) + "\n"
	    		);
	    
	    /* locale Date - date empirique *********** */
		LocalDate nowLocalDate = LocalDate.now();
		LocalDate shakespearedDoB =  LocalDate.of(1564, Month.APRIL, 23);		
		/* Periode : durée entre localdate */
		Period p = shakespearedDoB.until(nowLocalDate);		
		Long pDAYS = shakespearedDoB.until(nowLocalDate, ChronoUnit.DAYS);
		System.out.println(
				"shakespeareDoB Locale Date : "+ shakespearedDoB + "\n" 
				+ "now Locale Date : "+ nowLocalDate + "\n" 
				+ "shakespeareDoB period YEAR from now : " + p.getYears() + "\n" 
				+ "shakespeareDoB period DAYS from now : " + pDAYS + "\n" 
		);
		
		
	}
	
	/** ======================================================== DATE RANGE - ============================================================================= */	
	/**
	 * coder une heure localisé
	 */
	public static void checkDateRange() {
		
		
	}
	
	/** ======================================================== Temporal Adjusters ================================================================== */
	/**
	 * trouver une date à partir d'une autre
	 */
	public static void getDateFromAnotherDate() {
		
		LocalDate currentLocalDate = LocalDate.now();
		LocalDateTime currentDateTime = LocalDateTime.now();
	 
		System.out.println("firstDayOfMonth: "+ currentDateTime.with(TemporalAdjusters.firstDayOfMonth()));
		
		System.out.println("currentDateTime lastDayOfMonth		: "+ currentDateTime.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println("currentDateTime firstDayOfNextMonth	: "+ currentDateTime.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.println("currentDateTime firstDayOfNextYear	: "+ currentDateTime.with(TemporalAdjusters.firstDayOfNextYear()));
		System.out.println("currentDateTime firstDayOfYear		: "+ currentDateTime.with(TemporalAdjusters.firstDayOfYear()));
		System.out.println("currentDateTime next DayOfWeek		: "+ currentDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
		
		System.out.println("current Local Date - next DayOfWeek		: "+ currentLocalDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));			 
		
	}
	
	/** ======================================================== JAVA 7 & 6 & 5 ==================================================================== */
	
	public static void DateAndTimeJava7Test() {
		
		// check range date 
		Date date = new Date() ;		
		Calendar minDate = Calendar.getInstance();
		minDate.set(2005, 07, 11, 0, 0, 0);
		Calendar maxDate = Calendar.getInstance();
		maxDate.set(2010, 06, 8, 0, 0, 0);
		System.out.println("date.after(minDate.getTime()) : " + date.after(minDate.getTime()) ); ;
		System.out.println("date.after(minDate.getTime()) : " + date.before(maxDate.getTime()) );
		System.out.println("between : " + (date.after(minDate.getTime()) && date.before(maxDate.getTime())) );
	}
	
	private static long daysBetweenJava7Test(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}
	
	/** convert java.util.Date to java.sql.Date in Java */
	
	public static void Date_ConvertSqltoUtil() { 
		
		// contains both date and time information 
		Date javaDate = new Date(); 
		// contains only date information without time 
		java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
		
		System.out.println("Convert SqlToJava - Java : " + javaDate);		
		System.out.println("SQL date in Java : " + sqlDate); 
		System.out.println("SQL date in Java - Time : " + sqlDate.getTime()); 
		System.out.println("SQL date in Java - Time : " + sqlDate.getDate()); 
		System.out.printf("Time : %s:%s:%s", sqlDate.getHours(), sqlDate.getMinutes(), sqlDate.getSeconds()); 
	
	}
	
	/** ======================================================== JODA TIME  ==================================================================== */
	
	public static void DateAndTimeJodaTime() {
	
		
	}

}
