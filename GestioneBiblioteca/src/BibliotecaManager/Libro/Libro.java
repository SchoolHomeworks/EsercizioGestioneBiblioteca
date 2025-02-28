package BibliotecaManager.Libro;

import ObjectManager.I_ManagedObject;

public class Libro implements I_ManagedObject {
    private String _titolo;
    private String _autore;
    private int _anno_di_produzione;
    private String _genere;
    private String _isbn;
    private int _scaffale;

    @Override
    public String[] getAttributeNames() {
        String[] nomi = new String[6];
        nomi[0] = "titolo";
        nomi[1] = "autore";
        nomi[2] = "anno_di_produzione";
        nomi[3] = "genere";
        nomi[4] = "isbn";
        nomi[5] = "scaffale";
        return nomi;
    }

    @Override
    public void setAttribute(String name, Object value){
        switch (name)
        {
            case "titolo":
                this._titolo = value.toString();
                break;

            case "autore":
                this._autore = value.toString();
                break;

            case "anno_di_produzione":
                this._anno_di_produzione = Integer.parseInt(value.toString());
                break;

            case "genere":
                this._genere = value.toString();
                break;

            case "isbn":
                this._isbn = value.toString();
                break;

            case "scaffale":
                this._scaffale = Integer.parseInt(value.toString());
                break;

            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "[titolo: " + this._titolo + "] [autore: " + this._autore + "] [anno_di_produzione: " + this._anno_di_produzione + "] [genere: " + this._genere + "] [isbn: " + this._isbn + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    public String getTitolo(){
        return this._titolo;
    }

    public String getIsbn(){
        return this._isbn;
    }
}
