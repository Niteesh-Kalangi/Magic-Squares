public class MagicSquare {
	private int[][] magic;

	public int[][] getMagic() {
		return magic;
	}

	public void setMagic(int x) {
		this.magic = new int[x][x];
	}

	public MagicSquare(int x) {
		
		this.magic = new int[x][x];
	}
	private boolean magicTrue() {
	int magicNumber=0;
	int currentSum=0;
	//columns
	for(int j=0; j<this.magic[0].length; j++) {
		int i;
		for(i=0; i<this.magic.length; i++) {
			currentSum+=this.magic[i][j];
			
			
		}
		if(currentSum!=magicNumber&&j>0) 
			return false;
		magicNumber=currentSum;
		currentSum=0;
	}
	for(int i=0; i<this.magic.length; i++) {
		for(int j=0; j<this.magic[0].length; j++) {
			currentSum+=this.magic[i][j];
		}
		if(currentSum!=magicNumber) 
			return false;
		magicNumber=currentSum;
		currentSum=0;
	}
	for(int i=0; i<this.magic.length; i++) {
		currentSum += this.magic[i][i];
	}
	if(currentSum!=magicNumber) 
		return false;
	magicNumber=currentSum;
	currentSum=0;
	for(int i=0; i<this.magic.length; i++) {
		currentSum += this.magic[i][this.magic.length-i-1];
	}
	if(currentSum!=magicNumber) 
		return false;
	return true;
		}
	public boolean sameNo() {
		int count =0;
		int[] x=new int[this.magic.length*this.magic.length];
		for(int i=0; i<this.magic.length; i++) {
			for(int j=0; j<this.magic.length; j++) {
				x[count]=magic[i][j];
				count++;
			}
		}
		for(int i=0; i<x.length; i++)
			for(int j=i+1; j<x.length-1; j++) {
				if(x[i]==x[j])
					return false;
			}
		return true;
	}
	public boolean checkIfMagic() {
	if(this.magicTrue()==true&&this.sameNo()==true)
		return true;
	return false;
	}
	public boolean fillSquare(int[] arr) {
		int count=0;
		if(arr.length==(this.magic[0].length*this.magic[0].length)) {
	
		
		for(int i=0; i<this.magic.length; i++) {
			for(int j=0; j<this.magic[0].length; j++) {
				
				this.magic[i][j]=arr[count];
				count++;
			}
				
			}
		return true;
			}
				return false;

	}
	private int[] shuffle(int[][] arr){
		int[] deck= new int[magic.length*magic.length];
		for(int i=0; i<this.magic.length*magic.length; i++) 
			deck[i]=i+1;
	
		for(int i=0; i<this.magic.length*this.magic.length; i++) {
			
			int randomSpot=(int)(Math.random()*(magic.length*magic.length));
			int temp=deck[i];
			deck[i]=deck[randomSpot];
			deck[randomSpot]=temp;
			
			
					
		}
		return deck;
	}
	public void randomize() {
		
		
		fillSquare(shuffle(this.magic));
		
			
			
	}
	public String toString() {
		String toOutput="";
		for(int i=0; i<this.magic.length; i++) {
			
			for(int j=0; j<this.magic[0].length; j++) {
				toOutput+=""+this.magic[i][j]+" ";
			}
			toOutput+="\n";
		}
		return toOutput;
		
	}
	
	public int[][] rotate(){
		  for (int i = 0; i < this.getMagic()[0].length; i++) 
	            for (int j = 0, k = this.getMagic()[0].length - 1; 
	                 j < k; j++, k--) { 
	                int temp =  this.getMagic()[j][i]; 
	                this.getMagic()[j][i] =this.getMagic()[k][i]; 
	                this.getMagic()[k][i] = temp; 
	            } 
		  
		  for (int i = 0; i < this.getMagic().length; i++) 
	            for (int j = i; j < this.getMagic()[0].length; j++) { 
	                int temp = this.getMagic()[j][i]; 
	                this.getMagic()[j][i] = this.getMagic()[i][j]; 
	                this.getMagic()[i][j] = temp; 
	            } 
		  return this.getMagic();
	}
	public boolean equals(MagicSquare temp) {
		int count=0;
		MagicSquare n=new MagicSquare(temp.getMagic().length);
		for(int x=0; x<n.getMagic().length; x++) {
			for(int y=0; y<n.getMagic().length; y++) 
				n.getMagic()[x][y]=temp.getMagic()[x][y];
		}
		
		for(int x=0; x<4; x++) {
			for(int i=0; i<temp.getMagic().length; i++) {

			for(int j=0; j<this.magic[0].length; j++) {
				if(n.getMagic()[i][j]==this.magic[i][j])
					count++;
			}
			
		}
		if(count==magic.length*magic.length)
			return true;
		n.rotate();
		count=0;
		}

				
	
		return false;
	}

	

}