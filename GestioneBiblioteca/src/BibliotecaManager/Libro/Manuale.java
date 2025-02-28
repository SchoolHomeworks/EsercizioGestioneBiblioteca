package BibliotecaManager.Libro;

import ObjectManager.I_ManagedObject;

public class Manuale extends Libro implements I_ManagedObject {
    private String _titolo;
    private String _autore;
    private int _anno_di_produzione;
    private String _genere;
    private int _difficolta;

    @Override
    public String[] getAttributeNames(){
        String[] superNomi = super.getAttributeNames();
        String[] nomi = new String[superNomi.length + 1];
        System.arraycopy(superNomi, 0, nomi, 0, superNomi.length);
        nomi[superNomi.length] = "difficolta";
        return nomi;
    }

    @Override
    public void setAttribute(String name, Object value){
        try{
            super.setAttribute(name, value);
        } catch (AssertionError e) {}

        if(name.equals("difficolta")){
            this._difficolta = Integer.parseInt(value.toString());
        }
        else if(!name.equals("titolo") && !name.equals("autore") && !name.equals("anno_di_produzione") && !name.equals("genere") && !name.equals("scaffale") && !name.equals("isbn")){
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [difficolta: " + this._difficolta + "]";
    }
}
