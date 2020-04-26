package com.bsr.simulator.utils;


public class DataTypeChangeHelper {
	/**
	 * ��һ�����ֽڵ�byteת����32λ��int
	 * 
	 * @param b
	 *            byte
	 * @return convert result
	 */
	public static int unsignedByteToInt(byte b) {
		return (int) b & 0xFF;
	}

	/**
	 * ��һ�����ֽڵ�Byteת����ʮ�����Ƶ���
	 * 
	 * @param b
	 *            byte
	 * @return convert result
	 */
	public static String byteToHex(byte b) {
		int i = b & 0xFF;
		return Integer.toHexString(i);
	}

	/**
	 * ��һ��4byte������ת����32λ��int
	 * 
	 * @param buf
	 *            bytes buffer
	 * @param byte[]�п�ʼת����λ��
	 * @return convert result
	 */
	public static long unsigned4BytesToInt(byte[] buf, int pos) {
		int firstByte = 0;
		int secondByte = 0;
		int thirdByte = 0;
		int fourthByte = 0;
		int index = pos;
		firstByte = (0x000000FF & ((int) buf[index]));
		secondByte = (0x000000FF & ((int) buf[index + 1]));
		thirdByte = (0x000000FF & ((int) buf[index + 2]));
		fourthByte = (0x000000FF & ((int) buf[index + 3]));
		index = index + 4;
		return ((long) (firstByte << 24 | secondByte << 16 | thirdByte << 8 | fourthByte)) & 0xFFFFFFFFL;
	}

	/**
	 * ��16λ��shortת����byte����
	 * 
	 * @param s
	 *            short
	 * @return byte[] ����Ϊ2
	 * */
	public static byte[] shortToByteArray(short s) {
		byte[] targets = new byte[2];
		for (int i = 0; i < 2; i++) {
			int offset = (targets.length - 1 - i) * 8;
			targets[i] = (byte) ((s >>> offset) & 0xff);
		}
		return targets;
	}

	/**
	 * ��32λ����ת���ɳ���Ϊ4��byte����
	 * 
	 * @param s
	 *            int
	 * @return byte[]
	 * */
	public static byte[] intToByteArray(int s) {
		byte[] targets = new byte[2];
		for (int i = 0; i < 4; i++) {
			int offset = (targets.length - 1 - i) * 8;
			targets[i] = (byte) ((s >>> offset) & 0xff);
		}
		return targets;
	}

	/**
	 * long to byte[]
	 * 
	 * @param s
	 *            long
	 * @return byte[]
	 * */
	public static byte[] longToByteArray(long s) {
		byte[] targets = new byte[2];
		for (int i = 0; i < 8; i++) {
			int offset = (targets.length - 1 - i) * 8;
			targets[i] = (byte) ((s >>> offset) & 0xff);
		}
		return targets;
	}

	/**32λintתbyte[]*/
	public static byte[] int2byte(int res) {
		byte[] targets = new byte[4];
		targets[0] = (byte) (res & 0xff);// ���λ
		targets[1] = (byte) ((res >> 8) & 0xff);// �ε�λ
		targets[2] = (byte) ((res >> 16) & 0xff);// �θ�λ
		targets[3] = (byte) (res >>> 24);// ���λ,�޷������ơ�
		return targets;
	}

	/**
	 * ������Ϊ2��byte����ת��Ϊ16λint
	 * 
	 * @param res
	 *            byte[]
	 * @return int
	 * */
	public static int byte2int(byte[] res) {
		// res = InversionByte(res);
		// һ��byte��������24λ���0x??000000��������8λ���0x00??0000
		int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00); // | ��ʾ��λ��
		return targets;
	}
}