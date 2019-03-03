using System;
using Monetary;
using System.Diagnostics.Contracts;

namespace MovieReservation
{
    public class Screening
    {
        private Movie movie;
        private int sequence;
        private DateTime whenScreened;

        public Money MovieFee
        {
            get
            {
                return movie.Fee;
            }
        }

        public DateTime StartTime
        {
            get
            {
                return whenScreened;
            }
        }

        public Screening(Movie movie, int sequence, DateTime whenScreened)
        {
            this.movie = movie;
            this.sequence = sequence;
            this.whenScreened = whenScreened;
        }

        public bool IsSequence(int sequence)
        {
            return this.sequence == sequence;
        }

        public Reservation reserve(Customer customer, int audienceCount)
		{
            Contract.Requires(customer != null);
            Contract.Requires(audienceCount >= 1);
            Contract.Ensures(Contract.Result<Reservation>() != null);
			return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
		}

        private Money calculateFee(int count)
        {
            return movie.calculateMovieFee(this) * count;
        }

        [ContractInvariantMethod]
        private void Invariant() {
            Contract.Invariant(movie != null);
            Contract.Invariant(sequence >= 1);
            Contract.Invariant(whenScreened > DateTime.Now);
        }
	}
}
