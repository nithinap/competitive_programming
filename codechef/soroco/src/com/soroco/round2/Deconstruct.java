package com.soroco.round2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Class to de-construct a binary file into blocks of given size, and output
 * minimum disk space(in bytes) required to store the information (ignoring
 * system overhead)
 * 
 * @author Nithin AP
 */
public class Deconstruct {
	static int BLOCK_SIZE;
	public static File inpFile = null;
	public static File headerFile = null;
	public static ByteArrayOutputStream headstr;

	static Map<ByteArrayWrapper, String> blockWrapMap;
	private static int filePartCount = 0;

	static Map<String, String> map;

	/**
	 * Convenience method to view hex format bin file from the give
	 * {@code array}.
	 * 
	 * @param array byte array which is to be printed as hex format
	 */
	private static void readByteArray(byte[] array) {
		for (int j = 0; j < array.length; j++) {
			System.out.format("%02X ", array[j]);
		}
	}

	/**
	 * Convenience method to read the hashmap
	 */
	private static void readMap() {
		System.out.println("Map contents : ");
		for (Entry<String, String> entry : map.entrySet()) {
			readByteArray(entry.getKey().getBytes());
			System.out.println(" ==> " + entry.getValue());
		}
	}

	/**
	 * Method to store the non-duplicate file partitions to separate files and
	 * the header file info using the hashmap with {@code (key, value)} as
	 * {@code (non-duplicate partition, offset_of_occurence)}
	 */
	public static void storeHeaderParts(String runLengthEncoded) {
		Properties prop = new Properties();
		FileChannel writeChannel = null;
		File outFile;

		for (Entry<String, String> entry : map.entrySet()) {
			// store non-duplicate partitions to seperate files
			outFile = new File(inpFile.getPath() + "_" + filePartCount++);
			try {
				writeChannel = FileChannel.open(outFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
				writeChannel.write(ByteBuffer.wrap(entry.getKey().getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (writeChannel != null) {
					try {
						writeChannel.close();
					} catch (IOException e) {
						System.out.println("Could not close write channel: " + e);
					}
				}
			}
		}

		try {
			// store header info to header file
			prop.put("RLEVAL", runLengthEncoded);
			prop.store(new FileOutputStream(headerFile), null);
		} catch (IOException e) {
			System.out.println("IO Error: Error writing header file!");
		}
	}

	/**
	 * Method facilitating reading a binary file and the encoding, using offset
	 * of byte occurrence as values to the byteArray as string -> offset(s) map
	 * Also creates a run length encoded string and returns the value
	 * encoded string format: 
	 * 		{@code <count_of_partition_occurrence>}#{@code <partition>}##
	 * 
	 * @param inFile binary file to be encoded
	 * @return run length encoded string 
	 */
	private static String encodePartition(File inFile) {
		ByteBuffer inBuffer = ByteBuffer.allocate(BLOCK_SIZE);
		FileChannel readChannel = null;
		String partKey;
		StringBuffer rle = new StringBuffer();
		try {
			readChannel = FileChannel.open(inFile.toPath(), StandardOpenOption.READ);
			int offset = 0;
			int count = 0;
			String prevKey = "";
			while ((readChannel.read(inBuffer)) != -1) {
				byte[] b = inBuffer.array();
				partKey = new String(b);

				if (map.containsKey(partKey)) {
					// add offset to the already mapped non-duplicate partition
					map.put(partKey, map.get(partKey) + "," + new Integer(offset));

				} else {
					// New non-duplicate partition
					map.put(partKey, new Integer(offset).toString());
				}
				
				if(offset == 0) {
					prevKey = partKey;
				}
				
				if (prevKey.equals(partKey)) {
					count++;
				} else {
					rle.append(new Integer(count).toString() + "#" + prevKey + "##");
					prevKey = partKey;
					count = 1;
				}
				
				offset++;
				inBuffer.clear();
			}
			rle.append(new Integer(count).toString() + "#" + prevKey + "##");
			// System.out.println("RLE :"+rle);

		} catch (IOException e) {
			System.out.println("Some error occurred while reading from File: " + e);
		} finally {
			if (readChannel != null) {
				try {
					readChannel.close();
				} catch (IOException e) {
					System.out.println("Could not close read channel: " + e);
				}
			}
		}
		return rle.toString();
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Missing arguments: Please provide the filename and block size as input!");
			System.exit(1);
		}

		inpFile = new File(args[0]);
		headerFile = new File(args[0] + ".header");
		BLOCK_SIZE = Integer.parseInt(args[1]);
		map = new HashMap<String, String>();
		// System.out.println("Input file size(in bytes): " + inpFile.length());

		String rle = encodePartition(inpFile);
		storeHeaderParts(rle);

		System.out.println(map.size() * BLOCK_SIZE);
	}
}