package patron_generico;

public class generica <T>{

    private T atributo1, atributo2, atributo3;

    public generica()
    {
        this.atributo1 = null;
        this.atributo2 = null;
        this.atributo3 = null;
    }

    public T getAtributo1() 
    {
        return atributo1;
    }

    public void setAtributo1(T atributo1) 
    {
        this.atributo1 = atributo1;
    }

    public T getAtributo2() 
    {
        return atributo2;
    }

    public void setAtributo2(T atributo2) 
    {
        this.atributo2 = atributo2;
    }

    public T getAtributo3() 
    {
        return atributo3;
    }

    public void setAtributo3(T atributo3) 
    {
        this.atributo3 = atributo3;
    }

}