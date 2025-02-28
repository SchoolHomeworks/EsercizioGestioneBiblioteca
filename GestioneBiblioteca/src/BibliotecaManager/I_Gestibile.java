package BibliotecaManager;

import BibliotecaManager.Libro.Libro;

import java.util.ArrayList;

public interface I_Gestibile {
    public void aggiungiLibro(Libro libro);
    public boolean rimuoviLibro(String titolo);
    public Libro ricercaLibro(String titolo);
    public ArrayList<Libro> elencoLibri();
}
