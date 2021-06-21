public class Airplane {
  //instance fields
	private boolean[][] firstCls;
	private boolean[][] economyCls;
  //instaed of creating a string or int array, creating a boolean array makes it easier bc you can simply put true for the taken seats and false for others

  //constructor
	public Airplane() {
		firstCls = new boolean[5][4];
		economyCls = new boolean[15][6];
	}

	public String seats(String cls, String pos, int num){
		if (cls.equalsIgnoreCase("f")){
      //first class
			for (int row = 0; row < firstCls.length; row++){
				if (num == 2){
          //since there are only two columns in the first class, we don't ask for aisle/window seats. 
					if (!firstCls[row][0] && !firstCls[row][1]){
						firstCls[row][0] = true;
            //we mark the seats as "true" so that other passengers can't take the seat.
						firstCls[row][1] = true;
						return ("row " + (row + 1) + " left side");
					}
					if (!firstCls[row][2] && !firstCls[row][3]){
						firstCls[row][2] = true;
						firstCls[row][3] = true;
						return "row " + (row + 1) + " right side";
					}
				} 
        else {
          //since there is only one person making reservation, we have to ask them which seat they prefer.
					if (pos.equalsIgnoreCase("a")){
						if(!firstCls[row][1]){
							firstCls[row][1] = true;
							return "row " + (row + 1) + " left side";
						}
						if(!firstCls[row][2]){
							firstCls[row][2] = true;
							return "row " + (row + 1) + " right side";
						}
					}
          else {
						if(!firstCls[row][0]){
							firstCls[row][0] = true;
							return "row " + (row + 1) + " left side";
						}
						if(!firstCls[row][3]){
							firstCls[row][3] = true;
							return "row " + (row + 1) + " right side";
						}
					}
				}
			}
		} 
    else {
			for (int row = 0; row < economyCls.length; row++){
				if (num == 3){
          //economy has 3 columns so don't ask aisle/middle/window
					if (!economyCls[row][0] && !economyCls[row][1] && !economyCls[row][2]){
						economyCls[row][0] = true;
						economyCls[row][1] = true;
						economyCls[row][2] = true;
						return "row " + (row + 6) + " left side";
					}
					if (!economyCls[row][3] && !economyCls[row][4] && !economyCls[row][5]){
						economyCls[row][3] = true;
						economyCls[row][4] = true;
						economyCls[row][5] = true;
						return "row " + (row + 6) + " right side";
					}
				}
        else if (num == 2){
          //ask if there are two people only for aisle/window
					if (pos.equalsIgnoreCase("a")){
						if (!economyCls[row][1] && !economyCls[row][2]){
							economyCls[row][1] = true;
							economyCls[row][2] = true;
							return "row " + (row + 6) + " left side";
						}
						if (!economyCls[row][3] && !economyCls[row][4]){
							economyCls[row][3] = true;
							economyCls[row][4] = true;
							return "row " + (row + 6) + " right side";
						}
					}
          else {
						if (!economyCls[row][0] && !economyCls[row][1]){
							economyCls[row][0] = true;
							economyCls[row][1] = true;
							return "row " + (row + 6) + " left side";
						}
						if (!economyCls[row][4] && !economyCls[row][5]){
							economyCls[row][4] = true;
							economyCls[row][5] = true;
							return "row " + (row + 6) + " right side";
						}
					}
				}
        else {
          //when there is 1 person
					if (pos.equalsIgnoreCase("a")){
						if(!economyCls[row][2]){
							economyCls[row][2] = true;
							return "row " + (row + 6) + " left side";
						}
						if(!economyCls[row][3]){
							economyCls[row][3] = true;
							return "row " + (row + 6) + " right side";
						}
					}
          else if (pos.equalsIgnoreCase("m")){
						if(!economyCls[row][1]){
							economyCls[row][1] = true;
							return "row " + (row + 6) + " left side";
						}
						if(!economyCls[row][4]){
							economyCls[row][4] = true;
							return "row " + (row + 6) + " right side";
						}
					}
          else {
            //window seats
						if(!economyCls[row][0]){
							economyCls[row][0] = true;
							return "row " + (row + 6) + " left side";
						}
						if(!economyCls[row][5]){
							economyCls[row][5] = true;
							return "row " + (row + 6) + " right side";
						}
					}
				}
			}			
		}
		return null;
    //it has to return something at the end so if none applies, just return null.
	}

  //print the seats 
	public String printPlane(){
    //this is the method for S)how option. 
		String print = "";
		int rowNum = 1;
    //start from row number 1
		for (boolean[] row : firstCls){
			print += "\n" + rowNum++ + ":    ";
      //print out the row number/
      //****make sure to ++ it!!
			for (int i = 0; i < row.length; i++){
				if (i == row.length/2){
          print += "  ";
        }
				if (row[i] == true){
          print += "* ";
        }
				else{
          print += ". ";
        }
			}
		}
		for (boolean[] row : economyCls){
			print += "\n" + rowNum++ + ": ";
      //this one has less spaces than the first class one bc it has 3 columns
			if (rowNum < 11){
        print += " ";
      }
			for (int i = 0; i < row.length; i++){
				if (i == row.length/2){
          print += "  ";
        }
        //if taken. row[i] has to be true bc the array is boolean
				if (row[i] == true){
          print += "* ";
        }
				else{
          print += ". ";
        }
			}
		}
		return print;
	}


}
