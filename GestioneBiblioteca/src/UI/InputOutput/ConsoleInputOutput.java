package UI.InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputOutput implements I_InputOutput{
    private BufferedReader _bfn;

    public ConsoleInputOutput(){
        this._bfn = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void print(String value) {
        System.out.print(value);
    }

    @Override
    public void println(String value) {
        System.out.println(value);
    }

    @Override
    public String getString() {
        try {
            return this._bfn.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getInt() {
        try {
            return Integer.parseInt(this._bfn.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AttendiInvio()
    {
        this.println("\nPremi invio per continuare...");
        while (true) {
            String input = this.getString();
            if (input.isEmpty()) {
                break;
            }
        }

    }

    @Override
    public void PulisciSchermo()
    {
        if (System.getProperty("os.name").contains("Windows"))
        {
            try
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            catch (IOException | InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
        else
        {
            try
            {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
            catch (IOException | InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}