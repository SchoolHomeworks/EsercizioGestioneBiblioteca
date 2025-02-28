package UI.UI_Manager;

import BibliotecaManager.Libro.Libro;
import UI.InputOutput.I_InputOutput;
import ObjectManager.ObjectManager;

import java.util.ArrayList;

public class BibliotecaUI implements I_BibliotecaUI{
    public static BibliotecaUI _instance = null;
    private static I_InputOutput _io;

    private final ObjectManager _objectManager;

    private BibliotecaUI() {
        this._objectManager = new ObjectManager(_io);
    }

    public static BibliotecaUI getInstance(I_InputOutput io) {
        if(BibliotecaUI._instance == null)
        {
            BibliotecaUI._io = io;
            BibliotecaUI._instance = new BibliotecaUI();
        }

        return BibliotecaUI._instance;
    }

    @Override
    public int sceltaOperazione_UI() {
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

    @Override
    public int sceltaLibroDaAggiungere_UI() {
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

    @Override
    public void aggiungiLibro_UI(Libro libro) {
        _io.PulisciSchermo();
        this._objectManager.InputAttributes(libro);
    }

    @Override
    public String cercaLibro_UI() {
        _io.PulisciSchermo();
        _io.println("Inserisci l' ISBN del libro da cercare: ");
        String isbn = _io.getString();
        return isbn;
    }

    @Override
    public String rimuoviLibro_UI() {
        _io.PulisciSchermo();
        _io.println("Inserisci l' ISBN del libro da eliminare dalla biblioteca: ");
        String isbn = _io.getString();
        return isbn;
    }

    @Override
    public void mostraElencoLibri_UI(ArrayList<Libro> elencoLibri) {
        _io.PulisciSchermo();
        _io.println("Elenco dei libri presenti nella biblioteca: ");
        for(Libro libro : elencoLibri){
            _io.println(libro.toString());
        }
        _io.AttendiInvio();
    }

    @Override
    public void aggiuntoConSuccesso_UI() {
        _io.println("Libro aggiunto con successo!");
        _io.AttendiInvio();
    }

    @Override
    public void libroTrovato_UI(Libro libro) {
        _io.println("Il libro è presente nella biblioteca!");
        _io.println(libro.toString());
        _io.AttendiInvio();
    }

    @Override
    public void libroNonTrovato_UI() {
        _io.println("Il libro NON è presente nella biblioteca!");
        _io.AttendiInvio();
    }

    @Override
    public void rimossoConSuccesso_UI() {
        _io.println("Il libro è stato rimosso con successo dalla biblioteca!");
        _io.AttendiInvio();
    }

    @Override
    public void impossibileRimuovere_UI() {
        _io.println("Impossibile eliminare il libro!");
        _io.AttendiInvio();
    }
}
