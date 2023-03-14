class BucketRange() {
  /**
   * The given code defines a class BucletRange with a single method getRange that takes a double value num
   * as input, calculates the bucket range for the given value based on the given rules
   */
  def getRange(num: Double): Unit = {
    var lastTwoDigits = ((num*1000)%100).toDouble  // Fetching the last two digits
    var leftRange = 0.0
    var rightRange = 0.0

    /**
    * If the value of the last two digits after the decimal point is greater than or equal to 50,
    * then the bucket range is from `num - (last two digits/1000) + 0.050 to num + (99 - last two digits)/1000`.
    * */
    if (lastTwoDigits >= 50) {
      leftRange = num - (lastTwoDigits / 1000) + 0.050
      rightRange = num + (99 - lastTwoDigits) / 1000
    }

    // Otherwise, the bucket range is from `num - (last two digits/1000) to num + (49 - last two digits)/1000`.
    else {
      leftRange = num - (lastTwoDigits / 1000)
      rightRange = num + (49 - lastTwoDigits) / 1000
    }

    print(f"$num -> Bucket : $leftRange%,.3f" + " - " + f"$rightRange%,.3f\n") // Printing the fetched limits
  }
}

// Creating object to run
object BucketRange {
  /**
  * The main method creates an object of the BucketRange class and calls the
  *  getRange method for an array of double values.
  * */
  def main(args: Array[String]): Unit = {
    val obj = new BucketRange() // Creation of object for above created class
    val input = Array(12.05, 12.99, 10.33, 11.45, 13.50,11.99999,5.4999999999)
    for (i <- input) {
      obj.getRange(i)      //calling the getRange function to fetch the bucket details
    }
  }
}