package com.kuark.tool.advance.advance20191220Algorithm.ecc;

import com.kuark.tool.advance.advance20191220Algorithm.ecc.elliptic.*;
import com.kuark.tool.advance.advance20201105util.formal.MD5Util;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Random;

/**
 * ͨ����֤
 */
@Slf4j
public class EcdhAlgorithm {
    private BigInteger selfRandom;
    private ECPoint point;

    public EcdhAlgorithm(int numBits,boolean definitionEllipticCurve){
        try {
            selfRandom = generateRandom(numBits);
            point = generateECPoint(definitionEllipticCurve);
        }catch (Exception e){

        }
    }


    /**
     * ����ָ��λ���Ĵ��������
     * @param numBits ����λ��
     * @return
     */
    private BigInteger generateRandom(int numBits){
        /**
         * ������������Ĭ�����ӣ������ָ������
         */
        return new BigInteger(numBits, new Random());
    }

    /**
     * todo �����Գ���һ�£������Զ������ʵ�ַ�ʽ
     * @param definitionEllipticCurve
     * @return
     * @throws InsecureCurveException
     * @throws NotOnMotherException
     */
    private ECPoint generateECPoint(boolean definitionEllipticCurve) throws InsecureCurveException, NotOnMotherException {
        EllipticCurve e ;
        ECPoint point;
        if(definitionEllipticCurve){
            e = new EllipticCurve(new BigInteger("2"),
                    new BigInteger("4"), new BigInteger("11"));
            System.out.println("EllipticCurve: " + e + " created succesfully!");

            //ǰ�涨������ߣ����涨��ĵ����������������ϵģ�����ᱨ��������x��ֵ��֮��y��ֵ��Ҫͨ��x��ֵ����ó�
            // ���ɻ���G---�ҵ��������ϵ�һ���㣬��x\y��ֵ
            point=new ECPoint(e, new BigInteger("2"), new BigInteger("4"));
        }else {
            e = new EllipticCurve(new secp256r1());
            point = new ECPoint(e.getGenerator().compress(), e);
        }

        return point;
    }

    /**
     * �����Լ��ļ�����
     * @return
     */
    public ECPoint calculatePoint(){
        return this.point.multiply(selfRandom);
    }

    /**
     * ����Э�̽��
     * @param sidePoint
     * @return
     */
    public String calculateResult(ECPoint sidePoint) {
        ECPoint multiply = sidePoint.multiply(this.selfRandom);
        return MD5Util.stringMD5(multiply.toString());
    }
}


