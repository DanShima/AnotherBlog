//Expression matters
fun expressionsMatter(a : Int, b : Int, c : Int) = intArrayOf(a + b + c, a + b * c, a * b * c, a * b + c, (a + b) * c, a * (b + c)).max()

fun expressionsMatter(a : Int, b : Int, c : Int) : Int {
        var results = mutableListOf<Int>()
        return results.let {
             it.add(a * (b + c))
                it.add(a * b * c)
            it.add(a * b + c)
            it.add(a + b * c)
            it.add((a + b) * c)
            it.add(a + b + c)  
            it.max()
         } ?: 0
    }
//Growth of a population
fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int): Int = 
  generateSequence(pp0.toDouble()) { it * (1 + percent / 100) + aug }.takeWhile { it < p }.count()
fun nbYear(p0:Int, percent:Double, aug:Int, p:Int):Int {
    var population = p0
    var percentIncrease = percent/100
    var comingInhabitants = aug
    var expectedPopulation = p
    var year = 0
    do {
        population += (population * percentIncrease).toInt() + comingInhabitants
        year++
    } while(population < expectedPopulation)
    return year      
}
//Grasshopper - summation
fun summation(n: Int) = (1..n).sum()
fun summation(n:Int):Int {
        var sum = 0
        for(i in 1..n) {
            sum += i
        }
        return sum
    }
//Delete occurrences of an element if it occurs more than n times (without changing the order)
fun deleteNth(elements: IntArray, maxOccurrences: Int): IntArray {
        val count = hashMapOf<Int, Int>().withDefault { 0 }
        return elements.filter { i -> count.getValue(i).let { count[i] = it + 1; it < maxOccurrences } }.toIntArray()
    }
fun deleteNth(elements: IntArray, n: Int): IntArray {
        val counts = mutableMapOf<Int, Int>()
        fun countFilter(x: Int) = counts.compute(x, { _, count -> count?.plus(1) ?: 1 })!! <= n
        return elements.filter { countFilter(it) }.toIntArray()
    }
//Opposite attract: If one of the flowers has an even number of petals and the other has an odd number of petals it means they are in love.
fun loveFun(flowerA: Int, flowerB: Int): Boolean = (flowerA + flowerB) %2 == 1
fun loveFun(flowerA: Int, flowerB: Int): Boolean = if(flowerA % 2 == flowerB % 2) false else true



