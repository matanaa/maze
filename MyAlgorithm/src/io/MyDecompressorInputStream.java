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
	
	public int read(byte[] bytes) throws IOException {
		byte zeroOrOne;
		byte counter;
		int fileSize= in.available();
		int k = 0 ;
		
		for(int i = 0 ; i < fileSize ; i += 2){
			if(bytes.length <= k){
				break;
			}
			zeroOrOne = (byte)in.read();
			counter = (byte)in.read();
			
			for(int j = 0 ; j < counter ; j++){
				if(bytes.length <= k){
					break;
				}
				bytes[k++] = zeroOrOne;
			}
		}
		return -1;
	}
}
