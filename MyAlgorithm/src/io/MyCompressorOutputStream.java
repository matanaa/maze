package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

	private OutputStream out;

	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
	}

	@Override
	public void write(int arg0) throws IOException {
		out.write(arg0);
	}

	public void write(byte[] bytes) throws IOException {
		int i = 0;
		int counter = 0;
		while (i < bytes.length) {
			counter = byteCounter(i, bytes);
			while (counter > 255) {
				out.write(bytes[i]);
				out.write(255);
				counter -= 255;
			}
			out.write(bytes[i]);
			out.write(counter);
			i += counter;
		}
	}

	private int byteCounter(int i, byte[] bytes) {
		int counter = 1;
		while ((bytes.length > i+1) && (bytes[i] == bytes[++i])) {
			counter++;
		}
		return counter;
	}

}


