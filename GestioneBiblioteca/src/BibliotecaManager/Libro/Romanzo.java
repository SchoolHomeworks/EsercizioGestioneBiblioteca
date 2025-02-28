package BibliotecaManager.Libro;

import ObjectManager.I_ManagedObject;

public class Romanzo extends Libro implements I_ManagedObject {
    private String _titolo;
    private String _autore;
    private int _anno_di_produzione;
    private String _genere;
    private Boolean _narrativa;

    @Override
    public String[] getAttributeNames(){
        String[] superNomi = super.getAttributeNames();
        String[] nomi = new String[superNomi.length + 1];
        System.arraycopy(superNomi, 0, nomi, 0, superNomi.length);
        nomi[superNomi.length] = "narrativa";
        return nomi;
    }

    @Override
    public void setAttribute(String name, Object value){
        try{
            super.setAttribute(name, value);
        } catch (AssertionError e) {}

        if(name.equals("narrativa")){
            this._narrativa = value.toString().equalsIgnoreCase("si");
        }
        else if(!name.equals("titolo") && !name.equals("autore") && !name.equals("anno_di_produzione") && !name.equals("genere") && !name.equals("scaffale")){
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        String narrativa;
        if(this._narrativa){
            narrativa = "si";
        }
        else{
            narrativa = "no";
        }
        return super.toString() + " [narrativa: " + narrativa + "]";
    }
}
