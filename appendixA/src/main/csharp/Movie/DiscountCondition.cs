using System;

namespace MovieReservation
{
    public interface DiscountCondition
    {
        bool IsSatisfiedBy(Screening screening);
    }

    public class SequenceCondition : DiscountCondition
	{
    	private int sequence;

    	public SequenceCondition(int sequence)
    	{
    		this.sequence = sequence;
    	}

    	public bool IsSatisfiedBy(Screening screening)
    	{
    		return screening.IsSequence(sequence);
    	}
    }

    public class PeriodCondition : DiscountCondition
    {
    	private DayOfWeek dayOfWeek;
    	private TimeSpan startTime;
    	private TimeSpan endTime;

        public PeriodCondition(DayOfWeek dayOfWeek, TimeSpan startTime, TimeSpan endTime)
    	{
    		this.dayOfWeek = dayOfWeek;
    		this.startTime = startTime;
    		this.endTime = endTime;
    	}

    	public bool IsSatisfiedBy(Screening screening)
    	{
    		return screening.StartTime.DayOfWeek.Equals(dayOfWeek) &&
                startTime <= screening.StartTime.TimeOfDay &&
		        endTime >= screening.StartTime.TimeOfDay;
    	}
    }
}
