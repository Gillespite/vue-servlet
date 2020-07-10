package servlet;

public class getall_return {
    private int ok;
    private String msg;

    public getall_return(int ok, String msg) {
        this.ok = ok;
        this.msg = msg;
    }

    public int getOk() {
        return ok;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
