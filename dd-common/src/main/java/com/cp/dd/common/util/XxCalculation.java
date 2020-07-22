package com.cp.dd.common.util;

import com.cp.dd.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class XxCalculation {


    /**
     *    小学身高计算
     * @param age 年龄
     * @param height  身高
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calHeight(String age,double height,int sex){


        int score = 0;
        if(sex ==1){
            if("7".equals(age)){
                if(height>123.9){
                    score = 10;
                }else if(120.8<=height && height<= 123.9){
                    score = 8;
                }else if(117.5<=height && height<= 120.7){
                    score = 6;
                }else if(114.5<=height && height<= 117.4){
                    score = 4;
                }else  if(height < 114.5){
                    score = 2;
                }
            }else if("8".equals(age)){
                if(height>130.7){
                    score = 10;
                }else if(127.2<=height && height<= 130.7){
                    score = 8;
                }else if(123.7<=height && height<= 127.1){
                    score = 6;
                }else if(120.5<=height && height<= 123.6){
                    score = 4;
                }else  if(height < 120.5){
                    score = 2;
                }

            }else if("9".equals(age)){
                if(height>136.6){
                    score = 10;
                }else if(132.8<=height && height<= 136.6){
                    score = 8;
                }else if(130.1<=height && height<= 132.7){
                    score = 6;
                }else if(125.6<=height && height<= 130.0){
                    score = 4;
                }else  if(height < 125.6){
                    score = 2;
                }

            }else{
                if(height>140.2){
                    score = 10;
                }else if(138.0<=height && height<= 140.2){
                    score = 8;
                }else if(134.0<=height && height<= 137.9){
                    score = 6;
                }else if(130.3<=height && height<= 133.9){
                    score = 4;
                }else  if(height <130.3){
                    score = 2;
                }
            }
        }else{
            if("7".equals(age)){
                if(height>122.7){
                    score = 10;
                }else if(119.5<=height && height<= 122.7){
                    score = 8;
                }else if(116.3<=height && height<= 119.4){
                    score = 6;
                }else if(113.4<=height && height<= 116.2){
                    score = 4;
                }else  if(height < 113.4){
                    score = 2;
                }
            }else if("8".equals(age)){
                if(height>129.1){
                    score = 10;
                }else if(125.7<=height && height<= 129.1){
                    score = 8;
                }else if(122.2<=height && height<= 125.6){
                    score = 6;
                }else if(119.0<=height && height<= 122.1){
                    score = 4;
                }else  if(height < 119.0){
                    score = 2;
                }

            }else if("9".equals(age)){
                if(height>135.1){
                    score = 10;
                }else if(131.4<=height && height<= 135.1){
                    score = 8;
                }else if(127.7<=height && height<= 131.3){
                    score = 6;
                }else if(124.2<=height && height<= 127.6){
                    score = 4;
                }else  if(height < 124.2){
                    score = 2;
                }

            }else{
                if(height>141.1){
                    score = 10;
                }else if(137.1<=height && height<= 141.1){
                    score = 8;
                }else if(133.0<=height && height<= 137.0){
                    score = 6;
                }else if(129.3<=height && height<= 132.9){
                    score = 4;
                }else  if(height <129.3){
                    score = 2;
                }
            }
        }
        log.info("年龄:"+age+"身高:"+height+"性别:"+sex+"得分:"+score);
        return score;
    }


    /**
     *    BMI计算
     * @param age 年龄
     * @param height  身高
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calBmi(String age,double height,double tz,int sex){
        double bmi = bigDecimalDouble(height,tz);
        int score = 0;
        if(sex ==1){
            if("7".equals(age)){
                if(bmi>18.13){
                    score = 2;
                }else if(16.33<=bmi && bmi<= 18.13){
                    score = 6;
                }else if(15.25<=bmi && bmi<= 16.32){
                    score = 10;
                }else if(14.07<=bmi && bmi<= 15.24){
                    score = 6;
                }else  if(bmi < 14.07){
                    score = 2;
                }
            }else if("8".equals(age)){
                if(bmi>19.53){
                    score = 2;
                }else if(17.29<=bmi && bmi<= 19.53){
                    score = 6;
                }else if(15.45<=bmi && bmi<= 17.28){
                    score = 10;
                }else if(14.13<=bmi && bmi<= 15.44){
                    score = 6;
                }else  if(bmi < 14.13){
                    score = 2;
                }

            }else if("9".equals(age)){
                if(bmi>20.66){
                    score = 2;
                }else if(17.76<=bmi && bmi<= 20.66){
                    score = 6;
                }else if(15.84<=bmi && bmi<= 17.75){
                    score = 10;
                }else if(14.20<=bmi && bmi<= 15.83){
                    score = 6;
                }else  if(bmi < 14.20){
                    score = 2;
                }

            }else{
                if(bmi>21.65){
                    score = 2;
                }else if(18.77<=bmi && bmi<= 21.65){
                    score = 6;
                }else if(16.25<=bmi && bmi<= 18.76){
                    score = 10;
                }else if(14.42<=bmi && bmi<= 16.24){
                    score = 6;
                }else  if(bmi <14.42){
                    score = 2;
                }
            }
        }else{
            if("7".equals(age)){
                if(bmi>17.13){
                    score = 2;
                }else if(15.89<=bmi && bmi<= 17.13){
                    score = 6;
                }else if(14.62<=bmi && bmi<= 15.88){
                    score = 10;
                }else if(13.69<=bmi && bmi<= 14.61){
                    score = 6;
                }else  if(bmi < 13.69){
                    score = 2;
                }
            }else if("8".equals(age)){
                if(bmi>17.79){
                    score = 2;
                }else if(15.85<=bmi && bmi<= 17.79){
                    score = 6;
                }else if(14.65<=bmi && bmi<= 15.84){
                    score = 10;
                }else if(13.67<=bmi && bmi<= 14.64){
                    score = 6;
                }else  if(bmi < 13.67){
                    score = 2;
                }

            }else if("9".equals(age)){
                if(bmi>18.72){
                    score = 2;
                }else if(16.73<=bmi && bmi<= 18.72){
                    score = 6;
                }else if(14.73<=bmi && bmi<= 16.72){
                    score = 10;
                }else if(13.77<=bmi && bmi<= 14.73){
                    score = 6;
                }else  if(bmi < 13.77){
                    score = 2;
                }

            }else{
                if(bmi>19.90){
                    score = 2;
                }else if(17.24<=bmi && bmi<= 19.90){
                    score = 6;
                }else if(15.32<=bmi && bmi<= 17.23){
                    score = 10;
                }else if(13.96<=bmi && bmi<= 15.31){
                    score = 6;
                }else  if(bmi <13.96){
                    score = 2;
                }
            }
        }
        log.info("年龄:"+age+"BMI:"+bmi+"性别:"+sex+"得分:"+score);
        return score;
    }



    /**
     *    小学肺活量计算
     * @param age 年龄
     * @param height  身高
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calFhl(String age,double height,int sex){


        int score = 0;
        if(sex ==1){
            if("7".equals(age)){
                if(height>1500){
                    score = 20;
                }else if(1300<=height && height<= 1500){
                    score = 16;
                }else if(700<=height && height<= 1299){
                    score = 12;
                }else if(500<=height && height<= 699){
                    score = 8;
                }else  if(height < 500){
                    score = 4;
                }
            }else if("8".equals(age)){
                if(height>1800){
                    score = 20;
                }else if(1500<=height && height<= 1800){
                    score = 16;
                }else if(800<=height && height<= 1499){
                    score = 12;
                }else if(550<=height && height<= 799){
                    score = 8;
                }else  if(height < 550){
                    score = 4;
                }

            }else if("9".equals(age)){
                if(height>2100){
                    score = 20;
                }else if(1700<=height && height<= 2100){
                    score = 16;
                }else if(900<=height && height<= 1699){
                    score = 12;
                }else if(600<=height && height<= 899){
                    score = 8;
                }else  if(height < 600){
                    score = 4;
                }

            }else{
                if(height>2400){
                    score = 20;
                }else if(1900<=height && height<= 2400){
                    score = 16;
                }else if(1100<=height && height<= 1899){
                    score = 12;
                }else if(750<=height && height<= 1099){
                    score = 8;
                }else  if(height < 750){
                    score = 4;
                }
            }
        }else{
            if("7".equals(age)){
                if(height>1200){
                    score = 20;
                }else if(1000<=height && height<= 1200){
                    score = 16;
                }else if(600<=height && height<= 999){
                    score = 12;
                }else if(500<=height && height<= 599){
                    score = 8;
                }else  if(height < 500){
                    score = 4;
                }
            }else if("8".equals(age)){
                if(height>1400){
                    score = 20;
                }else if(1200<=height && height<= 1400){
                    score = 16;
                }else if(700<=height && height<= 1199){
                    score = 12;
                }else if(600<=height && height<= 699){
                    score = 8;
                }else  if(height < 600){
                    score = 4;
                }

            }else if("9".equals(age)){
                if(height>1600){
                    score = 20;
                }else if(1400<=height && height<= 1600){
                    score = 16;
                }else if(800<=height && height<= 1399){
                    score = 12;
                }else if(700<=height && height<= 799){
                    score = 8;
                }else  if(height < 700){
                    score = 4;
                }

            }else{
                if(height>1800){
                    score = 20;
                }else if(1600<=height && height<= 1800){
                    score = 16;
                }else if(900<=height && height<= 1599){
                    score = 12;
                }else if(800<=height && height<= 899){
                    score = 8;
                }else  if(height < 800){
                    score = 4;
                }
            }
        }
        log.info("年龄:"+age+"肺活量:"+height+"性别:"+sex+"得分:"+score);
        return score;
    }


    /**
     *    灵敏性计算（10*4折返跑）
     * @param age 年龄
     * @param coordinate  coordinate
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calSensitives(String age,double coordinate,int sex){
        int score = 0;
        if(sex ==1){
            if("7".equals(age)){
                if(coordinate<11.3){
                    score = 20;
                }else if(11.3<=coordinate && coordinate<= 12.1){
                    score = 16;
                }else if(12.2<=coordinate && coordinate<= 13.3){
                    score = 12;
                }else if(13.4<=coordinate && coordinate<= 14.1){
                    score = 8;
                }else  if(14.1<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }
            }else if("8".equals(age)){
                if(coordinate<10.5){
                    score = 20;
                }else if(10.5<=coordinate && coordinate<= 10.7){
                    score = 16;
                }else if(10.8<=coordinate && coordinate<= 12.6){
                    score = 12;
                }else if(12.7<=coordinate && coordinate<= 13.6){
                    score = 8;
                }else  if(13.6<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }

            }else if("9".equals(age)){
                if(coordinate<9.9){
                    score = 20;
                }else if(9.9<=coordinate && coordinate<= 10.1){
                    score = 16;
                }else if(10.2<=coordinate && coordinate<= 12.1){
                    score = 12;
                }else if(12.2<=coordinate && coordinate<= 13.0){
                    score = 8;
                }else  if(13.0<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }

            }else{
                if(coordinate<9.4){
                    score = 20;
                }else if(9.4<=coordinate && coordinate<= 9.6){
                    score = 16;
                }else if(9.7<=coordinate && coordinate<= 11.6){
                    score = 12;
                }else if(11.7<=coordinate && coordinate<= 12.5){
                    score = 8;
                }else  if(12.5<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }
            }
        }else{
            if("7".equals(age)){
                if(coordinate<12.4){
                    score = 20;
                }else if(12.4<=coordinate && coordinate<= 13.5){
                    score = 16;
                }else if(13.6<=coordinate && coordinate<= 14.3){
                    score = 12;
                }else if(14.4<=coordinate && coordinate<= 15.2){
                    score = 8;
                }else  if(15.2<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }
            }else if("8".equals(age)){
                if(coordinate<11.5){
                    score = 20;
                }else if(11.5<=coordinate && coordinate<= 11.9){
                    score = 16;
                }else if(12.0<=coordinate && coordinate<= 13.9){
                    score = 12;
                }else if(14.0<=coordinate && coordinate<= 14.8){
                    score = 8;
                }else  if(14.8<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }

            }else if("9".equals(age)){
                if(coordinate<10.5){
                    score = 20;
                }else if(10.5<=coordinate && coordinate<= 10.9){
                    score = 16;
                }else if(11.0<=coordinate && coordinate<= 12.9){
                    score = 12;
                }else if(13.0<=coordinate && coordinate<= 13.8){
                    score = 8;
                }else  if(13.8<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }

            }else{
                if(coordinate<9.7){
                    score = 20;
                }else if(9.7<=coordinate && coordinate<= 10.1){
                    score = 16;
                }else if(10.2<=coordinate && coordinate<= 12.1){
                    score = 12;
                }else if(12.2<=coordinate && coordinate<= 13){
                    score = 8;
                }else  if(13<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"灵敏性:"+coordinate+"性别:"+sex+"得分:"+score);
        return score;
    }



    /**
     *    柔韧性计算(坐位体前屈)
     * @param age 年龄
     * @param coordinate  coordinate
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calFlexibility(String age,double coordinate,int sex){

        int score = 0;
        if(sex ==1){
            if("7".equals(age)){
                if(coordinate>12){
                    score = 20;
                }else if(10<=coordinate && coordinate<= 12){
                    score = 16;
                }else if(-0.7<=coordinate && coordinate<= 9.9){
                    score = 12;
                }else if(-4.0<=coordinate && coordinate<= -0.8){
                    score = 8;
                }else  if( coordinate<-4.0){
                    score = 4;
                }
            }else if("8".equals(age)){
                if(coordinate>11.9){
                    score = 20;
                }else if(9.6<=coordinate && coordinate<= 11.9){
                    score = 16;
                }else if(-1.1<=coordinate && coordinate<= 9.5){
                    score = 12;
                }else if(-4.4<=coordinate && coordinate<= -1.2){
                    score = 8;
                }else  if( coordinate<-4.4){
                    score = 4;
                }

            }else if("9".equals(age)){
                if(coordinate>11.8){
                    score = 20;
                }else if(9.2<=coordinate && coordinate<= 11.8){
                    score = 16;
                }else if(-1.5<=coordinate && coordinate<= 9.1){
                    score = 12;
                }else if(-4.8<=coordinate && coordinate<= -1.6){
                    score = 8;
                }else  if( coordinate<-4.8){
                    score = 4;
                }

            }else{
                if(coordinate>11.7){
                    score = 20;
                }else if(8.7<=coordinate && coordinate<= 11.7){
                    score = 16;
                }else if(-3.1<=coordinate && coordinate<= 8.6){
                    score = 12;
                }else if(-7.2<=coordinate && coordinate<= -3.2){
                    score = 8;
                }else  if( coordinate<-7.2){
                    score = 4;
                }
            }
        }else{

            if("7".equals(age)){
                if(coordinate>14.7){
                    score = 20;
                }else if(12.4<=coordinate && coordinate<= 14.7){
                    score = 16;
                }else if(-1.7<=coordinate && coordinate<= 12.3){
                    score = 12;
                }else if(-1.6<=coordinate && coordinate<= -1.6){
                    score = 8;
                }else  if( coordinate<-1.6){
                    score = 4;
                }
            }else if("8".equals(age)){
                if(coordinate>14.8){
                    score = 20;
                }else if(12.3<=coordinate && coordinate<= 14.8){
                    score = 16;
                }else if(1.6<=coordinate && coordinate<= 12.2){
                    score = 12;
                }else if(-1.6<=coordinate && coordinate<= 1.5){
                    score = 8;
                }else  if( coordinate<-1.6){
                    score = 4;
                }

            }else if("9".equals(age)){
                if(coordinate>14.9){
                    score = 20;
                }else if(12.2<=coordinate && coordinate<= 14.9){
                    score = 16;
                }else if(1.5<=coordinate && coordinate<= 12.1){
                    score = 12;
                }else if(-1.8<=coordinate && coordinate<= 1.4){
                    score = 8;
                }else  if( coordinate<-1.8){
                    score = 4;
                }

            }else{
                if(coordinate>15){
                    score = 20;
                }else if(12.1<=coordinate && coordinate<= 15){
                    score = 16;
                }else if(1.4<=coordinate && coordinate<= 12.0){
                    score = 12;
                }else if(-1.9<=coordinate && coordinate<= 1.3){
                    score = 8;
                }else  if( coordinate<-1.9){
                    score = 4;
                }
            }

        }
        log.info("年龄:"+age+"柔韧性(坐位体前屈):"+coordinate+"性别:"+sex+"得分:"+score);
        return score;
    }

    /**
     *    跳绳
     * @param age 年龄
     * @param legs  跳远
     * @return
     */
    public static int calTs(String age,Integer legs,int sex){
        int score = 0;
        if(sex == 1) {
            if ("7".equals(age)) {
                if (legs > 93) {
                    score = 20;
                } else if (81 <= legs && legs <= 93) {
                    score = 16;
                } else if (15 <= legs && legs <= 80) {
                    score = 12;
                } else if (2 <= legs && legs <= 14) {
                    score = 8;
                } else if ( legs < 2) {
                    score = 4;
                }
            } else if ("8".equals(age)) {
                if (legs > 107) {
                    score = 20;
                } else if (89 <= legs && legs <= 107) {
                    score = 16;
                } else if (23 <= legs && legs <= 88) {
                    score = 12;
                } else if (10 <= legs && legs <= 22) {
                    score = 8;
                } else if ( legs < 10) {
                    score = 4;
                }

            } else if ("9".equals(age)) {
                if (legs > 110) {
                    score = 20;
                } else if (98 <= legs && legs <= 110) {
                    score = 16;
                } else if (32 <= legs && legs <= 97) {
                    score = 12;
                } else if (19 <= legs && legs <= 31) {
                    score = 8;
                } else if ( legs < 19) {
                    score = 4;
                }

            } else {
                if (legs > 121) {
                    score = 20;
                } else if (109 <= legs && legs <= 121) {
                    score = 16;
                } else if (43 <= legs && legs <= 108) {
                    score = 12;
                } else if (30 <= legs && legs <= 42) {
                    score = 8;
                } else if ( legs < 30) {
                    score = 4;
                }
            }
        }else {

            if ("7".equals(age)) {
                if (legs > 95) {
                    score = 20;
                } else if (81 <= legs && legs <= 95) {
                    score = 16;
                } else if (15 <= legs && legs <= 80) {
                    score = 12;
                } else if (2 <= legs && legs <= 14) {
                    score = 8;
                } else if ( legs < 2) {
                    score = 4;
                }
            } else if ("8".equals(age)) {
                if (legs > 105) {
                    score = 20;
                } else if (91 <= legs && legs <= 105) {
                    score = 16;
                } else if (25 <= legs && legs <= 90) {
                    score = 12;
                } else if (12 <= legs && legs <= 24) {
                    score = 8;
                } else if ( legs < 12) {
                    score = 4;
                }

            } else if ("9".equals(age)) {
                if (legs > 117) {
                    score = 20;
                } else if (103 <= legs && legs <= 117) {
                    score = 16;
                } else if (37 <= legs && legs <= 102) {
                    score = 12;
                } else if (24 <= legs && legs <= 36) {
                    score = 8;
                } else if ( legs < 24) {
                    score = 4;
                }

            } else {
                if (legs > 127) {
                    score = 20;
                } else if (113 <= legs && legs <= 127) {
                    score = 16;
                } else if (47 <= legs && legs <= 112) {
                    score = 12;
                } else if (34 <= legs && legs <= 46) {
                    score = 8;
                } else if ( legs < 30) {
                    score = 4;
                }
            }

        }
        log.info("年龄:"+age+"跳绳:"+legs+""+"得分:"+score);
        return score;
    }




    /**
     *    移动技术
     * @param age 年龄
     * @param coordinate  coordinate
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calYd(String age,double coordinate,int sex){
        int score = 0;
        if(sex ==1){
            if("7".equals(age)){
                if(coordinate<16.52){
                    score = 20;
                }else if(16.52<=coordinate && coordinate<= 18.78){
                    score = 16;
                }else if(18.79<=coordinate && coordinate<= 24.62){
                    score = 12;
                }else if(24.63<=coordinate && coordinate<= 27.35){
                    score = 8;
                }else  if(27.35<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }
            }else if("8".equals(age)){
                if(coordinate<15.74){
                    score = 20;
                }else if(15.74<=coordinate && coordinate<= 16.84){
                    score = 16;
                }else if(16.85<=coordinate && coordinate<= 18.44){
                    score = 12;
                }else if(18.45<=coordinate && coordinate<= 21.56){
                    score = 8;
                }else  if(21.56<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }

            }else if("9".equals(age)){
                if(coordinate<13.28){
                    score = 20;
                }else if(13.28<=coordinate && coordinate<= 15.14){
                    score = 16;
                }else if(15.15<=coordinate && coordinate<= 17.93){
                    score = 12;
                }else if(17.94<=coordinate && coordinate<= 20.77){
                    score = 8;
                }else  if(20.77<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }

            }else{
                if(coordinate<12.36){
                    score = 20;
                }else if(12.36<=coordinate && coordinate<= 14.04){
                    score = 16;
                }else if(14.05<=coordinate && coordinate<= 16.63){
                    score = 12;
                }else if(16.64<=coordinate && coordinate<= 19.12){
                    score = 8;
                }else  if(19.12<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }
            }
        }else{
            if("7".equals(age)){
                if(coordinate<17.53){
                    score = 20;
                }else if(17.53<=coordinate && coordinate<= 20.34){
                    score = 16;
                }else if(20.35<=coordinate && coordinate<= 23.55){
                    score = 12;
                }else if(23.56<=coordinate && coordinate<= 28.88){
                    score = 8;
                }else  if(28.88<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }
            }else if("8".equals(age)){
                if(coordinate<16.84){
                    score = 20;
                }else if(16.84<=coordinate && coordinate<= 18.33){
                    score = 16;
                }else if(18.34<=coordinate && coordinate<= 21.37){
                    score = 12;
                }else if(21.38<=coordinate && coordinate<= 23.43){
                    score = 8;
                }else  if(23.43<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }

            }else if("9".equals(age)){
                if(coordinate<15.84){
                    score = 20;
                }else if(15.84<=coordinate && coordinate<= 17.53){
                    score = 16;
                }else if(17.54<=coordinate && coordinate<= 20.26){
                    score = 12;
                }else if(20.27<=coordinate && coordinate<= 22.66){
                    score = 8;
                }else  if(22.66<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }

            }else{
                if(coordinate<14.96){
                    score = 20;
                }else if(14.96<=coordinate && coordinate<= 16.47){
                    score = 16;
                }else if(16.48<=coordinate && coordinate<= 19.57){
                    score = 12;
                }else if(19.58<=coordinate && coordinate<= 21.34){
                    score = 8;
                }else  if(21.34<coordinate ){
                    score = 4;
                }else{
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"灵敏性:"+coordinate+"性别:"+sex+"得分:"+score);
        return score;
    }



    /**
     *    传球计算
     * @param age 年龄
     * @param legs  跳远
     * @return
     */
    public static int calPass(String age,Integer legs,int sex){
        int score = 0;
        if(sex == 1) {
            if ("7".equals(age)) {
                if (legs > 19) {
                    score = 40;
                } else if (16 <= legs && legs <= 19) {
                    score = 32;
                } else if (11 <= legs && legs <= 15) {
                    score = 24;
                } else if (7 <= legs && legs <= 10) {
                    score = 16;
                } else if ( legs < 7) {
                    score = 8;
                }
            } else if ("8".equals(age)) {
                if (legs > 24) {
                    score = 40;
                } else if (21 <= legs && legs <= 24) {
                    score = 32;
                } else if (16 <= legs && legs <= 20) {
                    score = 24;
                } else if (9 <= legs && legs <= 15) {
                    score = 16;
                } else if ( legs < 9) {
                    score = 8;
                }

            } else if ("9".equals(age)) {
                if (legs > 27) {
                    score = 40;
                } else if (24 <= legs && legs <= 27) {
                    score = 32;
                } else if (19 <= legs && legs <= 23) {
                    score = 24;
                } else if (12 <= legs && legs <= 18) {
                    score = 16;
                } else if ( legs < 12) {
                    score = 8;
                }

            } else {
                if (legs > 27) {
                    score = 40;
                } else if (25 <= legs && legs <= 27) {
                    score = 32;
                } else if (21 <= legs && legs <= 24) {
                    score = 24;
                } else if (13 <= legs && legs <= 20) {
                    score = 16;
                } else if ( legs < 13) {
                    score = 8;
                }
            }
        }else{
            if ("7".equals(age)) {
                if (legs > 18) {
                    score = 40;
                } else if (15 <= legs && legs <= 18) {
                    score = 32;
                } else if (11 <= legs && legs <= 14) {
                    score = 24;
                } else if (7 <= legs && legs <= 10) {
                    score = 16;
                } else if ( legs < 7) {
                    score = 8;
                }
            } else if ("8".equals(age)) {
                if (legs > 20) {
                    score = 40;
                } else if (17 <= legs && legs <= 20) {
                    score = 32;
                } else if (13 <= legs && legs <= 16) {
                    score = 24;
                } else if (8 <= legs && legs <= 12) {
                    score = 16;
                } else if ( legs < 8) {
                    score = 8;
                }

            } else if ("9".equals(age)) {
                if (legs > 23) {
                    score = 40;
                } else if (20 <= legs && legs <= 23) {
                    score = 32;
                } else if (16 <= legs && legs <= 19) {
                    score = 24;
                } else if (10 <= legs && legs <= 15) {
                    score = 16;
                } else if ( legs < 10) {
                    score = 8;
                }

            } else {
                if (legs > 26) {
                    score = 40;
                } else if (22 <= legs && legs <= 26) {
                    score = 32;
                } else if (17 <= legs && legs <= 21) {
                    score = 24;
                } else if (11 <= legs && legs <= 16) {
                    score = 16;
                } else if ( legs < 11) {
                    score = 8;
                }
            }
        }
        log.info("年龄:"+age+"传球:"+legs+""+"得分:"+score);
        return score;
    }



    /**
     *    投篮计算
     * @param age 年龄
     * @param legs  跳远
     * @return
     */
    public static int calShoot(String age,Integer legs,int sex){
        int score = 0;
        if(sex == 1) {
            if ("7".equals(age)) {
                if (legs > 6) {
                    score = 40;
                } else if (5 <= legs && legs <= 6) {
                    score = 32;
                } else if (3 <= legs && legs <= 4) {
                    score = 24;
                } else if ( legs == 2) {
                    score = 16;
                } else if ( legs == 1) {
                    score = 8;
                }
            } else if ("8".equals(age)) {
                if (legs > 7) {
                    score = 40;
                } else if (5 <= legs && legs <= 7) {
                    score = 32;
                } else if ( legs == 4) {
                    score = 24;
                } else if (legs == 3) {
                    score = 16;
                } else if ( legs < 3) {
                    score = 8;
                }

            } else if ("9".equals(age)) {
                if (legs > 6) {
                    score = 40;
                } else if (5 <= legs && legs <= 6) {
                    score = 32;
                } else if (3 <= legs && legs <= 4) {
                    score = 24;
                } else if ( legs == 2) {
                    score = 16;
                } else if ( legs == 1) {
                    score = 8;
                }

            } else {
                if (legs > 8) {
                    score = 40;
                } else if (7 <= legs && legs <= 8) {
                    score = 32;
                } else if (5 <= legs && legs <= 6) {
                    score = 24;
                } else if (3 <= legs && legs <= 4) {
                    score = 16;
                } else if ( legs < 3) {
                    score = 8;
                }
            }
        }else{
            if ("7".equals(age)) {
                if (legs > 6) {
                    score = 40;
                } else if (5 <= legs && legs <= 6) {
                    score = 32;
                } else if (3 <= legs && legs <= 4) {
                    score = 24;
                } else if ( legs == 2) {
                    score = 16;
                } else if ( legs == 1) {
                    score = 8;
                }
            } else if ("8".equals(age)) {
                if (legs > 7) {
                    score = 40;
                } else if (5 <= legs && legs <= 7) {
                    score = 32;
                } else if ( legs == 4) {
                    score = 24;
                } else if ( legs == 3) {
                    score = 16;
                } else if ( legs < 3) {
                    score = 8;
                }

            } else if ("9".equals(age)) {
                if (legs > 6) {
                    score = 40;
                } else if (5 <= legs && legs <= 6) {
                    score = 32;
                } else if (3 <= legs && legs <= 4) {
                    score = 24;
                } else if (legs == 2) {
                    score = 16;
                } else if ( legs == 1) {
                    score = 8;
                }

            } else {
                if (legs > 7) {
                    score = 40;
                } else if (5 <= legs && legs <= 7) {
                    score = 32;
                } else if (legs == 4) {
                    score = 24;
                } else if ( legs == 3) {
                    score = 16;
                } else if ( legs < 3) {
                    score = 8;
                }
            }
        }
        log.info("年龄:"+age+"传球:"+legs+""+"得分:"+score);
        return score;
    }





    public static double bigDecimalDouble (double height,double tz){
        double bmi = tz / ((height/100)*(height/100));
        BigDecimal bg = new BigDecimal(bmi);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return  f1;
    }

    /**
     * 身高预测
     * @param fHeight 父亲身高
     * @param mHeight 母亲身高
     * @param sex  性别
     * @return
     */
    public static double calResultHeight (double fHeight,double mHeight,int sex){
        double resultHeight = 0.0;
        if(fHeight <100 || mHeight<100){
            throw new ApiException("请输入合理数据");
        }
        if(sex ==1){
            resultHeight = 59.699+0.419*fHeight + 0.265*mHeight;
        } else{
            resultHeight =  43.089+0.306*fHeight + 0.431*mHeight;
        }
        BigDecimal bg = new BigDecimal(resultHeight);
        resultHeight = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return  resultHeight;
    }

    public  static double getBMI(double height,double tz){
        double bmi = bigDecimalDouble(height,tz);
        return  bmi;
    }



}
