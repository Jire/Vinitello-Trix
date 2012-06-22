package trix.packet;

public class Packet {

	private final int id, length;
	private final byte[] data;

	public Packet(byte[] data) {
		this(-1, data.length, data);
	}

	public Packet(int id, byte[] data) {
		this(id, data.length, data);
	}

	private Packet(int id, int length, byte[] data) {
		this.id = id;
		this.length = length;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public int getLength() {
		return length;
	}

	public byte[] getData() {
		return data;
	}

	@Override
	public String toString() {
		return "(id=" + id + ", length=" + length + ")";
	}

}