package soroco;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BinaryReader {
	static int BLOCK_SIZE;
	public static File inpFile = null;
	public static File headerFile = null;
	public static StringBuilder str;

	static Map<ByteArrayWrapper, String> blockWrapMap;
	private static int filePartCount;

	private static void readByteArray(byte[] array) {
		for (int j = 0; j < array.length; j++) {
			System.out.format("%02X ", array[j]);
		}
	}

	private static void setBlockWrapMap(ByteArrayWrapper byteWrap, int offset) {
		if (blockWrapMap.containsKey(byteWrap)) {
			blockWrapMap.put(byteWrap, blockWrapMap.get(byteWrap) + "," + new Integer(offset).toString());
		} else {
			blockWrapMap.put(byteWrap, new Integer(offset).toString());
			File outFile = new File(inpFile.getPath() + "_" + filePartCount++);
			FileChannel writeChannel = null;
			FileChannel headerChannel = null;
			
			try {
				// System.out.println("new : " + outFile.getPath());
				writeChannel = FileChannel.open(outFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
				writeChannel.write(ByteBuffer.wrap(byteWrap.getData()));
				
				createHeaderString(ByteBuffer.wrap(byteWrap.getData()));
				
				headerChannel = FileChannel.open(headerFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
				headerChannel.write(ByteBuffer.wrap(byteWrap.getData()));
				//headerChannel.write(ByteBuffer.wrap("#".getBytes()));			
				
			} catch (IOException e) {
				System.out.println("Some error occurred while reading from File: " + e);
			} finally {
				if (writeChannel != null) {
					try {
						writeChannel.close();
					} catch (IOException e) {
						System.out.println("Could not close read channel: " + e);
					}
				}
			}
		}
	}

	private static void createHeaderString(ByteBuffer srcBuffer) {
		Charset charset =  Charset.forName("UTF=8");
        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer resBuffer;
		try {
			resBuffer = decoder.decode(srcBuffer);
			str.append(resBuffer);
		} catch (CharacterCodingException e) {
			System.out.println("Character encoding/decoding error!");		
		}
	}

	private static void readWrapMap() {
		System.out.println("\nReading map contents: ");
		for (Entry<ByteArrayWrapper, String> entry : blockWrapMap.entrySet()) {
			// readByteArray(entry.getKey().getData());
			System.out.println(entry.getKey() + "=============>" + entry.getValue());
		}
		System.out.println("\n=================");
	}
	
	private static void encodePartition(File inFile) {
		// final File outFile = new File("D:\\bin_files\\HexEd2_copy");
		ByteBuffer inBuffer = ByteBuffer.allocate(BLOCK_SIZE);
		// final ByteBuffer outBuffer = ByteBuffer.allocate(OUT_BUFFER_SIZE);

		FileChannel readChannel = null;

		ByteArrayWrapper byteWrap = null;

		try {
			readChannel = FileChannel.open(inFile.toPath(), StandardOpenOption.READ);
			// long totalReadByteCount = 0L;
			// read bytes into the in-buffer
			int offset = 0;

			while ((readChannel.read(inBuffer)) != -1) {
				// totalReadByteCount += readOp;
				byteWrap = new ByteArrayWrapper(inBuffer.array(), BLOCK_SIZE);
				setBlockWrapMap(byteWrap, offset);
				offset++;
				inBuffer.clear();				
			}
			// System.out.println("read total: " + totalReadByteCount + " bytes.");

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
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Missing arguments: Please provide the filename and block size as input!");
			System.exit(1);
		}

		inpFile = new File(args[0]);
		headerFile = new File(args[0]+".header");
		BLOCK_SIZE = Integer.parseInt(args[1]);
		blockWrapMap = new HashMap<ByteArrayWrapper, String>();

		System.out.println("Input file size(in bytes): " + inpFile.length());

		encodePartition(inpFile);

		System.out.println(blockWrapMap.size() * BLOCK_SIZE);
	}
}