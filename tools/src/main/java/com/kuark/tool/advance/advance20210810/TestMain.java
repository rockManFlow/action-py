package com.kuark.tool.advance.advance20210810;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rock
 * @detail safetoken
 * @date 2021/12/10 16:17
 */
public class TestMain {
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;
    public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException {
//        System.out.println(new BigDecimal("32.24").multiply(new BigDecimal(100)).toString());
//        date();

//        String cardNo="1234567890";
//        System.out.println(cardNo.substring(cardNo.length()-4));
//        String str="12345";
//        Pattern pattern = Pattern.compile("\\d{6}");
//        Matcher isNum = pattern.matcher(str);
//        System.out.println(isNum.matches());
//
//        String substring = str.substring(0, 6);
//        System.out.println("q:"+substring);
//        atomic();
        // �����JVM����ʱ�Ĳ����б�
//        Properties properties = System.getProperties();
//        String property = properties.getProperty("user.dir");
//        System.out.println(property);
//        String property2 = properties.getProperty("sun.net.client.defaultConnectTimeout");
//        System.out.println(property2);
//        String virtualClientId = "IKIA9614B82064D632E9B6418DF358A6A4AEA84D7218";
//        String virtualClientSecret = "XCTiBtLy1G9chAnyg0z3BcaFK4cVpwDg/GTw2EmjTZ8=";

        //new
//        String virtualClientId = "IKIA3A7E63FF6663AC129DE8684B99BE42DD35748FCD";
//        String virtualClientSecret = "vCXaJrT6Jq5HGxHFYNns5ORIROtGtWeW+GuKusgDtoI";

        //old
//        String virtualClientId = "IKIA3A7E63FF6663AC129DE8684B99BE42DD35748FCD";
//        String virtualClientSecret = "FhRnIytjbYMxJnGSRFKflfurM+3vHBnhAvXLh5v1Ftw=";
//        String st = virtualClientId + ":" + virtualClientSecret;
//        String base = Base64.getEncoder().encodeToString(st.getBytes());
//        System.out.println(base);
//        boolean equals = base.equals("SUtJQTk2MTRCODIwNjRENjMyRTlCNjQxOERGMzU4QTZBNEFFQTg0RDcyMTg6WENUaUJ0THkxRzljaEFueWcwejNCY2FGSzRjVnB3RGcvR1R3MkVtalRaOD0=");
//        System.out.println(equals);

//        String ss=new String(Base64.getDecoder().decode("SUtJQTk3RjRDRDk3NzFGQjE5RjEzOUNDMTk3NzQ4QzMyNjI2RjBBMEQ1QzM=".getBytes()));
//        System.out.println(ss);
//
//        System.out.println("vCXaJrT6Jq5HGxHFYNns5ORIROtGtWeW+GuKusgDtoI".equals("vCXaJrT6Jq5HGxHFYNns5ORIROtGtWeW+GuKusgDtoI"));


//        String s = "SUtJQTNBN0U2M0ZGNjY2M0FDMTI5REU4Njg0Qjk5QkU0MkREMzU3NDhGQ0Q6dkNYYUpyVDZKcTVIR3hIRllObnM1T1JJUk90R3RXZVcrR3VLdXNnRHRvST0=";
//        String s1 = new String(Base64.getDecoder().decode(s));
//        System.out.println("dd:"+s1);
//
//        bitSet();
//        atomic();
//        System.out.println(String.format("%sDDD%s",12,34));
//
//        InstanceofTwo t=new InstanceofTwo();
//        if(t instanceof InstanceofTwo){
//            System.out.println("yes");
//        }
//
//        double c = 0.8;
//        double d = 0.7;
//        double e = 0.6;
//        System.out.println(c-d);
//        System.out.println(d-e);
//        System.out.println(ChronoUnit.DAYS.between(LocalDate.of(2022,11,10),LocalDate.of(2022,10,10)));

//        System.out.println(Pattern.compile("\\s+").matcher("12 34").find());
//        System.out.println(0==0);
//        AtomicInteger count=new AtomicInteger(0);
//        add(count);
//        System.out.println("main count:"+count.get());

        Random random=new Random(100);
        int i=0;
        while (i<5){
            System.out.println(random.nextInt());
            i++;
        }


        long oldseed=100, nextseed;
        nextseed = (oldseed * multiplier + addend) & mask;
        System.out.println("nextseed="+nextseed);
        int result=(int)(nextseed >>> (48 - 32));
        System.out.println("result="+result);
        /**
         * nextseed=2521490391711
         * result=38474890
         */

        SecureRandom secureRandom=new SecureRandom();
        secureRandom.nextInt();

        SecureRandom secureRandom1=SecureRandom.getInstance("SHA1PRNG");
        secureRandom1.nextInt();
    }

    private static void add(AtomicInteger count){
        System.out.println("before:"+count.get());
        count.incrementAndGet();
        System.out.println("end:"+count.get());
    }

    private static void date(){
        String date="2022-07-18T16:00:20.000Z";//
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime localDateTime = LocalDateTime.parse(date,formatter);
        System.out.println(localDateTime);

        DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = localDateTime.format(formatter2);
        System.out.println(format);
    }

    private static void atomic() throws InterruptedException {
        // AtomicReference������֤���ö���֮���ԭ���ԣ����԰Ѷ����?����һ������?
        //����?CAS����
        BeanTwo beanTwo=new BeanTwo();
        beanTwo.setAge(10L);
        beanTwo.setName("xiaohong");

        BeanTwo beanTwo2=new BeanTwo();
        beanTwo2.setAge(20L);
        beanTwo2.setName("xiaogao");
        CountDownLatch latch=new CountDownLatch(10);

        //��ʼ��ǰֵ����,�൱�������¶��������
        AtomicReference<BeanTwo> atomicReference=new AtomicReference<BeanTwo>(beanTwo);
        for (int i = 0; i < 10; i++)
        {
            new Thread() {
                public void run() {
                    try
                    {
                        //Ϊ�� ʹ�ÿ���̨��ӡ�� ����student1���߳� ����ʾ����һ�� ÿ���߳����ͣ�� ��ִ�м����ܿ���Ч��
                        Thread.sleep(Math.abs((int)Math.random()*100));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    //Ԥ��ֵ student1�� ��ǰֵ�������atomicStudent.set(student1);�����ʱ�� ����student2�µ�ֵ
                    //cas�ı���¶��������ΪbeanTwo2�����õ�ַ
                    if (atomicReference.compareAndSet(beanTwo,beanTwo2))
                    {
                        System.out.println(Thread.currentThread().getId() + "Change value");
                        atomicReference.get().setName(atomicReference.get().getName()+"11");
                        System.out.println(atomicReference.get().getName()+":"+atomicReference.get().getAge());
                    }else {
                        System.out.println(Thread.currentThread().getId() + "Failed");
                    }
                    latch.countDown();
                };
            }.start();
        }

        latch.await();
        System.out.println(beanTwo2.getAge()+":"+beanTwo2.getName());

    }

    private static void reflect(){
        Field tag = ReflectionUtils.findField(BeanTwo.class, "tag");
        tag.setAccessible(true);
        try {
            String o = (String)tag.get(BeanTwo.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void map(){
        HashMap hashMap=new HashMap(2);
        hashMap.put("aa","11");
        hashMap.get("aa");
    }

    private static void bitSet(){
        /**
         * ��С�ɶ�̬�ı�, ȡֵΪtrue��false��λ���ϡ����ڱ�ʾһ�鲼����־��
         */
        BitSet bitSet=new BitSet();
        bitSet.set(1,true);
        boolean b = bitSet.get(2);
        System.out.println(b);

        /**
         * ʹ�ó���������Ϊ���֣��������true��false���ֽ����
         * ����������������ж��Ƿ���������Ƿ����--������ �� ���Ȳ���--����
         */

        /**
         * ������
         *
         * public void set(int pos): λ��pos����λ����Ϊtrue��
         *
         * public void set(int bitIndex, boolean value) ��ָ����������λ����Ϊָ����ֵ��
         *
         * public void clear(int pos): λ��pos����λ����Ϊfalse��
         *
         * public void clear() : ���� BitSet �е�����λ����Ϊ false��
         *
         * public int cardinality() ���ش� BitSet ������Ϊ true ��λ����
         *
         * public boolean get(int pos): ����λ����pos����λֵ��
         *
         * public void and(BitSet other): otherͬ����λ������������������Ϊ����λ������ֵ��
         *
         * public void or(BitSet other): otherͬ����λ�����л�����������Ϊ����λ������ֵ��
         *
         * public void xor(BitSet other): otherͬ����λ�������������������Ϊ����λ������ֵ��
         *
         * public void andNot(BitSet set) ����� BitSet �����е�λ,set - �������δ� BitSet �� BitSet
         *
         * public int size(): ���ش� BitSet ��ʾλֵʱʵ��ʹ�ÿռ��λ����
         *
         * public int length() ���ش� BitSet �ġ��߼���С����BitSet ���������λ�������� 1��
         *
         * public int hashCode(): ���ظü���Hash �룬 �����ͬ�����е���λֵ�йء�
         *
         * public boolean equals(Object other): ���other�е���λͬ�����е���λ��ͬ������true��
         *
         * public Object clone() ��¡�� BitSet������һ����֮��ȵ��� BitSet��
         *
         * public String toString() ���ش�λ set ���ַ�����ʾ��ʽ��
         */
    }

    public void test1() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        // ���ַ���һ
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }

        // ���ַ�����
        for (Integer value : arrayList) {
            if (value.intValue() == 5) {
                arrayList.remove(value);
            }
        }

        // ����취
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                iterator.remove();
            }
        }

        /**
         * ���ϱ���ɾ�������쳣java.util.ConcurrentModificationException
         * ԭ�������
         *  ����ArrayList���޸�modCount�ķ����Ƚ϶࣬��add��remove��clear��ensureCapacityInternal�ȣ�������Ƶ�ArrayList�����޸ĵĶ�������modCount���ԡ�
         *  ��ȴû�а�modCount��ֵ��expectedModCount�Ĳ�����
         *
         *  Iterator�е�ListItrʵ��add��remove��clear��ensureCapacityInternal�Ȼ���modCount��ֵ��expectedModCount�Ĳ�����
         *
         *  �ڴ���Iterator��ʱ��ὫmodCount��ֵ��expectedModCount���ڱ���ArrayList�����У�û�������ط���������expectedModCount�ˡ�
         *  ��ʹ��iterator.remove();��Ҳ���modCount��ֵ��expectedModCount�����´ε���checkForComodification()����У��ʱ���Ͳ��ᱨ��
         * ��ִ��next����ʱ������modCount != expectedModCount�����������׳��쳣java.util.ConcurrentModificationException��
         *
         * ����ΪʲôҪ��ô���أ�
         *      ��������ô����Ϊ����ֹ����Ա�ڲ������޸ĵ�ʱ���޸Ķ����𵽱������ã��������δ֪�쳣��
         *      Iterator �ǹ�����һ���������߳��У�����ӵ��һ�� mutex ����
         *      Iterator ������֮��Ὠ��һ��ָ��ԭ������ĵ�����������ԭ���Ķ������������仯ʱ���������������ݲ���ͬ���ı䡣
         *      ������ָ�������ƶ���ʱ����Ҳ���Ҫ�����Ķ������԰��� fail-fast ԭ�� Iterator �������׳� java.util.ConcurrentModificationException �쳣��
         *      ���� Iterator �ڹ�����ʱ���ǲ����������Ķ��󱻸ı�ġ��������ʹ�� Iterator ����ķ��� remove() ��ɾ������ Iterator.remove() ��������ɾ����ǰ���������ͬʱά��������һ���ԡ�
         */
    }

    private static void bitmapA(){
        /**
         * Byte(byte)=8bit,jvm����С���ݵ�λ��8bit
         * ǰ��booleanռ��һ��bitλ�������512M
         */

        //bitmap���±�ӳ��ֵ�������е�ֵ�������Ƿ���ڣ���true��false
        //��bit������±��ӦQQ��--�ؼ���bitmapӳ���˼��
        boolean[] bitmap=new boolean[2^32-1];
        for(boolean b:bitmap){
            //�������ļ�
            //�������λ�ø�ֵΪtrue������false
        }

        for(int i=0;i<bitmap.length;i++){
            if(bitmap[i]){
                System.out.println("��ӡȥ��֮���ֵ��"+i);
            }
        }

    }
}
