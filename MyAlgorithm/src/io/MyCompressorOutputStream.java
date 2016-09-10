package io;

import java.io.IOException;
import java.io.OutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class MyCompressorOutputStream.
 */
public class MyCompressorOutputStream extends OutputStream {

	/** The out. */
	private OutputStream out;

	/**
	 * Instantiates a new my compressor output stream.
	 *
	 * @param out the out
	 */
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(int)
	 */
	@Override
	public void write(int arg0) throws IOException {
		out.write(arg0);
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(byte[])
	 */
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

	/**
	 * Byte counter.
	 *
	 * @param i the i
	 * @param bytes the bytes
	 * @return the int
	 */
	private int byteCounter(int i, byte[] bytes) {
		int counter = 1;
		while ((bytes.length < i) && (bytes[i] == bytes[i++])) {
			counter++;
		}
		return counter;
	}

}
