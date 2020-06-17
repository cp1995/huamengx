package com.cp.dd.common.util;

import com.cp.dd.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class calculation {


    /**
     *    身高计算
     * @param age 年龄
     * @param height  身高
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calHeight(String age,double height,int sex){


        int score = 0;
        if(sex ==1){
            if("3".equals(age)){
                if(height>104.1){
                    score = 5;
                }else if(99.4<=height && height<= 104.1){
                    score = 4;
                }else if(95.5<=height && height<= 99.3){
                    score = 3;
                }else if(91.2<=height && height<= 95.4){
                    score = 2;
                }else  if(height < 91.2){
                    score = 1;
                }
            }else if("3.5".equals(age)){
                if(height>106.9){
                    score = 5;
                }else if(102.1<=height && height<= 106.9){
                    score = 4;
                }else if(98.3<=height && height<= 102.0){
                    score = 3;
                }else if(94.1<=height && height<= 98.2){
                    score = 2;
                }else  if(height < 94.1){
                    score = 1;
                }

            }else if("4".equals(age)){
                if(height>110.4){
                    score = 5;
                }else if(105.5<=height && height<= 110.4){
                    score = 4;
                }else if(102.0<=height && height<= 105.4){
                    score = 3;
                }else if(97.5<=height && height<= 101.9){
                    score = 2;
                }else  if(height < 97.5){
                    score = 1;
                }

            }else if("4.5".equals(age)){
                if(height>113.1){
                    score = 5;
                }else if(108.5<=height && height<= 113.1){
                    score = 4;
                }else if(104.7<=height && height<= 108.4){
                    score = 3;
                }else if(100<=height && height<= 104.6){
                    score = 2;
                }else  if(height <100){
                    score = 1;
                }

            }else if("5".equals(age)){
                if(height>116.9){
                    score = 5;
                }else if(112.0<=height && height<= 116.9){
                    score = 4;
                }else if(107.9<=height && height<= 111.9){
                    score = 3;
                }else if(103.1<=height && height<= 107.8){
                    score = 2;
                }else  if(height <103.1){
                    score = 1;
                }

            }else if("5.5".equals(age)){
                if(height>119.7){
                    score = 5;
                }else if(114.7<=height && height<= 119.7){
                    score = 4;
                }else if(110.2<=height && height<= 114.6){
                    score = 3;
                }else if(104.6<=height && height<= 110.1){
                    score = 2;
                }else  if(height <104.6){
                    score = 1;
                }
            }else{
                if(height>123.0){
                    score = 5;
                }else if(117.8<=height && height<= 123.0){
                    score = 4;
                }else if(113.3<=height && height<= 117.7){
                    score = 3;
                }else if(108.2<=height && height<= 113.2){
                    score = 2;
                }else  if(height <108.2){
                    score = 1;
                }
            }
        }else{
            if("3".equals(age)){
                if(height>103){
                    score = 5;
                }else if(98.1<=height && height<= 103){
                    score = 4;
                }else if(94.7<=height && height<= 98){
                    score = 3;
                }else if(90<=height && height<= 94.6){
                    score = 2;
                }else  if(height < 90){
                    score = 1;
                }
            }else if("3.5".equals(age)){
                if(height>105.5){
                    score = 5;
                }else if(101.2<=height && height<= 105.5){
                    score = 4;
                }else if(97.6<=height && height<= 101.1){
                    score = 3;
                }else if(93<=height && height<= 97.5){
                    score = 2;
                }else  if(height < 93){
                    score = 1;
                }

            }else if("4".equals(age)){
                if(height>108.9){
                    score = 5;
                }else if(104.5<=height && height<= 108.9){
                    score = 4;
                }else if(101.0<=height && height<= 104.4){
                    score = 3;
                }else if(96.6<=height && height<= 100.9){
                    score = 2;
                }else  if(height < 96.6){
                    score = 1;
                }

            }else if("4.5".equals(age)){
                if(height>111.9){
                    score = 5;
                }else if(107.4<=height && height<= 111.9){
                    score = 4;
                }else if(103.7<=height && height<= 107.3){
                    score = 3;
                }else if(99.0<=height && height<= 103.6){
                    score = 2;
                }else  if(height <99.0){
                    score = 1;
                }

            }else if("5".equals(age)){
                if(height>115.4){
                    score = 5;
                }else if(110.5<=height && height<= 115.4){
                    score = 4;
                }else if(106.6<=height && height<= 110.4){
                    score = 3;
                }else if(102.0<=height && height<= 106.5){
                    score = 2;
                }else  if(height <102.0){
                    score = 1;
                }

            }else if("5.5".equals(age)){
                if(height>118.4){
                    score = 5;
                }else if(113.5<=height && height<= 118.4){
                    score = 4;
                }else if(109.3<=height && height<= 113.4){
                    score = 3;
                }else if(104.5<=height && height<= 109.2){
                    score = 2;
                }else  if(height <104.5){
                    score = 1;
                }
            }else{
                if(height>121.7){
                    score = 5;
                }else if(116.7<=height && height<= 121.7){
                    score = 4;
                }else if(112.0<=height && height<= 116.6){
                    score = 3;
                }else if(107.0<=height && height<= 111.9){
                    score = 2;
                }else  if(height <107.0){
                    score = 1;
                }
            }
        }
        log.info("年龄:"+age+"身高:"+height+"性别:"+sex+"得分:"+score*4);
        return score*4;
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
            if("3".equals(age)){
                if(bmi>16.72){
                    score = 1;
                }else if(15.94<=bmi && bmi<= 16.72){
                    score = 3;
                }else if(15.33<=bmi && bmi<= 15.93){
                    score = 5;
                }else if(14.84<=bmi && bmi<= 15.32){
                    score = 3;
                }else  if(bmi < 14.84){
                    score = 1;
                }
            }else if("3.5".equals(age)){
                if(bmi>16.58){
                    score = 1;
                }else if(15.75<=bmi && bmi<= 16.58){
                    score = 3;
                }else if(15.24<=bmi && bmi<= 15.74){
                    score = 5;
                }else if(14.59<=bmi && bmi<= 15.23){
                    score = 3;
                }else  if(bmi < 14.59){
                    score = 1;
                }

            }else if("4".equals(age)){
                if(bmi>16.57){
                    score = 1;
                }else if(15.66<=bmi && bmi<= 16.57){
                    score = 3;
                }else if(15.16<=bmi && bmi<= 15.65){
                    score = 5;
                }else if(14.46<=bmi && bmi<= 15.15){
                    score = 3;
                }else  if(bmi < 14.46){
                    score = 1;
                }

            }else if("4.5".equals(age)){
                if(bmi>16.61){
                    score = 1;
                }else if(15.71<=bmi && bmi<= 16.61){
                    score = 3;
                }else if(15.10<=bmi && bmi<= 15.70){
                    score = 5;
                }else if(14.37<=bmi && bmi<= 15.09){
                    score = 3;
                }else  if(bmi <14.37){
                    score = 1;
                }

            }else if("5".equals(age)){
                if(bmi>16.67){
                    score = 1;
                }else if(15.83<=bmi && bmi<= 16.67){
                    score = 3;
                }else if(15.02<=bmi && bmi<= 15.82){
                    score = 5;
                }else if(14.30<=bmi && bmi<= 15.01){
                    score = 3;
                }else  if(bmi <14.30){
                    score = 1;
                }

            }else if("5.5".equals(age)){
                if(bmi>16.98){
                    score = 1;
                }else if(15.75<=bmi && bmi<= 16.98){
                    score = 3;
                }else if(15.04<=bmi && bmi<= 15.74){
                    score = 5;
                }else if(14.21<=bmi && bmi<= 15.03){
                    score = 3;
                }else  if(bmi <14.21){
                    score = 1;
                }
            }else{
                if(bmi>17.19){
                    score = 1;
                }else if(15.86<=bmi && bmi<= 17.19){
                    score = 3;
                }else if(14.95<=bmi && bmi<= 15.85){
                    score = 5;
                }else if(14.11<=bmi && bmi<= 14.95){
                    score = 3;
                }else  if(bmi <14.11){
                    score = 1;
                }
            }
        }else{
            if("3".equals(age)){
                if(bmi>16.57){
                    score = 1;
                }else if(15.77<=bmi && bmi<= 16.57){
                    score = 3;
                }else if(15.16<=bmi && bmi<= 15.76){
                    score = 5;
                }else if(14.65<=bmi && bmi<= 15.15){
                    score = 3;
                }else  if(bmi < 14.65){
                    score = 1;
                }
            }else if("3.5".equals(age)){
                if(bmi>16.56){
                    score = 1;
                }else if(15.75<=bmi && bmi<= 16.56){
                    score = 3;
                }else if(15.04<=bmi && bmi<= 15.74){
                    score = 5;
                }else if(14.43<=bmi && bmi<= 15.03){
                    score = 3;
                }else  if(bmi < 14.43){
                    score = 1;
                }

            }else if("4".equals(age)){
                if(height>16.55){
                    score = 1;
                }else if(15.62<=bmi && bmi<= 16.55){
                    score = 3;
                }else if(14.91<=bmi && bmi<= 15.61){
                    score = 5;
                }else if(14.27<=bmi && bmi<= 14.90){
                    score = 3;
                }else  if(bmi < 14.27){
                    score = 1;
                }

            }else if("4.5".equals(age)){
                if(bmi>16.47){
                    score = 1;
                }else if(15.54<=bmi && bmi<= 16.47){
                    score = 3;
                }else if(14.73<=bmi && bmi<= 15.53){
                    score = 5;
                }else if(14.11<=bmi && bmi<= 14.72){
                    score = 3;
                }else  if(bmi <14.11){
                    score = 1;
                }

            }else if("5".equals(age)){
                if(bmi>16.51){
                    score = 1;
                }else if(15.55<=bmi && bmi<= 16.51){
                    score = 3;
                }else if(14.64<=bmi && bmi<= 15.54){
                    score = 5;
                }else if(13.99<=bmi && bmi<= 14.63){
                    score = 3;
                }else  if(bmi <13.99){
                    score = 1;
                }

            }else if("5.5".equals(age)){
                if(bmi>16.61){
                    score = 1;
                }else if(15.93<=bmi && bmi<= 16.61){
                    score = 3;
                }else if(15.12<=bmi && bmi<= 15.92){
                    score = 5;
                }else if(13.85<=bmi && bmi<= 15.11){
                    score = 3;
                }else  if(bmi <13.85){
                    score = 1;
                }
            }else{
                if(bmi>16.72){
                    score = 1;
                }else if(16.13<=bmi && bmi<= 16.72){
                    score = 3;
                }else if(15.32<=bmi && bmi<= 16.12){
                    score = 5;
                }else if(13.78<=bmi && bmi<= 15.31){
                    score = 3;
                }else  if(bmi <13.78){
                    score = 1;
                }
            }
        }
        log.info("年龄:"+age+"BMI:"+bmi+"性别:"+sex+"得分:"+score*4);
        return score*4;
    }


    /**
     *    下肢计算
     * @param age 年龄
     * @param legs  跳远
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calLeg(String age,Integer legs,int sex){

        int score = 0;
        if(sex ==1){
            if("3".equals(age)){
                if(legs>76){
                    score = 5;
                }else if(59<=legs && legs<= 76){
                    score = 4;
                }else if(43<=legs && legs<= 58){
                    score = 3;
                }else if(30<=legs && legs<= 42){
                    score = 2;
                }else  if(21<=legs && legs<= 29){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(legs>84){
                    score = 5;
                }else if(70<=legs && legs<= 84){
                    score = 4;
                }else if(53<=legs && legs<= 69){
                    score = 3;
                }else if(35<=legs && legs<= 52){
                    score = 2;
                }else  if(27<=legs && legs<= 34){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(legs>95){
                    score = 5;
                }else if(80<=legs && legs<= 95){
                    score = 4;
                }else if(65<=legs && legs<= 79){
                    score = 3;
                }else if(47<=legs && legs<= 64){
                    score = 2;
                }else  if(35<=legs && legs<= 46){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(legs>102){
                    score = 5;
                }else if(89 <=legs && legs<= 102){
                    score = 4;
                }else if(73<=legs && legs<= 88){
                    score = 3;
                }else if(55<=legs && legs<= 72){
                    score = 2;
                }else  if(40<=legs && legs<= 54){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("5".equals(age)){
                if(legs>110){
                    score = 5;
                }else if(86<=legs && legs<= 110){
                    score = 4;
                }else if(80<=legs && legs<= 95){
                    score = 3;
                }else if(65<=legs && legs<= 79){
                    score = 2;
                }else  if(50<=legs && legs<= 64){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(legs>119){
                    score = 5;
                }else if(103<=legs && legs<= 119){
                    score = 4;
                }else if(90<=legs && legs<= 102){
                    score = 3;
                }else if(70<=legs && legs<= 89){
                    score = 2;
                }else  if(56<=legs && legs<= 69){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(legs>127){
                    score = 5;
                }else if(111<=legs && legs<= 127){
                    score = 4;
                }else if(95<=legs && legs<= 110){
                    score = 3;
                }else if(79<=legs && legs<= 94){
                    score = 2;
                }else  if(61<=legs && legs<= 78){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }else{
            if("3".equals(age)){
                if(legs>71){
                    score = 5;
                }else if(55<=legs && legs<= 71){
                    score = 4;
                }else if(40<=legs && legs<= 54){
                    score = 3;
                }else if(29<=legs && legs<= 39){
                    score = 2;
                }else  if(21<=legs && legs<= 28){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(legs>81){
                    score = 5;
                }else if(65<=legs && legs<= 81){
                    score = 4;
                }else if(50<=legs && legs<= 64){
                    score = 3;
                }else if(34<=legs && legs<= 49){
                    score = 2;
                }else  if(25<=legs && legs<= 33){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(legs>89){
                    score = 5;
                }else if(74<=legs && legs<= 89){
                    score = 4;
                }else if(60<=legs && legs<= 73){
                    score = 3;
                }else if(44<=legs && legs<= 59){
                    score = 2;
                }else  if(32<=legs && legs<= 43){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(legs>96){
                    score = 5;
                }else if(81<=legs && legs<= 96){
                    score = 4;
                }else if(68<=legs && legs<= 80){
                    score = 3;
                }else if(50<=legs && legs<= 67){
                    score = 2;
                }else  if(40<=legs && legs<= 49){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5".equals(age)){
                if(legs>102){
                    score = 5;
                }else if(89<=legs && legs<= 102){
                    score = 4;
                }else if(75<=legs && legs<= 88){
                    score = 3;
                }else if(60<=legs && legs<= 74){
                    score = 2;
                }else  if(50<=legs && legs<= 59){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(legs>109){
                    score = 5;
                }else if(96<=legs && legs<= 109){
                    score = 4;
                }else if(82<=legs && legs<= 95){
                    score = 3;
                }else if(66<=legs && legs<= 81){
                    score = 2;
                }else  if(64<=legs && legs<= 65){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(legs>116){
                    score = 5;
                }else if(101<=legs && legs<= 116){
                    score = 4;
                }else if(87<=legs && legs<= 100){
                    score = 3;
                }else if(71<=legs && legs<= 86){
                    score = 2;
                }else  if(60<=legs && legs<= 70){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"跳远:"+legs+"性别:"+sex+"得分:"+score*2);
        return score*2;
    }

    /**
     *    上肢计算
     * @param age 年龄
     * @param limb  掷远
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calLimb(String age,double limb,int sex){

        double a = limb*10;
        if(a%5!=0){
            throw new ApiException("您输入的网球投掷数据不符合要求");
        }

        int score = 0;
        if(sex ==1){
            if("3".equals(age)){
                if(limb>5.5){
                    score = 5;
                }else if(4.0<=limb && limb<= 5.5){
                    score = 4;
                }else if(3.0<=limb && limb<= 3.5){
                    score = 3;
                }else if(2.0<=limb && limb<= 2.5){
                    score = 2;
                }else  if(limb== 1.5){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(limb>5.5){
                    score = 5;
                }else if(4.5<=limb && limb<= 5.5){
                    score = 4;
                }else if(3.0<=limb && limb<= 4){
                    score = 3;
                }else if(2.0<=limb && limb<= 2.5){
                    score = 2;
                }else  if( limb== 1.5){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(limb>6){
                    score = 5;
                }else if(5.0<=limb && limb<= 6.0){
                    score = 4;
                }else if(4.0<=limb && limb<= 4.5){
                    score = 3;
                }else if(3.0<=limb && limb<= 3.5){
                    score = 2;
                }else  if(2.0<=limb && limb<= 2.5){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(limb>8.0){
                    score = 5;
                }else if(6.5 <=limb && limb<= 8.0){
                    score = 4;
                }else if(4.5<=limb && limb<= 6.0){
                    score = 3;
                }else if(3.0<=limb && limb<= 4.0){
                    score = 2;
                }else  if( limb== 2.5){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("5".equals(age)){
                if(limb>9.0){
                    score = 5;
                }else if(7.5<=limb && limb<= 9.0){
                    score = 4;
                }else if(5.5<=limb && limb<= 7.0){
                    score = 3;
                }else if(4.0<=limb && limb<= 5.0){
                    score = 2;
                }else  if(3.0<=limb && limb<= 3.5){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(limb>10.0){
                    score = 5;
                }else if(8.0<=limb && limb<= 10.0){
                    score = 4;
                }else if(6.0<=limb && limb<= 7.5){
                    score = 3;
                }else if(4.0<=limb && limb<= 5.5){
                    score = 2;
                }else  if(3.0<=limb && limb<= 3.5){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(limb>12.0){
                    score = 5;
                }else if(9.5<=limb && limb<= 12.0){
                    score = 4;
                }else if(7.0<=limb && limb<= 9.0){
                    score = 3;
                }else if(4.5<=limb && limb<= 6.5){
                    score = 2;
                }else  if(3.5<=limb && limb<= 4.0){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }else{
            if("3".equals(age)){
                if(limb>5.0){
                    score = 5;
                }else if(3.5<=limb && limb<= 5.0){
                    score = 4;
                }else if(2.5<=limb && limb<= 3.0){
                    score = 3;
                }else if(1.5<=limb && limb<= 2.0){
                    score = 2;
                }else  if(limb== 1.0){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(limb>5.0){
                    score = 5;
                }else if(4.0<=limb && limb<= 5.0){
                    score = 4;
                }else if(3.0<=limb && limb<= 3.5){
                    score = 3;
                }else if(2.0<=limb && limb<= 2.5){
                    score = 2;
                }else  if( limb== 1.5){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(limb>5.0){
                    score = 5;
                }else if(4.5<=limb && limb<= 5.0){
                    score = 4;
                }else if(3.5<=limb && limb<= 4.0){
                    score = 3;
                }else if(2.5<=limb && limb<= 3.0){
                    score = 2;
                }else if(limb == 2.0){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(limb>5.5){
                    score = 5;
                }else if(4.5<=limb && limb<= 5.5){
                    score = 4;
                }else if(3.5<=limb && limb<= 4.0){
                    score = 3;
                }else if(2.5<=limb && limb<= 3.0){
                    score = 2;
                }else  if( limb== 2.0){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5".equals(age)){
                if(limb>8.5){
                    score = 5;
                }else if(6.0<=limb && limb<= 8.5){
                    score = 4;
                }else if(4.5<=limb && limb<= 5.5){
                    score = 3;
                }else if(3.5<=limb && limb<= 4.0){
                    score = 2;
                }else  if(2.5<=limb && limb<= 3.0){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(limb>8.5){
                    score = 5;
                }else if(6.5<=limb && limb<= 8.5){
                    score = 4;
                }else if(5.0<=limb && limb<= 6.0){
                    score = 3;
                }else if(3.5<=limb && limb<= 4.5){
                    score = 2;
                }else  if(limb== 3){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(limb>8.0){
                    score = 5;
                }else if(6.5<=limb && limb<= 8.0){
                    score = 4;
                }else if(5.0<=limb && limb<= 6.0){
                    score = 3;
                }else if(3.5<=limb && limb<= 4.5){
                    score = 2;
                }else  if( limb== 3.0){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"投掷:"+limb+"性别:"+sex+"得分:"+score*2);
        return score*2;
    }

    /**
     *    协调性计算
     * @param age 年龄
     * @param coordinate  coordinate
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calCoordinate(String age,double coordinate,int sex){

        int score = 0;
        if(sex ==1){
            if("3".equals(age)){
                if(coordinate<6.6){
                    score = 5;
                }else if(6.6<=coordinate && coordinate<= 9.1){
                    score = 4;
                }else if(9.2<=coordinate && coordinate<= 13.0){
                    score = 3;
                }else if(13.1<=coordinate && coordinate<= 19.6){
                    score = 2;
                }else  if(19.7<=coordinate && coordinate<= 25.0){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(coordinate<6.1){
                    score = 5;
                }else if(6.1<=coordinate && coordinate<= 8.2){
                    score = 4;
                }else if(8.3<=coordinate && coordinate<= 11.1){
                    score = 3;
                }else if(11.2<=coordinate && coordinate<= 16.9){
                    score = 2;
                }else  if(17.0<=coordinate && coordinate<= 21.8){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(coordinate<5.6){
                    score = 5;
                }else if(5.6<=coordinate && coordinate<= 7.0){
                    score = 4;
                }else if(7.1<=coordinate && coordinate<= 9.1){
                    score = 3;
                }else if(9.2<=coordinate && coordinate<= 13.1){
                    score = 2;
                }else  if(13.2<=coordinate && coordinate<= 17.0){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(coordinate<5.3){
                    score = 5;
                }else if(5.3 <=coordinate && coordinate<= 6.4){
                    score = 4;
                }else if(6.5<=coordinate && coordinate<= 8.1){
                    score = 3;
                }else if(8.2<=coordinate && coordinate<= 11.2){
                    score = 2;
                }else  if(11.3<=coordinate && coordinate<= 14.5){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("5".equals(age)){
                if(coordinate<5.1){
                    score = 5;
                }else if(5.1<=coordinate && coordinate<= 5.9){
                    score = 4;
                }else if(6.0<=coordinate && coordinate<= 7.2){
                    score = 3;
                }else if(7.3<=coordinate && coordinate<= 9.8){
                    score = 2;
                }else  if(9.9<=coordinate && coordinate<= 12.5){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(coordinate<4.9){
                    score = 5;
                }else if(4.9<=coordinate && coordinate<= 5.6){
                    score = 4;
                }else if(5.7<=coordinate && coordinate<= 6.8){
                    score = 3;
                }else if(6.9<=coordinate && coordinate<= 9.3){
                    score = 2;
                }else  if(9.4<=coordinate && coordinate<= 11.9){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(coordinate<4.4){
                    score = 5;
                }else if(4.4<=coordinate && coordinate<= 5.1){
                    score = 4;
                }else if(5.2<=coordinate && coordinate<= 6.1){
                    score = 3;
                }else if(6.2<=coordinate && coordinate<= 8.2){
                    score = 2;
                }else  if(8.3<=coordinate && coordinate<= 10.4){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }else{
            if("3".equals(age)){
                if(coordinate<7.1){
                    score = 5;
                }else if(7.1<=coordinate && coordinate<= 9.7){
                    score = 4;
                }else if(9.8<=coordinate && coordinate<= 13.4){
                    score = 3;
                }else if(13.5<=coordinate && coordinate<= 20.0){
                    score = 2;
                }else  if(20.1<=coordinate && coordinate<= 25.9){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(coordinate<6.2){
                    score = 5;
                }else if(6.2<=coordinate && coordinate<= 8.4){
                    score = 4;
                }else if(8.5<=coordinate && coordinate<= 11.2){
                    score = 3;
                }else if(11.3<=coordinate && coordinate<= 17.0){
                    score = 2;
                }else  if(17.1<=coordinate && coordinate<= 21.9){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(coordinate<5.9){
                    score = 5;
                }else if(5.9<=coordinate && coordinate<= 7.3){
                    score = 4;
                }else if(7.4<=coordinate && coordinate<= 9.5){
                    score = 3;
                }else if(9.6<=coordinate && coordinate<= 13.4){
                    score = 2;
                }else  if(13.5<=coordinate && coordinate<= 17.2){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(coordinate<5.5){
                    score = 5;
                }else if(5.5<=coordinate && coordinate<= 6.7){
                    score = 4;
                }else if(6.8<=coordinate && coordinate<= 8.5){
                    score = 3;
                }else if(8.6<=coordinate && coordinate<= 11.9){
                    score = 2;
                }else  if(12.0<=coordinate && coordinate<= 14.9){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5".equals(age)){
                if(coordinate<5.2){
                    score = 5;
                }else if(5.2<=coordinate && coordinate<= 6.1){
                    score = 4;
                }else if(6.2<=coordinate && coordinate<= 7.5){
                    score = 3;
                }else if(7.6<=coordinate && coordinate<= 10.0){
                    score = 2;
                }else  if(10.1<=coordinate && coordinate<= 12.7){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(coordinate<4.9){
                    score = 5;
                }else if(4.9<=coordinate && coordinate<= 5.7){
                    score = 4;
                }else if(5.8<=coordinate && coordinate<= 6.9){
                    score = 3;
                }else if(7.0<=coordinate && coordinate<= 9.2){
                    score = 2;
                }else  if(9.3<=coordinate && coordinate<= 11.5){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(coordinate<4.6){
                    score = 5;
                }else if(4.6<=coordinate && coordinate<= 5.2){
                    score = 4;
                }else if(5.3<=coordinate && coordinate<= 6.2){
                    score = 3;
                }else if(6.3<=coordinate && coordinate<= 8.3){
                    score = 2;
                }else  if(8.4<=coordinate && coordinate<= 10.5){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"双脚连续跳:"+coordinate+"性别:"+sex+"得分:"+score*2);
        return score*2;
    }

    /**
     *    平衡性计算
     * @param age 年龄
     * @param coordinate  coordinate
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calBalance(String age,double coordinate,int sex){

        int score = 0;
        if(sex ==1){
            if("3".equals(age)){
                if(coordinate<6.6){
                    score = 5;
                }else if(6.6<=coordinate && coordinate<= 10.5){
                    score = 4;
                }else if(10.6<=coordinate && coordinate<= 16.8){
                    score = 3;
                }else if(16.9<=coordinate && coordinate<= 30.0){
                    score = 2;
                }else  if(30.1<=coordinate && coordinate<= 48.5){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(coordinate<5.9){
                    score = 5;
                }else if(5.9<=coordinate && coordinate<= 9.3){
                    score = 4;
                }else if(9.4<=coordinate && coordinate<= 15.0){
                    score = 3;
                }else if(15.1<=coordinate && coordinate<= 27.0){
                    score = 2;
                }else  if(27.1<=coordinate && coordinate<= 41.1){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(coordinate<4.9){
                    score = 5;
                }else if(4.9<=coordinate && coordinate<= 7.3){
                    score = 4;
                }else if(7.4<=coordinate && coordinate<= 11.5){
                    score = 3;
                }else if(11.6<=coordinate && coordinate<= 21.5){
                    score = 2;
                }else  if(21.6<=coordinate && coordinate<= 33.2){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(coordinate<4.3){
                    score = 5;
                }else if(4.3 <=coordinate && coordinate<= 6.2){
                    score = 4;
                }else if(6.3<=coordinate && coordinate<= 9.6){
                    score = 3;
                }else if(9.7<=coordinate && coordinate<= 17.8){
                    score = 2;
                }else  if(17.9<=coordinate && coordinate<= 28.4){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("5".equals(age)){
                if(coordinate<3.7){
                    score = 5;
                }else if(3.7<=coordinate && coordinate<= 5.2){
                    score = 4;
                }else if(5.3<=coordinate && coordinate<= 7.8){
                    score = 3;
                }else if(7.9<=coordinate && coordinate<= 14.0){
                    score = 2;
                }else  if(14.1<=coordinate && coordinate<= 22.2){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(coordinate<3.3){
                    score = 5;
                }else if(3.3<=coordinate && coordinate<= 4.5){
                    score = 4;
                }else if(4.6<=coordinate && coordinate<= 6.7){
                    score = 3;
                }else if(6.8<=coordinate && coordinate<= 12.0){
                    score = 2;
                }else  if(12.1<=coordinate && coordinate<= 19.2){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(coordinate<2.7){
                    score = 5;
                }else if(2.7<=coordinate && coordinate<= 3.7){
                    score = 4;
                }else if(3.8<=coordinate && coordinate<= 5.3){
                    score = 3;
                }else if(5.4<=coordinate && coordinate<= 9.3){
                    score = 2;
                }else  if(9.4<=coordinate && coordinate<= 16.0){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }else{
            if("3".equals(age)){
                if(coordinate<7.1){
                    score = 5;
                }else if(7.1<=coordinate && coordinate<= 9.7){
                    score = 4;
                }else if(9.8<=coordinate && coordinate<= 13.4){
                    score = 3;
                }else if(13.5<=coordinate && coordinate<= 20.0){
                    score = 2;
                }else  if(20.1<=coordinate && coordinate<= 25.9){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(coordinate<6.9){
                    score = 5;
                }else if(6.9<=coordinate && coordinate<= 10.7){
                    score = 4;
                }else if(10.8<=coordinate && coordinate<= 17.3){
                    score = 3;
                }else if(17.4<=coordinate && coordinate<= 32.4){
                    score = 2;
                }else  if(32.5<=coordinate && coordinate<= 49.8){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(coordinate<5.3){
                    score = 5;
                }else if(5.3<=coordinate && coordinate<= 8.1){
                    score = 4;
                }else if(8.1<=coordinate && coordinate<= 12.2){
                    score = 3;
                }else if(12.3<=coordinate && coordinate<= 22.5){
                    score = 2;
                }else  if(22.6<=coordinate && coordinate<= 32.2){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(coordinate<4.7){
                    score = 5;
                }else if(4.7<=coordinate && coordinate<= 6.9){
                    score = 4;
                }else if(7.0<=coordinate && coordinate<= 10.1){
                    score = 3;
                }else if(10.2<=coordinate && coordinate<= 18.6){
                    score = 2;
                }else  if(18.7<=coordinate && coordinate<= 26.5){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5".equals(age)){
                if(coordinate<4.1){
                    score = 5;
                }else if(4.1<=coordinate && coordinate<= 5.7){
                    score = 4;
                }else if(5.8<=coordinate && coordinate<= 8.2){
                    score = 3;
                }else if(8.3<=coordinate && coordinate<= 14.0){
                    score = 2;
                }else  if(14.1<=coordinate && coordinate<= 23.7){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(coordinate<3.6){
                    score = 5;
                }else if(3.6<=coordinate && coordinate<= 5.0){
                    score = 4;
                }else if(5.1<=coordinate && coordinate<= 7.4){
                    score = 3;
                }else if(7.5<=coordinate && coordinate<= 12.5){
                    score = 2;
                }else  if(12.6<=coordinate && coordinate<= 20.1){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(coordinate<3.0){
                    score = 5;
                }else if(3.0<=coordinate && coordinate<= 4.2){
                    score = 4;
                }else if(4.3<=coordinate && coordinate<= 6.1){
                    score = 3;
                }else if(6.2<=coordinate && coordinate<= 10.7){
                    score = 2;
                }else  if(10.8<=coordinate && coordinate<= 17.0){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"双脚连续跳:"+coordinate+"性别:"+sex+"得分:"+score*2);
        return score*2;
    }

    /**
     *    柔韧性计算
     * @param age 年龄
     * @param coordinate  coordinate
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calFlexibility(String age,double coordinate,int sex){

        int score = 0;
        if(sex ==1){
            if("3".equals(age)){
                if(coordinate>14.9){
                    score = 5;
                }else if(11.7<=coordinate && coordinate<= 14.9){
                    score = 4;
                }else if(8.6<=coordinate && coordinate<= 11.6){
                    score = 3;
                }else if(4.9<=coordinate && coordinate<= 8.5){
                    score = 2;
                }else  if(2.9<=coordinate && coordinate<= 4.8){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(coordinate>14.9){
                    score = 5;
                }else if(11.6<=coordinate && coordinate<= 14.9){
                    score = 4;
                }else if(8.5<=coordinate && coordinate<= 11.5){
                    score = 3;
                }else if(4.7<=coordinate && coordinate<= 8.4){
                    score = 2;
                }else  if(2.7<=coordinate && coordinate<= 4.64){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(coordinate>14.9){
                    score = 5;
                }else if(11.5<=coordinate && coordinate<= 14.9){
                    score = 4;
                }else if(8.5<=coordinate && coordinate<= 11.4){
                    score = 3;
                }else if(4.5<=coordinate && coordinate<= 8.4){
                    score = 2;
                }else  if(2.4<=coordinate && coordinate<= 4.4){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(coordinate>14.4){
                    score = 5;
                }else if(11.0 <=coordinate && coordinate<= 14.4){
                    score = 4;
                }else if(8.0<=coordinate && coordinate<= 10.9){
                    score = 3;
                }else if(4.2<=coordinate && coordinate<= 7.9){
                    score = 2;
                }else  if(1.8<=coordinate && coordinate<= 4.1){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("5".equals(age)){
                if(coordinate>14.4){
                    score = 5;
                }else if(11.0<=coordinate && coordinate<= 14.4){
                    score = 4;
                }else if(7.6<=coordinate && coordinate<= 10.9){
                    score = 3;
                }else if(3.5<=coordinate && coordinate<= 7.5){
                    score = 2;
                }else  if(1.1<=coordinate && coordinate<= 3.4){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(coordinate>14.4){
                    score = 5;
                }else if(11.0<=coordinate && coordinate<= 14.4){
                    score = 4;
                }else if(7.6<=coordinate && coordinate<= 10.9){
                    score = 3;
                }else if(3.3<=coordinate && coordinate<= 7.5){
                    score = 2;
                }else  if(1.0<=coordinate && coordinate<= 3.2){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(coordinate>14.4){
                    score = 5;
                }else if(10.5<=coordinate && coordinate<= 14.4){
                    score = 4;
                }else if(7.1<=coordinate && coordinate<= 10.4){
                    score = 3;
                }else if(3.2<=coordinate && coordinate<= 7.0){
                    score = 2;
                }else  if(1.0<=coordinate && coordinate<= 3.1){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }else{
            if("3".equals(age)){
                if(coordinate>15.9){
                    score = 5;
                }else if(13.0<=coordinate && coordinate<= 15.9){
                    score = 4;
                }else if(10.0<=coordinate && coordinate<= 12.9){
                    score = 3;
                }else if(6.3<=coordinate && coordinate<= 9.9){
                    score = 2;
                }else  if(3.2<=coordinate && coordinate<= 6.29){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(coordinate>15.9){
                    score = 5;
                }else if(13.0<=coordinate && coordinate<= 15.9){
                    score = 4;
                }else if(10.0<=coordinate && coordinate<= 12.9){
                    score = 3;
                }else if(6.3<=coordinate && coordinate<= 9.9){
                    score = 2;
                }else  if(3.5<=coordinate && coordinate<= 6.2){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(coordinate>15.9){
                    score = 5;
                }else if(13.0<=coordinate && coordinate<= 15.9){
                    score = 4;
                }else if(10.0<=coordinate && coordinate<= 12.9){
                    score = 3;
                }else if(6.0<=coordinate && coordinate<= 9.9){
                    score = 2;
                }else  if(3.4<=coordinate && coordinate<= 5.9){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(coordinate>16.0){
                    score = 5;
                }else if(13.0<=coordinate && coordinate<= 16.0){
                    score = 4;
                }else if(10.0<=coordinate && coordinate<= 12.9){
                    score = 3;
                }else if(6.0<=coordinate && coordinate<= 9.9){
                    score = 2;
                }else  if(3.0<=coordinate && coordinate<= 5.9){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5".equals(age)){
                if(coordinate>16.6){
                    score = 5;
                }else if(13.2<=coordinate && coordinate<= 16.6){
                    score = 4;
                }else if(9.7<=coordinate && coordinate<= 13.1){
                    score = 3;
                }else if(5.5<=coordinate && coordinate<= 9.6){
                    score = 2;
                }else  if(3.0<=coordinate && coordinate<= 5.4){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(coordinate>16.7){
                    score = 5;
                }else if(13.0<=coordinate && coordinate<= 16.7){
                    score = 4;
                }else if(9.7<=coordinate && coordinate<= 12.9){
                    score = 3;
                }else if(5.5<=coordinate && coordinate<= 9.6){
                    score = 2;
                }else  if(3.0<=coordinate && coordinate<= 5.4){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(coordinate>16.7){
                    score = 5;
                }else if(13.0<=coordinate && coordinate<= 16.7){
                    score = 4;
                }else if(9.6<=coordinate && coordinate<= 12.9){
                    score = 3;
                }else if(5.4<=coordinate && coordinate<= 9.5){
                    score = 2;
                }else  if(3.0<=coordinate && coordinate<= 5.3){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"柔韧性:"+coordinate+"性别:"+sex+"得分:"+score*2);
        return score*2;
    }

    /**
     *    灵敏性计算
     * @param age 年龄
     * @param coordinate  coordinate
     * @param sex  性别  1男 2 女
     * @return
     */
    public static int calSensitives(String age,double coordinate,int sex){
        int score = 0;
        if(sex ==1){
            if("3".equals(age)){
                if(coordinate<8.0){
                    score = 5;
                }else if(8.0<=coordinate && coordinate<= 9.0){
                    score = 4;
                }else if(9.1<=coordinate && coordinate<= 10.2){
                    score = 3;
                }else if(10.3<=coordinate && coordinate<= 12.8){
                    score = 2;
                }else  if(12.91<=coordinate && coordinate<= 15.8){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(coordinate<7.5){
                    score = 5;
                }else if(7.5<=coordinate && coordinate<= 8.3){
                    score = 4;
                }else if(8.4<=coordinate && coordinate<= 9.4){
                    score = 3;
                }else if(9.5<=coordinate && coordinate<= 11.3){
                    score = 2;
                }else  if(11.4<=coordinate && coordinate<= 14.0){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(coordinate<6.9){
                    score = 5;
                }else if(6.9<=coordinate && coordinate<= 7.6){
                    score = 4;
                }else if(7.7<=coordinate && coordinate<= 8.5){
                    score = 3;
                }else if(8.6<=coordinate && coordinate<= 10.1){
                    score = 2;
                }else  if(10.2<=coordinate && coordinate<= 12.4){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(coordinate<6.7){
                    score = 5;
                }else if(6.7 <=coordinate && coordinate<= 7.2){
                    score = 4;
                }else if(7.3<=coordinate && coordinate<= 8.0){
                    score = 3;
                }else if(8.1<=coordinate && coordinate<= 9.7){
                    score = 2;
                }else  if(9.8<=coordinate && coordinate<= 11.8){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("5".equals(age)){
                if(coordinate<6.4){
                    score = 5;
                }else if(6.4<=coordinate && coordinate<= 6.9){
                    score = 4;
                }else if(7.0<=coordinate && coordinate<= 7.6){
                    score = 3;
                }else if(7.7<=coordinate && coordinate<= 8.9){
                    score = 2;
                }else  if(9.0<=coordinate && coordinate<= 10.3){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(coordinate<6.2){
                    score = 5;
                }else if(6.2<=coordinate && coordinate<= 6.7){
                    score = 4;
                }else if(6.8<=coordinate && coordinate<= 7.3){
                    score = 3;
                }else if(7.4<=coordinate && coordinate<= 8.5){
                    score = 2;
                }else  if(8.6<=coordinate && coordinate<= 10.0){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(coordinate<5.8){
                    score = 5;
                }else if(5.8<=coordinate && coordinate<= 6.2){
                    score = 4;
                }else if(6.3<=coordinate && coordinate<= 6.8){
                    score = 3;
                }else if(6.9<=coordinate && coordinate<= 7.9){
                    score = 2;
                }else  if(8.0<=coordinate && coordinate<= 9.4){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }else{
            if("3".equals(age)){
                if(coordinate<8.2){
                    score = 5;
                }else if(8.2<=coordinate && coordinate<= 9.3){
                    score = 4;
                }else if(9.4<=coordinate && coordinate<= 10.5){
                    score = 3;
                }else if(10.6<=coordinate && coordinate<= 13.4){
                    score = 2;
                }else  if(13.5<=coordinate && coordinate<= 16.8){
                    score = 1;
                }else{
                    score = 0;
                }
            }else if("3.5".equals(age)){
                if(coordinate<7.7){
                    score = 5;
                }else if(7.7<=coordinate && coordinate<= 8.6){
                    score = 4;
                }else if(8.7<=coordinate && coordinate<= 9.7){
                    score = 3;
                }else if(9.8<=coordinate && coordinate<= 12.0){
                    score = 2;
                }else  if(12.1<=coordinate && coordinate<= 14.9){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4".equals(age)){
                if(coordinate<7.2){
                    score = 5;
                }else if(7.2<=coordinate && coordinate<= 8.0){
                    score = 4;
                }else if(8.1<=coordinate && coordinate<= 9.0){
                    score = 3;
                }else if(9.1<=coordinate && coordinate<= 10.8){
                    score = 2;
                }else  if(10.9<=coordinate && coordinate<= 13.2){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("4.5".equals(age)){
                if(coordinate<7.0){
                    score = 5;
                }else if(7.0<=coordinate && coordinate<= 7.6){
                    score = 4;
                }else if(7.7<=coordinate && coordinate<= 8.5){
                    score = 3;
                }else if(8.6<=coordinate && coordinate<= 10.2){
                    score = 2;
                }else  if(10.3<=coordinate && coordinate<= 12.4){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5".equals(age)){
                if(coordinate<6.7){
                    score = 5;
                }else if(6.7<=coordinate && coordinate<= 7.2){
                    score = 4;
                }else if(7.3<=coordinate && coordinate<= 8.0){
                    score = 3;
                }else if(8.1<=coordinate && coordinate<= 9.6){
                    score = 2;
                }else  if(9.7<=coordinate && coordinate<= 11.2){
                    score = 1;
                }else{
                    score = 0;
                }

            }else if("5.5".equals(age)){
                if(coordinate<6.4){
                    score = 5;
                }else if(6.4<=coordinate && coordinate<= 6.9){
                    score = 4;
                }else if(7.0<=coordinate && coordinate<= 7.6){
                    score = 3;
                }else if(7.7<=coordinate && coordinate<= 9.0){
                    score = 2;
                }else  if(9.1<=coordinate && coordinate<= 10.5){
                    score = 1;
                }else{
                    score = 0;
                }
            }else{
                if(coordinate<6.1){
                    score = 5;
                }else if(6.1<=coordinate && coordinate<= 6.5){
                    score = 4;
                }else if(6.6<=coordinate && coordinate<= 7.2){
                    score = 3;
                }else if(7.3<=coordinate && coordinate<= 8.5){
                    score = 2;
                }else  if(8.6<=coordinate && coordinate<= 10.2){
                    score = 1;
                }else{
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"灵敏性:"+coordinate+"性别:"+sex+"得分:"+score*2);
        return score*2;
    }

    /**
     *    拍球计算
     * @param age 年龄
     * @param legs  跳远
     * @return
     */
    public static int calRacket(String age,Integer legs){
        int score = 0;
        if(legs != null) {
            if ("3".equals(age)) {
                if (legs > 25) {
                    score = 5;
                } else if (20 <= legs && legs <= 25) {
                    score = 4;
                } else if (15 <= legs && legs <= 19) {
                    score = 3;
                } else if (10 <= legs && legs <= 14) {
                    score = 2;
                } else if (70 <= 5 && legs <= 9) {
                    score = 1;
                } else {
                    score = 0;
                }
            } else if ("3.5".equals(age)) {
                if (legs > 50) {
                    score = 5;
                } else if (40 <= legs && legs <= 49) {
                    score = 4;
                } else if (30 <= legs && legs <= 39) {
                    score = 3;
                } else if (20 <= legs && legs <= 29) {
                    score = 2;
                } else if (10 <= legs && legs <= 19) {
                    score = 1;
                } else {
                    score = 0;
                }

            } else if ("4".equals(age)) {
                if (legs > 65) {
                    score = 5;
                } else if (55 <= legs && legs <= 64) {
                    score = 4;
                } else if (45 <= legs && legs <= 54) {
                    score = 3;
                } else if (35 <= legs && legs <= 44) {
                    score = 2;
                } else if (25 <= legs && legs <= 34) {
                    score = 1;
                } else {
                    score = 0;
                }

            } else if ("4.5".equals(age)) {
                if (legs > 85) {
                    score = 5;
                } else if (75 <= legs && legs <= 84) {
                    score = 4;
                } else if (65 <= legs && legs <= 74) {
                    score = 3;
                } else if (55 <= legs && legs <= 64) {
                    score = 2;
                } else if (45 <= legs && legs <= 54) {
                    score = 1;
                } else {
                    score = 0;
                }
            } else if ("5".equals(age)) {
                if (legs > 90) {
                    score = 5;
                } else if (80 <= legs && legs <= 89) {
                    score = 4;
                } else if (70 <= legs && legs <= 79) {
                    score = 3;
                } else if (60 <= legs && legs <= 68) {
                    score = 2;
                } else if (50 <= legs && legs <= 59) {
                    score = 1;
                } else {
                    score = 0;
                }

            } else if ("5.5".equals(age)) {
                if (legs > 109) {
                    score = 5;
                } else if (100 <= legs && legs <= 109) {
                    score = 4;
                } else if (90 <= legs && legs <= 99) {
                    score = 3;
                } else if (80 <= legs && legs <= 89) {
                    score = 2;
                } else if (70 <= legs && legs <= 79) {
                    score = 1;
                } else {
                    score = 0;
                }
            } else {
                if (legs > 124) {
                    score = 5;
                } else if (115 <= legs && legs <= 124) {
                    score = 4;
                } else if (105 <= legs && legs <= 114) {
                    score = 3;
                } else if (95 <= legs && legs <= 104) {
                    score = 2;
                } else if (95 <= legs && legs <= 94) {
                    score = 1;
                } else {
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"拍球:"+legs+""+"得分:"+score*8);
        return score*8;
    }

    /**
     *    传球计算
     * @param age 年龄
     * @param legs  跳远
     * @return
     */
    public static int calPass(String age,Integer legs){
        int score = 0;
        if(legs !=null) {
            if ("3".equals(age)) {
                if (legs > 4) {
                    score = 5;
                } else if (legs == 4) {
                    score = 4;
                } else if (legs == 3) {
                    score = 3;
                } else if (legs == 2) {
                    score = 2;
                } else if (legs == 1) {
                    score = 1;
                } else {
                    score = 0;
                }
            } else if ("3.5".equals(age)) {
                if (legs > 5) {
                    score = 5;
                } else if (legs == 5) {
                    score = 4;
                } else if (legs == 4) {
                    score = 3;
                } else if (legs == 3) {
                    score = 2;
                } else if (legs == 2) {
                    score = 1;
                } else {
                    score = 0;
                }

            } else if ("4".equals(age)) {
                if (legs > 4) {
                    score = 5;
                } else if (legs == 4) {
                    score = 4;
                } else if (legs == 3) {
                    score = 3;
                } else if (legs == 2) {
                    score = 2;
                } else if (legs == 1) {
                    score = 1;
                } else {
                    score = 0;
                }

            } else if ("4.5".equals(age)) {
                if (legs > 5) {
                    score = 5;
                } else if (legs == 5) {
                    score = 4;
                } else if (legs == 4) {
                    score = 3;
                } else if (legs == 3) {
                    score = 2;
                } else if (legs == 2) {
                    score = 1;
                } else {
                    score = 0;
                }
            } else if ("5".equals(age)) {
                if (legs > 5) {
                    score = 5;
                } else if (legs == 5) {
                    score = 4;
                } else if (legs == 4) {
                    score = 3;
                } else if (legs == 3) {
                    score = 2;
                } else if (legs == 2) {
                    score = 1;
                } else {
                    score = 0;
                }

            } else if ("5.5".equals(age)) {
                if (legs > 6) {
                    score = 5;
                } else if (legs == 6) {
                    score = 4;
                } else if (legs == 5) {
                    score = 3;
                } else if (legs == 4) {
                    score = 2;
                } else if (legs == 3) {
                    score = 1;
                } else {
                    score = 0;
                }
            } else {
                if (legs > 5) {
                    score = 5;
                } else if (legs == 5) {
                    score = 4;
                } else if (legs == 4) {
                    score = 3;
                } else if (legs == 3) {
                    score = 2;
                } else if (legs == 2) {
                    score = 1;
                } else {
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"拍球:"+legs+""+"得分:"+score*6);
        return score*6;
    }

    /**
     *    投篮计算
     * @param age 年龄
     * @param legs  跳远
     * @return
     */
    public static int calShoot(String age,Integer legs){
        int score = 0;
        if(legs !=null) {
            if ("3".equals(age)) {
                if (legs > 4) {
                    score = 5;
                } else if (legs == 4) {
                    score = 4;
                } else if (legs == 3) {
                    score = 3;
                } else if (legs == 2) {
                    score = 2;
                } else if (legs == 1) {
                    score = 1;
                } else {
                    score = 0;
                }
            } else if ("3.5".equals(age)) {
                if (legs > 6) {
                    score = 5;
                } else if (legs == 6) {
                    score = 4;
                } else if (legs == 5) {
                    score = 3;
                } else if (legs == 4) {
                    score = 2;
                } else if (legs == 3) {
                    score = 1;
                } else {
                    score = 0;
                }

            } else if ("4".equals(age)) {
                if (legs > 4) {
                    score = 5;
                } else if (legs == 4) {
                    score = 4;
                } else if (legs == 3) {
                    score = 3;
                } else if (legs == 2) {
                    score = 2;
                } else if (legs == 1) {
                    score = 1;
                } else {
                    score = 0;
                }

            } else if ("4.5".equals(age)) {
                if (legs > 6) {
                    score = 5;
                } else if (legs == 6) {
                    score = 4;
                } else if (legs == 5) {
                    score = 3;
                } else if (legs == 4) {
                    score = 2;
                } else if (legs == 3) {
                    score = 1;
                } else {
                    score = 0;
                }
            } else if ("5".equals(age)) {
                if (legs > 4) {
                    score = 5;
                } else if (legs == 4) {
                    score = 4;
                } else if (legs == 3) {
                    score = 3;
                } else if (legs == 2) {
                    score = 2;
                } else if (legs == 1) {
                    score = 1;
                } else {
                    score = 0;
                }

            } else if ("5.5".equals(age)) {
                if (legs > 5) {
                    score = 5;
                } else if (legs == 5) {
                    score = 4;
                } else if (legs == 4) {
                    score = 3;
                } else if (legs == 3) {
                    score = 2;
                } else if (legs == 2) {
                    score = 1;
                } else {
                    score = 0;
                }
            } else {
                if (legs > 5) {
                    score = 5;
                } else if (legs == 5) {
                    score = 4;
                } else if (legs == 4) {
                    score = 3;
                } else if (legs == 3) {
                    score = 2;
                } else if (legs == 2) {
                    score = 1;
                } else {
                    score = 0;
                }
            }
        }
        log.info("年龄:"+age+"投篮:"+legs+""+"得分:"+score*6);
        return score*6;
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
