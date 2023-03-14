# Scala_mid_assignment

### Question - 1

We need to Bucktize the given values, i.e we need to check in which bucket the value given falls in. Here the buckets are of capacity 0.05. The bucket intervals are as in the manner of (x,x+0.049).

```
0.000 - 0.049
0.050 - 0.099
0.100 - 0.149
0.150 - 0.199
0.200 - 0.249
0.250 - 0.299
0.300 - 0.349
0.350 - 0.399 
...
...
100.000 - 100.049
```

The given code defines a class BucketRange with a single function getRange that takes a double value num as input, calculates the bucket range for the given value.

If the value of the last two digits after the decimal point is greater than or equal to 50, then the bucket range is from `num - (last two digits/1000) + 0.050 to num + (99 - last two digits)/1000`.
Otherwise, the bucket range is from `num - (last two digits/1000) to num + (49 - last two digits)/1000`.
```
    var lastTwoDigits = ((num*1000)%100).toDouble  // Fetching the last two digits
    var leftRange = 0.0
    var rightRange = 0.0

    if (lastTwoDigits >= 50) {
      leftRange = num - (lastTwoDigits / 1000) + 0.050
      rightRange = num + (99 - lastTwoDigits) / 1000
    }

    else {
      leftRange = num - (lastTwoDigits / 1000)
      rightRange = num + (49 - lastTwoDigits) / 1000
    }

    print(f"$num -> Bucket : $leftRange%,.3f" + " - " + f"$rightRange%,.3f\n")
 ```
 ###Test Run
   
   <img width="322" alt="Screenshot 2023-03-14 at 12 21 13 PM" src="https://user-images.githubusercontent.com/123619674/224919090-623f2a44-7dae-408b-91eb-be53fe3feb7d.png">
 
 ### Question - 2
 For given players statistics..
    Find the below -
1. Player with the best highest run scored.
2. Top 5 players by run scored.
3. Top 5 players by wicket taken.
4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.

The below is the case class definition for a player object. It has six attributes:

- Year: an integer representing the year in which the player played.
- Name: a string representing the name of the player.
- Country: a string representing the country that the player represents.
- Matches: an integer representing the number of matches that the player played.
- Runs: an integer representing the number of runs that the player scored.
- Wickets: an integer representing the number of wickets that the player took.

```
case class Player(Year: Int, Name: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)
```

The <b>printPlayerInfo</b> takes a list of Player objects and prints out their information such as name, country, year, runs, matches, and wickets.
The <b>printPlayerInfoWithRanks</b> takes a list of Player objects and prints out their information such as name, country, year, runs, matches, wickets, and Performance.

```
    var rank = 1
    for (player <- players) {
      // Printing the data in the object
      println("Rank: " + rank +", Name: " + player.Name + ", Country: " + player.Country + ", Year: " + player.Year +  ", Matches: " + player.Matches + ", Runs: " + player.Runs + ", Wickets: " + player.Wickets + ", Performance :" + (5 * player.Wickets + 0.05 * player.Runs))
      rank += 1
    }
 ```
 
 ###Question 2.1
 Created a function playerWithMaxRuns, it takes List[Player] as input and  List[Player] as output.In order to get the player with the most runs, used the maxBy method with the Runs attribute.
 ```
   def playerWithMaxRuns(players : List[Player]): List[Player] = {
    return List(players.maxBy(_.Runs))
  }
  
 obj.printPlayerInfo(playerWithMaxRuns(players))
 ```
 ###Question 2.2
 
created a function top5PlayersByRuns, it takes List[Player] as input and  List[Player] as output.To get the top five players with the most runs, used the sortBy method with the Runs attribute and sorted by negative (Runs) to get in desc order of runs
```
  def top5PlayersByRuns(players: List[Player]): List[Player] = {
    return players.sortBy(-_.Runs).take(5)
  }
  
  obj.printPlayerInfo(top5PlayersByRuns(players))
 ```
 
 ###Question 2.3
 
created a function top5PlayersByWickets, it takes List[Player] as input and  List[Player] as output.To get the top five players with the most wickets, used the sortBy method with the wickets attribute and sorted by negative (Wickets) to get in desc order of wickets
 ```
   def top5PlayersByWickets(players: List[Player]): List[Player] = {
    return players.sortBy(-_.Wickets).take(5)
  }
  
    obj.printPlayerInfo(top5PlayersByWickets(players))
 ```
 
 ###Question 2.4
 created a function top5PlayersByCriteria, it takes List[Player] as input and  List[Player] as output.To get the top five players with the given criteria (5*wickets + 0.05*runs), used the sortBy method with the given metric and sorted by negative (given metric) to get in desc order of given metric
 ```
   def top5PlayersByCriteria(players: List[Player]): List[Player] ={
    return players.sortBy(player => -1 * (0.05 * player.Runs + 5 * player.Wickets)).take(5)
  }
  
   obj.printPlayerInfoWithRanks(top5PlayersByCriteria(players))
  ```
  
  ###Input
  ```
      Player(2021, "Sam", "India", 23, 2300, 3),
      Player(2021, "Ram", "India", 23, 300, 30),
      Player(2021, "Mano", "India", 23, 300, 13),
      Player(2022, "Rohith", "Aus", 22, 305, 1),
      Player(2022, "Punith", "Eng", 22, 908, 23)
   ```
   
   ###Test Run
   <img width="959" alt="Screenshot 2023-03-14 at 12 50 04 PM" src="https://user-images.githubusercontent.com/123619674/224924819-2815b953-e490-4e84-9e84-117279511b9f.png">


   
    
 
      

 
 
 

    
 

    
    
