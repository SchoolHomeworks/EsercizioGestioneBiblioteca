package UI;

import BibliotecaManager.Biblioteca;
import BibliotecaManager.Libro.Libro;
import BibliotecaManager.Libro.Manuale;
import BibliotecaManager.Libro.Romanzo;
import UI.InputOutput.I_InputOutput;
import ObjectManager.ObjectManager;

import java.util.ArrayList;

public class UI {
    public static UI _instance = null;
    private static I_InputOutput _io;

    private final ObjectManager _objectManager;

    private UI() {
        this._objectManager = new ObjectManager(_io);
    }

    public static UI getInstance(I_InputOutput io) {
        if(UI._instance == null)
        {
            UI._io = io;
            UI._instance = new UI();
        }

        return UI._instance;
    }

    private int SceltaMenuTipoLibro(){
        int scelta = 0;
        do{
            _io.PulisciSchermo();
            _io.println("Inserisci la tipologia di libro da aggiungere: ");
            _io.println("1. Romanzo");
            _io.println("2. Manuale");
            _io.print("--> ");
            scelta = _io.getInt();
        }while(scelta < 0 || scelta > 2);
        return scelta;
    }

    private void AggiungiLibro(Biblioteca biblioteca){
        _io.PulisciSchermo();
        int scelta = this.SceltaMenuTipoLibro();
        Libro libro;
        if(scelta == 1){
            libro = new Romanzo();
            libro.setAttribute("genere", "romanzo");
        }
        else{
            libro = new Manuale();
            libro.setAttribute("genere", "manuale");
        }
        this._objectManager.InputAttributes(libro);
        biblioteca.aggiungiLibro(libro);
        _io.AttendiInvio();
    }

    private void CercaLibro(Biblioteca biblioteca){
        _io.PulisciSchermo();
        _io.println("Inserisci il titolo del libro da cercare: ");
        String titolo = _io.getString();
        Libro libro = biblioteca.ricercaLibro(titolo);
        if(libro != null){
            _io.println("Il libro è presente nella biblioteca!");
            _io.println(libro.toString());
        }
        else{
            _io.println("Il libro NON è presente nella biblioteca!");
        }
        _io.AttendiInvio();
    }

    private void RimuoviLibro(Biblioteca biblioteca){
        _io.PulisciSchermo();
        _io.println("Inserisci il titolo del libro da eliminare dalla biblioteca: ");
        String titolo = _io.getString();
        if(biblioteca.rimuoviLibro(titolo)){
            _io.println("Il libro è stato rimosso con successo dalla biblioteca!");
        }
        else {
            _io.println("Impossibile eliminare il libro!");
        }
        _io.AttendiInvio();
    }

    private void VisualizzaElencoLibri(Biblioteca biblioteca){
        _io.PulisciSchermo();
        _io.println("Elenco dei libri presenti nella biblioteca: ");
        ArrayList<Libro> elencoLibri = biblioteca.elencoLibri();
        for(Libro libro : elencoLibri){
            _io.println(libro.toString());
        }
        _io.AttendiInvio();
    }

    private int SceltaMenu(){
        int scelta = 0;
        do
        {
            _io.PulisciSchermo();
            _io.println("1. Aggiungi libro");
            _io.println("2. Cerca libro");
            _io.println("3. Visualizza elenco libri presenti");
            _io.println("4. Rimuovi libro");
            _io.println("0. Esci");
            _io.print("--> ");
            scelta = _io.getInt();
        }while(scelta < 0 || scelta > 4);
        return scelta;
    }

    public void Run(){
        _io.PulisciSchermo();
        Biblioteca biblioteca = new Biblioteca();
        int scelta = 0;
        do{
            scelta = this.SceltaMenu();
            switch (scelta){
                case 1:
                    AggiungiLibro(biblioteca);
                    break;
                case 2:
                    CercaLibro(biblioteca);
                    break;
                case 3:
                    VisualizzaElencoLibri(biblioteca);
                    break;
                case 4:
                    RimuoviLibro(biblioteca);
                    break;
            }
        }while(scelta != 0);
    }
}
