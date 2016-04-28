package huff;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wq on 16-4-25.
 */
public class Test {
    public static void main(String args[]) throws Exception{
        String s = "abccaabbbbb";
        String reg = "";
        Huffman2 huff = new Huffman2();
        List<Node2> lists = huff.getList(s,reg);
        Node2 root = huff.createHuffamnTree(lists);
        HashMap<String,String> hashMap =  huff.createHuffmanCode(root,"",new Node2("",0));
        System.out.println("得到編碼序列！！！");
        String code = huff.getCode(s, hashMap);
        System.out.println(s+"的編碼序列爲"+ code);
    }
}
