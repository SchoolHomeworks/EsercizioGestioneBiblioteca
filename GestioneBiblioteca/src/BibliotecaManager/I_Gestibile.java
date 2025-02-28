package BibliotecaManager;

import BibliotecaManager.Libro.Libro;

import java.util.ArrayList;

public interface I_Gestibile {
    public void aggiungiLibro(Libro libro);
    public boolean rimuoviLibro(String isbn);
    public Libro ricercaLibro(String isbn);
    public ArrayList<Libro> elencoLibri();
}
