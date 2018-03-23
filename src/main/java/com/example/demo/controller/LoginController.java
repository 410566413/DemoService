package com.example.demo.controller;

import com.example.demo.pojo.Contact;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    @RequestMapping(value = "/mobile/mobileLogin.do",method = {RequestMethod.POST ,RequestMethod.GET})
    public Object mobileLogin(@RequestBody String msg){
        System.out.println(msg);

        Map map = new HashMap<>();
        map.put("code",200);
        map.put("message","成功");
        map.put("data",msg);
        return map;
    }


    @RequestMapping(value = "/client/sendMessage.do",method = {RequestMethod.POST ,RequestMethod.GET})
    public Object SendMessageContext(@RequestBody String phoneNo ){

        System.out.println(phoneNo.toString());
        Map map = new HashMap<>();
        map.put("code",200);
        map.put("message","短信发送成功!");
        map.put("data",phoneNo.substring(9,15));
        return map;
    }


    @RequestMapping(value = "/mobile/contactPost.do",method = {RequestMethod.POST})
    public Object contactPost(@RequestBody String contacts){
        System.out.println(contacts);
        JSONArray myJsonArray = JSONArray.fromObject(contacts);
        if(myJsonArray.size()>0){
            for(int i=0;i<myJsonArray.size();i++){
                JSONObject job = myJsonArray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                System.out.println(job.optString("phoneMaster")) ;  // 得到 每个对象中的属性值
                System.out.println(job.get("contactId")) ;  // 得到 每个对象中的属性值
                System.out.println(job.get("contactName")) ;  // 得到 每个对象中的属性值
                System.out.println(job.get("contactPhone")) ;  // 得到 每个对象中的属性值
            }
        }
        Map map = new HashMap<>();
        map.put("code",200);
        map.put("message","成功");
        map.put("data","");
        return map;
    }

}
