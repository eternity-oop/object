using System;
using Monetary;

namespace MovieReservation
{
    public class Movie
    {
		public Money Fee { get; }

		private String title;
        private TimeSpan runningTime;
		private DiscountPolicy discountPolicy;

		public Movie(string title, TimeSpan runningTime, Money fee, DiscountPolicy discountPolicy)
        {
            this.title = title;
            this.runningTime = runningTime;
            this.Fee = fee;
            this.discountPolicy = discountPolicy;
        }

        public Money calculateMovieFee(Screening screening)
        {
            return Fee - discountPolicy.CalculateDiscountAmount(screening);
        }
    }
}
