package huff;

import java.util.*;

/**
 * Created by wq on 16-4-23.
 */
public class Huffman2 {
    /**
     * 在霍夫曼編碼前 需要構建霍夫曼樹
     * @param nodes  接收一個Node的集合
     * @return  返回霍夫曼樹的根節點
     */
    public Node2 createHuffamnTree(List<Node2> nodes) throws Exception{
        if(nodes.size()==0){
            throw new Exception("00000");
        }
        List<Node2> nodeList = new ArrayList<>();
        if(nodes.size()>1) {
            nodeList = replaceNode(nodes);
        }else{
            nodeList.add(nodeList.get(0));
        }
        if(nodeList.size()>1){
            return createHuffamnTree(nodeList);
        }else{
            return nodeList.get(0);
        }
    }

    /**
     * 構建霍夫曼樹時，構建新List集合
     * @param nodes 接收一個Node的集合
     * @return 一個List集合
     */
    public List<Node2> replaceNode(List<Node2> nodes){
        List<Node2> list = sortNode(nodes);
        List<Node2> re = null;
        if(list.size() !=1){
            double a = list.get(0).getWeight();
            double b = list.get(1).getWeight();
            Node2<String> newNode = new Node2("N"+(a+b),(a+b));
            newNode.leftNode  = list.get(0);
            newNode.rightNode = list.get(1);
            list.remove(1);
            list.remove(0);
            list.add(newNode);
            re = sortNode(list);
            return re;
        }else{
            re = list;
            return re;
        }
    }

    /**
     * 對List<Node> 進行排序  排序規則在Node 中已經實現了Comparable中的compareTo方法
     * @param nodes 接收一個Node的集合
     * @return 一個List集合
     */
    public List<Node2> sortNode(List<Node2> nodes){
        Collections.sort(nodes);
        return nodes;
    }


    HashMap<String,String> hashMap = new HashMap<String,String>();

    /**
     * 創建霍夫曼編碼集合
     * @param ele 迭代的元素
     * @param s 這個定義了 左分支爲0 或這  爲1
     * @param parent  迭代元素的父元素  用於 計算除當前元素的 編碼序列
     * @return 用於爲對象的編碼hashMap
     */
    public HashMap<String,String> createHuffmanCode(Node2<String> ele,String s,Node2<String> parent){

        if(ele != null){
            String parentString = hashMap.containsKey(parent.data) ? hashMap.get(parent.data) : "";
            String data = ele.data;
            hashMap.put(data,parentString+s);
            if(ele.leftNode !=null){
                createHuffmanCode(ele.leftNode, "0", ele);
            }
            if(ele.rightNode !=null){
                createHuffmanCode(ele.rightNode, "1", ele);
            }
        }
        return hashMap;
    }


    /**
     * 計算得出編碼
     * @param s 要進行編碼的字符串
     * @param hashMap 用於爲對象的編碼hashMap
     * @return 編碼序列
     */
    public String getCode(String s,HashMap<String,String> hashMap){
        StringBuffer code = new StringBuffer();
        String ss [] = s.split("");
        for(String str : ss){
            code.append(hashMap.get(str));
        }
        return code.toString();
    }

    /**
     * 將給定的字符串通過分割參數進行分割，計算權重，得出Node 的集合
     * @param s 字符串
     * @param reg 分割參數
     * @return List<Node>集合
     */
    public List<Node2> getList(String s,String reg){
        List<Node2> lists = new ArrayList();
        String x[] = s.split(reg);
        HashMap<String,Integer> hashMap1 = new HashMap<>();
        for(String str:x){
            if(hashMap1.containsKey(str)){
                int hz = hashMap1.get(str);
                hashMap1.put(str,hz+1);
            }else{
                hashMap1.put(str,1);
            }
        }
        Iterator<Map.Entry<String,Integer>> iterator = hashMap1.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> en = iterator.next();
            lists.add(new Node2(en.getKey(),en.getValue()));
        }
        System.out.println("lists 構建完成！！！！！");
        return lists;
    }

    public String getDeCode(String code){
        return "";
    }
}
