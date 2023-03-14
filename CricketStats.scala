case class Player(Year: Int, Name: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)

class CricketStats {
  // This method takes a list of Player objects and prints out their information such as name, country, year, runs, matches, and wickets.
  private def printPlayerInfo(players: List[Player]): Unit = {  //Printing player info
    for (player <- players) {
      println( "Name: " + player.Name + ", Country: " + player.Country + ", Year: " + player.Year + ", Runs: " + player.Runs + ", Matches: " + player.Matches + ", Wickets: " + player.Wickets)
    }
  }


  // This method takes a list of Player objects and prints out their information such as name, country, year, runs, matches, wickets, and Performance.
  private def printPlayerInfoWithRanks(players: List[Player]): Unit = {
    var rank = 1
    for (player <- players) {
      // Printing the data in the object
      println("Rank: " + rank +", Name: " + player.Name + ", Country: " + player.Country + ", Year: " + player.Year + ", Runs: " + player.Runs + ", Matches: " + player.Matches + ", Wickets: " + player.Wickets + ", Performance :" + (5 * player.Wickets + 0.05 * player.Runs))
      rank += 1
    }
  }



}

// Creating object to run
object CricketStats {
  /*
  * The main method creates an object of the CricketStats class and calls the
  *  desired methods for the desired activities.
  * */
  // function to get player with max runs
  def playerWithMaxRuns(players : List[Player]): List[Player] = {
    return List(players.maxBy(-_.Runs))
  }

  //function to get top 5 players by runs
  def top5PlayersByRuns(players: List[Player]): List[Player] = {
    return players.sortBy(-_.Runs).take(5)
  }

  //function to get top 5 players by wickets
  def top5PlayersByWickets(players: List[Player]): List[Player] = {
    return players.sortBy(-_.Wickets).take(5)
  }

  //function to get top 5 players by given criteria (5*wickets + 0.05*runs)
  def top5PlayersByCriteria(players: List[Player]): List[Player] ={
    return players.sortBy(player => -1 * (0.05 * player.Runs + 5 * player.Wickets)).take(5)
  }

  def main(args: Array[String]): Unit = {
    val obj = new CricketStats() // Creation of Object
    val players = List(
      Player(2021, "Sam", "India", 23, 2300, 3),
      Player(2021, "Ram", "India", 23, 300, 30),
      Player(2021, "Mano", "India", 23, 300, 13),
      Player(2022, "Rohith", "Aus", 22, 305, 1),
      Player(2022, "Punith", "Eng", 22, 908, 23)
    )

    println("Player with max runs")
    obj.printPlayerInfo(playerWithMaxRuns(players))
    println()

    println("Top 5 players by runs")
    obj.printPlayerInfo(top5PlayersByRuns(players))
    println()

    println("Top 5 players by wickets")
    obj.printPlayerInfo(top5PlayersByWickets(players))
    println()

    println("Top 5 players by given criteria (5*wickets + 0.05*runs)")
    obj.printPlayerInfoWithRanks(top5PlayersByCriteria(players))
  }
}
