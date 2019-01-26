package beans;

public class Calcul {
    private int n1;
    private int n2;
    private int op;
    private int value;

    public int getN1() {
        return n1;
    }
    public void setN1(int n1) {
        this.n1 = n1;
    }
    public int getN2() {
        return n2;
    }
    public void setN2(int n2) {
        this.n2 = n2;
    }
    public int getOp() {
        return op;
    }
    public void setOp(int op) {
        this.op = op;
    }
    public int getValue() {
        return value;
    }

    public void setValue() {
        switch (op){
            case 0:
                this.value = n1 + n2;
                break;
            case 1:
                this.value = n1 - n2;
                break;
            case 2:
                this.value = n1 * n2;
                break;
            case 3:
                if(n2 != 0) {
                    this.value = n1 / n2;
                    break;
                }
            default:
                this.value = 0;
        }
    }

    public String getOper(){
        switch (op){
            case 0:
                return " + ";
            case 1:
                return " - ";
            case 2:
                return " x ";
            case 3:
                return " / ";
            default:
                return "";
        }
    }

    public Calcul(int n1, int n2, int op) {
        this.n1 = n1;
        this.n2 = n2;
        this.op = op;
        this.setValue();
    }
    public Calcul(){
        this.n1=0;
        this.n2=0;
        this.op = 0;
        this.setValue();
    }

    @Override
    public String toString() {
        //on gere la division par 0
        if(this.n2 == 0 && op == 3){
            return "DIVISION PAR 0 IMPOSSIBLE";
        }
        String n1s = "" + this.n1;
        String n2s = "" + this.n2;
        String vals = "" + this.value;
        if(this.n1 < 0){
            n1s = "(" + n1s + ")";
        }
        if(this.n2 < 0){
            n2s = "(" + n2s + ")";
        }
        if(this.value < 0){
            vals = "(" + vals + ")";
        }
        return "<strong> Resultat de l'operation : </strong>" + n1s + this.getOper() + n2s + " = " + vals;
    }

    public boolean equals(Calcul c2) {
        return this.value == c2.getValue();
    }
}
