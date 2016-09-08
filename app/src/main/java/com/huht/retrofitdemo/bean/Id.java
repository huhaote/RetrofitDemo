package com.huht.retrofitdemo.bean;

/**
 * Created by huht on 2016/9/8.
 */
public class Id {


    /**
     * code : 10001
     * desc : success
     * data : {"id":"1"}
     */

    private int code;
    private String desc;
    /**
     * id : 1
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
