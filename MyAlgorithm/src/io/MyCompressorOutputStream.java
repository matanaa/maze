package io;
import java.io.IOException;
import java.io.OutputStream;
public class MyCompressorOutputStream extends OutputStream{
	OutputStream out;
	

	public MyCompressorOutputStream(OutputStream out) {
		super();
		this.out = out;
	}

	@Override
	public void write(int arg0) throws IOException {
		out.write(arg0);
		
	}
	public void write(byte[] b)throws IOException  {
		int i=0; 
		int count =0;
		while (i < b.length){
			count = byteCounter(i,b);
			while (count>255){
				out.write(b[i]);
				out.write(255);
				count-=255;
			}
			out.write(b[i]);
			out.write(count);
			
		}
		
	}

	private int byteCounter(int i, byte[] b) {
		int count=0;
		while (b[i]==b[i++]){
			count++;
		}
		return count;
	}
	
	
}
