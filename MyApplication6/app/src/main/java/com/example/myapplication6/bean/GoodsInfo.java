package com.example.myapplication6.bean;

import com.example.myapplication6.R;

import java.util.ArrayList;

public class GoodsInfo {
    public long rowid; // 行号
    public int sn; // 序号
    public String name; // 名称
    public String desc; // 描述
    public float price; // 价格
    public String thumb_path; // 小图的保存路径
    public String pic_path; // 大图的保存路径
    public int thumb; // 小图的资源编号
    public int pic; // 大图的资源编号

    public GoodsInfo() {
        rowid = 0L;
        sn = 0;
        name = "";
        desc = "";
        price = 0;
        thumb_path = "";
        pic_path = "";
        thumb = 0;
        pic = 0;
    }

    // 声明一个手机商品的名称数组
    private static String[] mNameArray = {
            "东风雪铁龙C3L", "福特野马Mustang", "别克英朗", "奥迪A4L", "福特野马Mustang", "汽大众奥迪A3Limousine", "上汽通用别克英朗", "大众朗逸2019款"
    };
    // 声明一个手机商品的描述数组
    private static String[] mDescArray = {
            "东风雪铁龙C3L 升级每个生活时刻 【新车汽车买车轿车】 颜色以跟经销商确认为准 六速手动悦升版",
            "福特野马Mustang【新车汽车买车跑车】2019款加规2.3 汽油 红色",
            "别克英朗 2019款 18T 自动互联精英 汽车新车整车 轿车 白色",
            "奥迪A4L 2019款 40 TFSI 时尚型 汽车新车整车 轿车 红色",
            "福特野马Mustang【新车汽车买车跑车】2019款加规2.3 汽油 蓝色",
            "汽大众奥迪A3Limousine 51车低月供金融分期购车 【新车汽车买车轿车】 2020款改款Limousine35TFSI进取型 冰川白",
            "上汽通用别克英朗 免息分期低首付苏州上牌【新车汽车买车轿车】 2019款 18T 自动互联精英型",
            "大众朗逸2019款 1.5L 自动舒适型 国VI 黑色"
    };
    // 声明一个手机商品的价格数组
    private static float[] mPriceArray = {60888, 39009, 29009, 28099, 26008, 20098, 26900, 20008};
    // 声明一个手机商品的小图数组
    private static int[] mThumbArray = {
            R.drawable.car1, R.drawable.car2, R.drawable.car3,
            R.drawable.car4, R.drawable.car5, R.drawable.car6,
            R.drawable.car7, R.drawable.car8
    };
    // 声明一个手机商品的大图数组
    private static int[] mPicArray = {
            R.drawable.car1, R.drawable.car2, R.drawable.car3,
            R.drawable.car4, R.drawable.car5, R.drawable.car6,
            R.drawable.car7, R.drawable.car8
    };

    // 获取默认的手机信息列表
    public static ArrayList<GoodsInfo> getDefaultList() {
        ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
        for (int i = 0; i < mNameArray.length; i++) {
            GoodsInfo info = new GoodsInfo();
            info.name = mNameArray[i];
            info.desc = mDescArray[i];
            info.price = mPriceArray[i];
            info.thumb = mThumbArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }
}