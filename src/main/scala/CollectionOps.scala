object CollectionOps {

  def sort(list: List[Int]): List[Int] =
    list.sorted

  def sortDesc(list: List[Int]): List[Int] =
    list.sorted(Ordering.Int.reverse)
}
