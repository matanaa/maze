package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {
	
	private InputStream in;
	
	public MyDecompressorInputStream(InputStream in) {
		this.in = in;
	}

	@Override
	public int read() throws IOException {
		return (int)in.read();
	}
	
	
	public int read(byte[] arr) throws IOException {
		int k = 0;
		while (k < arr.length) {
			byte b = (byte) in.read();
			byte count = (byte) in.read();
			
			for (int j = 0; j < count; j++) {
				arr[k++] = b;
			}
		}
		return arr.length;		
	}
}

