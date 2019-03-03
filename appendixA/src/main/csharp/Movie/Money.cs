using System;

namespace Monetary
{
    public struct Money : IComparable<Money>
	{
        public long Amount
        {
            get;
        }

        public static Money wons(long amount)
        {
            return new Money(amount);
        }

        private Money(long amount)
		{
			this.Amount = amount;
		}

		public int CompareTo(Money other)
		{
			return (int)(Amount - other.Amount);
		}

		public static Money operator +(Money first, Money second)
		{
			return new Money(first.Amount + second.Amount);
		}

		public static Money operator *(Money money, double times)
		{
			return new Money((long)(money.Amount * times));
		}

		public static Money operator -(Money first, Money second)
		{
			return new Money(first.Amount - second.Amount);
		}

        public static bool operator >(Money first, Money second)
        {
            return first.CompareTo(second) > 0;
        }

		public static bool operator <(Money first, Money second)
		{
			return first.CompareTo(second) < 0;
		}
	}
}