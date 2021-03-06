package com.soroco.round2;

import java.util.Arrays;

/**
 * Simple wrapper class to permit {@code byte[]} as a hashtable key.  
 * 
 * <p>
 * <em>Warning: Changing the backing byte array will NOT change the hash code of this object if it has
 * already been generated.</em>
 * </p>
 * 
 * @author Nithin AP
 *
 */
public class ByteArrayWrapper implements Comparable<ByteArrayWrapper>
{
    private byte[] data;
    private int hashCode = 0;
    public static char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7',
    	      '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    
    public ByteArrayWrapper(byte[] data, int blockSize)
    {
    	this.data = new byte[blockSize];
        if (data == null)
        {
            throw new NullPointerException();
        }
        this.data = data;
    }
    
    /**
     * @return {@code byte[]} with the partition data
     */
    public byte[] getData() {
    	return this.data;
    }  

	@Override
    public boolean equals(Object other)
    {
        if (!(other instanceof ByteArrayWrapper))
        {
            return false;
        }
        return Arrays.equals(this.data, ((ByteArrayWrapper)other).data);
    }

	/**
	 * Returns the hash code for the underlying byte array, as generated by {@link Arrays#hashCode(byte[])}. Note that
	 * this method caches the generated hash code after the first call, so changes to the underlying byte array will
	 * not change the hash code of this object.
	 */
    @Override
    public int hashCode()
    {
		if(this.hashCode == 0)
		{
			return this.hashCode = Arrays.hashCode(this.data);
		}	
		return this.hashCode;
    }
    
	/**
	 * Compares this array to {@code other} using the following steps:
	 * <ol>
	 *   <li>Compare lengths: a shorter array is "less than" a longer array, regardless of values.</li>
	 *   <li>Compare values: the byte value in each array is compared, from first to last, and ordered by binary value.</li>
	 * </ol>
	 */
	@Override
	public int compareTo(ByteArrayWrapper other)
	{
		if(this.data.length != other.data.length)
			return this.data.length - other.data.length;
		
		for(int i = 0; i < this.data.length; ++i)
		{
			if(this.data[i] != other.data[i])
				return (this.data[i]&0xFF) - (other.data[i]&0xFF);
		}
		return 0;
	}
	    
    /**
     * Returns a String representing the byte[] as a sequence of uppercase
     * hexadecimal characters, starting with "0x". Omitting any leading 0-value
     * bytes.
     * 
     * @param bytes
     *          the byte array to convert.
     * @return a String representing the value of {@code bytes} as hexadecimal
     *         characters, starting with "0x". If {@code bytes} is null or has a
     *         length of 0, then the String "0x" is returned.
     */
	@Override
	public String toString()
	{
		byte[] bytes = this.data;
	    StringBuffer sb = new StringBuffer("");

	    boolean leadingZeros = true;
	    if (bytes != null) {
	      for (byte b : bytes) {
	        if (leadingZeros && b == 0)
	          continue;
	        leadingZeros = false;
	        sb.append(HEX_CHARS[0x0F & (b >> 4)]).append(HEX_CHARS[b & 0x0F]);
	      }
	    }
	    return sb.toString();
	}
}