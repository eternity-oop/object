using System;

namespace Variance
{
    public class Book
    {
        private Publisher publisher;

        public Book(Publisher publisher)
        {
            this.publisher = publisher;
        }
    }

    public class Magazine : Book
    {
        public Magazine(Publisher publisher) : base(publisher)
        {
        }
    }
}
