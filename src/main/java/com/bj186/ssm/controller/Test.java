package com.bj186.ssm.controller;

import javafx.scene.input.DataFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 郑金城
 * @title: Test
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/1310:22
 */
public class Test {

    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse("2019-6-13");
            String format = simpleDateFormat.format(date);
            date = simpleDateFormat.parse("2019-6-14");
            System.out.println(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long tm = parse.getTime() - date.getTime();
        long tm2 = 24*60*60*1000;
        System.out.println(tm+"  "+tm2);
    }

}
