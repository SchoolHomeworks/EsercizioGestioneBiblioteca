package ObjectManager;

import UI.InputOutput.I_InputOutput;

import java.util.ArrayList;

public class ObjectManager {
    private I_InputOutput _io;

    private ArrayList<String> ignoredAttributes;;

    public ObjectManager(I_InputOutput io){
        _io = io;
        this.ignoredAttributes = new ArrayList<>();
        this.ignoredAttributes.add("genere");
    }

    private String defaultInput(String name){
        this._io.println("Inserisci " + name + ": ");
        return this._io.getString();
    }

    private String inputLibro(String name){
        if(name.equals("narrativa")){
            String attribute = null;
            do{
                this._io.println("Il libro è di narrativa?");
                attribute = this._io.getString();
            }while(!attribute.equalsIgnoreCase("si") && !attribute.equalsIgnoreCase("no"));
            return attribute;
        }
        else if(name.equals("difficolta")){
            int attribute = 0;
            do{
                this._io.println("Inserisci difficoltà: ");
                attribute = this._io.getInt();
            }while(attribute < 1 || attribute > 5);
            return Integer.toString(attribute);
        }
        return null;
    }

    private String input(String name){
        String input;
        input = inputLibro(name);
        if(input != null){
            return input;
        }

        return defaultInput(name);
    }

    public void InputAttributes(I_ManagedObject obj){
        for (String name : obj.getAttributeNames()){
            if(this.ignoredAttributes.contains(name)){
                continue;
            }
            String attribute = input(name);
            obj.setAttribute(name, attribute);
        }
    }
}