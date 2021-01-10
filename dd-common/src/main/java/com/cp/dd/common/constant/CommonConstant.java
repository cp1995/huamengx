package com.cp.dd.common.constant;

public class CommonConstant {

    public static final int LIMIT_SECONDS_AFTER_LOGIN_FAIL = 60 * 60;


    public interface State {
        int DELETE = -1; //删除
        int ENABLE =1;  //正常
    }

    public interface Role {
        int SUPER = 1; //管理员
        int ENTRY =2;  //录入员
        int AREA =3;  //园区管理员
        int zg=6;//体测主管
    }


}
