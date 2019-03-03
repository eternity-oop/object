package org.eternity.function.variance

class Orderer {
  var book: Book = null

  def order(store: IndependentPublisher => Book): Unit = {
    book = store(new IndependentPublisher())
  }
}

object Main extends App {
  new Orderer().order((publisher:IndependentPublisher) => new Book(publisher))
  new Orderer().order((publisher:Publisher) => new Magazine(publisher))
}