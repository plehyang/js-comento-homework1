package com.demo.comentoStatistic.controller;

@Controller
public class PingController {

    @RequestMapping(value="/ping", produces = "application/json")
    @ResponseBody
    public Object healthCheck(){
        Map<String, Object> map = new HashMap<>();
        map.put("today", ZonedDateTime.now().getMonth() + ":" + ZonedDateTime.now().getDayOfMonth());
        return map;
    }

}
