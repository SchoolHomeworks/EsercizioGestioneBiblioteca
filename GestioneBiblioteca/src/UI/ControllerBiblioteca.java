package UI;

import BibliotecaManager.I_Gestibile;
import BibliotecaManager.Libro.Libro;
import BibliotecaManager.Libro.Manuale;
import BibliotecaManager.Libro.Romanzo;
import UI.UI_Manager.I_BibliotecaUI;

import java.util.ArrayList;

public class ControllerBiblioteca {
    public static ControllerBiblioteca _instance = null;
    private static I_Gestibile i_logic;
    private static I_BibliotecaUI i_ui;

    private ControllerBiblioteca() {}

    public static ControllerBiblioteca getInstance(I_Gestibile i_gestibile, I_BibliotecaUI i_bibliotecaUI) {
        if(ControllerBiblioteca._instance == null)
        {
            ControllerBiblioteca._instance = new ControllerBiblioteca();
            ControllerBiblioteca.i_logic = i_gestibile;
            ControllerBiblioteca.i_ui = i_bibliotecaUI;
        }

        return ControllerBiblioteca._instance;
    }

    private void aggiungiLibro(){
        int scelta = i_ui.sceltaLibroDaAggiungere_UI();
        Libro libro;
        if(scelta == 1){
            libro = new Romanzo();
            libro.setAttribute("genere", "romanzo");
        }
        else{
            libro = new Manuale();
            libro.setAttribute("genere", "manuale");
        }
        i_ui.aggiungiLibro_UI(libro);
        i_logic.aggiungiLibro(libro);
        i_ui.aggiuntoConSuccesso_UI();
    }

    private void cercaLibro(){
        String isbn = i_ui.cercaLibro_UI();
        Libro libro = i_logic.ricercaLibro(isbn);
        if(libro != null){
            i_ui.libroTrovato_UI(libro);
        }
        else{
            i_ui.libroNonTrovato_UI();
        }
    }

    private void rimuoviLibro(){
        String isbn = i_ui.rimuoviLibro_UI();
        Boolean rimosso = i_logic.rimuoviLibro(isbn);
        if(rimosso){
            i_ui.rimossoConSuccesso_UI();
        }
        else{
            i_ui.impossibileRimuovere_UI();
        }
    }

    private void mostraLibri(){
        ArrayList<Libro> elencoLibri = i_logic.elencoLibri();
        i_ui.mostraElencoLibri_UI(elencoLibri);
    }

    public void Run(){
        int scelta = 0;
        do{
            scelta = i_ui.sceltaOperazione_UI();
            switch (scelta){
                case 1:
                    aggiungiLibro();
                    break;
                case 2:
                    cercaLibro();
                    break;
                case 3:
                    mostraLibri();
                    break;
                case 4:
                    rimuoviLibro();
                    break;
            }
        }while(scelta != 0);
    }
}
