using System;
namespace Variance
{
    public class BookStall
	{
		public virtual Book sell(IndependentPublisher publisher)
		{
			return new Book(publisher);
		}
	}

    public class MagazineStore : BookStall
	{
    	public override Magazine sell(IndependentPublisher publisher)
    	{
    		return new Magazine(publisher);
    	}
    }
}
