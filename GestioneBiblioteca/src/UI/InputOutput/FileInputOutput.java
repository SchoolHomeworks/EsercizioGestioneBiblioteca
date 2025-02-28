package UI.InputOutput;

import java.io.*;

public class FileInputOutput implements I_InputOutput{
    private BufferedReader _reader;
    private BufferedWriter _writer;

    public FileInputOutput(String File_Input, String File_Output) {
        try {
            FileReader f_input = new FileReader(File_Input);
            FileWriter f_output = new FileWriter(File_Output);

            this._reader = new BufferedReader(f_input);
            this._writer = new BufferedWriter(f_output);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void print(String value) {
        try {
            this._writer.write(value);
            this._writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void println(String value) {
        try {
            this._writer.write(value);
            this._writer.newLine();
            this._writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getString() {
        try {
            String line = this._reader.readLine();
            if(line != null)
            {
                return line;
            }
            else
            {
                return "";
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getInt() {
        try {
            return Integer.parseInt(this._reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AttendiInvio(){
        this.println("\nPremi invio per continuare...");
    }

    @Override
    public void PulisciSchermo(){
        this.println("\n_____ SCHERMO PULITO _____");
    }
}