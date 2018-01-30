class AddNumbers 
{
    /*static int Add(int x, int y) //iterative
    {
        // Iterate till there is no carry
        while (y != 0) 
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;
 
            // Sum of bits of x and 
            // y where at least one 
            // of the bits is not set
            x = x ^ y;
 
            // Carry is shifted by 
            // one so that adding it 
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }*/
	static int add(int x, int y)	//recursive
	{
	    if (y == 0)
	        return x;
	    else
	        return add( x ^ y, (x & y) << 1);
	}
     
    // Driver code
    public static void main(String args[]) 
    {
        System.out.println(add(22, 11));
    }
}