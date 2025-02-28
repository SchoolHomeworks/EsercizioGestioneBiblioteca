package UI.UI_Manager;

import BibliotecaManager.Libro.Libro;

import java.util.ArrayList;

public interface I_BibliotecaUI {
    int sceltaOperazione_UI();
    int sceltaLibroDaAggiungere_UI();

    void aggiungiLibro_UI(Libro libro);
    String cercaLibro_UI();
    String rimuoviLibro_UI();
    void mostraElencoLibri_UI(ArrayList<Libro> elencoLibri);

    void aggiuntoConSuccesso_UI();

    void libroTrovato_UI(Libro libro);
    void libroNonTrovato_UI();

    void rimossoConSuccesso_UI();
    void impossibileRimuovere_UI();
}
