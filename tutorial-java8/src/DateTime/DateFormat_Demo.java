package DateTime;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Demonstrates formatting dates as strings and parsing strings into dates and
 * times using pre-Java 8 (java.text.SimpleDateFormat) and Java 8
 * (java.time.format.DateTimeFormatter) mechanisms.
 * 
 * java.time.format.DateTimeFormatter class is immutable and thread-safe, 
 * The JDK 8 date/time classes and related formatting and parsing classes are much more straightforward
 * 
 * SimpleDateFormat in Java is not Thread-Safe
 */
public class DateFormat_Demo {
	/** Pattern to use for String representation of Dates/Times. */
	private final String dateTimeFormatPattern = "yyyy/MM/dd HH:mm:ss z";

	/**
	 * java.util.Date instance representing now that can be formatted using
	 * SimpleDateFormat based on my dateTimeFormatPattern field.
	 */
	private final Date now = new Date();

	/**
	 * java.time.ZonedDateTime instance representing now that can be formatted
	 * using DateTimeFormatter based on my dateTimeFormatPattern field.
	 * 
	 * Note that ZonedDateTime needed to be used in this example instead of
	 * java.time.LocalDateTime or java.time.OffsetDateTime because there is zone
	 * information in the format provided by my dateTimeFormatPattern field and
	 * attempting to have DateTimeFormatter.format(TemporalAccessor)
	 * instantiated with a format pattern that includes time zone details will
	 * lead to DateTimeException for instances of TemporalAccessor that do not
	 * have time zone information (such as LocalDateTime and OffsetDateTime).
	 */
	private final ZonedDateTime now8 = ZonedDateTime.now();

	/**
	 * String that can be used by both SimpleDateFormat and DateTimeFormatter to
	 * parse respective date/time instances from this String.
	 */
	private final String dateTimeString = "2014/09/03 13:59:50 MDT";

	/**
	 * Demonstrate presenting java.util.Date as String matching provided pattern
	 * via use of SimpleDateFormat.
	 */
	public void demonstrateSimpleDateFormatFormatting() {
		final DateFormat format = new SimpleDateFormat(dateTimeFormatPattern);
		final String nowString = format.format(now);
		System.out.println("Date '" + now + "' formatted with SimpleDateFormat and '" + dateTimeFormatPattern + "': " + nowString);
	}

	/**
	 * Demonstrate parsing a java.util.Date from a String via SimpleDateFormat.
	 */
	public void demonstrateSimpleDateFormatParsing() {
		final DateFormat format = new SimpleDateFormat(dateTimeFormatPattern);
		try {
			final Date parsedDate = format.parse(dateTimeString);
			System.out.println("'" + dateTimeString + "' is parsed with SimpleDateFormat as " + parsedDate);
		}
		// DateFormat.parse(String) throws a checked exception
		catch (ParseException parseException) {
			System.out.println("ERROR: Unable to parse date/time String '"+ dateTimeString + "' with pattern '"+ dateTimeFormatPattern + "'.");
		}
	}

	/**
	 * Demonstrate presenting ZonedDateTime as a String matching provided
	 * pattern via DateTimeFormatter and its ofPattern(String) method.
	 */
	public void demonstrateDateTimeFormatFormatting() {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
		final String nowString = formatter.format(now8);
		System.out.println(now8 + " formatted with DateTimeFormatter and '"+ dateTimeFormatPattern + "': " + nowString);
	}

	/**
	 * Demonstrate parsing ZonedDateTime from provided String via
	 * ZonedDateTime's parse(String, DateTimeFormatter) method.
	 */
	public void demonstrateDateTimeFormatParsingTemporalStaticMethod() {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
		final ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString,formatter);
		System.out.println("'"+ dateTimeString+ "' is parsed with DateTimeFormatter and ZonedDateTime.parse as "+ zonedDateTime);
	}

	/**
	 * Demonstrate parsing ZonedDateTime from String via
	 * DateTimeFormatter.parse(String, TemporaryQuery) with the Temple Query in
	 * this case being ZonedDateTime's from(TemporalAccessor) used as a Java 8
	 * method reference.
	 */
	public void demonstrateDateTimeFormatParsingMethodReference() {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
		final ZonedDateTime zonedDateTime = formatter.parse(dateTimeString,ZonedDateTime::from);
		System.out.println("'" + dateTimeString + "' is parsed with DateTimeFormatter and ZoneDateTime::from as " + zonedDateTime);
	}

	/**
	 * Demonstrate formatting ZonedDateTime via DateTimeFormatter, but using
	 * implementation of Format.
	 */
	public void demonstrateDateTimeFormatAndFormatFormatting() {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
		final Format format = formatter.toFormat();
		final String nowString = format.format(now8);
		System.out.println("ZonedDateTime " + now
				+ " formatted with DateTimeFormatter/Format (and "
				+ format.getClass().getCanonicalName() + ") and '"
				+ dateTimeFormatPattern + "': " + nowString);
	}

	/**
	 * Demonstrate formatting and parsing an instance of Instant.
	 */
	public void demonstrateDateTimeFormatFormattingAndParsingInstant() {
		// Instant instances don't have timezone information
		final Instant instant = now.toInstant();
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern).withZone(ZoneId.systemDefault());
		final String formattedInstance = formatter.format(instant);
		System.out.println("Instant " + instant
				+ " formatted with DateTimeFormatter and '"
				+ dateTimeFormatPattern + "' to '" + formattedInstance + "'");
		final Instant instant2 = formatter.parse(formattedInstance,ZonedDateTime::from).toInstant();
		System.out.println(formattedInstance + " parsed back to " + instant2);
	}

	/**
	 * Demonstrate java.text.SimpleDateFormat and
	 * java.time.format.DateTimeFormatter.
	 * 
	 * @param arguments
	 *            Command-line arguments; none anticipated.
	 */
	public static void main(final String[] arguments) {
		final DateFormat_Demo demo = new DateFormat_Demo();
		System.out.print("\n1: ");
		demo.demonstrateSimpleDateFormatFormatting();
		System.out.print("\n2: ");
		demo.demonstrateSimpleDateFormatParsing();
		System.out.print("\n3: ");
		demo.demonstrateDateTimeFormatFormatting();
		System.out.print("\n4: ");
		demo.demonstrateDateTimeFormatParsingTemporalStaticMethod();
		System.out.print("\n5: ");
		demo.demonstrateDateTimeFormatParsingMethodReference();
		System.out.print("\n6: ");
		demo.demonstrateDateTimeFormatAndFormatFormatting();
		System.out.print("\n7: ");
		demo.demonstrateDateTimeFormatFormattingAndParsingInstant();
	}
}
