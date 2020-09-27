package com.cp.dd.common.util.sys;

import com.cp.dd.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Slf4j
public class Baskculation {


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
     * 30秒胯下O字绕滚球
     * @param type
     * @param rall
     * @return
     */

    public  static  int calRall(Integer type,int rall){
        int score = 0;
        if(type == 1){
            if(rall >= 9){
                score =100;
            }else if(7 <= rall && rall <= 8){
                score =80;
            }else if(5 <= rall && rall <= 6){
                score =60;
            }else if(3 <= rall && rall <= 4){
                score =40;
            }else if( rall <= 2){
                score =20;
            }
        }else if(type == 2){
            if(rall >= 12){
                score =100;
            }else if(10 <= rall && rall <= 11){
                score =80;
            }else if(8 <= rall && rall <= 9){
                score =60;
            }else if(6 <= rall && rall <= 7){
                score =40;
            }else if(rall <= 5){
                score =20;
            }
        }else if(type == 3){
            if(rall >= 6){
                score =100;
            }else if(5 == rall){
                score =80;
            }else if( 4 == rall ){
                score =60;
            }else if(3 == rall ){
                score =40;
            }else if( rall <= 2){
                score =20;
            }
        }
        return score/5;
    }


    /**
     * 30秒原地单手运球
     * @param type
     * @param rall
     * @return
     */

    public  static  int calShDribble(Integer type,int rall){
        int score = 0;
        if(type == 1){
            if(rall >= 36){
                score =100;
            }else if(31 <= rall && rall <= 35){
                score =80;
            }else if(20 <= rall && rall <= 30){
                score =60;
            }else if(10 <= rall && rall <= 19){
                score =40;
            }else if( rall <= 9){
                score =20;
            }
        }else if(type == 2){
            if(rall >= 49){
                score =100;
            }else if(40 <= rall && rall <= 48){
                score =80;
            }else if(28 <= rall && rall <= 39){
                score =60;
            }else if(13 <= rall && rall <= 27){
                score =40;
            }else if( rall <= 12){
                score =20;
            }
        }else if(type == 3){
            if(rall >= 63){
                score =100;
            }else if(57 <= rall && rall <= 62){
                score =80;
            }else if(46 <= rall && rall <= 56){
                score =60;
            }else if(30 <= rall && rall <= 45){
                score =40;
            }else if(12 <= rall && rall <= 29){
                score =20;
            }
        }
        return score/5;
    }


    /**
     *8米折返动感1+1拍球
     * @param type
     * @param rall
     * @return
     */

    public  static  int calBat(Integer type,Double rall){
        int score = 0;
        if(type == 1){
            if(rall <= 15){
                score =100;
            }else if(16 <= rall && rall <= 21){
                score =80;
            }else if(22 <= rall && rall <= 29){
                score =60;
            }else if(30 <= rall && rall <= 36){
                score =40;
            }else if(37 <= rall ){
                score =20;
            }
        }else if(type == 2){
            if(rall <= 15){
                score =100;
            }else if(16 <= rall && rall <= 19){
                score =80;
            }else if(20 <= rall && rall <= 25){
                score =60;
            }else if(26 <= rall && rall <= 30){
                score =40;
            }else if(31 <= rall ){
                score =20;
            }
        }else if(type == 3){
            if(rall <= 20){
                score =100;
            }else if(21 <= rall && rall <= 25){
                score =80;
            }else if(26 <= rall && rall <= 30){
                score =60;
            }else if(31 <= rall && rall <= 35){
                score =40;
            }else if(36 <= rall ){
                score =20;
            }
        }
        return score/5;
    }


    /**
     * 传/抛球进圈
     * @param type
     * @param rall
     * @return
     */
    public  static  int calPass(Integer type,int rall){
        int score = 0;
        if(type == 1){
            if(rall >= 7){
                score =100;
            }else if(5 <= rall && rall <= 6){
                score =80;
            }else if(4 == rall ){
                score =60;
            }else if(2 <= rall && rall <= 3){
                score =40;
            }else if(rall <= 1 ){
                score =20;
            }
        }else if(type == 2){
            if(rall >= 7){
                score =100;
            }else if(5 <= rall && rall <= 6){
                score =80;
            }else if(3 <= rall && rall <= 4){
                score =60;
            }else if(2 == rall ){
                score =40;
            }else if(rall <= 1){
                score =20;
            }
        }else if(type == 3){
            if(rall >= 6){
                score =100;
            }else if(5 == rall ){
                score =80;
            }else if(4 == rall){
                score =60;
            }else if(3 == rall){
                score =40;
            }else if( rall <= 2){
                score =20;
            }
        }
        return score/5;
    }



    /**
     * 投篮
     * @param type
     * @param rall
     * @return
     */
    public  static  int calShoot(Integer type,int rall){
        int score = 0;
        if(type == 1){
            if(rall >= 5){
                score =100;
            }else if(4 == rall ){
                score =80;
            }else if(3 == rall ){
                score =60;
            }else if(2 == rall){
                score =40;
            }else if(rall <= 1  ){
                score =20;
            }
        }else if(type == 2){
            if(rall >= 5){
                score =100;
            }else if(4 == rall ){
                score =80;
            }else if(3 == rall ){
                score =60;
            }else if(2 == rall){
                score =40;
            }else if(rall <= 1 ){
                score =20;
            }
        }else if(type == 3){
            if(rall >= 5){
                score =100;
            }else if(4 == rall ){
                score =80;
            }else if(3 == rall ){
                score =60;
            }else if(2 == rall){
                score =40;
            }else if(rall <= 1  ){
                score =20;
            }
        }
        return score/5;
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

    /**
     * 篮球年龄
     * @param birth
     * @return
     */
    public  static String getBaskAge(String birth){
        LocalDate today = LocalDate.now();
        LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(birth));
        long years = ChronoUnit.YEARS.between(playerDate, today);
        long month = ChronoUnit.MONTHS.between(playerDate, today);
        long day = ChronoUnit.DAYS.between(playerDate, today);
        String age = String.valueOf(years);
        if(day - years*365 >= 2 ){
            if(years <= 1){
                age = "1";
            }else{
                age = Integer.valueOf(age)+1 +"";
            }
        }
        return  age;
    }






}
