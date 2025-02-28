package BibliotecaManager;

import BibliotecaManager.Libro.Libro;

import java.util.ArrayList;
import java.util.HashMap;

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
    public boolean rimuoviLibro(String titolo) {
        if(this.hashMapBiblioteca.containsKey(titolo)){
            if(this.hashMapBiblioteca.get(titolo).isEmpty()){
                this.hashMapBiblioteca.remove(titolo);
            }
            else{
                this.hashMapBiblioteca.get(titolo).removeFirst();
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Libro ricercaLibro(String titolo) {
        ArrayList<Libro> libri = this.hashMapBiblioteca.get(titolo);
        if(libri != null){
            return libri.getFirst();
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
