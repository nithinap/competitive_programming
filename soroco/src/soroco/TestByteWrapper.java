package soroco;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.soroco.round2.ByteArrayWrapper;

public class TestByteWrapper {
	private static void readByteArray(byte[] array) {
		for (int j=0; j<array.length; j++) {
			   System.out.format("%02X ", array[j]);
		}
	}
	
	private static void readWrapMap(Map<ByteArrayWrapper, String> map) {
		System.out.println("\nReading map contents: ");
		for(Entry<ByteArrayWrapper, String> entry : map.entrySet()) {
			byte[] content = entry.getKey().getData();
			readByteArray(content);
			System.out.println("=============>"+entry.getValue());
		}
		System.out.println("\n=================");
	}
	
	public static void main(String[] args) {
		Map<ByteArrayWrapper, String> map = new HashMap<ByteArrayWrapper, String>();
		byte[] data1 = new byte[]{1,2,15};
		ByteArrayWrapper bw = new ByteArrayWrapper(data1);
		
		map.put(bw, "1");
		byte[] data2 = new byte[]{1,2,15};
		ByteArrayWrapper bw2 = new ByteArrayWrapper(data2);
		
		if(map.containsKey(bw)) {
			System.out.println("1 -> YES");
		}
		if(map.containsKey(bw2)) {
			System.out.println("2 -> YES");
			map.put(bw2, map.get(bw2)+",2");
			System.out.println(map.get(bw));
		}
		
		byte[] data3 = new byte[]{1,2,10};
		ByteArrayWrapper bw3 = new ByteArrayWrapper(data3);
		
		map.put(bw3, "3");
		
		readWrapMap(map);
	}
}
