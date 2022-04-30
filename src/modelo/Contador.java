package modelo;

public class Contador {
    private static Contador instancia;
    private ContadorListener listener;
    private int valor;

    public Contador(){
        this.valor = 0;

    }
    public int getValor(){
        return valor;
    }

    public void setValor(int novoValor){
        this.valor = novoValor;

    }

    public void incrementa(){
        setValor(getValor()+1);
        listener.oValorMudou(getValor());
    }

    public void decremento(){
        setValor(getValor()-1);
        listener.oValorMudou(getValor());
    }

    public static Contador getInstance(){
        if(instancia==null){
            instancia = new Contador();
        }return instancia;
    }

    public void setListener(ContadorListener x){
        this.listener=x;


    }


}

