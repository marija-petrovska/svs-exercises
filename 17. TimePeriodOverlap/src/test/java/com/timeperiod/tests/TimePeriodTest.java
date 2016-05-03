package com.timeperiod.tests;

import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;
import com.timeperiod.time.TimePeriod;

public class TimePeriodTest {

	@Test
	public void firstPeriodContainsSecond() {

		final LocalTime periodAStart = LocalTime.of(3, 10);
		final LocalTime periodAEnd = LocalTime.of(4, 0);

		final LocalTime periodBStart = LocalTime.of(3, 30);
		final LocalTime periodBEnd = LocalTime.of(3, 50);

		final TimePeriod periodA = new TimePeriod(periodAStart, periodAEnd);
		final TimePeriod periodB = new TimePeriod(periodBStart, periodBEnd);

		final boolean overlaps;
		overlaps = periodA.overlapsWith(periodB);

		Assert.assertTrue(overlaps);
	}

	@Test
	public void secondPeriodContainsFirst() {

		final LocalTime periodAStart = LocalTime.of(3, 0);
		final LocalTime periodAEnd = LocalTime.of(4, 0);

		final LocalTime periodBStart = LocalTime.of(2, 0);
		final LocalTime periodBEnd = LocalTime.of(4, 30);

		final TimePeriod periodA = new TimePeriod(periodAStart, periodAEnd);
		final TimePeriod periodB = new TimePeriod(periodBStart, periodBEnd);

		final boolean overlaps;
		overlaps = periodA.overlapsWith(periodB);

		Assert.assertTrue(overlaps);
	}

	@Test
	public void firstPeriodComesAfterSecond() {

		final LocalTime periodAStart = LocalTime.of(5, 0);
		final LocalTime periodAEnd = LocalTime.of(5, 30);

		final LocalTime periodBStart = LocalTime.of(3, 0);
		final LocalTime periodBEnd = LocalTime.of(4, 0);

		final TimePeriod periodA = new TimePeriod(periodAStart, periodAEnd);
		final TimePeriod periodB = new TimePeriod(periodBStart, periodBEnd);

		final boolean overlaps;
		overlaps = periodA.overlapsWith(periodB);

		Assert.assertFalse(overlaps);
	}

	@Test
	public void secondPeriodComesAfterFirst() {

		final LocalTime periodAStart = LocalTime.of(1, 10);
		final LocalTime periodAEnd = LocalTime.of(2, 20);

		final LocalTime periodBStart = LocalTime.of(3, 0);
		final LocalTime periodBEnd = LocalTime.of(4, 0);

		final TimePeriod periodA = new TimePeriod(periodAStart, periodAEnd);
		final TimePeriod periodB = new TimePeriod(periodBStart, periodBEnd);

		final boolean overlaps;
		overlaps = periodA.overlapsWith(periodB);

		Assert.assertFalse(overlaps);
	}

	@Test
	public void secondPeriodIntermediatesFirst() {

		final LocalTime periodAStart = LocalTime.of(2, 0);
		final LocalTime periodAEnd = LocalTime.of(4, 30);

		final LocalTime periodBStart = LocalTime.of(4, 0);
		final LocalTime periodBEnd = LocalTime.of(5, 0);

		final TimePeriod periodA = new TimePeriod(periodAStart, periodAEnd);
		final TimePeriod periodB = new TimePeriod(periodBStart, periodBEnd);

		final boolean overlaps;
		overlaps = periodA.overlapsWith(periodB);

		Assert.assertTrue(overlaps);
	}

	@Test
	public void firstPeriodIntermediatesSecond() {

		final LocalTime periodAStart = LocalTime.of(1, 30);
		final LocalTime periodAEnd = LocalTime.of(3, 0);

		final LocalTime periodBStart = LocalTime.of(1, 0);
		final LocalTime periodBEnd = LocalTime.of(2, 10);

		final TimePeriod periodA = new TimePeriod(periodAStart, periodAEnd);
		final TimePeriod periodB = new TimePeriod(periodBStart, periodBEnd);

		final boolean overlaps;
		overlaps = periodA.overlapsWith(periodB);

		Assert.assertTrue(overlaps);
	}
}
