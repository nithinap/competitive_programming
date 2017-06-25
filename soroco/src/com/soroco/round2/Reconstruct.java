package com.soroco.round2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Class to reconstruct the binary file using the file header info.
 * 
 * @author Nithin_Ap
 */
public class Reconstruct {

	public static File headerFile = null;
	public static File outFile = null;

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
	private static void readMap(Map<String, String> map) {
		System.out.println("Map contents : ");
		for (Entry<String, String> entry : map.entrySet()) {
			readByteArray(entry.getKey().getBytes());
			System.out.println(" ==> " + entry.getValue());
		}
	}

	/**
	 * Method to retrieve header information and reconstruct the file
	 * @return status as 0 for success, 1 for failure
	 */
	private static int reconstruct() {
		int status = 1;

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(headerFile));
		} catch (FileNotFoundException e) {
			System.out.println("Failed to reconstruct! Missing header info file...");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Error while reading header info!");
		}

		String rle = properties.getProperty("RLEVAL");
		decodeAndWrite(rle);
		System.out.println(rle);
		status = 0; // success
		return status;
	}

	/**
	 * Method to decode the run length encoded string {@code rle} and write to the output 
	 * file mentioned as command line input
	 * @param rle run length encoded string
	 */
	private static void decodeAndWrite(String rle) {
		FileChannel writeChannel = null;
		try {
			writeChannel = FileChannel.open(outFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			for (String pair : rle.split("##")) {
				int count = Integer.parseInt(pair.split("#")[0]);
				String partition = pair.split("#")[1];
				for (; count > 0; count--) {
					writeChannel.write(ByteBuffer.wrap(partition.getBytes()));
				}
			}
		} catch (IOException e) {
			System.out.println("Error writing to channel." + e);
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

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Missing arguments! ");
			System.exit(1);
		}

		headerFile = new File(args[0]);
		outFile = new File(args[1]);

		int status = reconstruct();
		if(status == 0)
			System.out.println("Successfully reconstructed and saved to path :"+outFile.getPath());
		else
			System.out.println("Error reconstructing file!");
	}
}
