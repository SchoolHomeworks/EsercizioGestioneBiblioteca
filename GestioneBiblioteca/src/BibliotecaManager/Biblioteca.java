package BibliotecaManager;

import BibliotecaManager.Libro.Libro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Biblioteca implements I_Gestibile{
    private HashMap<String, ArrayList<Libro>> hashMapBiblioteca;

    public Biblioteca(){
        this.hashMapBiblioteca = new HashMap<>();
    }

    @Override
    public void aggiungiLibro(Libro libro){
        this.hashMapBiblioteca.putIfAbsent(libro.getTitolo(), new ArrayList<>());
        this.hashMapBiblioteca.get(libro.getTitolo()).add(libro);
    }

    @Override
    public boolean rimuoviLibro(String isbn) {
        Libro libro = this.ricercaLibro(isbn);
        if(libro != null){
            ArrayList<Libro> libri = this.hashMapBiblioteca.get(libro.getTitolo());
            libri.remove(libro);
            return true;
        }
        return false;
    }

    @Override
    public Libro ricercaLibro(String isbn) {
        for(String key : this.hashMapBiblioteca.keySet()){
            ArrayList<Libro> libri = this.hashMapBiblioteca.get(key);
            for(Libro libro : libri){
                if(libro.getIsbn().equals(isbn)){
                    return libro;
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Libro> elencoLibri() {
        ArrayList<Libro> listaLibri = new ArrayList<>();
        for(ArrayList<Libro> libri : this.hashMapBiblioteca.values()){
            listaLibri.addAll(libri);
        }
        return listaLibri;
    }
}
