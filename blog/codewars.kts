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
//Delete occurrences of an element if it occurs more than n times
