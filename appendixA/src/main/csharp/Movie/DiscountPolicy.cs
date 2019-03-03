using System;
using Monetary;
using System.Collections.Generic;

namespace MovieReservation
{
    public abstract class DiscountPolicy
    {
        private DiscountCondition[] conditions;

        public PriceDiscountPolicy(params DiscountCondition[] conditions) {
            this.conditions = conditions;
        }

        public Money CalculateDiscountAmount(Screening screening)
        {
			foreach (var each in conditions)
			{
				if (each.IsSatisfiedBy(screening))
				{
					return getDiscountAmount(screening);
				}
			}

			return screening.MovieFee;
		}

		abstract protected Money getDiscountAmount(Screening screening);
	}

    public class AmountDiscountPolicy : DiscountPolicy
	{
    	private Money discountAmount;

        public AmountDiscountPolicy(Money discountAmount, params DiscountCondition[] conditions) : base(conditions)
    	{
    		this.discountAmount = discountAmount;
    	}

    	protected override Money getDiscountAmount(Screening screening)
    	{
    		return discountAmount;
    	}
    }

    public class PercentDiscountPolicy : DiscountPolicy
	{
    	private double percent;

        public PercentDiscountPolicy(double percent, params DiscountCondition[] conditions) : base(conditions)
    	{
    		this.percent = percent;
    	}

    	protected override Money getDiscountAmount(Screening screening)
    	{
    		return screening.MovieFee * percent;
    	}
    }

    public class NoneDiscountPolicy : PriceDiscountPolicy
	{
    	protected override Money getDiscountAmount(Screening screening)
    	{
    		return new Money(0);
    	}
    }
}
