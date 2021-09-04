package com.ygl.mymusic.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mypage {

    public static Map getPage(int cur, int size, List a)
    {
        int end= Math.min(cur * size, a.size());
        int start=(cur-1)*size>a.size()?0:(cur-1)*size;
        Map<String,Object>res=new HashMap<>();
        res.put("current",cur);
        res.put("size",size);
        res.put("total",a.size());
        res.put("list",a.subList(start, end));
        return res;

    }


}