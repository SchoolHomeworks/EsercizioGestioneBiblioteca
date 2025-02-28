import BibliotecaManager.Biblioteca;
import BibliotecaManager.I_Gestibile;
import UI.InputOutput.ConsoleInputOutput;
import UI.InputOutput.FileInputOutput;
import UI.InputOutput.I_InputOutput;
import UI.UI_Manager.I_BibliotecaUI;
import UI.UI_Manager.BibliotecaUI;
import UI.ControllerBiblioteca;

public class Main {
    public static void main(String[] args) {
        final String file_input_test_aggiungi_libro = "GestioneBiblioteca/src/TEST/AggiungiLibro/input.txt";
        final String file_output_test_aggiungi_libro = "GestioneBiblioteca/src/TEST/AggiungiLibro/output.txt";

        final String file_input_test_ricerca_libro = "GestioneBiblioteca/src/TEST/RicercaLibro/input.txt";
        final String file_output_test_ricerca_libro = "GestioneBiblioteca/src/TEST/RicercaLibro/output.txt";

        final String file_input_test_rimuovi_libro = "GestioneBiblioteca/src/TEST/RimuoviLibro/input.txt";
        final String file_output_test_rimuovi_libro = "GestioneBiblioteca/src/TEST/RimuoviLibro/output.txt";

        final String file_input_test_totale_libro = "GestioneBiblioteca/src/TEST/TestTotale/input.txt";
        final String file_output_test_totale_libro = "GestioneBiblioteca/src/TEST/TestTotale/output.txt";

        //I_InputOutput i_io = new FileInputOutput(file_input_test_aggiungi_libro, file_output_test_aggiungi_libro);
        //I_InputOutput i_io = new FileInputOutput(file_input_test_ricerca_libro, file_output_test_ricerca_libro);
        //I_InputOutput i_io = new FileInputOutput(file_input_test_rimuovi_libro, file_output_test_rimuovi_libro);
        //I_InputOutput i_io = new FileInputOutput(file_input_test_totale_libro, file_output_test_totale_libro);

        I_InputOutput i_io = new ConsoleInputOutput();

        I_Gestibile gestibile = new Biblioteca();
        I_BibliotecaUI bibliotecaUI = BibliotecaUI.getInstance(i_io);
        ControllerBiblioteca controllerBiblioteca = ControllerBiblioteca.getInstance(gestibile, bibliotecaUI);
        controllerBiblioteca.Run();
    }
}