 ## SCALA _ASSIGNMENT
### Peer Learning Document
### Problem Statements
#### Question 1
Bucketise the given array[Double] into buckets having range interval (x, x+0.049).

 0.000 - 0.049
0.050 - 0.099
0.100 - 0.149
0.150 - 0.199
...
...
100.000 - 100.049

Sample -12.05, 12.03, 10.33, 11.45, 13.50

Output- [12.050-12.099, 12.050-12.099, 10.300-10.349, 11.450-11.499, 13.500-13.549]


### Question 2. 
For given players statistics..
Find the below -
1.  Player with the best highest run scored. 
2.  Top 5 players by run scored. 
3.  Top 5 players by wicket taken. 
4.  Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.
    
Sample -Year, PlayerName, Country, Matches, Runs, Wickets 2021, Sam, India, 23, 2300, 3
2021, Ram, India, 23, 300, 30
2021, Mano, India, 23, 300, 13

### Aayush Sinha Approach
#### Question-1:
- Read the input. using the readDouble method of the scala.io.StdIn object and stored it in the num variable.Next, rounds off the number using the roundOff function and stores it in the roundNum variable.    
- Then, calculated the index of the bucket that the number belongs to by dividing the roundNum by 0.05 and taking the integer part using the toInt method.  Then calculated the lower bound of the range by multiplying the index by 0.05 and rounding it off to 3 decimal points and adding 0.049 to lower bound to get upper bound
- Finally, printed the lower and upper bounds of the range in the format "lowerBound - upperBound".
- Exception handling : If the input is not a valid Double, the program catches the NumberFormatException and prints "Invalid Input"
#### Question-2:
- The scala code stores information about cricket players using a case class called Player and then performs sorting based on the runs scored, wickets taken, and a weighted score (combining runs and wickets).
- A list of Player objects, which include player details like the year, name, nation, matches, runs, and wickets, are returned by the getPlayers() function.  The data is hardcoded as a list of players.
- The sortByRun(players:List[Player]) function takes a list of players and sorts them in descending order by the runs scored.Similarly, the sortByWicket(players:List[Player]) function sorts players by wickets taken and sortByWeightage(players:List[Player]) function sorts players by weightage(5 x Wickets + 0.05 x Runs)
- In the main() function, the program first gets the list of players using getPlayers(), then sorts the players by run, wicket, and weightage using the respective functions. The program then prints out the highest scored player, top 5 players by runs, top 5 players by wickets, and top 5 players by weightage.

### Chakradhar Srinivas Approach
#### Question-1
- Defined a class Question_1 with a single method get_bucket that takes a Double value n as input, calculates the bucket range for the given value based on the given rules, and prints the fetched limits. The main method creates an object of the Question_1 class and calls the get_bucket method for an array of Double values.
-  The get_bucket method fetches the last two digits of the input value num using the formula ((n * 1000) % 100)
- If the value of the last two digits after the decimal point is greater than or equal to 50, the bucket range is calculated using the formula n - (last two digits/1000) + 0.050 to n + (99 - last two digits)/1000. Otherwise, the bucket range is calculated using the formula n - (last two digits/1000) to n + (49 - last two digits)/1000 and prints the bucket range
```
  def get_bucket(n: Double): Unit = {
    var last_two_digits = (n * 1000) % 100
    print(f"Value :  $n") 
    if (last_two_digits >= 50) {
      val left = n - (last_two_digits / 1000) + 0.050 // Calculating and Storing the left limit
      val right = n + (99 - last_two_digits) / 1000 // Calculating and Storing the right limit
      print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n") // Printing the fetched limits
    }
    else {
      val left = n - (last_two_digits / 1000) // Calculating and Storing the left limit
      val right = n + (49 - last_two_digits) / 1000 // Calculating and Storing the right limit
      print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n") // Printing the fetched limits
    }
  }
}
```
#### Question-2
-The scala code stores information about cricket players using a case class called Player.
```case class Player(Year: Int, Name: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)```
-defined a read_data_from_file function which uses the Source library to read data from the file, runs.txt. It then maps the lines of the file to player objects by splitting each line and creating a new Player object from the extracted values. The function returns a list of Player objects.
```  private def read_data_from_file(): List[Player] = {
    val players = Source.fromFile("//Users//chakradhar//Desktop//runs.txt")
      .getLines()
      .map(line => {
        val Array(year, name, country, matches, runs, wickets) = line.trim.split(", ")
        Player(year.toInt, name, country, matches.toInt, runs.toInt, wickets.toInt)
      }).toList
    return players
  }
```
-defined <b>print_player_info function</b> which takes a list of Player objects and prints out information such as the name, country, year, runs, matches, and wickets for each player.similarly defined <b>print_player_info_with_ranks</b>.it also calculates and prints out a performance metric provided in question.
```
  private def print_player_info_with_ranks(playerobjects: List[Player]): Unit = {
    var cnt = 1 
    for (playerobject <- playerobjects) {
      println("Name : " + playerobject.Name + "\nRank : " + cnt + "\nCounty : " + playerobject.Country + "\nYear : " + playerobject.Year + "\nRuns : " + playerobject.Runs + "\nMatches : " + playerobject.Matches + "\nWickets : " + playerobject.Wickets + "\nPerformance : " + 5 * playerobject.Wickets + (0.05 * playerobject.Runs))
      cnt = cnt + 1 
      println()
    }
  }
```
-To find the player with the highest number of runs, used the sortBy method with the Runs attribute and a ordered in descending order and took the top element
-To find the top 5 players by runs,used the sortBy method with the Runs attribute and a ordered in descending order and took the top 5 elements
```
obj.print_player_info(players.sortBy(_.Runs)(Ordering[Int].reverse).take(5))
```
-To find the top 5 players by wickets,used the sortBy method with the Wickets attribute and a ordered in descending order and took the top 5 elements
```
obj.print_player_info(players.sortBy(_.Wickets)(Ordering[Int].reverse).take(5))
```
-To find the top 5 players by performance based on given metric,used the sortBy method with a custom function that computes performance based on the metric (5*Wickets+0.05*runs) and ordered it in descending order and took the top 5 players
```
obj.print_player_info_with_ranks(players.sortBy(r => 5 * r.Wickets + 0.05 * r.Runs)(Ordering[Double].reverse).take(5))
```
