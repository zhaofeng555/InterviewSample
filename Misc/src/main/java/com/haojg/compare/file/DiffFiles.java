package com.haojg.compare.file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DiffFiles {

    public static void main(String[] args) {
//        String recoverPath1="D:\\opt\\ccs\\accounting_data\\recover\\2020-03-11";
//        String recoverPath2="D:\\opt2\\ccs\\accounting_data\\recover\\2020-03-11";

//        String recoverPath1="D:\\opt\\ccs\\accounting_data\\riskGrade\\2020-03-11";
//        String recoverPath2="D:\\opt2\\ccs\\accounting_data\\riskGrade\\2020-03-11";

//        String recoverPath1 = "D:\\opt\\ccs\\accounting_data\\batch\\2020-03-11";
//        String recoverPath2 = "D:\\opt2\\ccs\\accounting_data\\batch\\2020-03-11";

//        String recoverPath1 = "D:\\opt\\ccs\\accounting_data\\accg\\entry\\2020-03-12";
//        String recoverPath2 = "D:\\opt2\\ccs\\accounting_data\\accg\\entry\\2020-03-12";

//        listFiles(recoverPath1, recoverPath2);

//        String p1="D:\\opt\\ccs\\accounting_data\\accg\\entry\\2020-03-14";
//        String p2="D:\\opt2\\ccs\\accounting_data\\accg\\entry\\2020-03-14-2";
//        listFiles(p1, p2);



//        diffJson();

//        diffLedger();


        comFile();

        System.out.println("end");
    }

    private static void comFile(){
        File masterFile = new File("D:\\opt\\ccs\\accounting_data\\recover\\2020-03-18\\ACCG_LOAD_RECOVER_0_0");
        File youhuaFile = new File("D:\\opt2\\ccs\\accounting_data\\recover\\2020-03-18\\ACCG_LOAD_RECOVER_0_0");
        Boolean isDiff = diff(masterFile, youhuaFile);
        System.out.println(isDiff);
    }

    private static void diffLedger(){
        for(int i=1;i<=4;i++){
            String recoverPath1 = "D:\\opt2\\ccs\\accounting_data\\ledger\\ccs00pg00"+i;
            String recoverPath2 = "D:\\opt2\\ccs\\accounting_data\\ledger\\ccs00pg00"+i;
            listFiles(recoverPath1, recoverPath2);
        }

        for(int i=5; i<=17;i++){
            String genPath1="D:\\opt\\ccs\\accounting_data\\generalledger\\ccs00pg0"+(i>9?i:"0"+i);
            String genPath2="D:\\opt2\\ccs\\accounting_data\\generalledger\\ccs00pg0"+(i>9?i:"0"+i);
            listFiles(genPath1, genPath2);
        }

    }

    public static void listFiles(String dir1, String dir2) {
        File[] files1 = new File(dir1).listFiles();
        File[] files2 = new File(dir2).listFiles();

        for (int i = 0; i < files1.length; i++) {
            if (!diff(files1[i], files2[i])) {
//                return;
            }
        }

    }

    public static boolean diff(File f1, File f2) {

        if (f1.length() != f2.length()) {

            System.out.println("different file");
            System.out.println(f1.getName());
            System.out.println(f2.getName());
//            return false;
        } else {

        }

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(f1));
                BufferedReader br2 = new BufferedReader(new FileReader(f2));
        ) {
            String con1 = "";
            String con2 = "";

            String attrs[]={"reqId", "transactionId","subTransactionId", "securityStatus"};

            con1 = br1.readLine();
            con2 = br2.readLine();
            int i = 0;
            while (con1 != null || con2 != null) {
                ++i;

                con1 = convertJsonStr(con1, attrs);
                con2 = convertJsonStr(con2, attrs);

                if (!con1.equals(con2)) {
//                if (!con1.equals(con2)) {
//                    System.out.println(i);
                    System.out.println(f1.getName() + "  !=  " + f2.getName());
                    System.out.println("优化的：" + con1);
                    System.out.println("master:" + con2);
//                    return false;
                }
                con1 = br1.readLine();
                con2 = br2.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(f1.getName() + "  ==  " + f2.getName());
        return true;
    }

    public static String convertJsonStr(String json, String... exludeAttr) {
        String con = null;
        try {
            JSONObject obj = JSONObject.parseObject(json);

            for(String attr : exludeAttr){
                obj.remove(attr);
            }



            JSONArray arr = obj.getJSONArray("bacAccgReqEntityList");
            for(int i=0;i <arr.size(); i++){
                JSONObject innerObj = arr.getJSONObject(i);

                for(String attr : exludeAttr){
                    innerObj.remove(attr);
                }
            }

            con=obj.toJSONString();
        } catch (Exception e) {
            try {
                JSONArray arr = JSONArray.parseArray(json);
                for(int i=0;i <arr.size(); i++){
                    JSONObject obj = arr.getJSONObject(i);

                    for(String attr : exludeAttr){
                        obj.remove(attr);
                    }
                }
                con= arr.toJSONString();
            } catch (Exception e1) {
                con = json;
            }
        }
        return con;
    }


    private static void diffJson() {


        String j1 = "[{\"accountDate\":1583769600000,\"adjustValues\":[],\"createTime\":1540437548000,\"customerId\":100000046157,\"loanId\":2415257713443947635,\"loanOptValues\":[{\"afterValueInt\":3,\"afterValueString\":\"\",\"beforeValueInt\":2,\"beforeValueString\":\"\",\"created\":1540437548000,\"customerId\":100000046157,\"installmentMadeNo\":0,\"loanId\":0,\"operationType\":31,\"scheduleNo\":0,\"sourceType\":3,\"transactionId\":2637589031991932525},{\"afterValueInt\":0,\"afterValueString\":\"Wed Mar 11 00:00:00 CST 2020\",\"beforeValueInt\":0,\"beforeValueString\":\"Sun Dec 15 00:00:00 CST 2019\",\"created\":1540437548000,\"customerId\":100000046157,\"installmentMadeNo\":0,\"loanId\":0,\"operationType\":40,\"scheduleNo\":0,\"sourceType\":3,\"transactionId\":2637589031991932525}],\"paymentChannel\":1,\"relatedTransactionId\":0,\"requestId\":\"2637589031991932525\",\"transactionAmount\":0,\"transactionCode\":\"010212\",\"transactionDate\":1583769600000,\"transactionId\":2637589031991932525}]";

        String j2 = "[{\"accountDate\":1583769600000,\"adjustValues\":[],\"createTime\":1540437530000,\"customerId\":100000046157,\"loanId\":2415257713443947635,\"loanOptValues\":[{\"afterValueInt\":3,\"afterValueString\":\"\",\"beforeValueInt\":2,\"beforeValueString\":\"\",\"created\":1540437530000,\"customerId\":100000046157,\"installmentMadeNo\":0,\"loanId\":0,\"operationType\":31,\"scheduleNo\":0,\"sourceType\":3,\"transactionId\":2637588276077696621},{\"afterValueInt\":0,\"afterValueString\":\"Wed Mar 11 00:00:00 CST 2020\",\"beforeValueInt\":0,\"beforeValueString\":\"Sun Dec 15 00:00:00 CST 2019\",\"created\":1540437530000,\"customerId\":100000046157,\"installmentMadeNo\":0,\"loanId\":0,\"operationType\":40,\"scheduleNo\":0,\"sourceType\":3,\"transactionId\":2637588276077696621}],\"paymentChannel\":1,\"relatedTransactionId\":0,\"requestId\":\"2637588276077696621\",\"transactionAmount\":0,\"transactionCode\":\"010212\",\"transactionDate\":1583769600000,\"transactionId\":2637588276077696621}]";

        System.out.println(j1.equals(j2));
        JSONObject o1 = JSONObject.parseObject(j1);
        JSONObject o2 = JSONObject.parseObject(j2);

        Iterator<String> i = o1.keySet().iterator();
        while (i.hasNext()) {

            String key = i.next();
            System.out.println("key = " + key);

            try {
                String val1 = o1.getString(key);
                String val2 = o2.getString(key);

                if (val1 != null || val2 != null) {
                    if (!val1.equals(val2)) {
                        System.out.println(o1.getString(key));
                        System.out.println(o2.getString(key));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }

        }

//        compareJson(o1, o2, null);
//
//        Set<Map.Entry<String, Object>> setEn1 = o1.entrySet();
//        Set<Map.Entry<String, Object>> setEn2 = o2.entrySet();
//        for (Map.Entry<String, Object> en : setEn1) {
//            String key = en.getKey();
//            setEn1.
//        }

    }

    @SuppressWarnings("unchecked")
    public static void compareJson(JSONObject json1, JSONObject json2, String key) {

        Iterator<String> i = json1.keySet().iterator();
        while (i.hasNext()) {
            key = i.next();
            compareJson(json1.get(key), json2.get(key), key);
        }
//        return sb.toString();
    }

    public static void compareJson(Object json1, Object json2, String key) {
        if (json1 instanceof JSONObject) {
//            System.out.println("this JSONObject----" + key);
            compareJson((JSONObject) json1, (JSONObject) json2, key);
        } else if (json1 instanceof JSONArray) {
//            System.out.println("this JSONArray----" + key);
            compareJson((JSONArray) json1, (JSONArray) json2, key);
        } else if (json1 instanceof String) {
//            System.out.println("this String----" + key);
//            compareJson((String) json1, (String) json2, key);
            try {
                String json1ToStr = json1.toString();
                String json2ToStr = json2.toString();
                compareJson(json1ToStr, json2ToStr, key);
            } catch (Exception e) {
                System.out.println("转换发生异常 key:" + key);
                e.printStackTrace();
            }

        } else {
//            System.out.println("this other----" + key);
            compareJson(json1.toString(), json2.toString(), key);
        }
    }

    public static void compareJson(String str1, String str2, String key) {
        if (!str1.equals(str2)) {
//            sb.append("key:"+key+ ",json1:"+ str1 +",json2:"+str2);
            System.err.println("不一致key:" + key + ",json1:" + str1 + ",json2:" + str2);
        } else {
            System.out.println("一致：key:" + key + ",json1:" + str1 + ",json2:" + str2);
        }
    }

    public static void compareJson(JSONArray json1, JSONArray json2, String key) {
        if (json1 != null && json2 != null) {
            Iterator i1 = json1.iterator();
            Iterator i2 = json2.iterator();
            while (i1.hasNext()) {
                compareJson(i1.next(), i2.next(), key);
            }
        } else {
            if (json1 == null && json2 == null) {
                System.err.println("不一致：key:" + key + "  在json1和json2中均不存在");
            } else if (json1 == null) {
                System.err.println("不一致：key:" + key + "  在json1中不存在");
            } else if (json2 == null) {
                System.err.println("不一致：key:" + key + "  在json2中不存在");
            } else {
                System.err.println("不一致：key:" + key + "  未知原因");
            }

        }
    }


}
