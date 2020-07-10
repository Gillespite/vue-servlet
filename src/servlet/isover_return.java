package servlet;

public class isover_return {
    private int ok;
    private int msg;

    public isover_return(int ok, int msg) {
        this.ok = ok;
        this.msg = msg;
    }

    public int getOk() {
        return ok;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }
}
