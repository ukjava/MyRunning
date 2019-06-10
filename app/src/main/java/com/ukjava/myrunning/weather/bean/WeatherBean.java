package com.ukjava.myrunning.weather.bean;


import java.io.Serializable;
import java.util.List;

//天气接口返回数据
public class WeatherBean implements Serializable {
    public SK getSk() {
        return sk;
    }

    public void setSk(SK sk) {
        this.sk = sk;
    }

    public Today getToday() {
        return today;
    }

    public void setToday(Today today) {
        this.today = today;
    }

    /**
     * {
     * 	"resultcode":"200",
     * 	"reason":"successed!",
     * 	"result":{
     * 		"sk":{当前实况天气
     * 			"temp":"21",当前温度
     * 			"wind_direction":"东南风",   当前风向
     * 			"wind_strength":"1级",      当前风力
     * 			"humidity":"96%",        当前湿度
     * 			"time":"22:56"       更新时间
     *                },
     * 		"today":{
     * 			"temperature":"19℃~21℃",      今日温度
     * 			"weather":"大雨转中雨-大雨",      今日天气
     * 			"weather_id":{         天气唯一标识
     * 				"fa":"09",      天气标识00：晴
     * 				"fb":"22"    天气标识53：霾 如果fa不等于fb，说明是组合天气
     *            },
     * 			"wind":"持续无风向微风",
     * 			"week":"星期六",
     * 			"city":"广州",
     * 			"date_y":"2019年04月13日",
     * 			"dressing_index":"较舒适",  穿衣指数
     * 			"dressing_advice":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。",
     * 			"uv_index":"最弱",       紫外线强度
     * 			"comfort_index":"",     舒适度指数
     * 			"wash_index":"不宜",     洗车指数
     * 			"travel_index":"较不宜",   旅游指数
     * 			"exercise_index":"较不宜",  晨练指数
     * 			"drying_index":""        干燥指数
     *        },
     * 		   	},
     * 	"error_code":0
     * }
     */

    private SK sk;
    private Today today;

    public static class SK{
        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getWind_direction() {
            return wind_direction;
        }

        public void setWind_direction(String wind_direction) {
            this.wind_direction = wind_direction;
        }

        public String getWind_strength() {
            return wind_strength;
        }

        public void setWind_strength(String wind_strength) {
            this.wind_strength = wind_strength;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        private String temp;
        private String wind_direction;
        private String wind_strength;
        private String humidity;
        private String time;
    }

    public static class Today{
        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public WId getWeather_id() {
            return weather_id;
        }

        public void setWeather_id(WId weather_id) {
            this.weather_id = weather_id;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDate_y() {
            return date_y;
        }

        public void setDate_y(String date_y) {
            this.date_y = date_y;
        }

        public String getDressing_index() {
            return dressing_index;
        }

        public void setDressing_index(String dressing_index) {
            this.dressing_index = dressing_index;
        }

        public String getDressing_advice() {
            return dressing_advice;
        }

        public void setDressing_advice(String dressing_advice) {
            this.dressing_advice = dressing_advice;
        }

        public String getUv_index() {
            return uv_index;
        }

        public void setUv_index(String uv_index) {
            this.uv_index = uv_index;
        }

        public String getComfort_index() {
            return comfort_index;
        }

        public void setComfort_index(String comfort_index) {
            this.comfort_index = comfort_index;
        }

        public String getWash_index() {
            return wash_index;
        }

        public void setWash_index(String wash_index) {
            this.wash_index = wash_index;
        }

        public String getTravel_index() {
            return travel_index;
        }

        public void setTravel_index(String travel_index) {
            this.travel_index = travel_index;
        }

        public String getExercise_index() {
            return exercise_index;
        }

        public void setExercise_index(String exercise_index) {
            this.exercise_index = exercise_index;
        }

        public String getDrying_index() {
            return drying_index;
        }

        public void setDrying_index(String drying_index) {
            this.drying_index = drying_index;
        }

        private String temperature;
        private String weather;
        private WId weather_id;
        private String wind;
        private String week;
        private String city;
        private String date_y;
        private String dressing_index;
        private String dressing_advice;
        private String uv_index;
        private String comfort_index;
        private String wash_index;
        private String travel_index;
        private String exercise_index;
        private String drying_index;


    }

    public static class WId{
        public String getFa() {
            return fa;
        }

        public void setFa(String fa) {
            this.fa = fa;
        }

        public String getFb() {
            return fb;
        }

        public void setFb(String fb) {
            this.fb = fb;
        }

        private String fa;
        private String fb;
    }
}
