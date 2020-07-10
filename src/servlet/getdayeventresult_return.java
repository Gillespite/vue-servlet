package servlet;

public class getdayeventresult_return {
    private int ok;
    private double msg;

    public getdayeventresult_return(int ok, double msg) {
        this.ok = ok;
        this.msg = msg;
    }

    public int getOk() {
        return ok;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public double getMsg() {
        return msg;
    }

    public void setMsg(double msg) {
        this.msg = msg;
    }
}
