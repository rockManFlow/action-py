package com.kuark.tool.advance.advance20210810;

import java.util.Random;

/**
 * @author rock
 * @detail ���գ�https://zhuanlan.zhihu.com/p/47203032
 * @date 2021/10/27 15:32
 */
public class PinBlock {
    public static void main(String[] args) {
        String pin = "1234";
        String accno = "1234567890123456";
        String s = format0(pin, accno);
        System.out.println("pin block="+s);
    }

    /**
     * Format 0 PIN block
     *
     * @param PIN ����
     * @param PAN �˺�
     * @return Format 0 PIN block ʮ�������ַ���
     */
    private static String format0(String PIN, String PAN) {
        // PIN��64bit��16λʮ����������
        // �̶�ֵ0x0 + PIN���� + PIN(����14λ�Ҳ�F)
        String PINField = "0"
                + Integer.toHexString(PIN.length())
                + String.format("%-14s", PIN).replace(' ', 'F');
        // PAN��64bit��16λʮ����������
        // �̶�ֵ0x0000 + PAN��ȥ��У�����֣����ұ���12λ������12λ��0x0
        String PANWithoutCheckDigit = PAN.substring(0, PAN.length() - 1);
        String PANField = "0000"
                + (PANWithoutCheckDigit.length() > 12 ? PANWithoutCheckDigit
                .substring(PANWithoutCheckDigit.length() - 12,
                        PANWithoutCheckDigit.length()) : String.format(
                "%12s", PANWithoutCheckDigit).replace(' ', '0'));
        // ʮ������תbyte����
        byte[] PINFieldByteArray = hexString2ByteArr(PINField);
        // ʮ������תbyte����
        byte[] PANFieldByteArray = hexString2ByteArr(PANField);
        // ���
        byte[] PINBlockByteArray = new byte[8];
        for (int i = 0; i < 8; i++) {
            PINBlockByteArray[i] = (byte) (PINFieldByteArray[i] ^ PANFieldByteArray[i]);
        }
        // ����ʮ������
        return byteArr2HexString(PINBlockByteArray).toUpperCase();
    }

    /**
     * �ֽ�����ת16����
     *
     * @param bytes ��Ҫת����byte����
     * @return ת�����Hex�ַ���
     */
    public static String byteArr2HexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * hex�ַ���תbyte����
     *
     * @param inHex ��ת����Hex�ַ���
     * @return ת�����byte������
     */
    public static byte[] hexString2ByteArr(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            //����
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            //ż��
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }

    /**
     * Hex�ַ���תbyte
     *
     * @param inHex ��ת����Hex�ַ���
     * @return ת�����byte
     */
    public static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

    /**
     * Format 1 PIN block
     *
     * @param PIN ����
     * @return Format 1 PIN block ʮ�������ַ���
     */
    private static String format1(String PIN) {
        // PIN block��64bit��16λʮ����������
        // �̶�ֵ0x1 + PIN���� + PIN������14λ�Ҳ�������
        String PINBlock = "1" + Integer.toHexString(PIN.length()) + PIN;
        // ������ʹ���������ȡֵ��Χ��0x0~0xF
        Random r = new Random();
        for (int i = 0; i < 14 - PIN.length(); i++) {
            PINBlock += Integer.toHexString(r.nextInt(16));
        }
        return PINBlock.toUpperCase();
    }

    /**
     * Format 2 PIN block
     *
     * @param PIN ����
     * @return Format 2 PIN block ʮ�������ַ���
     */
    private static String format2(String PIN) {
        // PIN block��64bit��16λʮ����������
        // �̶�ֵ0x2 + PIN���� + PIN(����14λ�Ҳ�F)
        return "2"
                + Integer.toHexString(PIN.length())
                + String.format("%-14s", PIN).replace(' ', 'F');
    }

    /**
     * Format 3 PIN block
     *
     * @param PIN ����
     * @param PAN �˺�
     * @return Format 3 PIN block ʮ�������ַ���
     */
    private static String format3(String PIN, String PAN) {
        // PIN��64bit��16λʮ����������
        // �̶�ֵ0x3 + PIN���� + PIN(����14λ�Ҳ������)
        String PINField = "3" + Integer.toHexString(PIN.length()) + PIN;
        // �����ȡֵ��Χ0xA~0xF
        Random r = new Random();
        for (int i = 0; i < 14 - PIN.length(); i++) {
            PINField += Integer.toHexString(r.nextInt(6) + 10);
        }
        // PAN��64bit��16λʮ����������
        // �̶�ֵ0x0000 + PAN��ȥ��У�����֣����ұ���12λ������12λ��0x0
        String PANWithoutCheckDigit = PAN.substring(0, PAN.length() - 1);
        String PANField = "0000"
                + (PANWithoutCheckDigit.length() > 12 ? PANWithoutCheckDigit
                .substring(PANWithoutCheckDigit.length() - 12,
                        PANWithoutCheckDigit.length()) : String.format(
                "%12s", PANWithoutCheckDigit).replace(' ', '0'));
        // ʮ������תbyte����
        byte[] PINFieldByteArray = hexString2ByteArr(PINField);
        // ʮ������תbyte����
        byte[] PANFieldByteArray = hexString2ByteArr(PANField);
        // ���
        byte[] PINBlockByteArray = new byte[8];
        for (int i = 0; i < 8; i++) {
            PINBlockByteArray[i] = (byte) (PINFieldByteArray[i] ^ PANFieldByteArray[i]);
        }
        // ����ʮ������
        return byteArr2HexString(PINBlockByteArray).toUpperCase();
    }
}

