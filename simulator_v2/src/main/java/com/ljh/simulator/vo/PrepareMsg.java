package com.ljh.simulator.vo;

public class PrepareMsg extends Message{

    public int v;

    public int n;

    public Message m;

    public int i;

    //消息结构
    //<PREPARE, v, n, m, i>:v表示视图编号;n表示序列号;m表示request消息;i表示节点id
    public PrepareMsg(int v, int n, Message m, int i, int sndId, int rcvId, long rcvtime) {
        super(sndId, rcvId, rcvtime);
        this.type = PREPARE;
        this.len = PREMSGLEN;
        this.v = v;
        this.n = n;
        this.m = m;
        this.i = i;
    }

    public Message copy(int rcvId, long rcvtime) {
        //m是浅复制，不过没有关系，不会修改它的值
        return new PrepareMsg(v, n, m, i, sndId, rcvId, rcvtime);
    }

    public boolean equals(Object obj) {
        if (obj instanceof PrepareMsg) {
            PrepareMsg msg = (PrepareMsg) obj;
            return (v == msg.v && n == msg.n && i == msg.i && ((m == null && msg.m == null) || (m != null && m.equals(msg.m))));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        String str = "" + v + n + i;
        return str.hashCode();
    }

    public String toString() {
        return super.toString() + "视图编号:"+v+";序列号:"+n;
    }

    public String mString() {
        if(m == null) {
            return "";
        }
        return m.toString();
    }

}
